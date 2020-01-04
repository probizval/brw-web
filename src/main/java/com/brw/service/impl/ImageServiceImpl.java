package com.brw.service.impl;

/**
 * @author siyapatil
 * 2019
 */

import java.util.ArrayList;
import java.util.List;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.brw.dao.ImagesDAO;
import com.brw.dto.EstimatesListDTO;
import com.brw.dto.ImagesListDTO;
import com.brw.entities.Estimates;
import com.brw.entities.Images;
import com.brw.exceptions.ImageException;


@Component
public class ImageServiceImpl implements com.brw.service.ImageService {
	
	@Autowired
	private ImagesDAO imagesDAO;
	
	@Override
	public ImagesListDTO addImages(ImagesListDTO imagesListDTO) {
		System.out.println("222 **** Inside ImageServiceImpl.addImages()");
		return imagesListDTO;
	}
	

	@Override
	public ImagesListDTO getImages(int businessId) throws ImageException {
		
		ImagesListDTO imageListRet = new ImagesListDTO();
		
		List<Images> imageList = (List<Images>)imagesDAO.getImages(businessId);
		
		return imageListRet;
	}
}