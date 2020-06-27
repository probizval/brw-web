package com.brw.service.impl;

/**
 * @author sidpatil
 * 2019
 */

import java.util.ArrayList;
import java.util.List;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.brw.dao.EstimatesDAO;
import com.brw.dto.EstimatesDTO;
import com.brw.dto.EstimatesListDTO;
import com.brw.entities.Estimates;

@Component
public class EstimateServiceImpl implements com.brw.service.EstimateService {

	private static final Logger logger = LoggerFactory.getLogger(EstimateServiceImpl.class);

	@Autowired
	private EstimatesDAO estimatesDAO;
	
	@Override
	public EstimatesListDTO getEstimates(int businessId) {
		// TODO Auto-generated method stub
		logger.info("**** 222 Inside EstimateServiceImpl.getEstimates() businessId: "+businessId);
		
		List<Estimates> estimateList = (List<Estimates>)estimatesDAO.getEstimates(businessId);
		List<EstimatesDTO> estimatesDTOList = new ArrayList<EstimatesDTO>();
		EstimatesListDTO estimatesListDTO = new EstimatesListDTO();
		
		for (Estimates estimates: estimateList) {
			EstimatesDTO estimatesDTO = new EstimatesDTO();
			estimatesDTO.setEstimateId(estimates.getEstimateId());
			estimatesDTO.setBusinessId(estimates.getBusinessId());
			estimatesDTO.setEstimateType(estimates.getEstimateType());
			estimatesDTO.setEstimateSubType(estimates.getEstimateSubType());
			estimatesDTO.setEstimatedAmount(estimates.getEstimatedAmount());
			estimatesDTO.setEstimatedAmountHigh(estimates.getEstimatedAmountHigh());
			estimatesDTO.setEstimatedAmountLow(estimates.getEstimatedAmountLow());
			estimatesDTO.setLastEstimationDate(estimates.getLastEstimationDate().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")));
			
			estimatesDTOList.add(estimatesDTO);
		}
		estimatesListDTO.setEstimatesList(estimatesDTOList);
		return estimatesListDTO;
	}
	
	@Override
	public EstimatesListDTO addEstimates(EstimatesListDTO estimateslistDTO) {
		
		logger.info("222 **** Inside EstimateServiceImpl.addEstimates()");

		List<EstimatesDTO> estimatesDTOList = estimateslistDTO.getEstimatesList();
		List<EstimatesDTO> estDTOList = new ArrayList<EstimatesDTO>();
		EstimatesListDTO estListDTO = new EstimatesListDTO();

		Estimates estimates;
		
		for (EstimatesDTO estimatesDTO: estimatesDTOList) {
			
			estimates = new Estimates();
			
			//estimates.setEstimateId(estimatesDTO.getEstimateId());
			estimates.setBusinessId(estimatesDTO.getBusinessId());
			estimates.setEstimateType(estimatesDTO.getEstimateType());
			estimates.setEstimateSubType(estimatesDTO.getEstimateSubType());
			estimates.setEstimatedAmount(estimatesDTO.getEstimatedAmount());
			estimates.setEstimatedAmountHigh(estimatesDTO.getEstimatedAmountHigh());
			estimates.setEstimatedAmountLow(estimatesDTO.getEstimatedAmountLow());
			estimates.setLastEstimationDate(LocalDateTime.now());
			
			Estimates est = estimatesDAO.save(estimates);
			
			EstimatesDTO estDTO = new EstimatesDTO();
			estDTO.setEstimateId(est.getEstimateId());
			estDTO.setBusinessId(est.getBusinessId());
			estDTO.setEstimateType(est.getEstimateType());
			estDTO.setEstimateSubType(est.getEstimateSubType());
			estDTO.setEstimatedAmount(est.getEstimatedAmount());
			estDTO.setEstimatedAmountHigh(est.getEstimatedAmountHigh());
			estDTO.setEstimatedAmountLow(est.getEstimatedAmountLow());
			estDTO.setLastEstimationDate(est.getLastEstimationDate().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")));
			
			estDTOList.add(estDTO);
		}
		estListDTO.setEstimatesList(estDTOList);
		return estListDTO;
	}
}