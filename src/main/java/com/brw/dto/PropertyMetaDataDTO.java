package com.brw.dto;

import java.io.Serializable;
import java.util.List;

import com.brw.entities.PropertyDetails;
import com.brw.entities.PropertyImages;

public class PropertyMetaDataDTO implements Serializable{


private static final long serialVersionUID = 4680239861087741457L;

private PropertyDetails propertyMetaData;
	
private List<PropertyImages> propertyImages;

public PropertyDetails getPropertyMetaData() {
	return propertyMetaData;
}

public void setPropertyMetaData(PropertyDetails propertyMetaData) {
	this.propertyMetaData = propertyMetaData;
}

public List<PropertyImages> getPropertyImages() {
	return propertyImages;
}

public void setPropertyImages(List<PropertyImages> propertyImages) {
	this.propertyImages = propertyImages;
}


	
}
