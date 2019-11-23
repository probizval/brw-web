package com.brw.controllers;

/**
 * @author sidpatil
 * 2019
 */

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpServerErrorException.InternalServerError;

import com.brw.common.constants.ErrorCodes;
import com.brw.common.response.ApiResponse;
import com.brw.dto.BizTransactionsListDTO;
import com.brw.exceptions.BizTransactionsException;
import com.brw.service.BizTransactionService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/transactions/v1/")
public class BizTransactionController implements ErrorController {

	public static final Logger logger = LoggerFactory.getLogger(EstimateController.class);

	@Autowired
	BizTransactionService bizTransactionService;

	@Override
	public String getErrorPath() {
		// TODO Auto-generated method stub
		return "/error";
	}

	/**
	 * @author sidpatil
	 * getEstimates - Service to get ALL the Business Estimates on the basis of biz_id 
	 */
	@RequestMapping(value = "getBizTransactions/{businessId}", method = RequestMethod.GET, produces = "application/json")
	public ApiResponse<?> getBizTransactions(@PathVariable int businessId) {
		
		System.out.println("**** 111 Inside BizTransactionController.getBizTransactions()");
		
		logger.info("Get the Business Transactions based on business Id");

		BizTransactionsListDTO bizTransactionsListDTO = null;
		
		try {
			bizTransactionsListDTO = bizTransactionService.getBizTransactions(businessId);
			
		} catch (BizTransactionsException ee) {
			return ApiResponse.withError(ErrorCodes.INTERNAL_SERVER_ERROR, "Record not found");
			
		}
		return ApiResponse.withData(bizTransactionsListDTO);
		
	}
	
	/**
	 * @author sidpatil
	 * addBizTransactions - Service to add business transactions in BRW DB 
	 */
	@PostMapping(value = "addBizTransactions")
	public ResponseEntity<BizTransactionsListDTO> addBizTransactions(@RequestBody BizTransactionsListDTO bizTransactionsListDTO) {
		
		System.out.println("111 **** Inside BizTransactionController.addBizTransactions()");
		
		logger.info("Add the New Business Transaction Details");
		
		try {
			BizTransactionsListDTO btListDTo = bizTransactionService.addBizTransactions(bizTransactionsListDTO);
			return new ResponseEntity<>(btListDTo, HttpStatus.OK);
			
		} catch (InternalServerError e) {
			// TODO: handle exception
			return new ResponseEntity<>(bizTransactionsListDTO, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}