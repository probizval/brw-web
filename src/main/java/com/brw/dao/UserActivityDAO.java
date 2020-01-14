package com.brw.dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import com.brw.entities.UserActivity;

public interface UserActivityDAO extends PagingAndSortingRepository<UserActivity, Integer> {

	@Query(nativeQuery=true, value="SELECT * FROM t_brw_user_activity WHERE user_id = :userId")
	List<UserActivity> getUserActivity(@Param ("userId") int userId);
	
	@Query(nativeQuery=true, value="SELECT * FROM t_brw_user_activity WHERE biz_id = :businessId AND type = 'READ' and sub_type = 'BUSINESS'")
	List<UserActivity> getTotalBusinessViews(@Param ("businessId") int businessId);
	
	@Query(nativeQuery=true, value="SELECT * FROM t_brw_user_activity WHERE biz_id = :businessId AND type = 'READ' and sub_type = 'BUSINESS' AND create_date > :dateSince")
	List<UserActivity> getBusinessViewsSince(@Param ("businessId") int businessId, @Param ("dateSince")  Date dateSince);
}