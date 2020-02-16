package com.brw.service;

import com.brw.dto.ImagesListDTO;
import com.brw.dto.UploadImagesListDTO;

public interface ImageService {
	
	public UploadImagesListDTO uploadImages(UploadImagesListDTO uploadImagesListDTO);
	public ImagesListDTO addImages(ImagesListDTO imagesListDTO);
	public ImagesListDTO getImages(int businessId);
	public int deleteImages(ImagesListDTO imagesListDTO);
}