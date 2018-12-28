package com.brw.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.brw.common.constants.ErrorCodes;
import com.brw.common.response.ApiResponse;
import com.brw.dao.CoinLaundryDAO;
import com.brw.dao.GasStationDAO;
import com.brw.dao.LiquorStoreDAO;
import com.brw.dao.PropertyDetailsDAO;
import com.brw.dao.PropertyImagesDAO;
import com.brw.dao.RestaurentDAO;
import com.brw.dao.SalonStoreDAO;
import com.brw.dto.CoinLaundryDetailsDTO;
import com.brw.dto.FilterDTO;
import com.brw.dto.GasStationDetailsDTO;
import com.brw.dto.LiquorStoreDTO;
import com.brw.dto.PropertyDetailsDTO;
import com.brw.dto.PropertyImagesDTO;
import com.brw.dto.PropertyListDTO;
import com.brw.dto.PropertyMetaDataDTO;
import com.brw.dto.RestaurantDTO;
import com.brw.dto.RestaurantDetailsDTO;
import com.brw.dto.SalonStoreDTO;
import com.brw.entities.CoinLaundry;
import com.brw.entities.GasStation;
import com.brw.entities.LiquorStore;
import com.brw.entities.PropertyDetails;
import com.brw.entities.PropertyImages;
import com.brw.entities.Restaurant;
import com.brw.entities.SalonStore;
import com.brw.exceptions.PropertyDetailsException;

@Component
public class PropertyDetailsService implements com.brw.service.PropertyDetailsService  {

	@Autowired
	private PropertyDetailsDAO propertyDetailsDAO; 
	
	@Autowired
	private GasStationDAO gasStationDAO;
	
	@Autowired
	private RestaurentDAO restaurentDAO;
	
	@Autowired
	private PropertyImagesDAO propertImagesDAO;
	
	@Autowired
	private CoinLaundryDAO coinLaundryDAO;
	
	@Autowired
	private LiquorStoreDAO liquorStoreDAO;
	
	@Autowired
	private SalonStoreDAO salonStoreDAO;
	
	@Override
	public PropertyListDTO getAllPropertyList(FilterDTO filter) {
		// TODO Auto-generated method stub
		List<PropertyDetails> propertyList = (List<PropertyDetails>) propertyDetailsDAO.getProperties(filter.getLatitude(), filter.getLongitude(), filter.getZipCode());
		List<PropertyDetailsDTO> propertyDetailsDTOList = new ArrayList<PropertyDetailsDTO>();
		PropertyListDTO propertyListDTO = new PropertyListDTO();
		
		for (PropertyDetails propertyDetails: propertyList) {
			PropertyDetailsDTO propertyDetailsDTO = new PropertyDetailsDTO();
			propertyDetailsDTO.setId(propertyDetails.getId());
			propertyDetailsDTO.setPropertyName(propertyDetails.getPropertyName());		
			propertyDetailsDTO.setPropertyType(propertyDetails.getPropertyType());
			propertyDetailsDTO.setBusinessType(propertyDetails.getBusinessType());
			propertyDetailsDTO.setCity(propertyDetails.getCity());
			propertyDetailsDTO.setCurrentOwner(propertyDetails.getCurrentOwner());
			propertyDetailsDTO.setEstatedEstimatedValue(propertyDetails.getEstatesEstimatedValue());
			propertyDetailsDTO.setImageUrl(propertyDetails.getImageUrl());
			propertyDetailsDTO.setLatitude(propertyDetails.getLatitude());
			propertyDetailsDTO.setLongitude(propertyDetails.getLongitude());
			propertyDetailsDTO.setLotSize(propertyDetails.getLotSize());
			propertyDetailsDTO.setPropertyAddress(propertyDetails.getPropertyAddress());
			propertyDetailsDTO.setState(propertyDetails.getState());
			propertyDetailsDTO.setZipCode(propertyDetails.getZipCode());
			
			propertyDetailsDTOList.add(propertyDetailsDTO);
		}
		propertyListDTO.setPropertyList(propertyDetailsDTOList);
		return propertyListDTO;
	}

	@Override
	public PropertyMetaDataDTO getPropertyDetails(int id) throws PropertyDetailsException {
		// TODO Auto-generated method stub
		
		PropertyDetails propertyDetails = null;
		try {
				propertyDetails = propertyDetailsDAO.findById(id).get();
		} catch (Exception e) {
			throw new PropertyDetailsException("Record not found...");
		}
		PropertyMetaDataDTO propertyDetailsDTO = new PropertyMetaDataDTO();
		propertyDetailsDTO.setPropertyMetaData(propertyDetails);
		List<PropertyImages> propertyImages = propertImagesDAO.findByPropertyDetailsId(propertyDetails.getId());
		propertyDetailsDTO.setPropertyImages(propertyImages);
		return propertyDetailsDTO;
	}

	@Override
	public PropertyDetailsDTO savePropertyDetail(PropertyDetailsDTO propertyDetailsDTO) {
		// TODO Auto-generated method stub
		PropertyDetails propertyDetails = new PropertyDetails();
		propertyDetails.setPropertyName(propertyDetailsDTO.getPropertyName());
		propertyDetails.setPropertyType(propertyDetailsDTO.getPropertyType());
		
		List<PropertyDetails> propertyList = (List<PropertyDetails>) propertyDetailsDAO.findByPropertyName(propertyDetailsDTO.getPropertyName());
		PropertyDetails property;
		
		if(!propertyList.isEmpty()) {
			property = propertyList.get(0);
		} else {
			property = propertyDetailsDAO.save(propertyDetails);
		}
		PropertyDetailsDTO prodDTO = new PropertyDetailsDTO();
		
		prodDTO.setId(property.getId());
		prodDTO.setPropertyName(property.getPropertyName());
		prodDTO.setPropertyType(property.getPropertyType());
		
		return prodDTO;
	}

	@Override
	public PropertyDetailsDTO updatePropertyDetail(PropertyDetailsDTO propertyDetailsDTO) {
		// TODO Auto-generated method stub
				PropertyDetails propertyDetails = propertyDetailsDAO.findById(propertyDetailsDTO.getId()).get();
				propertyDetails.setPropertyName(propertyDetailsDTO.getPropertyName());
				propertyDetails.setPropertyType(propertyDetailsDTO.getPropertyType());
			
				PropertyDetails	property = propertyDetailsDAO.save(propertyDetails);
				PropertyDetailsDTO prodDTO = new PropertyDetailsDTO();
				
				prodDTO.setId(property.getId());
				prodDTO.setPropertyName(property.getPropertyName());
				prodDTO.setPropertyType(property.getPropertyType());
				
				return prodDTO;
	}
	
