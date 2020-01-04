package com.brw.dao;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.brw.entities.User;

public interface UserDAO extends PagingAndSortingRepository<User, Integer> {

	//List<User> findByEmailId(@Param ("emailId") String emailId);

}
