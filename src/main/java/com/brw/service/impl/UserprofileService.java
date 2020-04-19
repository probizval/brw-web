package com.brw.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.brw.dao.UserProfileDAO;
import com.brw.dto.UserProfileDTO;
import com.brw.entities.UserProfile;
import com.brw.service.UserProfileService;

@Component
public class UserprofileService implements UserProfileService {

	@Autowired
	private UserProfileDAO userProfileDAO;
	
	
	@Override
	public UserProfileDTO getUserProfile(UserProfileDTO userDTO) {
		
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
		
		return userProfileDTO;
	}


	@Override
	public UserProfileDTO updateUserProfile(UserProfileDTO userProfileDTO) {
		
		userProfileDTO.setId(1001);
		
		System.out.println("**** 222 Inside UserProfileService.updateUserProfile() getId: "+userProfileDTO.getId());
		System.out.println("**** 222 Inside UserProfileService.updateUserProfile() getEmailId: "+userProfileDTO.getEmailId());
		System.out.println("**** 222 Inside UserProfileService.updateUserProfile() getFirstName: "+userProfileDTO.getFirstName());
		System.out.println("**** 222 Inside UserProfileService.updateUserProfile() getLastName: "+userProfileDTO.getLastName());
		System.out.println("**** 222 Inside UserProfileService.updateUserProfile() getAgentTitle: "+userProfileDTO.getAgentTitle());
		
		UserProfile userProfile = userProfileDAO.findById(userProfileDTO.getId()).get();
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
		
		userProfile = userProfileDAO.save(userProfile);
		
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
		
		return userProfileDTO;
	}

}