	@Override
	public GasStationDetailsDTO  getGasStationPropertyDetails(int id) throws PropertyDetailsException {
		 //TODO Auto-generated method stub
		PropertyDetails propertyDetails = propertyDetailsDAO.findById(id).get();
		
		if(String.valueOf(propertyDetails.getPropertyId()) == null) {
			throw new PropertyDetailsException("Record not found");
		}
		
		GasStation gasStation = gasStationDAO.findById(propertyDetails.getPropertyId()).get();
		GasStationDetailsDTO gasStationDTO = new GasStationDetailsDTO();
		gasStationDTO.setId(gasStation.getId());
		gasStationDTO.setBrand(gasStation.getBrand());
		gasStationDTO.setFuelType(gasStation.getFuelType());
		gasStationDTO.setFrannchise(gasStation.getFrannchise());
		gasStationDTO.setNumberOfPumps(gasStation.getNumberOfPumps());
		gasStationDTO.setGasolineCapacity(gasStation.getGasolineCapacity());
		gasStationDTO.setDiselCapacity(gasStation.getDiselCapacity());
		gasStationDTO.setStoreBrand(gasStation.getStoreBrand());
		gasStationDTO.setStoreApproxInventoryCost(gasStation.getStoreApproxInventoryCost());
		gasStationDTO.setFoodCourtSeatingCapacity(gasStation.getFoodCourtSeatingCapacity());
		gasStationDTO.setCarWashEquipCost(gasStation.getCarWashEquipCost());
		gasStationDTO.setAtm(gasStation.getAtm());
		gasStationDTO.setRestroom(gasStation.getRestroom());
		gasStationDTO.setLotSize(gasStation.getLotSize());
		gasStationDTO.setLotSize(gasStation.getLotSize());
		gasStationDTO.setNumberOfParking(gasStation.getNumberOfParking());
		gasStationDTO.setFireEquip(gasStation.getFireEquip());
		gasStationDTO.setFireCapacity(gasStation.getFireCapacity());
		gasStationDTO.setAutoSupplyRepairMaintShop(gasStation.getAutoSupplyRepairMaintShop());
		List<PropertyImages> propertyImages = propertImagesDAO.findByPropertyDetailsId(propertyDetails.getId());
		gasStationDTO.setPropertyImages(propertyImages);
		gasStationDTO.setPropertyMetaData(propertyDetails);
		return gasStationDTO;
		
	}
	
	@Override
	public GasStationDetailsDTO saveGasStationPropertyDetail(GasStationDetailsDTO gasStationDetailsDTO) throws PropertyDetailsException {
		// TODO Auto-generated method stub
		
		
		GasStation gasStationDetails = new GasStation();
		gasStationDetails.setBrand(gasStationDetailsDTO.getBrand());
		gasStationDetails.setFuelType(gasStationDetailsDTO.getFuelType());
		gasStationDetails.setFrannchise(gasStationDetailsDTO.getFrannchise());
		gasStationDetails.setNumberOfPumps(gasStationDetailsDTO.getNumberOfPumps());
		gasStationDetails.setGasolineCapacity(gasStationDetailsDTO.getGasolineCapacity());
		gasStationDetails.setDiselCapacity(gasStationDetailsDTO.getDiselCapacity());
		gasStationDetails.setStoreBrand(gasStationDetailsDTO.getStoreBrand());
		gasStationDetails.setStoreApproxInventoryCost(gasStationDetailsDTO.getStoreApproxInventoryCost());
		gasStationDetails.setFoodCourtSeatingCapacity(gasStationDetailsDTO.getFoodCourtSeatingCapacity());
		gasStationDetails.setCarWashEquipCost(gasStationDetailsDTO.getCarWashEquipCost());
		gasStationDetails.setAtm(gasStationDetailsDTO.getAtm());
		gasStationDetails.setRestroom(gasStationDetailsDTO.getRestroom());
		gasStationDetails.setLotSize(gasStationDetailsDTO.getLotSize());
		gasStationDetails.setLotSize(gasStationDetailsDTO.getLotSize());
		gasStationDetails.setNumberOfParking(gasStationDetailsDTO.getNumberOfParking());
		gasStationDetails.setFireEquip(gasStationDetailsDTO.getFireEquip());
		gasStationDetails.setFireCapacity(gasStationDetailsDTO.getFireCapacity());
		gasStationDetails.setAutoSupplyRepairMaintShop(gasStationDetailsDTO.getAutoSupplyRepairMaintShop());
		
		
		List<PropertyDetails> propertyList = (List<PropertyDetails>) propertyDetailsDAO.findByPropertyName(gasStationDetailsDTO.getPropertyMetaData().getPropertyName());
		PropertyDetails property = null;
		GasStation gasStation = null;
		
		
		
		PropertyDetails propertyDetails = gasStationDetailsDTO.getPropertyMetaData();
		
		
		if(!propertyList.isEmpty()) {
			property = propertyList.get(0);
			throw new PropertyDetailsException("Duplicate record");
		} else {			
			gasStation = gasStationDAO.save(gasStationDetails);
			propertyDetails.setPropertyId(gasStation.getId());
			propertyDetails.setBusinessTypeCode("b_type_2");
			propertyDetails.setPropertyCode(null);
			property = propertyDetailsDAO.save(propertyDetails);
		}
		
		GasStationDetailsDTO gasStationDTO = new GasStationDetailsDTO();
		gasStationDTO.setId(gasStation.getId());
		gasStationDTO.setBrand(gasStation.getBrand());
		gasStationDTO.setFuelType(gasStation.getFuelType());
		gasStationDTO.setFrannchise(gasStation.getFrannchise());
		gasStationDTO.setNumberOfPumps(gasStation.getNumberOfPumps());
		gasStationDTO.setGasolineCapacity(gasStation.getGasolineCapacity());
		gasStationDTO.setDiselCapacity(gasStation.getDiselCapacity());
		gasStationDTO.setStoreBrand(gasStation.getStoreBrand());
		gasStationDTO.setStoreApproxInventoryCost(gasStation.getStoreApproxInventoryCost());
		gasStationDTO.setFoodCourtSeatingCapacity(gasStation.getFoodCourtSeatingCapacity());
		gasStationDTO.setCarWashEquipCost(gasStation.getCarWashEquipCost());
		gasStationDTO.setAtm(gasStation.getAtm());
		gasStationDTO.setRestroom(gasStation.getRestroom());
		gasStationDTO.setLotSize(gasStation.getLotSize());
		gasStationDTO.setLotSize(gasStation.getLotSize());
		gasStationDTO.setNumberOfParking(gasStation.getNumberOfParking());
		gasStationDTO.setFireEquip(gasStation.getFireEquip());
		gasStationDTO.setFireCapacity(gasStation.getFireCapacity());
		gasStationDTO.setAutoSupplyRepairMaintShop(gasStation.getAutoSupplyRepairMaintShop());
		
		gasStationDTO.setPropertyMetaData(property);
		
		return gasStationDTO;
	}

