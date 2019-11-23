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
@Table(name = "t_brw_estimate")
@Inheritance(strategy = InheritanceType.JOINED)
public class Estimates implements Serializable {
	
	private static final long serialVersionUID = -8504035975938683238L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	@Column(name = "est_id")
	private int estimateId;
	
	@Column(name = "biz_id")
	private int businessId;
	
	@Column(name = "type")
	private String estimateType;
	
	@Column(name = "sub_type")
	private String estimateSubType;
	
	@Column(name = "est_amount")
	private String estimatedAmount;
	
	@Column(name = "est_amount_high")
	private String estimatedAmountHigh;
	
	@Column(name = "est_amount_low")
	private String estimatedAmountLow;
	
	@Column(name = "last_est_date")
	private LocalDateTime lastEstimationDate;

	public int getEstimateId() {
		return estimateId;
	}

	public void setEstimateId(int estimateId) {
		this.estimateId = estimateId;
	}

	public int getBusinessId() {
		return businessId;
	}

	public void setBusinessId(int businessId) {
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

	public LocalDateTime getLastEstimationDate() {
		return lastEstimationDate;
	}

	public void setLastEstimationDate(LocalDateTime lastEstimationDate) {
		this.lastEstimationDate = lastEstimationDate;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}