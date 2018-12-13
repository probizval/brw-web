package com.brw.dto;

import java.io.Serializable;

public class FilterDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3729061184407096447L;
	
	private Double latitude;
	
	private Double longitude;
	
	private Integer zipCode;

	public Integer getZipCode() {
		return zipCode;
	}

	public void setZipCode(Integer zipCode) {
		this.zipCode = zipCode;
	}

	public Double getLatitude() {
		return latitude;
	}

	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

	public Double getLongitude() {
		return longitude;
	}

	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}
	
}