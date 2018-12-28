package com.brw.service;

import java.util.List;

import com.brw.dao.RestaurentDAO;
import com.brw.dto.CoinLaundryDetailsDTO;
import com.brw.dto.FilterDTO;
import com.brw.dto.GasStationDetailsDTO;
import com.brw.dto.LiquorStoreDTO;
import com.brw.dto.PropertyDetailsDTO;
import com.brw.dto.PropertyListDTO;
import com.brw.dto.PropertyMetaDataDTO;
import com.brw.dto.RestaurantDetailsDTO;
import com.brw.dto.SalonStoreDTO;
import com.brw.exceptions.PropertyDetailsException;


public interface PropertyDetailsService {
	public PropertyListDTO getAllPropertyList(FilterDTO filter);
	public PropertyMetaDataDTO getPropertyDetails(int id) throws PropertyDetailsException;
	public PropertyDetailsDTO savePropertyDetail(PropertyDetailsDTO propertyDetailsDTO);
	public PropertyDetailsDTO updatePropertyDetail(PropertyDetailsDTO propertyDetailsDTO);
	public GasStationDetailsDTO getGasStationPropertyDetails(int id) throws PropertyDetailsException;
	public GasStationDetailsDTO saveGasStationPropertyDetail(GasStationDetailsDTO gasStationDetailsDTO) throws PropertyDetailsException;
	public GasStationDetailsDTO updateGasStationPropertyDetail(GasStationDetailsDTO gasStationDetailsDTO) throws PropertyDetailsException;
	public RestaurantDetailsDTO getRestaurantPropertyDetails(int id) throws PropertyDetailsException;
	public RestaurantDetailsDTO saveRestaurantPropertyDetail(RestaurantDetailsDTO restaurantDetailsDTO) throws PropertyDetailsException;
	public RestaurantDetailsDTO updateRestaurantPropertyDetail(RestaurantDetailsDTO restaurantDetailsDTO) throws PropertyDetailsException;
	public CoinLaundryDetailsDTO getCoinLaundryPropertyDetails(int id) throws PropertyDetailsException;
	public CoinLaundryDetailsDTO saveCoinLaundryPropertyDetail(CoinLaundryDetailsDTO coinLaundryDetailsDTO) throws PropertyDetailsException;
	public CoinLaundryDetailsDTO updateCoinLaundryPropertyDetail(CoinLaundryDetailsDTO coinLaundryDetailsDTO) throws PropertyDetailsException;
	
	public LiquorStoreDTO getLiquerStorePropertyDetails(int id) throws PropertyDetailsException;
	public LiquorStoreDTO saveLiquerStorePropertyDetail(LiquorStoreDTO liquorStoreDTO) throws PropertyDetailsException;
	public LiquorStoreDTO updateLiquerStorePropertyDetail(LiquorStoreDTO liquorStoreDTO) throws PropertyDetailsException;
	
	public SalonStoreDTO getSalonStorePropertyDetails(int id) throws PropertyDetailsException;
	public SalonStoreDTO saveSalonStorePropertyDetail(SalonStoreDTO salonStoreDTO) throws PropertyDetailsException;
	public SalonStoreDTO updateSalonStorePropertyDetail(SalonStoreDTO salonStoreDTO) throws PropertyDetailsException;
}