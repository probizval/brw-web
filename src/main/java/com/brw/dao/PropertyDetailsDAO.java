package com.brw.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.query.Param;

import com.brw.entities.PropertyDetails;

@Repository
public interface PropertyDetailsDAO extends PagingAndSortingRepository<PropertyDetails, Integer>{

	
	List<PropertyDetails> findByPropertyName(@Param ("propertyName") String propertyName);
	
	@Query(nativeQuery=true, value="SELECT * FROM t_brw_business")
	List<PropertyDetails> getProperties(@Param ("latitude") Double latitude,@Param ("longitude") Double longitude,@Param ("zipCode") Integer zipCode, @Param ("businessType") String businessType, @Param ("minPrice") Double minPrice, @Param ("maxPrice") Double maxPrice);
	
	List<PropertyDetails> findAllByUserId(@Param ("userId") int userId);
	
	
	Page<PropertyDetails> findAllByUserId(Pageable pageable, @Param ("userId") int userId);
	
	@Query(nativeQuery=true, value="Select propdetails.* from rw_user_bookmarked_listing as bookmarks INNER JOIN rw_property_details as propdetails ON bookmarks.property_details_id = propdetails.id and bookmarks.user_id=:userId")
	Page<PropertyDetails> findBookmarkPropByUserId(Pageable pageable, @Param ("userId") int userId);
}
