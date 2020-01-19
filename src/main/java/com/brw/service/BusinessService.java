package com.brw.service;

/**
 * @author sidpatil
 * 2019
 */

import com.brw.dto.BusinessDetailsDTO;
import com.brw.dto.BusinessListDTO;
import com.brw.dto.RelatedBusinessDTO;
import com.brw.dto.RelatedBusinessListDTO;
import com.brw.dto.UserBusinessDTO;
import com.brw.dto.UserBusinessListDTO;
import com.brw.exceptions.BusinessException;

public interface BusinessService {
	
	public BusinessListDTO searchBusiness(BusinessDetailsDTO searchFilter) throws BusinessException;
	public BusinessDetailsDTO getBusinessDetailsFromBRWDB(int businessId) throws BusinessException;
	public BusinessDetailsDTO addBusinessDetails(BusinessDetailsDTO businessDetailsDTO) throws BusinessException;
	public BusinessDetailsDTO updateBusinessDetails(BusinessDetailsDTO businessDetailsDTO) throws BusinessException;
	public BusinessListDTO searchComparableBusiness(BusinessDetailsDTO businessInQuestion) throws BusinessException;
	public String estimateRealWorth(BusinessDetailsDTO businessDetailsDTO) throws BusinessException;
	
	public RelatedBusinessDTO addRelatedBusiness(RelatedBusinessDTO relatedBusinessDTO) throws BusinessException;
	public RelatedBusinessListDTO getRelatedBusinesses(int businessId) throws BusinessException;
	public void deleteRelatedBusiness(int businessId, int relatedBizId) throws BusinessException;
}