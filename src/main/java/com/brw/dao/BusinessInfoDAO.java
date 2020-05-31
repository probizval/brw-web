package com.brw.dao;

/**
 * @author sidpatil
 * 2019-20
 */

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.query.Param;

import com.brw.entities.BusinessDetails;
import com.brw.entities.BusinessInfo;

@Repository
public interface BusinessInfoDAO extends PagingAndSortingRepository<BusinessInfo, Integer>{
	
	@Query(nativeQuery=true, value="SELECT biz_id, name_dba, type, sub_type, for_sell_YN, hidden_YN, for_sell_price, market_based_est, image_first, add_street1, add_street2, add_city, add_zip, add_county, add_state, latitude, longitude, vendor_call_YN, franchise_YN "
			+ "FROM t_brw_business "
			+ "WHERE (:businessId is null or biz_id = :businessId);")
	BusinessInfo getBusinessInfo(@Param ("businessId") int businessId);
	
	//ZIP
	//Search where all 3 non-required attributes are part of the input - Type, Name and Address
	@Query(nativeQuery=true, value="SELECT biz_id, name_dba, type, sub_type, for_sell_YN, hidden_YN, for_sell_price, market_based_est, image_first, add_street1, add_street2, add_city, add_zip, add_county, add_state, latitude, longitude, vendor_call_YN, franchise_YN "
			+ "FROM t_brw_business "
			+ "WHERE name_dba LIKE %:businessName% "
			+ "AND type = :businessType "
			+ "AND add_street1 LIKE '%:street1%' "
			+ "AND add_zip = :zip "
			+ "AND franchise_YN = :franchiseYN "
			+ "AND for_sell_YN = :forSellYN "
			+ "ORDER BY for_sell_YN DESC") 
	List<BusinessInfo> searchBusiness_1(@Param ("businessName") String businessName, @Param ("businessType") String businessType, @Param ("street1") String street1, @Param ("zip") int zip, @Param ("franchiseYN") String franchiseYN, @Param ("forSellYN") String forSellYN);
	
	//Search where 2 out of 3 non-required attributes are part of the input - Name and Type
	@Query(nativeQuery=true, value="SELECT biz_id, name_dba, type, sub_type, for_sell_YN, hidden_YN, for_sell_price, market_based_est, image_first, add_street1, add_street2, add_city, add_zip, add_county, add_state, latitude, longitude, vendor_call_YN, franchise_YN "
			+ "FROM t_brw_business "
			+ "WHERE name_dba LIKE %:businessName% "
			+ "AND type = :businessType "
			+ "AND add_zip = :zip "
			+ "AND franchise_YN = :franchiseYN "
			+ "AND for_sell_YN = :forSellYN "
			+ "ORDER BY for_sell_YN DESC")
	List<BusinessInfo> searchBusiness_2(@Param ("businessName") String businessName, @Param ("businessType") String businessType, @Param ("zip") int zip, @Param ("franchiseYN") String franchiseYN, @Param ("forSellYN") String forSellYN);
	
	//Search where 2 out of 3 non-required attributes are part of the input - Name and Address
	@Query(nativeQuery=true, value="SELECT biz_id, name_dba, type, sub_type, for_sell_YN, hidden_YN, for_sell_price, market_based_est, image_first, add_street1, add_street2, add_city, add_zip, add_county, add_state, latitude, longitude, vendor_call_YN, franchise_YN "
			+ "FROM t_brw_business "
			+ "WHERE name_dba LIKE %:businessName% "
			+ "AND add_street1 LIKE '%:street1%' "
			+ "AND add_zip = :zip "
			+ "AND franchise_YN = :franchiseYN "
			+ "AND for_sell_YN = :forSellYN "
			+ "ORDER BY for_sell_YN DESC")
	List<BusinessInfo> searchBusiness_3(@Param ("businessName") String businessName, @Param ("street1") String street1, @Param ("zip") int zip, @Param ("franchiseYN") String franchiseYN, @Param ("forSellYN") String forSellYN);
	
	//Search where 2 out of 3 non-required attributes are part of the input - Type and Address
	@Query(nativeQuery=true, value="SELECT biz_id, name_dba, type, sub_type, for_sell_YN, hidden_YN, for_sell_price, market_based_est, image_first, add_street1, add_street2, add_city, add_zip, add_county, add_state, latitude, longitude, vendor_call_YN, franchise_YN "
			+ "FROM t_brw_business "
			+ "WHERE type = :businessType "
			+ "AND add_street1 LIKE '%:street1%' "
			+ "AND add_zip = :zip "
			+ "AND franchise_YN = :franchiseYN "
			+ "AND for_sell_YN = :forSellYN "
			+ "ORDER BY for_sell_YN DESC")
	List<BusinessInfo> searchBusiness_4(@Param ("businessType") String businessType, @Param ("street1") String street1, @Param ("zip") int zip, @Param ("franchiseYN") String franchiseYN, @Param ("forSellYN") String forSellYN);
	
	//Search where only 1 non-required attributes are part of the input - Name
	@Query(nativeQuery=true, value="SELECT biz_id, name_dba, type, sub_type, for_sell_YN, hidden_YN, for_sell_price, market_based_est, image_first, add_street1, add_street2, add_city, add_zip, add_county, add_state, latitude, longitude, vendor_call_YN, franchise_YN "
			+ "FROM t_brw_business "
			+ "WHERE name_dba LIKE %:businessName% "
			+ "AND add_zip = :zip "
			+ "AND franchise_YN = :franchiseYN "
			+ "AND for_sell_YN = :forSellYN "
			+ "ORDER BY for_sell_YN DESC")
	List<BusinessInfo> searchBusiness_5(@Param ("businessName") String businessName, @Param ("zip") int zip, @Param ("franchiseYN") String franchiseYN, @Param ("forSellYN") String forSellYN);
	
