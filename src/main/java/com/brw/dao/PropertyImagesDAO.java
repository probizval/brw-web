package com.brw.dao;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.brw.dto.PropertyImagesDTO;
import com.brw.entities.PropertyImages;

@Repository
public interface PropertyImagesDAO  extends PagingAndSortingRepository<PropertyImages, Integer> {

	List<PropertyImages> findByPropertyCode(@Param ("propertyCode") String propertyCode);
	
}