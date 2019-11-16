package com.brw.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpServerErrorException.InternalServerError;

import com.brw.common.constants.ErrorCodes;
import com.brw.common.response.ApiResponse;
import com.brw.dao.BusinessDetailsDAO;
import com.brw.dao.PropertyDetailsDAO;
import com.brw.dto.GasStationDetailsDTO;
import com.brw.dto.LiquorStoreDTO;
import com.brw.dto.PropertyDetailsDTO;
import com.brw.dto.PropertyListDTO;
import com.brw.dto.PropertyMetaDataDTO;
import com.brw.dto.RestaurantDetailsDTO;
import com.brw.dto.SalonStoreDTO;
import com.brw.dto.SimpleSearchFilterDTO;
import com.brw.exceptions.PropertyDetailsException;
import com.brw.dto.AutoServiceDTO;
import com.brw.dto.BookMarksDTO;
import com.brw.dto.BusinessListDTO;
import com.brw.dto.BusinessRequirementDTO;
import com.brw.dto.CoinLaundryDetailsDTO;
import com.brw.dto.FilterDTO;
import com.brw.service.PropertyDetailsService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/v1/")
public class PropertyDetailsController implements ErrorController {

	public static final Logger logger = LoggerFactory.getLogger(PropertyDetailsController.class);

	@Autowired
	PropertyDetailsService propertyDetailsService;

	@Override
	public String getErrorPath() {
		// TODO Auto-generated method stub
		return "/error";
	}
	
	@RequestMapping(value = "propertyList", method = RequestMethod.POST, produces = "application/json")
	public ApiResponse<?> getAllProperties(@RequestBody FilterDTO filter) {
		
		System.out.println("**** Inside PropertyDetailsController.getAllProperties()");

		logger.info(" get all properties");
		PropertyListDTO properties = propertyDetailsService.getAllPropertyList(filter);
		return ApiResponse.withData(properties);
	}

	@RequestMapping(value = "property/{id}", method = RequestMethod.GET, produces = "application/json")
	public ApiResponse<?> getPropertyDetails(@PathVariable int id) {
		
		System.out.println("**** Inside PropertyDetailsController.getPropertyDetails()");

		PropertyMetaDataDTO propertyDetailsDTO = null;
		try {
			propertyDetailsDTO = propertyDetailsService.getPropertyDetails(id);
		} catch (PropertyDetailsException e) {
			return ApiResponse.withError(ErrorCodes.INTERNAL_SERVER_ERROR, "Record not found");
		}

		return ApiResponse.withData(propertyDetailsDTO);
	}