	//Search where only 1 non-required attributes are part of the input - Type
	@Query(nativeQuery=true, value="SELECT biz_id, name_dba, type, sub_type, for_sell_YN, hidden_YN, for_sell_price, market_based_est, image_first, add_street1, add_street2, add_city, add_zip, add_county, add_state, latitude, longitude, vendor_call_YN, franchise_YN "
			+ "FROM t_brw_business "
			+ "WHERE type = :businessType "
			+ "AND add_zip = :zip "
			+ "AND franchise_YN = :franchiseYN "
			+ "AND for_sell_YN = :forSellYN "
			+ "ORDER BY for_sell_YN DESC")
	List<BusinessInfo> searchBusiness_6(@Param ("businessType") String businessType, @Param ("zip") int zip, @Param ("franchiseYN") String franchiseYN, @Param ("forSellYN") String forSellYN);
	
	//Search where non of the non-required attributes are part of the input
	@Query(nativeQuery=true, value="SELECT biz_id, name_dba, type, sub_type, for_sell_YN, hidden_YN, for_sell_price, market_based_est, image_first, add_street1, add_street2, add_city, add_zip, add_county, add_state, latitude, longitude, vendor_call_YN, franchise_YN "
			+ "FROM t_brw_business "
			+ "WHERE add_zip = :zip "
			+ "AND franchise_YN = :franchiseYN "
			+ "AND for_sell_YN = :forSellYN "
			+ "ORDER BY for_sell_YN DESC")
	List<BusinessInfo> searchBusiness_7(@Param ("zip") int zip, @Param ("franchiseYN") String franchiseYN, @Param ("forSellYN") String forSellYN);

	//CITY
	//Search where all 3 non-required attributes are part of the input - Type, Name and Address
	@Query(nativeQuery=true, value="SELECT biz_id, name_dba, type, sub_type, for_sell_YN, hidden_YN, for_sell_price, market_based_est, image_first, add_street1, add_street2, add_city, add_zip, add_county, add_state, latitude, longitude, vendor_call_YN, franchise_YN "
			+ "FROM t_brw_business "
			+ "WHERE name_dba = LIKE %:businessName% "
			+ "AND type = :businessType "
			+ "AND add_street1 LIKE '%:street1%' "
			+ "AND add_city = :city "
			+ "AND add_state = :state "
			+ "AND franchise_YN = :franchiseYN "
			+ "AND for_sell_YN = :forSellYN "
			+ "ORDER BY for_sell_YN DESC")
	List<BusinessInfo> searchBusiness_8(@Param ("businessName") String businessName, @Param ("businessType") String businessType, @Param ("street1") String street1, @Param ("city") String city, @Param ("state") String state, @Param ("franchiseYN") String franchiseYN, @Param ("forSellYN") String forSellYN);
	
	//Search where 2 out of 3 non-required attributes are part of the input - Name and Type
	@Query(nativeQuery=true, value="SELECT biz_id, name_dba, type, sub_type, for_sell_YN, hidden_YN, for_sell_price, market_based_est, image_first, add_street1, add_street2, add_city, add_zip, add_county, add_state, latitude, longitude, vendor_call_YN, franchise_YN "
			+ "FROM t_brw_business "
			+ "WHERE name_dba LIKE %:businessName% "
			+ "AND type = :businessType "
			+ "AND add_city = :city "
			+ "AND add_state = :state "
			+ "AND franchise_YN = :franchiseYN "
			+ "AND for_sell_YN = :forSellYN "
			+ "ORDER BY for_sell_YN DESC")
	List<BusinessInfo> searchBusiness_9(@Param ("businessName") String businessName, @Param ("businessType") String businessType, @Param ("city") String city, @Param ("state") String state, @Param ("franchiseYN") String franchiseYN, @Param ("forSellYN") String forSellYN);
	
	//Search where 2 out of 3 non-required attributes are part of the input - Name and Address
	@Query(nativeQuery=true, value="SELECT biz_id, name_dba, type, sub_type, for_sell_YN, hidden_YN, for_sell_price, market_based_est, image_first, add_street1, add_street2, add_city, add_zip, add_county, add_state, latitude, longitude, vendor_call_YN, franchise_YN "
			+ "FROM t_brw_business "
			+ "WHERE name_dba LIKE %:businessName% "
			+ "AND add_street1 LIKE '%:street1%' "
			+ "AND add_city = :city "
			+ "AND add_state = :state "
			+ "AND franchise_YN = :franchiseYN "
			+ "AND for_sell_YN = :forSellYN "
			+ "ORDER BY for_sell_YN DESC")
	List<BusinessInfo> searchBusiness_10(@Param ("businessName") String businessName, @Param ("street1") String street1, @Param ("city") String city, @Param ("state") String state, @Param ("franchiseYN") String franchiseYN, @Param ("forSellYN") String forSellYN);
	
