package com.brw.dto;

/**
 * @author sidpatil
 * 2019
 */

import java.io.Serializable;
import java.util.List;

public class AdditionalAttribDefinitionsListDTO implements Serializable {

	private static final long serialVersionUID = -65223447914153444L;
	
	private List<AdditionalAttribDefinitionsDTO> additionalAttribDefinitionsListDTO;

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

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
	
	public List<AdditionalAttribDefinitionsDTO> getAdditionalAttribDefinitionsListDTO() {
		return additionalAttribDefinitionsListDTO;
	}

	public void setAdditionalAttribDefinitionsListDTO(
			List<AdditionalAttribDefinitionsDTO> additionalAttribDefinitionsListDTO) {
		this.additionalAttribDefinitionsListDTO = additionalAttribDefinitionsListDTO;
	}
}
