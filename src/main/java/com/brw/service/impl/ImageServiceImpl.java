package com.brw.service.impl;

/**
 * @author sidpatil
 * 2019
 */

import java.util.ArrayList;
import java.util.List;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.brw.dao.ImageDAO;
import com.brw.dto.ImageDTO;
import com.brw.dto.ImagesListDTO;
import com.brw.entities.Image;

import com.brw.dao.ImagesDAO;
import com.brw.dto.EstimatesListDTO;
import com.brw.dto.ImagesListDTO;
import com.brw.exceptions.ImageException;

@Component
public class ImageServiceImpl implements com.brw.service.ImageService {
	
	private static final String businessId = null;
	@Autowired

	private ImageDAO imageDAO;	
	@Override
	public ImagesListDTO addImages(ImagesListDTO imagesListDTO) {
		System.out.println("222 **** Inside EstimateServiceImpl.addEstimates()");

		List<ImageDTO> imagesDTOList = imagesListDTO.getImagesList();
		List<ImageDTO> imgDTOList = new ArrayList<ImageDTO>();
		ImagesListDTO returnImagesListDTO = new ImagesListDTO();

		Image image;
		ImageDTO retimgDTO;
		
		for (ImageDTO imageDTO: imagesDTOList) {
			
			image = new Image();
			retimgDTO = new ImageDTO();
			
			//image.setImageId(imageDTO.getImageId());
			image.setBusinessId(imageDTO.getBizId());
			image.setUrl(imageDTO.getUrl());
			image.setCreatedByUserId(imageDTO.getInvokerId());
			image.setCreateDate(LocalDateTime.now());
			image.setUpdatedByUserId(imageDTO.getInvokerId());
			image.setUpdateDate(LocalDateTime.now());
			
			Image img = imageDAO.save(image);
			
			retimgDTO.setImageId(img.getImageId());
			retimgDTO.setBizId(img.getBusinessId());
			retimgDTO.setUrl(img.getUrl());
			//retimgDTO.setCreatedByUserId(img.getCreatedByUserId());
			//retimgDTO.setCreateDate(img.getCreateDate());
			//retimgDTO.setUpdatedByUserId(img.getUpdatedByUserId());
			//retimgDTO.setUpdateDate(img.now());
			
			imgDTOList.add(retimgDTO);
		}
		returnImagesListDTO.setImagesList(imgDTOList);
		return returnImagesListDTO;
	}
	
	@Override
	public ImagesListDTO getImages(int businessId) throws ImageException {
		
		ImagesListDTO imageListRet = new ImagesListDTO();
		
		List<Images> imageList = (List<Images>)imagesDAO.getImages(businessId);
		
		return imageListRet;
	}
}