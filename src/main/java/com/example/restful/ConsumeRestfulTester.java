package com.example.restful;

import java.nio.charset.Charset;
import java.util.Collections;

import org.apache.commons.codec.binary.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class ConsumeRestfulTester {

	private static final Logger log = LoggerFactory.getLogger(ConsumeRestfulTester.class);

	
	//Uncomment this code for testing this class
	/*
	public static void main(String[] args) {
		SpringApplication.run(ConsumeRestfulTester.class, args);
	}
	*/
	
	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}

	@Bean
	public CommandLineRunner run(RestTemplate restTemplate) throws Exception {
		return args -> {
			
			
			String key = "fUMoAOl6wPbiLfLQMtygfCiwX007lVGY";
			String secret = "KtmfEXJ2EKf0kAPt";
		    
			///*
			// CALL FAILS -> Caused by: org.springframework.web.client.HttpClientErrorException$Unauthorized: 401 Unauthorized
			//Call to PB geoproperty API
			ResponseEntity<PropertyAttributesFromPBResponse> propertyAttributes = 
					restTemplate.exchange(
					"https://api.pitneybowes.com/location-intelligence/geoproperty/v1/all/attributes/bypbkey?pbKey=P00003PZZOIE", HttpMethod.GET,
		            new HttpEntity<>(createHeaders(key, secret)), PropertyAttributesFromPBResponse.class);
			log.info(propertyAttributes.toString());
			//*/
			
			/*
			PropertyDetailsResponse propertyDetailsResponse = restTemplate.getForObject(
					"http://bizrealworth.com/api/v1/property/19", PropertyDetailsResponse.class);
			System.out.println("*** propertyMetaDataDTO.getPropertyMetaData().getCity(): "+propertyDetailsResponse.getData().getPropertyMetaData().getCity());
			log.info(propertyDetailsResponse.toString());
			*/
		};
	}
	
	private HttpHeaders createHeaders(String username, String password){
	   return new HttpHeaders() {{
	         String auth = username + ":" + password;
	         byte[] encodedAuth = Base64.encodeBase64( 
	            auth.getBytes(Charset.forName("US-ASCII")) );
	         String authHeader = "Basic " + new String( encodedAuth );
	         
	         System.out.println("Encoded Value: "+authHeader);
	         
	         //set( "Authorization", authHeader );
	         set( "Authorization", "Bearer HDYnCWRnjn8qxTA81y3iNAikCeCJ");
	      }};
	}
	
}