package com.brw.dto;

/**
 * @author sidapatil
 * 2020
 */

import java.io.Serializable;

public class UploadImageDTO implements Serializable {

	private static final long serialVersionUID = 1941284759903233525L;
	
	private String title;
	private String imageBase64;
	private String s3url;

	private int createdByUserId;
	private String createDate;
	private int updatedByUserId;
	private String updateDate;
	
	public String getS3url() {
		return s3url;
	}
	public void setS3url(String s3url) {
		this.s3url = s3url;
	}
	public int getCreatedByUserId() {
		return createdByUserId;
	}
	public void setCreatedByUserId(int createdByUserId) {
		this.createdByUserId = createdByUserId;
	}
	public String getCreateDate() {
		return createDate;
	}
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}
	public int getUpdatedByUserId() {
		return updatedByUserId;
	}
	public void setUpdatedByUserId(int updatedByUserId) {
		this.updatedByUserId = updatedByUserId;
	}
	public String getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(String updateDate) {
		this.updateDate = updateDate;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getImageBase64() {
		return imageBase64;
	}
	public void setImageBase64(String imageBase64) {
		this.imageBase64 = imageBase64;
	}
}