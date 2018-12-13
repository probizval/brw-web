package com.brw.dto;

import javax.persistence.Column;

public class PropertyDetailsDTO {
	private int id;
	
	private String propertyType;
	
	private String propertyName;
	
	private String businessType;

	private String city;
	
	private String currentOwner;
	
	private Double estatedEstimatedValue;
	
	private String imageUrl;
	
	private Double latitude;
	
	private Double longitude;
	
	private Double lotSize;
	
	private String propertyAddress;
	
	private String state;
	
	private Integer zipCode;	
		
	private String zoningCategory;
	
	private String property_code;
	
	private String businessTypeCode;
	

	public String getProperty_code() {
		return property_code;
	}

	public void setProperty_code(String property_code) {
		this.property_code = property_code;
	}

	public String getBusinessTypeCode() {
		return businessTypeCode;
	}

	public void setBusinessTypeCode(String businessTypeCode) {
		this.businessTypeCode = businessTypeCode;
	}

	public String getBusinessType() {
		return businessType;
	}

	public void setBusinessType(String businessType) {
		this.businessType = businessType;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCurrentOwner() {
		return currentOwner;
	}

	public void setCurrentOwner(String currentOwner) {
		this.currentOwner = currentOwner;
	}

	public Double getEstatedEstimatedValue() {
		return estatedEstimatedValue;
	}

	public void setEstatedEstimatedValue(Double estatedEstimatedValue) {
		this.estatedEstimatedValue = estatedEstimatedValue;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
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

	public Double getLotSize() {
		return lotSize;
	}

	public void setLotSize(Double lotSize) {
		this.lotSize = lotSize;
	}

	public String getPropertyAddress() {
		return propertyAddress;
	}

	public void setPropertyAddress(String propertyAddress) {
		this.propertyAddress = propertyAddress;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Integer getZipCode() {
		return zipCode;
	}

	public void setZipCode(Integer zipCode) {
		this.zipCode = zipCode;
	}

	public String getZoningCategory() {
		return zoningCategory;
	}

	public void setZoningCategory(String zoningCategory) {
		this.zoningCategory = zoningCategory;
	}
	
	public String getPropertyType() {
		return propertyType;
	}

	public void setPropertyType(String propertyType) {
		this.propertyType = propertyType;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	

	public String getPropertyName() {
		return propertyName;
	}

	public void setPropertyName(String propertyName) {
		this.propertyName = propertyName;
	}
}