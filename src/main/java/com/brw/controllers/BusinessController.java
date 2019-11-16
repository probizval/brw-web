package com.brw.controllers;

/**
 * @author sidpatil
 */

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpServerErrorException.InternalServerError;

import com.brw.common.constants.ErrorCodes;
import com.brw.common.response.ApiResponse;
import com.brw.dao.BusinessDetailsDAO;
import com.brw.dto.SimpleSearchFilterDTO;
import com.brw.exceptions.BusinessException;
import com.brw.exceptions.PropertyDetailsException;
import com.brw.dto.BusinessDetailsDTO;
import com.brw.dto.BusinessListDTO;
import com.brw.dto.PropertyDetailsDTO;
import com.brw.dto.PropertyMetaDataDTO;
import com.brw.service.BusinessService;
import com.brw.service.PropertyDetailsService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/business/v1/")
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
	public ApiResponse<?> searchBusiness(@RequestBody SimpleSearchFilterDTO simpleSearchFilter) {
		
		System.out.println("**** Inside BusinessController.searchBusiness() searchFilter: "+simpleSearchFilter.toString());

		logger.info("Search Business based on search criteria");
		
		BusinessListDTO businessList = null;

		try {
			businessList = businessService.searchBusiness(simpleSearchFilter);
		
		} catch (BusinessException be) {
			return ApiResponse.withError(ErrorCodes.INTERNAL_SERVER_ERROR, "Record not found");
		}
		return ApiResponse.withData(businessList);
	}
	
	/**
	 * @author sidpatil
	 * getBusinessDetails - Service to get the Business Details on the basis of biz_id, 
	 */
	@RequestMapping(value = "getBusiness/{businessId}", method = RequestMethod.GET, produces = "application/json")
	public ApiResponse<?> getBusinessDetails(@PathVariable int businessId) {
		
		System.out.println("**** Inside BusinessController.getBusinessDetails()");
		
		logger.info("Get the Business details based on business Id");

		BusinessDetailsDTO businessDetailsDTO = null;
		
		try {
			businessDetailsDTO = businessService.getBusinessDetails(businessId);
			
		} catch (BusinessException be) {
			return ApiResponse.withError(ErrorCodes.INTERNAL_SERVER_ERROR, "Record not found");
			
		}
		return ApiResponse.withData(businessDetailsDTO);
	}
	
	/**
	 * @author sidpatil
	 * getBusinessDetails - Service to get the Business Details on the basis of biz_id, 
	 */
	@PostMapping(value = "addBusiness")
	public ResponseEntity<BusinessDetailsDTO> addBusiness(@RequestBody BusinessDetailsDTO businessDetailsDTO) {
		
		System.out.println("**** Inside BusinessController.addBusiness()");
		
		logger.info("Add the New Business Details");
		
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
	 * getBusinessDetails - Service to get the Business Details on the basis of biz_id, 
	 */
	/*
	@PutMapping(value = "property")
	public ResponseEntity<PropertyDetailsDTO> updateProperty(@RequestBody PropertyDetailsDTO propertyDetailsDTO) {
		try {
			PropertyDetailsDTO pDTo = propertyDetailsService.updatePropertyDetail(propertyDetailsDTO);
			return new ResponseEntity<>(propertyDetailsDTO, HttpStatus.OK);
		} catch (InternalServerError e) {
			// TODO: handle exception
			return new ResponseEntity<>(propertyDetailsDTO, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	*/
}