	@Override
	public RestaurantDetailsDTO getRestaurantPropertyDetails(int id) throws PropertyDetailsException {
		// TODO Auto-generated method stub
		PropertyDetails propertyDetails = propertyDetailsDAO.findById(id).get();		
		if( String.valueOf(propertyDetails.getPropertyId()) == null) {
			throw new PropertyDetailsException("Record not found");
		}
		Restaurant restaurant = restaurentDAO.findById(propertyDetails.getPropertyId()).get();
		RestaurantDetailsDTO restaurantDetailsDTO = new RestaurantDetailsDTO();
		restaurantDetailsDTO.setId(restaurant.getId());
		restaurantDetailsDTO.setType(restaurant.getType());
		restaurantDetailsDTO.setDescription(restaurant.getDescription());
		restaurantDetailsDTO.setIndoorSeatingCapacity(restaurant.getIndoorSeatingCapacity());
		restaurantDetailsDTO.setOutdoorSeatingCapacity(restaurant.getOutdoorSeatingCapacity());
		restaurantDetailsDTO.setKitchenHoodSize(restaurant.getKitchenHoodSize());
		restaurantDetailsDTO.setKitchenSqft(restaurant.getKitchenSqft());
		restaurantDetailsDTO.setAvailableAppliances(restaurant.getAvailableAppliances());
		restaurantDetailsDTO.setDishWasher(restaurant.getDishWasher());
		restaurantDetailsDTO.setOven(restaurant.getOven());
		restaurantDetailsDTO.setCookingRange(restaurant.getCookingRange());
		restaurantDetailsDTO.setFryers(restaurant.getFryers());
		restaurantDetailsDTO.setTotalCostUtensils(restaurant.getTotalCostUtensils());
		restaurantDetailsDTO.setInteriorSqft(restaurant.getInteriorSqft());
		restaurantDetailsDTO.setInteriorSeatingArrangement(restaurant.getInteriorSeatingArrangement());
		restaurantDetailsDTO.setInteriorCost(restaurant.getInteriorCost());
		restaurantDetailsDTO.setInteriorFeatures(restaurant.getInteriorFeatures());
		restaurantDetailsDTO.setInteriorElectronics(restaurant.getInteriorElectronics());
		restaurantDetailsDTO.setInteriorRestrooms(restaurant.getInteriorRestrooms());
		restaurantDetailsDTO.setInteriorRestroomsADA(restaurant.getInteriorRestroomsADA());
		restaurantDetailsDTO.setBarType(restaurant.getBarType());
		restaurantDetailsDTO.setBarSeatingCapacity(restaurant.getBarSeatingCapacity());
		restaurantDetailsDTO.setLastRenovationDate(restaurant.getLastRenovationDate());
		restaurantDetailsDTO.setCondition(restaurant.getCondition());
		restaurantDetailsDTO.setWaitingArea(restaurant.getWaitingArea());
		restaurantDetailsDTO.setDryStorage(restaurant.getDryStorage());
		restaurantDetailsDTO.setExteriorType(restaurant.getExteriorType());
		restaurantDetailsDTO.setParking(restaurant.getParking());
		restaurantDetailsDTO.setSecurity(restaurant.getSecurity());
		restaurantDetailsDTO.setSurroundingBusiness(restaurant.getSurroundingBusiness());
		restaurantDetailsDTO.setMonthlyRent(restaurant.getMonthlyRent());
		restaurantDetailsDTO.setNnnExpense(restaurant.getNnnExpense());
		restaurantDetailsDTO.setGarbageExpense(restaurant.getGarbageExpense());
		restaurantDetailsDTO.setUtilitiesExpense(restaurant.getUtilitiesExpense());
		restaurantDetailsDTO.setResidentialArea(restaurant.getResidentialArea());
		restaurantDetailsDTO.setWikiDemoLink(restaurant.getWikiDemoLink());
		restaurantDetailsDTO.setWalkscore(restaurant.getWalkscore());
		restaurantDetailsDTO.setAvgAge(restaurant.getAvgAge());
		restaurantDetailsDTO.setAvgIncome(restaurant.getAvgIncome());
		restaurantDetailsDTO.setCrimeIndicator(restaurant.getCrimeIndicator());
		restaurantDetailsDTO.setAvgRevenueInResto(restaurant.getAvgRevenueInResto());
		restaurantDetailsDTO.setAvgRevenueToGo(restaurant.getAvgRevenueToGo());
		restaurantDetailsDTO.setAvgRevenueCatering(restaurant.getAvgRevenueCatering());
		restaurantDetailsDTO.setAvgTevenueLiquer(restaurant.getAvgTevenueLiquer());
		restaurantDetailsDTO.setTotal_emp(restaurant.getTotal_emp());
		restaurantDetailsDTO.setCertified_emp(restaurant.getCertified_emp());
		restaurantDetailsDTO.setFulltime_emp(restaurant.getFulltime_emp());
		restaurantDetailsDTO.setParttiem_emp(restaurant.getParttime_emp());
		
		restaurantDetailsDTO.setPropertyMetaData(propertyDetails);
		
		List<PropertyImages> propertyImages = propertImagesDAO.findByPropertyDetailsId(propertyDetails.getId());
		restaurantDetailsDTO.setPropertyImages(propertyImages);
		
		return restaurantDetailsDTO;
	}

	@Override
	public RestaurantDetailsDTO saveRestaurantPropertyDetail(RestaurantDetailsDTO restaurantDetailsDTO)
			throws PropertyDetailsException {
		// TODO Auto-generated method stub
		Restaurant restaurant = new Restaurant();
		restaurant.setType(restaurantDetailsDTO.getType());
		restaurant.setDescription(restaurantDetailsDTO.getDescription());
		restaurant.setType(restaurantDetailsDTO.getType());
		restaurant.setDescription(restaurantDetailsDTO.getDescription());
		restaurant.setIndoorSeatingCapacity(restaurantDetailsDTO.getIndoorSeatingCapacity());
		restaurant.setOutdoorSeatingCapacity(restaurantDetailsDTO.getOutdoorSeatingCapacity());
		restaurant.setKitchenHoodSize(restaurantDetailsDTO.getKitchenHoodSize());
		restaurant.setKitchenSqft(restaurantDetailsDTO.getKitchenSqft());
		restaurant.setAvailableAppliances(restaurantDetailsDTO.getAvailableAppliances());
		restaurant.setDishWasher(restaurantDetailsDTO.getDishWasher());
		restaurant.setOven(restaurantDetailsDTO.getOven());
		restaurant.setCookingRange(restaurantDetailsDTO.getCookingRange());
		restaurant.setFryers(restaurantDetailsDTO.getFryers());
		restaurant.setTotalCostUtensils(restaurantDetailsDTO.getTotalCostUtensils());
		restaurant.setInteriorSqft(restaurantDetailsDTO.getInteriorSqft());
		restaurant.setInteriorSeatingArrangement(restaurantDetailsDTO.getInteriorSeatingArrangement());
		restaurant.setInteriorCost(restaurantDetailsDTO.getInteriorCost());
		restaurant.setInteriorFeatures(restaurantDetailsDTO.getInteriorFeatures());
		restaurant.setInteriorElectronics(restaurantDetailsDTO.getInteriorElectronics());
		restaurant.setInteriorRestrooms(restaurantDetailsDTO.getInteriorRestrooms());
		restaurant.setInteriorRestroomsADA(restaurantDetailsDTO.getInteriorRestroomsADA());
		restaurant.setBarType(restaurantDetailsDTO.getBarType());
		restaurant.setBarSeatingCapacity(restaurantDetailsDTO.getBarSeatingCapacity());
		restaurant.setLastRenovationDate(restaurantDetailsDTO.getLastRenovationDate());
		restaurant.setCondition(restaurantDetailsDTO.getCondition());
		restaurant.setWaitingArea(restaurantDetailsDTO.getWaitingArea());
		restaurant.setDryStorage(restaurantDetailsDTO.getDryStorage());
		restaurant.setExteriorType(restaurantDetailsDTO.getExteriorType());
		restaurant.setParking(restaurantDetailsDTO.getParking());
		restaurant.setSecurity(restaurantDetailsDTO.getSecurity());
		restaurant.setSurroundingBusiness(restaurantDetailsDTO.getSurroundingBusiness());
		restaurant.setMonthlyRent(restaurantDetailsDTO.getMonthlyRent());
		restaurant.setNnnExpense(restaurantDetailsDTO.getNnnExpense());
		restaurant.setGarbageExpense(restaurantDetailsDTO.getGarbageExpense());
		restaurant.setUtilitiesExpense(restaurantDetailsDTO.getUtilitiesExpense());
		restaurant.setResidentialArea(restaurantDetailsDTO.getResidentialArea());
		restaurant.setWikiDemoLink(restaurantDetailsDTO.getWikiDemoLink());
		restaurant.setWalkscore(restaurantDetailsDTO.getWalkscore());
		restaurant.setAvgAge(restaurantDetailsDTO.getAvgAge());
		restaurant.setAvgIncome(restaurantDetailsDTO.getAvgIncome());
		restaurant.setCrimeIndicator(restaurantDetailsDTO.getCrimeIndicator());
		restaurant.setAvgRevenueInResto(restaurantDetailsDTO.getAvgRevenueInResto());
		restaurant.setAvgRevenueToGo(restaurantDetailsDTO.getAvgRevenueToGo());
		restaurant.setAvgRevenueCatering(restaurantDetailsDTO.getAvgRevenueCatering());
		restaurant.setAvgTevenueLiquer(restaurantDetailsDTO.getAvgTevenueLiquer());
		restaurant.setTotal_emp(restaurantDetailsDTO.getTotal_emp());
		restaurant.setCertified_emp(restaurantDetailsDTO.getCertified_emp());
		restaurant.setFulltime_emp(restaurantDetailsDTO.getFulltime_emp());
		restaurant.setParttime_emp(restaurantDetailsDTO.getParttiem_emp());
		
		List<PropertyDetails> propertyList = (List<PropertyDetails>) propertyDetailsDAO.findByPropertyName(restaurantDetailsDTO.getPropertyMetaData().getPropertyName());
		PropertyDetails property = null;
		
		PropertyDetails propertyDetails = restaurantDetailsDTO.getPropertyMetaData();
		
		if(!propertyList.isEmpty()) {
			property = propertyList.get(0);
			throw new PropertyDetailsException("Duplicate record");
		} else {			
			restaurant = restaurentDAO.save(restaurant);
			propertyDetails.setPropertyId(restaurant.getId());
			propertyDetails.setBusinessTypeCode("b_type_1");
			propertyDetails.setPropertyCode(null);
			property = propertyDetailsDAO.save(propertyDetails);
		}
		restaurantDetailsDTO.setId(restaurant.getId());
		restaurantDetailsDTO.setPropertyMetaData(property);
		
		return restaurantDetailsDTO;
	}

