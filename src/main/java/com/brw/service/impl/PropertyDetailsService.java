package com.brw.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.brw.common.constants.ErrorCodes;
import com.brw.common.response.ApiResponse;
import com.brw.dao.GasStationDAO;
import com.brw.dao.PropertyDetailsDAO;
import com.brw.dao.PropertyImagesDAO;
import com.brw.dao.RestaurentDAO;
import com.brw.dto.FilterDTO;
import com.brw.dto.GasStationDetailsDTO;
import com.brw.dto.PropertyDetailsDTO;
import com.brw.dto.PropertyImagesDTO;
import com.brw.dto.PropertyListDTO;
import com.brw.dto.PropertyMetaDataDTO;
import com.brw.dto.RestaurantDTO;
import com.brw.dto.RestaurantDetailsDTO;
import com.brw.entities.GasStation;
import com.brw.entities.PropertyDetails;
import com.brw.entities.PropertyImages;
import com.brw.entities.Restaurant;
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
			propertyDetails.setPropertyCode("b_type_2");
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
			propertyDetails.setPropertyCode("b_type_1");
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
		
		PropertyDetails property = null;
		
		PropertyDetails propertyDetails = restaurantDetailsDTO.getPropertyMetaData();
					
		restaurant = restaurentDAO.save(restaurant);
		property = propertyDetailsDAO.save(propertyDetails);
		
		restaurantDetailsDTO.setPropertyMetaData(property);
		
		return restaurantDetailsDTO;
	}
	
}