# BRW Spring Boot Web Application

You Need:

1. Java 1.8
2. Maven 3.6
3. Tomcat v9.0

PB Bearer Token: 
{
    "access_token": "HDYnCWRnjn8qxTA81y3iNAikCeCJ",
    "tokenType": "BearerToken",
    "issuedAt": "1575502638056",
    "expiresIn": "35999",
    "clientID": "fUMoAOl6wPbiLfLQMtygfCiwX007lVGY",
    "org": "pitneybowes"
}

Open your terminal then type this : `mvn clean spring-boot:run`

Open your browser then type this : `http://localhost:8080/`

Stripe BackUp Code Key - knuk-glcz-utcs-bgxp-scuc

BRW MongoDB Credentials
user: “app_mongo”
pwd: “appUser123”
AuthDB — brwdev
IP — 54.198.119.109


Create token
https://mycart.auth0.com/oauth/token

POST
{
  "grant_type":"password",
  "username": "user@test.com",
  "password": "123123",
  "audience": "https://mycart.auth0.com/api/v2/",
  "client_id": "DNRjecYAbrlr0gt5iZj1AE0y5ApblcnV",
  "client_secret": "SoCWPLAkcJjwEqOSCjaPNyVjjDvr4JJ4PoNJ__vuCb4wk5i4gP7mwH2JwvulUURU"
}


Property List based on latitude and longitude
http://localhost:8080/api/v1/propertyList

//zipCode is optional, we can add more optional attributes

POST
{
    "latitude": 37.57613630000001,
    "longitude": -122.03861259999996,
    "zipCode": 94555
}


To get details:
GET
http://localhost:8080/api/v1/propertydetails/116



Create new gas Station
http://localhost:8080/api/v1/property/gasstation
POST
{
        "brand": "Chevron",
        "fuelType": "ALL",
        "frannchise": "Last mile",
        "numberOfPumps": "5",
        "gasolineCapacity": "1000 ML",
        "diselCapacity": "500 ML",
        "storeBrand": "Last Mile",
        "storeApproxInventoryCost": "1M",
        "foodCourtSeatingCapacity": "20 People",
        "carWashEquipCost": "NA",
        "atm": "YES",
        "restroom": "YES",
        "lotSize": "40,000 SQFT",
        "numberOfParking": "10",
        "fireEquip": "",
        "fireCapacity": "",
        "autoSupplyRepairMaintShop": "",
        "propertyMetaData": {
            "propertyName": "Chevron2",
            "propertyType": null,
            "businessType": "Gas Station",
            "city": "Fremont",
            "currentOwner": "",
            "estatesEstimatedValue": 0,
            "imageUrl": "https://capi.myleasestar.com/v2/dimg-crop/17153218/300x438/17153218.jpg",
            "latitude": 37.5761,
            "longitude": -122.039,
            "lotSize": 213213,
            "propertyAddress": "34077 Paseo Padre Pkwy",
            "state": "CA",
            "zipCode": 94555,
            "zoningCategory": ""
        }
    }
    
 create new Restaurent
 POST
 http://localhost:8080/api/v1/property/restaurant
 {
	"type": "Indo-chinese",
	"description":"veg-NonVeg",
	"indoorSeatingCapacity":"50",
        "propertyMetaData": {
            "propertyName": "Little by Little 2",
            "businessType": "Restaurants and Food",
            "city": "Fremont",
            "currentOwner": "FREMONT TIMES SQUARE SHOPPING",
            "estatesEstimatedValue": 986851,
            "imageUrl": "https://photos.zillowstatic.com/p_h/IS2f4c0vcvb37g1000000000.jpg",
            "latitude": 37.4938,
            "longitude": -121.93,
            "lotSize": 52419,
            "propertyAddress": "46164 Warm Springs Blvd",
            "state": "CA",
            "zipCode": 94539,
            "zoningCategory": "Industrial"
        }
    }
 
 
 
`To update images table`
update rw_property_images as b 
inner join rw_property_details as a on a.property_code = b.property_code
set b.property_details_id = a.id; 


update `rw_property_details` set `property_id` = 1 WHERE business_type_code = 'b_type_1'


