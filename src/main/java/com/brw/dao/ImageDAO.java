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
	
	//@Query(nativeQuery=true, value="SELECT * FROM t_brw_images where (name_dba = :imagesName) AND (type = :imagesType);")
	
	@Query(nativeQuery=true, value="SELECT * FROM t_brw_business WHERE (:businessId is null or biz_id = :imagesId);")
	Image getImages(@Param ("imagesId") int imagesId);
}