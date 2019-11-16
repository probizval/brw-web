package com.brw.service;

/**
 * @author sidpatil
 */

import com.brw.dto.BusinessDetailsDTO;
import com.brw.dto.BusinessListDTO;
import com.brw.dto.PropertyDetailsDTO;
import com.brw.dto.SimpleSearchFilterDTO;
import com.brw.exceptions.BusinessException;

public interface BusinessService {
	
	public BusinessListDTO searchBusiness(SimpleSearchFilterDTO searchFilter) throws BusinessException;
	public BusinessDetailsDTO getBusinessDetails(int businessId) throws BusinessException;
	public BusinessDetailsDTO addBusinessDetails(BusinessDetailsDTO businessDetailsDTO);

	//public BusinessDetailsDTO addBusinessDetails(BusinessDetailsDTO businessDetailsDTO);
	//public BusinessDetailsDTO updateBusinessDetails(BusinessDetailsDTO businessDetailsDTO);

}