	@Override
	public GasStationDetailsDTO updateGasStationPropertyDetail(GasStationDetailsDTO gasStationDetailsDTO)
			throws PropertyDetailsException {

		if(Integer.toString(gasStationDetailsDTO.getId()) == null ) {
			throw new PropertyDetailsException("Record not found");
		}
		GasStation gasStationDetails = new GasStation();
		gasStationDetails.setId(gasStationDetailsDTO.getId());
		gasStationDetails.setBrand(gasStationDetailsDTO.getBrand());
		gasStationDetails.setFuelType(gasStationDetailsDTO.getFuelType());
		gasStationDetails.setFrannchise(gasStationDetailsDTO.getFrannchise());
		gasStationDetails.setNumberOfPumps(gasStationDetailsDTO.getNumberOfPumps());
		gasStationDetails.setGasolineCapacity(gasStationDetailsDTO.getGasolineCapacity());
		gasStationDetails.setDiselCapacity(gasStationDetailsDTO.getDiselCapacity());
		gasStationDetails.setStoreBrand(gasStationDetailsDTO.getStoreBrand());
		gasStationDetails.setStoreApproxInventoryCost(gasStationDetailsDTO.getStoreApproxInventoryCost());
		gasStationDetails.setFoodCourtSeatingCapacity(gasStationDetailsDTO.getFoodCourtSeatingCapacity());
		gasStationDetails.setCarWashEquipCost(gasStationDetailsDTO.getCarWashEquipCost());
		gasStationDetails.setAtm(gasStationDetailsDTO.getAtm());
		gasStationDetails.setRestroom(gasStationDetailsDTO.getRestroom());
		gasStationDetails.setLotSize(gasStationDetailsDTO.getLotSize());
		gasStationDetails.setLotSize(gasStationDetailsDTO.getLotSize());
		gasStationDetails.setNumberOfParking(gasStationDetailsDTO.getNumberOfParking());
		gasStationDetails.setFireEquip(gasStationDetailsDTO.getFireEquip());
		gasStationDetails.setFireCapacity(gasStationDetailsDTO.getFireCapacity());
		gasStationDetails.setAutoSupplyRepairMaintShop(gasStationDetailsDTO.getAutoSupplyRepairMaintShop());
		
		gasStationDetails = gasStationDAO.save(gasStationDetails);
		
		PropertyDetails propertyDetails = gasStationDetailsDTO.getPropertyMetaData();
		
		if( String.valueOf(propertyDetails.getPropertyId()) == null) {
			throw new PropertyDetailsException("Record not found");
		}
		
		propertyDetails = propertyDetailsDAO.save(propertyDetails);
		
		GasStationDetailsDTO gasStationDTO = new GasStationDetailsDTO();
		gasStationDTO.setId(gasStationDetails.getId());
		gasStationDTO.setBrand(gasStationDetails.getBrand());
		gasStationDTO.setFuelType(gasStationDetails.getFuelType());
		gasStationDTO.setFrannchise(gasStationDetails.getFrannchise());
		gasStationDTO.setNumberOfPumps(gasStationDetails.getNumberOfPumps());
		gasStationDTO.setGasolineCapacity(gasStationDetails.getGasolineCapacity());
		gasStationDTO.setDiselCapacity(gasStationDetails.getDiselCapacity());
		gasStationDTO.setStoreBrand(gasStationDetails.getStoreBrand());
		gasStationDTO.setStoreApproxInventoryCost(gasStationDetails.getStoreApproxInventoryCost());
		gasStationDTO.setFoodCourtSeatingCapacity(gasStationDetails.getFoodCourtSeatingCapacity());
		gasStationDTO.setCarWashEquipCost(gasStationDetails.getCarWashEquipCost());
		gasStationDTO.setAtm(gasStationDetails.getAtm());
		gasStationDTO.setRestroom(gasStationDetails.getRestroom());
		gasStationDTO.setLotSize(gasStationDetails.getLotSize());
		gasStationDTO.setLotSize(gasStationDetails.getLotSize());
		gasStationDTO.setNumberOfParking(gasStationDetails.getNumberOfParking());
		gasStationDTO.setFireEquip(gasStationDetails.getFireEquip());
		gasStationDTO.setFireCapacity(gasStationDetails.getFireCapacity());
		gasStationDTO.setAutoSupplyRepairMaintShop(gasStationDetails.getAutoSupplyRepairMaintShop());
		
		gasStationDTO.setPropertyMetaData(propertyDetails);
		
		return gasStationDTO;
	}

