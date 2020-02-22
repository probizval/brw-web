package com.brw.dto;

/**
 * @author sidpatil
 * 2020
 */

import java.io.Serializable;
import java.util.List;

public class BusinessInfoListDTO implements Serializable {

	private static final long serialVersionUID = -65223447914153444L;
	
	private List<BusinessInfoDTO> businessList;
	
	private Long totalCount;
	
	private Integer pageNumber;
	
	private Integer pageSize;

	public List<BusinessInfoDTO> getBusinessList() {
		return businessList;
	}

	public void setBusinessList(List<BusinessInfoDTO> businessList) {
		this.businessList = businessList;
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}	
}
