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
@Table(name = "t_brw_business_transaction")
@Inheritance(strategy = InheritanceType.JOINED)
public class BizTransactions implements Serializable {
	
	private static final long serialVersionUID = -8504035975938683238L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	@Column(name = "transaction_id")
	private int transactionId;
	
	@Column(name = "biz_id")
	private int businessId;
	
	@Column(name = "type")
	private String transactionType;
	
	@Column(name = "sub_type")
	private String transactionSubType;
	
	@Column(name = "date")
	private LocalDateTime transactionDate;
	
	@Column(name = "amount")
	private String transactionAmount;
	
	@Column(name = "isVerified_YN")
	private String isVerified;
	
	@Column(name = "verification_method")
	private String verificationMethod;
	
	@Column(name = "createdby_user_id")
	private int createdByUserId;
	
	@Column(name = "created_date")
	private LocalDateTime createDate;
	
	@Column(name = "updatedby_user_id")
	private int updatedByUserId;
	
	@Column(name = "updated_date")
	private LocalDateTime updateDate;

	public int getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
	}

	public int getBusinessId() {
		return businessId;
	}

	public void setBusinessId(int businessId) {
		this.businessId = businessId;
	}

	public String getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}

	public String getTransactionSubType() {
		return transactionSubType;
	}

	public void setTransactionSubType(String transactionSubType) {
		this.transactionSubType = transactionSubType;
	}

	public LocalDateTime getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(LocalDateTime transactionDate) {
		this.transactionDate = transactionDate;
	}

	public String getTransactionAmount() {
		return transactionAmount;
	}

	public void setTransactionAmount(String transactionAmount) {
		this.transactionAmount = transactionAmount;
	}

	public String getIsVerified() {
		return isVerified;
	}

	public void setIsVerified(String isVerified) {
		this.isVerified = isVerified;
	}

	public String getVerificationMethod() {
		return verificationMethod;
	}

	public void setVerificationMethod(String verificationMethod) {
		this.verificationMethod = verificationMethod;
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