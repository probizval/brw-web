package com.brw.common.constants;


public enum ValidationErrorCode {
	
	NOT_NULL("VE-1000"),
	EMPTY("VE-1001"),
	NOT_IN_RANGE("VE-1002");
	
	private String errorCode;
	
	ValidationErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
	
	public String getErrorCode() {
		return this.errorCode;
	}
}