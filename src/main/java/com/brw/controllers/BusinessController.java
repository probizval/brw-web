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

import com.brw.common.constants.Constants;
import com.brw.common.constants.ErrorCodes;
import com.brw.common.response.ApiResponse;

import com.brw.exceptions.BusinessException;
import com.brw.dto.BusinessDetailsDTO;
import com.brw.dto.BusinessInfoListDTO;
import com.brw.dto.RelatedBusinessDTO;
import com.brw.dto.RelatedBusinessListDTO;
import com.brw.service.BusinessService;

/**
 * @author sidpatil
 * 2019-20
 */

@RestController
@CrossOrigin(origins = "*")
//@RequestMapping("/api/business/v1/")
@RequestMapping(value = "/api/business/v1/", produces = "application/json")
public class BusinessController implements ErrorController {

	public static final Logger logger = LoggerFactory.getLogger(BusinessController.class);

	@Autowired
	BusinessService businessService;
	
	//@Autowired
	//VendorDataService vendorDataService;

	@Override
	public String getErrorPath() {
		// TODO Auto-generated method stub
		return "/error";
	}
	
	/**
	 * @author sidpatil
	 * searchBusiness - Service for simple search on home page based on business name, OR type, OR address returns list of matching businesses with limited attributes
	 */
	@RequestMapping(value = "searchBusiness", method = RequestMethod.POST, produces = "application/json")
	//@PostMapping(value = "searchBusiness")
	public ApiResponse<?> searchBusiness(@RequestBody BusinessDetailsDTO businessDetailsDTO) {
		
		System.out.println("**** 111 Inside BusinessController.searchBusiness() searchFilter: "+businessDetailsDTO.toString());

		logger.info("Search Business based on search criteria");
		
		BusinessInfoListDTO businessList = null;

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
	 *    and (??also in BRW MONGO DB(all attributes)??) and pull the data from BRW DB.
	 * 5. This service also calculates the estimated worth of business. 
	 */
	//@RequestMapping(value = "getBusinessDetails/{businessId}", method = RequestMethod.GET, produces = "application/json")
	@PostMapping(value = "getBusinessDetails")
	public ApiResponse<?> getBusinessDetails(@RequestBody BusinessDetailsDTO businessDTO) {
		
		System.out.println("**** 111 Inside BusinessController.getBusinessDetails()");
		
		logger.info("GET the Business details based on business Id");

		BusinessDetailsDTO returnBusinessDetailsDTO = null;
		//BusinessDetailsDTO businessDetailsDTO2 = null;

		try {
			
			returnBusinessDetailsDTO = businessService.getBusinessDetailsFromBRWDB(businessDTO.getBusinessId());
			//businessDetailsDTO1.setIsEstimateAvailable(businessService.estimateRealWorth(businessDetailsDTO1));
			
			return ApiResponse.withData(returnBusinessDetailsDTO);
			
			/* Code in case we decide to make Vendor API call run-time
			if(null != businessDTO.getIsVendorCall() && Constant.Y == businessDTO.getIsVendorCall()) {
				businessDetailsDTO1 = businessService.getBusinessDetailsFromBRWDB(businessDTO.getBusinessId());
				businessDetailsDTO1.setIsEstimateAvailable(businessService.estimateRealWorth(businessDetailsDTO1));
				
				return ApiResponse.withData(businessDetailsDTO1);

			} else {
				//If the address and Vendor Id mapping is not available then make vendor call based on address
				businessDetailsDTO1 = businessService.getBusinessDetailsFromBRWDB(businessDTO.getBusinessId());
				
				try {
					businessDetailsDTO2 = vendorDataService.getBusinessDetailsFromPB(businessDetailsDTO1.getStreet1(), businessDetailsDTO1.getStreet2(), businessDetailsDTO1.getCity(), businessDetailsDTO1.getStateCode(), businessDetailsDTO1.getZip()); 
				
				} catch (DataFromPBException pe) {
					pe.printStackTrace();
					return ApiResponse.withError(ErrorCodes.INTERNAL_SERVER_ERROR, "Data Not Found");
				}
				//calls Vendor API stores data in DBs(My SQL and MONGODB) and returns stores data businessDetailsDTO
				businessDetailsDTO2.setIsEstimateAvailable(businessService.estimateRealWorth(businessDetailsDTO2));
				businessDetailsDTO2 = updateBusinessWithVendorData(businessDetailsDTO2);
				
				return ApiResponse.withData(businessDetailsDTO2);
			}
			*/
		} catch (BusinessException be) {
			be.printStackTrace();
			return ApiResponse.withError(ErrorCodes.INTERNAL_SERVER_ERROR, "Data Not Found");
		}
	}
	
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
			
		} catch (Exception e) {
			e.printStackTrace();
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
			
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
			return new ResponseEntity<>(businessDetailsDTO, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	/**
	 * @author sidpatil
	 * updateBusinessWithVendorData - Service to update the existing business details based on Vendor data
	 */
	public BusinessDetailsDTO updateBusinessWithVendorData(BusinessDetailsDTO businessDetailsDTO) {
		
		System.out.println("**** Inside updateBusinessWithVendorData()");
		
		logger.info("UPDATE the Business Details based on Vendor Data");
		
		try {
			BusinessDetailsDTO bDTo = businessService.updateBusinessDetails(businessDetailsDTO);
			return bDTo;
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	@PostMapping(value = "addRelatedBusiness")
	public ResponseEntity<RelatedBusinessDTO> addRelatedBusiness(@RequestBody RelatedBusinessDTO relatedBusinessDTO) {
		try {
			RelatedBusinessDTO returnRelatedBusinessDTO = businessService.addRelatedBusiness(relatedBusinessDTO);
			return new ResponseEntity<>(returnRelatedBusinessDTO, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
			return new ResponseEntity<>(relatedBusinessDTO, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping(value = "getRelatedBusinesses")
	public ApiResponse<?> getRelatedBusiness(@RequestBody RelatedBusinessDTO relatedBusinessDTO) {
		
		RelatedBusinessListDTO relatedBusinessListDTO = null;
		try {
			relatedBusinessListDTO = businessService.getRelatedBusinesses(relatedBusinessDTO.getBusinessId());
			return ApiResponse.withData(relatedBusinessListDTO);
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
			return ApiResponse.withError(ErrorCodes.INTERNAL_SERVER_ERROR, "Record not found");
		}
	}
	
	@PostMapping(value = "deleteRelatedBusiness")
	public ApiResponse<?> deleteUserBusiness(@RequestBody RelatedBusinessDTO relatedBusinessDTO) {
		try {
			businessService.deleteRelatedBusiness(relatedBusinessDTO.getBusinessId(), relatedBusinessDTO.getRelatedBizId());
			return ApiResponse.withData(Constants.RESPONSE_SUCCESS);
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
			return ApiResponse.withError(ErrorCodes.INTERNAL_SERVER_ERROR, "Record not found");
		}
	}
}