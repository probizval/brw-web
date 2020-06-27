package com.brw.service;

/**
 * @author sidpatil
 * 2019
 */

import java.util.List;
import java.util.concurrent.CompletableFuture;

import com.brw.dto.BizLatLongDTO;

import com.brw.dto.BusinessDetailsDTO;
import com.brw.dto.BusinessDetailsListDTO;
import com.brw.dto.BusinessInfoDTO;
import com.brw.dto.BusinessInfoListDTO;
import com.brw.dto.RelatedBusinessDTO;
import com.brw.dto.RelatedBusinessListDTO;
import com.brw.exceptions.BusinessException;

public interface BusinessService {
	
	public BusinessInfoListDTO searchBusiness(BusinessDetailsDTO searchFilter) throws BusinessException;
	public BusinessInfoDTO getBusinessInfoFromBRWDB(int businessId) throws BusinessException;
	public BusinessDetailsDTO getBusinessDetailsFromBRWDB(int businessId) throws BusinessException;
	public BusinessDetailsDTO addBusinessDetails(BusinessDetailsDTO businessDetailsDTO) throws BusinessException;
	public BusinessDetailsDTO updateBusinessDetails(BusinessDetailsDTO businessDetailsDTO) throws BusinessException;
	public BusinessDetailsListDTO searchComparableBusiness(BusinessDetailsDTO businessInQuestion) throws BusinessException;
	public String estimateRealWorth(BusinessDetailsDTO businessDetailsDTO) throws BusinessException;
	public RelatedBusinessDTO addRelatedBusiness(RelatedBusinessDTO relatedBusinessDTO) throws BusinessException;
	public RelatedBusinessListDTO getRelatedBusinesses(int businessId) throws BusinessException;
	public void deleteRelatedBusiness(int businessId, int relatedBizId) throws BusinessException;
}