package com.brw.service.impl;

/**
 * @author sidpatil
 * 2019-20
 * 
 */

import java.util.ArrayList;
import java.util.List;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.brw.dao.AdditionalAttribDefinitionsDAO;
import com.brw.dao.AdditionalAttribsDAO;
import com.brw.dto.AdditionalAttribDefinitionsDTO;
import com.brw.dto.AdditionalAttribDefinitionsListDTO;
import com.brw.dto.AdditionalAttribsDTO;
import com.brw.dto.AdditionalAttribsListDTO;
import com.brw.dto.StateCountyCitiesDTO;
import com.brw.entities.AdditionalAttribDefinitions;
import com.brw.entities.AdditionalAttributes;

@Component
public class AdditionalAttribServiceImpl implements com.brw.service.AdditionalAttribService {

	@Autowired
	private AdditionalAttribsDAO additionalAttribsDAO;
	
	@Autowired
	private AdditionalAttribDefinitionsDAO additionalAttribDefinitionsDAO;
	
	@Override
	public AdditionalAttribDefinitionsListDTO getAdditionalAttribDefinitions(String bizType, String bizSubType) {
		// TODO Auto-generated method stub
		System.out.println("**** 222 Inside AdditionalAttribServiceImpl.getAdditionalAttribDefinitions bizType: "+bizType);
		System.out.println("**** 222 Inside AdditionalAttribServiceImpl.getAdditionalAttribDefinitions bizSubType: "+bizSubType);
		
		List<AdditionalAttribDefinitions> additionalAttribDefinitionsList = (List<AdditionalAttribDefinitions>)additionalAttribDefinitionsDAO.getAdditionalAttribDefinitions(bizType, bizSubType);
		List<AdditionalAttribDefinitionsDTO> additionalAttribDefinitionsDTOList = new ArrayList<AdditionalAttribDefinitionsDTO>();
		AdditionalAttribDefinitionsListDTO additionalAttribDefinitionsListDTO = new AdditionalAttribDefinitionsListDTO();
		
		for (AdditionalAttribDefinitions additionalAttribDefinitions: additionalAttribDefinitionsList) {
			AdditionalAttribDefinitionsDTO additionalAttribDefinitionsDTO = new AdditionalAttribDefinitionsDTO();
			additionalAttribDefinitionsDTO.setBizType(additionalAttribDefinitions.getBizType());
			additionalAttribDefinitionsDTO.setBizSubType(additionalAttribDefinitions.getBizSubType());
			additionalAttribDefinitionsDTO.setAttribType(additionalAttribDefinitions.getAttributeType());
			additionalAttribDefinitionsDTO.setAttribSubType(additionalAttribDefinitions.getAttributeSubType());
						
			additionalAttribDefinitionsDTOList.add(additionalAttribDefinitionsDTO);
		}
		additionalAttribDefinitionsListDTO.setAdditionalAttribDefinitionsListDTO(additionalAttribDefinitionsDTOList);
		return additionalAttribDefinitionsListDTO;
	}
	
	@Override
	public AdditionalAttribsListDTO getAdditionalAttributes(int businessId) {
		// TODO Auto-generated method stub
		System.out.println("**** 222 Inside AdditionalAttribServiceImpl.getAdditionalAttribs() businessId: "+businessId);
		
		List<AdditionalAttributes> additionalAttributesList = (List<AdditionalAttributes>)additionalAttribsDAO.getAdditionalAttributes(businessId);
		List<AdditionalAttribsDTO> additionalAttribsDTOList = new ArrayList<AdditionalAttribsDTO>();
		AdditionalAttribsListDTO additionalAttribsListDTO = new AdditionalAttribsListDTO();
		
		for (AdditionalAttributes additionalAttributes: additionalAttributesList) {
			AdditionalAttribsDTO additionalAttribsDTO = new AdditionalAttribsDTO();
			
			additionalAttribsDTO.setAddAttribId(additionalAttributes.getAddAttributeId());
			additionalAttribsDTO.setAttribType(additionalAttributes.getAddAttribType());
			additionalAttribsDTO.setAttribSubType(additionalAttributes.getAddAttribSubType());
			additionalAttribsDTO.setValue(additionalAttributes.getValue());
			additionalAttribsDTO.setQuantity(additionalAttributes.getQuantity());
			
			additionalAttribsDTO.setPricePerUnit(additionalAttributes.getPerUnitPrice());
			additionalAttribsDTO.setMonthlyMaintExpense(additionalAttributes.getMonthlyMaintCost());
			
			additionalAttribsDTOList.add(additionalAttribsDTO);
		}
		additionalAttribsListDTO.setAddAttributesList(additionalAttribsDTOList);
		return additionalAttribsListDTO;
	}
	
