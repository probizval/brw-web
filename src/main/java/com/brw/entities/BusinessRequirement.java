package com.brw.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Table(name = "rw_buy_business_requirements")
@Inheritance(strategy = InheritanceType.JOINED)
public class BusinessRequirement implements Serializable {

	private static final long serialVersionUID = 1532152977931395965L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "user_id")
	private int userId;
	
	@Column(name = "business_category")
	private String businessCategory;
	
	@Column(name = "business_type")
	private String businessType;
	
	@Column(name = "other_business_category")
	private String otherBusinessCategory;
	
	@Column(name = "other_business_type")
	private String otherBusinessType;
	
	@Column(name = "radius")
	private int radius;
	
	@Column(name = "min_price")
	private int minPrice;
	
	@Column(name = "max_price")
	private int maxPrice;
	
	@Column(name = "min_lot_size")
	private int minLotSize;
	
	@Column(name = "max_lot_size")
	private int maxLotSize;
	
	@Column(name = "business_description")
	private String businessDescription;
	
	@Column(name = "business_location")
	private String businessLocation;
	
	@Column(name = "address")
	private String address;
	
	@Column(name = "city")
	private String city;
	
	@Column(name = "state")
	private String state;
	
	@Column(name = "country")
	private String country;
	
	@Column(name = "zip_code")
	private int zipCode;
	
	@Column(name = "latitude")
	private Double latitude;
	
	@Column(name = "longitude")
	private Double longitude;
	
	@Column(name = "first_name")
	private String firstName;
	
	@Column(name = "last_name")
	private String lastName;
	
	@Column(name = "email_adress")
	private String emailAdress;
	
	@Column(name = "contact_number")
	private String contactNumber;
	
	@Column(name = "mode_of_contact")
	private String modeOfContact;
	
	@Column(name = "connect_with_local_agents")
	private Boolean isConnectWithLocalAgents;
	
	@Column(name = "send_matched_businesses_email")
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

	public int getZipCode() {
		return zipCode;
	}

	public void setZipCode(int zipCode) {
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