	//Search where 2 out of 3 non-required attributes are part of the input - Type and Address
	@Query(nativeQuery=true, value="SELECT biz_id, name_dba, type, sub_type, for_sell_YN, hidden_YN, for_sell_price, market_based_est, image_first, add_street1, add_street2, add_city, add_zip, add_county, add_state, latitude, longitude, vendor_call_YN, franchise_YN "
			+ "FROM t_brw_business "
			+ "WHERE type = :businessType "
			+ "AND add_street1 LIKE '%:street1%' "
			+ "AND add_city = :city "
			+ "AND add_state = :state "
			+ "AND franchise_YN = :franchiseYN "
			+ "AND for_sell_YN = :forSellYN "
			+ "ORDER BY for_sell_YN DESC")
	List<BusinessInfo> searchBusiness_11(@Param ("businessType") String businessType, @Param ("street1") String street1, @Param ("city") String city, @Param ("state") String state, @Param ("franchiseYN") String franchiseYN, @Param ("forSellYN") String forSellYN);
	
	//Search where only 1 non-required attributes are part of the input - Name
	@Query(nativeQuery=true, value="SELECT biz_id, name_dba, type, sub_type, for_sell_YN, hidden_YN, for_sell_price, market_based_est, image_first, add_street1, add_street2, add_city, add_zip, add_county, add_state, latitude, longitude, vendor_call_YN, franchise_YN "
			+ "FROM t_brw_business "
			+ "WHERE name_dba LIKE %:businessName% "
			+ "AND add_city = :city "
			+ "AND add_state = :state "
			+ "AND franchise_YN = :franchiseYN "
			+ "AND for_sell_YN = :forSellYN "
			+ "ORDER BY for_sell_YN DESC")
	List<BusinessInfo> searchBusiness_12(@Param ("businessName") String businessName, @Param ("city") String city, @Param ("state") String state, @Param ("franchiseYN") String franchiseYN, @Param ("forSellYN") String forSellYN);
	
	//Search where only 1 non-required attributes are part of the input - Type
	@Query(nativeQuery=true, value="SELECT biz_id, name_dba, type, sub_type, for_sell_YN, hidden_YN, for_sell_price, market_based_est, image_first, add_street1, add_street2, add_city, add_zip, add_county, add_state, latitude, longitude, vendor_call_YN, franchise_YN "
			+ "FROM t_brw_business "
			+ "WHERE type = :businessType "
			+ "AND add_city = :city "
			+ "AND add_state = :state "
			+ "AND franchise_YN = :franchiseYN "
			+ "AND for_sell_YN = :forSellYN "
			+ "ORDER BY for_sell_YN DESC")
	List<BusinessInfo> searchBusiness_13(@Param ("businessType") String businessType, @Param ("city") String city, @Param ("state") String state, @Param ("franchiseYN") String franchiseYN, @Param ("forSellYN") String forSellYN);
	
	//Search where non of the non-required attributes are part of the input
	@Query(nativeQuery=true, value="SELECT biz_id, name_dba, type, sub_type, for_sell_YN, hidden_YN, for_sell_price, market_based_est, image_first, add_street1, add_street2, add_city, add_zip, add_county, add_state, latitude, longitude, vendor_call_YN, franchise_YN "
			+ "FROM t_brw_business "
			+ "WHERE add_city = :city "
			+ "AND add_state = :state "
			+ "AND franchise_YN = :franchiseYN "
			+ "AND for_sell_YN = :forSellYN "
			+ "ORDER BY for_sell_YN DESC")
	List<BusinessInfo> searchBusiness_14(@Param ("city") String city, @Param ("state") String state, @Param ("franchiseYN") String franchiseYN, @Param ("forSellYN") String forSellYN);
	
	//COUNTY
	//Search where all 3 non-required attributes are part of the input - Type, Name and Address
	@Query(nativeQuery=true, value="SELECT biz_id, name_dba, type, sub_type, for_sell_YN, hidden_YN, for_sell_price, market_based_est, image_first, add_street1, add_street2, add_city, add_zip, add_county, add_state, latitude, longitude, vendor_call_YN, franchise_YN "
			+ "FROM t_brw_business "
			+ "WHERE name_dba LIKE %:businessName% "
			+ "AND type = :businessType "
			+ "AND add_street1 LIKE '%:street1%' "
			+ "AND add_county = :county "
			+ "AND add_state = :state "
			+ "AND franchise_YN = :franchiseYN "
			+ "AND for_sell_YN = :forSellYN "
			+ "ORDER BY for_sell_YN DESC")
	List<BusinessInfo> searchBusiness_15(@Param ("businessName") String businessName, @Param ("businessType") String businessType, @Param ("street1") String street1, @Param ("county") String county, @Param ("state") String state, @Param ("franchiseYN") String franchiseYN, @Param ("forSellYN") String forSellYN);
	
	//Search where 2 out of 3 non-required attributes are part of the input - Name and Type
	@Query(nativeQuery=true, value="SELECT biz_id, name_dba, type, sub_type, for_sell_YN, hidden_YN, for_sell_price, market_based_est, image_first, add_street1, add_street2, add_city, add_zip, add_county, add_state, latitude, longitude, vendor_call_YN, franchise_YN "
			+ "FROM t_brw_business "
			+ "WHERE name_dba LIKE %:businessName% "
			+ "AND type = :businessType "
			+ "AND add_county = :county "
			+ "AND add_state = :state "
			+ "AND franchise_YN = :franchiseYN "
			+ "AND for_sell_YN = :forSellYN "
			+ "ORDER BY for_sell_YN DESC")
	List<BusinessInfo> searchBusiness_16(@Param ("businessName") String businessName, @Param ("businessType") String businessType, @Param ("county") String county, @Param ("state") String state, @Param ("franchiseYN") String franchiseYN, @Param ("forSellYN") String forSellYN);

