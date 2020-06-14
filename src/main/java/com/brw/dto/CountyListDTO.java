package com.brw.dto;

/**
 * @author sidpatil
 * 2020
 */

import java.io.Serializable;
import java.util.List;

public class CountyListDTO implements Serializable {

	private static final long serialVersionUID = -65223447914153444L;
	private List<CountyDTO> countyList;
	
	public List<CountyDTO> getCountyList() {
		return countyList;
	}

	public void setCountyList(List<CountyDTO> countyList) {
		this.countyList = countyList;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
