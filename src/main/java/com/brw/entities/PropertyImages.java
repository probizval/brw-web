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
@Table(name = "rw_property_images")
@Inheritance(strategy = InheritanceType.JOINED)
public class PropertyImages implements Serializable {

	private static final long serialVersionUID = -8691356959147177631L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "property_code", nullable = false)
	private String propertyCode;
	
	@Column(name = "image_url", nullable = false)
	private String imageUrl;
	
	@Column(name = "property_details_id", nullable = false)
	private int propertyDetailsId;
	

	public int getPropertyDetailsId() {
		return propertyDetailsId;
	}

	public void setPropertyDetailsId(int propertyDetailsId) {
		this.propertyDetailsId = propertyDetailsId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPropertyCode() {
		return propertyCode;
	}

	public void setPropertyCode(String propertyCode) {
		this.propertyCode = propertyCode;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	

}