-------

ALTER TABLE `rw_property_details` ADD `property_id` INT NULL DEFAULT NULL AFTER `property_address`, ADD `property_type` VARCHAR(50) NULL DEFAULT NULL AFTER `property_id`;

INSERT INTO rw_restaurant (type,description) values ('Asian', 'All foods');

ALTER TABLE `rw_property_images` ADD `property_details_id` INT NULL DEFAULT NULL AFTER `image_url`;

update rw_property_images as b 
inner join rw_property_details as a on a.property_code = b.property_code
set b.property_details_id = a.id; 

update `rw_property_details` set `property_id` = 1 WHERE business_type_code = 'b_type_1';

update `rw_property_details` set `property_id` = 1 WHERE business_type_code = 'b_type_2';


CREATE TABLE `devbusinessdatabase`.`rw_liquer_store` ( `id` INT(10) NOT NULL AUTO_INCREMENT , `appr_inventory_cost` VARCHAR(50) NULL , `atm_machine` VARCHAR(50) NULL , `storage_sqft` VARCHAR(50) NULL , `drinks_cabinets` VARCHAR(50) NULL , `vending_machine` VARCHAR(50) NULL , `goods_Cabinets` VARCHAR(50) NULL , `residential_area` VARCHAR(50) NULL , `demographic_link` VARCHAR(50) NULL , `walkscore` VARCHAR(50) NULL , `avg_age` VARCHAR(50) NULL , `avg_income` VARCHAR(50) NULL , `crime_indcator` VARCHAR(50) NULL , `associated_business` VARCHAR(50) NULL , `convenience_store` VARCHAR(50) NULL , `fresh_goods_market` VARCHAR(50) NULL , `anchor_business` VARCHAR(100) NULL , `shopping_complex_traffic_score` VARCHAR(50) NULL , PRIMARY KEY (`id`)) ENGINE = InnoDB;

CREATE TABLE `devbusinessdatabase`.`rw_nail_care_store` ( `id` INT NOT NULL AUTO_INCREMENT , `nail_care` BOOLEAN NULL DEFAULT NULL , `skin_care` BOOLEAN NULL DEFAULT NULL , `lash_extension` BOOLEAN NULL DEFAULT NULL , `massage` BOOLEAN NULL DEFAULT NULL , `body_treatments` BOOLEAN NULL DEFAULT NULL , `location_of_spa` VARCHAR(50) NULL DEFAULT NULL , `walkscore` VARCHAR(50) NULL DEFAULT NULL , `avg_age` VARCHAR(50) NULL DEFAULT NULL , `avg_income` VARCHAR(50) NULL DEFAULT NULL , `interior_sqft` VARCHAR(50) NULL DEFAULT NULL , `manicure_tables` VARCHAR(50) NULL DEFAULT NULL , `nail_dryers` VARCHAR(50) NULL DEFAULT NULL , `portable_pedicure_spa` VARCHAR(50) NULL DEFAULT NULL , `nail_salon_trolleys` VARCHAR(50) NULL DEFAULT NULL , `pedicure_spa_chairs` VARCHAR(50) NULL DEFAULT NULL , `interior_features` VARCHAR(100) NULL DEFAULT NULL , `restrooms` VARCHAR(50) NULL DEFAULT NULL , `waiting_area` VARCHAR(50) NULL DEFAULT NULL , `reception_area` VARCHAR(50) NULL DEFAULT NULL , `capacity` VARCHAR(50) NULL DEFAULT NULL , `last_renovation` VARCHAR(50) NULL DEFAULT NULL , `staff_rooms` VARCHAR(50) NULL DEFAULT NULL , `exterior_signage` VARCHAR(50) NULL DEFAULT NULL , `anchor_business` VARCHAR(50) NULL DEFAULT NULL , `type_of_building` VARCHAR(50) NULL DEFAULT NULL , `parking` VARCHAR(50) NULL DEFAULT NULL , `rent` VARCHAR(50) NULL DEFAULT NULL , `water` VARCHAR(50) NULL DEFAULT NULL , `electricity` VARCHAR(50) NULL DEFAULT NULL , `garbage` VARCHAR(50) NULL DEFAULT NULL , `employee` VARCHAR(50) NULL DEFAULT NULL , PRIMARY KEY (`id`)) ENGINE = InnoDB;

