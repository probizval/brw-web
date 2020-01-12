package com.brw.service;

import com.brw.dto.UserBusinessDTO;
import com.brw.dto.UserDTO;

public interface UserService {
	
	public UserDTO addUserProfile(UserDTO userDTO);
	public UserDTO updateUserProfile(UserDTO userDTO);
	public UserDTO getUserProfile(UserDTO userDTO);
	public UserBusinessDTO addUserBusiness(UserBusinessDTO userBusinessDTO);
	public UserBusinessDTO getUserBusiness(UserBusinessDTO userBusinessDTO);
	public void deleteUserBusiness(UserBusinessDTO userBusinessDTO);
}
