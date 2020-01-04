package com.brw.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PropertyAttributesFromPBResponse {
	
	private String category;
	private List<Variable> individualValueVariable;
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public List<Variable> getIndividualValueVariable() {
		return individualValueVariable;
	}
	public void setIndividualValueVariable(List<Variable> individualValueVariable) {
		this.individualValueVariable = individualValueVariable;
	}
	@Override
	public String toString() {
		return "PropertyAttributesFromPBResponse [category=" + category + ", individualValueVariable="
				+ individualValueVariable + "]";
	}
}