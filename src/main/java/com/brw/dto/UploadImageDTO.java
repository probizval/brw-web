package com.brw.dto;

/**
 * @author sidapatil
 * 2020
 */

import java.io.Serializable;

import org.springframework.web.multipart.MultipartFile;

public class UploadImageDTO implements Serializable {

	private static final long serialVersionUID = 1941284759903233525L;
		
	private MultipartFile file;
	private String jsonData;
	
	private String imageDescription;
	private String imageBase64;

	private int createdByUserId;
	private String createDate;
	private int updatedByUserId;
	private String updateDate;
	
	public MultipartFile getFile() {
		return file;
	}
	public void setFile(MultipartFile file) {
		this.file = file;
	}
	public String getJsonData() {
		return jsonData;
	}
	public void setJsonData(String jsonData) {
		this.jsonData = jsonData;
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
	public String getImageDescription() {
		return imageDescription;
	}
	public void setImageDescription(String imageDescription) {
		this.imageDescription = imageDescription;
	}
	public String getImageBase64() {
		return imageBase64;
	}
	public void setImageBase64(String imageBase64) {
		this.imageBase64 = imageBase64;
	}
}