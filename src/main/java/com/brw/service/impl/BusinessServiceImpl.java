package com.brw.service.impl;

/**
 * @author sidpatil
 */

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.brw.dao.BusinessDetailsDAO;

import com.brw.dto.BusinessDetailsDTO;
import com.brw.dto.BusinessListDTO;
import com.brw.dto.PropertyDetailsDTO;
import com.brw.dto.SimpleSearchFilterDTO;

import com.brw.entities.BusinessDetails;
import com.brw.entities.PropertyDetails;

@Component
public class BusinessServiceImpl implements com.brw.service.BusinessService  {

	
	@Autowired
	private BusinessDetailsDAO businessDetailsDAO;
	
	@Override
	public BusinessListDTO searchBusiness(SimpleSearchFilterDTO simpleSearchFilter) {
		// TODO Auto-generated method stub
		System.out.println("**** Inside BusinessServiceImpl.searchBusiness()");
		
		List<BusinessDetails> businessList = (List<BusinessDetails>) businessDetailsDAO.searchBusiness(simpleSearchFilter.getBizName(), simpleSearchFilter.getBizType());
		List<BusinessDetailsDTO> businessDetailsDTOList = new ArrayList<BusinessDetailsDTO>();
		BusinessListDTO businessListDTO = new BusinessListDTO();
		
		for (BusinessDetails businessDetails: businessList) {
			BusinessDetailsDTO businessDetailsDTO = new BusinessDetailsDTO();
			businessDetailsDTO.setBusinessId(businessDetails.getBusinessId());
			businessDetailsDTO.setName(businessDetails.getName());		
			businessDetailsDTO.setType(businessDetails.getType());
			businessDetailsDTO.setSubType(businessDetails.getSubType());
			businessDetailsDTO.setCity(businessDetails.getCity());
			//businessDetailsDTO.setCurrentOwner(businessDetails.getCurrentOwner());
			//businessDetailsDTO.setEstatedEstimatedValue(businessDetails.getEstatesEstimatedValue());
			businessDetailsDTO.setImageFirst(businessDetails.getImageFirst());
			businessDetailsDTO.setLatitude(businessDetails.getLatitude());
			businessDetailsDTO.setLongitude(businessDetails.getLongitude());
			businessDetailsDTO.setSqftLot(businessDetails.getSqftLot());
			//businessDetailsDTO.setPropertyAddress(businessDetails.getPropertyAddress());
			businessDetailsDTO.setStateCode(businessDetails.getStateCode());
			businessDetailsDTO.setZip(businessDetails.getZip());
			if(simpleSearchFilter.getInvokerId() != null) {
				//businessDetailsDTO.setIsBookMarked(this.getBookMarksDetails(searchFilter.getUserId(), businessDetails.getBusinessId()));
			}
			businessDetailsDTOList.add(businessDetailsDTO);
		}
		businessListDTO.setBusinessList(businessDetailsDTOList);
		return businessListDTO;
	}
	