	@Override
	public AdditionalAttribsListDTO addAdditionalAttributes(AdditionalAttribsListDTO additionalAttribsListDTO) {
		
		System.out.println("222 **** Inside AdditionalAttribServiceImpl.addAdditionalAttributes()");

		List<AdditionalAttribsDTO> additionalAttribsDTOList = additionalAttribsListDTO.getAddAttributesList();
		System.out.println("222 **** Inside AdditionalAttribServiceImpl.addAdditionalAttributes() addAdditionalAttributes SIZE: "+additionalAttribsDTOList.size());
		
		List<AdditionalAttribsDTO> addAttribsDTOList = new ArrayList<AdditionalAttribsDTO>();
		AdditionalAttribsListDTO addAttribsListDTO = new AdditionalAttribsListDTO();

		AdditionalAttributes additionalAttributes;
		AdditionalAttribsDTO addAttribsDTO;
		AdditionalAttributes addAttributes = new AdditionalAttributes();

		for (AdditionalAttribsDTO additionalAttribsDTO: additionalAttribsDTOList) {
			
			additionalAttributes = new AdditionalAttributes();
			
			additionalAttributes.setBusinessId(additionalAttribsListDTO.getBusinessId());
			additionalAttributes.setAddAttribType(additionalAttribsDTO.getAttribType());
			additionalAttributes.setAddAttribSubType(additionalAttribsDTO.getAttribSubType());
			additionalAttributes.setValueType(additionalAttribsDTO.getValueType());
			additionalAttributes.setValue(additionalAttribsDTO.getValue());
			additionalAttributes.setQuantity(additionalAttribsDTO.getQuantity());
			additionalAttributes.setPerUnitPrice(additionalAttribsDTO.getPricePerUnit());
			additionalAttributes.setMonthlyMaintCost(additionalAttribsDTO.getMonthlyMaintExpense());
			additionalAttributes.setCreatedByUserId(additionalAttribsListDTO.getInvokerId());
			additionalAttributes.setCreateDate(LocalDateTime.now());
			additionalAttributes.setUpdatedByUserId(additionalAttribsListDTO.getInvokerId());
			additionalAttributes.setUpdateDate(LocalDateTime.now());
			
			addAttributes = additionalAttribsDAO.save(additionalAttributes);
			
			addAttribsDTO = new AdditionalAttribsDTO();
			//addAttribsDTO.setBusinessId(addAttributes.getBusinessId());
			addAttribsDTO.setAttribType(addAttributes.getAddAttribType());
			addAttribsDTO.setAttribSubType(addAttributes.getAddAttribSubType());
			addAttribsDTO.setValueType(addAttributes.getValueType());
			addAttribsDTO.setValue(addAttributes.getValue());
			addAttribsDTO.setQuantity(addAttributes.getQuantity());
			addAttribsDTO.setPricePerUnit(addAttributes.getPerUnitPrice());
			addAttribsDTO.setMonthlyMaintExpense(addAttributes.getMonthlyMaintCost());
			addAttribsDTO.setCreatedByUserId(addAttributes.getCreatedByUserId());
			addAttribsDTO.setCreateDate(addAttributes.getCreateDate().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")));
			addAttribsDTO.setUpdatedByUserId(addAttributes.getUpdatedByUserId());
			addAttribsDTO.setUpdateDate(addAttributes.getUpdateDate().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")));
			
			addAttribsDTOList.add(addAttribsDTO);
		}
		
		addAttribsListDTO.setInvokerId(addAttributes.getCreatedByUserId());
		addAttribsListDTO.setBusinessId(addAttributes.getBusinessId());
		addAttribsListDTO.setAddAttributesList(addAttribsDTOList);
		
		return addAttribsListDTO;
	}
	
	@Override
	public boolean deleteAdditionalAttributes(int businessId) {
		System.out.println("222 **** Inside AdditionalAttribServiceImpl.updateAdditionalAttributes()");
		
		int records = additionalAttribsDAO.deleteAdditionalAttributes(businessId);
		
		System.out.println("222.1 **** Inside AdditionalAttribServiceImpl.updateAdditionalAttributes() Number of deletedRecords: "+ records);

		return true;
	}
	
	@Override
	public StateCountyCitiesDTO getStateCounties(String stateName) {
		// TODO Auto-generated method stub
		System.out.println("**** 222 Inside AdditionalAttribServiceImpl.getStateCounties() stateName: "+stateName);
		
		List<String> counties = (List<String>)additionalAttribsDAO.getStateCounties(stateName);

		StateCountyCitiesDTO retuenStateCountyCitiesDTO = new StateCountyCitiesDTO();
			
		//retuenStateCountyCitiesDTO.setStateCode(stateCountyCitiesDTO.getStateCode());
		retuenStateCountyCitiesDTO.setStateName(stateName);
		retuenStateCountyCitiesDTO.setListsOfCounties(counties);
			
		return retuenStateCountyCitiesDTO;
	}
}