	@Override
	public RestaurantDetailsDTO updateRestaurantPropertyDetail(RestaurantDetailsDTO restaurantDetailsDTO)
			throws PropertyDetailsException {
		Restaurant restaurant = new Restaurant();
		restaurant.setId(restaurantDetailsDTO.getId());
		restaurant.setType(restaurantDetailsDTO.getType());
		restaurant.setDescription(restaurantDetailsDTO.getDescription());
		restaurant.setType(restaurantDetailsDTO.getType());
		restaurant.setDescription(restaurantDetailsDTO.getDescription());
		restaurant.setIndoorSeatingCapacity(restaurantDetailsDTO.getIndoorSeatingCapacity());
		restaurant.setOutdoorSeatingCapacity(restaurantDetailsDTO.getOutdoorSeatingCapacity());
		restaurant.setKitchenHoodSize(restaurantDetailsDTO.getKitchenHoodSize());
		restaurant.setKitchenSqft(restaurantDetailsDTO.getKitchenSqft());
		restaurant.setAvailableAppliances(restaurantDetailsDTO.getAvailableAppliances());
		restaurant.setDishWasher(restaurantDetailsDTO.getDishWasher());
		restaurant.setOven(restaurantDetailsDTO.getOven());
		restaurant.setCookingRange(restaurantDetailsDTO.getCookingRange());
		restaurant.setFryers(restaurantDetailsDTO.getFryers());
		restaurant.setTotalCostUtensils(restaurantDetailsDTO.getTotalCostUtensils());
		restaurant.setInteriorSqft(restaurantDetailsDTO.getInteriorSqft());
		restaurant.setInteriorSeatingArrangement(restaurantDetailsDTO.getInteriorSeatingArrangement());
		restaurant.setInteriorCost(restaurantDetailsDTO.getInteriorCost());
		restaurant.setInteriorFeatures(restaurantDetailsDTO.getInteriorFeatures());
		restaurant.setInteriorElectronics(restaurantDetailsDTO.getInteriorElectronics());
		restaurant.setInteriorRestrooms(restaurantDetailsDTO.getInteriorRestrooms());
		restaurant.setInteriorRestroomsADA(restaurantDetailsDTO.getInteriorRestroomsADA());
		restaurant.setBarType(restaurantDetailsDTO.getBarType());
		restaurant.setBarSeatingCapacity(restaurantDetailsDTO.getBarSeatingCapacity());
		restaurant.setLastRenovationDate(restaurantDetailsDTO.getLastRenovationDate());
		restaurant.setCondition(restaurantDetailsDTO.getCondition());
		restaurant.setWaitingArea(restaurantDetailsDTO.getWaitingArea());
		restaurant.setDryStorage(restaurantDetailsDTO.getDryStorage());
		restaurant.setExteriorType(restaurantDetailsDTO.getExteriorType());
		restaurant.setParking(restaurantDetailsDTO.getParking());
		restaurant.setSecurity(restaurantDetailsDTO.getSecurity());
		restaurant.setSurroundingBusiness(restaurantDetailsDTO.getSurroundingBusiness());
		restaurant.setMonthlyRent(restaurantDetailsDTO.getMonthlyRent());
		restaurant.setNnnExpense(restaurantDetailsDTO.getNnnExpense());
		restaurant.setGarbageExpense(restaurantDetailsDTO.getGarbageExpense());
		restaurant.setUtilitiesExpense(restaurantDetailsDTO.getUtilitiesExpense());
		restaurant.setResidentialArea(restaurantDetailsDTO.getResidentialArea());
		restaurant.setWikiDemoLink(restaurantDetailsDTO.getWikiDemoLink());
		restaurant.setWalkscore(restaurantDetailsDTO.getWalkscore());
		restaurant.setAvgAge(restaurantDetailsDTO.getAvgAge());
		restaurant.setAvgIncome(restaurantDetailsDTO.getAvgIncome());
		restaurant.setCrimeIndicator(restaurantDetailsDTO.getCrimeIndicator());
		restaurant.setAvgRevenueInResto(restaurantDetailsDTO.getAvgRevenueInResto());
		restaurant.setAvgRevenueToGo(restaurantDetailsDTO.getAvgRevenueToGo());
		restaurant.setAvgRevenueCatering(restaurantDetailsDTO.getAvgRevenueCatering());
		restaurant.setAvgTevenueLiquer(restaurantDetailsDTO.getAvgTevenueLiquer());
		restaurant.setTotal_emp(restaurantDetailsDTO.getTotal_emp());
		restaurant.setCertified_emp(restaurantDetailsDTO.getCertified_emp());
		restaurant.setFulltime_emp(restaurantDetailsDTO.getFulltime_emp());
		restaurant.setParttime_emp(restaurantDetailsDTO.getParttiem_emp());
		
		PropertyDetails property = null;
		
		PropertyDetails propertyDetails = restaurantDetailsDTO.getPropertyMetaData();
					
		restaurant = restaurentDAO.save(restaurant);
		property = propertyDetailsDAO.save(propertyDetails);
		
		restaurantDetailsDTO.setPropertyMetaData(property);
		
		return restaurantDetailsDTO;
	}

	@Override
	public CoinLaundryDetailsDTO getCoinLaundryPropertyDetails(int id) throws PropertyDetailsException {
		// TODO Auto-generated method stub
				PropertyDetails propertyDetails = propertyDetailsDAO.findById(id).get();		
				if( String.valueOf(propertyDetails.getPropertyId()) == null) {
					throw new PropertyDetailsException("Record not found");
				}
				
				CoinLaundry coinLaundry = coinLaundryDAO.findById(propertyDetails.getPropertyId()).get();
				CoinLaundryDetailsDTO coinLaundryDetailsDTO = new CoinLaundryDetailsDTO();
				coinLaundryDetailsDTO.setId(coinLaundry.getId());
				coinLaundryDetailsDTO.setNumberOfWashers(coinLaundry.getNumberOfWashers());
				coinLaundryDetailsDTO.setNumberOfDryers(coinLaundry.getNumberOfDryers());
				coinLaundryDetailsDTO.setCostOfEquip(coinLaundry.getCostOfEquip());
				coinLaundryDetailsDTO.setFeatures(coinLaundry.getFeatures());
				coinLaundryDetailsDTO.setRestrooms(coinLaundry.getRestrooms());
				coinLaundryDetailsDTO.setSupplies(coinLaundry.getSupplies());
				coinLaundryDetailsDTO.setCoinDispensers(coinLaundry.getCoinDispensers());
				coinLaundryDetailsDTO.setSeatingCapacity(coinLaundry.getSeatingCapacity());
				coinLaundryDetailsDTO.setTotalSqft(coinLaundry.getTotalSqft());
				coinLaundryDetailsDTO.setCounterSpace(coinLaundry.getCounterSpace());
				coinLaundryDetailsDTO.setCarts(coinLaundry.getCarts());
				coinLaundryDetailsDTO.setWaterFactor(coinLaundry.getWaterFactor());
				coinLaundryDetailsDTO.setUtilities(coinLaundry.getUtilities());
				coinLaundryDetailsDTO.setDemographicsPopulation(coinLaundry.getDemographicsPopulation());
				coinLaundryDetailsDTO.setMaintenanceContracts(coinLaundry.getMaintenanceContracts());
				coinLaundryDetailsDTO.setMachinManufactures(coinLaundry.getMachinManufactures());
				coinLaundryDetailsDTO.setMachineEfficiences(coinLaundry.getMachineEfficiences());
				coinLaundryDetailsDTO.setMachineLifespan(coinLaundry.getMachineLifespan());
				coinLaundryDetailsDTO.setAssociationWithOthers(coinLaundry.getAssociationWithOthers());
				coinLaundryDetailsDTO.setPropertyMetaData(propertyDetails);
				
				
				List<PropertyImages> propertyImages = propertImagesDAO.findByPropertyDetailsId(propertyDetails.getId());
				coinLaundryDetailsDTO.setPropertyImages(propertyImages);
				
				return coinLaundryDetailsDTO;
	}

