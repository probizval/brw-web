package com.brw.service.impl;

/**
 * @author sidpatil
 * 2019
 * 
 */

import java.util.ArrayList;
import java.util.List;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.brw.dao.BizTransactionsDAO;
import com.brw.dto.BizTransactionsDTO;
import com.brw.dto.BizTransactionsListDTO;
import com.brw.entities.BizTransactions;

@Component
public class BizTransactionServiceImpl implements com.brw.service.BizTransactionService {
	
	private static final Logger logger = LoggerFactory.getLogger(BizTransactionServiceImpl.class);

	@Autowired
	private BizTransactionsDAO bizTransactionsDAO;
	
	@Override
	public BizTransactionsListDTO getBizTransactions(int businessId) {
		// TODO Auto-generated method stub
		logger.info("**** 222 Inside BizTransactionServiceImpl.getBizTransactions() businessId: "+businessId);
		
		List<BizTransactions> bizTransactionsList = (List<BizTransactions>)bizTransactionsDAO.getBizTransactions(businessId);
		List<BizTransactionsDTO> bizTransactionsDTOList = new ArrayList<BizTransactionsDTO>();
		BizTransactionsListDTO bizTransactionsListDTO = new BizTransactionsListDTO();
		
		for (BizTransactions bizTransactions: bizTransactionsList) {
			BizTransactionsDTO bizTransactionsDTO = new BizTransactionsDTO();
			
			bizTransactionsDTO.setTransactionId(bizTransactions.getTransactionId());
			bizTransactionsDTO.setBusinessId(bizTransactions.getBusinessId());
			bizTransactionsDTO.setTransactionType(bizTransactions.getTransactionType());
			bizTransactionsDTO.setTransactionSubType(bizTransactions.getTransactionSubType());
			bizTransactionsDTO.setTransactionDate(bizTransactions.getTransactionDate().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")));
			bizTransactionsDTO.setTransactionAmount(bizTransactions.getTransactionAmount());
			bizTransactionsDTO.setIsVerified(bizTransactions.getIsVerified());
			bizTransactionsDTO.setVerificationMethod(bizTransactions.getVerificationMethod());
			bizTransactionsDTO.setCreatedByUserId(bizTransactions.getCreatedByUserId());
			bizTransactionsDTO.setCreateDate(bizTransactions.getCreateDate().toString());
			bizTransactionsDTO.setUpdatedByUserId(bizTransactions.getUpdatedByUserId());
			bizTransactionsDTO.setUpdateDate(bizTransactions.getUpdateDate().toString());
			
			bizTransactionsDTOList.add(bizTransactionsDTO);
		}
		bizTransactionsListDTO.setBizTransactionsList(bizTransactionsDTOList);
		return bizTransactionsListDTO;
	}
	
	@Override
	public BizTransactionsDTO getBizLastSoldPrice(int businessId) {
		// TODO Auto-generated method stub
		logger.info("**** 222 Inside BizTransactionServiceImpl.getBizLastSoldPrice() businessId: "+businessId);
		
		BizTransactions compBizTransaction = bizTransactionsDAO.getBizLastSoldPrice(businessId, "SOLD");
		
		BizTransactionsDTO bizTransactionsDTO = new BizTransactionsDTO();
			
		bizTransactionsDTO.setTransactionId(compBizTransaction.getTransactionId());
		bizTransactionsDTO.setBusinessId(compBizTransaction.getBusinessId());
		bizTransactionsDTO.setTransactionType(compBizTransaction.getTransactionType());
		bizTransactionsDTO.setTransactionSubType(compBizTransaction.getTransactionSubType());
		bizTransactionsDTO.setTransactionDate(compBizTransaction.getTransactionDate().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")));
		bizTransactionsDTO.setTransactionAmount(compBizTransaction.getTransactionAmount());
		bizTransactionsDTO.setIsVerified(compBizTransaction.getIsVerified());
		bizTransactionsDTO.setVerificationMethod(compBizTransaction.getVerificationMethod());
		bizTransactionsDTO.setCreatedByUserId(compBizTransaction.getCreatedByUserId());
		bizTransactionsDTO.setCreateDate(compBizTransaction.getCreateDate().toString());
		bizTransactionsDTO.setUpdatedByUserId(compBizTransaction.getUpdatedByUserId());
		bizTransactionsDTO.setUpdateDate(compBizTransaction.getUpdateDate().toString());
			
		return bizTransactionsDTO;
	}
	
	@Override
	public BizTransactionsListDTO addBizTransactions(BizTransactionsListDTO bizTransactionsListDTO) {
		
		logger.info("222 **** Inside BizTransactionServiceImpl.addBizTransactions()");

		List<BizTransactionsDTO> bizTransactionsDTOList = bizTransactionsListDTO.getBizTransactionsList();
		logger.info("222 **** Inside BizTransactionServiceImpl.addBizTransactions() bizTransactionsDTOList SIZE: "+bizTransactionsDTOList.size());
		
		List<BizTransactionsDTO> bizTransDTOList = new ArrayList<BizTransactionsDTO>();
		BizTransactionsListDTO bizTransListDTO = new BizTransactionsListDTO();

		BizTransactions transactions;
		
		for (BizTransactionsDTO bizTransactionsDTO: bizTransactionsDTOList) {
			
			transactions = new BizTransactions();
			
			//estimates.setEstimateId(estimatesDTO.getEstimateId());
			transactions.setBusinessId(bizTransactionsDTO.getBusinessId());
			transactions.setTransactionType(bizTransactionsDTO.getTransactionType());
			transactions.setTransactionSubType(bizTransactionsDTO.getTransactionSubType());
			transactions.setTransactionAmount(bizTransactionsDTO.getTransactionAmount());
			transactions.setTransactionDate(LocalDateTime.parse(bizTransactionsDTO.getTransactionDate(), DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")));
			transactions.setIsVerified(bizTransactionsDTO.getIsVerified());
			transactions.setVerificationMethod(bizTransactionsDTO.getVerificationMethod());
			transactions.setCreatedByUserId(bizTransactionsDTO.getInvokerId());
			transactions.setCreateDate(LocalDateTime.now());
			transactions.setUpdatedByUserId(bizTransactionsDTO.getInvokerId());
			transactions.setUpdateDate(LocalDateTime.now());
			
			BizTransactions bizTransactions = bizTransactionsDAO.save(transactions);
			
			BizTransactionsDTO bizTransDTO = new BizTransactionsDTO();
			bizTransDTO.setTransactionId(bizTransactions.getTransactionId());
			bizTransDTO.setBusinessId(bizTransactions.getBusinessId());
			bizTransDTO.setTransactionType(bizTransactions.getTransactionType());
			bizTransDTO.setTransactionSubType(bizTransactions.getTransactionSubType());
			bizTransDTO.setTransactionDate(bizTransactions.getTransactionDate().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")));
			bizTransDTO.setTransactionAmount(bizTransactions.getTransactionAmount());
			bizTransDTO.setIsVerified(bizTransactions.getIsVerified());
			bizTransDTO.setVerificationMethod(bizTransactions.getVerificationMethod());
			bizTransDTO.setCreatedByUserId(bizTransactions.getCreatedByUserId());
			bizTransDTO.setCreateDate(bizTransactions.getCreateDate().toString());
			bizTransDTO.setUpdatedByUserId(bizTransactions.getUpdatedByUserId());
			bizTransDTO.setUpdateDate(bizTransactions.getUpdateDate().toString());
			
			bizTransDTOList.add(bizTransDTO);
		}
		bizTransListDTO.setBizTransactionsList(bizTransDTOList);
		return bizTransListDTO;
	}
}