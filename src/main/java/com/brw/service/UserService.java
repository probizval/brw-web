package com.brw.service;

import com.brw.dto.UserDTO;

public interface UserService {
	
	public UserDTO addUser(UserDTO userDTO);
	public UserDTO updateUserDetails(UserDTO userDTO);
	public UserDTO getUserDetails(UserDTO userDTO);
	public UserDTO addUserBusiness(UserDTO userDTO);
	public UserDTO getUserBusiness(UserDTO userDTO);
	public UserDTO removeUserBusiness(UserDTO userDTO);

}
