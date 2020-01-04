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
import com.brw.dto.ImagesListDTO;
import com.brw.exceptions.ImageException;


@Component
public class ImageServiceImpl implements com.brw.service.ImageService {
	
	@Autowired
	private ImagesDAO imagesDetailsDAO;
	
	@Override
	public ImagesListDTO addImages(ImagesListDTO imagesListDTO) {
		System.out.println("222 **** Inside ImageServiceImpl.addImages()");
		return imagesListDTO;
	}
	

	@Override
	public ImagesListDTO getImages(int bizId) throws ImageException {
		// TODO Auto-generated method stub
		return null;
	}


	public ImagesDAO getImagesDetailsDAO() {
		return imagesDetailsDAO;
	}


	public void setImagesDetailsDAO(ImagesDAO imagesDetailsDAO) {
		this.imagesDetailsDAO = imagesDetailsDAO;
	}
	
}