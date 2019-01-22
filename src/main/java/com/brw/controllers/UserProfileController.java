package com.brw.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpServerErrorException.InternalServerError;

import com.brw.common.response.ApiResponse;
import com.brw.dto.FilterDTO;
import com.brw.dto.PropertyDetailsDTO;
import com.brw.dto.PropertyListDTO;
import com.brw.dto.UserProfileDTO;
import com.brw.service.PropertyDetailsService;
import com.brw.service.UserProfileService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/v1/")
public class UserProfileController implements ErrorController {
	
	@Autowired
	UserProfileService userProfileService;
	
	@Autowired
	PropertyDetailsService propertyDetailsService;

	@Override
	public String getErrorPath() {
		// TODO Auto-generated method stub
		return "/error";
	}
	
	@PostMapping(value = "userprofile")
	public ResponseEntity<UserProfileDTO> getProfile(@RequestBody UserProfileDTO userProfileDTO) {
		try {
			UserProfileDTO userDTO = userProfileService.getUserProfile(userProfileDTO);
			return new ResponseEntity<>(userDTO, HttpStatus.OK);
		} catch (InternalServerError e) {
			// TODO: handle exception
			return new ResponseEntity<>(userProfileDTO, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping(value = "userprofile")
	public ResponseEntity<UserProfileDTO> updateProfile(@RequestBody UserProfileDTO userProfileDTO) {
		try {
			UserProfileDTO userDTO = userProfileService.updateUserProfile(userProfileDTO);
			return new ResponseEntity<>(userDTO, HttpStatus.OK);
		} catch (InternalServerError e) {
			// TODO: handle exception
			return new ResponseEntity<>(userProfileDTO, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@RequestMapping(value = "userprofile/propertyList/{userId}/{pageNumber}", method = RequestMethod.GET, produces = "application/json")
	public ApiResponse<?> getAllProperties(@PathVariable int userId, @PathVariable int pageNumber) {
		PropertyListDTO properties = propertyDetailsService.getAllPropertyListByUser(userId, pageNumber);
		return ApiResponse.withPaginatedData(properties, properties.getTotalCount(), properties.getPageNumber(), properties.getPageSize());
	}
	
	@RequestMapping(value = "userprofile/bookmarksPropertyList/{userId}/{pageNumber}", method = RequestMethod.GET, produces = "application/json")
	public ApiResponse<?> getBookMarksProperties(@PathVariable int userId, @PathVariable int pageNumber) {
		PropertyListDTO properties = propertyDetailsService.getBookMarkPropertyListByUser(userId, pageNumber);
		return ApiResponse.withPaginatedData(properties, properties.getTotalCount(), properties.getPageNumber(), properties.getPageSize());
	}

}
