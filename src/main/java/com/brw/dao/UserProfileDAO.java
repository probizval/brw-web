package com.brw.dao;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import com.brw.entities.UserProfile;

public interface UserProfileDAO extends PagingAndSortingRepository<UserProfile, Integer> {

	List<UserProfile> findByEmailId(@Param ("emailId") String emailId);

}
