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

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
		
	private static final Logger logger = LoggerFactory.getLogger(ImageServiceImpl.class);

	@Autowired
	private ImageDAO imageDAO;
	
	@Override
	public ImagesListDTO uploadImages(UploadImagesListDTO uploadImagesListDTO) {
		logger.info("222 **** Inside ImageServiceImpl.uploadImages()");

		List<UploadImageDTO> uploadImagesDTOList = uploadImagesListDTO.getUploadImagesList();
		//List<UploadImageDTO> returnImageDTOList = new ArrayList<UploadImageDTO>();
		ImagesListDTO returnImagesListDTO = new ImagesListDTO();
		//UploadImageDTO returnImageDTO = new UploadImageDTO();
		
		ImagesListDTO imagesToDBListDTO = new ImagesListDTO();
		List<ImageDTO> imageToDBDTOList = new ArrayList<ImageDTO>();

		//Image returnImage = new Image();
		int i = 0;
		
		for (UploadImageDTO uploadImageDTO: uploadImagesDTOList) {
			logger.info("222 **** uploadImageDTO.name "+uploadImageDTO.getTitle());
			logger.info("222 **** uploadImageDTO.getImageBase64 "+uploadImageDTO.getImageBase64());
			
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
	        
	        BasicAWSCredentials creds = new BasicAWSCredentials("AKIAIV7P5V63PEUDQOLA", "/VeP0cUjlpif6NFWToCOJE5SCxthT2VIFaC/AVAF");
	        AmazonS3 s3Client = AmazonS3Client.builder()
	        	    .withRegion(Constants.US_WEST_1)
	        	    .withCredentials(new AWSStaticCredentialsProvider(creds))
	        	    .build();
	        
	        s3Client.putObject(objectRequest);
	        s3Url = s3Client.getUrl(s3bucketName, key);
	        
	        logger.info("333 **** AWS S3 URL for this IMAGE: " + s3Url.toString());
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return s3Url.toString();
	}
	
	@Override
	public ImagesListDTO addImages(ImagesListDTO imagesListDTO) {
		logger.info("222 **** Inside ImageServiceImpl.addImages()");

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
		logger.info("222 **** Inside ImageServiceImpl.getImages()");

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
		logger.info("222 **** Inside ImageServiceImpl.getImages()");

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
		logger.info("222 **** Inside ImageServiceImpl.getImages()");
		
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
		long start = System.currentTimeMillis();

		logger.info("222 **** Inside ImageServiceImpl.getDefaultImageForBizType()");
		
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

		//String imageFirst = imageDAO.getImage(bizId);
		//String imageFirst = imageDAO.getImage(990131);
		
		String imageFirst = Constants.EMPTY_STRING;
		
		switch (bizId) {
			//BTYPE_AGRI
		  	case 990001:
		  		imageFirst = "https://brwbusinessimages.s3.us-west-1.amazonaws.com/990001/990001_0.JPG";
		  		break;
		  	case 990002:
				imageFirst = "https://brwbusinessimages.s3.us-west-1.amazonaws.com/990002/990002_0.JPG";
				break;
		  	case 990003:
			  	imageFirst = "https://brwbusinessimages.s3.us-west-1.amazonaws.com/990003/990003_0.JPG";
			  	break;
		  	case 990004:
			  	imageFirst = "https://brwbusinessimages.s3.us-west-1.amazonaws.com/990004/990004_0.JPG";
			  	break;
		  	case 990005:
		  		imageFirst = "https://brwbusinessimages.s3.us-west-1.amazonaws.com/990005/990005_0.JPG";
		  		break;
		  	case 990006:
		  		imageFirst = "https://brwbusinessimages.s3.us-west-1.amazonaws.com/990006/990006_0.JPG";
		  		break;
		  	case 990007:
		  		imageFirst = "https://brwbusinessimages.s3.us-west-1.amazonaws.com/990007/990007_0.JPG";
		  		break;
		  	case 990008:
		  		imageFirst = "https://brwbusinessimages.s3.us-west-1.amazonaws.com/990008/990008_0.JPG";
		  		break;
		  	case 990009:
		  		imageFirst = "https://brwbusinessimages.s3.us-west-1.amazonaws.com/990009/990009_0.JPG";
		  		break;
		  	case 990010:
		  		imageFirst = "https://brwbusinessimages.s3.us-west-1.amazonaws.com/990009/990009_0.JPG";
		  		break;
		  	//BTYPE_AUTO_BOAT
		  	case 990011:
		  		imageFirst = "";
		  		break;
		  	case 990012:
				imageFirst = "";
				break;
		  	case 990013:
			  	imageFirst = "";
			  	break;
		  	case 990014:
			  	imageFirst = "";
			  	break;
		  	case 990015:
		  		imageFirst = "";
		  		break;
		  	case 990016:
		  		imageFirst = "";
		  		break;
		  	case 990017:
		  		imageFirst = "";
		  		break;
		  	case 990018:
		  		imageFirst = "";
		  		break;
		  	case 990019:
		  		imageFirst = "";
		  		break;
		  	case 990020:
		  		imageFirst = "";
		  		break;	 
		  	//BTYPE_BEAUTY_PERSONA
		  	case 990021:
		  		imageFirst = "";
		  		break;
		  	case 990022:
				imageFirst = "";
				break;
		  	case 990023:
			  	imageFirst = "";
			  	break;
		  	case 990024:
			  	imageFirst = "";
			  	break;
		  	case 990025:
		  		imageFirst = "";
		  		break;
		  	case 990026:
		  		imageFirst = "";
		  		break;
		  	case 990027:
		  		imageFirst = "";
		  		break;
		  	case 990028:
		  		imageFirst = "";
		  		break;
		  	case 990029:
		  		imageFirst = "";
		  		break;
		  	case 990030:
		  		imageFirst = "";
		  		break;	
		  	//BTYPE_BUILD_CONS
		  	case 990031:
		  		imageFirst = "";
		  		break;
		  	case 990032:
				imageFirst = "";
				break;
		  	case 990033:
			  	imageFirst = "";
			  	break;
		  	case 990034:
			  	imageFirst = "";
			  	break;
		  	case 990035:
		  		imageFirst = "";
		  		break;
		  	case 990036:
		  		imageFirst = "";
		  		break;
		  	case 990037:
		  		imageFirst = "";
		  		break;
		  	case 990038:
		  		imageFirst = "";
		  		break;
		  	case 990039:
		  		imageFirst = "";
		  		break;
		  	case 990040:
		  		imageFirst = "";
		  		break;
		  	//BTYPE_COM_MEDIA
		  	case 990041:
		  		imageFirst = "";
		  		break;
		  	case 990042:
				imageFirst = "";
				break;
		  	case 990043:
			  	imageFirst = "";
			  	break;
		  	case 990044:
			  	imageFirst = "";
			  	break;
		  	case 990045:
		  		imageFirst = "";
		  		break;
		  	case 990046:
		  		imageFirst = "";
		  		break;
		  	case 990047:
		  		imageFirst = "";
		  		break;
		  	case 990048:
		  		imageFirst = "";
		  		break;
		  	case 990049:
		  		imageFirst = "";
		  		break;
		  	case 990050:
		  		imageFirst = "";
		  		break;
		  	//BTYPE_EDU_CHILD
		  	case 990051:
		  		imageFirst = "";
		  		break;
		  	case 990052:
				imageFirst = "";
				break;
		  	case 990053:
			  	imageFirst = "";
			  	break;
		  	case 990054:
			  	imageFirst = "";
			  	break;
		  	case 990055:
		  		imageFirst = "";
		  		break;
		  	case 990056:
		  		imageFirst = "";
		  		break;
		  	case 990057:
		  		imageFirst = "";
		  		break;
		  	case 990058:
		  		imageFirst = "";
		  		break;
		  	case 990059:
		  		imageFirst = "";
		  		break;
		  	case 990060:
		  		imageFirst = "";
		  		break;
		  	//BTYPE_ENT_REC
		  	case 990061:
		  		imageFirst = "";
		  		break;
		  	case 990062:
				imageFirst = "";
				break;
		  	case 990063:
			  	imageFirst = "";
			  	break;
		  	case 990064:
			  	imageFirst = "";
			  	break;
		  	case 990065:
		  		imageFirst = "";
		  		break;
		  	case 990066:
		  		imageFirst = "";
		  		break;
		  	case 990067:
		  		imageFirst = "";
		  		break;
		  	case 990068:
		  		imageFirst = "";
		  		break;
		  	case 990069:
		  		imageFirst = "";
		  		break;
		  	case 990070:
		  		imageFirst = "";
		  		break;
		  	//BTYPE_FINANCIAL
		  	case 990071:
		  		imageFirst = "";
		  		break;
		  	case 990072:
				imageFirst = "";
				break;
		  	case 990073:
			  	imageFirst = "";
			  	break;
		  	case 990074:
			  	imageFirst = "";
			  	break;
		  	case 990075:
		  		imageFirst = "";
		  		break;
		  	case 990076:
		  		imageFirst = "";
		  		break;
		  	case 990077:
		  		imageFirst = "";
		  		break;
		  	case 990078:
		  		imageFirst = "";
		  		break;
		  	case 990079:
		  		imageFirst = "";
		  		break;
		  	case 990080:
		  		imageFirst = "";
		  		break;
		  	//BTYPE_HEALTH_FIT
		  	case 990081:
		  		imageFirst = "";
		  		break;
		  	case 990082:
				imageFirst = "";
				break;
		  	case 990083:
			  	imageFirst = "";
			  	break;
		  	case 990084:
			  	imageFirst = "";
			  	break;
		  	case 990085:
		  		imageFirst = "";
		  		break;
		  	case 990086:
		  		imageFirst = "";
		  		break;
		  	case 990087:
		  		imageFirst = "";
		  		break;
		  	case 990088:
		  		imageFirst = "";
		  		break;
		  	case 990089:
		  		imageFirst = "";
		  		break;
		  	case 990090:
		  		imageFirst = "";
		  		break;
		  	//BTYPE_MANUFACTURING
		  	case 990091:
		  		imageFirst = "";
		  		break;
		  	case 990092:
				imageFirst = "";
				break;
		  	case 990093:
			  	imageFirst = "";
			  	break;
		  	case 990094:
			  	imageFirst = "";
			  	break;
		  	case 990095:
		  		imageFirst = "";
		  		break;
		  	case 990096:
		  		imageFirst = "";
		  		break;
		  	case 990097:
		  		imageFirst = "";
		  		break;
		  	case 990098:
		  		imageFirst = "";
		  		break;
		  	case 990099:
		  		imageFirst = "";
		  		break;
		  	case 990100:
		  		imageFirst = "";
		  		break;
		  	//BTYPE_ONLINE_TECH
		  	case 990101:
		  		imageFirst = "";
		  		break;
		  	case 990102:
				imageFirst = "";
				break;
		  	case 990103:
			  	imageFirst = "";
			  	break;
		  	case 990104:
			  	imageFirst = "";
			  	break;
		  	case 990105:
		  		imageFirst = "";
		  		break;
		  	case 990106:
		  		imageFirst = "";
		  		break;
		  	case 990107:
		  		imageFirst = "";
		  		break;
		  	case 990108:
		  		imageFirst = "";
		  		break;
		  	case 990109:
		  		imageFirst = "";
		  		break;
		  	case 990110:
		  		imageFirst = "";
		  		break;
		  	//BTYPE_PET_SER
		  	case 990111:
		  		imageFirst = "";
		  		break;
		  	case 990112:
				imageFirst = "";
				break;
		  	case 990113:
			  	imageFirst = "";
			  	break;
		  	case 990114:
			  	imageFirst = "";
			  	break;
		  	case 990115:
		  		imageFirst = "";
		  		break;
		  	case 990116:
		  		imageFirst = "";
		  		break;
		  	case 990117:
		  		imageFirst = "";
		  		break;
		  	case 990118:
		  		imageFirst = "";
		  		break;
		  	case 990119:
		  		imageFirst = "";
		  		break;
		  	case 990120:
		  		imageFirst = "";
		  		break;
		  	//BTYPE_REAL_EST
		  	case 990121:
		  		imageFirst = "";
		  		break;
		  	case 990122:
				imageFirst = "";
				break;
		  	case 990123:
			  	imageFirst = "";
			  	break;
		  	case 990124:
			  	imageFirst = "";
			  	break;
		  	case 990125:
		  		imageFirst = "";
		  		break;
		  	case 990126:
		  		imageFirst = "";
		  		break;
		  	case 990127:
		  		imageFirst = "";
		  		break;
		  	case 990128:
		  		imageFirst = "";
		  		break;
		  	case 990129:
		  		imageFirst = "";
		  		break;
		  	case 990130:
		  		imageFirst = "";
		  		break;
		  	//BTYPE_REST_FOOD
		  	case 990131:
		  		imageFirst = "https://brwbusinessimages.s3.us-west-1.amazonaws.com/1000000/1000000_0.JPEG";
		  		break;
		  	case 990132:
				imageFirst = "https://brwbusinessimages.s3.us-west-1.amazonaws.com/1000000/1000000_0.JPEG";
				break;
		  	case 990133:
			  	imageFirst = "https://brwbusinessimages.s3.us-west-1.amazonaws.com/1000000/1000000_0.JPEG";
			  	break;
		  	case 990134:
			  	imageFirst = "https://brwbusinessimages.s3.us-west-1.amazonaws.com/1000000/1000000_0.JPEG";
			  	break;
		  	case 990135:
		  		imageFirst = "https://brwbusinessimages.s3.us-west-1.amazonaws.com/1000000/1000000_0.JPEG";
		  		break;
		  	case 990136:
		  		imageFirst = "https://brwbusinessimages.s3.us-west-1.amazonaws.com/1000000/1000000_0.JPEG";
		  		break;
		  	case 990137:
		  		imageFirst = "https://brwbusinessimages.s3.us-west-1.amazonaws.com/1000000/1000000_0.JPEG";
		  		break;
		  	case 990138:
		  		imageFirst = "https://brwbusinessimages.s3.us-west-1.amazonaws.com/1000000/1000000_0.JPEG";
		  		break;
		  	case 990139:
		  		imageFirst = "https://brwbusinessimages.s3.us-west-1.amazonaws.com/1000000/1000000_0.JPEG";
		  		break;
		  	case 990140:
		  		imageFirst = "https://brwbusinessimages.s3.us-west-1.amazonaws.com/1000000/1000000_0.JPEG";
		  		break;
		  	//BTYPE_RETAIL
		  	case 990141:
		  		imageFirst = "";
		  		break;
		  	case 990142:
				imageFirst = "";
				break;
		  	case 990143:
			  	imageFirst = "";
			  	break;
		  	case 990144:
			  	imageFirst = "";
			  	break;
		  	case 990145:
		  		imageFirst = "";
		  		break;
		  	case 990146:
		  		imageFirst = "";
		  		break;
		  	case 990147:
		  		imageFirst = "";
		  		break;
		  	case 990148:
		  		imageFirst = "";
		  		break;
		  	case 990149:
		  		imageFirst = "";
		  		break;
		  	case 990150:
		  		imageFirst = "";
		  		break;
		  	//BTYPE_SER_BIZ
		  	case 990151:
		  		imageFirst = "";
		  		break;
		  	case 990152:
				imageFirst = "";
				break;
		  	case 990153:
			  	imageFirst = "";
			  	break;
		  	case 990154:
			  	imageFirst = "";
			  	break;
		  	case 990155:
		  		imageFirst = "";
		  		break;
		  	case 990156:
		  		imageFirst = "";
		  		break;
		  	case 990157:
		  		imageFirst = "";
		  		break;
		  	case 990158:
		  		imageFirst = "";
		  		break;
		  	case 990159:
		  		imageFirst = "";
		  		break;
		  	case 990160:
		  		imageFirst = "";
		  		break;
		  	//BTYPE_TRANS_STOR
		  	case 990161:
		  		imageFirst = "";
		  		break;
		  	case 990162:
				imageFirst = "";
				break;
		  	case 990163:
			  	imageFirst = "";
			  	break;
		  	case 990164:
			  	imageFirst = "";
			  	break;
		  	case 990165:
		  		imageFirst = "";
		  		break;
		  	case 990166:
		  		imageFirst = "";
		  		break;
		  	case 990167:
		  		imageFirst = "";
		  		break;
		  	case 990168:
		  		imageFirst = "";
		  		break;
		  	case 990169:
		  		imageFirst = "";
		  		break;
		  	case 990170:
		  		imageFirst = "";
		  		break;
		  	//BTYPE_TRAVEL
		  	case 990171:
		  		imageFirst = "";
		  		break;
		  	case 990172:
				imageFirst = "";
				break;
		  	case 990173:
			  	imageFirst = "";
			  	break;
		  	case 990174:
			  	imageFirst = "";
			  	break;
		  	case 990175:
		  		imageFirst = "";
		  		break;
		  	case 990176:
		  		imageFirst = "";
		  		break;
		  	case 990177:
		  		imageFirst = "";
		  		break;
		  	case 990178:
		  		imageFirst = "";
		  		break;
		  	case 990179:
		  		imageFirst = "";
		  		break;
		  	case 990180:
		  		imageFirst = "";
		  		break;
		  	//BTYPE_WHLSL_DIST
		  	case 990181:
		  		imageFirst = "";
		  		break;
		  	case 990182:
				imageFirst = "";
				break;
		  	case 990183:
			  	imageFirst = "";
			  	break;
		  	case 990184:
			  	imageFirst = "";
			  	break;
		  	case 990185:
		  		imageFirst = "";
		  		break;
		  	case 990186:
		  		imageFirst = "";
		  		break;
		  	case 990187:
		  		imageFirst = "";
		  		break;
		  	case 990188:
		  		imageFirst = "";
		  		break;
		  	case 990189:
		  		imageFirst = "";
		  		break;
		  	case 990190:
		  		imageFirst = "";
		  		break;
		  	//BTYPE_MISC
		  	case 990191:
		  		imageFirst = "";
		  		break;
		  	case 990192:
				imageFirst = "";
				break;
		  	case 990193:
			  	imageFirst = "";
			  	break;
		  	case 990194:
			  	imageFirst = "";
			  	break;
		  	case 990195:
		  		imageFirst = "";
		  		break;
		  	case 990196:
		  		imageFirst = "";
		  		break;
		  	case 990197:
		  		imageFirst = "";
		  		break;
		  	case 990198:
		  		imageFirst = "";
		  		break;
		  	case 990199:
		  		imageFirst = "";
		  		break;
		  	case 990200:
		  		imageFirst = "";
		  		break;
		}
		
		logger.info("Elapsed time in getDefaultImageForBizType: " + (System.currentTimeMillis() - start));

		return imageFirst;
	}
}