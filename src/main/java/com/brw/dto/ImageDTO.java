package com.brw.dto;

/**
 * @author siyapatil
 * 2019
 */

import java.io.Serializable;

public class ImageDTO implements Serializable {

	private static final long serialVersionUID = 1941284759903233525L;
	
	private int imageId;
	
	private int bizId;
	
	private String url;
	
	private String createdBy;
	
	private String createDate;
	
	private String updatedBy;
	
	private String updatDate;

	public int getImageId() {
		return imageId;
	}

	public void setImageId(int imageId) {
		this.imageId = imageId;
	}

	public int getBizId() {
		return bizId;
	}

	public void setBizId(int bizId) {
		this.bizId = bizId;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getCreateDate() {
		return createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	public String getUpdatDate() {
		return updatDate;
	}

	public void setUpdatDate(String updatDate) {
		this.updatDate = updatDate;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}