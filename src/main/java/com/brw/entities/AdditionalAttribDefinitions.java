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
@Table(name = "t_brw_business_add_attribute_def")
@Inheritance(strategy = InheritanceType.JOINED)
public class AdditionalAttribDefinitions implements Serializable {
	
	private static final long serialVersionUID = -8504035975938683238L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	@Column(name = "type")
	private String attributeType;
	
	@Column(name = "sub_type")
	private String attributeSubType;
	
	@Column(name = "business_type")
	private String bizType;
	
	@Column(name = "business_sub_type")
	private String bizSubType;

	public String getAttributeType() {
		return attributeType;
	}

	public void setAttributeType(String attributeType) {
		this.attributeType = attributeType;
	}

	public String getAttributeSubType() {
		return attributeSubType;
	}

	public void setAttributeSubType(String attributeSubType) {
		this.attributeSubType = attributeSubType;
	}

	public String getBizType() {
		return bizType;
	}

	public void setBizType(String bizType) {
		this.bizType = bizType;
	}

	public String getBizSubType() {
		return bizSubType;
	}

	public void setBizSubType(String bizSubType) {
		this.bizSubType = bizSubType;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}