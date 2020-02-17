package com.brw.entities;

import java.io.Serializable;
import java.time.LocalDateTime;

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
@Table(name = "t_brw_image")
@Inheritance(strategy = InheritanceType.JOINED)
public class Image implements Serializable {
	
	private static final long serialVersionUID = -8504035975938683238L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	@Column(name = "image_id")
	private int imageId;
	
	@Column(name = "biz_id")
	private int businessId;
	
	@Column(name = "title")
	private String title;
	
	@Column(name = "url")
	private String url;
	
	@Column(name = "createdby_user_id")
	private int createdByUserId;
	
	@Column(name = "create_date")
	private LocalDateTime createDate;
	
	@Column(name = "updatedby_user_id")
	private int updatedByUserId;
	
	@Column(name = "update_date")
	private LocalDateTime updateDate;

	public int getImageId() {
		return imageId;
	}

	public void setImageId(int imageId) {
		this.imageId = imageId;
	}

	public int getBusinessId() {
		return businessId;
	}

	public void setBusinessId(int businessId) {
		this.businessId = businessId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
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