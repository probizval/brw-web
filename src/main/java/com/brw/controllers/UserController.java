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

import com.brw.common.constants.Constants;
import com.brw.common.constants.ErrorCodes;
import com.brw.common.response.ApiResponse;
import com.brw.dto.UserBusinessDTO;
import com.brw.dto.UserBusinessListDTO;
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
			UserDTO retUserDTO = userService.getUserProfile(userDTO);
			return new ResponseEntity<>(retUserDTO, HttpStatus.OK);
		} catch (InternalServerError e) {
			e.printStackTrace();
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
			e.printStackTrace();
			// TODO: handle exception
			return new ResponseEntity<>(userDTO, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping(value = "addUserBusiness")
	public ResponseEntity<UserBusinessDTO> addUserBusiness(@RequestBody UserBusinessDTO userBusinessDTO) {
		try {
			UserBusinessDTO returnUserBusinessDTO = userService.addUserBusiness(userBusinessDTO);
			return new ResponseEntity<>(returnUserBusinessDTO, HttpStatus.OK);
		} catch (InternalServerError e) {
			e.printStackTrace();
			// TODO: handle exception
			return new ResponseEntity<>(userBusinessDTO, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping(value = "getUserBusinesses")
	public ApiResponse<?> getUserBusinesses(@RequestBody UserBusinessDTO userBusinessDTO) {
		
		UserBusinessListDTO userBusinessListDTO = null;
		try {
			userBusinessListDTO = userService.getUserBusinesses(userBusinessDTO.getUserId());
			return ApiResponse.withData(userBusinessListDTO);
		} catch (InternalServerError e) {
			e.printStackTrace();
			// TODO: handle exception
			return ApiResponse.withError(ErrorCodes.INTERNAL_SERVER_ERROR, "Record not found");
		}
	}
	
	@PostMapping(value = "deleteUserBusiness")
	public ApiResponse<?> deleteUserBusiness(@RequestBody UserBusinessDTO userBusinessDTO) {
		try {
			userService.deleteUserBusiness(userBusinessDTO.getUserId(), userBusinessDTO.getRelationship());
			return ApiResponse.withData(Constants.RESPONSE_SUCCESS);
		} catch (InternalServerError e) {
			e.printStackTrace();
			// TODO: handle exception
			return ApiResponse.withError(ErrorCodes.INTERNAL_SERVER_ERROR, "Record not found");
		}
	}
	
	/*
	@PostMapping(value = "addUserActivity")
	public ResponseEntity<UserBusinessDTO> addUserBusiness(@RequestBody UserBusinessDTO userBusinessDTO) {
		try {
			UserBusinessDTO returnUserBusinessDTO = userService.addUserBusiness(userBusinessDTO);
			return new ResponseEntity<>(returnUserBusinessDTO, HttpStatus.OK);
		} catch (InternalServerError e) {
			e.printStackTrace();
			// TODO: handle exception
			return new ResponseEntity<>(userBusinessDTO, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	*/
}