	@Override
	public CoinLaundryDetailsDTO saveCoinLaundryPropertyDetail(CoinLaundryDetailsDTO coinLaundryDetailsDTO)
			throws PropertyDetailsException {

		
		CoinLaundry coinLaundry = new CoinLaundry();
		coinLaundry.setNumberOfWashers(coinLaundryDetailsDTO.getNumberOfDryers());
		coinLaundry.setNumberOfDryers(coinLaundryDetailsDTO.getNumberOfDryers());
		coinLaundry.setCostOfEquip(coinLaundryDetailsDTO.getCostOfEquip());
		coinLaundry.setFeatures(coinLaundryDetailsDTO.getFeatures());
		coinLaundry.setRestrooms(coinLaundryDetailsDTO.getRestrooms());
		coinLaundry.setSupplies(coinLaundryDetailsDTO.getSupplies());
		coinLaundry.setCoinDispensers(coinLaundryDetailsDTO.getCoinDispensers());
		coinLaundry.setSeatingCapacity(coinLaundryDetailsDTO.getSeatingCapacity());
		coinLaundry.setTotalSqft(coinLaundryDetailsDTO.getTotalSqft());
		coinLaundry.setCounterSpace(coinLaundryDetailsDTO.getCounterSpace());
		coinLaundry.setCarts(coinLaundryDetailsDTO.getCarts());
		coinLaundry.setWaterFactor(coinLaundryDetailsDTO.getWaterFactor());
		coinLaundry.setUtilities(coinLaundryDetailsDTO.getUtilities());
		coinLaundry.setDemographicsPopulation(coinLaundryDetailsDTO.getDemographicsPopulation());
		coinLaundry.setMaintenanceContracts(coinLaundryDetailsDTO.getMaintenanceContracts());
		coinLaundry.setMachinManufactures(coinLaundryDetailsDTO.getMachinManufactures());
		coinLaundry.setMachineEfficiences(coinLaundryDetailsDTO.getMachineEfficiences());
		coinLaundry.setMachineLifespan(coinLaundryDetailsDTO.getMachineLifespan());
		coinLaundry.setAssociationWithOthers(coinLaundryDetailsDTO.getAssociationWithOthers());
		
		
		List<PropertyDetails> propertyList = (List<PropertyDetails>) propertyDetailsDAO.findByPropertyName(coinLaundryDetailsDTO.getPropertyMetaData().getPropertyName());
		PropertyDetails property = null;
		
		PropertyDetails propertyDetails = coinLaundryDetailsDTO.getPropertyMetaData();
		
		if(!propertyList.isEmpty()) {
			property = propertyList.get(0);
			throw new PropertyDetailsException("Duplicate record");
		} else {			
			coinLaundry = coinLaundryDAO.save(coinLaundry);
			propertyDetails.setPropertyId(coinLaundry.getId());
			propertyDetails.setBusinessTypeCode("b_type_7");
			propertyDetails.setPropertyCode(null);
			property = propertyDetailsDAO.save(propertyDetails);
		}
		coinLaundryDetailsDTO.setId(coinLaundry.getId());
		coinLaundryDetailsDTO.setPropertyMetaData(property);
		
		return coinLaundryDetailsDTO;
	}

	@Override
	public CoinLaundryDetailsDTO updateCoinLaundryPropertyDetail(CoinLaundryDetailsDTO coinLaundryDetailsDTO)
			throws PropertyDetailsException {

		CoinLaundry coinLaundry = new CoinLaundry();
		coinLaundry.setId(coinLaundryDetailsDTO.getId());
		coinLaundry.setNumberOfWashers(coinLaundryDetailsDTO.getNumberOfDryers());
		coinLaundry.setNumberOfDryers(coinLaundryDetailsDTO.getNumberOfDryers());
		coinLaundry.setCostOfEquip(coinLaundryDetailsDTO.getCostOfEquip());
		coinLaundry.setFeatures(coinLaundryDetailsDTO.getFeatures());
		coinLaundry.setRestrooms(coinLaundryDetailsDTO.getRestrooms());
		coinLaundry.setSupplies(coinLaundryDetailsDTO.getSupplies());
		coinLaundry.setCoinDispensers(coinLaundryDetailsDTO.getCoinDispensers());
		coinLaundry.setSeatingCapacity(coinLaundryDetailsDTO.getSeatingCapacity());
		coinLaundry.setTotalSqft(coinLaundryDetailsDTO.getTotalSqft());
		coinLaundry.setCounterSpace(coinLaundryDetailsDTO.getCounterSpace());
		coinLaundry.setCarts(coinLaundryDetailsDTO.getCarts());
		coinLaundry.setWaterFactor(coinLaundryDetailsDTO.getWaterFactor());
		coinLaundry.setUtilities(coinLaundryDetailsDTO.getUtilities());
		coinLaundry.setDemographicsPopulation(coinLaundryDetailsDTO.getDemographicsPopulation());
		coinLaundry.setMaintenanceContracts(coinLaundryDetailsDTO.getMaintenanceContracts());
		coinLaundry.setMachinManufactures(coinLaundryDetailsDTO.getMachinManufactures());
		coinLaundry.setMachineEfficiences(coinLaundryDetailsDTO.getMachineEfficiences());
		coinLaundry.setMachineLifespan(coinLaundryDetailsDTO.getMachineLifespan());
		coinLaundry.setAssociationWithOthers(coinLaundryDetailsDTO.getAssociationWithOthers());
		
		PropertyDetails property = null;
		
		PropertyDetails propertyDetails = coinLaundryDetailsDTO.getPropertyMetaData();
					
		coinLaundry = coinLaundryDAO.save(coinLaundry);
		property = propertyDetailsDAO.save(propertyDetails);
		
		coinLaundryDetailsDTO.setPropertyMetaData(property);
		
		return coinLaundryDetailsDTO;
	}
	
	@Override
	public LiquorStoreDTO getLiquerStorePropertyDetails(int id) throws PropertyDetailsException {
		// TODO Auto-generated method stub
				PropertyDetails propertyDetails = propertyDetailsDAO.findById(id).get();		
				if( String.valueOf(propertyDetails.getPropertyId()) == null) {
					throw new PropertyDetailsException("Record not found");
				}
				
				LiquorStore liquorStore = liquorStoreDAO.findById(propertyDetails.getPropertyId()).get();
				
				LiquorStoreDTO liquorStoreDTO = new LiquorStoreDTO();
				
				liquorStoreDTO.setId(liquorStore.getId());
				liquorStoreDTO.setApprInventoryCost(liquorStore.getApprInventoryCost());
				liquorStoreDTO.setAtmMachine(liquorStore.getAtmMachine());
				liquorStoreDTO.setStorageSqft(liquorStore.getStorageSqft());
				liquorStoreDTO.setDrinksCabinets(liquorStore.getDrinksCabinets());
				liquorStoreDTO.setVendingMachine(liquorStore.getVendingMachine());
				liquorStoreDTO.setGoodsCabinets(liquorStore.getGoodsCabinets());
				liquorStoreDTO.setResidentialArea(liquorStore.getResidentialArea());
				liquorStoreDTO.setDemographicLink(liquorStore.getDemographicLink());
				liquorStoreDTO.setWalkscore(liquorStore.getWalkscore());
				liquorStoreDTO.setAvgAge(liquorStore.getAvgAge());
				liquorStoreDTO.setAvgIncome(liquorStore.getAvgIncome());
				liquorStoreDTO.setCrimeIndcator(liquorStore.getCrimeIndcator());
				liquorStoreDTO.setAssociatedBusiness(liquorStore.getAssociatedBusiness());
				liquorStoreDTO.setConvenienceStore(liquorStore.getConvenienceStore());
				liquorStoreDTO.setFreshGoodsMarket(liquorStore.getFreshGoodsMarket());
				liquorStoreDTO.setAnchorBusiness(liquorStore.getAnchorBusiness());
				liquorStoreDTO.setShoppingComplexTrafficScore(liquorStore.getShoppingComplexTrafficScore());
				
				liquorStoreDTO.setPropertyMetaData(propertyDetails);
				
				
				List<PropertyImages> propertyImages = propertImagesDAO.findByPropertyDetailsId(propertyDetails.getId());
				liquorStoreDTO.setPropertyImages(propertyImages);
				
				return liquorStoreDTO;
	}

