package com.brw.dto;


/**
 * @author sidpatil
 * 2020
 */

public class BusinessInfoDTO {

	private Integer invokerId;
	private Integer businessId;
	private String name;
	private String googleName;
	private String type;
	private String subType;
	private String isForSell;
	private String isHidden;
	private Integer forSellPrice;
	private Integer marketBasedEst;
	private String imageLogo;
	private String imageFirst;
	private String [] googlePhotoReferances;
	private String street1;
	private String street2;
	private String city;
	private String county;
	private String stateCode;
	private String zip;
	private double latitude;
	private double longitude;
	private String googleAddress;
	private Integer rangeMile;
	private String isFranchise;
	private String isEstimateAvailable;
	private String isVendorCall;
	
	public Integer getInvokerId() {
		return invokerId;
	}
	public void setInvokerId(Integer invokerId) {
		this.invokerId = invokerId;
	}
	public Integer getBusinessId() {
		return businessId;
	}
	public void setBusinessId(Integer businessId) {
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
	public String getIsForSell() {
		return isForSell;
	}
	public void setIsForSell(String isForSell) {
		this.isForSell = isForSell;
	}
	public Integer getForSellPrice() {
		return forSellPrice;
	}
	public void setForSellPrice(Integer forSellPrice) {
		this.forSellPrice = forSellPrice;
	}
	public Integer getMarketBasedEst() {
		return marketBasedEst;
	}
	public void setMarketBasedEst(Integer marketBasedEst) {
		this.marketBasedEst = marketBasedEst;
	}
	public String getIsHidden() {
		return isHidden;
	}

	public void setIsHidden(String isHidden) {
		this.isHidden = isHidden;
	}
	public String getImageLogo() {
		return imageLogo;
	}
	public void setImageLogo(String imageLogo) {
		this.imageLogo = imageLogo;
	}
	public String getImageFirst() {
		return imageFirst;
	}
	public void setImageFirst(String imageFirst) {
		this.imageFirst = imageFirst;
	}
	public String[] getGooglePhotoReferances() {
		return googlePhotoReferances;
	}
	public void setGooglePhotoReferances(String[] googlePhotoReferances) {
		this.googlePhotoReferances = googlePhotoReferances;
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
	public Integer getRangeMile() {
		return rangeMile;
	}
	public void setRangeMile(Integer rangeMile) {
		this.rangeMile = rangeMile;
	}
	public String getIsFranchise() {
		return isFranchise;
	}
	public void setIsFranchise(String isFranchise) {
		this.isFranchise = isFranchise;
	}
	public String getIsEstimateAvailable() {
		return isEstimateAvailable;
	}
	public void setIsEstimateAvailable(String isEstimateAvailable) {
		this.isEstimateAvailable = isEstimateAvailable;
	}
	public String getIsVendorCall() {
		return isVendorCall;
	}
	public void setIsVendorCall(String isVendorCall) {
		this.isVendorCall = isVendorCall;
	}
	public String getGoogleName() {
		return googleName;
	}
	public void setGoogleName(String googleName) {
		this.googleName = googleName;
	}
	public String getGoogleAddress() {
		return googleAddress;
	}
	public void setGoogleAddress(String googleAddress) {
		this.googleAddress = googleAddress;
	}
}