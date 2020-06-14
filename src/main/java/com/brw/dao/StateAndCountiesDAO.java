package com.brw.dao;

import java.util.List;

/**
 * @author sidpatil
 * 2020
 */

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.query.Param;

import com.brw.entities.CountyCoordinates;

@Repository
public interface StateAndCountiesDAO extends PagingAndSortingRepository<CountyCoordinates, Integer>{

	@Query(nativeQuery=true, value="SELECT * FROM t_brw_state_counties WHERE state_name = :stateName ORDER BY county_name ASC;")
	List<CountyCoordinates> getCountiesAndCoordinates(@Param ("stateName") String stateName);
}