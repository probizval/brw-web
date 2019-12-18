package com.brw.dao;

/**
 * @author sidpatil
 * 2019
 */

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.query.Param;

import com.brw.entities.BusinessDetails;

@Repository
public interface BusinessDetailsDAO extends PagingAndSortingRepository<BusinessDetails, Integer>{

	@Query(nativeQuery=true, value="SELECT * FROM t_brw_business "
			+ "WHERE (:businessId is null or biz_id = :businessId);")
	BusinessDetails getBusinessDetails(@Param ("businessId") int businessId);
	
	@Query(nativeQuery=true, value="SELECT * FROM t_brw_business "
			+ "WHERE (:businessType is null or type = :businessName) "
			+ "AND (:businessSubType is null or sub_type = :businessSubType) "
			+ "AND (:state is null or add_state = :state) "
			+ "AND (:city is null or add_city = :city) LIMIT 5;")
	List<BusinessDetails> searchComparableBusiness(@Param ("businessType") String businessType, @Param ("businessSubType") String businessSubType, @Param ("state") String state, @Param ("city") String city);
}