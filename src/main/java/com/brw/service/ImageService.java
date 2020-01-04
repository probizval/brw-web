package com.brw.service;

import com.brw.dto.ImagesListDTO;
import com.brw.exceptions.ImageException;

public interface ImageService {
	
	public ImagesListDTO getImages(int bizId) throws ImageException;
	public ImagesListDTO addImages(ImagesListDTO imagesListDTO);
	
}
