package com.brw.dto;

import java.util.List;

/**
 * @author sidpatil
 * 2020
 */
public class StateCountyCitiesDTO {

	private String stateCode;
	private String stateName;
	private List<String> listsOfCounties;
	private List<String> listsOfCities;
	
	public String getStateCode() {
		return stateCode;
	}
	public void setStateCode(String stateCode) {
		this.stateCode = stateCode;
	}
	public List<String> getListsOfCounties() {
		return listsOfCounties;
	}
	public void setListsOfCounties(List<String> listsOfCounties) {
		this.listsOfCounties = listsOfCounties;
	}
	public String getStateName() {
		return stateName;
	}
	public void setStateName(String stateName) {
		this.stateName = stateName;
	}
	public List<String> getListsOfCities() {
		return listsOfCities;
	}
	public void setListsOfCities(List<String> listsOfCities) {
		this.listsOfCities = listsOfCities;
	}
	
}