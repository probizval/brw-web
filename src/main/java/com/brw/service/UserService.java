package com.brw.service;

import java.util.Date;

import com.brw.dto.UserActivityDTO;
import com.brw.dto.UserBusinessDTO;
import com.brw.dto.UserBusinessListDTO;
import com.brw.dto.UserDTO;

public interface UserService {
	
	public UserDTO addUserProfile(UserDTO userDTO);
	public UserDTO updateUserProfile(UserDTO userDTO);
	public UserDTO getUserProfile(UserDTO userDTO);
	public UserBusinessDTO addUserBusiness(UserBusinessDTO userBusinessDTO);
	public UserBusinessListDTO getUserBusinesses(int userId);
	public void deleteUserBusiness(int userId, String relationship);
	public UserActivityDTO trackUserActivity(UserActivityDTO userActivityDTO);
	public int getTotalBusinessViews(int businessId);
	public int getBusinessViewsSince(int businessId, String dateSince);
}
