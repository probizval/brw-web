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

import com.brw.entities.BusinessInfo;

@Repository
public interface BusinessInfoDAO extends PagingAndSortingRepository<BusinessInfo, Integer>{
	
	//ZIP
	//Search where all 3 non-required attributes are part of the input - Type, Name and Address
	@Query(nativeQuery=true, value="SELECT biz_id, name_dba, type, sub_type, for_sell_YN, for_sell_price, image_first, add_street1, add_street2, add_city, add_zip, add_county, add_state, latitude, longitude, vendor_call_YN "
			+ "FROM t_brw_business "
			+ "WHERE name_dba = :businessName "
			+ "AND type = :businessType "
			+ "AND add_street1 LIKE '%:street1%' "
			+ "AND add_street2 LIKE '%:street2%' "
			+ "AND add_zip = :zip")
	List<BusinessInfo> searchBusiness_1(@Param ("businessName") String businessName, @Param ("businessType") String businessType, @Param ("street1") String street1, @Param ("street2") String street2, @Param ("zip") int zip);
	
	//Search where 2 out of 3 non-required attributes are part of the input - Name and Type
	@Query(nativeQuery=true, value="SELECT biz_id, name_dba, type, sub_type, for_sell_YN, for_sell_price, image_first, add_street1, add_street2, add_city, add_zip, add_county, add_state, latitude, longitude, vendor_call_YN "
			+ "FROM t_brw_business "
			+ "WHERE name_dba = :businessName "
			+ "AND type = :businessType "
			+ "AND add_zip = :zip")
	List<BusinessInfo> searchBusiness_2(@Param ("businessName") String businessName, @Param ("businessType") String businessType, @Param ("zip") int zip);
	
	//Search where 2 out of 3 non-required attributes are part of the input - Name and Address
	@Query(nativeQuery=true, value="SELECT biz_id, name_dba, type, sub_type, for_sell_YN, for_sell_price, image_first, add_street1, add_street2, add_city, add_zip, add_county, add_state, latitude, longitude, vendor_call_YN "
			+ "FROM t_brw_business "
			+ "WHERE name_dba = :businessName "
			+ "AND add_street1 LIKE '%:street1%' "
			+ "AND add_street2 LIKE '%:street2%' "
			+ "AND add_zip = :zip")
	List<BusinessInfo> searchBusiness_3(@Param ("businessName") String businessName, @Param ("street1") String street1, @Param ("street2") String street2, @Param ("zip") int zip);
	
	//Search where 2 out of 3 non-required attributes are part of the input - Type and Address
	@Query(nativeQuery=true, value="SELECT biz_id, name_dba, type, sub_type, for_sell_YN, for_sell_price, image_first, add_street1, add_street2, add_city, add_zip, add_county, add_state, latitude, longitude, vendor_call_YN "
			+ "FROM t_brw_business "
			+ "WHERE type = :businessType "
			+ "AND add_street1 LIKE '%:street1%' "
			+ "AND add_street2 LIKE '%:street2%' "
			+ "AND add_zip = :zip")
	List<BusinessInfo> searchBusiness_4(@Param ("businessType") String businessType, @Param ("street1") String street1, @Param ("street2") String street2, @Param ("zip") int zip);
	
	//Search where only 1 non-required attributes are part of the input - Name
	@Query(nativeQuery=true, value="SELECT biz_id, name_dba, type, sub_type, for_sell_YN, for_sell_price, image_first, add_street1, add_street2, add_city, add_zip, add_county, add_state, latitude, longitude, vendor_call_YN "
			+ "FROM t_brw_business "
			+ "WHERE name_dba = :businessName "
			+ "AND add_zip = :zip")
	List<BusinessInfo> searchBusiness_5(@Param ("businessName") String businessName, @Param ("zip") int zip);
	
	//Search where only 1 non-required attributes are part of the input - Type
	@Query(nativeQuery=true, value="SELECT biz_id, name_dba, type, sub_type, for_sell_YN, for_sell_price, image_first, add_street1, add_street2, add_city, add_zip, add_county, add_state, latitude, longitude, vendor_call_YN "
			+ "FROM t_brw_business "
			+ "WHERE type = :businessType "
			+ "AND add_zip = :zip")
	List<BusinessInfo> searchBusiness_6(@Param ("businessType") String businessType, @Param ("zip") int zip);
	
	//Search where non of the non-required attributes are part of the input
	@Query(nativeQuery=true, value="SELECT biz_id, name_dba, type, sub_type, for_sell_YN, for_sell_price, image_first, add_street1, add_street2, add_city, add_zip, add_county, add_state, latitude, longitude, vendor_call_YN "
			+ "FROM t_brw_business "
			+ "WHERE add_zip = :zip")
	List<BusinessInfo> searchBusiness_7(@Param ("zip") int zip);

