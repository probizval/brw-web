package com.brw.dao;

/**
 * @author sidpatil
 * 2020
 */

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.brw.entities.SearchAgent;

import org.springframework.data.repository.query.Param;

@Repository
public interface SearchAgentDAO extends PagingAndSortingRepository<SearchAgent, Integer>{

	@Query(nativeQuery=true, value="SELECT * FROM t_brw_search_agent WHERE user_id = :userId;")
	List<SearchAgent> getSearchAgents(@Param ("userId") int userId);
	
	//@Query(nativeQuery=true, value="SELECT * FROM t_brw_estimate WHERE (:businessId is null or biz_id = :businessId) ORDER BY est_id DESC;")
	//List<Estimates> getEstimatesHistory(@Param ("businessId") int businessId);
}