	//Search where 2 out of 3 non-required attributes are part of the input - Name and Address
	@Query(nativeQuery=true, value="SELECT biz_id, name_dba, type, sub_type, for_sell_YN, hidden_YN, for_sell_price, market_based_est, image_first, add_street1, add_street2, add_city, add_zip, add_county, add_state, latitude, longitude, vendor_call_YN, franchise_YN "
			+ "FROM t_brw_business "
			+ "WHERE name_dba LIKE %:businessName% "
			+ "AND add_street1 LIKE '%:street1%' "
			+ "AND add_county = :county "
			+ "AND add_state = :state "
			+ "AND franchise_YN = :franchiseYN "
			+ "AND for_sell_YN = :forSellYN "
			+ "ORDER BY for_sell_YN DESC")
	List<BusinessInfo> searchBusiness_17(@Param ("businessName") String businessName, @Param ("street1") String street1, @Param ("county") String county, @Param ("state") String state, @Param ("franchiseYN") String franchiseYN, @Param ("forSellYN") String forSellYN);
	
	//Search where 2 out of 3 non-required attributes are part of the input - Type and Address
	@Query(nativeQuery=true, value="SELECT biz_id, name_dba, type, sub_type, for_sell_YN, hidden_YN, for_sell_price, market_based_est, image_first, add_street1, add_street2, add_city, add_zip, add_county, add_state, latitude, longitude, vendor_call_YN, franchise_YN "
			+ "FROM t_brw_business "
			+ "WHERE type = :businessType "
			+ "AND add_street1 LIKE '%:street1%' "
			+ "AND add_county = :county "
			+ "AND add_state = :state "
			+ "AND franchise_YN = :franchiseYN "
			+ "AND for_sell_YN = :forSellYN "
			+ "ORDER BY for_sell_YN DESC")
	List<BusinessInfo> searchBusiness_18(@Param ("businessType") String businessType, @Param ("street1") String street1, @Param ("county") String county, @Param ("state") String state, @Param ("franchiseYN") String franchiseYN, @Param ("forSellYN") String forSellYN);
	
	//Search where only 1 non-required attributes are part of the input - Name
	@Query(nativeQuery=true, value="SELECT biz_id, name_dba, type, sub_type, for_sell_YN, hidden_YN, for_sell_price, market_based_est, image_first, add_street1, add_street2, add_city, add_zip, add_county, add_state, latitude, longitude, vendor_call_YN, franchise_YN "
			+ "FROM t_brw_business "
			+ "WHERE name_dba LIKE %:businessName% "
			+ "AND add_county = :county "
			+ "AND add_state = :state "
			+ "AND franchise_YN = :franchiseYN "
			+ "AND for_sell_YN = :forSellYN "
			+ "ORDER BY for_sell_YN DESC")
	List<BusinessInfo> searchBusiness_19(@Param ("businessName") String businessName, @Param ("county") String county, @Param ("state") String state, @Param ("franchiseYN") String franchiseYN, @Param ("forSellYN") String forSellYN);
	
	//Search where only 1 non-required attributes are part of the input - Type
	@Query(nativeQuery=true, value="SELECT biz_id, name_dba, type, sub_type, for_sell_YN, hidden_YN, for_sell_price, market_based_est, image_first, add_street1, add_street2, add_city, add_zip, add_county, add_state, latitude, longitude, vendor_call_YN, franchise_YN "
			+ "FROM t_brw_business "
			+ "WHERE type = :businessType "
			+ "AND add_county = :county "
			+ "AND add_state = :state "
			+ "AND franchise_YN = :franchiseYN "
			+ "AND for_sell_YN = :forSellYN "
			+ "ORDER BY for_sell_YN DESC")
	List<BusinessInfo> searchBusiness_20(@Param ("businessType") String businessType, @Param ("county") String county, @Param ("state") String state, @Param ("franchiseYN") String franchiseYN, @Param ("forSellYN") String forSellYN);
	
	//Search where non of the non-required attributes are part of the input
	@Query(nativeQuery=true, value="SELECT biz_id, name_dba, type, sub_type, for_sell_YN, hidden_YN, for_sell_price, market_based_est, image_first, add_street1, add_street2, add_city, add_zip, add_county, add_state, latitude, longitude, vendor_call_YN, franchise_YN "
			+ "FROM t_brw_business "
			+ "WHERE add_county = :county "
			+ "AND add_state = :state "
			+ "AND franchise_YN = :franchiseYN "
			+ "AND for_sell_YN = :forSellYN "
			+ "ORDER BY for_sell_YN DESC")
	List<BusinessInfo> searchBusiness_21(@Param ("county") String county, @Param ("state") String state, @Param ("franchiseYN") String franchiseYN, @Param ("forSellYN") String forSellYN);
	
	//Search where non of the non-required attributes are part of the input
	@Query(nativeQuery=true, value="SELECT biz_id, name_dba, type, sub_type, for_sell_YN, for_sell_price, market_based_est, image_first, add_street1, add_street2, add_city, add_zip, add_county, add_state, latitude, longitude, vendor_call_YN, franchise_YN, for_Sell_YN, ( 3959 * acos( cos( radians(:latitude) ) * cos( radians( latitude ) ) * cos( radians( longitude ) - radians(:longitude) ) + sin( radians(:latitude) ) * sin( radians( latitude ) ) ) ) AS distance "
			+ "FROM t_brw_business "
			+ "WHERE name_dba LIKE :name "
			+ "AND type = :type "
			+ "AND franchiseYN = :franchiseYN "
			+ "AND forSellYN = :forSellYN "
			+ "HAVING distance < :rangeMile")
	List<BusinessInfo> searchBusiness_22(@Param ("name") String name, @Param ("type") String type, @Param ("franchiseYN") String franchiseYN, @Param ("forSellYN") String forSellYN, @Param ("latitude") double latitude, @Param ("longitude") double longitude, @Param ("rangeMile") int rangeMile);
	
