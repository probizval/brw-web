package com.brw.service.impl;

/**
 * @author sidpatil
 * 2020
 */

import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import javax.xml.bind.DatatypeConverter;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpServerErrorException.InternalServerError;

import com.brw.common.constants.Constants;
import com.brw.dao.ImageDAO;
import com.brw.dto.ImageDTO;
import com.brw.dto.ImagesListDTO;
import com.brw.dto.SearchAgentDTO;
import com.brw.dto.SearchAgentsListDTO;
import com.brw.dto.UploadImageDTO;
import com.brw.dto.UploadImagesListDTO;
import com.brw.entities.Image;
import com.brw.entities.SearchAgent;
import com.brw.exceptions.ImageException;

@Component
public class ImageServiceImpl implements com.brw.service.ImageService {
		
	@Autowired
	private ImageDAO imageDAO;
	
	@Override
	public UploadImagesListDTO uploadImages(UploadImagesListDTO uploadImagesListDTO) {
		System.out.println("222 **** Inside ImageServiceImpl.uploadImages()");

		List<UploadImageDTO> uploadImagesDTOList = uploadImagesListDTO.getUploadImagesList();
		List<UploadImageDTO> returnImageDTOList = new ArrayList<UploadImageDTO>();
		UploadImagesListDTO returnImagesListDTO = new UploadImagesListDTO();

		Image returnImage = new Image();
		Image image;
		ImageDTO retImageDTO;
		
		for (UploadImageDTO uploadImageDTO: uploadImagesDTOList) {
			System.out.println("222 **** uploadImageDTO.getImageDescription "+uploadImageDTO.getImageDescription());
			System.out.println("222 **** uploadImageDTO.getImageBase64 "+uploadImageDTO.getImageBase64());
			
			//String base64String = "data:image/jpeg;base64,iVBORw0KGgoAAAANSUhEUgAAAHkAAAB5C...";
			String base64String = uploadImageDTO.getImageBase64();
			
	        String[] strings = base64String.split(Constants.COMMA);
	        String extension;
	        switch (strings[0]) {//check image's extension
	            case "data:image/jpeg;base64":
	                extension = "jpeg";
	                break;
	            case "data:image/png;base64":
	                extension = "png";
	                break;
	            default://should write cases for more images types
	                extension = "jpg";
	                break;
	        }
	        //convert base64 string to binary data
	        byte[] data = DatatypeConverter.parseBase64Binary(strings[1]);
	        String path = "/Users/sidpatil/Desktop/BizRealWorth/DATA/test_image." + extension;
	        File file = new File(path);
	        try (OutputStream outputStream = new BufferedOutputStream(new FileOutputStream(file))) {
	            outputStream.write(data);
	        } catch (IOException e) {
	            e.printStackTrace();
	        }

			returnImageDTOList.add(uploadImageDTO);
		}
		returnImagesListDTO.setBusinessId(returnImage.getBusinessId());
		returnImagesListDTO.setUploadImagesList(returnImageDTOList);
		
		return returnImagesListDTO;
	}
	
	@Override
	public ImagesListDTO addImages(ImagesListDTO imagesListDTO) {
		System.out.println("222 **** Inside ImageServiceImpl.addImages()");

		List<ImageDTO> imagesDTOList = imagesListDTO.getImagesList();
		List<ImageDTO> returnImageDTOList = new ArrayList<ImageDTO>();
		ImagesListDTO returnImagesListDTO = new ImagesListDTO();

		Image returnImage = new Image();
		Image image;
		ImageDTO retImageDTO;
		
		for (ImageDTO imageDTO: imagesDTOList) {
			
			image = new Image();

			image.setBusinessId(imagesListDTO.getBusinessId());
			image.setUrl(imageDTO.getUrl());
			image.setCreatedByUserId(imagesListDTO.getInvokerId());
			image.setCreateDate(LocalDateTime.now());
			image.setUpdatedByUserId(imagesListDTO.getInvokerId());
			image.setUpdateDate(LocalDateTime.now());
			
			returnImage = imageDAO.save(image);
			
			retImageDTO = new ImageDTO();

			retImageDTO.setImageId(returnImage.getImageId());
			//retimgDTO.setBizId(returnImage.getBusinessId());
			retImageDTO.setUrl(returnImage.getUrl());
			retImageDTO.setCreatedByUserId(returnImage.getCreatedByUserId());
			retImageDTO.setCreateDate(returnImage.getCreateDate().format(DateTimeFormatter.ofPattern(Constants.DATE_FORMAT)));
			retImageDTO.setUpdatedByUserId(returnImage.getUpdatedByUserId());
			retImageDTO.setUpdateDate(returnImage.getUpdateDate().format(DateTimeFormatter.ofPattern(Constants.DATE_FORMAT)));
			
			returnImageDTOList.add(retImageDTO);
		}
		returnImagesListDTO.setBusinessId(returnImage.getBusinessId());
		returnImagesListDTO.setImagesList(returnImageDTOList);
		return returnImagesListDTO;
	}
	
	@Override
	public ImagesListDTO getImages(int businessId) {
		System.out.println("222 **** Inside ImageServiceImpl.getImages()");

		List<Image> imageList = (List<Image>)imageDAO.getImages(businessId);
		List<ImageDTO> returnImageListDTO = new ArrayList<ImageDTO>();
		ImagesListDTO returnImageDTOList = new ImagesListDTO();
		int bizId = 0;
		
		for (Image image: imageList) {
			ImageDTO returnImageDTO = new ImageDTO();
			
			returnImageDTO.setImageId(image.getImageId());
			returnImageDTO.setUrl(image.getUrl());
			returnImageDTO.setCreatedByUserId(image.getCreatedByUserId());
			returnImageDTO.setCreateDate(image.getCreateDate().format(DateTimeFormatter.ofPattern(Constants.DATE_FORMAT)));
			returnImageDTO.setUpdatedByUserId(image.getUpdatedByUserId());
			returnImageDTO.setUpdateDate(image.getUpdateDate().format(DateTimeFormatter.ofPattern(Constants.DATE_FORMAT)));
			
			bizId = image.getBusinessId();
			returnImageListDTO.add(returnImageDTO);
		}
		returnImageDTOList.setBusinessId(bizId);
		returnImageDTOList.setImagesList(returnImageListDTO);
		return returnImageDTOList;
	}
	
	@Override
	public int deleteImages(ImagesListDTO imagesListDTO) {
		System.out.println("222 **** Inside ImageServiceImpl.getImages()");
		
		int businessId = imagesListDTO.getBusinessId();
		int nurDeleted = 0;
		
		for (ImageDTO imageDTO: imagesListDTO.getImagesList()) {
			
			imageDAO.deleteImage(businessId, imageDTO.getImageId());
			nurDeleted ++;
		}
		
		return nurDeleted;
	}
}