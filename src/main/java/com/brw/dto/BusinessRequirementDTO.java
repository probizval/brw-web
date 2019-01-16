package com.brw.dto;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class BusinessRequirementDTO {
	
	private int id;
	
	private int userId;
	
	private String businessCategory;
	
	private String businessType;
	
	private String otherBusinessCategory;
	
	private String otherBusinessType;
	
	private int radius;
	
	private int minPrice;
	
	private int maxPrice;
	
	private int minLotSize;
	
	private int maxLotSize;
	
	private String businessDescription;
	
	private String businessLocation;
	
	private String address;
	
	private String city;
	
	private String state;
	
	private String country;
	
	private int zip_code;
	
	private Double latitude;
	
	private Double longitude;
	
	private String firstName;
	
	private String lastName;
	
	private String emailAdress;
	
	private String contactNumber;
	
	private String modeOfContact;
	
	private Boolean isConnectWithLocalAgents;
	
	private Boolean isSendMatchedBusinessEmail;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getBusinessCategory() {
		return businessCategory;
	}

	public void setBusinessCategory(String businessCategory) {
		this.businessCategory = businessCategory;
	}

	public String getBusinessType() {
		return businessType;
	}

	public void setBusinessType(String businessType) {
		this.businessType = businessType;
	}

	public String getOtherBusinessCategory() {
		return otherBusinessCategory;
	}

	public void setOtherBusinessCategory(String otherBusinessCategory) {
		this.otherBusinessCategory = otherBusinessCategory;
	}

	public String getOtherBusinessType() {
		return otherBusinessType;
	}

	public void setOtherBusinessType(String otherBusinessType) {
		this.otherBusinessType = otherBusinessType;
	}

	public int getRadius() {
		return radius;
	}

	public void setRadius(int radius) {
		this.radius = radius;
	}

	public int getMinPrice() {
		return minPrice;
	}

	public void setMinPrice(int minPrice) {
		this.minPrice = minPrice;
	}

	public int getMaxPrice() {
		return maxPrice;
	}

	public void setMaxPrice(int maxPrice) {
		this.maxPrice = maxPrice;
	}

	public int getMinLotSize() {
		return minLotSize;
	}

	public void setMinLotSize(int minLotSize) {
		this.minLotSize = minLotSize;
	}

	public int getMaxLotSize() {
		return maxLotSize;
	}

	public void setMaxLotSize(int maxLotSize) {
		this.maxLotSize = maxLotSize;
	}

	public String getBusinessDescription() {
		return businessDescription;
	}

	public void setBusinessDescription(String businessDescription) {
		this.businessDescription = businessDescription;
	}

	public String getBusinessLocation() {
		return businessLocation;
	}

	public void setBusinessLocation(String businessLocation) {
		this.businessLocation = businessLocation;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
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

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public int getZip_code() {
		return zip_code;
	}

	public void setZip_code(int zip_code) {
		this.zip_code = zip_code;
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

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmailAdress() {
		return emailAdress;
	}

	public void setEmailAdress(String emailAdress) {
		this.emailAdress = emailAdress;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public String getModeOfContact() {
		return modeOfContact;
	}

	public void setModeOfContact(String modeOfContact) {
		this.modeOfContact = modeOfContact;
	}

	public Boolean getIsConnectWithLocalAgents() {
		return isConnectWithLocalAgents;
	}

	public void setIsConnectWithLocalAgents(Boolean isConnectWithLocalAgents) {
		this.isConnectWithLocalAgents = isConnectWithLocalAgents;
	}

	public Boolean getIsSendMatchedBusinessEmail() {
		return isSendMatchedBusinessEmail;
	}

	public void setIsSendMatchedBusinessEmail(Boolean isSendMatchedBusinessEmail) {
		this.isSendMatchedBusinessEmail = isSendMatchedBusinessEmail;
	}
	
	
}
