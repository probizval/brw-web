package com.brw.dto;


/**
 * @author sidpatil
 * 2019
 */

public class EstimatesDTO {

	private Integer invokerId;
	private Integer estimateId;
	private Integer businessId;
	private String estimateType;
	private String estimateSubType;
	private String estimatedAmount;
	private String estimatedAmountHigh;
	private String estimatedAmountLow;
	private String lastEstimationDate;
	public Integer getInvokerId() {
		return invokerId;
	}
	public void setInvokerId(Integer invokerId) {
		this.invokerId = invokerId;
	}
	public Integer getEstimateId() {
		return estimateId;
	}
	public void setEstimateId(Integer estimateId) {
		this.estimateId = estimateId;
	}
	public Integer getBusinessId() {
		return businessId;
	}
	public void setBusinessId(Integer businessId) {
		this.businessId = businessId;
	}
	public String getEstimateType() {
		return estimateType;
	}
	public void setEstimateType(String estimateType) {
		this.estimateType = estimateType;
	}
	public String getEstimateSubType() {
		return estimateSubType;
	}
	public void setEstimateSubType(String estimateSubType) {
		this.estimateSubType = estimateSubType;
	}
	public String getEstimatedAmount() {
		return estimatedAmount;
	}
	public void setEstimatedAmount(String estimatedAmount) {
		this.estimatedAmount = estimatedAmount;
	}
	public String getEstimatedAmountHigh() {
		return estimatedAmountHigh;
	}
	public void setEstimatedAmountHigh(String estimatedAmountHigh) {
		this.estimatedAmountHigh = estimatedAmountHigh;
	}
	public String getEstimatedAmountLow() {
		return estimatedAmountLow;
	}
	public void setEstimatedAmountLow(String estimatedAmountLow) {
		this.estimatedAmountLow = estimatedAmountLow;
	}
	public String getLastEstimationDate() {
		return lastEstimationDate;
	}
	public void setLastEstimationDate(String lastEstimationDate) {
		this.lastEstimationDate = lastEstimationDate;
	}
}