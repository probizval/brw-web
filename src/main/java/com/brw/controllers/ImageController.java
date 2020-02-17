package com.brw.controllers;

import java.io.IOException;

/**
 * @author siyapatil
 * 2019-20
 */

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpServerErrorException.InternalServerError;

import com.brw.common.constants.Constants;
import com.brw.common.constants.ErrorCodes;
import com.brw.common.response.ApiResponse;
import com.brw.dto.ImagesListDTO;
import com.brw.dto.UploadImagesListDTO;
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
	 * @author sidpatil
	 * uploadImages - Service to upload business images to S3 and then add image URLs to BRW DB 
	 */
	//@PostMapping(value = "uploadImages", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	@PostMapping(value = "uploadImages")
	
	public ResponseEntity<ImagesListDTO> uploadImages(@RequestBody UploadImagesListDTO uploadImagesListDTO) throws IOException{
		
		System.out.println("111 **** Inside BusinessController.uploadImages()");
		
		logger.info("Upload the Business Images to S3 and add URLs to BRW DB");
		
		ImagesListDTO returnImagesListDTO = new ImagesListDTO();
		
		try {
			returnImagesListDTO = imageService.uploadImages(uploadImagesListDTO);
			return new ResponseEntity<>(returnImagesListDTO, HttpStatus.OK);
			
		} catch (InternalServerError e) {
			// TODO: handle exception
			return new ResponseEntity<>(returnImagesListDTO, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	/**
	 * @author siyapatil
	 * addImages - Service to add business images in BRW DB 
	 */
	@PostMapping(value = "addImages")
	public ResponseEntity<ImagesListDTO> addImages(@RequestBody ImagesListDTO imagesListDTO) {
		
		System.out.println("111 **** Inside BusinessController.addImages()");
		
		logger.info("Add the Business Image URLs");
		
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
	@PostMapping(value = "getImages")
	public ResponseEntity<ImagesListDTO> getImages(@RequestBody ImagesListDTO imagesListDTO) {
		
		System.out.println("**** 111 Inside ImageController.getImages() getBusinessId: "+imagesListDTO.getBusinessId());
		
		logger.info("Get the Business images based on business Id");
		
		try {
			ImagesListDTO returnImagesListDTO = imageService.getImages(imagesListDTO.getBusinessId());
			return new ResponseEntity<>(returnImagesListDTO, HttpStatus.OK);
		} catch (InternalServerError e) {
			// TODO: handle exception
			return new ResponseEntity<>(imagesListDTO, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	/**
	 * @author siyapatil
	 * deleteImages - Service to get the Business Images on the basis of biz_id 
	 */
	@PostMapping(value = "deleteImages")
	public ApiResponse<?> deleteImages(@RequestBody ImagesListDTO imagesListDTO) {
		
		System.out.println("**** 111 Inside ImageController.getImages() getBusinessId: "+imagesListDTO.getBusinessId());
		
		logger.info("Get the Business images based on business Id");
		
		try {
			int numOfDelImg = imageService.deleteImages(imagesListDTO);
			return ApiResponse.withData(Constants.RESPONSE_SUCCESS);
		} catch (InternalServerError e) {
			// TODO: handle exception
			return ApiResponse.withError(ErrorCodes.INTERNAL_SERVER_ERROR, "Record not found");
		}
	}
}