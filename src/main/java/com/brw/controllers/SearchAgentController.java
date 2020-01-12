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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpServerErrorException.InternalServerError;

import com.brw.common.constants.ErrorCodes;
import com.brw.common.response.ApiResponse;
import com.brw.dto.SearchAgentDTO;
import com.brw.exceptions.SearchAgentException;
import com.brw.service.SearchAgentService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/searchAgent/v1/")
public class SearchAgentController implements ErrorController {

	public static final Logger logger = LoggerFactory.getLogger(EstimateController.class);

	@Autowired
	SearchAgentService searchAgentService;

	@Override
	public String getErrorPath() {
		// TODO Auto-generated method stub
		return "/error";
	}
	
	/**
	 * @author sidpatil
	 * addSearchAgent - Service to add search agent based on user preferances in BRW DB 
	 */
	@PostMapping(value = "addSearchAgent")
	public ResponseEntity<SearchAgentDTO> addSearchAgent(@RequestBody SearchAgentDTO searchAgentDTO) {
		
		System.out.println("111 **** Inside SearchAgentController.addSearchAgent()");
		
		logger.info("Add the New Estimates");
		
		try {
			SearchAgentDTO returnSearchAgent = searchAgentService.addSearchAgent(searchAgentDTO);
			return new ResponseEntity<>(returnSearchAgent, HttpStatus.OK);
			
		} catch (SearchAgentException e) {
			// TODO: handle exception
			return new ResponseEntity<>(searchAgentDTO, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}