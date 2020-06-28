package com.brw.service.impl;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

/**
 * @author sidpatil
 * 2020
 */

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.brw.common.constants.Constants;
import com.brw.dao.BusinessDetailsDAO;
import com.brw.dao.ImageDAO;
import com.brw.dto.BusinessDetailsDTO;
import com.brw.dto.BusinessInfoDTO;
import com.brw.dto.GBusinessInfoDTO;
import com.brw.dto.ImageDTO;
import com.brw.dto.ImagesListDTO;
import com.brw.entities.BusinessDetails;
import com.brw.entities.Image;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.maps.GeoApiContext;
import com.google.maps.PlacesApi;
import com.google.maps.model.Photo;
import com.google.maps.model.PlaceDetails;
import com.google.maps.model.PlacesSearchResponse;
import com.google.maps.model.PlacesSearchResult;

@Service
public class AsyncProcessingServiceImpl implements com.brw.service.AsyncProcessingService {
    
	private static final Logger logger = LoggerFactory.getLogger(AsyncProcessingServiceImpl.class);
	
	@Autowired
	private BusinessDetailsDAO businessDetailsDAO;
	
	@Autowired
	private ImageDAO imageDAO;
	
	/*
	 * asyncStoreLatLngToDB calls Google Places API to get the lat/long, firstImage and placeId
	 * The placeId will then be used by asyncStoreImagesToDB method 
	 */
	@Async("threadPoolTaskExecutor")
	//public CompletableFuture<List<GBusinessInfoDTO>> asyncStoreLatLngToDB(List <BusinessInfoDTO> bizInfoDTOList) throws InterruptedException {
	public CompletableFuture<Integer> asyncStoreLatLngToDB(List <BusinessInfoDTO> bizInfoDTOList) throws InterruptedException {
		logger.info("**** Inside AsyncProcessingServiceImpl.asyncStoreLatLngToDB() bizInfoDTOList.size(): "+bizInfoDTOList.size());
		long start = System.currentTimeMillis();
		int updateCount = 0;
		
		List<GBusinessInfoDTO> returnGBusinessInfoDTOList = new ArrayList();
		Integer x = 0;
		
		if (bizInfoDTOList.size() > 1) {
			
			
			for (BusinessInfoDTO businessInfoDTO: bizInfoDTOList) {
				logger.info("**** businessInfoDTO.getGoogleBizSearchString(): "+businessInfoDTO.getGoogleBizSearchString());
				if (null != businessInfoDTO.getGoogleBizSearchString()) {
				
					GBusinessInfoDTO gBusinessInfoDTO = new GBusinessInfoDTO();
					GBusinessInfoDTO returnGBusinessInfoDTO = new GBusinessInfoDTO();
		
					try {
						gBusinessInfoDTO = getFormattedAddressAndLatLong(businessInfoDTO.getGoogleBizSearchString());
						
					} catch (Exception e) {
						e.printStackTrace();
					}
					
					BusinessDetailsDTO businessDetailsDTO = new BusinessDetailsDTO();
					businessDetailsDTO.setInvokerId(1001);
					businessDetailsDTO.setBusinessId(businessInfoDTO.getBusinessId());
					businessDetailsDTO.setLatitude(gBusinessInfoDTO.getgLatitude());
					businessDetailsDTO.setLongitude(gBusinessInfoDTO.getgLongitude());
					businessDetailsDTO.setImageFirst(gBusinessInfoDTO.getgSinglePhotoUrl());
					
					//populate info in BizLatLongDTO
					logger.info("**** businessInfoDTO.getBusinessId(): "+businessInfoDTO.getBusinessId());
					returnGBusinessInfoDTO.setBizId(businessInfoDTO.getBusinessId());
					logger.info("**** gBusinessInfoDTO.getgPlaceId(): "+gBusinessInfoDTO.getgPlaceId());
					returnGBusinessInfoDTO.setgPlaceId(gBusinessInfoDTO.getgPlaceId());
					//returnGBusinessInfoDTO.setgSinglePhotoUrl(gBusinessInfoDTO.getgSinglePhotoUrl());
					//returnGBusinessInfoDTO.setgLatitude(gBusinessInfoDTO.getgLatitude());
					//returnGBusinessInfoDTO.setgLongitude(gBusinessInfoDTO.getgLongitude());
					//
					
					logger.info("**** businessInfoDTO.isUpdateAfterGoogle(): "+businessInfoDTO.isUpdateAfterGoogle());
					logger.info("**** gBusinessInfoDTO.isUpdateAfterGoogle(): "+gBusinessInfoDTO.isUpdateAfterGoogle());			
					if (businessInfoDTO.isUpdateAfterGoogle() && gBusinessInfoDTO.isUpdateAfterGoogle()) {
						updateCount++;
						logger.info("**** CURRENT updateCount: "+updateCount);
						logger.info("**** calling updateBusinessDetails");
						updateBusinessDetails(businessDetailsDTO);
						logger.info("**** updateBusinessDetails for LAT/LONG is COMPLETE");
					} else {
						logger.info("**** CALL TO updateBusinessDetails is SKIPPED");
					}
					returnGBusinessInfoDTOList.add(returnGBusinessInfoDTO);
				}
			}
			//Call this method to get the Photo URLs for biz from google and Add them to image table
			logger.info("**** calling asyncStoreImageUrlsToDB");
			asyncStoreImageUrlsToDB(returnGBusinessInfoDTOList);
		}
		logger.info("**** Total updateCount: "+updateCount);
		logger.info("Elapsed time in asyncStoreLatLngToDB: " + (System.currentTimeMillis() - start));
		//return CompletableFuture.completedFuture(returnGBusinessInfoDTOList);
		return CompletableFuture.completedFuture(x);
	}

