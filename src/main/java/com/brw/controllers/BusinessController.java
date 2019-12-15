package com.brw.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.web.servlet.error.ErrorController;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.client.HttpServerErrorException.InternalServerError;

import com.brw.common.constants.ErrorCodes;
import com.brw.common.response.ApiResponse;

import com.brw.exceptions.BusinessException;

import com.brw.dto.BusinessDetailsDTO;
import com.brw.dto.BusinessListDTO;
import com.brw.service.BusinessService;

/**
 * @author sidpatil
 * 2019
 */

@RestController
@CrossOrigin(origins = "*")
//@RequestMapping("/api/business/v1/")
@RequestMapping(value = "/api/business/v1/", produces = "application/json")
public class BusinessController implements ErrorController {

	public static final Logger logger = LoggerFactory.getLogger(BusinessController.class);

	@Autowired
	BusinessService businessService;

	@Override
	public String getErrorPath() {
		// TODO Auto-generated method stub
		return "/error";
	}

	/**
	 * @author sidpatil
	 * searchBusiness - Service for simple search on home page based on business name, OR type, OR address returns list of matching businessess with limited attributes
	 */
	@RequestMapping(value = "searchBusiness", method = RequestMethod.POST, produces = "application/json")
	//@PostMapping(value = "searchBusiness")
	public ApiResponse<?> searchBusiness(@RequestBody BusinessDetailsDTO businessDetailsDTO) {
		
		System.out.println("**** 111 Inside BusinessController.searchBusiness() searchFilter: "+businessDetailsDTO.toString());

		logger.info("Search Business based on search criteria");
		
		BusinessListDTO businessList = null;

		try {
			businessList = businessService.searchBusiness(businessDetailsDTO);
		
		} catch (BusinessException be) {
			return ApiResponse.withError(ErrorCodes.INTERNAL_SERVER_ERROR, "Record not found");
		}
		return ApiResponse.withData(businessList);
	}
	
	/**
	 * @author sidpatil
	 * getBusinessDetails - Service to get the Business Details on the basis of biz_id
	 * 1. This service first checks in the BRW DB for the Vendor Data Flag/s before calling Vendor API to get the data
	 * 2. If Vendor Data flag returns FALSE, it makes vendor API calls.
	 * 3. Store the data returned by Vendor APIs in BRW DB and then return it back in the response of getBusinessDetails
	 * 4. If the Vendor Data flag returns TRUE, then do not call Vendor API store data in BRW MYSQL DB(subset of total result set) 
	 *    and also in BRW MONGO DB(all attributes) and pull the data from BRW DB.
	 * 5. This service also calculates the estimated worth of business. 
	 */
	//@RequestMapping(value = "getBusinessDetails/{businessId}", method = RequestMethod.GET, produces = "application/json")
	@PostMapping(value = "getBusinessDetails")
	public ApiResponse<?> getBusinessDetails(@RequestBody BusinessDetailsDTO businessDTO) {
		
		System.out.println("**** 111 Inside BusinessController.getBusinessDetails()");
		
		logger.info("GET the Business details based on business Id");

		BusinessDetailsDTO businessDetailsDTO = null;
		try {
			//vendorDataFlag = businessService.getVendorDataFlag(businessId);
			//if(vendorDataFlag) {
				businessDetailsDTO = businessService.getBusinessDetails(businessDTO.getBusinessId());
				businessDetailsDTO.setIsEstimateAvailable(businessService.estimateRealWorth(businessDetailsDTO));
			//} else {
				//String vendorId = vendorDataService.getVendorId(businessId);
				//businessDetailsDTO = vendorDataService.getBusinessDetailsFromVendor(vendorId); //calls Vendor API stores data in DBs(My SQL and MONGODB) and returns stores data businessDetailsDTO
				//businessDetailsDTO.setIsEstimateAvailable(businessService.estimateRealWorth(businessDetailsDTO));
			//}
			
		} catch (BusinessException be) {
			return ApiResponse.withError(ErrorCodes.INTERNAL_SERVER_ERROR, "Record not found");
			
		}
		return ApiResponse.withData(businessDetailsDTO);
	}
	
	/*
	@RequestMapping(value = "getBusinessDetails/{businessId}", method = RequestMethod.GET, produces = "application/json")
	public ApiResponse<?> getBusinessDetails(@PathVariable int businessId) {
		
		System.out.println("**** 111 Inside BusinessController.getBusinessDetails()");
		
		logger.info("GET the Business details based on business Id");

		BusinessDetailsDTO businessDetailsDTO = null;
		try {
			//vendorDataFlag = businessService.getVendorDataFlag(businessId);
			//if(vendorDataFlag) {
				businessDetailsDTO = businessService.getBusinessDetails(businessId);
				businessDetailsDTO.setIsEstimateAvailable(businessService.estimateRealWorth(businessDetailsDTO));
			//} else {
				//String vendorId = vendorDataService.getVendorId(businessId);
				//businessDetailsDTO = vendorDataService.getBusinessDetailsFromVendor(vendorId); //calls Vendor API stores data in DBs(My SQL and MONGODB) and returns stores data businessDetailsDTO
				//businessDetailsDTO.setIsEstimateAvailable(businessService.estimateRealWorth(businessDetailsDTO));
			//}
			
		} catch (BusinessException be) {
			return ApiResponse.withError(ErrorCodes.INTERNAL_SERVER_ERROR, "Record not found");
			
		}
		return ApiResponse.withData(businessDetailsDTO);
	}
	*/
	
	/**
	 * @author sidpatil
	 * addBusinessDetails - Service to add business that does not already exist in BRW DB 
	 */
	@PostMapping(value = "addBusinessDetails")
	public ResponseEntity<BusinessDetailsDTO> addBusiness(@RequestBody BusinessDetailsDTO businessDetailsDTO) {
		
		System.out.println("111 **** Inside BusinessController.addBusiness()");
		
		logger.info("ADD the New Business Details");
		
		try {
			BusinessDetailsDTO bDTo = businessService.addBusinessDetails(businessDetailsDTO);
			return new ResponseEntity<>(bDTo, HttpStatus.OK);
			
		} catch (InternalServerError e) {
			// TODO: handle exception
			return new ResponseEntity<>(businessDetailsDTO, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	/**
	 * @author sidpatil
	 * updateBusinessDetails - Service to update the existing business details
	 */
	@PutMapping(value = "updateBusinessDetails")
	public ResponseEntity<BusinessDetailsDTO> updateBusiness(@RequestBody BusinessDetailsDTO businessDetailsDTO) {
		
		System.out.println("111 **** Inside BusinessController.updateBusiness()");
		
		logger.info("UPDATE the New Business Details");
		
		try {
			BusinessDetailsDTO bDTo = businessService.updateBusinessDetails(businessDetailsDTO);
			return new ResponseEntity<>(bDTo, HttpStatus.OK);
			
		} catch (InternalServerError e) {
			// TODO: handle exception
			return new ResponseEntity<>(businessDetailsDTO, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}