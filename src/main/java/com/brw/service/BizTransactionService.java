package com.brw.service;

import com.brw.dto.BizTransactionsDTO;
import com.brw.dto.BizTransactionsListDTO;
import com.brw.exceptions.BizTransactionsException;

/**
 * @author sidpatil
 * 2019
 */

public interface BizTransactionService {
	
	public BizTransactionsListDTO getBizTransactions(int businessId) throws BizTransactionsException;
	public BizTransactionsDTO getBizLastSoldPrice(int businessId) throws BizTransactionsException;
	public BizTransactionsListDTO addBizTransactions(BizTransactionsListDTO bizTransactionsListDTO) throws BizTransactionsException;
	//public EstimatesDTO updateEstimates(EstimatesDTO estimatesDTO);
}