ALTER TABLE `rw_user_profile` CHANGE `first_name` `first_name` VARCHAR(50) NULL;

ALTER TABLE `rw_user_profile` CHANGE `user_type` `user_type` VARCHAR(10) NULL;

ALTER TABLE `rw_property_details` ADD `user_id` INT NULL AFTER `updatedOn`;

UPDATE rw_property_details SET user_id = 2;

CREATE TABLE `devbusinessdatabase2`.`rw_user_bookmarked_listing` ( `id` INT NOT NULL AUTO_INCREMENT , `user_id` INT NOT NULL , `property_details_id` INT NOT NULL , PRIMARY KEY (`id`));

ALTER TABLE devbusinessdatabase_new.rw_property_details ADD email_adddress varchar(50) null default null after phone_number, ADD reason_for_sell varchar(1000) null default null, ADD business_description varchar(1000) null default null, ADD business_premise varchar(100) null default null, ADD lease_terms varchar(100) null default null, ADD asking_price varchar(50) null after estated_estimated_value, ADD estimated_price_by_average varchar(50) null after asking_price, ADD estimated_price_by_gross varchar(50) null after estimated_price_by_average, ADD estimated_price_by_cash varchar(50) null after estimated_price_by_gross;

ALTER Table devbusinessdatabase_new.rw_restaurant ADD walkin_freezer varchar(50) null default null after oven, ADD refrigerator varchar(50) null default null after walkin_freezer, ADD dish_capacity varchar(50) null default null after fryers, ADD number_of_ovens varchar(50) null default null after dish_capacity, ADD exhaust_type varchar(50) null default null after number_of_ovens, ADD shopping_complex_traffice_score varchar(50) null default null after crime_indicator, ADD signage_size varchar(50) null default null after shopping_complex_traffice_score, ADD signage_visibility varchar(50) null default null after signage_size;
ALTER Table devbusinessdatabase_new.rw_restaurant MODIFY certified_emp varchar(50) null after utilities_expense, MODIFY fulltime_emp varchar(50) null after certified_emp, CHANGE parttiem_emp parttime_emp varchar(50) null after fulltime_emp, MODIFY total_emp varchar(50) null after parttime_emp, MODIFY residential_area varchar(100) null after avg_revenue_liquer, MODIFY wiki_demo_link varchar(50) null after residential_area, MODIFY walkscore varchar(50) null after wiki_demo_link, MODIFY crime_indicator varchar(50) null after walkscore, MODIFY security varchar(50) null after crime_indicator, MODIFY surrounding_business varchar(50) null after security, CHANGE shopping_complex_traffice_score shopping_complex_traffic_score varchar(50) null after surrounding_business, ADD structure_age varchar(50) null after shopping_complex_traffic_score, MODIFY signage_size varchar(50) null after structure_age, MODIFY signage_visibility varchar(50) null after signage_size;

