package com.brw.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
import com.brw.dao.PropertyDetailsDAO;
import com.brw.dto.GasStationDetailsDTO;
import com.brw.dto.PropertyDetailsDTO;
import com.brw.dto.PropertyListDTO;
import com.brw.exceptions.PropertyDetailsException;
import com.brw.dto.FilterDTO;
import com.brw.service.PropertyDetailsService;

@RestController
@RequestMapping("/api/v1/")
public class PropertyDetailsController implements ErrorController {

	public static final Logger logger = LoggerFactory.getLogger(PropertyDetailsController.class);

	@Autowired
	PropertyDetailsService propertyDetailsService;

	@Override
	public String getErrorPath() {
		// TODO Auto-generated method stub
		return "/error";
	}

	@RequestMapping(value = "propertyList", method = RequestMethod.POST, produces = "application/json")
	public ApiResponse<?> getAllProperties(@RequestBody FilterDTO filter) {
		logger.info(" get all properties");
		PropertyListDTO properties = propertyDetailsService.getAllPropertyList(filter);
		return ApiResponse.withData(properties);
	}

	@RequestMapping(value = "property/{id}", method = RequestMethod.GET, produces = "application/json")
	public ApiResponse<?> getPropertyDetails(@PathVariable int id) {

		PropertyDetailsDTO propertyDetailsDTO = null;
		try {
			propertyDetailsDTO = propertyDetailsService.getPropertyDetails(id);
		} catch (PropertyDetailsException e) {
			return ApiResponse.withError(ErrorCodes.INTERNAL_SERVER_ERROR, "Record not found");
		}

		return ApiResponse.withData(propertyDetailsDTO);
	}

	@PostMapping(value = "property")
	public ResponseEntity<PropertyDetailsDTO> createProperty(@RequestBody PropertyDetailsDTO propertyDetailsDTO) {
		try {
			PropertyDetailsDTO pDTo = propertyDetailsService.savePropertyDetail(propertyDetailsDTO);
			return new ResponseEntity<>(pDTo, HttpStatus.OK);
		} catch (InternalServerError e) {
			// TODO: handle exception
			return new ResponseEntity<>(propertyDetailsDTO, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

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

	@RequestMapping(value = "propertydetails/{id}", method = RequestMethod.GET, produces = "application/json")
	public ApiResponse<?> getGasStationPropertyDetails(@PathVariable int id) {

		PropertyDetailsDTO propertyDetailsDTO = null;
		try {
			propertyDetailsDTO = propertyDetailsService.getPropertyDetails(id);
		} catch (PropertyDetailsException e) {
			return ApiResponse.withError(ErrorCodes.INTERNAL_SERVER_ERROR, e.getMessage());
		}

		if (propertyDetailsDTO.getBusinessType().equalsIgnoreCase("Gas Station")) {
			GasStationDetailsDTO gasStationDetailsDTO = null;
			try {
				gasStationDetailsDTO = propertyDetailsService.getGasStationPropertyDetails(id);
			} catch (PropertyDetailsException e) {
				return ApiResponse.withError(ErrorCodes.INTERNAL_SERVER_ERROR);
			}
			return ApiResponse.withData(gasStationDetailsDTO);
		} else {
			return ApiResponse.withData(propertyDetailsDTO);
		}

	}

	@PostMapping(value = "property/gasstation")
	public ApiResponse<?> createGasStationProperty(
			@RequestBody GasStationDetailsDTO gasStationDetailsDTO) {
		try {
			GasStationDetailsDTO pDTo = propertyDetailsService.saveGasStationPropertyDetail(gasStationDetailsDTO);
			return ApiResponse.withData(pDTo);
		} catch (InternalServerError e) {
			// TODO: handle exception
			return ApiResponse.withError(ErrorCodes.INTERNAL_SERVER_ERROR);
		} catch (PropertyDetailsException e) {
			return ApiResponse.withError(ErrorCodes.INTERNAL_SERVER_ERROR, e.getMessage());
		}
	}
}