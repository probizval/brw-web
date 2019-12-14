package com.brw.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpServerErrorException.InternalServerError;

import com.brw.dto.BusinessDetailsDTO;
import com.brw.dto.DataFromPBDTO;

import com.brw.service.BusinessService;

/**
 * @author sidpatil
 * 2019
 */

@Component
public class DataFromPBServiceImpl implements com.brw.service.DataFromPBService {
	
	@Autowired
	BusinessService businessService;
	
	@Override
	public DataFromPBDTO getGeoPropertyByPBKey(String pbKey) {
		// TODO Auto-generated method stub
		System.out.println("**** 222 Inside BusinessServiceImpl.getBusinessDetails() pbKey: "+pbKey);
		
		DataFromPBDTO dataFromPBDTO = null;
		//(DataFromPBDTO) dataFromPBDAO.getGeoPropertyByPBKey(pbKey);
		
		return dataFromPBDTO;
	}

	@Override
	public BusinessDetailsDTO updateGeoPropertyPBDataToBDB(BusinessDetailsDTO businessDetailsDTO) {
		//Method to UPDATE Business Details in BRW DB based on data returned by PB API
		
		BusinessDetailsDTO updatedBizDetailsDTO = null;
		try {
			updatedBizDetailsDTO = businessService.updateBusinessDetails(businessDetailsDTO);
			
		} catch (InternalServerError e) {
			e.printStackTrace();
		}
		return updatedBizDetailsDTO;
	}
	
	@Override
	public void updateGeoPropertyPBDataToMDB(DataFromPBDTO dataFromPBDTO) {
		// TODO This method is to update data in Mongo DB - to capture all attributes for the business returned by PB API
		System.out.println("222 **** Inside BusinessServiceImpl.updateBusinessDetails() businessDetailsDTO.getRegCityDate()");
		
	}
}