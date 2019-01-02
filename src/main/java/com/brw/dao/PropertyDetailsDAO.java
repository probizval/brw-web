package com.brw.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.query.Param;

import com.brw.entities.PropertyDetails;

@Repository
public interface PropertyDetailsDAO extends PagingAndSortingRepository<PropertyDetails, Integer>{

	
	List<PropertyDetails> findByPropertyName(@Param ("propertyName") String propertyName);
	
	@Query(nativeQuery=true, value="SELECT property_code,business_type_code,zip_code,id,img_url,property_id, property_type, latitude, longitude, listedOn, property_name, property_address, business_type, city, state, zip_code, lot_size,zoning_category,current_owner_name, estated_estimated_value,  ( 3959 * acos( cos( radians(:latitude) ) * cos( radians( latitude ) ) * cos( radians( longitude ) - radians(:longitude) ) + sin( radians(:latitude) ) * sin( radians( latitude ) ) ) ) AS distance FROM RW_Property_Details where (:zipCode is null or zip_code = :zipCode) HAVING distance < 1;")
	List<PropertyDetails> getProperties(@Param ("latitude") Double latitude,@Param ("longitude") Double longitude,@Param ("zipCode") Integer zipCode);
	
	List<PropertyDetails> findAllByUserId(@Param ("userId") int userId);
}
