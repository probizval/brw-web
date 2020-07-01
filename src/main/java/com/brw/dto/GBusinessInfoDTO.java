package com.brw.dto;

/**
 * @author sidpatil
 * 2020
 */

public class GBusinessInfoDTO {

	private Integer invokerId;
	private Integer bizId;
	private String gPlaceId;
	private String gBusinessName;
	private String gFormattedAddress;
	private double gLatitude;
	private double gLongitude;
	private String gRating;
	private String gIsClosed;
	private String gSinglePhotoUrl;
	private String[] gPhotoUrls;
	
	public Integer getInvokerId() {
		return invokerId;
	}
	public void setInvokerId(Integer invokerId) {
		this.invokerId = invokerId;
	}
	public Integer getBizId() {
		return bizId;
	}
	public void setBizId(Integer bizId) {
		this.bizId = bizId;
	}
	public String getgPlaceId() {
		return gPlaceId;
	}
	public void setgPlaceId(String gPlaceId) {
		this.gPlaceId = gPlaceId;
	}
	public String getgBusinessName() {
		return gBusinessName;
	}
	public void setgBusinessName(String gBusinessName) {
		this.gBusinessName = gBusinessName;
	}
	public String getgFormattedAddress() {
		return gFormattedAddress;
	}
	public void setgFormattedAddress(String gFormattedAddress) {
		this.gFormattedAddress = gFormattedAddress;
	}
	public double getgLatitude() {
		return gLatitude;
	}
	public void setgLatitude(double gLatitude) {
		this.gLatitude = gLatitude;
	}
	public double getgLongitude() {
		return gLongitude;
	}
	public void setgLongitude(double gLongitude) {
		this.gLongitude = gLongitude;
	}
	public String getgRating() {
		return gRating;
	}
	public void setgRating(String gRating) {
		this.gRating = gRating;
	}
	public String getgIsClosed() {
		return gIsClosed;
	}
	public void setgIsClosed(String gIsClosed) {
		this.gIsClosed = gIsClosed;
	}
	
	public String getgSinglePhotoUrl() {
		return gSinglePhotoUrl;
	}
	public void setgSinglePhotoUrl(String gSinglePhotoUrl) {
		this.gSinglePhotoUrl = gSinglePhotoUrl;
	}
	public String[] getgPhotoUrls() {
		return gPhotoUrls;
	}
	public void setgPhotoUrls(String[] gPhotoUrls) {
		this.gPhotoUrls = gPhotoUrls;
	}
}