	@Override
	public LiquorStoreDTO saveLiquerStorePropertyDetail(LiquorStoreDTO liquorStoreDTO)
			throws PropertyDetailsException {
		LiquorStore liquorStore = new LiquorStore();
		liquorStore.setApprInventoryCost(liquorStoreDTO.getApprInventoryCost());
		liquorStore.setAtmMachine(liquorStoreDTO.getAtmMachine());
		liquorStore.setStorageSqft(liquorStoreDTO.getStorageSqft());
		liquorStore.setDrinksCabinets(liquorStoreDTO.getDrinksCabinets());
		liquorStore.setVendingMachine(liquorStoreDTO.getVendingMachine());
		liquorStore.setGoodsCabinets(liquorStoreDTO.getGoodsCabinets());
		liquorStore.setResidentialArea(liquorStoreDTO.getResidentialArea());
		liquorStore.setDemographicLink(liquorStoreDTO.getDemographicLink());
		liquorStore.setWalkscore(liquorStoreDTO.getWalkscore());
		liquorStore.setAvgAge(liquorStoreDTO.getAvgAge());
		liquorStore.setAvgIncome(liquorStoreDTO.getAvgIncome());
		liquorStore.setCrimeIndcator(liquorStoreDTO.getCrimeIndcator());
		liquorStore.setAssociatedBusiness(liquorStoreDTO.getAssociatedBusiness());
		liquorStore.setConvenienceStore(liquorStoreDTO.getConvenienceStore());
		liquorStore.setFreshGoodsMarket(liquorStoreDTO.getFreshGoodsMarket());
		liquorStore.setAnchorBusiness(liquorStoreDTO.getAnchorBusiness());
		liquorStore.setShoppingComplexTrafficScore(liquorStoreDTO.getShoppingComplexTrafficScore());
		
		
		List<PropertyDetails> propertyList = (List<PropertyDetails>) propertyDetailsDAO.findByPropertyName(liquorStoreDTO.getPropertyMetaData().getPropertyName());
		PropertyDetails property = null;
		
		PropertyDetails propertyDetails = liquorStoreDTO.getPropertyMetaData();
		
		if(!propertyList.isEmpty()) {
			property = propertyList.get(0);
			throw new PropertyDetailsException("Duplicate record");
		} else {			
			liquorStore = liquorStoreDAO.save(liquorStore);
			propertyDetails.setPropertyId(liquorStore.getId());
			propertyDetails.setBusinessTypeCode("b_type_3");
			propertyDetails.setPropertyCode(null);
			property = propertyDetailsDAO.save(propertyDetails);
		}
		liquorStoreDTO.setId(liquorStore.getId());
		liquorStoreDTO.setPropertyMetaData(property);
		
		return liquorStoreDTO;
	}

	@Override
	public LiquorStoreDTO updateLiquerStorePropertyDetail(LiquorStoreDTO liquorStoreDTO)
			throws PropertyDetailsException {
		
		LiquorStore liquorStore = new LiquorStore();
		liquorStore.setId(liquorStoreDTO.getId());
		liquorStore.setApprInventoryCost(liquorStoreDTO.getApprInventoryCost());
		liquorStore.setAtmMachine(liquorStoreDTO.getAtmMachine());
		liquorStore.setStorageSqft(liquorStoreDTO.getStorageSqft());
		liquorStore.setDrinksCabinets(liquorStoreDTO.getDrinksCabinets());
		liquorStore.setVendingMachine(liquorStoreDTO.getVendingMachine());
		liquorStore.setGoodsCabinets(liquorStoreDTO.getGoodsCabinets());
		liquorStore.setResidentialArea(liquorStoreDTO.getResidentialArea());
		liquorStore.setDemographicLink(liquorStoreDTO.getDemographicLink());
		liquorStore.setWalkscore(liquorStoreDTO.getWalkscore());
		liquorStore.setAvgAge(liquorStoreDTO.getAvgAge());
		liquorStore.setAvgIncome(liquorStoreDTO.getAvgIncome());
		liquorStore.setCrimeIndcator(liquorStoreDTO.getCrimeIndcator());
		liquorStore.setAssociatedBusiness(liquorStoreDTO.getAssociatedBusiness());
		liquorStore.setConvenienceStore(liquorStoreDTO.getConvenienceStore());
		liquorStore.setFreshGoodsMarket(liquorStoreDTO.getFreshGoodsMarket());
		liquorStore.setAnchorBusiness(liquorStoreDTO.getAnchorBusiness());
		liquorStore.setShoppingComplexTrafficScore(liquorStoreDTO.getShoppingComplexTrafficScore());
		
		
		PropertyDetails property = null;
		
		PropertyDetails propertyDetails = liquorStoreDTO.getPropertyMetaData();
					
		liquorStore = liquorStoreDAO.save(liquorStore);
		
		property = propertyDetailsDAO.save(propertyDetails);
		
		liquorStoreDTO.setPropertyMetaData(property);
		
		return liquorStoreDTO;
	}

	@Override
	public SalonStoreDTO getSalonStorePropertyDetails(int id) throws PropertyDetailsException {
		PropertyDetails propertyDetails = propertyDetailsDAO.findById(id).get();		
		if( String.valueOf(propertyDetails.getPropertyId()) == null) {
			throw new PropertyDetailsException("Record not found");
		}
		
		SalonStore salonStore = salonStoreDAO.findById(propertyDetails.getPropertyId()).get();
		
		SalonStoreDTO salonStoreDTO = new SalonStoreDTO();
		salonStoreDTO.setId(salonStore.getId());
		salonStoreDTO.setNailCare(salonStore.getNailCare());
		salonStoreDTO.setSkinCare(salonStore.getSkinCare());
		salonStoreDTO.setLashExtension(salonStore.getLashExtension());
		salonStoreDTO.setMassage(salonStore.getMassage());
		salonStoreDTO.setBodyTreatments(salonStore.getBodyTreatments());
		salonStoreDTO.setLocationOfspa(salonStore.getLocationOfspa());
		salonStoreDTO.setWalkscore(salonStore.getWalkscore());
		salonStoreDTO.setAvgAge(salonStore.getAvgAge());
		salonStoreDTO.setAvgIncome(salonStore.getAvgIncome());
		salonStoreDTO.setInteriorSqft(salonStore.getInteriorSqft());
		salonStoreDTO.setManicureTables(salonStore.getManicureTables());
		salonStoreDTO.setNailDryers(salonStore.getNailDryers());
		salonStoreDTO.setPortablePedicureSpa(salonStore.getPortablePedicureSpa());
		salonStoreDTO.setNailSalonTrolleys(salonStore.getNailSalonTrolleys());
		salonStoreDTO.setPedicureSpaChairs(salonStore.getPedicureSpaChairs());
		salonStoreDTO.setInteriorFeatures(salonStore.getInteriorFeatures());
		salonStoreDTO.setRestrooms(salonStore.getRestrooms());
		salonStoreDTO.setWaitingArea(salonStore.getWaitingArea());
		salonStoreDTO.setReceptionArea(salonStore.getReceptionArea());
		salonStoreDTO.setCapacity(salonStore.getCapacity());
		salonStoreDTO.setLastRenovation(salonStore.getLastRenovation());
		salonStoreDTO.setStaffRooms(salonStore.getStaffRooms());
		salonStoreDTO.setExteriorSignage(salonStore.getExteriorSignage());
		salonStoreDTO.setAnchorBusiness(salonStore.getAnchorBusiness());
		salonStoreDTO.setTypeOfBuilding(salonStore.getTypeOfBuilding());
		salonStoreDTO.setParking(salonStore.getParking());
		salonStoreDTO.setRent(salonStore.getRent());
		salonStoreDTO.setWater(salonStore.getWater());
		salonStoreDTO.setElectricity(salonStore.getElectricity());
		salonStoreDTO.setGarbage(salonStore.getGarbage());
		salonStoreDTO.setEmployee(salonStore.getEmployee());
		
		
		
		salonStoreDTO.setPropertyMetaData(propertyDetails);
		
		
		List<PropertyImages> propertyImages = propertImagesDAO.findByPropertyDetailsId(propertyDetails.getId());
		salonStoreDTO.setPropertyImages(propertyImages);
		
		return salonStoreDTO;
	}

