package com.example.restful;

import com.brw.dto.PropertyMetaDataDTO;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PropertyDetailsResponse{
	private String status;
	private String httpStatus;
	private PropertyMetaDataDTO data;
	private String totalCount;
	private String pageNumber;
	private String pageSize;
	private String errorCode;
	private String errorMessage;
	private String validationErrors;
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getHttpStatus() {
		return httpStatus;
	}
	public void setHttpStatus(String httpStatus) {
		this.httpStatus = httpStatus;
	}
	public PropertyMetaDataDTO getData() {
		return data;
	}
	public void setData(PropertyMetaDataDTO data) {
		this.data = data;
	}
	public String getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(String totalCount) {
		this.totalCount = totalCount;
	}
	public String getPageNumber() {
		return pageNumber;
	}
	public void setPageNumber(String pageNumber) {
		this.pageNumber = pageNumber;
	}
	public String getPageSize() {
		return pageSize;
	}
	public void setPageSize(String pageSize) {
		this.pageSize = pageSize;
	}
	public String getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	public String getValidationErrors() {
		return validationErrors;
	}
	public void setValidationErrors(String validationErrors) {
		this.validationErrors = validationErrors;
	}
	
}
