package com.brw.service;

import com.brw.dto.UserDTO;

public interface UserService {
	
	public UserDTO addUserProfile(UserDTO userDTO);
	public UserDTO updateUserProfile(UserDTO userDTO);
	public UserDTO getUserProfile(UserDTO userDTO);
	public UserDTO addUserBusiness(UserDTO userDTO);
	public UserDTO getUserBusiness(UserDTO userDTO);
	public UserDTO removeUserBusiness(UserDTO userDTO);

}
