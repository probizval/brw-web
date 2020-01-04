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
@Table(name = "t_brw_business_add_attributes")
@Inheritance(strategy = InheritanceType.JOINED)
public class AdditionalAttributes implements Serializable {
	
	private static final long serialVersionUID = -8504035975938683238L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	@Column(name = "add_attribute_id")
	private int addAttributeId;
	
	@Column(name = "biz_id")
	private int businessId;
	
	@Column(name = "type")
	private String addAttribType;
	
	@Column(name = "sub_type")
	private String addAttribSubType;
	
	@Column(name = "value")
	private String value;
	
	@Column(name = "value_type")
	private String valueType;
	
	@Column(name = "quantity")
	private int quantity;
	
	@Column(name = "value_perunit_price")
	private int perUnitPrice;
	
	@Column(name = "exp_monthly_maint")
	private int monthlyMaintCost;
	
	@Column(name = "createdby_user_id")
	private int createdByUserId;
	
	@Column(name = "create_date")
	private LocalDateTime createDate;
	
	@Column(name = "updatedby_user_id")
	private int updatedByUserId;
	
	@Column(name = "update_date")
	private LocalDateTime updateDate;

	public int getAddAttributeId() {
		return addAttributeId;
	}

	public void setAddAttributeId(int addAttributeId) {
		this.addAttributeId = addAttributeId;
	}

	public int getBusinessId() {
		return businessId;
	}

	public void setBusinessId(int businessId) {
		this.businessId = businessId;
	}

	public String getAddAttribType() {
		return addAttribType;
	}

	public void setAddAttribType(String addAttribType) {
		this.addAttribType = addAttribType;
	}

	public String getAddAttribSubType() {
		return addAttribSubType;
	}

	public void setAddAttribSubType(String addAttribSubType) {
		this.addAttribSubType = addAttribSubType;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getValueType() {
		return valueType;
	}

	public void setValueType(String valueType) {
		this.valueType = valueType;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getPerUnitPrice() {
		return perUnitPrice;
	}

	public void setPerUnitPrice(int perUnitPrice) {
		this.perUnitPrice = perUnitPrice;
	}

	public int getMonthlyMaintCost() {
		return monthlyMaintCost;
	}

	public void setMonthlyMaintCost(int monthlyMaintCost) {
		this.monthlyMaintCost = monthlyMaintCost;
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