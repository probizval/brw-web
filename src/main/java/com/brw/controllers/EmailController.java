package com.brw.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.brw.dto.EmailDTO;
import com.brw.exceptions.EmailException;
import com.brw.service.EmailService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/email/v1/")
public class EmailController implements ErrorController {
	
	@Autowired
	EmailService emailService;

	@Override
	public String getErrorPath() {
		// TODO Auto-generated method stub
		return "/error";
	}
	
	@PostMapping(value = "sendEmail")
	public ResponseEntity<EmailDTO> sendEmail(@RequestBody EmailDTO emailDTO) {
		try {
			EmailDTO returnEmailDTO = emailService.sendEmail(emailDTO);
			return new ResponseEntity<>(returnEmailDTO, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
			return new ResponseEntity<>(emailDTO, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
