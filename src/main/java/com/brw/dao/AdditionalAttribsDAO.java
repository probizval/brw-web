package com.brw.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;

/**
 * @author sidpatil
 * 2019
 */

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.repository.query.Param;

import com.brw.entities.AdditionalAttributes;

@Repository
public interface AdditionalAttribsDAO extends PagingAndSortingRepository<AdditionalAttributes, Integer>{

	@Query(nativeQuery=true, value="SELECT * FROM t_brw_business_add_attributes WHERE biz_id = :businessId ORDER BY type, sub_type DESC;")
	List<AdditionalAttributes> getAdditionalAttributes(@Param ("businessId") int businessId);
	
	@Modifying
	@Transactional
	@Query(nativeQuery=true, value="DELETE FROM t_brw_business_add_attributes WHERE biz_id = :businessId")
	int deleteAdditionalAttributes(@Param ("businessId") int businessId);
}