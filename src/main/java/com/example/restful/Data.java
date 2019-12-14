package com.example.restful;

import com.brw.dto.PropertyMetaDataDTO;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Data{

	private PropertyMetaDataDTO propertyMetaData;

	public PropertyMetaDataDTO getPropertyMetaData() {
		return propertyMetaData;
	}
	
	public void setPropertyMetaData(PropertyMetaDataDTO propertyMetaData) {
		this.propertyMetaData = propertyMetaData;
	}	
	
}
