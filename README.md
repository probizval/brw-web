# BRW Spring Boot Web Application

You Need:

1. Java 1.8
2. Maven 3.6
3. Tomcat v9.0

Open your terminal then type this : `mvn clean spring-boot:run`

Open your browser then type this : `http://localhost:8080/`



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

ALTER TABLE `rw_user_profile` CHANGE `first_name` `first_name` VARCHAR(50) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL;

ALTER TABLE `rw_user_profile` CHANGE `user_type` `user_type` VARCHAR(10) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL;

ALTER TABLE `rw_property_details` ADD `user_id` INT NULL AFTER `updatedOn`;

