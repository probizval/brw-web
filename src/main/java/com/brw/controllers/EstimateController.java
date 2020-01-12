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
import com.brw.dto.EstimatesDTO;
import com.brw.dto.EstimatesListDTO;
import com.brw.exceptions.EstimateException;
import com.brw.service.EstimateService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/estimates/v1/")
public class EstimateController implements ErrorController {

	public static final Logger logger = LoggerFactory.getLogger(EstimateController.class);

	@Autowired
	EstimateService estimateService;

	@Override
	public String getErrorPath() {
		// TODO Auto-generated method stub
		return "/error";
	}

	/**
	 * @author sidpatil
	 * getEstimates - Service to get the Business Estimates on the basis of biz_id 
	 */
	//@RequestMapping(value = "getEstimates/{businessId}", method = RequestMethod.GET, produces = "application/json")
	@PostMapping(value = "getEstimates")
	public ApiResponse<?> getEstimates(@RequestBody EstimatesDTO estimatesDTO) {
		
		System.out.println("**** 111 Inside EstimateController.getEstimateDetails()");
		
		logger.info("Get the Business estimates based on business Id");

		EstimatesListDTO estimatesListDTO = null;
		
		try {
			estimatesListDTO = estimateService.getEstimates(estimatesDTO.getBusinessId());
			
		} catch (EstimateException ee) {
			ee.printStackTrace();
			return ApiResponse.withError(ErrorCodes.INTERNAL_SERVER_ERROR, "Record not found");
			
		}
		return ApiResponse.withData(estimatesListDTO);
		
	}
	
	/**
	 * @author sidpatil
	 * addBusinessDetails - Service to add business that does not already exist in BRW DB 
	 */
	@PostMapping(value = "addEstimates")
	public ResponseEntity<EstimatesListDTO> addEstimates(@RequestBody EstimatesListDTO estimatesListDTO) {
		
		System.out.println("111 **** Inside BusinessController.addBusiness()");
		
		logger.info("Add the New Estimates");
		
		try {
			EstimatesListDTO eListDTo = estimateService.addEstimates(estimatesListDTO);
			return new ResponseEntity<>(eListDTo, HttpStatus.OK);
			
		} catch (InternalServerError e) {
			// TODO: handle exception
			e.printStackTrace();
			return new ResponseEntity<>(estimatesListDTO, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}