	//Search where non of the non-required attributes are part of the input
	@Query(nativeQuery=true, value="SELECT biz_id, name_dba, type, sub_type, for_sell_YN, for_sell_price, market_based_est, image_first, add_street1, add_street2, add_city, add_zip, add_county, add_state, latitude, longitude, vendor_call_YN, franchise_YN, for_Sell_YN, ( 3959 * acos( cos( radians(:latitude) ) * cos( radians( latitude ) ) * cos( radians( longitude ) - radians(:longitude) ) + sin( radians(:latitude) ) * sin( radians( latitude ) ) ) ) AS distance "
			+ "FROM t_brw_business "
			+ "WHERE name_dba LIKE :name "
			+ "AND franchiseYN = :franchiseYN "
			+ "AND forSellYN = :forSellYN "
			+ "HAVING distance < :rangeMile")
	List<BusinessInfo> searchBusiness_23(@Param ("name") String name, @Param ("franchiseYN") String franchiseYN, @Param ("forSellYN") String forSellYN, @Param ("latitude") double latitude, @Param ("longitude") double longitude, @Param ("rangeMile") int rangeMile);
	
	//Search where non of the non-required attributes are part of the input
	@Query(nativeQuery=true, value="SELECT biz_id, name_dba, type, sub_type, for_sell_YN, for_sell_price, market_based_est, image_first, add_street1, add_street2, add_city, add_zip, add_county, add_state, latitude, longitude, vendor_call_YN, franchise_YN, for_Sell_YN, ( 3959 * acos( cos( radians(:latitude) ) * cos( radians( latitude ) ) * cos( radians( longitude ) - radians(:longitude) ) + sin( radians(:latitude) ) * sin( radians( latitude ) ) ) ) AS distance "
			+ "FROM t_brw_business "
			+ "WHERE type = :type "
			+ "AND franchiseYN = :franchiseYN "
			+ "AND forSellYN = :forSellYN "
			+ "HAVING distance < :rangeMile")
	List<BusinessInfo> searchBusiness_24(@Param ("type") String type, @Param ("franchiseYN") String franchiseYN, @Param ("forSellYN") String forSellYN, @Param ("latitude") double latitude, @Param ("longitude") double longitude, @Param ("rangeMile") int rangeMile);

	///////////////////////////////////////
	
	//BELOW IS JUST REPEAT OF ABOVE - WITH ISFORSELL = N
	
	//ZIP
	//Search where all 3 non-required attributes are part of the input - Type, Name and Address
	@Query(nativeQuery=true, value="SELECT biz_id, name_dba, type, sub_type, for_sell_YN, hidden_YN, for_sell_price, market_based_est, image_first, add_street1, add_street2, add_city, add_zip, add_county, add_state, latitude, longitude, vendor_call_YN, franchise_YN "
			+ "FROM t_brw_business "
			+ "WHERE name_dba LIKE %:businessName% "
			+ "AND type = :businessType "
			+ "AND add_street1 LIKE '%:street1%' "
			+ "AND add_zip = :zip "
			+ "ORDER BY for_sell_YN DESC") 
	List<BusinessInfo> searchBusiness_1_FSN(@Param ("businessName") String businessName, @Param ("businessType") String businessType, @Param ("street1") String street1, @Param ("zip") int zip);
	
	//Search where 2 out of 3 non-required attributes are part of the input - Name and Type
	@Query(nativeQuery=true, value="SELECT biz_id, name_dba, type, sub_type, for_sell_YN, hidden_YN, for_sell_price, market_based_est, image_first, add_street1, add_street2, add_city, add_zip, add_county, add_state, latitude, longitude, vendor_call_YN, franchise_YN "
			+ "FROM t_brw_business "
			+ "WHERE name_dba LIKE %:businessName% "
			+ "AND type = :businessType "
			+ "AND add_zip = :zip "
			+ "ORDER BY for_sell_YN DESC")
	List<BusinessInfo> searchBusiness_2_FSN(@Param ("businessName") String businessName, @Param ("businessType") String businessType, @Param ("zip") int zip);
	
	//Search where 2 out of 3 non-required attributes are part of the input - Name and Address
	@Query(nativeQuery=true, value="SELECT biz_id, name_dba, type, sub_type, for_sell_YN, hidden_YN, for_sell_price, market_based_est, image_first, add_street1, add_street2, add_city, add_zip, add_county, add_state, latitude, longitude, vendor_call_YN, franchise_YN "
			+ "FROM t_brw_business "
			+ "WHERE name_dba LIKE %:businessName% "
			+ "AND add_street1 LIKE '%:street1%' "
			+ "AND add_zip = :zip "
			+ "ORDER BY for_sell_YN DESC")
	List<BusinessInfo> searchBusiness_3_FSN(@Param ("businessName") String businessName, @Param ("street1") String street1, @Param ("zip") int zip);
	
