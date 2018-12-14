package com.brw.entities;


import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.Table;
import javax.persistence.InheritanceType;

@Entity
@Table(name = "rw_property_details")
@Inheritance(strategy = InheritanceType.JOINED)
public class PropertyDetails implements Serializable {
	
	private static final long serialVersionUID = -8504035975938683238L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "property_name", nullable = false)
	private String propertyName;
	
	@Column(name = "property_code")
	private String propertyCode;
	
	@Column(name = "property_type")
	private String propertyType;
	
	@Column(name = "property_id")
	private String propertyId;

	@Column(name = "business_type_code")
	private String businessTypeCode;
	
	@Column(name = "business_type")
	private String businessType;
	
	@Column(name = "city")
	private String city;
	
	@Column(name = "current_owner_name")
	private String currentOwner;
	
	@Column(name = "estated_estimated_value")
	private Double estatesEstimatedValue;
	
	@Column(name = "img_url")
	private String imageUrl;
	
	@Column(name = "latitude")
	private Double latitude;
	
	@Column(name = "longitude")
	private Double longitude;
	
	@Column(name = "lot_size")
	private Double lotSize;
	
	@Column(name = "property_address")
	private String propertyAddress;
	
	@Column(name = "state")
	private String state;
	
	@Column(name = "zip_code")
	private Integer zipCode;	
		
	@Column(name = "zoning_category")
	private String zoningCategory;
	
	
	
	
	
	


	public String getPropertyCode() {
		return propertyCode;
	}

	public void setPropertyCode(String propertyCode) {
		this.propertyCode = propertyCode;
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

	public Double getEstatesEstimatedValue() {
		return estatesEstimatedValue;
	}

	public void setEstatesEstimatedValue(Double estatesEstimatedValue) {
		this.estatesEstimatedValue = estatesEstimatedValue;
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

	public String getPropertyId() {
		return propertyId;
	}

	public void setPropertyId(String propertyId) {
		this.propertyId = propertyId;
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