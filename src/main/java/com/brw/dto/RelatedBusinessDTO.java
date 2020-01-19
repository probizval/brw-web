package com.brw.dto;

/**
 * @author sidpatil
 * 2020
 */
public class RelatedBusinessDTO {

	private int invokerId;
	private int relationshipId;
	private int businessId;
	private int relatedBizId;
	private int createdByUserId;
	private String createDate;
	private int updatedByUserId;
	private String updateDate;
	
	public int getInvokerId() {
		return invokerId;
	}
	public void setInvokerId(int invokerId) {
		this.invokerId = invokerId;
	}
	public int getRelationshipId() {
		return relationshipId;
	}
	public void setRelationshipId(int relationshipId) {
		this.relationshipId = relationshipId;
	}
	public int getBusinessId() {
		return businessId;
	}
	public void setBusinessId(int businessId) {
		this.businessId = businessId;
	}
	public int getRelatedBizId() {
		return relatedBizId;
	}
	public void setRelatedBizId(int relatedBizId) {
		this.relatedBizId = relatedBizId;
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