	//Search where 2 out of 3 non-required attributes are part of the input - Type and Address
	@Query(nativeQuery=true, value="SELECT biz_id, name_dba, type, sub_type, for_sell_YN, hidden_YN, for_sell_price, market_based_est, image_first, add_street1, add_street2, add_city, add_zip, add_county, add_state, latitude, longitude, vendor_call_YN, franchise_YN "
			+ "FROM t_brw_business "
			+ "WHERE type = :businessType "
			+ "AND add_street1 LIKE '%:street1%' "
			+ "AND add_zip = :zip "
			+ "ORDER BY for_sell_YN DESC")
	List<BusinessInfo> searchBusiness_4_FSN(@Param ("businessType") String businessType, @Param ("street1") String street1, @Param ("zip") int zip);
	
	//Search where only 1 non-required attributes are part of the input - Name
	@Query(nativeQuery=true, value="SELECT biz_id, name_dba, type, sub_type, for_sell_YN, hidden_YN, for_sell_price, market_based_est, image_first, add_street1, add_street2, add_city, add_zip, add_county, add_state, latitude, longitude, vendor_call_YN, franchise_YN "
			+ "FROM t_brw_business "
			+ "WHERE name_dba LIKE %:businessName% "
			+ "AND add_zip = :zip "
			+ "ORDER BY for_sell_YN DESC")
	List<BusinessInfo> searchBusiness_5_FSN(@Param ("businessName") String businessName, @Param ("zip") int zip);
	
	//Search where only 1 non-required attributes are part of the input - Type
	@Query(nativeQuery=true, value="SELECT biz_id, name_dba, type, sub_type, for_sell_YN, hidden_YN, for_sell_price, market_based_est, image_first, add_street1, add_street2, add_city, add_zip, add_county, add_state, latitude, longitude, vendor_call_YN, franchise_YN "
			+ "FROM t_brw_business "
			+ "WHERE type = :businessType "
			+ "AND add_zip = :zip "
			+ "ORDER BY for_sell_YN DESC")
	List<BusinessInfo> searchBusiness_6_FSN(@Param ("businessType") String businessType, @Param ("zip") int zip);
	
	//Search where non of the non-required attributes are part of the input
	@Query(nativeQuery=true, value="SELECT biz_id, name_dba, type, sub_type, for_sell_YN, hidden_YN, for_sell_price, market_based_est, image_first, add_street1, add_street2, add_city, add_zip, add_county, add_state, latitude, longitude, vendor_call_YN, franchise_YN "
			+ "FROM t_brw_business "
			+ "WHERE add_zip = :zip "
			+ "ORDER BY for_sell_YN DESC")
	List<BusinessInfo> searchBusiness_7_FSN(@Param ("zip") int zip);

	//CITY
	//Search where all 3 non-required attributes are part of the input - Type, Name and Address
	@Query(nativeQuery=true, value="SELECT biz_id, name_dba, type, sub_type, for_sell_YN, hidden_YN, for_sell_price, market_based_est, image_first, add_street1, add_street2, add_city, add_zip, add_county, add_state, latitude, longitude, vendor_call_YN, franchise_YN "
			+ "FROM t_brw_business "
			+ "WHERE name_dba = LIKE %:businessName% "
			+ "AND type = :businessType "
			+ "AND add_street1 LIKE '%:street1%' "
			+ "AND add_city = :city "
			+ "AND add_state = :state "
			+ "ORDER BY for_sell_YN DESC")
	List<BusinessInfo> searchBusiness_8_FSN(@Param ("businessName") String businessName, @Param ("businessType") String businessType, @Param ("street1") String street1, @Param ("city") String city, @Param ("state") String state);
	
	//Search where 2 out of 3 non-required attributes are part of the input - Name and Type
	@Query(nativeQuery=true, value="SELECT biz_id, name_dba, type, sub_type, for_sell_YN, hidden_YN, for_sell_price, market_based_est, image_first, add_street1, add_street2, add_city, add_zip, add_county, add_state, latitude, longitude, vendor_call_YN, franchise_YN "
			+ "FROM t_brw_business "
			+ "WHERE name_dba LIKE %:businessName% "
			+ "AND type = :businessType "
			+ "AND add_city = :city "
			+ "AND add_state = :state "
			+ "ORDER BY for_sell_YN DESC")
	List<BusinessInfo> searchBusiness_9_FSN(@Param ("businessName") String businessName, @Param ("businessType") String businessType, @Param ("city") String city, @Param ("state") String state);
	
	//Search where 2 out of 3 non-required attributes are part of the input - Name and Address
	@Query(nativeQuery=true, value="SELECT biz_id, name_dba, type, sub_type, for_sell_YN, hidden_YN, for_sell_price, market_based_est, image_first, add_street1, add_street2, add_city, add_zip, add_county, add_state, latitude, longitude, vendor_call_YN, franchise_YN "
			+ "FROM t_brw_business "
			+ "WHERE name_dba LIKE %:businessName% "
			+ "AND add_street1 LIKE '%:street1%' "
			+ "AND add_city = :city "
			+ "AND add_state = :state "
			+ "ORDER BY for_sell_YN DESC")
	List<BusinessInfo> searchBusiness_10_FSN(@Param ("businessName") String businessName, @Param ("street1") String street1, @Param ("city") String city, @Param ("state") String state);
	
	//Search where 2 out of 3 non-required attributes are part of the input - Type and Address
	@Query(nativeQuery=true, value="SELECT biz_id, name_dba, type, sub_type, for_sell_YN, hidden_YN, for_sell_price, market_based_est, image_first, add_street1, add_street2, add_city, add_zip, add_county, add_state, latitude, longitude, vendor_call_YN, franchise_YN "
			+ "FROM t_brw_business "
			+ "WHERE type = :businessType "
			+ "AND add_street1 LIKE '%:street1%' "
			+ "AND add_city = :city "
			+ "AND add_state = :state "
			+ "ORDER BY for_sell_YN DESC")
	List<BusinessInfo> searchBusiness_11_FSN(@Param ("businessType") String businessType, @Param ("street1") String street1, @Param ("city") String city, @Param ("state") String state);
	
