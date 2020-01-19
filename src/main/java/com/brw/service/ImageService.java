package com.brw.service;

import com.brw.dto.ImagesListDTO;

public interface ImageService {
	
	public ImagesListDTO addImages(ImagesListDTO imagesListDTO);
	public ImagesListDTO getImages(int businessId);
	public int deleteImages(ImagesListDTO imagesListDTO);
}