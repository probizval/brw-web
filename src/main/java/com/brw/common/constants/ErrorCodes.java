package com.brw.common.constants;

import org.springframework.http.HttpStatus;

public enum ErrorCodes {
	INTERNAL_SERVER_ERROR("BRV-0000", HttpStatus.INTERNAL_SERVER_ERROR),
	VALIDATION_ERROR("BRV-0001", HttpStatus.BAD_REQUEST),
	BAD_REQUEST("BRV-0002", HttpStatus.BAD_REQUEST),
	INVALID_FILE_FORMAT("BRV-0003", HttpStatus.BAD_REQUEST),
	UNAUTHORIZED_REQUEST("BRV-0004", HttpStatus.UNAUTHORIZED),
	ACCESS_DENIED("BRV-0005", HttpStatus.UNAUTHORIZED);
	
	private String code;
	
	private HttpStatus httpStatus;
	
	
	public String getCode() {
		return code;
	}


	public HttpStatus getHttpStatus() {
		return httpStatus;
	}


	ErrorCodes(String code, HttpStatus httpStatus) {
		this.code = code;
		this.httpStatus = httpStatus;
	}
	
}
