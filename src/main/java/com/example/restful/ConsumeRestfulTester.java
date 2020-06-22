package com.example.restful;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.Charset;
import java.text.ParseException;

import org.apache.http.client.utils.URIBuilder;
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
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.maps.GeoApiContext;
import com.google.maps.GeocodingApi;
import com.google.maps.PlacesApi;
import com.google.maps.model.GeocodingResult;
import com.google.maps.model.PlacesSearchResponse;
import com.google.maps.model.PlacesSearchResult;

@SpringBootApplication
public class ConsumeRestfulTester {

	private static final Logger log = LoggerFactory.getLogger(ConsumeRestfulTester.class);

	//private static final String GOOGLE_API_KEY  = "***";
    //private final HttpClient client = new DefaultHttpClient();
    
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
			
			///* Call to Ggogle Places API - Working Code
			GeoApiContext context = new GeoApiContext.Builder()
				    .apiKey("AIzaSyAc0CLCHpUtmyrQmfcEgESIy_OYVICHT6I")
				    .build();
			//GeocodingResult[] results =  GeocodingApi.geocode(context, "1600 Amphitheatre Parkway Mountain View, CA 94043").await();
			//GeocodingResult[] results =  GeocodingApi.geocode(context, "2140 Peralta Blvd STE 110 Fremont, CA 94539").await();
				
			PlacesSearchResponse results = PlacesApi.textSearchQuery(context, "4627 Rousillon Ave").await();
			
				//System.out.println("**** Printing response from Google API results: "+results.toString());
				
				Gson gson = new GsonBuilder().setPrettyPrinting().create();
				//System.out.println(gson.toJson(results[0].addressComponents));
				
				PlacesSearchResult result = results.results[0];
				System.out.println("**** Printing response from Google API results: "+gson.toJson(result.formattedAddress));
			//*/
		
				
			/*
			//Call to PB geoproperty API - WORKING CODE
			ResponseEntity<PropertyAttributesFromPBResponse> propertyAttributes = 
					restTemplate.exchange(
					//"https://api.pitneybowes.com/location-intelligence/geoproperty/v1/all/attributes/bypbkey?pbKey=P00003PZZOIE", HttpMethod.GET,
					"https://api.pitneybowes.com/location-intelligence/geoproperty/v1/all/attributes/byaddress?address=4750 Walnut St, Boulder, CO, 80301", HttpMethod.GET,  

		            new HttpEntity<>(createHeaders(key, secret)), PropertyAttributesFromPBResponse.class);
			log.info(propertyAttributes.toString());
			*/
			
			/*
			PropertyDetailsResponse propertyDetailsResponse = restTemplate.getForObject(
					"http://bizrealworth.com/api/v1/property/19", PropertyDetailsResponse.class);
			System.out.println("*** propertyMetaDataDTO.getPropertyMetaData().getCity(): "+propertyDetailsResponse.getData().getPropertyMetaData().getCity());
			log.info(propertyDetailsResponse.toString());
			*/
		};
	}
	
	/*
	public void performSearch(final String types, final double lon, final double lat) throws ParseException, IOException, URISyntaxException
    {
        final URIBuilder builder = new URIBuilder().setScheme("https").setHost("maps.googleapis.com").setPath("/maps/api/place/search/json");

        builder.addParameter("location", lat + "," + lon);
        builder.addParameter("radius", "5");
        builder.addParameter("types", types);
        builder.addParameter("sensor", "true");
        builder.addParameter("key", "AIzaSyAc0CLCHpUtmyrQmfcEgESIy_OYVICHT6I");

        final HttpUriRequest request = new HttpGet(builder.build());

        final HttpResponse execute = this.client.execute(request);

        final String response = EntityUtils.toString(execute.getEntity());

        System.out.println(response);
    }
	*/
	
	/*
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
	*/
}