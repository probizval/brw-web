package com.brw.service;

import com.brw.dto.BusinessDetailsDTO;
import com.brw.dto.DataFromPBDTO;
import com.brw.exceptions.DataFromPBException;

/**
 * @author sidpatil
 * 2019
 */
public interface DataFromPBService {
	
	//Request URI - https://api.pitneybowes.com/location-intelligence/geoproperty/v1/all/attributes/bypbkey?pbKey=P00003PZZOIE
	public DataFromPBDTO getGeoPropertyByPBKey(String pbKey) throws DataFromPBException;
	public BusinessDetailsDTO updateGeoPropertyPBDataToBDB(BusinessDetailsDTO businessDetailsDTO);
	public void updateGeoPropertyPBDataToMDB(DataFromPBDTO dataFromPBDTO);
	//public EstimatesDTO updateEstimates(EstimatesDTO estimatesDTO);

}