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
import com.brw.dto.FilterDTO;
import com.brw.dto.GasStationDetailsDTO;
import com.brw.dto.PropertyDetailsDTO;
import com.brw.dto.PropertyListDTO;
import com.brw.entities.GasStation;
import com.brw.entities.PropertyDetails;
import com.brw.exceptions.PropertyDetailsException;

@Component
public class PropertyDetailsService implements com.brw.service.PropertyDetailsService  {

	@Autowired
	private PropertyDetailsDAO propertyDetailsDAO; 
	
	@Autowired
	private GasStationDAO gasStationDAO;
	
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
	public PropertyDetailsDTO getPropertyDetails(int id) throws PropertyDetailsException {
		// TODO Auto-generated method stub
		
		PropertyDetails propertyDetails = null;
		try {
				propertyDetails = propertyDetailsDAO.findById(id).get();
		} catch (Exception e) {
			throw new PropertyDetailsException("Record not found...");
		}
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
		
		GasStation gasStation = gasStationDAO.findById(Integer.parseInt(propertyDetails.getPropertyId())).get();
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
			propertyDetails.setPropertyId(String.valueOf(gasStation.getId()));
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
	
}