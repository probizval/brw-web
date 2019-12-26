package com.brw.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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
		
		/*
		User user = userDAO.findById(userDTO.getUserId()).get();
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
