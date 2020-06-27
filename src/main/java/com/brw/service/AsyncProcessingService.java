package com.brw.service;

/**
 * @author sidpatil
 * 2020
 */

import java.util.List;
import java.util.concurrent.CompletableFuture;

import com.brw.dto.BizLatLongDTO;
import com.brw.dto.BusinessDetailsDTO;

public interface AsyncProcessingService {
	
	public CompletableFuture<Integer> asyncStoreLatLngToDB(List <BizLatLongDTO> bizLatLongDTOList) throws InterruptedException;
	public BusinessDetailsDTO updateBusinessDetails(BusinessDetailsDTO businessDetailsDTO) throws Exception;

}