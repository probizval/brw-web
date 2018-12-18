package com.brw.dto;

import java.io.Serializable;
import java.util.List;

public class PropertyListDTO implements Serializable {

	private static final long serialVersionUID = -65223447914153444L;
	
	private List<PropertyDetailsDTO> propertyList;

	public List<PropertyDetailsDTO> getPropertyList() {
		return propertyList;
	}

	public void setPropertyList(List<PropertyDetailsDTO> propertyList) {
		this.propertyList = propertyList;
	}
	
}
