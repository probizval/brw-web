package com.brw.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import com.brw.entities.User;

public interface UserDAO extends PagingAndSortingRepository<User, Integer> {

	@Query(nativeQuery=true, value="SELECT * FROM t_brw_user WHERE email = :email")
	User getUserProfile(@Param ("email") String emailId);

}
