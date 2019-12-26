package com.brw.dto;

import java.time.LocalDateTime;

/**
 * @author sidpatil
 * 2019
 */
public class UserDTO {

private int user_id;
	
	private String email;
	private String firstName;
	private String middleInitial;
	private String lastName;
	private String isBroker;
	private String phoneCountryCode;
	private String phoneNumber;
	private String phoneExtention;
	private String isSearchAgentEmail;
	private String searchAgentEmailFreq;
	private String isUserVerified;
	private LocalDateTime userVerificationDate;
	private String userVerificationMethod;
	private String isBrokerVerified;
	private LocalDateTime brokerVerificationDate;
	private String brokerVerificationMethod;
	private String brokerLicenseNumber;
	private String brokerDescription;
	private String brokerImageUrl;
	private String lastLoginDate;
	private String street1;
	private String street2;
	private String city;
	private String state;
	private String foreignState;
	private String zip;
	private String foreignPostalCode;
	private int country;
	private String isVettedBuyer;
	private String buyerVettingMethod;
	private String buyerPurchaseCapLow;
	private String buyerPurchaseCapHigh;
	private LocalDateTime buyerVettingDate;
	private int createdByUserId;
	private LocalDateTime createDate;
	private int updatedByUserId;
	private LocalDateTime updateDate;
	
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getMiddleInitial() {
		return middleInitial;
	}
	public void setMiddleInitial(String middleInitial) {
		this.middleInitial = middleInitial;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getIsBroker() {
		return isBroker;
	}
	public void setIsBroker(String isBroker) {
		this.isBroker = isBroker;
	}
	public String getPhoneCountryCode() {
		return phoneCountryCode;
	}
	public void setPhoneCountryCode(String phoneCountryCode) {
		this.phoneCountryCode = phoneCountryCode;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getPhoneExtention() {
		return phoneExtention;
	}
	public void setPhoneExtention(String phoneExtention) {
		this.phoneExtention = phoneExtention;
	}
	public String getIsSearchAgentEmail() {
		return isSearchAgentEmail;
	}
	public void setIsSearchAgentEmail(String isSearchAgentEmail) {
		this.isSearchAgentEmail = isSearchAgentEmail;
	}
	public String getSearchAgentEmailFreq() {
		return searchAgentEmailFreq;
	}
	public void setSearchAgentEmailFreq(String searchAgentEmailFreq) {
		this.searchAgentEmailFreq = searchAgentEmailFreq;
	}
	public String getIsUserVerified() {
		return isUserVerified;
	}
	public void setIsUserVerified(String isUserVerified) {
		this.isUserVerified = isUserVerified;
	}
	public LocalDateTime getUserVerificationDate() {
		return userVerificationDate;
	}
	public void setUserVerificationDate(LocalDateTime userVerificationDate) {
		this.userVerificationDate = userVerificationDate;
	}
	public String getUserVerificationMethod() {
		return userVerificationMethod;
	}
	public void setUserVerificationMethod(String userVerificationMethod) {
		this.userVerificationMethod = userVerificationMethod;
	}
	public String getIsBrokerVerified() {
		return isBrokerVerified;
	}
	public void setIsBrokerVerified(String isBrokerVerified) {
		this.isBrokerVerified = isBrokerVerified;
	}
	public LocalDateTime getBrokerVerificationDate() {
		return brokerVerificationDate;
	}
	public void setBrokerVerificationDate(LocalDateTime brokerVerificationDate) {
		this.brokerVerificationDate = brokerVerificationDate;
	}
	public String getBrokerVerificationMethod() {
		return brokerVerificationMethod;
	}
	public void setBrokerVerificationMethod(String brokerVerificationMethod) {
		this.brokerVerificationMethod = brokerVerificationMethod;
	}
	public String getBrokerLicenseNumber() {
		return brokerLicenseNumber;
	}
	public void setBrokerLicenseNumber(String brokerLicenseNumber) {
		this.brokerLicenseNumber = brokerLicenseNumber;
	}
	public String getBrokerDescription() {
		return brokerDescription;
	}
	public void setBrokerDescription(String brokerDescription) {
		this.brokerDescription = brokerDescription;
	}
	public String getBrokerImageUrl() {
		return brokerImageUrl;
	}
	public void setBrokerImageUrl(String brokerImageUrl) {
		this.brokerImageUrl = brokerImageUrl;
	}
	public String getLastLoginDate() {
		return lastLoginDate;
	}
	public void setLastLoginDate(String lastLoginDate) {
		this.lastLoginDate = lastLoginDate;
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
	public String getForeignState() {
		return foreignState;
	}
	public void setForeignState(String foreignState) {
		this.foreignState = foreignState;
	}
	public String getZip() {
		return zip;
	}
	public void setZip(String zip) {
		this.zip = zip;
	}
	public String getForeignPostalCode() {
		return foreignPostalCode;
	}
	public void setForeignPostalCode(String foreignPostalCode) {
		this.foreignPostalCode = foreignPostalCode;
	}
	public int getCountry() {
		return country;
	}
	public void setCountry(int country) {
		this.country = country;
	}
	public String getIsVettedBuyer() {
		return isVettedBuyer;
	}
	public void setIsVettedBuyer(String isVettedBuyer) {
		this.isVettedBuyer = isVettedBuyer;
	}
	public String getBuyerVettingMethod() {
		return buyerVettingMethod;
	}
	public void setBuyerVettingMethod(String buyerVettingMethod) {
		this.buyerVettingMethod = buyerVettingMethod;
	}
	public String getBuyerPurchaseCapLow() {
		return buyerPurchaseCapLow;
	}
	public void setBuyerPurchaseCapLow(String buyerPurchaseCapLow) {
		this.buyerPurchaseCapLow = buyerPurchaseCapLow;
	}
	public String getBuyerPurchaseCapHigh() {
		return buyerPurchaseCapHigh;
	}
	public void setBuyerPurchaseCapHigh(String buyerPurchaseCapHigh) {
		this.buyerPurchaseCapHigh = buyerPurchaseCapHigh;
	}
	public LocalDateTime getBuyerVettingDate() {
		return buyerVettingDate;
	}
	public void setBuyerVettingDate(LocalDateTime buyerVettingDate) {
		this.buyerVettingDate = buyerVettingDate;
	}
	public int getCreatedByUserId() {
		return createdByUserId;
	}
	public void setCreatedByUserId(int createdByUserId) {
		this.createdByUserId = createdByUserId;
	}
	public LocalDateTime getCreateDate() {
		return createDate;
	}
	public void setCreateDate(LocalDateTime createDate) {
		this.createDate = createDate;
	}
	public int getUpdatedByUserId() {
		return updatedByUserId;
	}
	public void setUpdatedByUserId(int updatedByUserId) {
		this.updatedByUserId = updatedByUserId;
	}
	public LocalDateTime getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(LocalDateTime updateDate) {
		this.updateDate = updateDate;
	}
}
