package com.brw.service;

import java.util.Date;

import com.brw.dto.UserActivityDTO;
import com.brw.dto.UserBusinessDTO;
import com.brw.dto.UserBusinessListDTO;
import com.brw.dto.UserDTO;

public interface UserService {
	
	public UserDTO addUserProfile(UserDTO userDTO) throws Exception;
	public UserDTO updateUserProfile(UserDTO userDTO) throws Exception;
	public UserDTO getUserProfile(UserDTO userDTO) throws Exception;
	public UserBusinessDTO addUserBusiness(UserBusinessDTO userBusinessDTO) throws Exception;
	public UserBusinessListDTO getUserBusinesses(int userId) throws Exception;
	public void deleteUserBusiness(int userId, String relationship) throws Exception;
	public UserActivityDTO trackUserActivity(UserActivityDTO userActivityDTO) throws Exception;
	public int getTotalBusinessViews(int businessId) throws Exception;
	public int getBusinessViewsSince(int businessId, String dateSince) throws Exception;
}