	//CITY
	//Search where all 3 non-required attributes are part of the input - Type, Name and Address
	@Query(nativeQuery=true, value="SELECT biz_id, name_dba, type, sub_type, for_sell_YN, for_sell_price, image_first, add_street1, add_street2, add_city, add_zip, add_county, add_state, latitude, longitude, vendor_call_YN "
			+ "FROM t_brw_business "
			+ "WHERE name_dba = :businessName "
			+ "AND type = :businessType "
			+ "AND add_street1 LIKE '%:street1%' "
			+ "AND add_street2 LIKE '%:street2%' "
			+ "AND add_city = :city "
			+ "AND add_state = :state")
	List<BusinessInfo> searchBusiness_8(@Param ("businessName") String businessName, @Param ("businessType") String businessType, @Param ("street1") String street1, @Param ("street2") String street2, @Param ("city") String city, @Param ("state") String state);
	
	//Search where 2 out of 3 non-required attributes are part of the input - Name and Type
	@Query(nativeQuery=true, value="SELECT biz_id, name_dba, type, sub_type, for_sell_YN, for_sell_price, image_first, add_street1, add_street2, add_city, add_zip, add_county, add_state, latitude, longitude, vendor_call_YN "
			+ "FROM t_brw_business "
			+ "WHERE name_dba = :businessName "
			+ "AND type = :businessType "
			+ "AND add_city = :city "
			+ "AND add_state = :state")
	List<BusinessInfo> searchBusiness_9(@Param ("businessName") String businessName, @Param ("businessType") String businessType, @Param ("city") String city, @Param ("state") String state);
	
	//Search where 2 out of 3 non-required attributes are part of the input - Name and Address
	@Query(nativeQuery=true, value="SELECT biz_id, name_dba, type, sub_type, for_sell_YN, for_sell_price, image_first, add_street1, add_street2, add_city, add_zip, add_county, add_state, latitude, longitude, vendor_call_YN "
			+ "FROM t_brw_business "
			+ "WHERE name_dba = :businessName "
			+ "AND add_street1 LIKE '%:street1%' "
			+ "AND add_street2 LIKE '%:street2%' "
			+ "AND add_city = :city "
			+ "AND add_state = :state")
	List<BusinessInfo> searchBusiness_10(@Param ("businessName") String businessName, @Param ("street1") String street1, @Param ("street2") String street2, @Param ("city") String city, @Param ("state") String state);
	
	//Search where 2 out of 3 non-required attributes are part of the input - Type and Address
	@Query(nativeQuery=true, value="SELECT biz_id, name_dba, type, sub_type, for_sell_YN, for_sell_price, image_first, add_street1, add_street2, add_city, add_zip, add_county, add_state, latitude, longitude, vendor_call_YN "
			+ "FROM t_brw_business "
			+ "WHERE type = :businessType "
			+ "AND add_street1 LIKE '%:street1%' "
			+ "AND add_street2 LIKE '%:street2%' "
			+ "AND add_city = :city "
			+ "AND add_state = :state")
	List<BusinessInfo> searchBusiness_11(@Param ("businessType") String businessType, @Param ("street1") String street1, @Param ("street2") String street2, @Param ("city") String city, @Param ("state") String state);
	
	//Search where only 1 non-required attributes are part of the input - Name
	@Query(nativeQuery=true, value="SELECT biz_id, name_dba, type, sub_type, for_sell_YN, for_sell_price, image_first, add_street1, add_street2, add_city, add_zip, add_county, add_state, latitude, longitude, vendor_call_YN "
			+ "FROM t_brw_business "
			+ "WHERE name_dba = :businessName "
			+ "AND add_city = :city "
			+ "AND add_state = :state")
	List<BusinessInfo> searchBusiness_12(@Param ("businessName") String businessName, @Param ("city") String city, @Param ("state") String state);
	
	//Search where only 1 non-required attributes are part of the input - Type
	@Query(nativeQuery=true, value="SELECT biz_id, name_dba, type, sub_type, for_sell_YN, for_sell_price, image_first, add_street1, add_street2, add_city, add_zip, add_county, add_state, latitude, longitude, vendor_call_YN "
			+ "FROM t_brw_business "
			+ "WHERE type = :businessType "
			+ "AND add_city = :city "
			+ "AND add_state = :state")
	List<BusinessInfo> searchBusiness_13(@Param ("businessType") String businessType, @Param ("city") String city, @Param ("state") String state);
	
	//Search where non of the non-required attributes are part of the input
	@Query(nativeQuery=true, value="SELECT biz_id, name_dba, type, sub_type, for_sell_YN, for_sell_price, image_first, add_street1, add_street2, add_city, add_zip, add_county, add_state, latitude, longitude, vendor_call_YN "
			+ "FROM t_brw_business "
			+ "WHERE add_city = :city "
			+ "AND add_state = :state")
	List<BusinessInfo> searchBusiness_14(@Param ("city") String city, @Param ("state") String state);
	
