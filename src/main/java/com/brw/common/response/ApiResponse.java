package com.brw.common.response;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.springframework.http.HttpStatus;

import com.brw.common.constants.Constants;
import com.brw.common.constants.ErrorCodes;

public class ApiResponse<T> implements Serializable {
	
	//private static final long serialVersionUID = 
	
	private String status;
	
	private HttpStatus httpStatus;
	
	private T data;
	
	private Long totalCount;
	
	private Integer pageNumber;
	
	private Integer pageSize;
	
	private ErrorCodes errorCode;
	
	private String errorMessage;
	
	private List<ValidationError> validationErrors;
	
	public String getStatus() {
		return status;
	}

	public HttpStatus getHttpStatus() {
		return httpStatus;
	}

	public T getData() {
		return data;
	}

	public Long getTotalCount() {
		return totalCount;
	}

	public Integer getPageNumber() {
		return pageNumber;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public ErrorCodes getErrorCode() {
		return errorCode;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public List<ValidationError> getValidationErrors() {
		return validationErrors != null ? new ArrayList<> (validationErrors) : null;
	}
	
	public ApiResponse() {
		
	}
	
	public static <T> ApiResponse<T> withData(T data) {
		return new ApiResponse<> (HttpStatus.OK, data, null, null, null);
	}
	
	public static <T> ApiResponse<T> withPaginatedData(T data, Long totalCount, Integer pageNumber, Integer pageSize) {
		return new ApiResponse<> (HttpStatus.OK, data, totalCount, pageNumber, pageSize);
	}
	
	public static ApiResponse<?> withError(ErrorCodes errorCode) {
		return new ApiResponse<>(errorCode, null, null);
	}
	
	public static ApiResponse<?> withError(ErrorCodes errorCode, String errorMessage) {
		return new ApiResponse<>(errorCode, errorMessage, null);
	}
	
	public static ApiResponse<?> withError(ErrorCodes errorCode, String errorMessage, List<ValidationError> validationErrors) {
		return new ApiResponse<>(errorCode, errorMessage, validationErrors);
	}
	
	private ApiResponse (HttpStatus httpStatus, T data, Long totalCount, Integer pageNumber, Integer pageSize ) {
	
		this.status = Constants.RESPONSE_SUCCESS;
		this.httpStatus = httpStatus;
		this.data = data;
		this.totalCount = totalCount;
		this.pageNumber = pageNumber;
		this.pageSize = pageSize;
	}
	
	private ApiResponse (ErrorCodes errorCodes, String errorMessage, List<ValidationError> validationErrors ) {
		
		this.status = Constants.RESPONSE_FAILURE;
		this.httpStatus = errorCodes.getHttpStatus();
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;
		if(validationErrors != null && !validationErrors.isEmpty()) {
			this.validationErrors = new ArrayList<> (validationErrors);
		}
		
	}
	
	
}