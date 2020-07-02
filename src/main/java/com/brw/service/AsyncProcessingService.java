package com.brw.service;

/**
 * @author sidpatil
 * 2020
 */

import java.util.List;
import java.util.concurrent.CompletableFuture;

import com.brw.dto.GBusinessInfoDTO;
import com.brw.dto.UserActivityDTO;
import com.brw.dto.BusinessInfoDTO;

public interface AsyncProcessingService {
	
	public CompletableFuture<Integer> asyncStoreLatLngToDB(List <BusinessInfoDTO> bizInfoDTOList) throws InterruptedException;
	public CompletableFuture<Integer> asyncTrackUserActivity(UserActivityDTO userActivityDTO) throws InterruptedException;
}