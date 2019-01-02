package com.brw.service;

import com.brw.dto.UserProfileDTO;

public interface UserProfileService {
	public UserProfileDTO getUserProfile(UserProfileDTO userProfileDTO);
	public UserProfileDTO updateUserProfile(UserProfileDTO userProfileDTO);

}