	//Method to get Google Photos(Photos API call) based on PlaceId and Photo References we got from Google Places API
	//@Async("threadPoolTaskExecutor")
	//public CompletableFuture<List<GBusinessInfoDTO>> asyncStoreImageUrlsToDB(List<GBusinessInfoDTO> gBusinessInfoDTOList) throws InterruptedException {
	public List<GBusinessInfoDTO> asyncStoreImageUrlsToDB(List<GBusinessInfoDTO> gBusinessInfoDTOList) throws InterruptedException {
		logger.info("**** Inside AsyncProcessingServiceImpl.asyncStoreImageUrlsToDB() gBusinessInfoDTOList.size() "+gBusinessInfoDTOList.size());
		long start = System.currentTimeMillis();
		
		List<GBusinessInfoDTO> returnGBusinessInfoDTOList = new ArrayList();
		GBusinessInfoDTO returnGBusinessInfoDTO = new GBusinessInfoDTO();
		ImagesListDTO imagesListDTO = new ImagesListDTO();
		ImageDTO imageDTO = new ImageDTO();
		List<ImageDTO> imageDTOList = new ArrayList();
		
		for (GBusinessInfoDTO gBusinessInfoDTO: gBusinessInfoDTOList) {
			
			logger.info("***  gBusinessInfoDTO.getBizId(): "+gBusinessInfoDTO.getBizId());
			logger.info("***  gBusinessInfoDTO.getgPlaceId(): "+gBusinessInfoDTO.getgPlaceId());

			String placeId = gBusinessInfoDTO.getgPlaceId();
			logger.info("***  placeId: "+placeId);
			
			if (null != placeId){
				PlaceDetails gpdResult = null;
				//PlaceDetailsRequest gpdResult = null;
				try {
					logger.info("***  Calling PLACE DETAILS API based on placeId: "+placeId);
					logger.info("***  Calling PLACE DETAILS API based on placeId for bizId: "+gBusinessInfoDTO.getBizId());
					gpdResult = (PlacesApi.placeDetails(getGoogleContext(), placeId)).await();
					logger.info("***  AFTER Calling PLACE DETAILS API gpdResult: "+gpdResult);

				} catch (Exception e) {
					e.printStackTrace();
				}
				
				if (null != gpdResult) {
					//capture up to 5 image references 
					logger.info("***  AFTER Calling PLACE DETAILS API Total NUMBER of Photos FOUND : "+gpdResult.photos.length);
	
					int x = 0;
					String[] photoReferances = new String[gpdResult.photos.length];
					if (null != gpdResult.photos && gpdResult.photos.length > 0) {
						for (Photo phoRef: gpdResult.photos) {
							photoReferances[x] = phoRef.photoReference;
							x ++;
							//Collect only 5 image references from Google - To save Photos api cost and storage space
							if(x == 5) {
								logger.info("**** INSIDE BREAK AFTER 5 COUNTER for gPhotos ****");
								break;
							}
						}
					}
					
					int y = 0;
					String[] gPhotoUrls = new String[gBusinessInfoDTOList.size()];
					for (String photoRef: photoReferances) {
						String gPhotoUrl = "https://maps.googleapis.com/maps/api/place/photo?photoreference="+photoRef+"&sensor=false&maxheight=500&maxwidth=500&key=AIzaSyAc0CLCHpUtmyrQmfcEgESIy_OYVICHT6I";
						
						logger.info("***  BIZ Image found on GOOGLE gPhotoUrl: "+gPhotoUrl);
	
						gPhotoUrls[y] = gPhotoUrl;
						y++;
						
						imageDTO.setUrl(gPhotoUrl);
					}
					imageDTOList.add(imageDTO);
					returnGBusinessInfoDTO.setgPhotoUrls(gPhotoUrls);
					
					imagesListDTO.setInvokerId(1001);
					imagesListDTO.setBusinessId(gBusinessInfoDTO.getBizId());
					imagesListDTO.setImagesList(imageDTOList);
					
					logger.info("**** calling addImages");
					//Call the addImages() to store Images on BRW DB
					addImages(imagesListDTO);
				}
			}
		}
		logger.info("Elapsed time: " + (System.currentTimeMillis() - start));
		returnGBusinessInfoDTOList.add(returnGBusinessInfoDTO);
		//return CompletableFuture.completedFuture(returnGBusinessInfoDTOList);
		return returnGBusinessInfoDTOList;
	}

