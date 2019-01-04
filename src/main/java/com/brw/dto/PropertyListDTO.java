package com.brw.dto;

import java.io.Serializable;
import java.util.List;

public class PropertyListDTO implements Serializable {

	private static final long serialVersionUID = -65223447914153444L;
	
	private List<PropertyDetailsDTO> propertyList;
	
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

	public List<PropertyDetailsDTO> getPropertyList() {
		return propertyList;
	}

	public void setPropertyList(List<PropertyDetailsDTO> propertyList) {
		this.propertyList = propertyList;
	}
	
}
