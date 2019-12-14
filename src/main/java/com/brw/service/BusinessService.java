package com.brw.service;

/**
 * @author sidpatil
 * 2019
 */

import com.brw.dto.BusinessDetailsDTO;
import com.brw.dto.BusinessListDTO;
import com.brw.exceptions.BusinessException;

public interface BusinessService {
	
	public BusinessListDTO searchBusiness(BusinessDetailsDTO searchFilter) throws BusinessException;
	public BusinessDetailsDTO getBusinessDetails(int businessId) throws BusinessException;
	public BusinessDetailsDTO addBusinessDetails(BusinessDetailsDTO businessDetailsDTO);
	public BusinessDetailsDTO updateBusinessDetails(BusinessDetailsDTO businessDetailsDTO);
	public BusinessListDTO searchComparableBusiness(BusinessDetailsDTO businessInQuestion) throws BusinessException;
	public String estimateRealWorth(BusinessDetailsDTO businessDetailsDTO);
}