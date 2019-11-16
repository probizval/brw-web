package com.brw.dao;

/**
 * @author sidpatil
 */

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.query.Param;

import com.brw.entities.BusinessDetails;

@Repository
public interface BusinessDetailsDAO extends PagingAndSortingRepository<BusinessDetails, Integer>{

	
	//List<PropertyDetails> findByPropertyName(@Param ("propertyName") String propertyName);
	
	List<BusinessDetails> findByBusinessName(@Param ("businessName") String businessName);
	
	@Query(nativeQuery=true, value="SELECT * FROM t_brw_business where (:businessName is null or name_dba = :businessName ) AND (:businessType is null or type = :businessType);")
	//@Query(nativeQuery=true, value="SELECT * FROM t_brw_business where (name_dba = :businessName) AND (type = :businessType);")
	List<BusinessDetails> searchBusiness(@Param ("businessName") String businessName, @Param ("businessType") String businessType);
	
	@Query(nativeQuery=true, value="SELECT * FROM t_brw_business where (:businessId is null or biz_id = :businessId);")
	BusinessDetails getBusinessDetails(@Param ("businessId") int businessId);
	
	//List<PropertyDetails> findAllByUserId(@Param ("userId") int userId);
	
	
	//Page<PropertyDetails> findAllByUserId(Pageable pageable, @Param ("userId") int userId);
	
	//@Query(nativeQuery=true, value="Select propdetails.* from rw_user_bookmarked_listing as bookmarks INNER JOIN rw_property_details as propdetails ON bookmarks.property_details_id = propdetails.id and bookmarks.user_id=:userId")
	//Page<PropertyDetails> findBookmarkPropByUserId(Pageable pageable, @Param ("userId") int userId);
}
