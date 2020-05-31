package com.brw.dto;

/**
 * @author sidpatil
 * 2020
 */
public class UserBusinessDTO {

	private int userId;
	private String relationship;
	private int businessId;
	private BusinessInfoDTO businessInfoDTO;
	private int createdByUserId;
	private String createDate;
	private int updatedByUserId;
	private String updateDate;
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getRelationship() {
		return relationship;
	}
	public void setRelationship(String relationship) {
		this.relationship = relationship;
	}
	public int getBusinessId() {
		return businessId;
	}
	public void setBusinessId(int businessId) {
		this.businessId = businessId;
	}
	public BusinessInfoDTO getBusinessInfoDTO() {
		return businessInfoDTO;
	}
	public void setBusinessInfoDTO(BusinessInfoDTO businessInfoDTO) {
		this.businessInfoDTO = businessInfoDTO;
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
}
