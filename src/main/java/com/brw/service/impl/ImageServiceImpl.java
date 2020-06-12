package com.brw.service.impl;

/**
 * @author sidpatil
 * 2020
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
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
	public ImagesListDTO uploadImages(UploadImagesListDTO uploadImagesListDTO) {
		System.out.println("222 **** Inside ImageServiceImpl.uploadImages()");

		List<UploadImageDTO> uploadImagesDTOList = uploadImagesListDTO.getUploadImagesList();
		//List<UploadImageDTO> returnImageDTOList = new ArrayList<UploadImageDTO>();
		ImagesListDTO returnImagesListDTO = new ImagesListDTO();
		//UploadImageDTO returnImageDTO = new UploadImageDTO();
		
		ImagesListDTO imagesToDBListDTO = new ImagesListDTO();
		List<ImageDTO> imageToDBDTOList = new ArrayList<ImageDTO>();

		//Image returnImage = new Image();
		int i = 0;
		
		for (UploadImageDTO uploadImageDTO: uploadImagesDTOList) {
			System.out.println("222 **** uploadImageDTO.name "+uploadImageDTO.getTitle());
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
	        
	        //Upload image to AWS S3
	        String pathToFile = String.valueOf(uploadImagesListDTO.getBusinessId());
	        String name = pathToFile + Constants.UNDERSCORE + i++;

	        String s3URL = uploadBase64Image(strings[1], fileType, pathToFile, name);
	        
			//Build imagesToDBListDTO to call AddImages API
			ImageDTO imageToDBDTO = new ImageDTO();
			
			imageToDBDTO.setUrl(s3URL);
	        imageToDBDTOList.add(imageToDBDTO);
	        imagesToDBListDTO.setBusinessId(uploadImagesListDTO.getBusinessId());
	        imagesToDBListDTO.setImagesList(imageToDBDTOList);
	        
	        //Build return Image Object
	        //returnImageDTO.setTitle(uploadImageDTO.getTitle());
	        //returnImageDTO.setS3url(s3URL);
			//returnImageDTOList.add(returnImageDTO);
		}
		//Add Image URL to BRW DB
		returnImagesListDTO = addImages(imagesToDBListDTO);
		return returnImagesListDTO;
	}
	
	public String uploadBase64Image(String base64String, String fileType, String pathToFile, String name) {
		
		byte[] imageBytes = javax.xml.bind.DatatypeConverter.parseBase64Binary(base64String);		
	    InputStream stream = new ByteArrayInputStream(imageBytes);

	    ObjectMetadata metadata = new ObjectMetadata();
	    metadata.setContentLength(imageBytes.length);
	    metadata.setContentType("image/"+fileType);
	    
	    String s3bucketName = Constants.S3_BUCKET_NAME;
	    
	    String key = pathToFile + Constants.FORWARD_SLASH + name + Constants.PERIOD + fileType;
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
			image.setTitle(imageDTO.getTitle());
			image.setCreatedByUserId(imagesListDTO.getInvokerId());
			image.setCreateDate(LocalDateTime.now());
			image.setUpdatedByUserId(imagesListDTO.getInvokerId());
			image.setUpdateDate(LocalDateTime.now());
			
			returnImage = imageDAO.save(image);
			retImageDTO = new ImageDTO();

			retImageDTO.setImageId(returnImage.getImageId());
			retImageDTO.setTitle(returnImage.getTitle());
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
	
	/**
	 * @author sidpatil
	 * GetImages method first tries to get image URLs from t_brw_image table.
	 * If there are no images already in DB for given business then it calls the google API to get the images.
	 */
	@Override
	public ImagesListDTO getImages(int businessId) {
		System.out.println("222 **** Inside ImageServiceImpl.getImages()");

		ImagesListDTO returnImageDTOList = new ImagesListDTO();
		ImagesListDTO dbIamgesDTOList = getImagesFromDB(businessId);
		
		if (dbIamgesDTOList.getImagesList().size() > 0) {
			returnImageDTOList = dbIamgesDTOList;
		} else {
			//TODO: Call Google API to get images for the business
			//Need the Business Address here
			/*
			photo_url = []
	        if place_details_data is not None and "photos" in place_details_data["result"]:
	                place_details_photos_list = place_details_data["result"]["photos"]
	                for place_photo in place_details_photos_list:
	                    photo_reference = place_photo["photo_reference"]
	                    place_photo_data = get_place_photo_results(photo_reference)
	                    if place_photo_data is not None:
	                        photo_url.append(place_photo_data)
	                    else:
	                        continue
			    
			*/
			
			/*
			        
	        def get_place_photo_results(photo_reference):
	            place_photo_url = "https://maps.googleapis.com/maps/api/place/photo?maxwidth=500&photoreference={}&key={}".format(
	                photo_reference, config.google_api_key)
	            photo_response = requests.get(place_photo_url)
	            if photo_response.status_code == 200:
	                return photo_response.url
	            else:
	                return None
			*/
			
		}
		
		return returnImageDTOList;
	}
	
	private ImagesListDTO getImagesFromDB(int businessId) {
		System.out.println("222 **** Inside ImageServiceImpl.getImages()");

		List<Image> imageList = (List<Image>)imageDAO.getImages(businessId);
		List<ImageDTO> returnImageListDTO = new ArrayList<ImageDTO>();
		ImagesListDTO returnImageDTOList = new ImagesListDTO();
		int bizId = 0;
		
		for (Image image: imageList) {
			ImageDTO returnImageDTO = new ImageDTO();
			
			returnImageDTO.setImageId(image.getImageId());
			returnImageDTO.setTitle(image.getTitle());
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
	
	@Override
	public String getDefaultImageForBizType(String bizType) {
		System.out.println("222 **** Inside ImageServiceImpl.getDefaultImageForBizType()");
		
		// switch case to pick up bizId range based on bizType
		int min = 0;
		int max = 0;
		switch (bizType) {
		  case Constants.BTYPE_AGRI:
			 min = 990001;
			 max = 990010;
			 break;
		  case Constants.BTYPE_AUTO_BOAT:
			 min = 990011;
			 max = 990020;
			 break;
		  case Constants.BTYPE_BEAUTY_PERSONA:
			min = 990021;
			max = 990030;
			break;
		  case Constants.BTYPE_BUILD_CONS:
			min = 990031;
			max = 990040;
			break;
		  case Constants.BTYPE_COM_MEDIA:
			min = 990041;
			max = 990050;
			break;
		  case Constants.BTYPE_EDU_CHILD:
			min = 990051;
			max = 990060;
			break;
		  case Constants.BTYPE_ENT_REC:
			min = 990061;
			max = 990070;
			break;
		  case Constants.BTYPE_FINANCIAL:
			min = 990071;
			max = 990080;
			break;
		  case Constants.BTYPE_HEALTH_FIT:
			 min = 990081;
			 max = 990090;
			 break;
		  case Constants.BTYPE_MANUFACTURING:
			 min = 990091;
			 max = 990100;
			 break;
		  case Constants.BTYPE_ONLINE_TECH:
			min = 990101;
			max = 990110;
			break;
		  case Constants.BTYPE_PET_SER:
			min = 990111;
			max = 990120;
			break;
		  case Constants.BTYPE_REAL_EST:
			 min = 990121;
			 max = 990130;
			 break;
		  case Constants.BTYPE_REST_FOOD:
			 min = 990131;
			 max = 990140;
			 break;
		  case Constants.BTYPE_RETAIL:
			min = 990141;
			max = 990150;
			break;
		  case Constants.BTYPE_SER_BIZ:
			min = 990151;
			max = 990160;
			break;
		  case Constants.BTYPE_TRANS_STOR:
			 min = 990161;
			 max = 990170;
			 break;
		  case Constants.BTYPE_TRAVEL:
			 min = 990171;
			 max = 990180;
			 break;
		  case Constants.BTYPE_WHLSL_DIST:
			min = 990181;
			max = 990190;
			break;
		  case Constants.BTYPE_MISC:
			min = 990191;
			max = 990200;
			break;
		}
		
		// nextInt is normally exclusive of the top value,
		// so add 1 to make it inclusive
		int bizId = ThreadLocalRandom.current().nextInt(min, max + 1);

		String imageFirst = imageDAO.getImage(bizId);
		
		return imageFirst;
	}
}