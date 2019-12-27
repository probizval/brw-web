package com.brw.service.impl;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.brw.common.constants.Constant;
import com.brw.dao.UserDAO;
import com.brw.dto.UserDTO;
import com.brw.entities.User;
import com.brw.service.UserService;

@Component
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDAO userDAO;
	
	@Override
	public UserDTO addUser(UserDTO userDTO) {
		
		User user = new User();
		user.setUserId(userDTO.getUserId());
		user.setEmail(userDTO.getEmail());
		user.setIsBroker(userDTO.getIsBroker());
		user.setFirstName(userDTO.getFirstName());
		user.setLastName(userDTO.getLastName());
		user.setMiddleInitial(userDTO.getMiddleInitial());
		user.setPhoneCountryCode(userDTO.getPhoneCountryCode());
		user.setPhoneNumber(userDTO.getPhoneNumber());
		user.setPhoneExtention(userDTO.getPhoneExtention());
		user.setIsSearchAgentEmail(userDTO.getIsSearchAgentEmail());
		user.setSearchAgentEmailFreq(userDTO.getSearchAgentEmailFreq());
		user.setIsUserVerified(userDTO.getIsUserVerified());
		user.setUserVerificationMethod(userDTO.getUserVerificationMethod());
		user.setUserVerificationDate(LocalDateTime.parse(userDTO.getUserVerificationDate(), DateTimeFormatter.ofPattern(Constant.DATE_FORMAT)));
		user.setIsBrokerVerified(userDTO.getIsBrokerVerified());
		user.setBrokerVerificationMethod(userDTO.getBrokerVerificationMethod());
		user.setBrokerVerificationDate(LocalDateTime.parse(userDTO.getBrokerVerificationDate(), DateTimeFormatter.ofPattern(Constant.DATE_FORMAT)));
		user.setBrokerLicenseNumber(userDTO.getBrokerLicenseNumber());
		user.setBrokerImageUrl(userDTO.getBrokerImageUrl());
		user.setBrokerDescription(userDTO.getBrokerDescription());
		user.setLastLoginDate(userDTO.getLastLoginDate());
		user.setStreet1(userDTO.getStreet1());
		user.setStreet2(userDTO.getStreet2());
		user.setCity(userDTO.getCity());
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
		user.setBuyerPurchaseCapLow(userDTO.getBuyerPurchaseCapLow());
		user.setBuyerPurchaseCapHigh(userDTO.getBuyerPurchaseCapHigh());
		user.setBuyerVettingDate(LocalDateTime.parse(userDTO.getBuyerVettingDate(), DateTimeFormatter.ofPattern(Constant.DATE_FORMAT)));
		user.setCreatedByUserId(userDTO.getInvokerId());
		user.setCreateDate(LocalDateTime.now());
		user.setUpdatedByUserId(userDTO.getInvokerId());
		user.setUpdateDate(LocalDateTime.now());
		
		User returnUser = userDAO.save(user);
		
		UserDTO returnUserDTO = new UserDTO();
		returnUserDTO.setUserId(returnUser.getUserId());
		returnUserDTO.setEmail(returnUser.getEmail());
		returnUserDTO.setIsBroker(returnUser.getIsBroker());
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
		returnUserDTO.setUserVerificationDate(returnUser.getUserVerificationDate().format(DateTimeFormatter.ofPattern(Constant.DATE_FORMAT)));
		returnUserDTO.setIsBrokerVerified(returnUser.getIsBrokerVerified());
		returnUserDTO.setBrokerVerificationMethod(returnUser.getBrokerVerificationMethod());
		returnUserDTO.setBrokerVerificationDate(returnUser.getBrokerVerificationDate().format(DateTimeFormatter.ofPattern(Constant.DATE_FORMAT)));
		returnUserDTO.setBrokerLicenseNumber(returnUser.getBrokerLicenseNumber());
		returnUserDTO.setBrokerImageUrl(returnUser.getBrokerImageUrl());
		returnUserDTO.setBrokerDescription(returnUser.getBrokerDescription());
		returnUserDTO.setLastLoginDate(returnUser.getLastLoginDate());
		returnUserDTO.setStreet1(returnUser.getStreet1());
		returnUserDTO.setStreet2(returnUser.getStreet2());
		returnUserDTO.setCity(returnUser.getCity());
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
		returnUserDTO.setBuyerVettingDate(returnUser.getBuyerVettingDate().format(DateTimeFormatter.ofPattern(Constant.DATE_FORMAT)));
		returnUserDTO.setCreatedByUserId(returnUser.getCreatedByUserId());
		returnUserDTO.setCreateDate(returnUser.getCreateDate().format(DateTimeFormatter.ofPattern(Constant.DATE_FORMAT)));
		returnUserDTO.setUpdatedByUserId(returnUserDTO.getInvokerId());
		returnUserDTO.setUpdateDate(returnUser.getUpdateDate().format(DateTimeFormatter.ofPattern(Constant.DATE_FORMAT)));
		
		return returnUserDTO;
	}
	
	@Override
	public UserDTO getUserDetails(UserDTO userDTO) {
		
		/*
		List<UserProfile> userProfileList = (List<UserProfile>) userProfileDAO.findByEmailId(userDTO.getEmailId());
		
		UserProfile userProfile = null;
		
		if(!userProfileList.isEmpty()) {
			userProfile = userProfileList.get(0);
		} else {
			userProfile = new UserProfile();
			userProfile.setFirstName(userDTO.getFirstName());
			userProfile.setLastName(userDTO.getLastName());
			userProfile.setEmailId(userDTO.getEmailId());
			userProfile.setContactNumber(userDTO.getContactNumber());
			userProfile.setAboutAgent(userDTO.getAboutAgent());
			userProfile.setAgentTitle(userDTO.getAgentTitle());
			userProfile.setLocation(userDTO.getLocation());
			userProfile.setAddress(userDTO.getAddress());
			userProfile.setCity(userDTO.getCity());
			userProfile.setState(userDTO.getState());
			userProfile.setCountry(userDTO.getCountry());
			userProfile.setZipcode(userDTO.getZipcode());
			userProfile.setUserImgUrl(userDTO.getUserImgUrl());
			userProfile.setUserType(userDTO.getUserType());
			userProfile = userProfileDAO.save(userProfile);
		}
		
		UserProfileDTO userProfileDTO = new UserProfileDTO();
		userProfileDTO.setId(userProfile.getId());
		userProfileDTO.setFirstName(userProfile.getFirstName());
		userProfileDTO.setLastName(userProfile.getLastName());
		userProfileDTO.setEmailId(userProfile.getEmailId());
		userProfileDTO.setContactNumber(userProfile.getContactNumber());
		userProfileDTO.setAboutAgent(userProfile.getAboutAgent());
		userProfileDTO.setAgentTitle(userProfile.getAgentTitle());
		userProfileDTO.setLocation(userProfile.getLocation());
		userProfileDTO.setAddress(userProfile.getAddress());
		userProfileDTO.setCity(userProfile.getCity());
		userProfileDTO.setState(userProfile.getState());
		userProfileDTO.setCountry(userProfile.getCountry());
		userProfileDTO.setZipcode(userProfile.getZipcode());
		userProfileDTO.setUserImgUrl(userProfile.getUserImgUrl());
		userProfileDTO.setUserType(userProfile.getUserType());
		*/
		return userDTO;
	}

	@Override
	public UserDTO updateUserDetails(UserDTO userDTO) {
		
		/*
		UserProfile userProfile = userDAO.findById(userProfileDTO.getId()).get();
		userProfile.setFirstName(userProfileDTO.getFirstName());
		userProfile.setLastName(userProfileDTO.getLastName());
		userProfile.setContactNumber(userProfileDTO.getContactNumber());
		userProfile.setAboutAgent(userProfileDTO.getAboutAgent());
		userProfile.setAgentTitle(userProfileDTO.getAgentTitle());
		userProfile.setLocation(userProfileDTO.getLocation());
		userProfile.setAddress(userProfileDTO.getAddress());
		userProfile.setCity(userProfileDTO.getCity());
		userProfile.setState(userProfileDTO.getState());
		userProfile.setCountry(userProfileDTO.getCountry());
		userProfile.setZipcode(userProfileDTO.getZipcode());
		userProfile.setUserType(userProfileDTO.getUserType());
		
		userProfile = userDAO.save(userProfile);
		
		userProfileDTO.setId(userProfile.getId());
		userProfileDTO.setFirstName(userProfile.getFirstName());
		userProfileDTO.setLastName(userProfile.getLastName());
		userProfileDTO.setEmailId(userProfile.getEmailId());
		userProfileDTO.setContactNumber(userProfile.getContactNumber());
		userProfileDTO.setAboutAgent(userProfile.getAboutAgent());
		userProfileDTO.setAgentTitle(userProfile.getAgentTitle());
		userProfileDTO.setLocation(userProfile.getLocation());
		userProfileDTO.setAddress(userProfile.getAddress());
		userProfileDTO.setCity(userProfile.getCity());
		userProfileDTO.setState(userProfile.getState());
		userProfileDTO.setCountry(userProfile.getCountry());
		userProfileDTO.setZipcode(userProfile.getZipcode());
		userProfileDTO.setUserImgUrl(userProfile.getUserImgUrl());
		userProfileDTO.setUserType(userProfile.getUserType());
		*/
		return userDTO;
	}

	@Override
	public UserDTO addUserBusiness(UserDTO userDTO) {
		/*
		UserProfile userProfile = userDAO.findById(userProfileDTO.getId()).get();
		userProfile.setFirstName(userProfileDTO.getFirstName());
		userProfile.setLastName(userProfileDTO.getLastName());
		userProfile.setContactNumber(userProfileDTO.getContactNumber());
		userProfile.setAboutAgent(userProfileDTO.getAboutAgent());
		userProfile.setAgentTitle(userProfileDTO.getAgentTitle());
		userProfile.setLocation(userProfileDTO.getLocation());
		userProfile.setAddress(userProfileDTO.getAddress());
		userProfile.setCity(userProfileDTO.getCity());
		userProfile.setState(userProfileDTO.getState());
		userProfile.setCountry(userProfileDTO.getCountry());
		userProfile.setZipcode(userProfileDTO.getZipcode());
		userProfile.setUserType(userProfileDTO.getUserType());
		
		userProfile = userDAO.save(userProfile);
		
		userProfileDTO.setId(userProfile.getId());
		userProfileDTO.setFirstName(userProfile.getFirstName());
		userProfileDTO.setLastName(userProfile.getLastName());
		userProfileDTO.setEmailId(userProfile.getEmailId());
		userProfileDTO.setContactNumber(userProfile.getContactNumber());
		userProfileDTO.setAboutAgent(userProfile.getAboutAgent());
		userProfileDTO.setAgentTitle(userProfile.getAgentTitle());
		userProfileDTO.setLocation(userProfile.getLocation());
		userProfileDTO.setAddress(userProfile.getAddress());
		userProfileDTO.setCity(userProfile.getCity());
		userProfileDTO.setState(userProfile.getState());
		userProfileDTO.setCountry(userProfile.getCountry());
		userProfileDTO.setZipcode(userProfile.getZipcode());
		userProfileDTO.setUserImgUrl(userProfile.getUserImgUrl());
		userProfileDTO.setUserType(userProfile.getUserType());
		*/
		return userDTO;
	}
	
	@Override
	public UserDTO getUserBusiness(UserDTO userDTO) {
		/*
		UserProfile userProfile = userDAO.findById(userProfileDTO.getId()).get();
		userProfile.setFirstName(userProfileDTO.getFirstName());
		userProfile.setLastName(userProfileDTO.getLastName());
		userProfile.setContactNumber(userProfileDTO.getContactNumber());
		userProfile.setAboutAgent(userProfileDTO.getAboutAgent());
		userProfile.setAgentTitle(userProfileDTO.getAgentTitle());
		userProfile.setLocation(userProfileDTO.getLocation());
		userProfile.setAddress(userProfileDTO.getAddress());
		userProfile.setCity(userProfileDTO.getCity());
		userProfile.setState(userProfileDTO.getState());
		userProfile.setCountry(userProfileDTO.getCountry());
		userProfile.setZipcode(userProfileDTO.getZipcode());
		userProfile.setUserType(userProfileDTO.getUserType());
		
		userProfile = userDAO.save(userProfile);
		
		userProfileDTO.setId(userProfile.getId());
		userProfileDTO.setFirstName(userProfile.getFirstName());
		userProfileDTO.setLastName(userProfile.getLastName());
		userProfileDTO.setEmailId(userProfile.getEmailId());
		userProfileDTO.setContactNumber(userProfile.getContactNumber());
		userProfileDTO.setAboutAgent(userProfile.getAboutAgent());
		userProfileDTO.setAgentTitle(userProfile.getAgentTitle());
		userProfileDTO.setLocation(userProfile.getLocation());
		userProfileDTO.setAddress(userProfile.getAddress());
		userProfileDTO.setCity(userProfile.getCity());
		userProfileDTO.setState(userProfile.getState());
		userProfileDTO.setCountry(userProfile.getCountry());
		userProfileDTO.setZipcode(userProfile.getZipcode());
		userProfileDTO.setUserImgUrl(userProfile.getUserImgUrl());
		userProfileDTO.setUserType(userProfile.getUserType());
		*/
		return userDTO;
	}
	
	@Override
	public UserDTO removeUserBusiness(UserDTO userDTO) {
		/*
		UserProfile userProfile = userDAO.findById(userProfileDTO.getId()).get();
		userProfile.setFirstName(userProfileDTO.getFirstName());
		userProfile.setLastName(userProfileDTO.getLastName());
		userProfile.setContactNumber(userProfileDTO.getContactNumber());
		userProfile.setAboutAgent(userProfileDTO.getAboutAgent());
		userProfile.setAgentTitle(userProfileDTO.getAgentTitle());
		userProfile.setLocation(userProfileDTO.getLocation());
		userProfile.setAddress(userProfileDTO.getAddress());
		userProfile.setCity(userProfileDTO.getCity());
		userProfile.setState(userProfileDTO.getState());
		userProfile.setCountry(userProfileDTO.getCountry());
		userProfile.setZipcode(userProfileDTO.getZipcode());
		userProfile.setUserType(userProfileDTO.getUserType());
		
		userProfile = userDAO.save(userProfile);
		
		userProfileDTO.setId(userProfile.getId());
		userProfileDTO.setFirstName(userProfile.getFirstName());
		userProfileDTO.setLastName(userProfile.getLastName());
		userProfileDTO.setEmailId(userProfile.getEmailId());
		userProfileDTO.setContactNumber(userProfile.getContactNumber());
		userProfileDTO.setAboutAgent(userProfile.getAboutAgent());
		userProfileDTO.setAgentTitle(userProfile.getAgentTitle());
		userProfileDTO.setLocation(userProfile.getLocation());
		userProfileDTO.setAddress(userProfile.getAddress());
		userProfileDTO.setCity(userProfile.getCity());
		userProfileDTO.setState(userProfile.getState());
		userProfileDTO.setCountry(userProfile.getCountry());
		userProfileDTO.setZipcode(userProfile.getZipcode());
		userProfileDTO.setUserImgUrl(userProfile.getUserImgUrl());
		userProfileDTO.setUserType(userProfile.getUserType());
		*/
		return userDTO;
	}
}
