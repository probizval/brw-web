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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpServerErrorException.InternalServerError;

import com.brw.dto.ImagesListDTO;
import com.brw.service.ImageService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/image/v1/")
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
			ImagesListDTO returnImagesListDTO = imageService.addImages(imagesListDTO);
			return new ResponseEntity<>(returnImagesListDTO, HttpStatus.OK);
			
		} catch (InternalServerError e) {
			// TODO: handle exception
			return new ResponseEntity<>(imagesListDTO, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	/**
	 * @author siyapatil
	 * getImages - Service to get the Business Images on the basis of biz_id 
	 */
	/*
	@PostMapping(value = "getImages")
	public ApiResponse<ImagesListDTO> getImages(@RequestBody ImageDTO imageDTO) {
		
		System.out.println("**** 111 Inside ImageController.getImages() bizId: "+imageDTO.getBizId());
		
		logger.info("Get the Business images based on business Id");
		
		try {
			EstimatesListDTO eListDTo = estimateService.addEstimates(estimatesListDTO);
			return new ResponseEntity<>(eListDTo, HttpStatus.OK);
			
		} catch (InternalServerError e) {
			// TODO: handle exception
			return new ResponseEntity<>(estimatesListDTO, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	*/
}