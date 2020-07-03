package com.brw.service;

import com.brw.dto.ImagesListDTO;
import com.brw.dto.UploadImagesListDTO;

public interface ImageService {
	
	public ImagesListDTO uploadImages(UploadImagesListDTO uploadImagesListDTO) throws Exception;
	public ImagesListDTO addImages(ImagesListDTO imagesListDTO) throws Exception;
	public ImagesListDTO getImages(int businessId) throws Exception;
	public int deleteImages(ImagesListDTO imagesListDTO) throws Exception;
	public String getDefaultImageForBizType(String bizType) throws Exception;
}