package com.brw.dto;

import java.io.Serializable;

public class SimpleSearchFilterDTO implements Serializable {

	/**
	 * @author sidpatil
	 */
	private static final long serialVersionUID = -3729061184407096447L;
	
	private Integer invokerId;
	
	private String bizName;
	
	private String bizType;
	
	private String street1;
	
	private String street2;

	private String city;
	
	private String state;
	
	private Integer zip;
	
	@Override
	public String toString() {
		return "SimpleSearchFilterDTO [invokerId=" + invokerId + ", bizName=" + bizName + ", bizType=" + bizType
				+ ", street1=" + street1 + ", street2=" + street2 + ", city=" + city + ", state=" + state + ", zip="
				+ zip + "]";
	}

	public Integer getInvokerId() {
		return invokerId;
	}

	public void setInvokerId(Integer invokerId) {
		this.invokerId = invokerId;
	}

	public String getBizName() {
		return bizName;
	}

	public void setBizName(String bizName) {
		this.bizName = bizName;
	}

	public String getBizType() {
		return bizType;
	}

	public void setBizType(String bizType) {
		this.bizType = bizType;
	}

	public String getStreet1() {
		return street1;
	}

	public void setStreet1(String street1) {
		this.street1 = street1;
	}

	public String getStreet2() {
		return street2;
	}

	public void setStreet2(String street2) {
		this.street2 = street2;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Integer getZip() {
		return zip;
	}

	public void setZip(Integer zip) {
		this.zip = zip;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}