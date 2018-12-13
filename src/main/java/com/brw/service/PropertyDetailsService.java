package com.brw.service;

import java.util.List;

import com.brw.dto.FilterDTO;
import com.brw.dto.GasStationDetailsDTO;
import com.brw.dto.PropertyDetailsDTO;
import com.brw.dto.PropertyListDTO;
import com.brw.exceptions.PropertyDetailsException;


public interface PropertyDetailsService {
	public PropertyListDTO getAllPropertyList(FilterDTO filter);
	public PropertyDetailsDTO getPropertyDetails(int id) throws PropertyDetailsException;
	public PropertyDetailsDTO savePropertyDetail(PropertyDetailsDTO propertyDetailsDTO);
	public PropertyDetailsDTO updatePropertyDetail(PropertyDetailsDTO propertyDetailsDTO);
	public GasStationDetailsDTO getGasStationPropertyDetails(int id) throws PropertyDetailsException;
	public GasStationDetailsDTO saveGasStationPropertyDetail(GasStationDetailsDTO gasStationDetailsDTO) throws PropertyDetailsException;
}