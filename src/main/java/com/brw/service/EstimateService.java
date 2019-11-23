package com.brw.service;

/**
 * @author sidpatil
 * 2019
 */

import com.brw.dto.EstimatesListDTO;
import com.brw.exceptions.EstimateException;

public interface EstimateService {
	
	public EstimatesListDTO getEstimates(int businessId) throws EstimateException;
	public EstimatesListDTO addEstimates(EstimatesListDTO estimatesListDTO);
	//public EstimatesDTO updateEstimates(EstimatesDTO estimatesDTO);

}