	@Override
	public BusinessDetailsDTO getBusinessDetails(int businessId) {
		// TODO Auto-generated method stub
		System.out.println("**** Inside BusinessServiceImpl.getBusinessDetails()");
		
		BusinessDetails businessDetails = (BusinessDetails) businessDetailsDAO.getBusinessDetails(businessId);
		List<BusinessDetailsDTO> businessDetailsDTOList = new ArrayList<BusinessDetailsDTO>();
		BusinessListDTO businessListDTO = new BusinessListDTO();
		
		BusinessDetailsDTO businessDetailsDTO = new BusinessDetailsDTO();
		businessDetailsDTO.setBusinessId(businessDetails.getBusinessId());
		businessDetailsDTO.setName(businessDetails.getName());		
		businessDetailsDTO.setType(businessDetails.getType());
		businessDetailsDTO.setSubType(businessDetails.getSubType());
		businessDetailsDTO.setCity(businessDetails.getCity());
		//businessDetailsDTO.setCurrentOwner(businessDetails.getCurrentOwner());
		//businessDetailsDTO.setEstatedEstimatedValue(businessDetails.getEstatesEstimatedValue());
		businessDetailsDTO.setImageFirst(businessDetails.getImageFirst());
		businessDetailsDTO.setLatitude(businessDetails.getLatitude());
		businessDetailsDTO.setLongitude(businessDetails.getLongitude());
		businessDetailsDTO.setSqftLot(businessDetails.getSqftLot());
		//businessDetailsDTO.setPropertyAddress(businessDetails.getPropertyAddress());
		businessDetailsDTO.setStateCode(businessDetails.getStateCode());
		businessDetailsDTO.setZip(businessDetails.getZip());
		businessDetailsDTOList.add(businessDetailsDTO);
		
		businessListDTO.setBusinessList(businessDetailsDTOList);
		return businessDetailsDTO;
	}
	
	
	@Override
	public BusinessDetailsDTO addBusinessDetails(BusinessDetailsDTO businessDetailsDTO) {
		// TODO Auto-generated method stub
		BusinessDetails businessDetails = new BusinessDetails();
		businessDetails.setLegalName(businessDetailsDTO.getLegalName());
		businessDetails.setType(businessDetailsDTO.getType());
		
		List<BusinessDetails> businessList = (List<BusinessDetails>) businessDetailsDAO.findByBusinessName(businessDetailsDTO.getLegalName());
		BusinessDetails business;
		
		if(!businessList.isEmpty()) {
			business = businessList.get(0);
			
		} else {
			business = businessDetailsDAO.save(businessDetails);
			
		}
		BusinessDetailsDTO bizDTO = new BusinessDetailsDTO();
		
		bizDTO.setBusinessId(business.getBusinessId());
		bizDTO.setLegalName(business.getLegalName());
		bizDTO.setType(business.getType());
		
		return bizDTO;
	}
	
	/*
	@Override
	public BusinessDetailsDTO updateBusinessDetails(BusinessDetailsDTO business) {
		// TODO Auto-generated method stub
		System.out.println("**** Inside BusinessServiceImpl.updateBusinessDetails()");
		
		BusinessDetails businessDetails = (BusinessDetails) businessDetailsDAO.getBusinessDetails(business.);
		List<BusinessDetailsDTO> businessDetailsDTOList = new ArrayList<BusinessDetailsDTO>();
		BusinessListDTO businessListDTO = new BusinessListDTO();
		
		BusinessDetailsDTO businessDetailsDTO = new BusinessDetailsDTO();
		businessDetailsDTO.setBusinessId(businessDetails.getBusinessId());
		businessDetailsDTO.setName(businessDetails.getName());		
		businessDetailsDTO.setType(businessDetails.getType());
		businessDetailsDTO.setSubType(businessDetails.getSubType());
		businessDetailsDTO.setCity(businessDetails.getCity());
		//businessDetailsDTO.setCurrentOwner(businessDetails.getCurrentOwner());
		//businessDetailsDTO.setEstatedEstimatedValue(businessDetails.getEstatesEstimatedValue());
		businessDetailsDTO.setImageFirst(businessDetails.getImageFirst());
		businessDetailsDTO.setLatitude(businessDetails.getLatitude());
		businessDetailsDTO.setLongitude(businessDetails.getLongitude());
		businessDetailsDTO.setSqftLot(businessDetails.getSqftLot());
		//businessDetailsDTO.setPropertyAddress(businessDetails.getPropertyAddress());
		businessDetailsDTO.setStateCode(businessDetails.getStateCode());
		businessDetailsDTO.setZip(businessDetails.getZip());
		businessDetailsDTOList.add(businessDetailsDTO);
		
		businessListDTO.setBusinessList(businessDetailsDTOList);
		return businessDetailsDTO;
	}
	*/
}