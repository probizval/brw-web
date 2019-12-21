package com.brw.controllers;

/**
 * @author siyapatil
 * 2019
 */

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpServerErrorException.InternalServerError;

import com.brw.common.constants.ErrorCodes;
import com.brw.common.response.ApiResponse;
import com.brw.dto.ImagesListDTO;
import com.brw.exceptions.ImageException;
import com.brw.service.ImageService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/images/v1/")
public class ImageController implements ErrorController {

	public static final Logger logger = LoggerFactory.getLogger(EstimateController.class);

	@Autowired
	ImageService imageService;

	@Override
	public String getErrorPath() {
		// TODO Auto-generated method stub
		return "/error";
	}
	
	/**
	 * @author siyapatil
	 * addImages - Service to add business images in BRW DB 
	 */
	@PostMapping(value = "addImages")
	public ResponseEntity<ImagesListDTO> addImages(@RequestBody ImagesListDTO imagesListDTO) {
		
		System.out.println("111 **** Inside BusinessController.addImages()");
		
		logger.info("Add the New Business Details");
		
		try {
			ImagesListDTO eListDTo = imageService.addImages(imagesListDTO);
			return null;
			
		} catch (InternalServerError e) {
			// TODO: handle exception
			return new ResponseEntity<>(imagesListDTO, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	/**
	 * @author siyapatil
	 * getImages - Service to get the Business Images on the basis of biz_id 
	 */
	@RequestMapping(value = "getImages/{businessId}", method = RequestMethod.GET, produces = "application/json")
	public ApiResponse<?> getImages(@PathVariable int businessId) {
		
		System.out.println("**** 111 Inside ImageController.getImages()");
		
		logger.info("Get the Business images based on business Id");

		ImagesListDTO imagesListDTO = null;
		
		//imagesListDTO = imageService.getImages(imagesListDTO);
		return ApiResponse.withData(imagesListDTO);
		
	}
	
	
}