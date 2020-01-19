package com.brw.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.brw.entities.RelatedBusiness;

public interface RelatedBusinessDAO extends PagingAndSortingRepository<RelatedBusiness, Integer> {

	@Query(nativeQuery=true, value="SELECT * FROM t_brw_related_business WHERE biz_id = :businessId")
	List<RelatedBusiness> getRelatedBusinesses(@Param ("businessId") int businessId);
	
	@Modifying
	@Transactional
	@Query(nativeQuery=true, value="DELETE FROM t_brw_related_business WHERE biz_id = :businessId AND related_biz_id = :relatedBizId")
	int deleteRelatedBusiness(@Param ("businessId") int businessId, @Param ("relatedBizId") int relatedBizId);
}