	//COUNTY
	//Search where all 3 non-required attributes are part of the input - Type, Name and Address
	@Query(nativeQuery=true, value="SELECT biz_id, name_dba, type, sub_type, for_sell_YN, for_sell_price, image_first, add_street1, add_street2, add_city, add_zip, add_county, add_state, latitude, longitude, vendor_call_YN "
			+ "FROM t_brw_business "
			+ "WHERE name_dba = :businessName "
			+ "AND type = :businessType "
			+ "AND add_street1 LIKE '%:street1%' "
			+ "AND add_street2 LIKE '%:street2%' "
			+ "AND add_county = :county "
			+ "AND add_state = :state")
	List<BusinessInfo> searchBusiness_15(@Param ("businessName") String businessName, @Param ("businessType") String businessType, @Param ("street1") String street1, @Param ("street2") String street2, @Param ("county") String county, @Param ("state") String state);
	
	//Search where 2 out of 3 non-required attributes are part of the input - Name and Type
	@Query(nativeQuery=true, value="SELECT biz_id, name_dba, type, sub_type, for_sell_YN, for_sell_price, image_first, add_street1, add_street2, add_city, add_zip, add_county, add_state, latitude, longitude, vendor_call_YN "
			+ "FROM t_brw_business "
			+ "WHERE name_dba = :businessName "
			+ "AND type = :businessType "
			+ "AND add_county = :county "
			+ "AND add_state = :state")
	List<BusinessInfo> searchBusiness_16(@Param ("businessName") String businessName, @Param ("businessType") String businessType, @Param ("county") String county, @Param ("state") String state);

	//Search where 2 out of 3 non-required attributes are part of the input - Name and Address
	@Query(nativeQuery=true, value="SELECT biz_id, name_dba, type, sub_type, for_sell_YN, for_sell_price, image_first, add_street1, add_street2, add_city, add_zip, add_county, add_state, latitude, longitude, vendor_call_YN "
			+ "FROM t_brw_business "
			+ "WHERE name_dba = :businessName "
			+ "AND add_street1 LIKE '%:street1%' "
			+ "AND add_street2 LIKE '%:street2%' "
			+ "AND add_county = :county "
			+ "AND add_state = :state")
	List<BusinessInfo> searchBusiness_17(@Param ("businessName") String businessName, @Param ("street1") String street1, @Param ("street2") String street2, @Param ("county") String county, @Param ("state") String state);
	
	//Search where 2 out of 3 non-required attributes are part of the input - Type and Address
	@Query(nativeQuery=true, value="SELECT biz_id, name_dba, type, sub_type, for_sell_YN, for_sell_price, image_first, add_street1, add_street2, add_city, add_zip, add_county, add_state, latitude, longitude, vendor_call_YN "
			+ "FROM t_brw_business "
			+ "WHERE type = :businessType "
			+ "AND add_street1 LIKE '%:street1%' "
			+ "AND add_street2 LIKE '%:street2%' "
			+ "AND add_county = :county "
			+ "AND add_state = :state")
	List<BusinessInfo> searchBusiness_18(@Param ("businessType") String businessType, @Param ("street1") String street1, @Param ("street2") String street2, @Param ("county") String county, @Param ("state") String state);
	
	//Search where only 1 non-required attributes are part of the input - Name
	@Query(nativeQuery=true, value="SELECT biz_id, name_dba, type, sub_type, for_sell_YN, for_sell_price, image_first, add_street1, add_street2, add_city, add_zip, add_county, add_state, latitude, longitude, vendor_call_YN "
			+ "FROM t_brw_business "
			+ "WHERE name_dba = :businessName "
			+ "AND add_county = :county "
			+ "AND add_state = :state")
	List<BusinessInfo> searchBusiness_19(@Param ("businessName") String businessName, @Param ("county") String county, @Param ("state") String state);
	
	//Search where only 1 non-required attributes are part of the input - Type
	@Query(nativeQuery=true, value="SELECT biz_id, name_dba, type, sub_type, for_sell_YN, for_sell_price, image_first, add_street1, add_street2, add_city, add_zip, add_county, add_state, latitude, longitude, vendor_call_YN "
			+ "FROM t_brw_business "
			+ "WHERE type = :businessType "
			+ "AND add_county = :county "
			+ "AND add_state = :state")
	List<BusinessInfo> searchBusiness_20(@Param ("businessType") String businessType, @Param ("county") String county, @Param ("state") String state);
	
	//Search where non of the non-required attributes are part of the input
	@Query(nativeQuery=true, value="SELECT biz_id, name_dba, type, sub_type, for_sell_YN, for_sell_price, image_first, add_street1, add_street2, add_city, add_zip, add_county, add_state, latitude, longitude, vendor_call_YN "
			+ "FROM t_brw_business "
			+ "WHERE add_county = :county "
			+ "AND add_state = :state")
	List<BusinessInfo> searchBusiness_21(@Param ("county") String county, @Param ("state") String state);	
}