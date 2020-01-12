package com.brw.dao;

/**
 * @author siyapatil
 * 2019
 */

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.query.Param;

import com.brw.entities.Image;

@Repository
public interface ImageDAO extends PagingAndSortingRepository<Image, Integer>{
		
	@Query(nativeQuery=true, value="SELECT * FROM t_brw_image WHERE biz_id = :businessId);")
	Image getImages(@Param ("businessId") int businessId);
}