	private GeoApiContext getGoogleContext() {
		GeoApiContext context = new GeoApiContext.Builder().apiKey("AIzaSyAc0CLCHpUtmyrQmfcEgESIy_OYVICHT6I").build();
		return context;
	}

	//Method to get Formatted Address and Latitude and Longitude from Google
	private GBusinessInfoDTO getFormattedAddressAndLatLong(String searchString) throws Exception {
		long start = System.currentTimeMillis();
		
		GBusinessInfoDTO returnGBusinessInfoDTO = new GBusinessInfoDTO();
		
		//logger.info("**** Calling Google for lat/long and photo references");
		logger.info("Calling Google for lat/long and photo references searchString: "+searchString);
		PlacesSearchResponse results = PlacesApi.textSearchQuery(getGoogleContext(), searchString).awaitIgnoreError();
		
		Gson gson = null;
		PlacesSearchResult result = new PlacesSearchResult();
		
		if (null != results.results && results.results.length > 0) {
			logger.info("***** RESULTS AFTER Google CALL IS NOT NULL ****");

			gson = new GsonBuilder().setPrettyPrinting().create();			
			result = results.results[0];
			
			if (!result.permanentlyClosed) {
				returnGBusinessInfoDTO.setgIsClosed(gson.toJson(result.permanentlyClosed));
				returnGBusinessInfoDTO.setgBusinessName(gson.toJson(result.name));
				logger.info("&&&&&&&&&&&&& result.placeId: "+result.placeId);
				returnGBusinessInfoDTO.setgPlaceId(gson.toJson(result.placeId));
				returnGBusinessInfoDTO.setgFormattedAddress(gson.toJson(result.formattedAddress));
				returnGBusinessInfoDTO.setgLatitude(new Double(gson.toJson(result.geometry.location.lat)));
				returnGBusinessInfoDTO.setgLongitude(new Double(gson.toJson(result.geometry.location.lng)));
				if (null != result.photos && result.photos.length > 0) {
					String gPhotoUrl = "https://maps.googleapis.com/maps/api/place/photo?photoreference="+result.photos[0].photoReference+"&sensor=false&maxheight=500&maxwidth=500&key=AIzaSyAc0CLCHpUtmyrQmfcEgESIy_OYVICHT6I";
					returnGBusinessInfoDTO.setgSinglePhotoUrl(gPhotoUrl);
					logger.info("IMAGE FIRST URL from Google gPhotoUrl: "+gPhotoUrl);

				}
				returnGBusinessInfoDTO.setUpdateAfterGoogle(true);
			}
		}
		logger.info("Elapsed time: " + (System.currentTimeMillis() - start));
		return returnGBusinessInfoDTO;
	}

