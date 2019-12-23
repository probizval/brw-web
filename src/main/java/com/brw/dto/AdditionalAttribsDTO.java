package com.brw.dto;


/**
 * @author sidpatil
 * 2019
 */

public class AdditionalAttribsDTO {

	private Integer invokerId;
	private Integer addAttribId;
	private Integer businessId;
	private String attribType;
	private String attribSubType;
	private String value;
	private Integer quantity;
	private Integer pricePerUnit;
	private Integer monthlyMaintExpense;
	private Integer createdByUserId;
	private String createDate;
	private Integer updatedByUserId;
	private String updateDate;
	
	public Integer getInvokerId() {
		return invokerId;
	}
	public void setInvokerId(Integer invokerId) {
		this.invokerId = invokerId;
	}
	public Integer getAddAttribId() {
		return addAttribId;
	}
	public void setAddAttribId(Integer addAttribId) {
		this.addAttribId = addAttribId;
	}
	public Integer getBusinessId() {
		return businessId;
	}
	public void setBusinessId(Integer businessId) {
		this.businessId = businessId;
	}
	public String getAttribType() {
		return attribType;
	}
	public void setAttribType(String attribType) {
		this.attribType = attribType;
	}
	public String getAttribSubType() {
		return attribSubType;
	}
	public void setAttribSubType(String attribSubType) {
		this.attribSubType = attribSubType;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public Integer getPricePerUnit() {
		return pricePerUnit;
	}
	public void setPricePerUnit(Integer pricePerUnit) {
		this.pricePerUnit = pricePerUnit;
	}
	public Integer getMonthlyMaintExpense() {
		return monthlyMaintExpense;
	}
	public void setMonthlyMaintExpense(Integer monthlyMaintExpense) {
		this.monthlyMaintExpense = monthlyMaintExpense;
	}
	public Integer getCreatedByUserId() {
		return createdByUserId;
	}
	public void setCreatedByUserId(Integer createdByUserId) {
		this.createdByUserId = createdByUserId;
	}
	public String getCreateDate() {
		return createDate;
	}
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}
	public Integer getUpdatedByUserId() {
		return updatedByUserId;
	}
	public void setUpdatedByUserId(Integer updatedByUserId) {
		this.updatedByUserId = updatedByUserId;
	}
	public String getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(String updateDate) {
		this.updateDate = updateDate;
	}
}