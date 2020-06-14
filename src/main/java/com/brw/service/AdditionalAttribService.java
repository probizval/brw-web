package com.brw.service;

import com.brw.dto.AdditionalAttribDefinitionsListDTO;
import com.brw.dto.AdditionalAttribsListDTO;
import com.brw.dto.CountyListDTO;
import com.brw.dto.StateCountyCitiesDTO;
import com.brw.exceptions.AdditionalAttribsException;

/**
 * @author sidpatil
 * 2019-20
 */

public interface AdditionalAttribService {
	
	public AdditionalAttribDefinitionsListDTO getAdditionalAttribDefinitions(String bizType, String bizSubType) throws AdditionalAttribsException;
	public AdditionalAttribsListDTO getAdditionalAttributes(int businessId) throws AdditionalAttribsException;
	public AdditionalAttribsListDTO addAdditionalAttributes(AdditionalAttribsListDTO additionalAttribsListDTO) throws AdditionalAttribsException;
	public boolean deleteAdditionalAttributes(int businessId) throws AdditionalAttribsException;
	//public CountyListDTO getStateCounties(String stateName) throws AdditionalAttribsException;
	public CountyListDTO getCountiesAndCoordinates(String StateName) throws AdditionalAttribsException;

}