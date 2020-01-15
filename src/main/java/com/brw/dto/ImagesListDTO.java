package com.brw.dto;

/**
 * @author siyapatil
 * 2019
 */

import java.io.Serializable;
import java.util.List;

public class ImagesListDTO implements Serializable {

	private static final long serialVersionUID = -65223447914153444L;
	
	private int invokerId;

	private int businessId;
	
	private List<ImageDTO> imagesList;
	
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

	public List<ImageDTO> getImagesList() {
		return imagesList;
	}

	public void setImagesList(List<ImageDTO> imagesList) {
		this.imagesList = imagesList;
	}
}
