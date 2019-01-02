package com.brw.dto;

import java.util.List;

import javax.persistence.Column;

public class UserProfileDTO {
	private int id;
	
	private String firstName;

	private String lastName;
	
	private String emailId;
	
	private String contactNumber;
	
	private String aboutAgent;
	
	private String agentTitle;
	
	private String location;
	
	private String address;
	
	private String city;
	
	private String state;
	
	private String country;
	
	private int zipcode;
	
	private String userImgUrl;
	
	private String userType;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public String getAboutAgent() {
		return aboutAgent;
	}

	public void setAboutAgent(String aboutAgent) {
		this.aboutAgent = aboutAgent;
	}

	public String getAgentTitle() {
		return agentTitle;
	}

	public void setAgentTitle(String agentTitle) {
		this.agentTitle = agentTitle;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
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

	public int getZipcode() {
		return zipcode;
	}

	public void setZipcode(int zipcode) {
		this.zipcode = zipcode;
	}

	public String getUserImgUrl() {
		return userImgUrl;
	}

	public void setUserImgUrl(String userImgUrl) {
		this.userImgUrl = userImgUrl;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}
	
	
}
