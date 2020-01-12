package com.brw.dto;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class BizType {

    private String bizType;
	private String bizSubType;

    public String getBizType() {
		return bizType;
	}
	public void setBizType(String bizType) {
		this.bizType = bizType;
	}
	public String getBizSubType() {
		return bizSubType;
	}
	public void setBizSubType(String bizSubType) {
		this.bizSubType = bizSubType;
	}
}