	@PostMapping(value = "property")
	public ResponseEntity<PropertyDetailsDTO> createProperty(@RequestBody PropertyDetailsDTO propertyDetailsDTO) {
		try {
			PropertyDetailsDTO pDTo = propertyDetailsService.savePropertyDetail(propertyDetailsDTO);
			return new ResponseEntity<>(pDTo, HttpStatus.OK);
		} catch (InternalServerError e) {
			// TODO: handle exception
			return new ResponseEntity<>(propertyDetailsDTO, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping(value = "property")
	public ResponseEntity<PropertyDetailsDTO> updateProperty(@RequestBody PropertyDetailsDTO propertyDetailsDTO) {
		try {
			PropertyDetailsDTO pDTo = propertyDetailsService.updatePropertyDetail(propertyDetailsDTO);
			return new ResponseEntity<>(propertyDetailsDTO, HttpStatus.OK);
		} catch (InternalServerError e) {
			// TODO: handle exception
			return new ResponseEntity<>(propertyDetailsDTO, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@RequestMapping(value = "propertydetails/{id}", method = RequestMethod.GET, produces = "application/json")
	public ApiResponse<?> getGasStationPropertyDetails(@PathVariable int id) {

		PropertyMetaDataDTO propertyMetaDataDTO = null;
		try {
			propertyMetaDataDTO = propertyDetailsService.getPropertyDetails(id);
		} catch (PropertyDetailsException e) {
			return ApiResponse.withError(ErrorCodes.INTERNAL_SERVER_ERROR, e.getMessage());
		}

		if (propertyMetaDataDTO.getPropertyMetaData().getBusinessType().equalsIgnoreCase("Gas Station")) {
			GasStationDetailsDTO gasStationDetailsDTO = null;
			try {
				gasStationDetailsDTO = propertyDetailsService.getGasStationPropertyDetails(id);
			} catch (PropertyDetailsException e) {
				return ApiResponse.withError(ErrorCodes.INTERNAL_SERVER_ERROR);
			}
			return ApiResponse.withData(gasStationDetailsDTO);
		} else if (propertyMetaDataDTO.getPropertyMetaData().getBusinessType().equalsIgnoreCase("Restaurants and Food")) {
			RestaurantDetailsDTO restaurantDetailsDTO = null;
			try {
				restaurantDetailsDTO = propertyDetailsService.getRestaurantPropertyDetails(id);
			} catch (PropertyDetailsException e) {
				return ApiResponse.withError(ErrorCodes.INTERNAL_SERVER_ERROR, e.getMessage());
			}
			return ApiResponse.withData(restaurantDetailsDTO);
		}  else if (propertyMetaDataDTO.getPropertyMetaData().getBusinessType().equalsIgnoreCase("Laundry")) {
			CoinLaundryDetailsDTO coinLaundryDetailsDTO = null;
			try {
				coinLaundryDetailsDTO = propertyDetailsService.getCoinLaundryPropertyDetails(id);
			} catch (PropertyDetailsException e) {
				return ApiResponse.withError(ErrorCodes.INTERNAL_SERVER_ERROR, e.getMessage());
			}
			return ApiResponse.withData(coinLaundryDetailsDTO);
		} else if (propertyMetaDataDTO.getPropertyMetaData().getBusinessType().equalsIgnoreCase("Liquor Store")) {
			LiquorStoreDTO  liquorStoreDTO = null;
			try {
				liquorStoreDTO = propertyDetailsService.getLiquerStorePropertyDetails(id);
			} catch (PropertyDetailsException e) {
				return ApiResponse.withError(ErrorCodes.INTERNAL_SERVER_ERROR, e.getMessage());
			}
			return ApiResponse.withData(liquorStoreDTO);
		} else if (propertyMetaDataDTO.getPropertyMetaData().getBusinessType().equalsIgnoreCase("Beauty Salon/Spa/Nail")) {
			SalonStoreDTO  salonStoreDTO = null;
			try {
				salonStoreDTO = propertyDetailsService.getSalonStorePropertyDetails(id);
			} catch (PropertyDetailsException e) {
				return ApiResponse.withError(ErrorCodes.INTERNAL_SERVER_ERROR, e.getMessage());
			}
			return ApiResponse.withData(salonStoreDTO);
		} else if (propertyMetaDataDTO.getPropertyMetaData().getBusinessType().equalsIgnoreCase("Auto Service Shop")) {
			AutoServiceDTO  autoServiceDTO = null;
			try {
				autoServiceDTO = propertyDetailsService.getAutoServicePropertyDetails(id);
			} catch (PropertyDetailsException e) {
				return ApiResponse.withError(ErrorCodes.INTERNAL_SERVER_ERROR, e.getMessage());
			}
			return ApiResponse.withData(autoServiceDTO);
		} else {
			return ApiResponse.withData(propertyMetaDataDTO);
		}

	}

	@PostMapping(value = "property/gasstation")
	public ApiResponse<?> createGasStationProperty(
			@RequestBody GasStationDetailsDTO gasStationDetailsDTO) {
		try {
			GasStationDetailsDTO pDTo = propertyDetailsService.saveGasStationPropertyDetail(gasStationDetailsDTO);
			return ApiResponse.withData(pDTo);
		} catch (InternalServerError e) {
			// TODO: handle exception
			return ApiResponse.withError(ErrorCodes.INTERNAL_SERVER_ERROR);
		} catch (PropertyDetailsException e) {
			return ApiResponse.withError(ErrorCodes.INTERNAL_SERVER_ERROR, e.getMessage());
		}
	}
	
	@PutMapping(value = "property/gasstation")
	public ApiResponse<?> updateGasStationProperty(
			@RequestBody GasStationDetailsDTO gasStationDetailsDTO) {
		try {
			GasStationDetailsDTO pDTo = propertyDetailsService.updateGasStationPropertyDetail(gasStationDetailsDTO);
			return ApiResponse.withData(pDTo);
		} catch (InternalServerError e) {
			// TODO: handle exception
			return ApiResponse.withError(ErrorCodes.INTERNAL_SERVER_ERROR);
		} catch (PropertyDetailsException e) {
			return ApiResponse.withError(ErrorCodes.INTERNAL_SERVER_ERROR, e.getMessage());
		}
	}
	
	@PostMapping(value = "property/restaurant")
	public ApiResponse<?> createRestaurantProperty(@RequestBody RestaurantDetailsDTO restaurantDetailsDTO) {
		try {
			RestaurantDetailsDTO restDTO = propertyDetailsService.saveRestaurantPropertyDetail(restaurantDetailsDTO);
			return ApiResponse.withData(restDTO);
		} catch (InternalServerError e) {
			return ApiResponse.withError(ErrorCodes.INTERNAL_SERVER_ERROR);
		} catch (PropertyDetailsException e) {
			return ApiResponse.withError(ErrorCodes.INTERNAL_SERVER_ERROR, e.getMessage());
		}
	}
	
	@PutMapping(value = "property/restaurant")
	public ApiResponse<?> updateRestaurantProperty(@RequestBody RestaurantDetailsDTO restaurantDetailsDTO) {
		try {
			RestaurantDetailsDTO restDTO = propertyDetailsService.updateRestaurantPropertyDetail(restaurantDetailsDTO);
			return ApiResponse.withData(restDTO);
		} catch (InternalServerError e) {
			return ApiResponse.withError(ErrorCodes.INTERNAL_SERVER_ERROR);
		} catch (PropertyDetailsException e) {
			return ApiResponse.withError(ErrorCodes.INTERNAL_SERVER_ERROR, e.getMessage());
		}
	}
	
	@PostMapping(value = "property/laundry")
	public ApiResponse<?> createLaundryProperty(@RequestBody CoinLaundryDetailsDTO coinLaundryDetailsDTO) {
		try {
			CoinLaundryDetailsDTO restDTO = propertyDetailsService.saveCoinLaundryPropertyDetail(coinLaundryDetailsDTO);
			return ApiResponse.withData(restDTO);
		} catch (InternalServerError e) {
			return ApiResponse.withError(ErrorCodes.INTERNAL_SERVER_ERROR);
		} catch (PropertyDetailsException e) {
			return ApiResponse.withError(ErrorCodes.INTERNAL_SERVER_ERROR, e.getMessage());
		}
	}
	
	@PutMapping(value = "property/laundry")
	public ApiResponse<?> updateLaundryProperty(@RequestBody CoinLaundryDetailsDTO coinLaundryDetailsDTO) {
		try {
			CoinLaundryDetailsDTO restDTO = propertyDetailsService.updateCoinLaundryPropertyDetail(coinLaundryDetailsDTO);
			return ApiResponse.withData(restDTO);
		} catch (InternalServerError e) {
			return ApiResponse.withError(ErrorCodes.INTERNAL_SERVER_ERROR);
		} catch (PropertyDetailsException e) {
			return ApiResponse.withError(ErrorCodes.INTERNAL_SERVER_ERROR, e.getMessage());
		}
	}
	
	@PostMapping(value = "property/liquorstore")
	public ApiResponse<?> createLiquorStoreProperty(@RequestBody LiquorStoreDTO liquorStoreDTO) {
		try {
			LiquorStoreDTO liquorDTO = propertyDetailsService.saveLiquerStorePropertyDetail(liquorStoreDTO);
			return ApiResponse.withData(liquorDTO);
		} catch (InternalServerError e) {
			return ApiResponse.withError(ErrorCodes.INTERNAL_SERVER_ERROR);
		} catch (PropertyDetailsException e) {
			return ApiResponse.withError(ErrorCodes.INTERNAL_SERVER_ERROR, e.getMessage());
		}
	}
	
	@PutMapping(value = "property/liquorstore")
	public ApiResponse<?> updateLiquorStoreProperty(@RequestBody LiquorStoreDTO liquorStoreDTO) {
		try {
			LiquorStoreDTO liquorDTO = propertyDetailsService.updateLiquerStorePropertyDetail(liquorStoreDTO);
			return ApiResponse.withData(liquorDTO);
		} catch (InternalServerError e) {
			return ApiResponse.withError(ErrorCodes.INTERNAL_SERVER_ERROR);
		} catch (PropertyDetailsException e) {
			return ApiResponse.withError(ErrorCodes.INTERNAL_SERVER_ERROR, e.getMessage());
		}
	}
	
	@PostMapping(value = "property/salonstore")
	public ApiResponse<?> createSalonStoreProperty(@RequestBody SalonStoreDTO salonStoreDTO) {
		try {
			SalonStoreDTO salonDTO = propertyDetailsService.saveSalonStorePropertyDetail(salonStoreDTO);
			return ApiResponse.withData(salonDTO);
		} catch (InternalServerError e) {
			return ApiResponse.withError(ErrorCodes.INTERNAL_SERVER_ERROR);
		} catch (PropertyDetailsException e) {
			return ApiResponse.withError(ErrorCodes.INTERNAL_SERVER_ERROR, e.getMessage());
		}
	}
	
	@PutMapping(value = "property/salonstore")
	public ApiResponse<?> updateSalonStoreProperty(@RequestBody SalonStoreDTO salonStoreDTO) {
		try {
			SalonStoreDTO salonDTO = propertyDetailsService.updateSalonStorePropertyDetail(salonStoreDTO);
			return ApiResponse.withData(salonDTO);
		} catch (InternalServerError e) {
			return ApiResponse.withError(ErrorCodes.INTERNAL_SERVER_ERROR);
		} catch (PropertyDetailsException e) {
			return ApiResponse.withError(ErrorCodes.INTERNAL_SERVER_ERROR, e.getMessage());
		}
	}
	
	@PostMapping(value = "property/autoservice")
	public ApiResponse<?> createAutoServiceProperty(@RequestBody AutoServiceDTO autoServiceDTO) {
		try {
			AutoServiceDTO autoDTO = propertyDetailsService.saveAutoServicePropertyDetail(autoServiceDTO);
			return ApiResponse.withData(autoDTO);
		} catch (InternalServerError e) {
			return ApiResponse.withError(ErrorCodes.INTERNAL_SERVER_ERROR);
		} catch (PropertyDetailsException e) {
			return ApiResponse.withError(ErrorCodes.INTERNAL_SERVER_ERROR, e.getMessage());
		}
	}
	
	@PutMapping(value = "property/autoservice")
	public ApiResponse<?> updateAutoServiceProperty(@RequestBody AutoServiceDTO autoServiceDTO) {
		try {
			AutoServiceDTO autoDTO = propertyDetailsService.updateAutoServicePropertyDetail(autoServiceDTO);
			return ApiResponse.withData(autoDTO);
		} catch (InternalServerError e) {
			return ApiResponse.withError(ErrorCodes.INTERNAL_SERVER_ERROR);
		} catch (PropertyDetailsException e) {
			return ApiResponse.withError(ErrorCodes.INTERNAL_SERVER_ERROR, e.getMessage());
		}
	}
	
	@PostMapping(value = "property/bookmarks")
	public ApiResponse<?> saveBookMarks(@RequestBody BookMarksDTO bookMarksDTO) {
		try {
			BookMarksDTO bookmarkedDTO = propertyDetailsService.saveBookMarksDetail(bookMarksDTO);
			return ApiResponse.withData(bookmarkedDTO);
		} catch (InternalServerError e) {
			return ApiResponse.withError(ErrorCodes.INTERNAL_SERVER_ERROR);
		} catch (PropertyDetailsException e) {
			return ApiResponse.withError(ErrorCodes.INTERNAL_SERVER_ERROR, e.getMessage());
		}
	}
	
	@PostMapping(value = "property/removebookmarks")
	public ApiResponse<?> deleteBookMarks(@RequestBody BookMarksDTO bookMarksDTO) {
		try {
			Boolean bookmarkedDTO = propertyDetailsService.deleteBookMarksDetail(bookMarksDTO);
			return ApiResponse.withData(bookmarkedDTO);
		} catch (InternalServerError e) {
			return ApiResponse.withError(ErrorCodes.INTERNAL_SERVER_ERROR);
		} catch (PropertyDetailsException e) {
			return ApiResponse.withError(ErrorCodes.INTERNAL_SERVER_ERROR, e.getMessage());
		}
	}
	
	@PostMapping(value = "property/businessrequirement")
	public ApiResponse<?> saveBusinessRequirement(@RequestBody BusinessRequirementDTO businessRequirementDTO) {
		try {
			businessRequirementDTO = propertyDetailsService.saveBusinessRequirement(businessRequirementDTO);
			return ApiResponse.withData(businessRequirementDTO);
		} catch (InternalServerError e) {
			return ApiResponse.withError(ErrorCodes.INTERNAL_SERVER_ERROR);
		}
	}
	
	
}