	private BusinessDetailsDTO updateBusinessDetails(BusinessDetailsDTO businessDetailsDTO) {
		logger.info("222 **** Inside AsyncProcessingServiceImpl.updateBusinessDetails() businessDetailsDTO.getBusinessId(): "+businessDetailsDTO.getBusinessId());
		long start = System.currentTimeMillis();
		
		BusinessDetails businessDetails = businessDetailsDAO.findById(businessDetailsDTO.getBusinessId()).get();
		//BusinessDetails businessDetails = new BusinessDetails();
		if (null != businessDetailsDTO.getLegalName() && businessDetailsDTO.getLegalName() != Constants.EMPTY_STRING) {
			businessDetails.setLegalName(businessDetailsDTO.getLegalName());
		}
		
		if (null != businessDetailsDTO.getName() && businessDetailsDTO.getName() != Constants.EMPTY_STRING) {
			businessDetails.setName(businessDetailsDTO.getName());
		}
		
		if (null != businessDetailsDTO.getFirstOwnerName() && businessDetailsDTO.getFirstOwnerName() != Constants.EMPTY_STRING) {
			businessDetails.setFirstOwnerName(businessDetailsDTO.getFirstOwnerName());
		}
		
		if (null != businessDetailsDTO.getSecondOwnerName() && businessDetailsDTO.getSecondOwnerName() != Constants.EMPTY_STRING) {
			businessDetails.setSecondOwnerName(businessDetailsDTO.getSecondOwnerName());
		}
		
		if (null != businessDetailsDTO.getBrandName() && businessDetailsDTO.getBrandName() != Constants.EMPTY_STRING) {
			businessDetails.setBrandName(businessDetailsDTO.getBrandName());
		}
		
		if (null != businessDetailsDTO.getType() && businessDetailsDTO.getType() != Constants.EMPTY_STRING) {
			businessDetails.setType(businessDetailsDTO.getType());
		}
		
		if (null != businessDetailsDTO.getSubType() && businessDetailsDTO.getSubType() != Constants.EMPTY_STRING) {
			businessDetails.setSubType(businessDetailsDTO.getSubType());
		}
		
		if (null != businessDetailsDTO.getRegCityName() && businessDetailsDTO.getRegCityName() != Constants.EMPTY_STRING) {
			businessDetails.setRegCityName(businessDetailsDTO.getRegCityName());
		}
		
		if (null != businessDetailsDTO.getRegCityCode() && businessDetailsDTO.getRegCityCode() != Constants.EMPTY_STRING) {
			businessDetails.setRegCityCode(businessDetailsDTO.getRegCityCode());
		}
		
		if (null != businessDetailsDTO.getRegCityDate()) {
			businessDetails.setRegCityDate(LocalDateTime.parse(businessDetailsDTO.getRegCityDate(), DateTimeFormatter.ofPattern(Constants.DATE_FORMAT)));
		}
		
		if (null != businessDetailsDTO.getRegStateName() && businessDetailsDTO.getRegCityCode() != Constants.EMPTY_STRING) {
			businessDetails.setRegStateName(businessDetailsDTO.getRegStateName());
		}
		
		if (null != businessDetailsDTO.getRegStateCode() && businessDetailsDTO.getRegCityCode() != Constants.EMPTY_STRING) {
			businessDetails.setRegStateCode(businessDetailsDTO.getRegStateCode());
		}
		
		if (null != businessDetailsDTO.getRegStateDate()) {
			businessDetails.setRegStateDate(LocalDateTime.parse(businessDetailsDTO.getRegStateDate(), DateTimeFormatter.ofPattern(Constants.DATE_FORMAT)));
		}
		
		if (null != businessDetailsDTO.getDataCompletionScore()) {
			businessDetails.setDataCompletenessScore(businessDetailsDTO.getDataCompletionScore());
		}
		
		if (null != businessDetailsDTO.getIsForSell() && businessDetailsDTO.getIsForSell() != Constants.EMPTY_STRING) {
			businessDetails.setIsForSell(businessDetailsDTO.getIsForSell());
		}
		
		if (null != businessDetailsDTO.getIsHidden() && businessDetailsDTO.getIsHidden() != Constants.EMPTY_STRING) {
			businessDetails.setIsHidden(businessDetailsDTO.getIsHidden());
		}
		
		if (null != businessDetailsDTO.getForSellPrice()) {
			businessDetails.setForSellPrice(businessDetailsDTO.getForSellPrice());
		}
		
		if (null != businessDetailsDTO.getImageLogo() && businessDetailsDTO.getImageLogo() != Constants.EMPTY_STRING) {
			businessDetails.setImageLogo(businessDetailsDTO.getImageLogo());
		}

		logger.info("businessDetailsDTO.getImageFirst(): "+businessDetailsDTO.getImageFirst());
		if (null != businessDetailsDTO.getImageFirst() && businessDetailsDTO.getImageFirst() != Constants.EMPTY_STRING) {
			businessDetails.setImageFirst(businessDetailsDTO.getImageFirst());
		}
		
		if (null != businessDetailsDTO.getStreet1() && businessDetailsDTO.getStreet1() != Constants.EMPTY_STRING) {
			businessDetails.setStreet1(businessDetailsDTO.getStreet1());
		}
		
		if (null != businessDetailsDTO.getStreet2() && businessDetailsDTO.getStreet2() != Constants.EMPTY_STRING) {
			businessDetails.setStreet2(businessDetailsDTO.getStreet2());
		}
		
		if (null != businessDetailsDTO.getCity() && businessDetailsDTO.getCity() != Constants.EMPTY_STRING) {
			businessDetails.setCity(businessDetailsDTO.getCity());
		}
		
		if (null != businessDetailsDTO.getCounty() && businessDetailsDTO.getCounty() != Constants.EMPTY_STRING) {
			businessDetails.setCounty(businessDetailsDTO.getCounty());
		}
		
		if (null != businessDetailsDTO.getStateCode() && businessDetailsDTO.getStateCode() != Constants.EMPTY_STRING) {
			businessDetails.setStateCode(businessDetailsDTO.getStateCode());
		}
		
		if (null != businessDetailsDTO.getZip()) {
			businessDetails.setZip(businessDetailsDTO.getZip());
		}
		
		logger.info("businessDetailsDTO.getLatitude(): "+businessDetailsDTO.getLatitude());
		if (0.0 != businessDetailsDTO.getLatitude()) {
			businessDetails.setLatitude(businessDetailsDTO.getLatitude());
		}
		
		logger.info("businessDetailsDTO.getLongitude(): "+businessDetailsDTO.getLongitude());
		if (0.0 != businessDetailsDTO.getLongitude()) {
			businessDetails.setLongitude(businessDetailsDTO.getLongitude());
		}
		
		if (null != businessDetailsDTO.getPhone() && businessDetailsDTO.getPhone() != Constants.EMPTY_STRING) {
			businessDetails.setPhoneNumber(businessDetailsDTO.getPhone());
		}
		
		if (null != businessDetailsDTO.getPhoneExt() && businessDetailsDTO.getPhoneExt() != Constants.EMPTY_STRING) {
			businessDetails.setPhoneExtentionNumber(businessDetailsDTO.getPhoneExt());
		}
		
		if (null != businessDetailsDTO.getEmail() && businessDetailsDTO.getEmail() != Constants.EMPTY_STRING) {
			businessDetails.setEmail(businessDetailsDTO.getEmail());
		}
		
		if (null != businessDetailsDTO.getWebsite() && businessDetailsDTO.getWebsite() != Constants.EMPTY_STRING) {
			businessDetails.setWebsite(businessDetailsDTO.getWebsite());
		}
		
		if (null != businessDetailsDTO.getDescription() && businessDetailsDTO.getDescription() != Constants.EMPTY_STRING) {
			businessDetails.setFreeformDescription(businessDetailsDTO.getDescription());
		}
		
		if (null != businessDetailsDTO.getNAICSNum()) {
			businessDetails.setNAICSNum(businessDetailsDTO.getNAICSNum());
		}
		
		if (null != businessDetailsDTO.getNAICSDescription() && businessDetailsDTO.getNAICSDescription() != Constants.EMPTY_STRING) {
			businessDetails.setNAICSDescription(businessDetailsDTO.getNAICSDescription());
		}
		
		if (null != businessDetailsDTO.getIsFranchise() && businessDetailsDTO.getIsFranchise() != Constants.EMPTY_STRING) {
			businessDetails.setIsFranchise(businessDetailsDTO.getIsFranchise());
		}
		
		if (null != businessDetailsDTO.getIsOwnerClaimed() && businessDetailsDTO.getIsOwnerClaimed() != Constants.EMPTY_STRING) {
			businessDetails.setIsOwnerClaimed(businessDetailsDTO.getIsOwnerClaimed());
		}
		
		if (null != businessDetailsDTO.getSqftIndoor()) {
			businessDetails.setSqftIndoor(businessDetailsDTO.getSqftIndoor());
		}
		
		if (null != businessDetailsDTO.getSqftOutdoor()) {
			businessDetails.setSqftOutdoor(businessDetailsDTO.getSqftOutdoor());
		}
		
		if (null != businessDetailsDTO.getSqftLot()) {
			businessDetails.setSqftLot(businessDetailsDTO.getSqftLot());
		}
		
		if (null != businessDetailsDTO.getBuildingType() && businessDetailsDTO.getBuildingType() != Constants.EMPTY_STRING) {
			businessDetails.setBuildingType(businessDetailsDTO.getBuildingType());
		}
		
		if (null != businessDetailsDTO.getIsBuildingOwned() && businessDetailsDTO.getIsBuildingOwned() != Constants.EMPTY_STRING) {
			businessDetails.setIsBuildingOwned(businessDetailsDTO.getIsBuildingOwned());
		}
		
		if (null != businessDetailsDTO.getRevenueMonthly()) {
			businessDetails.setRevenueMonthly(businessDetailsDTO.getRevenueMonthly());
		}
		
		if (null != businessDetailsDTO.getExpenseMonthlyRent()) {
			businessDetails.setExpenseMonthlyRent(businessDetailsDTO.getExpenseMonthlyRent());
		}
		
		if (null != businessDetailsDTO.getExpenseMonthlyMortgage()) {
			businessDetails.setExpenseMonthlyMortgage(businessDetailsDTO.getExpenseMonthlyMortgage());
		}
		
		if (null != businessDetailsDTO.getExpenseMonthlyMaterial()) {
			businessDetails.setExpenseMonthlyMaterial(businessDetailsDTO.getExpenseMonthlyMaterial());
		}
		
		if (null != businessDetailsDTO.getExpenseMonthlyEmp()) {
			businessDetails.setExpenseMonthlyEmp(businessDetailsDTO.getExpenseMonthlyEmp());
		}
		
		if (null != businessDetailsDTO.getExpenseMonthlyUtility()) {
			businessDetails.setExpenseMonthlyUtility(businessDetailsDTO.getExpenseMonthlyUtility());
		}
		
		if (null != businessDetailsDTO.getExpenseMonthlyOther()) {
			businessDetails.setExpenseMonthlyOther(businessDetailsDTO.getExpenseMonthlyOther());
		}
		
		if (null != businessDetailsDTO.getValueTotalEquipment()) {
			businessDetails.setValueTotalEquipment(businessDetailsDTO.getValueTotalEquipment());
		}
		
		if (null != businessDetailsDTO.getValueTotalFurniture()) {
			businessDetails.setValueTotalFurniture(businessDetailsDTO.getValueTotalFurniture());
		}
		
		if (null != businessDetailsDTO.getValueIndoorDeco()) {
			businessDetails.setValueIndoorDeco(businessDetailsDTO.getValueIndoorDeco());
		}
		
		if (null != businessDetailsDTO.getValueOutdoorDeco()) {
			businessDetails.setValueOutdoorDeco(businessDetailsDTO.getValueOutdoorDeco());
		}
		
		if (null != businessDetailsDTO.getYearEquipment()) {
			businessDetails.setYearEquipment(businessDetailsDTO.getYearEquipment());
		}
		
		if (null != businessDetailsDTO.getYearFurniture()) {
			businessDetails.setYearFurniture(businessDetailsDTO.getYearFurniture());
		}
		
		if (null != businessDetailsDTO.getYearIndoorDeco()) {
			businessDetails.setYearIndoorDeco(businessDetailsDTO.getYearIndoorDeco());
		}
		
		if (null != businessDetailsDTO.getYearOutdoorDeco()) {
			businessDetails.setYearOutdoorDeco(businessDetailsDTO.getYearOutdoorDeco());
		}
		
		if (null != businessDetailsDTO.getEmpFullTimeNum()) {
			businessDetails.setEmpFullTimeNum(businessDetailsDTO.getEmpFullTimeNum());
		}
		
		if (null != businessDetailsDTO.getEmpPartTimeNum()) {
			businessDetails.setEmpPartTimeNum(businessDetailsDTO.getEmpPartTimeNum());
		}
		
		if (null != businessDetailsDTO.getAreaCrimeScore()) {
			businessDetails.setAreaCrimeScore(businessDetailsDTO.getAreaCrimeScore());
		}
		
		if (null != businessDetailsDTO.getAreaWalkScore()) {
			businessDetails.setAreaWalkScore(businessDetailsDTO.getAreaWalkScore());
		}
		
		if (null != businessDetailsDTO.getAreaAttractionsScore()) {
			businessDetails.setAreaAttractionsScore(businessDetailsDTO.getAreaAttractionsScore());
		}
		
		if (null != businessDetailsDTO.getAreaTransitScore()) {
			businessDetails.setAreaTransitScore(businessDetailsDTO.getAreaTransitScore());
		}
		
		if (null != businessDetailsDTO.getSocialMediaScore()) {
			businessDetails.setSocialMediaScore(businessDetailsDTO.getSocialMediaScore());
		}
		
		if (null != businessDetailsDTO.getPopulationIn1mileRadius()) {
			businessDetails.setPopulationIn1mileRadius(businessDetailsDTO.getPopulationIn1mileRadius());
		}
		
		if (null != businessDetailsDTO.getIncomeScoreIn1mileRadius()) {
		businessDetails.setIncomeScoreIn1mileRadius(businessDetailsDTO.getIncomeScoreIn1mileRadius());
		}
		
		if (null != businessDetailsDTO.getPopulationIn3mileRadius()) {
		businessDetails.setPopulationIn3mileRadius(businessDetailsDTO.getPopulationIn3mileRadius());
		}
		
		if (null != businessDetailsDTO.getIncomeScoreIn3mileRadius()) {
			businessDetails.setIncomeScoreIn3mileRadius(businessDetailsDTO.getIncomeScoreIn3mileRadius());
		}
		
		if (null != businessDetailsDTO.getPopulationIn5mileRadius()) {
			businessDetails.setPopulationIn5mileRadius(businessDetailsDTO.getPopulationIn5mileRadius());
		}
		
		if (null != businessDetailsDTO.getIncomeScoreIn5mileRadius()) {
			businessDetails.setIncomeScoreIn5mileRadius(businessDetailsDTO.getIncomeScoreIn5mileRadius());
		}
		
		if (null != businessDetailsDTO.getDailyPeoplAtDoorNum()) {
			businessDetails.setDailyPeoplAtDoorNum(businessDetailsDTO.getDailyPeoplAtDoorNum());
		}
		
		if (null != businessDetailsDTO.getDailyCarsAtParklotNum()) {
			businessDetails.setDailyCarsAtParklotNum(businessDetailsDTO.getDailyCarsAtParklotNum());
		}
		
		if (null != businessDetailsDTO.getYearEstablished()) {
			businessDetails.setYearEstablished(businessDetailsDTO.getYearEstablished());
		}
		
		businessDetails.setUpdatedByUserId(businessDetailsDTO.getInvokerId());
		businessDetails.setUpdateDate(LocalDateTime.now());
		
		BusinessDetails business = businessDetailsDAO.save(businessDetails);
		
		BusinessDetailsDTO bizDTO = new BusinessDetailsDTO();
		bizDTO.setBusinessId(business.getBusinessId());
		bizDTO.setLegalName(business.getLegalName());
		bizDTO.setType(business.getType());
		
		//BusinessDetails businessDetails = new BusinessDetails();
		bizDTO.setLegalName(business.getLegalName());
		bizDTO.setName(business.getName());
		bizDTO.setFirstOwnerName(business.getFirstOwnerName());
		bizDTO.setSecondOwnerName(business.getSecondOwnerName());
		bizDTO.setBrandName(business.getBrandName());
		bizDTO.setType(business.getType());
		bizDTO.setSubType(business.getSubType());
		bizDTO.setRegCityName(business.getRegCityName());
		bizDTO.setRegCityCode(business.getRegCityCode());
		if(null != business.getRegCityDate()) {
			bizDTO.setRegCityDate(business.getRegCityDate().format(DateTimeFormatter.ofPattern(Constants.DATE_FORMAT)));
		}
		bizDTO.setRegStateName(business.getRegStateName());
		bizDTO.setRegStateCode(business.getRegStateCode());
		if(null != business.getRegStateDate()) {
			bizDTO.setRegStateDate(business.getRegStateDate().format(DateTimeFormatter.ofPattern(Constants.DATE_FORMAT)));
		}
		bizDTO.setDataCompletionScore(business.getDataCompletenessScore());
		bizDTO.setIsForSell(business.getIsForSell());
		bizDTO.setIsHidden(business.getIsHidden());
		bizDTO.setForSellPrice(business.getForSellPrice());
		bizDTO.setImageLogo(business.getImageLogo());
		bizDTO.setImageFirst(business.getImageFirst());
		bizDTO.setStreet1(business.getStreet1());
		bizDTO.setStreet2(business.getStreet2());
		bizDTO.setCity(business.getCity());
		bizDTO.setCounty(business.getCounty());
		bizDTO.setStateCode(business.getStateCode());
		bizDTO.setZip(business.getZip());	
		bizDTO.setLatitude(business.getLatitude());
		bizDTO.setLongitude(business.getLongitude());
		bizDTO.setPhone(business.getPhoneNumber());
		bizDTO.setPhoneExt(business.getPhoneExtentionNumber());
		bizDTO.setEmail(business.getEmail());
		bizDTO.setWebsite(business.getWebsite());
		bizDTO.setDescription(business.getFreeformDescription());
		bizDTO.setNAICSNum(business.getNAICSNum());
		bizDTO.setNAICSDescription(business.getNAICSDescription());
		bizDTO.setIsFranchise(business.getIsFranchise());
		bizDTO.setIsOwnerClaimed(business.getIsOwnerClaimed());
		bizDTO.setSqftIndoor(business.getSqftIndoor());
		bizDTO.setSqftOutdoor(business.getSqftOutdoor());
		bizDTO.setSqftLot(business.getSqftLot());
		bizDTO.setBuildingType(business.getBuildingType());
		bizDTO.setIsBuildingOwned(business.getIsBuildingOwned());
		bizDTO.setRevenueMonthly(business.getRevenueMonthly());
		bizDTO.setExpenseMonthlyRent(business.getExpenseMonthlyRent());
		bizDTO.setExpenseMonthlyMortgage(business.getExpenseMonthlyMortgage());
		bizDTO.setExpenseMonthlyMaterial(business.getExpenseMonthlyMaterial());
		bizDTO.setExpenseMonthlyEmp(business.getExpenseMonthlyEmp());
		bizDTO.setExpenseMonthlyUtility(business.getExpenseMonthlyUtility());
		bizDTO.setExpenseMonthlyOther(business.getExpenseMonthlyOther());
		bizDTO.setValueTotalEquipment(business.getValueTotalEquipment());
		bizDTO.setValueTotalFurniture(business.getValueTotalFurniture());
		bizDTO.setValueIndoorDeco(business.getValueIndoorDeco());
		bizDTO.setValueOutdoorDeco(business.getValueOutdoorDeco());
		bizDTO.setYearEquipment(business.getYearEquipment());
		bizDTO.setYearFurniture(business.getYearFurniture());
		bizDTO.setYearIndoorDeco(business.getYearIndoorDeco());
		bizDTO.setYearOutdoorDeco(business.getYearOutdoorDeco());
		bizDTO.setEmpFullTimeNum(business.getEmpFullTimeNum());
		bizDTO.setEmpPartTimeNum(business.getEmpPartTimeNum());
		bizDTO.setAreaCrimeScore(business.getAreaCrimeScore());
		bizDTO.setAreaWalkScore(business.getAreaWalkScore());
		bizDTO.setAreaAttractionsScore(business.getAreaAttractionsScore());
		bizDTO.setAreaTransitScore(business.getAreaTransitScore());
		bizDTO.setSocialMediaScore(business.getSocialMediaScore());
		bizDTO.setPopulationIn1mileRadius(business.getPopulationIn1mileRadius());
		bizDTO.setIncomeScoreIn1mileRadius(business.getIncomeScoreIn1mileRadius());
		bizDTO.setPopulationIn3mileRadius(business.getPopulationIn3mileRadius());
		bizDTO.setIncomeScoreIn3mileRadius(business.getIncomeScoreIn3mileRadius());
		bizDTO.setPopulationIn5mileRadius(business.getPopulationIn5mileRadius());
		bizDTO.setIncomeScoreIn5mileRadius(business.getIncomeScoreIn5mileRadius());
		bizDTO.setDailyPeoplAtDoorNum(business.getDailyPeoplAtDoorNum());
		bizDTO.setDailyCarsAtParklotNum(business.getDailyCarsAtParklotNum());
		bizDTO.setYearEstablished(business.getYearEstablished());
		bizDTO.setCreatedByUserId(business.getCreatedByUserId());
		bizDTO.setCreateDate(business.getCreateDate().format(DateTimeFormatter.ofPattern(Constants.DATE_FORMAT)));
		bizDTO.setUpdatedByUserId(business.getUpdatedByUserId());
		bizDTO.setUpdateDate(business.getUpdateDate().format(DateTimeFormatter.ofPattern(Constants.DATE_FORMAT)));
		
		//Add Business and User relationship in t_brw_user_business table
		//addUserBusiness(bizDTO, businessDetailsDTO.getBuRelationship());
		logger.info("Elapsed time: " + (System.currentTimeMillis() - start));
		return bizDTO;
	}
	
