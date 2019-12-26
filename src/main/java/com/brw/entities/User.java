package com.brw.entities;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Table(name = "t_brw_user")
@Inheritance(strategy = InheritanceType.JOINED)
public class User implements Serializable {

	private static final long serialVersionUID = 7488754260792718849L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id")
	private int user_id;
	
	@Column(name = "email")
	private String email;

	@Column(name = "name_first")
	private String firstName;
	
	@Column(name = "name_m_initial")
	private String middleInitial;
	
	@Column(name = "name_last")
	private String lastName;
	
	@Column(name = "isBroker_YN")
	private String isBroker;
	
	@Column(name = "phone_country")
	private String phoneCountryCode;
	
	@Column(name = "phone_number")
	private String phoneNumber;
	
	@Column(name = "phone_ext")
	private String phoneExtention;
	
	@Column(name = "srchagent_email_YN")
	private String isSearchAgentEmail;
	
	@Column(name = "srchagent_email_frequency")
	private String searchAgentEmailFreq;
	
	@Column(name = "user_verification_YN")
	private String isUserVerified;
	
	@Column(name = "user_verification_date")
	private LocalDateTime userVerificationDate;
	
	@Column(name = "user_verification_method")
	private String userVerificationMethod;
	
	@Column(name = "broker_verification_YN")
	private String isBrokerVerified;
	
	@Column(name = "broker_verification_date")
	private LocalDateTime brokerVerificationDate;
	
	@Column(name = "broker_verification_method")
	private String brokerVerificationMethod;
	
	@Column(name = "broker_license_number")
	private String brokerLicenseNumber;
	
	@Column(name = "broker_description")
	private String brokerDescription;
	
	@Column(name = "broker_image_url")
	private String brokerImageUrl;
	
	@Column(name = "last_login_date")
	private String lastLoginDate;
	
	@Column(name = "add_street1")
	private String street1;
	
	@Column(name = "add_street2")
	private String street2;
	
	@Column(name = "add_city")
	private String city;
	
	@Column(name = "add_state")
	private String state;
	
	@Column(name = "add_foreign_state")
	private String foreignState;
	
	@Column(name = "add_zip")
	private String zip;
	
	@Column(name = "add_foreign_postalcode")
	private String foreignPostalCode;
	
	@Column(name = "add_country")
	private int country;
	
	@Column(name = "vetted_buyer_YN")
	private String isVettedBuyer;
	
	@Column(name = "vetted_method")
	private String buyerVettingMethod;
	
	@Column(name = "vetted_for_amountlow")
	private String buyerPurchaseCapLow;
	
	@Column(name = "vetted_for_amounthigh")
	private String buyerPurchaseCapHigh;
	
	@Column(name = "vetted_date")
	private LocalDateTime buyerVettingDate;

	@Column(name = "createdby_user_id")
	private int createdByUserId;
	
	@Column(name = "create_date")
	private LocalDateTime createDate;
	
	@Column(name = "updatedby_user_id")
	private int updatedByUserId;
	
	@Column(name = "update_date")
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
