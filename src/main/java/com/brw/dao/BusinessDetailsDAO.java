package com.brw.dao;

/**
 * @author sidpatil
 * 2019
 */

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.query.Param;

import com.brw.entities.BusinessDetails;

@Repository
public interface BusinessDetailsDAO extends PagingAndSortingRepository<BusinessDetails, Integer>{
	
	@Query(nativeQuery=true, value="SELECT * FROM t_brw_business WHERE (:businessName is null or name_dba = :businessName) AND (:businessType is null or type = :businessType) AND (:street1 is null or add_street1 = :street1) AND (:street2 is null or add_street1 = :street2) AND (:city is null or add_city = :city) AND (:state is null or add_city = :state) AND (:zip is null or add_zip = :zip);")
	//@Query(nativeQuery=true, value="SELECT * FROM t_brw_business where (name_dba = :businessName) AND (type = :businessType);")
	List<BusinessDetails> searchBusiness(@Param ("businessName") String businessName, @Param ("businessType") String businessType, @Param ("street1") String street1, @Param ("street2") String street2, @Param ("city") String city, @Param ("state") String state, @Param ("zip") int zip);
	
	@Query(nativeQuery=true, value="SELECT * FROM t_brw_business WHERE (:businessId is null or biz_id = :businessId);")
	BusinessDetails getBusinessDetails(@Param ("businessId") int businessId);
	
	@Query(nativeQuery=true, value="SELECT * FROM t_brw_business WHERE (:businessType is null or type = :businessName) AND (:businessSubType is null or sub_type = :businessSubType) AND (:state is null or add_state = :state) AND (:city is null or add_city = :city) LIMIT 5;")
	List<BusinessDetails> searchComparableBusiness(@Param ("businessType") String businessType, @Param ("businessSubType") String businessSubType, @Param ("state") String state, @Param ("city") String city);
}
