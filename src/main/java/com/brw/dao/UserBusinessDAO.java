package com.brw.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.brw.entities.UserBusiness;

public interface UserBusinessDAO extends PagingAndSortingRepository<UserBusiness, Integer> {

	@Query(nativeQuery=true, value="SELECT * FROM t_brw_user_business WHERE user_id = :userId")
	List<UserBusiness> getUserBusinesses(@Param ("userId") int userId);
	
	@Modifying
	@Transactional
	@Query(nativeQuery=true, value="DELETE FROM t_brw_user_business WHERE user_id = :userId AND relationship_type = :relationship")
	int deleteUserBusiness(@Param ("userId") int userId, @Param ("relationship") String relationship);
}