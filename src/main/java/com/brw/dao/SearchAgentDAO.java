package com.brw.dao;

/**
 * @author sidpatil
 * 2020
 */

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.brw.entities.SearchAgent;

import org.springframework.data.repository.query.Param;

@Repository
public interface SearchAgentDAO extends PagingAndSortingRepository<SearchAgent, Integer>{

	@Query(nativeQuery=true, value="SELECT * FROM t_brw_search_agent WHERE user_id = :userId")
	List<SearchAgent> getSearchAgents(@Param ("userId") int userId);
	
	@Modifying
	@Transactional
	@Query(nativeQuery=true, value="DELETE FROM t_brw_search_agent WHERE user_id = :userId AND agent_id = :agentId")
	int deleteSearchAgent(@Param ("userId") int userId, @Param ("agentId") int agentId);
}
