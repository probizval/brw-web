package com.brw.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpServerErrorException.InternalServerError;

import com.brw.dto.UserDTO;
import com.brw.service.UserService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/user/v1/")
public class UserController implements ErrorController {
	
	@Autowired
	UserService userService;

	@Override
	public String getErrorPath() {
		// TODO Auto-generated method stub
		return "/error";
	}
	
	@PostMapping(value = "addUserProfile")
	public ResponseEntity<UserDTO> addUser(@RequestBody UserDTO userDTO) {
		try {
			UserDTO returnUserDTO = userService.addUserProfile(userDTO);
			return new ResponseEntity<>(returnUserDTO, HttpStatus.OK);
		} catch (InternalServerError e) {
			e.printStackTrace();
			// TODO: handle exception
			return new ResponseEntity<>(userDTO, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping(value = "getUserProfile")
	public ResponseEntity<UserDTO> getUserDetails(@RequestBody UserDTO userDTO) {
		try {
			UserDTO userDTO1 = userService.getUserProfile(userDTO);
			return new ResponseEntity<>(userDTO1, HttpStatus.OK);
		} catch (InternalServerError e) {
			// TODO: handle exception
			return new ResponseEntity<>(userDTO, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping(value = "updateUserProfile")
	public ResponseEntity<UserDTO> updateUserProfile(@RequestBody UserDTO userDTO) {
		try {
			UserDTO userDTO1 = userService.updateUserProfile(userDTO);
			return new ResponseEntity<>(userDTO1, HttpStatus.OK);
		} catch (InternalServerError e) {
			// TODO: handle exception
			return new ResponseEntity<>(userDTO, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping(value = "addUserBusiness")
	public ResponseEntity<UserDTO> addUserBusiness(@RequestBody UserDTO userDTO) {
		try {
			UserDTO userDTO1 = userService.addUserBusiness(userDTO);
			return new ResponseEntity<>(userDTO1, HttpStatus.OK);
		} catch (InternalServerError e) {
			// TODO: handle exception
			return new ResponseEntity<>(userDTO, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping(value = "removeUserBusiness")
	public ResponseEntity<UserDTO> removeUserBusiness(@RequestBody UserDTO userDTO) {
		try {
			UserDTO userDTO1 = userService.removeUserBusiness(userDTO);
			return new ResponseEntity<>(userDTO1, HttpStatus.OK);
		} catch (InternalServerError e) {
			// TODO: handle exception
			return new ResponseEntity<>(userDTO, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping(value = "getUserBusiness")
	public ResponseEntity<UserDTO> getUserBusiness(@RequestBody UserDTO userDTO) {
		try {
			UserDTO userDTO1 = userService.getUserBusiness(userDTO);
			return new ResponseEntity<>(userDTO1, HttpStatus.OK);
		} catch (InternalServerError e) {
			// TODO: handle exception
			return new ResponseEntity<>(userDTO, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	/*
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
	*/
}
