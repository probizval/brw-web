package com.brw.dto;

/**
 * @author sidpatil
 * 2020
 */

import java.io.Serializable;

public class BizLatLongDTO implements Serializable {

	private static final long serialVersionUID = -65223447914153444L;
	
	private Integer bizId;
	private double latitude;
	private double longitude;
	
	public Integer getBizId() {
		return bizId;
	}
	public void setBizId(Integer bizId) {
		this.bizId = bizId;
	}
	public double getLatitude() {
		return latitude;
	}
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}
	public double getLongitude() {
		return longitude;
	}
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
