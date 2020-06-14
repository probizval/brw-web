package com.brw.controllers;

/**
 * @author sidpatil
 * 2020
 */

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.brw.common.constants.ErrorCodes;
import com.brw.common.response.ApiResponse;
import com.brw.dto.AdditionalAttribDefinitionsListDTO;
import com.brw.dto.AdditionalAttribsListDTO;
import com.brw.dto.BusinessDetailsDTO;
import com.brw.dto.CountyListDTO;
import com.brw.dto.StateCountyCitiesDTO;
import com.brw.exceptions.AdditionalAttribsException;
import com.brw.service.AdditionalAttribService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/additionalAttributes/v1/")
public class AdditionalAttribController implements ErrorController {

	public static final Logger logger = LoggerFactory.getLogger(EstimateController.class);

	@Autowired
	AdditionalAttribService additionalAttribService;

	@Override
	public String getErrorPath() {
		// TODO Auto-generated method stub
		return "/error";
	}
	
	/**
	 * @author sidpatil
	 * getAdditionalAttribDefinitions - Service to get Additional Attributes Definitions on the basis of business type and sub-type 
	 */
	@PostMapping(value = "getAdditionalAttribDefinitions")
	public ApiResponse<?> getAdditionalAttribDefinitions(@RequestBody BusinessDetailsDTO businessDTO) {
		
		System.out.println("**** 111 Inside AdditionalAttribController.getAdditionalAttribDefinitions()");
		
		logger.info("Get the Business Transactions based on business Id");

		AdditionalAttribDefinitionsListDTO additionalAttribDefinitionsListDTO = null;
		
		try {
			additionalAttribDefinitionsListDTO = additionalAttribService.getAdditionalAttribDefinitions(businessDTO.getType(), businessDTO.getSubType());
			
		} catch (AdditionalAttribsException ee) {
			return ApiResponse.withError(ErrorCodes.INTERNAL_SERVER_ERROR, "Record not found");
			
		}
		return ApiResponse.withData(additionalAttribDefinitionsListDTO);
	}

	/**
	 * @author sidpatil
	 * getAdditionalAttribs - Service to get Additional Attributes on the basis of biz_id 
	 */
	@PostMapping(value = "getAdditionalAttributes")
	public ApiResponse<?> getAdditionalAttribs(@RequestBody BusinessDetailsDTO businessDTO) {
		
		System.out.println("**** 111 Inside AdditionalAttribController.getAdditionalAttributes()");
		
		logger.info("Get the Business Transactions based on business Id");

		AdditionalAttribsListDTO additionalAttributesListDTO = null;
		
		try {
			additionalAttributesListDTO = additionalAttribService.getAdditionalAttributes(businessDTO.getBusinessId());
			
		} catch (AdditionalAttribsException ee) {
			ee.printStackTrace();
			return ApiResponse.withError(ErrorCodes.INTERNAL_SERVER_ERROR, "Record not found");
			
		}
		return ApiResponse.withData(additionalAttributesListDTO);
	}
	
	/**
	 * @author sidpatil
	 * addAdditionalAttribs - Service to add additional business attributes to BRW DB 
	 */
	@PostMapping(value = "addAdditionalAttributes")
	public ResponseEntity<AdditionalAttribsListDTO> addAdditionalAttribs(@RequestBody AdditionalAttribsListDTO additionalAttribsListDTO) {
		
		System.out.println("111 **** Inside AdditionalAttribController.addAdditionalAttributes()");
				
		logger.info("Add the New Business Transaction Details");
		
		AdditionalAttribsListDTO addAttribsListDTO = null;
		
		try {
			addAttribsListDTO = additionalAttribService.addAdditionalAttributes(additionalAttribsListDTO);
			return new ResponseEntity<>(addAttribsListDTO, HttpStatus.OK);
			
		} catch (AdditionalAttribsException e) {
			e.printStackTrace();
			// TODO: handle exception
			return new ResponseEntity<>(addAttribsListDTO, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	/**
	 * @author sidpatil
	 * updateAdditionalAttribs - Service to update additional business attributes to BRW DB 
	 */
	@PostMapping(value = "updateAdditionalAttributes")
	public ResponseEntity<AdditionalAttribsListDTO> updateAdditionalAttribs(@RequestBody AdditionalAttribsListDTO additionalAttribsListDTO) {
		
		System.out.println("111 **** Inside AdditionalAttribController.addAdditionalAttributes()");
				
		logger.info("Update Additional Business Attributes");
		
		AdditionalAttribsListDTO addAttribsListDTO = null;		
		
		boolean dataDeleted = false;
		//1. Delete the existing data based on Business Id from t_brw_business_add_attributes table
		try {
			dataDeleted = additionalAttribService.deleteAdditionalAttributes(additionalAttribsListDTO.getBusinessId());
			
		} catch (AdditionalAttribsException e) {
			e.printStackTrace();
			// TODO: handle exception
			
		}
		
		//2. Add data as comes in the input to t_brw_business_add_attributes table
		if (dataDeleted) {
			try {
				addAttribsListDTO = additionalAttribService.addAdditionalAttributes(additionalAttribsListDTO);
				return new ResponseEntity<>(addAttribsListDTO, HttpStatus.OK);
				
			} catch (AdditionalAttribsException e) {
				e.printStackTrace();
				// TODO: handle exception
				return new ResponseEntity<>(addAttribsListDTO, HttpStatus.INTERNAL_SERVER_ERROR);
			}
		} else {
			return new ResponseEntity<>(addAttribsListDTO, HttpStatus.INTERNAL_SERVER_ERROR);
			
		}
	}
	
	/**
	 * @author sidpatil
	 * 2020
	 * getStateCounties - Service to get list of counties based on state code 
	 */
	@PostMapping(value = "getStateCounties")
	public ApiResponse<?> getStateCounties(@RequestBody StateCountyCitiesDTO stateCountyCitiesDTO) {
		
		System.out.println("**** 111 Inside AdditionalAttribController.getAdditionalAttributes()");
		
		logger.info("Get the Business Transactions based on business Id");

		//StateCountyCitiesDTO returnStateCountyCitiesDTO = null;
		CountyListDTO returnCountyListDTO = null;
		
		try {
			//returnCountyListDTO = additionalAttribService.getStateCounties(stateCountyCitiesDTO.getStateName());
			returnCountyListDTO = additionalAttribService.getCountiesAndCoordinates(stateCountyCitiesDTO.getStateName());
			
		} catch (AdditionalAttribsException ee) {
			ee.printStackTrace();
			return ApiResponse.withError(ErrorCodes.INTERNAL_SERVER_ERROR, "Record not found");
		}
		return ApiResponse.withData(returnCountyListDTO);
	}
}