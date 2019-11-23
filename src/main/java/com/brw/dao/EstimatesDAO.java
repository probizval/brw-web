package com.brw.dao;

import java.util.List;

/**
 * @author sidpatil
 * 2019
 */

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.query.Param;

import com.brw.entities.Estimates;

@Repository
public interface EstimatesDAO extends PagingAndSortingRepository<Estimates, Integer>{

	@Query(nativeQuery=true, value="SELECT * FROM t_brw_estimate WHERE (:businessId is null or biz_id = :businessId) ORDER BY est_id DESC LIMIT 3;")
	List<Estimates> getEstimates(@Param ("businessId") int businessId);
	
	//@Query(nativeQuery=true, value="SELECT * FROM t_brw_estimate WHERE (:businessId is null or biz_id = :businessId) ORDER BY est_id DESC;")
	//List<Estimates> getEstimatesHistory(@Param ("businessId") int businessId);
}
