package com.brw.service.impl;

/**
 * @author sidpatil
 * 2019-20
 */

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.brw.common.constants.Constants;
import com.brw.dao.UserActivityDAO;
import com.brw.dao.UserBusinessDAO;
import com.brw.dao.UserDAO;
import com.brw.dto.UserActivityDTO;
import com.brw.dto.UserBusinessDTO;
import com.brw.dto.UserBusinessListDTO;
import com.brw.dto.UserDTO;
import com.brw.entities.User;
import com.brw.entities.UserActivity;
import com.brw.entities.UserBusiness;
import com.brw.service.UserService;

@Component
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDAO userDAO;
	
	@Autowired
	private UserBusinessDAO userBusinessDAO;
	
	@Autowired
	private UserActivityDAO userActivityDAO;
	
	@Override
	public UserDTO addUserProfile(UserDTO userDTO) {
		
		System.out.println("222 **** Inside UserServiceImpl.addUser(): "+userDTO.getUserId());
		
		User user = new User();
		user.setUserId(userDTO.getUserId());
		user.setEmail(userDTO.getEmail());
		
		if (null != userDTO.getUserType() && Constants.EMPTY_STRING != userDTO.getUserType()) {
			user.setUserType(userDTO.getUserType());
		} else {
			user.setUserType(Constants.DEFAULT_USER_TYPE);
		}
		
		if (null != userDTO.getFirstName() && Constants.EMPTY_STRING != userDTO.getFirstName()) {
			user.setFirstName(userDTO.getFirstName());
		} else {
			user.setFirstName(Constants.DEFAULT_FIRST_NAME);
		}
		
		if (null != userDTO.getLastName() && Constants.EMPTY_STRING != userDTO.getLastName()) {
			user.setLastName(userDTO.getLastName());
		} else {
			user.setLastName(Constants.DEFAULT_LAST_NAME);
		}
		
		user.setMiddleInitial(userDTO.getMiddleInitial());
		user.setPhoneCountryCode(userDTO.getPhoneCountryCode());
		user.setPhoneNumber(userDTO.getPhoneNumber());
		user.setPhoneExtention(userDTO.getPhoneExtention());
		
		user.setIsSearchAgentEmail(userDTO.getIsSearchAgentEmail());
		user.setSearchAgentEmailFreq(userDTO.getSearchAgentEmailFreq());
		user.setIsUserVerified(userDTO.getIsUserVerified());
		user.setUserVerificationMethod(userDTO.getUserVerificationMethod());
		
		if (null != userDTO.getUserVerificationDate() && Constants.EMPTY_STRING != userDTO.getUserVerificationDate()) {
			user.setUserVerificationDate(LocalDateTime.parse(userDTO.getUserVerificationDate(), DateTimeFormatter.ofPattern(Constants.DATE_FORMAT)));
		}
		user.setIsBrokerVerified(userDTO.getIsBrokerVerified());
		user.setBrokerVerificationMethod(userDTO.getBrokerVerificationMethod());
		if (null != userDTO.getBrokerVerificationDate() && Constants.EMPTY_STRING != userDTO.getBrokerVerificationDate()) {
			user.setBrokerVerificationDate(LocalDateTime.parse(userDTO.getBrokerVerificationDate(), DateTimeFormatter.ofPattern(Constants.DATE_FORMAT)));
		}
		user.setBrokerLicenseNumber(userDTO.getBrokerLicenseNumber());
		user.setBrokerImageUrl(userDTO.getBrokerImageUrl());
		user.setBrokerDescription(userDTO.getBrokerDescription());
		
		user.setLastLoginDate(LocalDateTime.now());
		
		user.setStreet1(userDTO.getStreet1());
		user.setStreet2(userDTO.getStreet2());
		user.setCity(userDTO.getCity());
		user.setState(userDTO.getState());
		user.setForeignState(userDTO.getForeignState());
		user.setZip(userDTO.getZip());
		user.setForeignPostalCode(userDTO.getForeignPostalCode());
		user.setCountry(userDTO.getCountry());
		user.setIsVettedBuyer(userDTO.getIsVettedBuyer());
		user.setBuyerVettingMethod(userDTO.getBuyerVettingMethod());
		if (null != userDTO.getBuyerPurchaseCapLow()) {
			user.setBuyerPurchaseCapLow(userDTO.getBuyerPurchaseCapLow());
		} else {
			user.setBuyerPurchaseCapLow(0);
		}
		if (null != userDTO.getBuyerPurchaseCapHigh()) {
			user.setBuyerPurchaseCapHigh(userDTO.getBuyerPurchaseCapHigh());
		} else {
			user.setBuyerPurchaseCapHigh(0);
		}
		if (null != userDTO.getBuyerVettingDate() && Constants.EMPTY_STRING != userDTO.getBuyerVettingDate()) {
			user.setBuyerVettingDate(LocalDateTime.parse(userDTO.getBuyerVettingDate(), DateTimeFormatter.ofPattern(Constants.DATE_FORMAT)));
		}
		user.setCreatedByUserId(userDTO.getInvokerId());
		user.setCreateDate(LocalDateTime.now());
		user.setUpdatedByUserId(userDTO.getInvokerId());
		user.setUpdateDate(LocalDateTime.now());
		
		User returnUser = userDAO.save(user);
		
		UserDTO returnUserDTO = new UserDTO();
		returnUserDTO.setUserId(returnUser.getUserId());
		returnUserDTO.setEmail(returnUser.getEmail());
		returnUserDTO.setUserType(returnUser.getUserType());
		returnUserDTO.setFirstName(returnUser.getFirstName());
		returnUserDTO.setLastName(returnUser.getLastName());
		returnUserDTO.setMiddleInitial(returnUser.getMiddleInitial());
		returnUserDTO.setPhoneCountryCode(returnUser.getPhoneCountryCode());
		returnUserDTO.setPhoneNumber(returnUser.getPhoneNumber());
		returnUserDTO.setPhoneExtention(returnUser.getPhoneExtention());
		returnUserDTO.setIsSearchAgentEmail(returnUser.getIsSearchAgentEmail());
		returnUserDTO.setSearchAgentEmailFreq(returnUser.getSearchAgentEmailFreq());
		returnUserDTO.setIsUserVerified(returnUser.getIsUserVerified());
		returnUserDTO.setUserVerificationMethod(returnUser.getUserVerificationMethod());
				
		if (null != returnUser.getUserVerificationDate()) {
			returnUserDTO.setUserVerificationDate(returnUser.getUserVerificationDate().format(DateTimeFormatter.ofPattern(Constants.DATE_FORMAT)));
		} else {
			returnUserDTO.setUserVerificationDate(null);
		}
		
		returnUserDTO.setIsBrokerVerified(returnUser.getIsBrokerVerified());
		returnUserDTO.setBrokerVerificationMethod(returnUser.getBrokerVerificationMethod());
				
		if (null != returnUser.getBrokerVerificationDate()) {
			returnUserDTO.setBrokerVerificationDate(returnUser.getBrokerVerificationDate().format(DateTimeFormatter.ofPattern(Constants.DATE_FORMAT)));
		} else {
			returnUserDTO.setBrokerVerificationDate(null);
		}
		
		returnUserDTO.setBrokerLicenseNumber(returnUser.getBrokerLicenseNumber());
		returnUserDTO.setBrokerImageUrl(returnUser.getBrokerImageUrl());
		returnUserDTO.setBrokerDescription(returnUser.getBrokerDescription());
				
		if (null != returnUser.getLastLoginDate()) {
			returnUserDTO.setLastLoginDate(returnUser.getLastLoginDate().format(DateTimeFormatter.ofPattern(Constants.DATE_FORMAT)));
		} else {
			returnUserDTO.setLastLoginDate(null);
		}
		
		returnUserDTO.setStreet1(returnUser.getStreet1());
		returnUserDTO.setStreet2(returnUser.getStreet2());
		returnUserDTO.setCity(returnUser.getCity());
		returnUserDTO.setState(returnUser.getState());
		returnUserDTO.setForeignState(returnUser.getForeignState());
		returnUserDTO.setZip(returnUser.getZip());
		returnUserDTO.setForeignPostalCode(returnUser.getForeignPostalCode());
		returnUserDTO.setCountry(returnUser.getCountry());
		returnUserDTO.setIsVettedBuyer(returnUser.getIsVettedBuyer());
		returnUserDTO.setBuyerVettingMethod(returnUser.getBuyerVettingMethod());
		returnUserDTO.setBuyerPurchaseCapLow(returnUser.getBuyerPurchaseCapLow());
		returnUserDTO.setBuyerPurchaseCapHigh(returnUser.getBuyerPurchaseCapHigh());
				
		if (null != returnUser.getBuyerVettingDate()) {
			returnUserDTO.setBuyerVettingDate(returnUser.getBuyerVettingDate().format(DateTimeFormatter.ofPattern(Constants.DATE_FORMAT)));
		} else {
			returnUserDTO.setBuyerVettingDate(null);
		}
		
		returnUserDTO.setCreatedByUserId(returnUser.getCreatedByUserId());
		returnUserDTO.setCreateDate(returnUser.getCreateDate().format(DateTimeFormatter.ofPattern(Constants.DATE_FORMAT)));
		returnUserDTO.setUpdatedByUserId(returnUserDTO.getInvokerId());
		returnUserDTO.setUpdateDate(returnUser.getUpdateDate().format(DateTimeFormatter.ofPattern(Constants.DATE_FORMAT)));
		
		return returnUserDTO;
	}
	
	@Override
	public UserDTO getUserProfile(UserDTO userDTO) {
		
		System.out.println("222 **** Inside UserServiceImpl.getUserProfile(): "+userDTO.getEmail());
		
		User returnUser = userDAO.getUserProfile(userDTO.getEmail());
	
		UserDTO returnUserDTO = new UserDTO();
		returnUserDTO.setUserId(returnUser.getUserId());
		returnUserDTO.setEmail(returnUser.getEmail());
		returnUserDTO.setUserType(returnUser.getUserType());
		returnUserDTO.setFirstName(returnUser.getFirstName());
		returnUserDTO.setLastName(returnUser.getLastName());
		returnUserDTO.setMiddleInitial(returnUser.getMiddleInitial());
		returnUserDTO.setPhoneCountryCode(returnUser.getPhoneCountryCode());
		returnUserDTO.setPhoneNumber(returnUser.getPhoneNumber());
		returnUserDTO.setPhoneExtention(returnUser.getPhoneExtention());
		returnUserDTO.setIsSearchAgentEmail(returnUser.getIsSearchAgentEmail());
		returnUserDTO.setSearchAgentEmailFreq(returnUser.getSearchAgentEmailFreq());
		returnUserDTO.setIsUserVerified(returnUser.getIsUserVerified());
		returnUserDTO.setUserVerificationMethod(returnUser.getUserVerificationMethod());
		returnUserDTO.setUserVerificationDate(returnUser.getUserVerificationDate().format(DateTimeFormatter.ofPattern(Constants.DATE_FORMAT)));
		returnUserDTO.setIsBrokerVerified(returnUser.getIsBrokerVerified());
		returnUserDTO.setBrokerVerificationMethod(returnUser.getBrokerVerificationMethod());
		returnUserDTO.setBrokerVerificationDate(returnUser.getBrokerVerificationDate().format(DateTimeFormatter.ofPattern(Constants.DATE_FORMAT)));
		returnUserDTO.setBrokerLicenseNumber(returnUser.getBrokerLicenseNumber());
		returnUserDTO.setBrokerImageUrl(returnUser.getBrokerImageUrl());
		returnUserDTO.setBrokerDescription(returnUser.getBrokerDescription());
		returnUserDTO.setLastLoginDate(returnUser.getLastLoginDate().format(DateTimeFormatter.ofPattern(Constants.DATE_FORMAT)));
		returnUserDTO.setStreet1(returnUser.getStreet1());
		returnUserDTO.setStreet2(returnUser.getStreet2());
		returnUserDTO.setCity(returnUser.getCity());
		returnUserDTO.setState(returnUser.getState());
		returnUserDTO.setForeignState(returnUser.getForeignState());
		returnUserDTO.setZip(returnUser.getZip());
		returnUserDTO.setForeignPostalCode(returnUser.getForeignPostalCode());
		returnUserDTO.setCountry(returnUser.getCountry());
		returnUserDTO.setIsVettedBuyer(returnUser.getIsVettedBuyer());
		returnUserDTO.setBuyerVettingMethod(returnUser.getBuyerVettingMethod());
		returnUserDTO.setBuyerPurchaseCapLow(returnUser.getBuyerPurchaseCapLow());
		returnUserDTO.setBuyerPurchaseCapHigh(returnUser.getBuyerPurchaseCapHigh());
		returnUserDTO.setBuyerVettingDate(returnUser.getBuyerVettingDate().format(DateTimeFormatter.ofPattern(Constants.DATE_FORMAT)));
		returnUserDTO.setCreatedByUserId(returnUser.getCreatedByUserId());
		returnUserDTO.setCreateDate(returnUser.getCreateDate().format(DateTimeFormatter.ofPattern(Constants.DATE_FORMAT)));
		returnUserDTO.setUpdatedByUserId(returnUserDTO.getInvokerId());
		returnUserDTO.setUpdateDate(returnUser.getUpdateDate().format(DateTimeFormatter.ofPattern(Constants.DATE_FORMAT)));
		
		return returnUserDTO;
	}

	@Override
	public UserDTO updateUserProfile(UserDTO userDTO) {
		
		System.out.println("222 **** Inside UserServiceImpl.updateUserDetails(): "+userDTO.getUserId());
		
		User user = userDAO.findById(userDTO.getUserId()).get();

		if (null != userDTO.getEmail() && userDTO.getEmail() != Constants.EMPTY_STRING) {
			user.setEmail(userDTO.getEmail());
		}
		
		if (null != userDTO.getUserType() && userDTO.getUserType() != Constants.EMPTY_STRING) {
			user.setUserType(userDTO.getUserType());
		}
		
		if (null != userDTO.getFirstName() && userDTO.getFirstName() != Constants.EMPTY_STRING) {
			user.setFirstName(userDTO.getFirstName());
		}
		
		if (null != userDTO.getLastName() && userDTO.getLastName() != Constants.EMPTY_STRING) {
			user.setLastName(userDTO.getLastName());
		}
		
		if (null != userDTO.getMiddleInitial() && userDTO.getMiddleInitial() != Constants.EMPTY_STRING) {
			user.setMiddleInitial(userDTO.getMiddleInitial());
		}
		
		if (null != userDTO.getPhoneCountryCode() && userDTO.getPhoneCountryCode() != Constants.EMPTY_STRING) {
			user.setPhoneCountryCode(userDTO.getPhoneCountryCode());
		}
		
		if (null != userDTO.getPhoneNumber() && userDTO.getPhoneNumber() != Constants.EMPTY_STRING) {
			user.setPhoneNumber(userDTO.getPhoneNumber());
		}
		
		if (null != userDTO.getPhoneExtention() && userDTO.getPhoneExtention() != Constants.EMPTY_STRING) {
			user.setPhoneExtention(userDTO.getPhoneExtention());
		}
		
		if (null != userDTO.getIsSearchAgentEmail() && userDTO.getIsSearchAgentEmail() != Constants.EMPTY_STRING) {
			user.setIsSearchAgentEmail(userDTO.getIsSearchAgentEmail());
		}
		
		if (null != userDTO.getSearchAgentEmailFreq() && userDTO.getSearchAgentEmailFreq() != Constants.EMPTY_STRING) {
			user.setSearchAgentEmailFreq(userDTO.getSearchAgentEmailFreq());
		}
		
		if (null != userDTO.getIsUserVerified() && userDTO.getIsUserVerified() != Constants.EMPTY_STRING) {
			user.setIsUserVerified(userDTO.getIsUserVerified());
		}
		
		if (null != userDTO.getUserVerificationMethod() && userDTO.getUserVerificationMethod() != Constants.EMPTY_STRING) {
			user.setUserVerificationMethod(userDTO.getUserVerificationMethod());
		}
		
		if (null != userDTO.getUserVerificationDate() && userDTO.getUserVerificationDate() != Constants.EMPTY_STRING) {
			user.setUserVerificationDate(LocalDateTime.parse(userDTO.getUserVerificationDate(), DateTimeFormatter.ofPattern(Constants.DATE_FORMAT)));
		}
		
		if (null != userDTO.getIsBrokerVerified() && userDTO.getIsBrokerVerified() != Constants.EMPTY_STRING) {
			user.setIsBrokerVerified(userDTO.getIsBrokerVerified());
		}
		
		if (null != userDTO.getBrokerVerificationMethod() && userDTO.getBrokerVerificationMethod() != Constants.EMPTY_STRING) {
			user.setBrokerVerificationMethod(userDTO.getBrokerVerificationMethod());
		}
		
		if (null != userDTO.getBrokerVerificationDate() && userDTO.getBrokerVerificationDate() != Constants.EMPTY_STRING) {
			user.setBrokerVerificationDate(LocalDateTime.parse(userDTO.getBrokerVerificationDate(), DateTimeFormatter.ofPattern(Constants.DATE_FORMAT)));
		}
		
		if (null != userDTO.getBrokerLicenseNumber() && userDTO.getBrokerLicenseNumber() != Constants.EMPTY_STRING) {
			user.setBrokerLicenseNumber(userDTO.getBrokerLicenseNumber());
		}
		
		if (null != userDTO.getBrokerImageUrl() && userDTO.getBrokerImageUrl() != Constants.EMPTY_STRING) {
			user.setBrokerImageUrl(userDTO.getBrokerImageUrl());
		}
		
		if (null != userDTO.getBrokerDescription() && userDTO.getBrokerDescription() != Constants.EMPTY_STRING) {
			user.setBrokerDescription(userDTO.getBrokerDescription());
		}
		
		if (null != userDTO.getLastLoginDate() && userDTO.getLastLoginDate() != Constants.EMPTY_STRING) {
			user.setLastLoginDate(LocalDateTime.parse(userDTO.getLastLoginDate(), DateTimeFormatter.ofPattern(Constants.DATE_FORMAT)));
		}
		
		if (null != userDTO.getStreet1() && userDTO.getStreet1() != Constants.EMPTY_STRING) {
			user.setStreet1(userDTO.getStreet1());
		}
		
		if (null != userDTO.getStreet2() && userDTO.getStreet2() != Constants.EMPTY_STRING) {
			user.setStreet2(userDTO.getStreet2());
		}
		
		if (null != userDTO.getCity() && userDTO.getCity() != Constants.EMPTY_STRING) {
			user.setCity(userDTO.getCity());
		}
		
		if (null != userDTO.getState() && userDTO.getState() != Constants.EMPTY_STRING) {
			user.setState(userDTO.getState());
		}
		
		if (null != userDTO.getForeignState() && userDTO.getForeignState() != Constants.EMPTY_STRING) {
			user.setForeignState(userDTO.getForeignState());
		}
		
		if (null != userDTO.getZip() && userDTO.getZip() != Constants.EMPTY_STRING) {
			user.setZip(userDTO.getZip());
		}
		
		if (null != userDTO.getForeignPostalCode() && userDTO.getForeignPostalCode() != Constants.EMPTY_STRING) {
			user.setForeignPostalCode(userDTO.getForeignPostalCode());
		}
		
		if (null != userDTO.getCountry() && userDTO.getCountry() != Constants.EMPTY_STRING) {
			user.setCountry(userDTO.getCountry());
		}
		
		if (null != userDTO.getIsVettedBuyer() && userDTO.getIsVettedBuyer() != Constants.EMPTY_STRING) {
			user.setIsVettedBuyer(userDTO.getIsVettedBuyer());
		}
		
		if (null != userDTO.getBuyerVettingMethod() && userDTO.getBuyerVettingMethod() != Constants.EMPTY_STRING) {
			user.setBuyerVettingMethod(userDTO.getBuyerVettingMethod());
		}
		
		if (null != userDTO.getBuyerPurchaseCapLow()) {
			user.setBuyerPurchaseCapLow(userDTO.getBuyerPurchaseCapLow());
		}
		
		if (null != userDTO.getBuyerPurchaseCapHigh()) {
			user.setBuyerPurchaseCapHigh(userDTO.getBuyerPurchaseCapHigh());
		}
		
		if (null != userDTO.getBuyerVettingDate() && userDTO.getBuyerVettingDate() != Constants.EMPTY_STRING) {
			user.setBuyerVettingDate(LocalDateTime.parse(userDTO.getBuyerVettingDate(), DateTimeFormatter.ofPattern(Constants.DATE_FORMAT)));
		}

		user.setUpdatedByUserId(userDTO.getInvokerId());
		user.setUpdateDate(LocalDateTime.now());
		
		User returnUser = userDAO.save(user);
		
		UserDTO returnUserDTO = new UserDTO();
		returnUserDTO.setUserId(returnUser.getUserId());
		returnUserDTO.setEmail(returnUser.getEmail());
		returnUserDTO.setUserType(returnUser.getUserType());
		returnUserDTO.setFirstName(returnUser.getFirstName());
		returnUserDTO.setLastName(returnUser.getLastName());
		returnUserDTO.setMiddleInitial(returnUser.getMiddleInitial());
		returnUserDTO.setPhoneCountryCode(returnUser.getPhoneCountryCode());
		returnUserDTO.setPhoneNumber(returnUser.getPhoneNumber());
		returnUserDTO.setPhoneExtention(returnUser.getPhoneExtention());
		returnUserDTO.setIsSearchAgentEmail(returnUser.getIsSearchAgentEmail());
		returnUserDTO.setSearchAgentEmailFreq(returnUser.getSearchAgentEmailFreq());
		returnUserDTO.setIsUserVerified(returnUser.getIsUserVerified());
		returnUserDTO.setUserVerificationMethod(returnUser.getUserVerificationMethod());
		returnUserDTO.setUserVerificationDate(returnUser.getUserVerificationDate().format(DateTimeFormatter.ofPattern(Constants.DATE_FORMAT)));
		returnUserDTO.setIsBrokerVerified(returnUser.getIsBrokerVerified());
		returnUserDTO.setBrokerVerificationMethod(returnUser.getBrokerVerificationMethod());
		returnUserDTO.setBrokerVerificationDate(returnUser.getBrokerVerificationDate().format(DateTimeFormatter.ofPattern(Constants.DATE_FORMAT)));
		returnUserDTO.setBrokerLicenseNumber(returnUser.getBrokerLicenseNumber());
		returnUserDTO.setBrokerImageUrl(returnUser.getBrokerImageUrl());
		returnUserDTO.setBrokerDescription(returnUser.getBrokerDescription());
		returnUserDTO.setLastLoginDate(returnUser.getLastLoginDate().format(DateTimeFormatter.ofPattern(Constants.DATE_FORMAT)));
		returnUserDTO.setStreet1(returnUser.getStreet1());
		returnUserDTO.setStreet2(returnUser.getStreet2());
		returnUserDTO.setCity(returnUser.getCity());
		returnUserDTO.setState(returnUser.getState());
		returnUserDTO.setForeignState(returnUser.getForeignState());
		returnUserDTO.setZip(returnUser.getZip());
		returnUserDTO.setForeignPostalCode(returnUser.getForeignPostalCode());
		returnUserDTO.setCountry(returnUser.getCountry());
		returnUserDTO.setIsVettedBuyer(returnUser.getIsVettedBuyer());
		returnUserDTO.setBuyerVettingMethod(returnUser.getBuyerVettingMethod());
		returnUserDTO.setBuyerPurchaseCapLow(returnUser.getBuyerPurchaseCapLow());
		returnUserDTO.setBuyerPurchaseCapHigh(returnUser.getBuyerPurchaseCapHigh());
		returnUserDTO.setBuyerVettingDate(returnUser.getBuyerVettingDate().format(DateTimeFormatter.ofPattern(Constants.DATE_FORMAT)));
		returnUserDTO.setCreatedByUserId(returnUser.getCreatedByUserId());
		returnUserDTO.setCreateDate(returnUser.getCreateDate().format(DateTimeFormatter.ofPattern(Constants.DATE_FORMAT)));
		returnUserDTO.setUpdatedByUserId(returnUserDTO.getUpdatedByUserId());
		returnUserDTO.setUpdateDate(returnUser.getUpdateDate().format(DateTimeFormatter.ofPattern(Constants.DATE_FORMAT)));
		
		return returnUserDTO;
	}

	@Override
	public UserBusinessDTO addUserBusiness(UserBusinessDTO userBusinessDTO) {
		
		System.out.println("222 **** Inside UserServiceImpl.addUserBusiness(): "+userBusinessDTO.getRelationship());
		
		UserBusiness userBusiness = new UserBusiness();
		UserBusinessDTO returnUserBusinessDTO = new UserBusinessDTO();
		
		userBusiness.setUserId(userBusinessDTO.getUserId());
		userBusiness.setRelationship(userBusinessDTO.getRelationship());
		userBusiness.setBusinessId(userBusinessDTO.getBusinessId());
		userBusiness.setCreatedByUserId(userBusinessDTO.getUserId());
		userBusiness.setCreateDate(LocalDateTime.now());
		userBusiness.setUpdatedByUserId(userBusinessDTO.getUserId());
		userBusiness.setUpdateDate(LocalDateTime.now());
		
		UserBusiness returnUserBusiness = userBusinessDAO.save(userBusiness);
		
		returnUserBusinessDTO.setUserId(returnUserBusiness.getUserId());
		returnUserBusinessDTO.setRelationship(returnUserBusiness.getRelationship());
		returnUserBusinessDTO.setBusinessId(returnUserBusiness.getBusinessId());
		returnUserBusinessDTO.setCreatedByUserId(returnUserBusiness.getCreatedByUserId());
		returnUserBusinessDTO.setCreateDate(returnUserBusiness.getCreateDate().format(DateTimeFormatter.ofPattern(Constants.DATE_FORMAT)));
		returnUserBusinessDTO.setUpdatedByUserId(returnUserBusiness.getUpdatedByUserId());
		returnUserBusinessDTO.setUpdateDate(returnUserBusiness.getUpdateDate().format(DateTimeFormatter.ofPattern(Constants.DATE_FORMAT)));
		
		return returnUserBusinessDTO;
	}
	
	@Override
	public UserBusinessListDTO getUserBusinesses(int userId) {
		System.out.println("222 **** Inside SearchAgentServiceImpl.getSearchAgent()");
		
		List<UserBusiness> userBusinessList = (List<UserBusiness>)userBusinessDAO.getUserBusinesses(userId);
		List<UserBusinessDTO> useBusinessDTOList = new ArrayList<UserBusinessDTO>();
		UserBusinessListDTO userBusinessListDTO = new UserBusinessListDTO();
		
		for (UserBusiness returnUserBusiness: userBusinessList) {
			UserBusinessDTO returnUserBusinessDTO = new UserBusinessDTO();
			
			returnUserBusinessDTO.setUserId(returnUserBusiness.getUserId());
			returnUserBusinessDTO.setRelationship(returnUserBusiness.getRelationship());
			returnUserBusinessDTO.setBusinessId(returnUserBusiness.getBusinessId());
			returnUserBusinessDTO.setCreatedByUserId(returnUserBusiness.getCreatedByUserId());
			returnUserBusinessDTO.setCreateDate(returnUserBusiness.getCreateDate().format(DateTimeFormatter.ofPattern(Constants.DATE_FORMAT)));
			returnUserBusinessDTO.setUpdatedByUserId(returnUserBusiness.getUpdatedByUserId());
			returnUserBusinessDTO.setUpdateDate(returnUserBusiness.getUpdateDate().format(DateTimeFormatter.ofPattern(Constants.DATE_FORMAT)));
		
			useBusinessDTOList.add(returnUserBusinessDTO);
		}
		userBusinessListDTO.setUserBusinessList(useBusinessDTOList);
		return userBusinessListDTO;
	}
	
	@Override
	public void deleteUserBusiness(int userId, String relationship) {
		System.out.println("222 **** Inside SearchAgentServiceImpl.deleteSearchAgent()");
		
		int nurDeleted = userBusinessDAO.deleteUserBusiness(userId, relationship);
		
		System.out.println("222 **** Inside SearchAgentServiceImpl.deleteSearchAgent() nurDeleted: "+nurDeleted);
	}
	
	@Override
	public UserActivityDTO trackUserActivity(UserActivityDTO userActivityDTO) {
		
		System.out.println("222 **** Inside UserServiceImpl.trackUserActivity()");
		
		UserActivity userActivity = new UserActivity();
		userActivity.setUserId(userActivityDTO.getUserId());
		userActivity.setBusinessId(userActivityDTO.getBusinessId());
		userActivity.setType(userActivityDTO.getType());
		userActivity.setSubType(userActivityDTO.getSubType());
		userActivity.setCreatedByUserId(userActivityDTO.getUserId());
		userActivity.setCreateDate(LocalDateTime.now());
		userActivity.setUpdatedByUserId(userActivityDTO.getUserId());
		userActivity.setUpdateDate(LocalDateTime.now());
		
		UserActivity returnUserActivity = userActivityDAO.save(userActivity);
		
		UserActivityDTO returnUserActivityDTO = new UserActivityDTO();
		returnUserActivityDTO.setUserId(returnUserActivity.getUserId());
		returnUserActivityDTO.setBusinessId(returnUserActivity.getBusinessId());
		returnUserActivityDTO.setType(returnUserActivity.getType());
		returnUserActivityDTO.setSubType(returnUserActivity.getSubType());
		returnUserActivityDTO.setCreatedByUserId(returnUserActivity.getUserId());
		returnUserActivityDTO.setCreateDate(returnUserActivity.getCreateDate().format(DateTimeFormatter.ofPattern(Constants.DATE_FORMAT)));
		returnUserActivityDTO.setUpdatedByUserId(returnUserActivity.getUserId());
		returnUserActivityDTO.setUpdateDate(returnUserActivity.getUpdateDate().format(DateTimeFormatter.ofPattern(Constants.DATE_FORMAT)));
		
		return returnUserActivityDTO;
	}
	
	@Override
	public int getTotalBusinessViews(int userId) {
		
		System.out.println("222 **** Inside UserServiceImpl.getTotalBusinessViews()");
		return 0;
	}
	
	@Override
	public int getBusinessViewsSince(int userId, String dateSince) {
		
		System.out.println("222 **** Inside UserServiceImpl.getTotalBusinessViews()");
		return 0;
	}
}