	private ImagesListDTO addImages(ImagesListDTO imagesListDTO) {
		logger.info("222 **** Inside AsyncProcessingServiceImpl.addImages()");
		long start = System.currentTimeMillis();
		
		List<ImageDTO> imagesDTOList = imagesListDTO.getImagesList();
		List<ImageDTO> returnImageDTOList = new ArrayList<ImageDTO>();
		ImagesListDTO returnImagesListDTO = new ImagesListDTO();

		Image returnImage = new Image();
		Image image;
		ImageDTO retImageDTO;
		
		for (ImageDTO imageDTO: imagesDTOList) {
			
			image = new Image();

			image.setBusinessId(imagesListDTO.getBusinessId());
			image.setUrl(imageDTO.getUrl());
			image.setTitle(imageDTO.getTitle());
			image.setCreatedByUserId(imagesListDTO.getInvokerId());
			image.setCreateDate(LocalDateTime.now());
			image.setUpdatedByUserId(imagesListDTO.getInvokerId());
			image.setUpdateDate(LocalDateTime.now());
			
			returnImage = imageDAO.save(image);
			retImageDTO = new ImageDTO();

			retImageDTO.setImageId(returnImage.getImageId());
			retImageDTO.setTitle(returnImage.getTitle());
			retImageDTO.setUrl(returnImage.getUrl());
			retImageDTO.setCreatedByUserId(returnImage.getCreatedByUserId());
			retImageDTO.setCreateDate(returnImage.getCreateDate().format(DateTimeFormatter.ofPattern(Constants.DATE_FORMAT)));
			retImageDTO.setUpdatedByUserId(returnImage.getUpdatedByUserId());
			retImageDTO.setUpdateDate(returnImage.getUpdateDate().format(DateTimeFormatter.ofPattern(Constants.DATE_FORMAT)));
			
			returnImageDTOList.add(retImageDTO);
		}
		returnImagesListDTO.setBusinessId(returnImage.getBusinessId());
		returnImagesListDTO.setImagesList(returnImageDTOList);
		logger.info("Elapsed time: " + (System.currentTimeMillis() - start));
		return returnImagesListDTO;
	}
	
}