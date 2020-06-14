package com.brw.dto;

import java.util.List;

/**
 * @author sidpatil
 * 2020
 */
public class StateCountyCitiesDTO {

	private String stateCode;
	private String stateName;
	private List<CountyDTO> listsOfCounties;
	private List<String> listsOfCities;
	
	public String getStateCode() {
		return stateCode;
	}
	public void setStateCode(String stateCode) {
		this.stateCode = stateCode;
	}
	public String getStateName() {
		return stateName;
	}
	public void setStateName(String stateName) {
		this.stateName = stateName;
	}
	public List<CountyDTO> getListsOfCounties() {
		return listsOfCounties;
	}
	public void setListsOfCounties(List<CountyDTO> listsOfCounties) {
		this.listsOfCounties = listsOfCounties;
	}
	public List<String> getListsOfCities() {
		return listsOfCities;
	}
	public void setListsOfCities(List<String> listsOfCities) {
		this.listsOfCities = listsOfCities;
	}
}