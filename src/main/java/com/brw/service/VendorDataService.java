package com.brw.service;

import com.brw.dto.BusinessDetailsDTO;
import com.brw.exceptions.DataFromPBException;

/**
 * @author sidpatil
 * 2019
 */
public interface VendorDataService {
	
	public BusinessDetailsDTO getBusinessDetailsFromPB(String street1, String street2, String city, String state, Integer zip) throws DataFromPBException;
}