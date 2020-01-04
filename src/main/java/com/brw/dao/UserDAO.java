package com.brw.dao;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import com.brw.entities.User;

public interface UserDAO extends PagingAndSortingRepository<User, Integer> {

	//List<User> findByEmailId(@Param ("emailId") String emailId);

}
