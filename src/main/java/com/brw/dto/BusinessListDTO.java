package com.brw.dto;

import java.io.Serializable;
import java.util.List;

public class BusinessListDTO implements Serializable {

	private static final long serialVersionUID = -65223447914153444L;
	
	private List<BusinessDetailsDTO> businessList;
	
	private Long totalCount;
	
	private Integer pageNumber;
	
	private Integer pageSize;
	
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

	public List<BusinessDetailsDTO> getBusinessList() {
		return businessList;
	}

	public void setBusinessList(List<BusinessDetailsDTO> businessList) {
		this.businessList = businessList;
	}
}
