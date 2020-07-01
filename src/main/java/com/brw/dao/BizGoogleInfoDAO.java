package com.brw.dao;

/**
 * @author sidpatil
 * 2020
 */

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.query.Param;

import com.brw.entities.BizGoogleInfo;

@Repository
public interface BizGoogleInfoDAO extends PagingAndSortingRepository<BizGoogleInfo, Integer>{
	//No method implementation so far other than save being called from AsyncProcessingServiceImpl
	
}