ALTER Table devbusinessdatabase_new.rw_gas_station MODIFY type_of_service varchar(50) after disel_capacity, ADD  convenient_store varchar(50) null default null after type_of_service, ADD food_court varchar(50) null default null after store_approx_inventory_cost, ADD food_court_cost varchar(50) null default null after food_court_seating_capacity, ADD car_wash varchar(50) null default null after food_court_cost, ADD auto_shop_cost  varchar(50) null default null after auto_supply_repair_maint_shop, CHANGE timings open_hours_gas varchar(50) null default null, ADD open_hours_store varchar(50) null default null, ADD open_hours_food_court varchar(50) null default null, ADD open_hours_car_wash varchar(50) null default null, ADD open_hours_auto_shop varchar(50) null default null, ADD monthly_rent varchar(50) null default null, ADD nnn_expense varchar(50) null default null, ADD garbage_expense varchar(50) null default null, ADD utilities_expense varchar(50) null default null, ADD certified_emp varchar(50) null default null, ADD fulltime_emp varchar(50) null default null, ADD parttime_emp varchar(50) null default null, ADD total_emp varchar(50) null default null, ADD aveg_revenue_gas varchar(50) null default null, ADD avg_revenue_store varchar(50) null default null, ADD avg_revenue_food_court varchar(50) null default null, ADD avg_revenue_car_wash varchar(50) null default null, ADD avg_revenue_auto_shop varchar(50) null default null, ADD total_revenue varchar(50) null default null, CHANGE local_community residential_area varchar(100) null after total_revenue, ADD wiki_demo_link varchar(50) null, ADD walkscore varchar(50) null,  ADD crime_indicator varchar(50) null, ADD security varchar(100) null, ADD surrounding_business varchar(100) null, ADD shopping_complex_traffic_score varchar(50) null, ADD structure_age varchar(50) null, MODIFY truck_parking varchar(50) after structure_age, MODIFY signage_size varchar(50) after truck_parking,  CHANGE signage_highvisibility signage_visibility varchar(50) after signage_size;

ALTER Table devbusinessdatabase_new.rw_coin_laundry ADD monthly_rent varchar(50) null default null, ADD nnn_expense varchar(50) null default null, ADD garbage_expense varchar(50) null default null, CHANGE utilities utilities_expense varchar(50) null default null after garbage_expense, ADD certified_emp varchar(50) null default null, ADD fulltime_emp varchar(50) null default null, ADD parttime_emp varchar(50) null default null, ADD total_emp varchar(50) null default null, ADD avg_revenue varchar(50) null default null, ADD residential_area varchar(100) null after avg_revenue, ADD wiki_demo_link varchar(50) null, ADD walkscore varchar(50) null,  ADD crime_indicator varchar(50) null, ADD security varchar(100) null, ADD surrounding_business varchar(100) null, ADD shopping_complex_traffic_score varchar(50) null, ADD structure_age varchar(50) null, ADD signage_size varchar(50) null,  ADD signage_visibility varchar(50) null;

ALTER Table devbusinessdatabase_new.rw_liquer_store ADD number_of_parking varchar(50) null after anchor_business, ADD monthly_rent varchar(50) null default null, ADD nnn_expense varchar(50) null default null, ADD garbage_expense varchar(50) null default null, ADD utilities_expense varchar(50) null default null after garbage_expense, ADD certified_emp varchar(50) null default null, ADD fulltime_emp varchar(50) null default null, ADD parttime_emp varchar(50) null default null, ADD total_emp varchar(50) null default null, MODIFY avg_income varchar(50) null after total_emp, ADD avg_revenue varchar(50) null after avg_income, MODIFY residential_area varchar(100) after avg_revenue, CHANGE demographic_link wiki_demo_link varchar(50) null after residential_area, MODIFY walkscore varchar(50) null after wiki_demo_link,  CHANGE crime_indcator crime_indicator varchar(50) null after walkscore, ADD security varchar(100) null after crime_indicator, ADD surrounding_business varchar(100) null after security, MODIFY shopping_complex_traffic_score varchar(50) after surrounding_business, ADD structure_age varchar(50) null, ADD signage_size varchar(50) null,  ADD signage_visibility varchar(50) null;

ALTER Table devbusinessdatabase_new.rw_nail_care_store CHANGE capacity seating_capacity varchar(50) null, ADD open_hours varchar(50) null after anchor_business, CHANGE rent monthly_rent varchar(50) null, DROP water, DROP electricity, ADD nnn_expense varchar(50) null after monthly_rent, CHANGE garbage gabarge_expense varchar(50) null after nnn_expense, ADD utilities_expense varchar(50) null after gabarge_expense, CHANGE employee certified_emp varchar(50) null after utilities_expense, ADD fulltime_emp varchar(50) null after certified_emp, ADD parttime_emp varchar(50) null after fulltime_emp, ADD total_emp varchar(50) null after parttime_emp, MODIFY avg_income varchar(50) after total_emp, ADD avg_revenue varchar(50) null after avg_income, ADD residential_area varchar(100) after avg_revenue, ADD wiki_demo_link varchar(50) null after residential_area, MODIFY walkscore varchar(50) null after wiki_demo_link, ADD crime_indicator varchar(50) null after walkscore, ADD security varchar(100) null after crime_indicator, ADD surrounding_business varchar(100) null after security, ADD shopping_complex_traffic_score varchar(50) after surrounding_business, ADD structure_age varchar(50) null, ADD signage_size varchar(50) null,  ADD signage_visibility varchar(50) null;