	@Override
	public SalonStoreDTO saveSalonStorePropertyDetail(SalonStoreDTO salonStoreDTO) throws PropertyDetailsException {
		SalonStore salonStore = new SalonStore();
		salonStore.setNailCare(salonStoreDTO.getNailCare());
		salonStore.setSkinCare(salonStoreDTO.getSkinCare());
		salonStore.setLashExtension(salonStoreDTO.getLashExtension());
		salonStore.setMassage(salonStoreDTO.getMassage());
		salonStore.setBodyTreatments(salonStoreDTO.getBodyTreatments());
		salonStore.setLocationOfspa(salonStoreDTO.getLocationOfspa());
		salonStore.setWalkscore(salonStoreDTO.getWalkscore());
		salonStore.setAvgAge(salonStoreDTO.getAvgAge());
		salonStore.setAvgIncome(salonStoreDTO.getAvgIncome());
		salonStore.setInteriorSqft(salonStoreDTO.getInteriorSqft());
		salonStore.setManicureTables(salonStoreDTO.getManicureTables());
		salonStore.setNailDryers(salonStoreDTO.getNailDryers());
		salonStore.setPortablePedicureSpa(salonStoreDTO.getPortablePedicureSpa());
		salonStore.setNailSalonTrolleys(salonStoreDTO.getNailSalonTrolleys());
		salonStore.setPedicureSpaChairs(salonStoreDTO.getPedicureSpaChairs());
		salonStore.setInteriorFeatures(salonStoreDTO.getInteriorFeatures());
		salonStore.setRestrooms(salonStoreDTO.getRestrooms());
		salonStore.setWaitingArea(salonStoreDTO.getWaitingArea());
		salonStore.setReceptionArea(salonStoreDTO.getReceptionArea());
		salonStore.setCapacity(salonStoreDTO.getCapacity());
		salonStore.setLastRenovation(salonStoreDTO.getLastRenovation());
		salonStore.setStaffRooms(salonStoreDTO.getStaffRooms());
		salonStore.setExteriorSignage(salonStoreDTO.getExteriorSignage());
		salonStore.setAnchorBusiness(salonStoreDTO.getAnchorBusiness());
		salonStore.setTypeOfBuilding(salonStoreDTO.getTypeOfBuilding());
		salonStore.setParking(salonStoreDTO.getParking());
		salonStore.setRent(salonStoreDTO.getRent());
		salonStore.setWater(salonStoreDTO.getWater());
		salonStore.setElectricity(salonStoreDTO.getElectricity());
		salonStore.setGarbage(salonStoreDTO.getGarbage());
		salonStore.setEmployee(salonStoreDTO.getEmployee());
		
		
		
		List<PropertyDetails> propertyList = (List<PropertyDetails>) propertyDetailsDAO.findByPropertyName(salonStoreDTO.getPropertyMetaData().getPropertyName());
		PropertyDetails property = null;
		
		PropertyDetails propertyDetails = salonStoreDTO.getPropertyMetaData();
		
		if(!propertyList.isEmpty()) {
			property = propertyList.get(0);
			throw new PropertyDetailsException("Duplicate record");
		} else {			
			salonStore = salonStoreDAO.save(salonStore);
			propertyDetails.setPropertyId(salonStore.getId());
			propertyDetails.setBusinessTypeCode("b_type_3");
			propertyDetails.setPropertyCode(null);
			property = propertyDetailsDAO.save(propertyDetails);
		}
		salonStoreDTO.setId(salonStore.getId());
		salonStoreDTO.setPropertyMetaData(property);
		
		return salonStoreDTO;
	}

	@Override
	public SalonStoreDTO updateSalonStorePropertyDetail(SalonStoreDTO salonStoreDTO) throws PropertyDetailsException {
		
		SalonStore salonStore = new SalonStore();
		salonStore.setId(salonStoreDTO.getId());
		salonStore.setNailCare(salonStoreDTO.getNailCare());
		salonStore.setSkinCare(salonStoreDTO.getSkinCare());
		salonStore.setLashExtension(salonStoreDTO.getLashExtension());
		salonStore.setMassage(salonStoreDTO.getMassage());
		salonStore.setBodyTreatments(salonStoreDTO.getBodyTreatments());
		salonStore.setLocationOfspa(salonStoreDTO.getLocationOfspa());
		salonStore.setWalkscore(salonStoreDTO.getWalkscore());
		salonStore.setAvgAge(salonStoreDTO.getAvgAge());
		salonStore.setAvgIncome(salonStoreDTO.getAvgIncome());
		salonStore.setInteriorSqft(salonStoreDTO.getInteriorSqft());
		salonStore.setManicureTables(salonStoreDTO.getManicureTables());
		salonStore.setNailDryers(salonStoreDTO.getNailDryers());
		salonStore.setPortablePedicureSpa(salonStoreDTO.getPortablePedicureSpa());
		salonStore.setNailSalonTrolleys(salonStoreDTO.getNailSalonTrolleys());
		salonStore.setPedicureSpaChairs(salonStoreDTO.getPedicureSpaChairs());
		salonStore.setInteriorFeatures(salonStoreDTO.getInteriorFeatures());
		salonStore.setRestrooms(salonStoreDTO.getRestrooms());
		salonStore.setWaitingArea(salonStoreDTO.getWaitingArea());
		salonStore.setReceptionArea(salonStoreDTO.getReceptionArea());
		salonStore.setCapacity(salonStoreDTO.getCapacity());
		salonStore.setLastRenovation(salonStoreDTO.getLastRenovation());
		salonStore.setStaffRooms(salonStoreDTO.getStaffRooms());
		salonStore.setExteriorSignage(salonStoreDTO.getExteriorSignage());
		salonStore.setAnchorBusiness(salonStoreDTO.getAnchorBusiness());
		salonStore.setTypeOfBuilding(salonStoreDTO.getTypeOfBuilding());
		salonStore.setParking(salonStoreDTO.getParking());
		salonStore.setRent(salonStoreDTO.getRent());
		salonStore.setWater(salonStoreDTO.getWater());
		salonStore.setElectricity(salonStoreDTO.getElectricity());
		salonStore.setGarbage(salonStoreDTO.getGarbage());
		salonStore.setEmployee(salonStoreDTO.getEmployee());
		
		
		
		
		PropertyDetails property = null;
		
		PropertyDetails propertyDetails = salonStoreDTO.getPropertyMetaData();
					
		salonStore = salonStoreDAO.save(salonStore);
		
		property = propertyDetailsDAO.save(propertyDetails);
		
		salonStoreDTO.setPropertyMetaData(property);
		
		return salonStoreDTO;
	}
	
}