package com.brw.dao;

import java.util.List;

/**
 * @author sidpatil
 * 2019
 */

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.brw.entities.AdditionalAttribDefinitions;

import org.springframework.data.repository.query.Param;

@Repository
public interface AdditionalAttribDefinitionsDAO extends PagingAndSortingRepository<AdditionalAttribDefinitions, Integer>{

	@Query(nativeQuery=true, value="SELECT * FROM t_brw_business_add_attribute_def WHERE business_type = :bizType AND business_sub_type = :bizSubType ORDER BY type, sub_type DESC;")
	List<AdditionalAttribDefinitions> getAdditionalAttribDefinitions(@Param ("bizType") String bizType, @Param ("bizSubType") String bizSubType);
}
