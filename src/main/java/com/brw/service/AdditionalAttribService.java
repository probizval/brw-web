package com.brw.service;

import com.brw.dto.AdditionalAttribDefinitionsListDTO;
import com.brw.dto.AdditionalAttribsListDTO;
import com.brw.exceptions.AdditionalAttribsException;

/**
 * @author sidpatil
 * 2019
 */

public interface AdditionalAttribService {
	
	public AdditionalAttribDefinitionsListDTO getAdditionalAttribDefinitions(String bizType, String bizSubType) throws AdditionalAttribsException;
	public AdditionalAttribsListDTO getAdditionalAttributes(int businessId) throws AdditionalAttribsException;
	public AdditionalAttribsListDTO addAdditionalAttributes(AdditionalAttribsListDTO additionalAttribsListDTO) throws AdditionalAttribsException;
	public boolean deleteAdditionalAttributes(int businessId) throws AdditionalAttribsException;
	//public AdditionalAttribsListDTO updateAdditionalAttributes(AdditionalAttribsListDTO additionalAttribsListDTO) throws AdditionalAttribsException;
}