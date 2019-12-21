package com.brw.service.impl;

import java.nio.charset.Charset;

import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.brw.dto.BusinessDetailsDTO;
import com.brw.exceptions.DataFromPBException;
import com.brw.service.BusinessService;
import com.brw.dto.PropertyAttributesFromPBResponse;
import com.brw.dto.Variable;

/**
 * @author sidpatil
 * 2019
 */

@Component
public class VendorDataServiceImpl implements com.brw.service.VendorDataService {
	
	@Autowired
	BusinessService businessService;
	
	@Autowired
	@Qualifier("pbRestTemplate")
	private RestTemplate restTemplate;
	
	public BusinessDetailsDTO getBusinessDetailsFromPB(String street1, String street2, String city, String state, Integer zip) {
		System.out.println("**** 222 Inside VendorDataServiceImpl.getBusinessDetailsFromPB()");
		
		String key = "P7AHcLiRnqA4JL7R9wdtXjHQzcI0HlKh";
		String secret = "ZMuVFQxqqGWrfsnd";
		
		String addressString = ""+street1+", "+street2+", "+city+", "+state+", "+zip;
								
		System.out.println("**** addressString: "+addressString);
	    
		//Call to PB geoproperty API
		ResponseEntity<PropertyAttributesFromPBResponse> propertyAttributes = 
				restTemplate.exchange(
				"https://api.pitneybowes.com/location-intelligence/geoproperty/v1/all/attributes/byaddress?address="+addressString, HttpMethod.GET,  
	            
				new HttpEntity<>(createHeaders(key, secret)), PropertyAttributesFromPBResponse.class);
		
		return transferDatafromPBToBusinessDetailsDTO(propertyAttributes);
	}	
	
	private HttpHeaders createHeaders(String username, String password){
	   return new HttpHeaders() {{
	         String auth = username + ":" + password;
	         byte[] encodedAuth = Base64.encodeBase64( 
	            auth.getBytes(Charset.forName("US-ASCII")) );
	         String authHeader = "Basic " + new String( encodedAuth );
	         
	         System.out.println("Encoded Value: "+authHeader);
	         
	         //set( "Authorization", authHeader );
	         set( "Authorization", "Bearer 0Q1sv7jDlNAJiR45egAVCYMckPDQ");
	      }};
	}
	
	public BusinessDetailsDTO transferDatafromPBToBusinessDetailsDTO(ResponseEntity<PropertyAttributesFromPBResponse> propertyAttributes) {
		
		//@Autowired
		BusinessDetailsDTO businessDetailsDTO = new BusinessDetailsDTO();
		
		//Not sure if this is going to work
		PropertyAttributesFromPBResponse propertyAttributesFromPBResponse = propertyAttributes.getBody();
		
		for (Variable variable : propertyAttributesFromPBResponse.getIndividualValueVariable()) {
			/*
			if(variable.getName() == "BUSNAME" && null != variable.getValue()) {
				businessDetailsDTO.setName(variable.getValue());
			}
			*/
			if(variable.getName() == "PROP_LANDSQFT" && null != variable.getValue()) {
				businessDetailsDTO.setName(variable.getValue());
			}
			if(variable.getName() == "PROP_BLDSQFT" && null != variable.getValue()) {
				businessDetailsDTO.setName(variable.getValue());
			}
		}
		
		return businessDetailsDTO;
	}
}