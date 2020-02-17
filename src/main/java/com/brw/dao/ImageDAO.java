package com.brw.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;

/**
 * @author siyapatil
 * 2019
 */

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.repository.query.Param;

import com.brw.entities.Image;

@Repository
public interface ImageDAO extends PagingAndSortingRepository<Image, Integer>{
		
	@Query(nativeQuery=true, value="SELECT * FROM t_brw_image WHERE biz_id = :businessId ORDER BY image_id ASC")
	List <Image> getImages(@Param ("businessId") int businessId);
	
	@Modifying
	@Transactional
	@Query(nativeQuery=true, value="DELETE FROM t_brw_image WHERE biz_id = :businessId AND image_id = :imageId")
	int deleteImage(@Param ("businessId") int businessId, @Param ("imageId") int imageId);
}