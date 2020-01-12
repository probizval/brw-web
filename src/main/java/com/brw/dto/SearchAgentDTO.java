package com.brw.dto;

/**
 * @author sidpatil
 * 2020
 */

public class SearchAgentDTO {

	private Integer userId;
	private Integer agentId;
	private String email;
	private String name;
	private String frequency;
	private String bizType;
	private String priceLow;
	private String priceHigh;
	private String state;
	private String county;
	
	
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public Integer getAgentId() {
		return agentId;
	}
	public void setAgentId(Integer agentId) {
		this.agentId = agentId;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getFrequency() {
		return frequency;
	}
	public void setFrequency(String frequency) {
		this.frequency = frequency;
	}
	public String getPriceLow() {
		return priceLow;
	}
	public void setPriceLow(String priceLow) {
		this.priceLow = priceLow;
	}
	public String getPriceHigh() {
		return priceHigh;
	}
	public void setPriceHigh(String priceHigh) {
		this.priceHigh = priceHigh;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCounty() {
		return county;
	}
	public void setCounty(String county) {
		this.county = county;
	}
	public String getBizType() {
		return bizType;
	}
	public void setBizType(String bizType) {
		this.bizType = bizType;
	}
}