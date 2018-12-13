package com.brw.common.response;

import java.io.Serializable;
import java.util.Map;

import com.brw.common.constants.ValidationErrorCode;

public class ValidationError implements Serializable {
	
	private ValidationErrorCode errorCode;
	
	private String errorMessage;
	
	private Map<String, String> errorParam;
	
	public ValidationError() {
		
	}
	
	public ValidationError(ValidationErrorCode errorCode, Map<String, String> errorParams) {
		this(errorCode, null, errorParams);
	}
	
	public ValidationError(ValidationErrorCode errorCode, String errorMessage, Map<String, String> errorParams) {
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;
		this.errorParam = errorParams;
	}
		
	
	public ValidationErrorCode getErrorCode() {
		return errorCode;
	}
	
	public String getErrorMessage() {
		return errorMessage;
	}
	
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	
	public Map<String, String> getErrorParams() {
		return errorParam;
	}
	
}