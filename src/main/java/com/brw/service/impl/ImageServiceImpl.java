package com.brw.service.impl;

/**
 * @author sidpatil
 * 2020
 */

import java.util.ArrayList;
import java.util.List;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.brw.common.constants.Constants;
import com.brw.dao.ImageDAO;
import com.brw.dto.ImageDTO;
import com.brw.dto.ImagesListDTO;
import com.brw.dto.SearchAgentDTO;
import com.brw.dto.SearchAgentsListDTO;
import com.brw.entities.Image;
import com.brw.entities.SearchAgent;
import com.brw.exceptions.ImageException;

@Component
public class ImageServiceImpl implements com.brw.service.ImageService {
		
	@Autowired
	private ImageDAO imageDAO;	
	
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

		
		return 0;
	}
}