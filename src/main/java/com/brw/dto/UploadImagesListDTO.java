package com.brw.dto;

/**
 * @author sidpatil
 * 2020
 */

import java.io.Serializable;
import java.util.List;

public class UploadImagesListDTO implements Serializable {

	private static final long serialVersionUID = -65223447914153444L;
	
	private int invokerId;

	private int businessId;
	
	private List<UploadImageDTO> uploadImagesList;
	
	private Long totalCount;
	
	private Integer pageNumber;
	
	private Integer pageSize;
	
	public int getInvokerId() {
		return invokerId;
	}

	public void setInvokerId(int invokerId) {
		this.invokerId = invokerId;
	}

	public int getBusinessId() {
		return businessId;
	}

	public void setBusinessId(int businessId) {
		this.businessId = businessId;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	public Long getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(Long totalCount) {
		this.totalCount = totalCount;
	}

	public Integer getPageNumber() {
		return pageNumber;
	}

	public void setPageNumber(Integer pageNumber) {
		this.pageNumber = pageNumber;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public List<UploadImageDTO> getUploadImagesList() {
		return uploadImagesList;
	}

	public void setUploadImagesList(List<UploadImageDTO> uploadImagesList) {
		this.uploadImagesList = uploadImagesList;
	}
}
