package com.brw.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.InheritanceType;

@Entity
@DynamicUpdate
@Table(name = "t_brw_business")
@Inheritance(strategy = InheritanceType.JOINED)
public class BusinessInfo implements Serializable {
	
	private static final long serialVersionUID = -8504035975938683238L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	@Column(name = "biz_id")
	private int businessId;
	
	@Column(name = "name_dba")
	private String name;
	
	@Column(name = "type")
	private String type;
	
	@Column(name = "sub_type")
	private String subType;
	
	@Column(name = "for_sell_YN")
	private String isForSell;
	
	@Column(name = "hidden_YN")
	private String isHidden;
	
	@Column(name = "franchise_YN")
	private String isFranchise;
	
	@Column(name = "for_sell_price")
	private int forSellPrice;
	
	@Column(name = "market_based_est")
	private int marketBasedEst;
	
	@Column(name = "image_first")
	private String imageFirst;
	
	@Column(name = "add_street1")
	private String street1;
	
	@Column(name = "add_street2")
	private String street2;
	
	@Column(name = "add_city")
	private String city;
	
	@Column(name = "add_county")
	private String county;
	
	@Column(name = "add_state")
	private String stateCode;
	
	@Column(name = "add_zip")
	private String zip;
	
	@Column(name = "gg_formatted_add")
	private String gFormattedAdd;
	
	@Column(name = "latitude")
	private double latitude;
	
	@Column(name = "longitude")
	private double longitude;
	
	@Column(name = "vendor_call_YN")
	private String isVendorCall;

	public int getBusinessId() {
		return businessId;
	}

	public void setBusinessId(int businessId) {
		this.businessId = businessId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getSubType() {
		return subType;
	}

	public void setSubType(String subType) {
		this.subType = subType;
	}

	public int getForSellPrice() {
		return forSellPrice;
	}

	public void setForSellPrice(int forSellPrice) {
		this.forSellPrice = forSellPrice;
	}

	public int getMarketBasedEst() {
		return marketBasedEst;
	}

	public void setMarketBasedEst(int marketBasedEst) {
		this.marketBasedEst = marketBasedEst;
	}

	public String getIsForSell() {
		return isForSell;
	}

	public void setIsForSell(String isForSell) {
		this.isForSell = isForSell;
	}
	
	public String getIsHidden() {
		return isHidden;
	}

	public void setIsHidden(String isHidden) {
		this.isHidden = isHidden;
	}

	public String getIsFranchise() {
		return isFranchise;
	}

	public void setIsFranchise(String isFranchise) {
		this.isFranchise = isFranchise;
	}

	public String getImageFirst() {
		return imageFirst;
	}

	public void setImageFirst(String imageFirst) {
		this.imageFirst = imageFirst;
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

	public String getCounty() {
		return county;
	}

	public void setCounty(String county) {
		this.county = county;
	}

	public String getStateCode() {
		return stateCode;
	}

	public void setStateCode(String stateCode) {
		this.stateCode = stateCode;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public String getgFormattedAdd() {
		return gFormattedAdd;
	}

	public void setgFormattedAdd(String gFormattedAdd) {
		this.gFormattedAdd = gFormattedAdd;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public String getIsVendorCall() {
		return isVendorCall;
	}

	public void setIsVendorCall(String isVendorCall) {
		this.isVendorCall = isVendorCall;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}