package com.brw.service.impl;

/**
 * @author sidpatil
 * 2019
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
import com.brw.dto.EstimatesDTO;
import com.brw.dto.EstimatesListDTO;
import com.brw.entities.AdditionalAttribDefinitions;
import com.brw.entities.AdditionalAttributes;
import com.brw.entities.Estimates;

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
		additionalAttribsListDTO.setAdditionalAttribsDTOList(additionalAttribsDTOList);
		return additionalAttribsListDTO;
	}
	
	@Override
	public AdditionalAttribsListDTO addAdditionalAttributes(AdditionalAttribsListDTO additionalAttribsListDTO) {
		
		System.out.println("222 **** Inside AdditionalAttribServiceImpl.addAdditionalAttribs()");

		List<AdditionalAttribsDTO> additionalAttribsDTOList = additionalAttribsListDTO.getAdditionalAttribsDTOList();
		System.out.println("222 **** Inside BizTransactionServiceImpl.addBizTransactions() bizTransactionsDTOList SIZE: "+additionalAttribsDTOList.size());
		
		List<AdditionalAttribsDTO> addAttribsDTOList = new ArrayList<AdditionalAttribsDTO>();
		AdditionalAttribsListDTO addAttribsListDTO = new AdditionalAttribsListDTO();

		AdditionalAttributes additionalAttributes;
		
		for (AdditionalAttribsDTO additionalAttribsDTO: additionalAttribsDTOList) {
			
			additionalAttributes = new AdditionalAttributes();
			
			additionalAttributes.setBusinessId(additionalAttribsDTO.getBusinessId());
			additionalAttributes.setAddAttribType(additionalAttribsDTO.getAttribType());
			additionalAttributes.setAddAttribSubType(additionalAttribsDTO.getAttribSubType());
			additionalAttributes.setValue(additionalAttribsDTO.getValue());
			additionalAttributes.setQuantity(additionalAttribsDTO.getQuantity());
			additionalAttributes.setPerUnitPrice(additionalAttribsDTO.getPricePerUnit());
			additionalAttributes.setMonthlyMaintCost(additionalAttribsDTO.getMonthlyMaintExpense());
			additionalAttributes.setCreatedByUserId(additionalAttribsDTO.getInvokerId());
			additionalAttributes.setCreateDate(LocalDateTime.now());
			additionalAttributes.setUpdatedByUserId(additionalAttribsDTO.getInvokerId());
			additionalAttributes.setUpdateDate(LocalDateTime.now());
			
			AdditionalAttributes addAttributes = additionalAttribsDAO.save(additionalAttributes);
			
			AdditionalAttribsDTO addAttribsDTO = new AdditionalAttribsDTO();
			addAttribsDTO.setBusinessId(addAttributes.getBusinessId());
			addAttribsDTO.setAttribType(addAttributes.getAddAttribType());
			addAttribsDTO.setAttribSubType(addAttributes.getAddAttribSubType());
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
		addAttribsListDTO.setAdditionalAttribsDTOList(addAttribsDTOList);
		return addAttribsListDTO;
	}
}