package com.brw.dto;



public class PaymentDTO {
private String token;
	
	public String getToken() {
	return token;
}

public void setToken(String token) {
	this.token = token;
}

public Double getAmount() {
	return amount;
}

public void setAmount(Double amount) {
	this.amount = amount;
}

	private Double amount;
}