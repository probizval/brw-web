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
import com.brw.dao.BizGoogleInfoDAO;
import com.brw.dao.BusinessActivityDAO;
import com.brw.dao.ImageDAO;
import com.brw.dao.UserActivityDAO;
import com.brw.dto.BusinessDetailsDTO;
import com.brw.dto.BusinessInfoDTO;
import com.brw.dto.GBusinessInfoDTO;
import com.brw.dto.ImageDTO;
import com.brw.dto.ImagesListDTO;
import com.brw.dto.UserActivityDTO;
import com.brw.entities.BizGoogleInfo;
import com.brw.entities.BusinessActivity;
import com.brw.entities.Image;
import com.brw.entities.UserActivity;
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
	private BizGoogleInfoDAO bizGoogleInfoDAO;
	
	@Autowired
	private ImageDAO imageDAO;
	
	@Autowired
	private UserActivityDAO userActivityDAO;
	
	@Autowired
	private BusinessActivityDAO bizActivityDAO;
	
	/*
	 * asyncStoreLatLngToDB calls Google Places API to get the lat/long, firstImage and placeId
	 * The placeId will then be used by asyncStoreImagesToDB method 
	 */
	@Async("threadPoolTaskExecutor")
	public CompletableFuture<Integer> asyncStoreLatLngToDB(List <BusinessInfoDTO> bizInfoDTOList) throws InterruptedException {
		logger.info("**** Inside AsyncProcessingServiceImpl.asyncStoreLatLngToDB() bizInfoDTOList.size(): "+bizInfoDTOList.size());
		long start = System.currentTimeMillis();
		int updateCount = 0;
		
		List<GBusinessInfoDTO> gBusinessInfoDTOList = null;
		
		if (bizInfoDTOList.size() > 0) {
			gBusinessInfoDTOList = new ArrayList();
			for (BusinessInfoDTO businessInfoDTO: bizInfoDTOList) {
				
				logger.info("**** businessInfoDTO.getGoogleBizSearchString(): "+businessInfoDTO.getGoogleBizSearchString());
				if (null != businessInfoDTO.getGoogleBizSearchString()) {
				
					GBusinessInfoDTO gBusinessInfoDTO = new GBusinessInfoDTO();
					GBusinessInfoDTO forUPDTGBusinessInfoDTO = new GBusinessInfoDTO();
		
					try {
						gBusinessInfoDTO = getBizGoggleInfo(businessInfoDTO.getGoogleBizSearchString());
						
					} catch (Exception e) {
						e.printStackTrace();
					}
					if (null != gBusinessInfoDTO) {
						
						BusinessDetailsDTO bizGoogleInfoDTO = new BusinessDetailsDTO();
						bizGoogleInfoDTO.setInvokerId(1001);
						bizGoogleInfoDTO.setBusinessId(businessInfoDTO.getBusinessId());
						logger.info("**** bizgoogleInfoDTO.getBusinessId(): "+bizGoogleInfoDTO.getBusinessId());

						bizGoogleInfoDTO.setLatitude(gBusinessInfoDTO.getgLatitude());
						logger.info("**** bizgoogleInfoDTO.getBusinessId(): "+bizGoogleInfoDTO.getLatitude());

						bizGoogleInfoDTO.setLongitude(gBusinessInfoDTO.getgLongitude());
						logger.info("**** bizgoogleInfoDTO.getBusinessId(): "+bizGoogleInfoDTO.getLongitude());

						bizGoogleInfoDTO.setImageFirst(gBusinessInfoDTO.getgSinglePhotoUrl());
						logger.info("**** bizgoogleInfoDTO.getBusinessId(): "+bizGoogleInfoDTO.getImageFirst());
						
						bizGoogleInfoDTO.setFormattedAddress(gBusinessInfoDTO.getgFormattedAddress());
						logger.info("**** bizgoogleInfoDTO.getBusinessId(): "+bizGoogleInfoDTO.getImageFirst());

						bizGoogleInfoDTO.setIsVendorCall(Constants.Y);
						logger.info("**** bizgoogleInfoDTO.getBusinessId(): "+bizGoogleInfoDTO.getIsVendorCall());

						
						updateCount++;
						logger.info("**** CURRENT updateCount: "+updateCount);
						//Calling updateBizGoogleInfoToBRWDB
						updateBizGoogleInfoToBRWDB(bizGoogleInfoDTO);
						
						//populate info in BizLatLongDTO
						forUPDTGBusinessInfoDTO.setBizId(businessInfoDTO.getBusinessId());
						forUPDTGBusinessInfoDTO.setgPlaceId(gBusinessInfoDTO.getgPlaceId());

						gBusinessInfoDTOList.add(forUPDTGBusinessInfoDTO);
					}
				} else {
					logger.info("$$$$$$ CALL TO updateBizGoogleInfoToBRWDB is SKIPPED");
				}
			}
			//Call this method to get the Photo URLs for biz from google and Add them to image table
			if (null != gBusinessInfoDTOList) {
				storeOtherImageUrlsToBRWDB(gBusinessInfoDTOList);
			}
		}
		logger.info("**** Total updateCount: "+updateCount);
		logger.info("Elapsed time in asyncStoreLatLngToDB: " + (System.currentTimeMillis() - start));
		//return CompletableFuture.completedFuture(returnGBusinessInfoDTOList);
		return CompletableFuture.completedFuture(0);
	}

	private GeoApiContext getGoogleContext() {
		GeoApiContext context = new GeoApiContext.Builder().apiKey("AIzaSyAc0CLCHpUtmyrQmfcEgESIy_OYVICHT6I").build();
		return context;
	}

	//Method to get Formatted Address and Latitude and Longitude from Google
	private GBusinessInfoDTO getBizGoggleInfo(String searchString) throws Exception {
		long start = System.currentTimeMillis();
		
		GBusinessInfoDTO returnGBusinessInfoDTO = null;
		
		//logger.info("**** Calling Google for lat/long and photo references");
		logger.info("Calling Google for lat/long and photo references searchString: "+searchString);
		PlacesSearchResponse results = PlacesApi.textSearchQuery(getGoogleContext(), searchString).awaitIgnoreError();
		
		Gson gson = null;
		PlacesSearchResult result = new PlacesSearchResult();
		
		if (null != results.results && results.results.length > 0) {
			gson = new GsonBuilder().setPrettyPrinting().create();			
			result = results.results[0];
			
			if (!result.permanentlyClosed) {
				returnGBusinessInfoDTO = new GBusinessInfoDTO();
				returnGBusinessInfoDTO.setgIsClosed(gson.toJson(result.permanentlyClosed));
				returnGBusinessInfoDTO.setgBusinessName(gson.toJson(result.name));
				returnGBusinessInfoDTO.setgPlaceId(gson.toJson(result.placeId));
				returnGBusinessInfoDTO.setgFormattedAddress(gson.toJson(result.formattedAddress));
				returnGBusinessInfoDTO.setgLatitude(new Double(gson.toJson(result.geometry.location.lat)));
				returnGBusinessInfoDTO.setgLongitude(new Double(gson.toJson(result.geometry.location.lng)));
				if (null != result.photos && result.photos.length > 0) {
					String gPhotoUrl = "https://maps.googleapis.com/maps/api/place/photo?photoreference="+result.photos[0].photoReference+"&sensor=false&maxheight=500&maxwidth=500&key=AIzaSyAc0CLCHpUtmyrQmfcEgESIy_OYVICHT6I";
					
					//TODO: How to get DIRECt image URL instead of above URL that has our Google API Key?
					//Below blog post says its not possible
					//https://stackoverflow.com/questions/40572232/processing-google-photo-reference-to-get-the-image-url

					returnGBusinessInfoDTO.setgSinglePhotoUrl(gPhotoUrl);

				}
			}
		}
		logger.info("Elapsed time in getBizGoggleInfo(): " + (System.currentTimeMillis() - start));
		return returnGBusinessInfoDTO;
	}
	
	//Method to get Google Photos(Photos API call) based on PlaceId and Photo References we got from Google Places API
	public List<GBusinessInfoDTO> storeOtherImageUrlsToBRWDB(List<GBusinessInfoDTO> gBusinessInfoDTOList) {
		logger.info("****$$$$ Inside AsyncProcessingServiceImpl.storeOtherImageUrlsToBRWDB() gBusinessInfoDTOList.size() "+gBusinessInfoDTOList.size());
		
		long start = System.currentTimeMillis();
		
		List<GBusinessInfoDTO> returnGBusinessInfoDTOList = new ArrayList();
		GBusinessInfoDTO returnGBusinessInfoDTO = null;
		ImagesListDTO imagesListDTO = null;
		ImageDTO imageDTO = null;
		List<ImageDTO> imageDTOList = null;
		
		for (GBusinessInfoDTO gBusinessInfoDTO: gBusinessInfoDTOList) {
			
			if (null != gBusinessInfoDTO.getgPlaceId()){
				PlaceDetails placeDetails = null;
				//PlaceDetailsRequest gpdResult = null;
			
				try {
					logger.info("***  Calling PLACE DETAILS API based on placeId: "+gBusinessInfoDTO.getgPlaceId());
					logger.info("***  Calling PLACE DETAILS API based on placeId for bizId: "+gBusinessInfoDTO.getBizId());
					//TODO: This call is failing for whatever reason - need fixing 06/30/2020
					//Failure is a reason of we not able to get Google Images stored in BRW DB
					placeDetails = (PlacesApi.placeDetails(getGoogleContext(), gBusinessInfoDTO.getgPlaceId())).awaitIgnoreError();

				} catch (Exception e) {
					e.printStackTrace();

				}
				
				if (null != placeDetails) {
					returnGBusinessInfoDTO = new GBusinessInfoDTO();
					imagesListDTO = new ImagesListDTO();
					imageDTO = new ImageDTO();
					imageDTOList = new ArrayList();
					
					//capture up to 5 image references 
					logger.info("***%%%%  AFTER Calling PLACE DETAILS API Total NUMBER of Photos FOUND : "+placeDetails.photos.length);
	
					int x = 0;
					String[] photoReferances = new String[placeDetails.photos.length];
					if (null != placeDetails.photos && placeDetails.photos.length > 0) {
						for (Photo phoRef: placeDetails.photos) {
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
					
					logger.info(" &&&&&& PlacesApi.placeDetails RESPONSE is NOT NULL");
					logger.info("**** calling addImages");
					//Call the addImages() to store Images on BRW DB
					addImages(imagesListDTO);
					
				} else {
					logger.info(" $$$$$$ PlacesApi.placeDetails RESPONSE is NULL");
				}
			} 
		}
		logger.info("Elapsed time in storeOtherImageUrlsToBRWDB: " + (System.currentTimeMillis() - start));
		returnGBusinessInfoDTOList.add(returnGBusinessInfoDTO);
		//return CompletableFuture.completedFuture(returnGBusinessInfoDTOList);
		return returnGBusinessInfoDTOList;
	}

	/*
	 * Update bit of business info as returned by google API
	 */
	private BusinessInfoDTO updateBizGoogleInfoToBRWDB(BusinessDetailsDTO bizGoogleInfoDTO) {
		logger.info("222 **** Inside AsyncProcessingServiceImpl.updateBizGoogleInfo() businessInfoDTO.getBusinessId(): "+bizGoogleInfoDTO.getBusinessId());
		long start = System.currentTimeMillis();
		
		BizGoogleInfo bizGoogleInfo = bizGoogleInfoDAO.findById(bizGoogleInfoDTO.getBusinessId()).get();

		logger.info("bizGoogleInfoDTO.getImageFirst(): "+bizGoogleInfoDTO.getImageFirst());
		if (null != bizGoogleInfoDTO.getImageFirst() && !bizGoogleInfoDTO.getImageFirst().equals(Constants.EMPTY_STRING)) {
			bizGoogleInfo.setImageFirst(bizGoogleInfoDTO.getImageFirst());
		}

		logger.info("bizGoogleInfoDTO.getLatitude(): "+bizGoogleInfoDTO.getLatitude());
		if (0.0 != bizGoogleInfoDTO.getLatitude()) {
			bizGoogleInfo.setLatitude(bizGoogleInfoDTO.getLatitude());
		}
		
		logger.info("businessDetailsDTO.getLongitude(): "+bizGoogleInfoDTO.getLongitude());
		if (0.0 != bizGoogleInfoDTO.getLongitude()) {
			bizGoogleInfo.setLongitude(bizGoogleInfoDTO.getLongitude());
		}
		
		logger.info("businessDetailsDTO.getFormattedAddress(): "+bizGoogleInfoDTO.getFormattedAddress());
		if (null != bizGoogleInfoDTO.getFormattedAddress() && !bizGoogleInfoDTO.getFormattedAddress().equals(Constants.EMPTY_STRING)) {
			bizGoogleInfo.setgFormattedAdd(bizGoogleInfoDTO.getFormattedAddress());
		}

		logger.info("businessDetailsDTO.getIsVendorCall(): "+bizGoogleInfoDTO.getIsVendorCall());
		if (null != bizGoogleInfoDTO.getIsVendorCall()) {
			bizGoogleInfo.setIsVendorCall(bizGoogleInfoDTO.getIsVendorCall());
		}
		
		bizGoogleInfo.setUpdatedByUserId(bizGoogleInfoDTO.getInvokerId());
		bizGoogleInfo.setUpdateDate(LocalDateTime.now());
		
		BizGoogleInfo updatedBizGoogleInfo = bizGoogleInfoDAO.save(bizGoogleInfo);
		
		BusinessInfoDTO bizInfoDTO = new BusinessInfoDTO();
		bizInfoDTO.setBusinessId(updatedBizGoogleInfo.getBusinessId());
		
		bizInfoDTO.setLatitude(updatedBizGoogleInfo.getLatitude());
		bizInfoDTO.setLongitude(updatedBizGoogleInfo.getLongitude());
		bizInfoDTO.setImageFirst(updatedBizGoogleInfo.getImageFirst());
		bizInfoDTO.setIsVendorCall(updatedBizGoogleInfo.getIsVendorCall());
		
		logger.info("Elapsed time: " + (System.currentTimeMillis() - start));
		return bizInfoDTO;
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

	/*
	 * asyncTrackUserActivity stores User Activity in User Table and also increments the view counter for business in business table
	 * 
	 */
	@Async("threadPoolTaskExecutor")
	public CompletableFuture<Integer> asyncTrackUserActivity(UserActivityDTO userActivityDTO) throws InterruptedException {
		long start = System.currentTimeMillis();

		logger.info("$$$$ **** Inside AsyncProcessingServiceImpl.asyncTrackUserActivity()");
		
		UserActivity userActivity = new UserActivity();
		userActivity.setUserId(userActivityDTO.getUserId());
		userActivity.setBusinessId(userActivityDTO.getBusinessId());
		userActivity.setType(userActivityDTO.getType());
		userActivity.setSubType(userActivityDTO.getSubType());
		userActivity.setCreatedByUserId(userActivityDTO.getUserId());
		userActivity.setCreateDate(LocalDateTime.now());
		userActivity.setUpdatedByUserId(userActivityDTO.getUserId());
		userActivity.setUpdateDate(LocalDateTime.now());
		
		//store user activity against userId in user activity table
		userActivityDAO.save(userActivity);
				
		//getBizViewCounter()
		BusinessActivity bizActivity = new BusinessActivity();
		bizActivity.setBusinessId(userActivityDTO.getBusinessId());
		bizActivity.setViewCounter(bizActivityDAO.getBizViewCounter(userActivityDTO.getBusinessId()) + 1);
		
		//Increment business view counter in business table - to see view view a particular business need to make a join sql query on user activity table
		bizActivityDAO.save(bizActivity);
		
		logger.info("Elapsed time in asyncTrackUserActivity: " + (System.currentTimeMillis() - start));

		return CompletableFuture.completedFuture(0);
	}
}