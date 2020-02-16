package com.brw.service.impl;

/**
 * @author sidpatil
 * 2020
 */

import java.util.ArrayList;
import java.util.List;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.net.URL;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.brw.common.constants.Constants;
import com.brw.dao.ImageDAO;
import com.brw.dto.ImageDTO;
import com.brw.dto.ImagesListDTO;
import com.brw.dto.UploadImageDTO;
import com.brw.dto.UploadImagesListDTO;
import com.brw.entities.Image;

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
		UploadImageDTO returnImageDTO = new UploadImageDTO();

		Image returnImage = new Image();
		
		for (UploadImageDTO uploadImageDTO: uploadImagesDTOList) {
			System.out.println("222 **** uploadImageDTO.name "+uploadImageDTO.getName());
			System.out.println("222 **** uploadImageDTO.getImageBase64 "+uploadImageDTO.getImageBase64());
			
			//String base64String = "data:image/jpeg;base64,iVBORw0KGgoAAAANSUhEUgAAAHkAAAB5C...";
			String base64String = uploadImageDTO.getImageBase64();
			
	        String[] strings = base64String.split(Constants.COMMA);
	        String fileType;
	        switch (strings[0]) {//check image's extension
	            case "data:image/jpeg;base64":
	            	fileType = Constants.JPEG;
	                break;
	            case "data:image/png;base64":
	            	fileType = Constants.PNG;
	                break;
	            default://should write cases for more images types
	            	fileType = Constants.JPG;
	                break;
	        }
	        
	        //Code to write in local for TEST
	        /*
	        //convert base64 string to binary data
	        byte[] data = DatatypeConverter.parseBase64Binary(strings[1]);
	        String path = "/Users/sidpatil/Desktop/BizRealWorth/DATA/test_image." + extension;
	        File file = new File(path);
	        
	        try (OutputStream outputStream = new BufferedOutputStream(new FileOutputStream(file))) {
	            outputStream.write(data);
	            
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	        */
	        
	        //Code to upload image to AWS S3
	        String s3URL = uploadBase64Image(strings[1], fileType, String.valueOf(uploadImagesListDTO.getBusinessId()), uploadImageDTO.getName());
	        
	        returnImageDTO.setName(uploadImageDTO.getName());
	        returnImageDTO.setS3url(s3URL);
			returnImageDTOList.add(returnImageDTO);
		}
		returnImagesListDTO.setBusinessId(returnImage.getBusinessId());
		returnImagesListDTO.setUploadImagesList(returnImageDTOList);
		
		return returnImagesListDTO;
	}
	
	public String uploadBase64Image(String base64String, String fileType, String pathToFile, String name) {
		
		byte[] imageBytes = javax.xml.bind.DatatypeConverter.parseBase64Binary(base64String);		
	    InputStream stream = new ByteArrayInputStream(imageBytes);

	    ObjectMetadata metadata = new ObjectMetadata();
	    metadata.setContentLength(imageBytes.length);
	    metadata.setContentType("image/"+fileType);
	    
	    String s3bucketName = Constants.S3_BUCKET_NAME;
	    
	    String key = pathToFile + Constants.FORWARD_SLASH +name + Constants.PERIOD + fileType;
	    URL s3Url = null;

	    try {
	    	
	        PutObjectRequest objectRequest = new PutObjectRequest(s3bucketName, key, stream, metadata);
	        objectRequest.setCannedAcl(CannedAccessControlList.PublicRead);
	        
	        BasicAWSCredentials creds = new BasicAWSCredentials("AKIAITCWQF4LXNVAICBQ", "BfXEr/91/bmzShibB5xnzNIqb3LOucwpyPo/usCT");
	        AmazonS3 s3Client = AmazonS3Client.builder()
	        	    .withRegion(Constants.US_WEST_1)
	        	    .withCredentials(new AWSStaticCredentialsProvider(creds))
	        	    .build();
	        
	        s3Client.putObject(objectRequest);
	        s3Url = s3Client.getUrl(s3bucketName, key);
	        
	        System.out.println("333 **** AWS S3 URL for this IMAGE: " + s3Url.toString());
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return s3Url.toString();
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