	//Search where only 1 non-required attributes are part of the input - Name
	@Query(nativeQuery=true, value="SELECT biz_id, name_dba, type, sub_type, for_sell_YN, hidden_YN, for_sell_price, market_based_est, image_first, add_street1, add_street2, add_city, add_zip, add_county, add_state, latitude, longitude, vendor_call_YN, franchise_YN "
			+ "FROM t_brw_business "
			+ "WHERE name_dba LIKE %:businessName% "
			+ "AND add_city = :city "
			+ "AND add_state = :state "
			+ "ORDER BY for_sell_YN DESC")
	List<BusinessInfo> searchBusiness_12_FSN(@Param ("businessName") String businessName, @Param ("city") String city, @Param ("state") String state);
	
	//Search where only 1 non-required attributes are part of the input - Type
	@Query(nativeQuery=true, value="SELECT biz_id, name_dba, type, sub_type, for_sell_YN, hidden_YN, for_sell_price, market_based_est, image_first, add_street1, add_street2, add_city, add_zip, add_county, add_state, latitude, longitude, vendor_call_YN, franchise_YN "
			+ "FROM t_brw_business "
			+ "WHERE type = :businessType "
			+ "AND add_city = :city "
			+ "AND add_state = :state "
			+ "ORDER BY for_sell_YN DESC")
	List<BusinessInfo> searchBusiness_13_FSN(@Param ("businessType") String businessType, @Param ("city") String city, @Param ("state") String state);
	
	//Search where non of the non-required attributes are part of the input
	@Query(nativeQuery=true, value="SELECT biz_id, name_dba, type, sub_type, for_sell_YN, hidden_YN, for_sell_price, market_based_est, image_first, add_street1, add_street2, add_city, add_zip, add_county, add_state, latitude, longitude, vendor_call_YN, franchise_YN "
			+ "FROM t_brw_business "
			+ "WHERE add_city = :city "
			+ "AND add_state = :state "
			+ "ORDER BY for_sell_YN DESC")
	List<BusinessInfo> searchBusiness_14_FSN(@Param ("city") String city, @Param ("state") String state);
	
	//COUNTY
	//Search where all 3 non-required attributes are part of the input - Type, Name and Address
	@Query(nativeQuery=true, value="SELECT biz_id, name_dba, type, sub_type, for_sell_YN, hidden_YN, for_sell_price, market_based_est, image_first, add_street1, add_street2, add_city, add_zip, add_county, add_state, latitude, longitude, vendor_call_YN, franchise_YN "
			+ "FROM t_brw_business "
			+ "WHERE name_dba LIKE %:businessName% "
			+ "AND type = :businessType "
			+ "AND add_street1 LIKE '%:street1%' "
			+ "AND add_county = :county "
			+ "AND add_state = :state "
			+ "ORDER BY for_sell_YN DESC")
	List<BusinessInfo> searchBusiness_15_FSN(@Param ("businessName") String businessName, @Param ("businessType") String businessType, @Param ("street1") String street1, @Param ("county") String county, @Param ("state") String state);
	
	//Search where 2 out of 3 non-required attributes are part of the input - Name and Type
	@Query(nativeQuery=true, value="SELECT biz_id, name_dba, type, sub_type, for_sell_YN, hidden_YN, for_sell_price, market_based_est, image_first, add_street1, add_street2, add_city, add_zip, add_county, add_state, latitude, longitude, vendor_call_YN, franchise_YN "
			+ "FROM t_brw_business "
			+ "WHERE name_dba LIKE %:businessName% "
			+ "AND type = :businessType "
			+ "AND add_county = :county "
			+ "AND add_state = :state "
			+ "ORDER BY for_sell_YN DESC")
	List<BusinessInfo> searchBusiness_16_FSN(@Param ("businessName") String businessName, @Param ("businessType") String businessType, @Param ("county") String county, @Param ("state") String state);

	//Search where 2 out of 3 non-required attributes are part of the input - Name and Address
	@Query(nativeQuery=true, value="SELECT biz_id, name_dba, type, sub_type, for_sell_YN, hidden_YN, for_sell_price, market_based_est, image_first, add_street1, add_street2, add_city, add_zip, add_county, add_state, latitude, longitude, vendor_call_YN, franchise_YN "
			+ "FROM t_brw_business "
			+ "WHERE name_dba LIKE %:businessName% "
			+ "AND add_street1 LIKE '%:street1%' "
			+ "AND add_county = :county "
			+ "AND add_state = :state "
			+ "ORDER BY for_sell_YN DESC")
	List<BusinessInfo> searchBusiness_17_FSN(@Param ("businessName") String businessName, @Param ("street1") String street1, @Param ("county") String county, @Param ("state") String state);
	
	//Search where 2 out of 3 non-required attributes are part of the input - Type and Address
	@Query(nativeQuery=true, value="SELECT biz_id, name_dba, type, sub_type, for_sell_YN, hidden_YN, for_sell_price, market_based_est, image_first, add_street1, add_street2, add_city, add_zip, add_county, add_state, latitude, longitude, vendor_call_YN, franchise_YN "
			+ "FROM t_brw_business "
			+ "WHERE type = :businessType "
			+ "AND add_street1 LIKE '%:street1%' "
			+ "AND add_county = :county "
			+ "AND add_state = :state "
			+ "ORDER BY for_sell_YN DESC")
	List<BusinessInfo> searchBusiness_18_FSN(@Param ("businessType") String businessType, @Param ("street1") String street1, @Param ("county") String county, @Param ("state") String state);
	
