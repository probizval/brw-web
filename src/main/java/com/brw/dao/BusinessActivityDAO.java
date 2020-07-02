package com.brw.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import com.brw.entities.BusinessActivity;

public interface BusinessActivityDAO extends PagingAndSortingRepository<BusinessActivity, Integer> {
	
	@Query(nativeQuery=true, value="SELECT view_counter FROM t_brw_business "
			+ "WHERE (:businessId is null or biz_id = :businessId);")
	int getBizViewCounter(@Param ("businessId") int businessId);
}