CREATE TABLE `t_brw_business_master` ( 

`id` INT(10) NOT NULL AUTO_INCREMENT,

`comp_based_est` INT(10) NULL,

`comp_based_low` INT(10) NULL,

`comp_based_high` INT(10) NULL,

`asset_based_est` INT(10) NULL,

`asset_based_low` INT(10) NULL,

`asset_based_high` INT(10) NULL,

`equity_based_est` INT(10) NULL,

`equity_based_low` INT(10) NULL,

`equity_based_high` INT(10) NULL,

`liquidity_based_est` INT(10) NULL,

`liquidity_based_low` INT(10) NULL,

`liquidity_based_high` INT(10) NULL,

`last_est_date` DATE NULL,

`last_infoupdate_date` DATE NULL,

`for_sell_YN` VARCHAR(1) NULL,

`for_sell_price` INT(10) NULL,

`for_sell_date` DATE NULL,

`name` VARCHAR(50) NOT NULL,

`DBA_name` VARCHAR(50) NOT NULL,

`image_url` VARCHAR(200) NOT NULL,

`address_street1` VARCHAR(50) NOT NULL,

`address_street2` VARCHAR(50) NULL,

`address_street3` VARCHAR(50) NULL,

`address_street4` VARCHAR(50) NULL,

`address_city` VARCHAR(50) NOT NULL,

`address_county` VARCHAR(50) NOT NULL,

`address_state` VARCHAR(50) NOT NULL,

`address_zip` VARCHAR(50) NOT NULL,

`address_country` VARCHAR(50) NOT NULL,

`address_latitude` DOUBLE NOT NULL,

`address_longitude` DOUBLE NOT NULL,

`phone` VARCHAR(10) NOT NULL,

`email_address` VARCHAR(128) NOT NULL,

`website` VARCHAR(128) NOT NULL,

`type` VARCHAR(50) NOT NULL,

`description` BLOB(10000) NULL,

`NACIS_type` VARCHAR(50) NULL,

`NACIS_description` VARCHAR(50) NULL,

`franchise_YN` VARCHAR(1) NULL,

`owner_claim_YN` VARCHAR(1) NULL,

`owner1_first_name` VARCHAR(30) NULL,

`owner1_last_name` VARCHAR(30) NULL,

`owner1_address_street1` VARCHAR(50) NOT NULL,

`owner1_address_street2` VARCHAR(50) NULL,

`owner1_address_street3` VARCHAR(50) NULL,

`owner1_address_street4` VARCHAR(50) NULL,

`owner1_address_city` VARCHAR(50) NOT NULL,

`owner1_address_county` VARCHAR(50) NOT NULL,

`owner1_address_state` VARCHAR(50) NOT NULL,

`owner1_address_zip` VARCHAR(50) NOT NULL,

`owner1_address_country` VARCHAR(50) NOT NULL,

`owner1_email_address` VARCHAR(128) NOT NULL,

`owner1_phone1` VARCHAR(10) NOT NULL,

`owner1_phone2` VARCHAR(20) NOT NULL,

`owner2_first_name` VARCHAR(30) NULL,

`owner2_last_name` VARCHAR(30) NULL,

`total_indoor_sqft` INT(10) NULL,

`total_outdoor_sqft` INT(10) NULL,

`total_lot_sqft` INT(10) NULL,

`total_parking_num` INT(10) NULL,

`security_type` VARCHAR(10) NULL,

`premise_owned_YN` VARCHAR(1) NULL,

`premise_price` INT(10) NULL,

`monthly_rent_expense` INT(10) NULL,

`monthly_rawmaterial_expense` INT(10) NULL,

`monthly_revenue` INT(10) NULL,

`monthly_net_profit` INT(10) NULL,

`monthly_emp_salary` INT(10) NULL,

`monthly_inventorymaint_cost` INT(10) NULL,

`total_equipment_cost` INT(10) NULL,

`furniture_cost` INT(10) NULL,

`furniture_year` VARCHAR(4) NULL,

`interiordeco_cost` INT(10) NULL,

`interiordeco_year` VARCHAR(4) NULL,

`exteriordeco_cost` INT(10) NULL,

`exteriordeco_year` VARCHAR(4) NULL,

`restroom_num` INT(2) NULL,

`ADArestroom_num` INT(2) NULL,

`alcohol_lic_type` VARCHAR(10) NULL,

`associated_biz_YN` VARCHAR(1) NULL,

`associated_biz_id1` INT(10)  NULL,

`associated_biz_id2` INT(10)  NULL,

`associated_biz_id3` INT(10)  NULL,

`associated_biz_id4` INT(10)  NULL,

`associated_biz_id5` INT(10)  NULL,

`ATM_YN` VARCHAR(1) NULL,

`ATM_cost` INT(10) NULL,

`firesafety_YN` VARCHAR(1) NULL,

`firesafety_equip_type` VARCHAR(1) NULL,

`firesafety_equip_cost` INT(10) NULL,

`equip1_type` VARCHAR(1) NULL,

`equip1_num` INT(3) NULL,

`equip1_cost` INT(10) NULL,

`equip1_update_year` VARCHAR(4) NULL,

`equip2_type` VARCHAR(1) NULL,

`equip2_num` INT(3) NULL,

`equip2_cost` INT(10) NULL,

`equip2_update_year` VARCHAR(4) NULL,

`equip3_type` VARCHAR(1) NULL,

`equip3_num` INT(3) NULL,

`equip3_cost` INT(10) NULL,

`equip3_update_year` VARCHAR(4) NULL,

`equip4_type` VARCHAR(1) NULL,

`equip4_num` INT(3) NULL,

`equip4_cost` INT(10) NULL,

`equip4_update_year` VARCHAR(4) NULL,

`equip5_type` VARCHAR(1) NULL,

`equip5_num` INT(3) NULL,

`equip5_cost` INT(10) NULL,

`equip5_update_year` VARCHAR(4) NULL,

`area_crime_score` INT(3) NULL,

`area_walk_score` INT(3) NULL,

`social_media_score` INT(3) NULL,

`proximity_attraction_score` INT(3) NULL,

`area_transit_score` INT(3) NULL,

`emp_FT_num` INT(4) NULL,

`emp_PT_num` INT(4) NULL,

`pop_1mile_rad` INT(10) NULL,

`pop_3mile_rad` INT(10) NULL,

`pop_5mile_rad` INT(10) NULL,

`dailypeople_doorfront_num` INT(10) NULL,

`dailycar_parklot_num` INT(10) NULL,

`last_sell_price` INT(10) NULL,

`last_sell_year` INT(4) NULL,

`last_sell_month` INT(2) NULL,

`resto_cuisine` VARCHAR(20) NULL,

`indoor_seat_cap` INT(4) NULL,

`outdoor_seat_cap` INT(4) NULL,

`resto_hood_length` INT(2) NULL,

`resto_kitchen_sqft` INT(4) NULL,

`resto_kitchenreno_year` VARCHAR(4) NULL,

`resto_bar_YN` INT(4) NULL,

`resto_bar_sqft` INT(4) NULL,

`resto_bar_seatcap` INT(2) NULL,

`resto_bardeco_cost` INT(10) NULL,

`resto_bardeco_year` VARCHAR(4) NULL,

`resto_NNN_expense` INT(10) NULL,

`gas_company` VARCHAR(30) NULL,

`gas_fuel_type` VARCHAR(10) NULL,

`gas_pump_type` VARCHAR(10) NULL,

`gas_pump_num` INT(2) NULL,

`gas_airwater_YN` VARCHAR(1) NULL,

PRIMARY KEY (`id`)) ENGINE = InnoDB;