	//Search where only 1 non-required attributes are part of the input - Name
	@Query(nativeQuery=true, value="SELECT biz_id, name_dba, type, sub_type, for_sell_YN, hidden_YN, for_sell_price, market_based_est, image_first, add_street1, add_street2, add_city, add_zip, add_county, add_state, latitude, longitude, vendor_call_YN, franchise_YN "
			+ "FROM t_brw_business "
			+ "WHERE name_dba LIKE %:businessName% "
			+ "AND add_county = :county "
			+ "AND add_state = :state "
			+ "ORDER BY for_sell_YN DESC")
	List<BusinessInfo> searchBusiness_19_FSN(@Param ("businessName") String businessName, @Param ("county") String county, @Param ("state") String state);
	
	//Search where only 1 non-required attributes are part of the input - Type
	@Query(nativeQuery=true, value="SELECT biz_id, name_dba, type, sub_type, for_sell_YN, hidden_YN, for_sell_price, market_based_est, image_first, add_street1, add_street2, add_city, add_zip, add_county, add_state, latitude, longitude, vendor_call_YN, franchise_YN "
			+ "FROM t_brw_business "
			+ "WHERE type = :businessType "
			+ "AND add_county = :county "
			+ "AND add_state = :state "
			+ "ORDER BY for_sell_YN DESC")
	List<BusinessInfo> searchBusiness_20_FSN(@Param ("businessType") String businessType, @Param ("county") String county, @Param ("state") String state);
	
	//Search where non of the non-required attributes are part of the input
	@Query(nativeQuery=true, value="SELECT biz_id, name_dba, type, sub_type, for_sell_YN, hidden_YN, for_sell_price, market_based_est, image_first, add_street1, add_street2, add_city, add_zip, add_county, add_state, latitude, longitude, vendor_call_YN, franchise_YN "
			+ "FROM t_brw_business "
			+ "WHERE add_county = :county "
			+ "AND add_state = :state "
			+ "ORDER BY for_sell_YN DESC")
	List<BusinessInfo> searchBusiness_21_FSN(@Param ("county") String county, @Param ("state") String state);
	
	//Search where non of the non-required attributes are part of the input
	@Query(nativeQuery=true, value="SELECT biz_id, name_dba, type, sub_type, for_sell_YN, for_sell_price, market_based_est, image_first, add_street1, add_street2, add_city, add_zip, add_county, add_state, latitude, longitude, vendor_call_YN, franchise_YN, for_Sell_YN, ( 3959 * acos( cos( radians(:latitude) ) * cos( radians( latitude ) ) * cos( radians( longitude ) - radians(:longitude) ) + sin( radians(:latitude) ) * sin( radians( latitude ) ) ) ) AS distance "
			+ "FROM t_brw_business "
			+ "WHERE name_dba LIKE :name "
			+ "AND type = :type "
			+ "HAVING distance < :rangeMile "
			+ "ORDER BY for_sell_YN DESC")
	List<BusinessInfo> searchBusiness_22_FSN(@Param ("name") String name, @Param ("type") String type, @Param ("latitude") double latitude, @Param ("longitude") double longitude, @Param ("rangeMile") int rangeMile);
	
	//Search where non of the non-required attributes are part of the input
	@Query(nativeQuery=true, value="SELECT biz_id, name_dba, type, sub_type, for_sell_YN, for_sell_price, market_based_est, image_first, add_street1, add_street2, add_city, add_zip, add_county, add_state, latitude, longitude, vendor_call_YN, franchise_YN, for_Sell_YN, ( 3959 * acos( cos( radians(:latitude) ) * cos( radians( latitude ) ) * cos( radians( longitude ) - radians(:longitude) ) + sin( radians(:latitude) ) * sin( radians( latitude ) ) ) ) AS distance "
			+ "FROM t_brw_business "
			+ "WHERE name_dba LIKE :name "
			+ "HAVING distance < :rangeMile "
			+ "ORDER BY for_sell_YN DESC")
	List<BusinessInfo> searchBusiness_23_FSN(@Param ("name") String name, @Param ("latitude") double latitude, @Param ("longitude") double longitude, @Param ("rangeMile") int rangeMile);
	
	//Search where non of the non-required attributes are part of the input
	@Query(nativeQuery=true, value="SELECT biz_id, name_dba, type, sub_type, for_sell_YN, for_sell_price, market_based_est, image_first, add_street1, add_street2, add_city, add_zip, add_county, add_state, latitude, longitude, vendor_call_YN, franchise_YN, for_Sell_YN, ( 3959 * acos( cos( radians(:latitude) ) * cos( radians( latitude ) ) * cos( radians( longitude ) - radians(:longitude) ) + sin( radians(:latitude) ) * sin( radians( latitude ) ) ) ) AS distance "
			+ "FROM t_brw_business "
			+ "WHERE type = :type "
			+ "HAVING distance < :rangeMile "
			+ "ORDER BY for_sell_YN DESC")
	List<BusinessInfo> searchBusiness_24_FSN(@Param ("type") String type, @Param ("latitude") double latitude, @Param ("longitude") double longitude, @Param ("rangeMile") int rangeMile);
///////////////////////////////////////
}