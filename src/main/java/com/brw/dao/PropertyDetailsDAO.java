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
	
	@Query(nativeQuery=true, value="SELECT property_code,business_type_code,zip_code,id,img_url,property_id, property_type, "
			+ "latitude, longitude, listedOn, property_name, property_address, business_type, city,user_id, state, zip_code, lot_size,zoning_category,"
			+ "current_owner_name, estated_estimated_value,  "
			+ "( 3959 * acos( cos( radians(:latitude) ) * cos( radians( latitude ) ) * cos( radians( longitude ) - radians(:longitude) ) "
			+ "+ sin( radians(:latitude) ) * sin( radians( latitude ) ) ) ) AS distance FROM rw_property_details where "
			+ "(:zipCode is null or zip_code = :zipCode ) AND (:businessType is null or business_type = :businessType) "
			+ "AND (:minPrice is null or estated_estimated_value >= :minPrice)  AND (:maxPrice is null or estated_estimated_value <= :maxPrice) "
			+ "HAVING distance < 10;")
	List<PropertyDetails> getProperties(@Param ("latitude") Double latitude,@Param ("longitude") Double longitude,@Param ("zipCode") Integer zipCode, @Param ("businessType") String businessType, @Param ("minPrice") Double minPrice, @Param ("maxPrice") Double maxPrice);
	
	List<PropertyDetails> findAllByUserId(@Param ("userId") int userId);
	
	
	Page<PropertyDetails> findAllByUserId(Pageable pageable, @Param ("userId") int userId);
	
	@Query(nativeQuery=true, value="Select propdetails.* from rw_user_bookmarked_listing as bookmarks INNER JOIN rw_property_details as propdetails ON bookmarks.property_details_id = propdetails.id and bookmarks.user_id=:userId")
	Page<PropertyDetails> findBookmarkPropByUserId(Pageable pageable, @Param ("userId") int userId);
}
