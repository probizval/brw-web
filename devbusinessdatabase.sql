-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Dec 18, 2018 at 10:49 AM
-- Server version: 10.1.36-MariaDB
-- PHP Version: 5.6.38

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `devbusinessdatabase`
--

-- --------------------------------------------------------

--
-- Table structure for table `rw_business_definition2`
--

CREATE TABLE `rw_business_definition` (
  `id` int(15) NOT NULL,
  `business_type_code` varchar(15) NOT NULL,
  `business_type` varchar(50) NOT NULL,
  `business_type_description` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `rw_business_definition`
--

INSERT INTO `rw_business_definition` (`id`, `business_type_code`, `business_type`, `business_type_description`) VALUES
(1, 'b_type_1', 'Restaurants and Food', 'Restaurants and Food');
INSERT INTO `rw_business_definition` (`id`, `business_type_code`, `business_type`, `business_type_description`) VALUES
(2, 'b_type_2', 'Gas Station', 'Gas Station');
INSERT INTO `rw_business_definition` (`id`, `business_type_code`, `business_type`, `business_type_description`) VALUES
(3, 'b_type_3', 'Liquor Store', 'Liquor Store');
INSERT INTO `rw_business_definition` (`id`, `business_type_code`, `business_type`, `business_type_description`) VALUES
(4, 'b_type_4', 'Beauty Salon/Spa/Nail', 'Beauty Salon/Spa/Nail');
INSERT INTO `rw_business_definition` (`id`, `business_type_code`, `business_type`, `business_type_description`) VALUES
(5, 'b_type_5', 'Convenience Store', 'Convenience Store');
INSERT INTO `rw_business_definition` (`id`, `business_type_code`, `business_type`, `business_type_description`) VALUES
(6, 'b_type_6', 'Auto Service Shop', 'Auto Service Shop');
INSERT INTO `rw_business_definition` (`id`, `business_type_code`, `business_type`, `business_type_description`) VALUES
(7, 'b_type_7', 'Laundry', 'Laundry');
INSERT INTO `rw_business_definition` (`id`, `business_type_code`, `business_type`, `business_type_description`) VALUES
(8, 'b_type_8', 'Cafe', 'Cafe');
INSERT INTO `rw_business_definition` (`id`, `business_type_code`, `business_type`, `business_type_description`) VALUES
(9, 'b_type_9', 'Others', 'Others');

-- --------------------------------------------------------

--
-- Table structure for table `rw_business_details`
--

CREATE TABLE `rw_business_details` (
  `id` int(15) NOT NULL,
  `business_code` varchar(15) NOT NULL,
  `property_code` varchar(15) DEFAULT NULL,
  `business_type_code` varchar(15) NOT NULL,
  `business_name` varchar(120) DEFAULT NULL,
  `estimated_value` double DEFAULT NULL,
  `cre_unit_code` varchar(15) NOT NULL,
  `square_feet` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `rw_business_valuation`
--

CREATE TABLE `rw_business_valuation` (
  `id` int(15) NOT NULL,
  `business_code` varchar(15) NOT NULL,
  `county_value` int(20) DEFAULT NULL,
  `estimated_value` double DEFAULT NULL,
  `historic_value` double DEFAULT NULL,
  `future_value` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `rw_buy_business_requirements`
--

CREATE TABLE `rw_buy_business_requirements` (
  `id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `business_category` varchar(100) NOT NULL,
  `business_type` varchar(1000) NOT NULL,
  `other_business_category` varchar(100) DEFAULT NULL,
  `other_business_type` varchar(100) DEFAULT NULL,
  `radius` int(11) NOT NULL,
  `min_price` int(20) DEFAULT NULL,
  `max_price` int(20) DEFAULT NULL,
  `min_lot_size` int(20) DEFAULT NULL,
  `max_lot_size` int(20) DEFAULT NULL,
  `business_description` varchar(1000) DEFAULT NULL,
  `business_location` varchar(1000) NOT NULL,
  `address` varchar(50) DEFAULT NULL,
  `city` varchar(50) DEFAULT NULL,
  `state` varchar(50) DEFAULT NULL,
  `country` varchar(50) DEFAULT NULL,
  `zip_code` int(11) DEFAULT NULL,
  `latitude` float DEFAULT NULL,
  `longitude` float DEFAULT NULL,
  `first_name` varchar(50) NOT NULL,
  `last_name` varchar(50) DEFAULT NULL,
  `email_adress` varchar(50) NOT NULL,
  `contact_number` varchar(50) NOT NULL,
  `mode_of_contact` varchar(50) NOT NULL,
  `connect_with_local_agents` tinyint(1) DEFAULT NULL,
  `send_matched_businesses_email` tinyint(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `rw_coin_laundry`
--

CREATE TABLE `rw_coin_laundry` (
  `id` int(11) NOT NULL,
  `no_of_washers` varchar(50) DEFAULT NULL,
  `no_of_dryers` varchar(50) DEFAULT NULL,
  `cost_of_equip` varchar(50) DEFAULT NULL,
  `features` varchar(50) DEFAULT NULL,
  `restrooms` varchar(50) DEFAULT NULL,
  `supplies` varchar(50) DEFAULT NULL,
  `coin_dispensers` varchar(50) DEFAULT NULL,
  `seating_capacity` varchar(50) DEFAULT NULL,
  `total_sqft` varchar(50) DEFAULT NULL,
  `counter_space` varchar(50) DEFAULT NULL,
  `carts` varchar(50) DEFAULT NULL,
  `water_factor` varchar(50) DEFAULT NULL,
  `utilities` varchar(50) DEFAULT NULL,
  `demographics_population` varchar(50) DEFAULT NULL,
  `maintenance_contracts` varchar(100) DEFAULT NULL,
  `machin_manufactures` varchar(50) DEFAULT NULL,
  `machine_efficiences` varchar(50) DEFAULT NULL,
  `machine_lifespan` varchar(50) DEFAULT NULL,
  `association_with_others` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `rw_cre_units`
--

CREATE TABLE `rw_cre_units` (
  `id` int(15) NOT NULL,
  `cre_unit_code` varchar(15) NOT NULL,
  `property_code` varchar(15) DEFAULT NULL,
  `square_feet` double DEFAULT NULL,
  `floor_number` int(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `rw_cre_valuation`
--

CREATE TABLE `rw_cre_valuation` (
  `id` int(15) NOT NULL,
  `cre_unit_code` varchar(15) NOT NULL,
  `property_code` varchar(15) DEFAULT NULL,
  `cre_value` double DEFAULT NULL,
  `rental_value` double DEFAULT NULL,
  `county_value` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `rw_customer_definition`
--

CREATE TABLE `rw_customer_definition` (
  `id` int(15) NOT NULL,
  `customer_type_code` varchar(15) NOT NULL,
  `customer_type` varchar(60) NOT NULL,
  `customer_type_description` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `rw_gas_station`
--

CREATE TABLE `rw_gas_station` (
  `id` int(11) NOT NULL,
  `brand` varchar(50) NOT NULL,
  `fuel_type` varchar(50) NOT NULL,
  `frannchise` varchar(50) DEFAULT NULL,
  `no_of_pumps` varchar(50) DEFAULT NULL,
  `gasoline_capacity` varchar(50) DEFAULT NULL,
  `disel_capacity` varchar(50) DEFAULT NULL,
  `store_brand` varchar(50) DEFAULT NULL,
  `store_approx_inventory_cost` varchar(50) DEFAULT NULL,
  `food_court_seating_capacity` varchar(50) DEFAULT NULL,
  `car_wash_equip_cost` varchar(50) DEFAULT NULL,
  `atm` varchar(50) DEFAULT NULL,
  `restroom` varchar(50) DEFAULT NULL,
  `lot_size` varchar(50) DEFAULT NULL,
  `number_of_parking` varchar(50) DEFAULT NULL,
  `fire_equip` varchar(50) DEFAULT NULL,
  `fire_capacity` varchar(50) DEFAULT NULL,
  `auto_supply_repair_maint_shop` varchar(50) DEFAULT NULL,
  `liquer_store` varchar(50) DEFAULT NULL,
  `local_community` varchar(50) DEFAULT NULL,
  `truck_parking` varchar(50) DEFAULT NULL,
  `signage_size` varchar(50) DEFAULT NULL,
  `signage_highvisibility` varchar(50) DEFAULT NULL,
  `timings` varchar(50) DEFAULT NULL,
  `type_of_service` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `rw_gas_station`
--

INSERT INTO `rw_gas_station` (`id`, `brand`, `fuel_type`, `frannchise`, `no_of_pumps`, `gasoline_capacity`, `disel_capacity`, `store_brand`, `store_approx_inventory_cost`, `food_court_seating_capacity`, `car_wash_equip_cost`, `atm`, `restroom`, `lot_size`, `number_of_parking`, `fire_equip`, `fire_capacity`, `auto_supply_repair_maint_shop`, `liquer_store`, `local_community`, `truck_parking`, `signage_size`, `signage_highvisibility`, `timings`, `type_of_service`) VALUES
(1, 'Shell', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '');
INSERT INTO `rw_gas_station` (`id`, `brand`, `fuel_type`, `frannchise`, `no_of_pumps`, `gasoline_capacity`, `disel_capacity`, `store_brand`, `store_approx_inventory_cost`, `food_court_seating_capacity`, `car_wash_equip_cost`, `atm`, `restroom`, `lot_size`, `number_of_parking`, `fire_equip`, `fire_capacity`, `auto_supply_repair_maint_shop`, `liquer_store`, `local_community`, `truck_parking`, `signage_size`, `signage_highvisibility`, `timings`, `type_of_service`) VALUES
(2, 'SHELL2', 'GAS', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '');
INSERT INTO `rw_gas_station` (`id`, `brand`, `fuel_type`, `frannchise`, `no_of_pumps`, `gasoline_capacity`, `disel_capacity`, `store_brand`, `store_approx_inventory_cost`, `food_court_seating_capacity`, `car_wash_equip_cost`, `atm`, `restroom`, `lot_size`, `number_of_parking`, `fire_equip`, `fire_capacity`, `auto_supply_repair_maint_shop`, `liquer_store`, `local_community`, `truck_parking`, `signage_size`, `signage_highvisibility`, `timings`, `type_of_service`) VALUES
(3, 'Shell', 'GAS', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '');

-- --------------------------------------------------------

--
-- Table structure for table `rw_property_definition`
--

CREATE TABLE `rw_property_definition` (
  `id` int(15) NOT NULL,
  `property_type_code` varchar(15) NOT NULL,
  `property_type` varchar(60) NOT NULL,
  `property_type_description` varchar(120) NOT NULL,
  `property_zoning` varchar(120) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `rw_property_definition`
--

INSERT INTO `rw_property_definition` (`id`, `property_type_code`, `property_type`, `property_type_description`, `property_zoning`) VALUES
(1, 'pt_type_1', 'Commercial', 'Commercial', 'Office, Restaurant, Condominium');
INSERT INTO `rw_property_definition` (`id`, `property_type_code`, `property_type`, `property_type_description`, `property_zoning`) VALUES
(2, 'pt_type_2', 'Industrial', 'Industrial', 'Industrial');

-- --------------------------------------------------------

--
-- Table structure for table `rw_property_details`
--

CREATE TABLE `rw_property_details` (
  `id` int(15) NOT NULL,
  `property_code` varchar(15) NOT NULL,
  `property_name` varchar(120) NOT NULL,
  `property_address` varchar(120) NOT NULL,
  `property_id` int(11) DEFAULT NULL,
  `property_type` varchar(50) DEFAULT NULL,
  `business_type_code` varchar(15) NOT NULL,
  `business_type` varchar(100) NOT NULL,
  `img_url` varchar(100) NOT NULL,
  `mls_number` int(11) DEFAULT NULL,
  `city` varchar(60) DEFAULT NULL,
  `state` varchar(60) DEFAULT NULL,
  `latitude` double DEFAULT NULL,
  `longitude` double DEFAULT NULL,
  `zip_code` int(10) DEFAULT NULL,
  `phone_number` varchar(30) DEFAULT NULL,
  `year_built` int(4) DEFAULT NULL,
  `effective_year_built` int(4) DEFAULT NULL,
  `lot_size` double DEFAULT NULL,
  `total_size_of_building` double DEFAULT NULL,
  `is_closed` tinyint(1) DEFAULT NULL,
  `is_business_claimed_by_owner` tinyint(1) DEFAULT NULL,
  `estated_estimated_value` double DEFAULT NULL,
  `units_count` int(15) DEFAULT NULL,
  `stories_count` int(5) DEFAULT NULL,
  `current_owner_name` varchar(120) DEFAULT NULL,
  `current_owner_address` varchar(120) DEFAULT NULL,
  `yelp_rating` double DEFAULT NULL,
  `zoning_category` varchar(60) DEFAULT NULL,
  `zoning_description` varchar(200) DEFAULT NULL,
  `property_available_for` varchar(10) NOT NULL,
  `listedOn` date DEFAULT NULL,
  `updatedOn` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `rw_property_details`
--

INSERT INTO `rw_property_details` (`id`, `property_code`, `property_name`, `property_address`, `property_id`, `property_type`, `business_type_code`, `business_type`, `img_url`, `mls_number`, `city`, `state`, `latitude`, `longitude`, `zip_code`, `phone_number`, `year_built`, `effective_year_built`, `lot_size`, `total_size_of_building`, `is_closed`, `is_business_claimed_by_owner`, `estated_estimated_value`, `units_count`, `stories_count`, `current_owner_name`, `current_owner_address`, `yelp_rating`, `zoning_category`, `zoning_description`, `property_available_for`, `listedOn`, `updatedOn`) VALUES
(1, 'pt_code_1', 'Michelle', 'Blue Village 1', 1, NULL, 'b_type_1', 'Restaurants and Food', 'https://photos.zillowstatic.com/p_h/IS2f4c0vcvb37g1000000000.jpg', 0, '', '', 0, 0, 0, '', 0, 0, 0, 0, 0, 0, 0, 0, 0, '', '', 0, '', '', 'Lease', '0000-00-00', '0000-00-00');
INSERT INTO `rw_property_details` (`id`, `property_code`, `property_name`, `property_address`, `property_id`, `property_type`, `business_type_code`, `business_type`, `img_url`, `mls_number`, `city`, `state`, `latitude`, `longitude`, `zip_code`, `phone_number`, `year_built`, `effective_year_built`, `lot_size`, `total_size_of_building`, `is_closed`, `is_business_claimed_by_owner`, `estated_estimated_value`, `units_count`, `stories_count`, `current_owner_name`, `current_owner_address`, `yelp_rating`, `zoning_category`, `zoning_description`, `property_available_for`, `listedOn`, `updatedOn`) VALUES
(10, 'pt_code_10', '39372 Drake Way, Fremont, CA 94538', '39372 Drake Way', NULL, NULL, 'b_type_9', 'Others', 'https://photos.zillowstatic.com/p_h/ISin5z6wfryj1l1000000000.jpg', 22222, 'Fremont', 'CA', 37.5354, -121.992, 94538, '1321', 0, 0, 22244, 0, 0, 0, 0, 0, 0, '', '', 0, '', '', 'Buy', '0000-00-00', '0000-00-00');
INSERT INTO `rw_property_details` (`id`, `property_code`, `property_name`, `property_address`, `property_id`, `property_type`, `business_type_code`, `business_type`, `img_url`, `mls_number`, `city`, `state`, `latitude`, `longitude`, `zip_code`, `phone_number`, `year_built`, `effective_year_built`, `lot_size`, `total_size_of_building`, `is_closed`, `is_business_claimed_by_owner`, `estated_estimated_value`, `units_count`, `stories_count`, `current_owner_name`, `current_owner_address`, `yelp_rating`, `zoning_category`, `zoning_description`, `property_available_for`, `listedOn`, `updatedOn`) VALUES
(101, 'pt_code_100', 'Big O Tires', '35255 Newark Blvd', NULL, NULL, 'b_type_6', 'Auto Service Shop', 'https://lh3.googleusercontent.com/p/AF1QipMifuq8Or1OcgtS8Ms3SY70WIb5AxrD_eWkxe_1=s1600-w500', NULL, 'Newark', 'CA', 37.5479353, -122.045078, 94560, '(510) 794-5622', 1984, 1984, 23614, 5000, 0, 1, 766107, 1, 1, 'VOORSTAD FAMILY LIVING TRUST', '12243 Lewis Ln, Nampa, ID 83686', 3.5, 'Commercial', 'Commercial', 'List', NULL, NULL);
INSERT INTO `rw_property_details` (`id`, `property_code`, `property_name`, `property_address`, `property_id`, `property_type`, `business_type_code`, `business_type`, `img_url`, `mls_number`, `city`, `state`, `latitude`, `longitude`, `zip_code`, `phone_number`, `year_built`, `effective_year_built`, `lot_size`, `total_size_of_building`, `is_closed`, `is_business_claimed_by_owner`, `estated_estimated_value`, `units_count`, `stories_count`, `current_owner_name`, `current_owner_address`, `yelp_rating`, `zoning_category`, `zoning_description`, `property_available_for`, `listedOn`, `updatedOn`) VALUES
(102, 'pt_code_101', 'Newark Tire & Auto Service', '6110 Jarvis Ave', NULL, NULL, 'b_type_6', 'Auto Service Shop', 'https://lh3.googleusercontent.com/p/AF1QipPBnsiRISfLZKBpN6Ft43fb-xf7LWJ-FyzhvbCU=s1600-w500', NULL, 'Newark', 'CA', 37.549604, -122.049504, 94560, '', 1986, 1987, 16745, 4572, 0, 0, 11996098, 1, 1, 'SHYU & YU ENTS', '3611 NEWARK BLVD, NEWARK, CA 94560', 0, 'Commercial', 'Commercial', 'List', NULL, NULL);
INSERT INTO `rw_property_details` (`id`, `property_code`, `property_name`, `property_address`, `property_id`, `property_type`, `business_type_code`, `business_type`, `img_url`, `mls_number`, `city`, `state`, `latitude`, `longitude`, `zip_code`, `phone_number`, `year_built`, `effective_year_built`, `lot_size`, `total_size_of_building`, `is_closed`, `is_business_claimed_by_owner`, `estated_estimated_value`, `units_count`, `stories_count`, `current_owner_name`, `current_owner_address`, `yelp_rating`, `zoning_category`, `zoning_description`, `property_available_for`, `listedOn`, `updatedOn`) VALUES
(103, 'pt_code_102', 'Laser Tagging', '5759 Stevenson Blvd', NULL, NULL, 'b_type_9', 'Others', 'https://lh3.googleusercontent.com/p/AF1QipMfnnpgR3cEP9L46mExXFpRdxsPrA1xbMQrm4op=s1600-w500', NULL, 'Newark', 'CA', 37.5199439, -121.9909988, 94560, '(510) 668-1200', 1978, 1991, 81010, 31730, 0, 1, 8494294, 7, 1, 'GULESSERIAN ENTS STEVENSON STA', '8 N San Pedro St Ste 270, San Jose, CA 95110', 4, 'Commercial', 'Commercial', 'List', NULL, NULL);
INSERT INTO `rw_property_details` (`id`, `property_code`, `property_name`, `property_address`, `property_id`, `property_type`, `business_type_code`, `business_type`, `img_url`, `mls_number`, `city`, `state`, `latitude`, `longitude`, `zip_code`, `phone_number`, `year_built`, `effective_year_built`, `lot_size`, `total_size_of_building`, `is_closed`, `is_business_claimed_by_owner`, `estated_estimated_value`, `units_count`, `stories_count`, `current_owner_name`, `current_owner_address`, `yelp_rating`, `zoning_category`, `zoning_description`, `property_available_for`, `listedOn`, `updatedOn`) VALUES
(104, 'pt_code_103', 'Java Teak', '37300 Cedar Blvd', NULL, NULL, 'b_type_9', 'Others', 'https://lh3.googleusercontent.com/p/AF1QipO_6U04Gby9eBFTG6_IZBEdKjnUECZRD7-185Yq=s1600-w500', NULL, 'Newark', 'CA', 37.540223, -122.021413, 94560, '(510) 579-7624', 0, 1986, 118048, 42000, 0, 1, 2050902, 5, 1, 'HUNTER AMY', '2596 Bay Rd Ste A, Redwood City, CA 94063', 5, 'Commercial', 'Commercial', 'List', NULL, NULL);
INSERT INTO `rw_property_details` (`id`, `property_code`, `property_name`, `property_address`, `property_id`, `property_type`, `business_type_code`, `business_type`, `img_url`, `mls_number`, `city`, `state`, `latitude`, `longitude`, `zip_code`, `phone_number`, `year_built`, `effective_year_built`, `lot_size`, `total_size_of_building`, `is_closed`, `is_business_claimed_by_owner`, `estated_estimated_value`, `units_count`, `stories_count`, `current_owner_name`, `current_owner_address`, `yelp_rating`, `zoning_category`, `zoning_description`, `property_available_for`, `listedOn`, `updatedOn`) VALUES
(105, 'pt_code_104', 'Ste 3D 8430 Central Ave', 'Ste 3D 8430 Central Ave', NULL, NULL, 'b_type_9', 'Others', 'https://photos.zillowstatic.com/p_h/IS2f4c0vcvb37g1000000000.jpg', NULL, 'Newark', 'CA', 37.51644, -122.0449, 94560, '', 1999, 1999, 121358, 4495, 0, 0, 1439934, 4, 1, 'VENTURE CENTER ASSOCIATES', '', 0, 'Commercial', 'Commercial', 'List', NULL, NULL);
INSERT INTO `rw_property_details` (`id`, `property_code`, `property_name`, `property_address`, `property_id`, `property_type`, `business_type_code`, `business_type`, `img_url`, `mls_number`, `city`, `state`, `latitude`, `longitude`, `zip_code`, `phone_number`, `year_built`, `effective_year_built`, `lot_size`, `total_size_of_building`, `is_closed`, `is_business_claimed_by_owner`, `estated_estimated_value`, `units_count`, `stories_count`, `current_owner_name`, `current_owner_address`, `yelp_rating`, `zoning_category`, `zoning_description`, `property_available_for`, `listedOn`, `updatedOn`) VALUES
(106, 'pt_code_105', 'Green Furniture Store', '7180 Thornton Ave', NULL, NULL, 'b_type_9', 'Others', 'https://lh3.googleusercontent.com/p/AF1QipPIqV5SrOwA_YkTBqjlxH08OUarAq-Emz0m5LbI=s1600-w500', NULL, 'Newark', 'CA', 37.5302039, -122.0374982, 94560, '', 1948, 1948, 3928, 3454, 0, 0, 802492, 3, 2, 'PHAM DONNA TRUST', '30 Reddy St, San Francisco, CA 94124', 0, 'Commercial', 'Commercial', 'List', NULL, NULL);
INSERT INTO `rw_property_details` (`id`, `property_code`, `property_name`, `property_address`, `property_id`, `property_type`, `business_type_code`, `business_type`, `img_url`, `mls_number`, `city`, `state`, `latitude`, `longitude`, `zip_code`, `phone_number`, `year_built`, `effective_year_built`, `lot_size`, `total_size_of_building`, `is_closed`, `is_business_claimed_by_owner`, `estated_estimated_value`, `units_count`, `stories_count`, `current_owner_name`, `current_owner_address`, `yelp_rating`, `zoning_category`, `zoning_description`, `property_available_for`, `listedOn`, `updatedOn`) VALUES
(107, 'pt_code_106', 'Zena Jewelers International', '1201 Newpark Mall', 1, NULL, 'b_type_1', 'Jewellery', 'https://lh3.googleusercontent.com/p/AF1QipO9s4Ow1HPk1W9ynCaK4Zy6m_nqDCvRqvWxtlHE=s1600-w500', NULL, 'Newark', 'CA', 37.526164, -121.999779, 94560, '', 1986, 1986, 465400, 91402, 0, 0, 18069535, 39, 2, 'NEWPARK MALL LP', '110 N Wacker Dr, Chicago, IL 60606', 0, 'Commercial', 'Commercial', 'List', NULL, NULL);
INSERT INTO `rw_property_details` (`id`, `property_code`, `property_name`, `property_address`, `property_id`, `property_type`, `business_type_code`, `business_type`, `img_url`, `mls_number`, `city`, `state`, `latitude`, `longitude`, `zip_code`, `phone_number`, `year_built`, `effective_year_built`, `lot_size`, `total_size_of_building`, `is_closed`, `is_business_claimed_by_owner`, `estated_estimated_value`, `units_count`, `stories_count`, `current_owner_name`, `current_owner_address`, `yelp_rating`, `zoning_category`, `zoning_description`, `property_available_for`, `listedOn`, `updatedOn`) VALUES
(108, 'pt_code_107', 'Best Nail', '36601 Newark Blvd', NULL, NULL, 'b_type_4', 'Beauty Salon/Spa/Nail', 'https://lh3.googleusercontent.com/p/AF1QipO8MQd6zY6DXC7kVz_VEP24qazlAS_8ipCyVs7V=s1600-w500', NULL, 'Newark', 'CA', 37.5389411, -122.0344225, 94560, '', 0, 1964, 209959, 58828, 0, 0, 1971743, 29, 1, 'FRIES PROPERTIES INC', '39678 Mission Blvd, Fremont, CA 94539', 0, 'Commercial', 'Commercial', 'List', NULL, NULL);
INSERT INTO `rw_property_details` (`id`, `property_code`, `property_name`, `property_address`, `property_id`, `property_type`, `business_type_code`, `business_type`, `img_url`, `mls_number`, `city`, `state`, `latitude`, `longitude`, `zip_code`, `phone_number`, `year_built`, `effective_year_built`, `lot_size`, `total_size_of_building`, `is_closed`, `is_business_claimed_by_owner`, `estated_estimated_value`, `units_count`, `stories_count`, `current_owner_name`, `current_owner_address`, `yelp_rating`, `zoning_category`, `zoning_description`, `property_available_for`, `listedOn`, `updatedOn`) VALUES
(109, 'pt_code_108', 'T & L\'s Elite Automotive Brakes & Transmissions', '1007 Decoto Rd', NULL, NULL, 'b_type_6', 'Auto Service Shop', 'https://lh3.googleusercontent.com/p/AF1QipOdPH4E9rTwVh5Vf98HphSEoZmta2nGU366XqbH=s1600-w500', NULL, 'Union City', 'CA', 37.5943628, -122.0192608, 94587, '', 0, 1935, 17900, 4158, 0, 0, 193097, 1, 1, 'BRINGHURST LLC', 'PO Box 2642, San Ramon, CA 94583', 0, 'Commercial', 'Commercial', 'List', NULL, NULL);
INSERT INTO `rw_property_details` (`id`, `property_code`, `property_name`, `property_address`, `property_id`, `property_type`, `business_type_code`, `business_type`, `img_url`, `mls_number`, `city`, `state`, `latitude`, `longitude`, `zip_code`, `phone_number`, `year_built`, `effective_year_built`, `lot_size`, `total_size_of_building`, `is_closed`, `is_business_claimed_by_owner`, `estated_estimated_value`, `units_count`, `stories_count`, `current_owner_name`, `current_owner_address`, `yelp_rating`, `zoning_category`, `zoning_description`, `property_available_for`, `listedOn`, `updatedOn`) VALUES
(110, 'pt_code_109', 'La-Z-Boy Furniture Galleries', '30650 Dyer St', NULL, NULL, 'b_type_9', 'Others', 'https://lh3.googleusercontent.com/p/AF1QipPXZ94aT7-ea-pjKw3KqXwAklqGdhJo6HSSKieo=s1600-w500', NULL, 'Union City', 'CA', 37.60350950000001, -122.0688437, 94587, '(510) 471-6130', 2002, 2002, 67008, 13674, 0, 1, 2587610, 1, 1, 'LA-Z-BOY FURNITURE G', '640 Lenfest Rd, San Jose, CA 95133', 3.5, 'Commercial', 'Commercial', 'List', NULL, NULL);
INSERT INTO `rw_property_details` (`id`, `property_code`, `property_name`, `property_address`, `property_id`, `property_type`, `business_type_code`, `business_type`, `img_url`, `mls_number`, `city`, `state`, `latitude`, `longitude`, `zip_code`, `phone_number`, `year_built`, `effective_year_built`, `lot_size`, `total_size_of_building`, `is_closed`, `is_business_claimed_by_owner`, `estated_estimated_value`, `units_count`, `stories_count`, `current_owner_name`, `current_owner_address`, `yelp_rating`, `zoning_category`, `zoning_description`, `property_available_for`, `listedOn`, `updatedOn`) VALUES
(11, 'pt_code_11', '464A Filbert St San Francisco, CA 94133', '464A Filbert St', NULL, NULL, 'b_type_9', 'Others', 'https://photos.zillowstatic.com/p_h/ISmaqtvxjq4h081000000000.jpg', 123456, 'San Francisco', 'CA', 37.8019, -122.407, 94133, '(415) 696-0288', 0, 0, 1000, 0, 0, 0, 0, 0, 0, '', '', 0, '', '', 'Buy', '0000-00-00', '0000-00-00');
INSERT INTO `rw_property_details` (`id`, `property_code`, `property_name`, `property_address`, `property_id`, `property_type`, `business_type_code`, `business_type`, `img_url`, `mls_number`, `city`, `state`, `latitude`, `longitude`, `zip_code`, `phone_number`, `year_built`, `effective_year_built`, `lot_size`, `total_size_of_building`, `is_closed`, `is_business_claimed_by_owner`, `estated_estimated_value`, `units_count`, `stories_count`, `current_owner_name`, `current_owner_address`, `yelp_rating`, `zoning_category`, `zoning_description`, `property_available_for`, `listedOn`, `updatedOn`) VALUES
(111, 'pt_code_110', '33333 Lewis St', '33333 Lewis St', 1, NULL, 'b_type_1', 'Restaurants and Food', 'https://photos.zillowstatic.com/p_h/IS2f4c0vcvb37g1000000000.jpg', NULL, 'Union City', 'CA', 37.598508, -122.030786, 94587, '', 1966, 1966, 78153, 43020, 0, 0, 1900062, 1, 1, 'YAN THOMAS', '33333 Lewis St, Union City, CA 94587', 0, 'Commercial', 'Commercial', 'List', NULL, NULL);
INSERT INTO `rw_property_details` (`id`, `property_code`, `property_name`, `property_address`, `property_id`, `property_type`, `business_type_code`, `business_type`, `img_url`, `mls_number`, `city`, `state`, `latitude`, `longitude`, `zip_code`, `phone_number`, `year_built`, `effective_year_built`, `lot_size`, `total_size_of_building`, `is_closed`, `is_business_claimed_by_owner`, `estated_estimated_value`, `units_count`, `stories_count`, `current_owner_name`, `current_owner_address`, `yelp_rating`, `zoning_category`, `zoning_description`, `property_available_for`, `listedOn`, `updatedOn`) VALUES
(112, 'pt_code_111', 'Jane Seymour Botanicals Inc', '3089 Whipple Rd', 1, NULL, 'b_type_1', 'Jewellery', 'https://photos.zillowstatic.com/p_h/IS2f4c0vcvb37g1000000000.jpg', NULL, 'Union City', 'CA', 37.606599, -122.077694, 94587, '', 1997, 1997, 303178, 134423, 0, 0, 27225808, 1, 1, 'GRAYBAR ELECTRIC CO', '34 N Meramec Ave, Saint Louis, MO 63105', 0, 'Commercial', 'Commercial', 'List', NULL, NULL);
INSERT INTO `rw_property_details` (`id`, `property_code`, `property_name`, `property_address`, `property_id`, `property_type`, `business_type_code`, `business_type`, `img_url`, `mls_number`, `city`, `state`, `latitude`, `longitude`, `zip_code`, `phone_number`, `year_built`, `effective_year_built`, `lot_size`, `total_size_of_building`, `is_closed`, `is_business_claimed_by_owner`, `estated_estimated_value`, `units_count`, `stories_count`, `current_owner_name`, `current_owner_address`, `yelp_rating`, `zoning_category`, `zoning_description`, `property_available_for`, `listedOn`, `updatedOn`) VALUES
(113, 'pt_code_112', 'El Mercado Laundry', '34300 Alvarado Niles Rd', NULL, NULL, 'b_type_7', 'Laundry', 'https://s3-media2.fl.yelpcdn.com/bphoto/T2nYt8p_W7gdO3gFT_bqAg/o.jpg', NULL, 'Union City', 'CA', 37.58816, -122.02347, 94587, '(510) 489-3960', 1981, 1981, 39988, 9000, 0, 1, 2078919, 5, 1, 'EL MERCADO SPE LLC', '4546 El Camino Real Ste 222, Los Altos, CA 94022', 3.5, 'Commercial', 'Commercial', 'List', NULL, NULL);
INSERT INTO `rw_property_details` (`id`, `property_code`, `property_name`, `property_address`, `property_id`, `property_type`, `business_type_code`, `business_type`, `img_url`, `mls_number`, `city`, `state`, `latitude`, `longitude`, `zip_code`, `phone_number`, `year_built`, `effective_year_built`, `lot_size`, `total_size_of_building`, `is_closed`, `is_business_claimed_by_owner`, `estated_estimated_value`, `units_count`, `stories_count`, `current_owner_name`, `current_owner_address`, `yelp_rating`, `zoning_category`, `zoning_description`, `property_available_for`, `listedOn`, `updatedOn`) VALUES
(114, 'pt_code_113', '2001 Decoto Rd', '2001 Decoto Rd', NULL, NULL, 'b_type_5', 'Convenience Store', 'https://photos.zillowstatic.com/p_h/IS2f4c0vcvb37g1000000000.jpg', NULL, 'Union City', 'CA', 37.587024, -122.022166, 94587, '', 0, 1988, 29087, 510, 0, 0, 2067484, 1, 1, 'NICK GOYAL', '41805 Albrae St, Fremont, CA 94538', 0, 'Commercial', 'Commercial', 'List', NULL, NULL);
INSERT INTO `rw_property_details` (`id`, `property_code`, `property_name`, `property_address`, `property_id`, `property_type`, `business_type_code`, `business_type`, `img_url`, `mls_number`, `city`, `state`, `latitude`, `longitude`, `zip_code`, `phone_number`, `year_built`, `effective_year_built`, `lot_size`, `total_size_of_building`, `is_closed`, `is_business_claimed_by_owner`, `estated_estimated_value`, `units_count`, `stories_count`, `current_owner_name`, `current_owner_address`, `yelp_rating`, `zoning_category`, `zoning_description`, `property_available_for`, `listedOn`, `updatedOn`) VALUES
(115, 'pt_code_114', 'Smart & Final Extra!', '31070 Dyer St', NULL, NULL, 'b_type_5', 'Convenience Store', 'https://lh3.googleusercontent.com/p/AF1QipM0ZzM5hRlxUGCxBL_1uRu8A1r7pM7gdrhgU2o=s1600-w500', NULL, 'Union City', 'CA', 37.60166900000001, -122.068055, 94587, '(510) 475-2633', 2000, 2000, 224694, 68433, 0, 1, 3157253, 3, 1, 'KPDT ENTS LLC', 'PO Box 5211, San Jose, CA 95150', 3.5, 'Commercial', 'Commercial', 'List', NULL, NULL);
INSERT INTO `rw_property_details` (`id`, `property_code`, `property_name`, `property_address`, `property_id`, `property_type`, `business_type_code`, `business_type`, `img_url`, `mls_number`, `city`, `state`, `latitude`, `longitude`, `zip_code`, `phone_number`, `year_built`, `effective_year_built`, `lot_size`, `total_size_of_building`, `is_closed`, `is_business_claimed_by_owner`, `estated_estimated_value`, `units_count`, `stories_count`, `current_owner_name`, `current_owner_address`, `yelp_rating`, `zoning_category`, `zoning_description`, `property_available_for`, `listedOn`, `updatedOn`) VALUES
(12, 'pt_code_12', 'Paranjape Yuthika Apartment', 'Yuthika by Paranjape Schemes', NULL, NULL, 'b_type_9', 'Others', 'https://teja13.kuikr.com/is/a/c/570x430/gallery_images/original/563a415edbfe2.gif', 0, 'Pune', 'MH', 18.5616, 73.771, 411045, '+917559237293', 0, 0, 1000, 0, 0, 0, 0, 0, 0, '', '', 0, '', '', 'Buy', '0000-00-00', '0000-00-00');
INSERT INTO `rw_property_details` (`id`, `property_code`, `property_name`, `property_address`, `property_id`, `property_type`, `business_type_code`, `business_type`, `img_url`, `mls_number`, `city`, `state`, `latitude`, `longitude`, `zip_code`, `phone_number`, `year_built`, `effective_year_built`, `lot_size`, `total_size_of_building`, `is_closed`, `is_business_claimed_by_owner`, `estated_estimated_value`, `units_count`, `stories_count`, `current_owner_name`, `current_owner_address`, `yelp_rating`, `zoning_category`, `zoning_description`, `property_available_for`, `listedOn`, `updatedOn`) VALUES
(13, 'pt_code_13', 'Fremont shell', '33 3rd Ave', 1, NULL, 'b_type_1', 'Restaurants and Food', 'https://photos.zillowstatic.com/p_h/ISe097k43crt4s1000000000.jpg', 3434, 'New York', 'NY', 40.7301, -73.989, 10003, '32343', 0, 0, 34, 0, 0, 0, 0, 0, 0, '', '', 0, '', '', 'Buy', '0000-00-00', '0000-00-00');
INSERT INTO `rw_property_details` (`id`, `property_code`, `property_name`, `property_address`, `property_id`, `property_type`, `business_type_code`, `business_type`, `img_url`, `mls_number`, `city`, `state`, `latitude`, `longitude`, `zip_code`, `phone_number`, `year_built`, `effective_year_built`, `lot_size`, `total_size_of_building`, `is_closed`, `is_business_claimed_by_owner`, `estated_estimated_value`, `units_count`, `stories_count`, `current_owner_name`, `current_owner_address`, `yelp_rating`, `zoning_category`, `zoning_description`, `property_available_for`, `listedOn`, `updatedOn`) VALUES
(14, 'pt_code_14', 'Fremont shell2', '444-446 Massachusetts Ave', 1, NULL, 'b_type_2', 'Gas Station', 'https://capi.myleasestar.com/v2/dimg-crop/17153210/718x429/17153210.jpg', 44, 'Arlington', 'MA', 42.4144, -71.1515, 2474, '4364', 0, 0, 44444, 0, 0, 0, 0, 0, 0, '', '', 0, '', '', 'Buy', '0000-00-00', '0000-00-00');
INSERT INTO `rw_property_details` (`id`, `property_code`, `property_name`, `property_address`, `property_id`, `property_type`, `business_type_code`, `business_type`, `img_url`, `mls_number`, `city`, `state`, `latitude`, `longitude`, `zip_code`, `phone_number`, `year_built`, `effective_year_built`, `lot_size`, `total_size_of_building`, `is_closed`, `is_business_claimed_by_owner`, `estated_estimated_value`, `units_count`, `stories_count`, `current_owner_name`, `current_owner_address`, `yelp_rating`, `zoning_category`, `zoning_description`, `property_available_for`, `listedOn`, `updatedOn`) VALUES
(15, 'pt_code_15', 'shell2', '34077 Paseo Padre Pkwy', 1, NULL, 'b_type_2', 'Gas Station', 'https://capi.myleasestar.com/v2/dimg-crop/17153218/300x438/17153218.jpg', 213123, 'Fremont', 'CA', 37.5761, -122.039, 94555, '21312321', 0, 0, 213213, 0, 0, 0, 0, 0, 0, '', '', 0, '', '', 'Buy', '0000-00-00', '0000-00-00');
INSERT INTO `rw_property_details` (`id`, `property_code`, `property_name`, `property_address`, `property_id`, `property_type`, `business_type_code`, `business_type`, `img_url`, `mls_number`, `city`, `state`, `latitude`, `longitude`, `zip_code`, `phone_number`, `year_built`, `effective_year_built`, `lot_size`, `total_size_of_building`, `is_closed`, `is_business_claimed_by_owner`, `estated_estimated_value`, `units_count`, `stories_count`, `current_owner_name`, `current_owner_address`, `yelp_rating`, `zoning_category`, `zoning_description`, `property_available_for`, `listedOn`, `updatedOn`) VALUES
(16, 'pt_code_16', 'shell gas station', 'Fremont', 1, NULL, 'b_type_2', 'Gas Station', 'https://photos.zillowstatic.com/p_h/IS6qv36ta74ip61000000000.jpg', 234234, 'Fremont', 'CA', 37.5483, -121.989, 0, '9865433', 0, 0, 324324, 0, 0, 0, 0, 0, 0, '', '', 0, '', '', 'Buy', '0000-00-00', '0000-00-00');
INSERT INTO `rw_property_details` (`id`, `property_code`, `property_name`, `property_address`, `property_id`, `property_type`, `business_type_code`, `business_type`, `img_url`, `mls_number`, `city`, `state`, `latitude`, `longitude`, `zip_code`, `phone_number`, `year_built`, `effective_year_built`, `lot_size`, `total_size_of_building`, `is_closed`, `is_business_claimed_by_owner`, `estated_estimated_value`, `units_count`, `stories_count`, `current_owner_name`, `current_owner_address`, `yelp_rating`, `zoning_category`, `zoning_description`, `property_available_for`, `listedOn`, `updatedOn`) VALUES
(17, 'pt_code_17', 'MacD', '34077 Paseo Padre Pkwy', 1, NULL, 'b_type_1', 'Restaurants and Food', 'https://capi.myleasestar.com/v2/dimg-crop/17153218/300x438/17153218.jpg', 88888, 'Fremont', 'CA', 37.5761, -122.039, 94555, '234324', 0, 0, 88888, 0, 0, 0, 0, 0, 0, '', '', 0, '', '', 'Buy', '0000-00-00', '0000-00-00');
INSERT INTO `rw_property_details` (`id`, `property_code`, `property_name`, `property_address`, `property_id`, `property_type`, `business_type_code`, `business_type`, `img_url`, `mls_number`, `city`, `state`, `latitude`, `longitude`, `zip_code`, `phone_number`, `year_built`, `effective_year_built`, `lot_size`, `total_size_of_building`, `is_closed`, `is_business_claimed_by_owner`, `estated_estimated_value`, `units_count`, `stories_count`, `current_owner_name`, `current_owner_address`, `yelp_rating`, `zoning_category`, `zoning_description`, `property_available_for`, `listedOn`, `updatedOn`) VALUES
(19, 'pt_code_18', 'Little by Little', '46164 Warm Springs Blvd', 1, NULL, 'b_type_1', 'Restaurants and Food', 'https://lh3.googleusercontent.com/p/AF1QipNwY-hw2pjziqNELvBo12yiN2ufutiiXYET1Kit=s1600-w500', NULL, 'Fremont', 'CA', 37.4937991, -121.9298339, 94539, '(510) 897-6678', 2010, 2010, 52419, 21724, 0, 1, 986851, 10, 1, 'FREMONT TIMES SQUARE SHOPPING', '', 4, 'Industrial', 'Industrial', 'List', NULL, NULL);
INSERT INTO `rw_property_details` (`id`, `property_code`, `property_name`, `property_address`, `property_id`, `property_type`, `business_type_code`, `business_type`, `img_url`, `mls_number`, `city`, `state`, `latitude`, `longitude`, `zip_code`, `phone_number`, `year_built`, `effective_year_built`, `lot_size`, `total_size_of_building`, `is_closed`, `is_business_claimed_by_owner`, `estated_estimated_value`, `units_count`, `stories_count`, `current_owner_name`, `current_owner_address`, `yelp_rating`, `zoning_category`, `zoning_description`, `property_available_for`, `listedOn`, `updatedOn`) VALUES
(20, 'pt_code_19', 'Bill\'s Cafe', '39222 Fremont Blvd', 1, NULL, 'b_type_1', 'Restaurants and Food', 'https://lh3.googleusercontent.com/p/AF1QipNbEVsmNQL9ehrLw-2sMVv_VOBIPcYd54CApQyw=s1600-w500', NULL, 'Fremont', 'CA', 37.5472184, -121.984945, 94538, '(510) 894-2224', 1972, 1972, 42753, 9341, 0, 1, 1992260, 0, 1, 'FREMONT STATE STREET CENTER LL', '3000 Executive Pkwy Ste 450, San Ramon, CA 94583', 3.5, 'Vacant', 'Vacant', 'List', NULL, NULL);
INSERT INTO `rw_property_details` (`id`, `property_code`, `property_name`, `property_address`, `property_id`, `property_type`, `business_type_code`, `business_type`, `img_url`, `mls_number`, `city`, `state`, `latitude`, `longitude`, `zip_code`, `phone_number`, `year_built`, `effective_year_built`, `lot_size`, `total_size_of_building`, `is_closed`, `is_business_claimed_by_owner`, `estated_estimated_value`, `units_count`, `stories_count`, `current_owner_name`, `current_owner_address`, `yelp_rating`, `zoning_category`, `zoning_description`, `property_available_for`, `listedOn`, `updatedOn`) VALUES
(2, 'pt_code_2', 'Little by Little', '46164 Warm Springs Blvd', 1, NULL, 'b_type_1', 'Restaurants and Food', 'https://photos.zillowstatic.com/p_h/IS2f4c0vcvb37g1000000000.jpg', 1234, 'Fremont', 'CA', 37.4938, -121.93, 94539, '(510) 897-6678', 2010, 2010, 52419, 21724, 0, 1, 986851, 10, 1, 'FREMONT TIMES SQUARE SHOPPING', '', 4, 'Industrial', 'Industrial', 'buy', '0000-00-00', '0000-00-00');
INSERT INTO `rw_property_details` (`id`, `property_code`, `property_name`, `property_address`, `property_id`, `property_type`, `business_type_code`, `business_type`, `img_url`, `mls_number`, `city`, `state`, `latitude`, `longitude`, `zip_code`, `phone_number`, `year_built`, `effective_year_built`, `lot_size`, `total_size_of_building`, `is_closed`, `is_business_claimed_by_owner`, `estated_estimated_value`, `units_count`, `stories_count`, `current_owner_name`, `current_owner_address`, `yelp_rating`, `zoning_category`, `zoning_description`, `property_available_for`, `listedOn`, `updatedOn`) VALUES
(21, 'pt_code_20', 'Ka Yumi', '40645 Fremont Blvd', 1, NULL, 'b_type_1', 'Restaurants and Food', 'https://lh3.googleusercontent.com/p/AF1QipPHzUQfD2FIi0-PE7nygzrMTIWZn-YRx2-1z2FJ=s1600-w500', NULL, 'Fremont', 'CA', 37.5347708, -121.9649559, 94538, '(510) 353-1088', 1959, 1960, 326501, 108501, 0, 1, 15920000, 12, 1, 'ACV FSD FREMONT', '465 1st St W, Sonoma, CA 95476', 4, 'Commercial', 'Commercial', 'List', NULL, NULL);
INSERT INTO `rw_property_details` (`id`, `property_code`, `property_name`, `property_address`, `property_id`, `property_type`, `business_type_code`, `business_type`, `img_url`, `mls_number`, `city`, `state`, `latitude`, `longitude`, `zip_code`, `phone_number`, `year_built`, `effective_year_built`, `lot_size`, `total_size_of_building`, `is_closed`, `is_business_claimed_by_owner`, `estated_estimated_value`, `units_count`, `stories_count`, `current_owner_name`, `current_owner_address`, `yelp_rating`, `zoning_category`, `zoning_description`, `property_available_for`, `listedOn`, `updatedOn`) VALUES
(22, 'pt_code_21', 'Papillon Restaurant', '37296 Mission Blvd', 1, NULL, 'b_type_1', 'Restaurants and Food', 'https://lh3.googleusercontent.com/p/AF1QipM2Y4UzHxlVMeET7rba9cqPIYMXcKs3ap2DHXMS=s1600-w500', NULL, 'Fremont', 'CA', 37.5792069, -121.9797028, 94536, '', 0, 0, 7313, 0, 0, 0, 896, 0, 0, 'BELLINI ARNOLD T & DOREEN', 'PO Box 41, Le Grand, CA 95333', 0, 'Commercial', 'Commercial', 'List', NULL, NULL);
INSERT INTO `rw_property_details` (`id`, `property_code`, `property_name`, `property_address`, `property_id`, `property_type`, `business_type_code`, `business_type`, `img_url`, `mls_number`, `city`, `state`, `latitude`, `longitude`, `zip_code`, `phone_number`, `year_built`, `effective_year_built`, `lot_size`, `total_size_of_building`, `is_closed`, `is_business_claimed_by_owner`, `estated_estimated_value`, `units_count`, `stories_count`, `current_owner_name`, `current_owner_address`, `yelp_rating`, `zoning_category`, `zoning_description`, `property_available_for`, `listedOn`, `updatedOn`) VALUES
(23, 'pt_code_22', 'Country Way', '5325 Mowry Ave', 1, NULL, 'b_type_1', 'Restaurants and Food', 'https://lh3.googleusercontent.com/p/AF1QipOiAdex4NxUs-o17jO7BI61_arSUYFy7rnUgtQj=s1600-w500', NULL, 'Fremont', 'CA', 37.5329603, -122.0015959, 94538, '(510) 797-3188', 0, 1969, 22750, 3970, 0, 0, 1551401, 1, 1, 'MATHEOU THEODOROS P & ELENI T', '5325 Mowry Ave, Fremont, CA 94538', 4, 'Commercial', 'Commercial', 'List', NULL, NULL);
INSERT INTO `rw_property_details` (`id`, `property_code`, `property_name`, `property_address`, `property_id`, `property_type`, `business_type_code`, `business_type`, `img_url`, `mls_number`, `city`, `state`, `latitude`, `longitude`, `zip_code`, `phone_number`, `year_built`, `effective_year_built`, `lot_size`, `total_size_of_building`, `is_closed`, `is_business_claimed_by_owner`, `estated_estimated_value`, `units_count`, `stories_count`, `current_owner_name`, `current_owner_address`, `yelp_rating`, `zoning_category`, `zoning_description`, `property_available_for`, `listedOn`, `updatedOn`) VALUES
(24, 'pt_code_23', 'Cut The Crab', '4949 Stevenson Blvd', 1, NULL, 'b_type_1', 'Restaurants and Food', 'https://lh3.googleusercontent.com/p/AF1QipNUkijt9LZJam--XN6WLCZ0o1HEUXjEkhC6ziA6=s1600-w500', NULL, 'Fremont', 'CA', 37.52957800000001, -121.9833044, 94538, '(510) 573-2264', 1963, 1963, 22610, 22195, 0, 1, 1985022, 14, 1, 'B F PROPERTIES CO & BROOKMAT CORP', '4725 Thornton Ave, Fremont, CA 94536', 3.5, 'Commercial', 'Commercial', 'List', NULL, NULL);
INSERT INTO `rw_property_details` (`id`, `property_code`, `property_name`, `property_address`, `property_id`, `property_type`, `business_type_code`, `business_type`, `img_url`, `mls_number`, `city`, `state`, `latitude`, `longitude`, `zip_code`, `phone_number`, `year_built`, `effective_year_built`, `lot_size`, `total_size_of_building`, `is_closed`, `is_business_claimed_by_owner`, `estated_estimated_value`, `units_count`, `stories_count`, `current_owner_name`, `current_owner_address`, `yelp_rating`, `zoning_category`, `zoning_description`, `property_available_for`, `listedOn`, `updatedOn`) VALUES
(25, 'pt_code_24', 'Shell', '40500 Fremont Blvd', 1, NULL, 'b_type_2', 'Gas Station', 'https://lh3.googleusercontent.com/p/AF1QipMN63NsBD3F6vx65-jgsHg9taW3UZFaaUVdebnR=s1600-w500', NULL, 'Fremont', 'CA', 37.5370686, -121.965889, 94538, '(510) 490-0810', 0, 1987, 11484, 2400, 0, 0, 1711622, 1, 1, 'TESORO SIERRA PROPERTIES LLC', 'PO Box 592809, San Antonio, TX 78259', 3.5, 'Commercial', 'Commercial', 'List', NULL, NULL);
INSERT INTO `rw_property_details` (`id`, `property_code`, `property_name`, `property_address`, `property_id`, `property_type`, `business_type_code`, `business_type`, `img_url`, `mls_number`, `city`, `state`, `latitude`, `longitude`, `zip_code`, `phone_number`, `year_built`, `effective_year_built`, `lot_size`, `total_size_of_building`, `is_closed`, `is_business_claimed_by_owner`, `estated_estimated_value`, `units_count`, `stories_count`, `current_owner_name`, `current_owner_address`, `yelp_rating`, `zoning_category`, `zoning_description`, `property_available_for`, `listedOn`, `updatedOn`) VALUES
(26, 'pt_code_25', 'Chevron', '39707 Paseo Padre Pkwy', 1, NULL, 'b_type_2', 'Gas Station', 'https://lh3.googleusercontent.com/p/AF1QipMOaw-EYRywOqs8aiqZh7q0H7Gtb_FDoUxML2zi=s1600-w500', NULL, 'Fremont', 'CA', 37.5481168, -121.9715576, 94538, '(510) 651-6334', 1971, 1971, 34368, 2185, 0, 0, 1507200, 1, 1, 'GAMCH ERLINDA (TE)', '862 Chateau Heights Ct, Pleasanton, CA 94566', 3, 'Commercial', 'Commercial', 'List', NULL, NULL);
INSERT INTO `rw_property_details` (`id`, `property_code`, `property_name`, `property_address`, `property_id`, `property_type`, `business_type_code`, `business_type`, `img_url`, `mls_number`, `city`, `state`, `latitude`, `longitude`, `zip_code`, `phone_number`, `year_built`, `effective_year_built`, `lot_size`, `total_size_of_building`, `is_closed`, `is_business_claimed_by_owner`, `estated_estimated_value`, `units_count`, `stories_count`, `current_owner_name`, `current_owner_address`, `yelp_rating`, `zoning_category`, `zoning_description`, `property_available_for`, `listedOn`, `updatedOn`) VALUES
(27, 'pt_code_26', 'Hub Valero', '4004 Mowry Ave', 1, NULL, 'b_type_2', 'Gas Station', 'https://lh3.googleusercontent.com/p/AF1QipMIikkDqnSfN56SBJkrfWdmT2Y-InQLVVI4-e-O=s1600-w500', NULL, 'Fremont', 'CA', 37.5478953, -121.9881983, 94538, '', 2005, 2005, 26360, 1775, 0, 0, 3417176, 0, 1, 'OLYAIE FAMILY TRUST', '1244 Tolteca Ct, Fremont, CA 94539', 0, 'Commercial', 'Commercial', 'List', NULL, NULL);
INSERT INTO `rw_property_details` (`id`, `property_code`, `property_name`, `property_address`, `property_id`, `property_type`, `business_type_code`, `business_type`, `img_url`, `mls_number`, `city`, `state`, `latitude`, `longitude`, `zip_code`, `phone_number`, `year_built`, `effective_year_built`, `lot_size`, `total_size_of_building`, `is_closed`, `is_business_claimed_by_owner`, `estated_estimated_value`, `units_count`, `stories_count`, `current_owner_name`, `current_owner_address`, `yelp_rating`, `zoning_category`, `zoning_description`, `property_available_for`, `listedOn`, `updatedOn`) VALUES
(28, 'pt_code_27', 'ampm', '5012 Stevenson Blvd', 1, NULL, 'b_type_2', 'Gas Station', 'https://lh3.googleusercontent.com/p/AF1QipMb8zYd4rhz66l6edWK8Fsj9wqmR7Eg0xYlwUR4=s1600-w500', NULL, 'Fremont', 'CA', 37.5277759, -121.9827517, 94538, '(510) 687-1877', 2008, 2009, 28009, 2856, 0, 1, 4856710, 1, 1, 'NEW ERA BUSINESS VENTURES INC', '5012 Stevenson Blvd, Fremont, CA 94538', 3, 'Commercial', 'Commercial', 'List', NULL, NULL);
INSERT INTO `rw_property_details` (`id`, `property_code`, `property_name`, `property_address`, `property_id`, `property_type`, `business_type_code`, `business_type`, `img_url`, `mls_number`, `city`, `state`, `latitude`, `longitude`, `zip_code`, `phone_number`, `year_built`, `effective_year_built`, `lot_size`, `total_size_of_building`, `is_closed`, `is_business_claimed_by_owner`, `estated_estimated_value`, `units_count`, `stories_count`, `current_owner_name`, `current_owner_address`, `yelp_rating`, `zoning_category`, `zoning_description`, `property_available_for`, `listedOn`, `updatedOn`) VALUES
(29, 'pt_code_28', '76', '4190 Mowry Ave', 1, NULL, 'b_type_2', 'Gas Station', 'https://lh3.googleusercontent.com/p/AF1QipM34ergsW8kJ2zN6ZWJSTabWdVlzxocDRQ5M0WV=s1600-w500', NULL, 'Fremont', 'CA', 37.5455236, -121.9901896, 94538, '(510) 796-1203', 1962, 1963, 22500, 0, 0, 1, 2027051, 1, 1, 'MAX PETROLEUM INC', '4190 Mowry Ave, Fremont, CA 94538', 3, 'Commercial', 'Commercial', 'List', NULL, NULL);
INSERT INTO `rw_property_details` (`id`, `property_code`, `property_name`, `property_address`, `property_id`, `property_type`, `business_type_code`, `business_type`, `img_url`, `mls_number`, `city`, `state`, `latitude`, `longitude`, `zip_code`, `phone_number`, `year_built`, `effective_year_built`, `lot_size`, `total_size_of_building`, `is_closed`, `is_business_claimed_by_owner`, `estated_estimated_value`, `units_count`, `stories_count`, `current_owner_name`, `current_owner_address`, `yelp_rating`, `zoning_category`, `zoning_description`, `property_available_for`, `listedOn`, `updatedOn`) VALUES
(30, 'pt_code_29', 'Chevron', '46050 Fremont Blvd', 1, NULL, 'b_type_2', 'Gas Station', 'https://lh3.googleusercontent.com/p/AF1QipNATkYqMOsgUtVqEW4lYZ3RPDmelxxBDDmfzIdp=s1600-w500', NULL, 'Fremont', 'CA', 37.4903954, -121.947818, 94538, '(510) 651-6334', 2001, 2002, 46566, 2516, 0, 0, 4289378, 1, 1, 'AJAY ENTS LP', '39150 Fremont Blvd, Fremont, CA 94538', 3, 'Commercial', 'Commercial', 'List', NULL, NULL);
INSERT INTO `rw_property_details` (`id`, `property_code`, `property_name`, `property_address`, `property_id`, `property_type`, `business_type_code`, `business_type`, `img_url`, `mls_number`, `city`, `state`, `latitude`, `longitude`, `zip_code`, `phone_number`, `year_built`, `effective_year_built`, `lot_size`, `total_size_of_building`, `is_closed`, `is_business_claimed_by_owner`, `estated_estimated_value`, `units_count`, `stories_count`, `current_owner_name`, `current_owner_address`, `yelp_rating`, `zoning_category`, `zoning_description`, `property_available_for`, `listedOn`, `updatedOn`) VALUES
(3, 'pt_code_3', 'Bill\'s Cafe', '39222 Fremont Blvd', 1, NULL, 'b_type_1', 'Restaurants and Food', 'https://photos.zillowstatic.com/p_h/IS2f4c0vcvb37g1000000000.jpg', 0, 'Fremont', 'CA', 37.5472, -121.985, 94538, '(510) 894-2224', 1972, 1972, 42753, 9341, 0, 1, 1992260, 0, 1, 'FREMONT STATE STREET CENTER LL', '3000 Executive Pkwy Ste 450, San Ramon, CA 94583', 4, 'Vacant', 'Vacant', 'buy', '0000-00-00', '0000-00-00');
INSERT INTO `rw_property_details` (`id`, `property_code`, `property_name`, `property_address`, `property_id`, `property_type`, `business_type_code`, `business_type`, `img_url`, `mls_number`, `city`, `state`, `latitude`, `longitude`, `zip_code`, `phone_number`, `year_built`, `effective_year_built`, `lot_size`, `total_size_of_building`, `is_closed`, `is_business_claimed_by_owner`, `estated_estimated_value`, `units_count`, `stories_count`, `current_owner_name`, `current_owner_address`, `yelp_rating`, `zoning_category`, `zoning_description`, `property_available_for`, `listedOn`, `updatedOn`) VALUES
(31, 'pt_code_30', 'Shell', '42816 Mission Blvd', 1, NULL, 'b_type_2', 'Gas Station', 'https://lh3.googleusercontent.com/p/AF1QipPA5gzPOoWWlCG61ODvPctACZNk2QEgBSQgAJ_O=s1600-w500', NULL, 'Fremont', 'CA', 37.5390851, -121.9230251, 94539, '(510) 490-0810', 1991, 1992, 12509, 1000, 0, 0, 1821772, 1, 1, '42816 MISSION BLVD LLC', '42816 Mission Blvd, Fremont, CA 94539', 3.5, 'Commercial', 'Commercial', 'List', NULL, NULL);
INSERT INTO `rw_property_details` (`id`, `property_code`, `property_name`, `property_address`, `property_id`, `property_type`, `business_type_code`, `business_type`, `img_url`, `mls_number`, `city`, `state`, `latitude`, `longitude`, `zip_code`, `phone_number`, `year_built`, `effective_year_built`, `lot_size`, `total_size_of_building`, `is_closed`, `is_business_claimed_by_owner`, `estated_estimated_value`, `units_count`, `stories_count`, `current_owner_name`, `current_owner_address`, `yelp_rating`, `zoning_category`, `zoning_description`, `property_available_for`, `listedOn`, `updatedOn`) VALUES
(32, 'pt_code_31', 'MyGoods Market', '2950 Auto Mall Pkwy', 1, NULL, 'b_type_2', 'Gas Station', 'https://lh3.googleusercontent.com/p/AF1QipMPLfO3uyVPnecuSFBGA-TtyhN-fJdr8b473wyJ=s1600-w500', NULL, 'Fremont', 'CA', 37.5133058, -121.9415782, 94538, '', 1995, 1996, 103571, 3549, 0, 0, 5740502, 1, 1, 'CONVENIENCE RETAILERS LLC', '7180 Koll Center Pkwy # 100, Pleasanton, CA 94566', 0, 'Commercial', 'Commercial', 'List', NULL, NULL);
INSERT INTO `rw_property_details` (`id`, `property_code`, `property_name`, `property_address`, `property_id`, `property_type`, `business_type_code`, `business_type`, `img_url`, `mls_number`, `city`, `state`, `latitude`, `longitude`, `zip_code`, `phone_number`, `year_built`, `effective_year_built`, `lot_size`, `total_size_of_building`, `is_closed`, `is_business_claimed_by_owner`, `estated_estimated_value`, `units_count`, `stories_count`, `current_owner_name`, `current_owner_address`, `yelp_rating`, `zoning_category`, `zoning_description`, `property_available_for`, `listedOn`, `updatedOn`) VALUES
(33, 'pt_code_32', 'Arco', '40077 Mission Blvd', 1, NULL, 'b_type_2', 'Gas Station', 'https://lh3.googleusercontent.com/p/AF1QipMU1UwdSp6IZVj8v6lZKQq7FypF_Bva7ozNUMo2=s1600-w500', NULL, 'Fremont', 'CA', 37.5565643, -121.9508738, 94539, '(510) 687-1877', 1973, 1973, 22854, 1664, 0, 1, 855571, 1, 1, 'BP WEST COAST PRODUCTS LLC', 'PO Box 5015, Buena Park, CA 90622', 3, 'Commercial', 'Commercial', 'List', NULL, NULL);
INSERT INTO `rw_property_details` (`id`, `property_code`, `property_name`, `property_address`, `property_id`, `property_type`, `business_type_code`, `business_type`, `img_url`, `mls_number`, `city`, `state`, `latitude`, `longitude`, `zip_code`, `phone_number`, `year_built`, `effective_year_built`, `lot_size`, `total_size_of_building`, `is_closed`, `is_business_claimed_by_owner`, `estated_estimated_value`, `units_count`, `stories_count`, `current_owner_name`, `current_owner_address`, `yelp_rating`, `zoning_category`, `zoning_description`, `property_available_for`, `listedOn`, `updatedOn`) VALUES
(34, 'pt_code_33', 'Chevron', '43455 Mission Blvd', 1, NULL, 'b_type_2', 'Gas Station', 'https://lh3.googleusercontent.com/p/AF1QipMfoHbADmB5JWFRq3GA-_N-ARQ7kbOfveza09Mv=s1600-w500', NULL, 'Fremont', 'CA', 37.5308962, -121.9196883, 94539, '(510) 651-6334', 1927, 1930, 26000, 1842, 0, 0, 266331, 2, 1, 'GARG FAMILY TRUST', '105 Hickory Ct, Danville, CA 94506', 3, 'Commercial', 'Commercial', 'List', NULL, NULL);
INSERT INTO `rw_property_details` (`id`, `property_code`, `property_name`, `property_address`, `property_id`, `property_type`, `business_type_code`, `business_type`, `img_url`, `mls_number`, `city`, `state`, `latitude`, `longitude`, `zip_code`, `phone_number`, `year_built`, `effective_year_built`, `lot_size`, `total_size_of_building`, `is_closed`, `is_business_claimed_by_owner`, `estated_estimated_value`, `units_count`, `stories_count`, `current_owner_name`, `current_owner_address`, `yelp_rating`, `zoning_category`, `zoning_description`, `property_available_for`, `listedOn`, `updatedOn`) VALUES
(35, 'pt_code_34', '7-Eleven', '35015 Fremont Blvd', 1, NULL, 'b_type_2', 'Gas Station', 'https://lh3.googleusercontent.com/p/AF1QipPd1aAq4QJZzH7Ol7oRh-_g2FmuXD1WYIw4ost7=s1600-w500', NULL, 'Fremont', 'CA', 37.5701821, -122.0323296, 94536, '(510) 792-7111', 0, 0, 11500, 0, 0, 1, 203588, 0, 0, 'SEJ ASSET MANAGEMENT & INVESTMENT CO', '1722 Routh St Ste 1000, Dallas, TX 75201', 2, 'Commercial', 'Commercial', 'List', NULL, NULL);
INSERT INTO `rw_property_details` (`id`, `property_code`, `property_name`, `property_address`, `property_id`, `property_type`, `business_type_code`, `business_type`, `img_url`, `mls_number`, `city`, `state`, `latitude`, `longitude`, `zip_code`, `phone_number`, `year_built`, `effective_year_built`, `lot_size`, `total_size_of_building`, `is_closed`, `is_business_claimed_by_owner`, `estated_estimated_value`, `units_count`, `stories_count`, `current_owner_name`, `current_owner_address`, `yelp_rating`, `zoning_category`, `zoning_description`, `property_available_for`, `listedOn`, `updatedOn`) VALUES
(36, 'pt_code_35', '76', '34867 Ardenwood Blvd', 1, NULL, 'b_type_2', 'Gas Station', 'https://lh3.googleusercontent.com/p/AF1QipNeve-BQGiJ9EDrN-IA67h_n1EOslQpKV0898pl=s1600-w500', NULL, 'Fremont', 'CA', 37.5523394, -122.0539365, 94555, '(510) 796-1203', 1996, 1996, 53146, 672, 0, 1, 3883390, 1, 1, 'CONVENIENCE RETAILERS LLC', '34867 Ardenwood Blvd, Fremont, CA 94555', 3, 'Commercial', 'Commercial', 'List', NULL, NULL);
INSERT INTO `rw_property_details` (`id`, `property_code`, `property_name`, `property_address`, `property_id`, `property_type`, `business_type_code`, `business_type`, `img_url`, `mls_number`, `city`, `state`, `latitude`, `longitude`, `zip_code`, `phone_number`, `year_built`, `effective_year_built`, `lot_size`, `total_size_of_building`, `is_closed`, `is_business_claimed_by_owner`, `estated_estimated_value`, `units_count`, `stories_count`, `current_owner_name`, `current_owner_address`, `yelp_rating`, `zoning_category`, `zoning_description`, `property_available_for`, `listedOn`, `updatedOn`) VALUES
(37, 'pt_code_36', 'Chevron', '37011 Fremont Blvd', 1, NULL, 'b_type_2', 'Gas Station', 'https://lh3.googleusercontent.com/p/AF1QipMiMx3GP2bxfdm-EOfWAObhm8ymAOhl9GGnLili=s1600-w500', NULL, 'Fremont', 'CA', 37.56013, -122.011587, 94536, '(510) 651-6334', 1995, 1995, 17210, 22880, 0, 0, 195616, 0, 1, 'WALLACE JOYCE', '38636 Kimbro St, Fremont, CA 94536', 3, 'Commercial', 'Commercial', 'List', NULL, NULL);
INSERT INTO `rw_property_details` (`id`, `property_code`, `property_name`, `property_address`, `property_id`, `property_type`, `business_type_code`, `business_type`, `img_url`, `mls_number`, `city`, `state`, `latitude`, `longitude`, `zip_code`, `phone_number`, `year_built`, `effective_year_built`, `lot_size`, `total_size_of_building`, `is_closed`, `is_business_claimed_by_owner`, `estated_estimated_value`, `units_count`, `stories_count`, `current_owner_name`, `current_owner_address`, `yelp_rating`, `zoning_category`, `zoning_description`, `property_available_for`, `listedOn`, `updatedOn`) VALUES
(38, 'pt_code_37', 'Arco', '36974 Fremont Blvd', 1, NULL, 'b_type_2', 'Gas Station', 'https://s3-media1.fl.yelpcdn.com/bphoto/qBdONgB9_gda0ewv2yOKmg/o.jpg', NULL, 'Fremont', 'CA', 37.561096, -122.011748, 94536, '(510) 713-7814', 0, 1986, 15000, 1908, 0, 0, 416989, 0, 1, 'LAGORIO PARTNERS', '15866 28 Mile Rd, Oakdale, CA 95361', 2.5, 'Commercial', 'Commercial', 'List', NULL, NULL);
INSERT INTO `rw_property_details` (`id`, `property_code`, `property_name`, `property_address`, `property_id`, `property_type`, `business_type_code`, `business_type`, `img_url`, `mls_number`, `city`, `state`, `latitude`, `longitude`, `zip_code`, `phone_number`, `year_built`, `effective_year_built`, `lot_size`, `total_size_of_building`, `is_closed`, `is_business_claimed_by_owner`, `estated_estimated_value`, `units_count`, `stories_count`, `current_owner_name`, `current_owner_address`, `yelp_rating`, `zoning_category`, `zoning_description`, `property_available_for`, `listedOn`, `updatedOn`) VALUES
(39, 'pt_code_38', 'Valero', '46494 Mission Blvd', 1, NULL, 'b_type_2', 'Gas Station', 'https://lh3.googleusercontent.com/p/AF1QipOh6IR-8uenps-R7JvFLZBhvzVclsN87pYHSYmG=s1600-w500', NULL, 'Fremont', 'CA', 37.49225879999999, -121.9262211, 94539, '(510) 794-7772', 0, 0, 8052, 0, 0, 0, 75572, 0, 0, 'SOE GARWIN B', '1630 Riviera Ave, Walnut Creek, CA 94596', 2, 'Commercial', 'Commercial', 'List', NULL, NULL);
INSERT INTO `rw_property_details` (`id`, `property_code`, `property_name`, `property_address`, `property_id`, `property_type`, `business_type_code`, `business_type`, `img_url`, `mls_number`, `city`, `state`, `latitude`, `longitude`, `zip_code`, `phone_number`, `year_built`, `effective_year_built`, `lot_size`, `total_size_of_building`, `is_closed`, `is_business_claimed_by_owner`, `estated_estimated_value`, `units_count`, `stories_count`, `current_owner_name`, `current_owner_address`, `yelp_rating`, `zoning_category`, `zoning_description`, `property_available_for`, `listedOn`, `updatedOn`) VALUES
(40, 'pt_code_39', 'Andy\'s Valero Gas & Service Center', '39990 Fremont Blvd', 1, NULL, 'b_type_2', 'Gas Station', 'https://lh3.googleusercontent.com/p/AF1QipO4QHmXW6FCblpBoDlUAPjcLs4jjQAeAkWBXMWF=s1600-w500', NULL, 'Fremont', 'CA', 37.54135309999999, -121.9732812, 94538, '(510) 651-3782', 0, 1971, 31795, 2601, 0, 1, 2377166, 0, 1, 'SHAHKARAMI ANDRANIK', '39990 Fremont Blvd, Fremont, CA 94538', 4.5, 'Commercial', 'Commercial', 'List', NULL, NULL);
INSERT INTO `rw_property_details` (`id`, `property_code`, `property_name`, `property_address`, `property_id`, `property_type`, `business_type_code`, `business_type`, `img_url`, `mls_number`, `city`, `state`, `latitude`, `longitude`, `zip_code`, `phone_number`, `year_built`, `effective_year_built`, `lot_size`, `total_size_of_building`, `is_closed`, `is_business_claimed_by_owner`, `estated_estimated_value`, `units_count`, `stories_count`, `current_owner_name`, `current_owner_address`, `yelp_rating`, `zoning_category`, `zoning_description`, `property_available_for`, `listedOn`, `updatedOn`) VALUES
(4, 'pt_code_4', 'parkview', '3333 Market St', NULL, NULL, 'b_type_9', 'Others', 'https://photos.zillowstatic.com/p_h/IS2f4c0vcvb37g1000000000.jpg', 0, '', '', 0, 0, 0, '', 0, 0, 0, 0, 0, 0, 0, 0, 0, '', '', 0, '', '', 'buy', '0000-00-00', '0000-00-00');
INSERT INTO `rw_property_details` (`id`, `property_code`, `property_name`, `property_address`, `property_id`, `property_type`, `business_type_code`, `business_type`, `img_url`, `mls_number`, `city`, `state`, `latitude`, `longitude`, `zip_code`, `phone_number`, `year_built`, `effective_year_built`, `lot_size`, `total_size_of_building`, `is_closed`, `is_business_claimed_by_owner`, `estated_estimated_value`, `units_count`, `stories_count`, `current_owner_name`, `current_owner_address`, `yelp_rating`, `zoning_category`, `zoning_description`, `property_available_for`, `listedOn`, `updatedOn`) VALUES
(41, 'pt_code_40', 'Fremont Gas & Food', '43250 Grimmer Blvd', 1, NULL, 'b_type_2', 'Gas Station', 'https://lh3.googleusercontent.com/p/AF1QipPZKqc25XW-3vlWtYzPMC2knvtYRVAidAp0KlRz=s1600-w500', NULL, 'Fremont', 'CA', 37.5134852, -121.9649299, 94538, '', 1968, 1968, 26104, 1600, 0, 0, 2273727, 0, 1, 'LUTHRA FAMILY TRUST', '', 0, 'Commercial', 'Commercial', 'List', NULL, NULL);
INSERT INTO `rw_property_details` (`id`, `property_code`, `property_name`, `property_address`, `property_id`, `property_type`, `business_type_code`, `business_type`, `img_url`, `mls_number`, `city`, `state`, `latitude`, `longitude`, `zip_code`, `phone_number`, `year_built`, `effective_year_built`, `lot_size`, `total_size_of_building`, `is_closed`, `is_business_claimed_by_owner`, `estated_estimated_value`, `units_count`, `stories_count`, `current_owner_name`, `current_owner_address`, `yelp_rating`, `zoning_category`, `zoning_description`, `property_available_for`, `listedOn`, `updatedOn`) VALUES
(42, 'pt_code_41', 'Valero', '47700 Warm Springs Blvd', 1, NULL, 'b_type_2', 'Gas Station', 'https://s3-media2.fl.yelpcdn.com/bphoto/QTvaKD66xs4wJ5idEGE-DQ/o.jpg', NULL, 'Fremont', 'CA', 37.477407, -121.921925, 94539, '(661) 325-6320', 1969, 1969, 19527, 1612, 0, 0, 1631205, 0, 1, 'DAVEN LOOMBA', '1269 Hong Kong Dr, San Jose, CA 95131', 3, 'Commercial', 'Commercial', 'List', NULL, NULL);
INSERT INTO `rw_property_details` (`id`, `property_code`, `property_name`, `property_address`, `property_id`, `property_type`, `business_type_code`, `business_type`, `img_url`, `mls_number`, `city`, `state`, `latitude`, `longitude`, `zip_code`, `phone_number`, `year_built`, `effective_year_built`, `lot_size`, `total_size_of_building`, `is_closed`, `is_business_claimed_by_owner`, `estated_estimated_value`, `units_count`, `stories_count`, `current_owner_name`, `current_owner_address`, `yelp_rating`, `zoning_category`, `zoning_description`, `property_available_for`, `listedOn`, `updatedOn`) VALUES
(43, 'pt_code_42', 'Good Nite Inn', '4135 Cushing Pkwy', NULL, NULL, 'b_type_9', 'Others', 'https://lh3.googleusercontent.com/p/AF1QipPA15MaF4yZWb8fFRbPnXakAZT0ZoZ_go25NUBV=s1600-w500', NULL, 'Fremont', 'CA', 37.4918133, -121.9503329, 94538, '(510) 656-9307', 1991, 1992, 91884, 45187, 0, 1, 5070320, 120, 3, 'GOOD NITE INN FREMONT INC', '11500 W Olympic Blvd Ste 345, Los Angeles, CA 90064', 3, 'Commercial', 'Commercial', 'List', NULL, NULL);
INSERT INTO `rw_property_details` (`id`, `property_code`, `property_name`, `property_address`, `property_id`, `property_type`, `business_type_code`, `business_type`, `img_url`, `mls_number`, `city`, `state`, `latitude`, `longitude`, `zip_code`, `phone_number`, `year_built`, `effective_year_built`, `lot_size`, `total_size_of_building`, `is_closed`, `is_business_claimed_by_owner`, `estated_estimated_value`, `units_count`, `stories_count`, `current_owner_name`, `current_owner_address`, `yelp_rating`, `zoning_category`, `zoning_description`, `property_available_for`, `listedOn`, `updatedOn`) VALUES
(44, 'pt_code_43', 'Days Inn by Wyndham Fremont', '46101 Warm Springs Blvd', NULL, NULL, 'b_type_9', 'Others', 'https://lh3.googleusercontent.com/p/AF1QipP3nBRCxPkytVW6YBsct8UxJ84p9-ojvdELpp-V=s1600-w338', NULL, 'Fremont', 'CA', 37.4937114, -121.9321288, 94539, '(800) 329-1073', 1992, 1992, 32200, 20361, 0, 1, 2595323, 49, 3, 'JAI SHREE KRISHNA LLC', '1156 Tanglewood Way, San Mateo, CA 94403', 1.5, 'Commercial', 'Commercial', 'List', NULL, NULL);
INSERT INTO `rw_property_details` (`id`, `property_code`, `property_name`, `property_address`, `property_id`, `property_type`, `business_type_code`, `business_type`, `img_url`, `mls_number`, `city`, `state`, `latitude`, `longitude`, `zip_code`, `phone_number`, `year_built`, `effective_year_built`, `lot_size`, `total_size_of_building`, `is_closed`, `is_business_claimed_by_owner`, `estated_estimated_value`, `units_count`, `stories_count`, `current_owner_name`, `current_owner_address`, `yelp_rating`, `zoning_category`, `zoning_description`, `property_available_for`, `listedOn`, `updatedOn`) VALUES
(45, 'pt_code_44', 'Extended Stay America - Fremont - Fremont Blvd. South', '46080 Fremont Blvd', NULL, NULL, 'b_type_9', 'Others', 'https://lh3.googleusercontent.com/p/AF1QipODdfz6FmRCTt3dCzi9NOIkiBJAhvf5cA_Ra539=s1600-w500', NULL, 'Fremont', 'CA', 37.490283, -121.946991, 94538, '(800) 804-3724', 1999, 1999, 115312, 58489, 0, 1, 8499953, 128, 3, 'BRE HV PROPERTIES LLC', 'PO Box 49550, Charlotte, NC 28277', 1.5, 'Commercial', 'Commercial', 'List', NULL, NULL);
INSERT INTO `rw_property_details` (`id`, `property_code`, `property_name`, `property_address`, `property_id`, `property_type`, `business_type_code`, `business_type`, `img_url`, `mls_number`, `city`, `state`, `latitude`, `longitude`, `zip_code`, `phone_number`, `year_built`, `effective_year_built`, `lot_size`, `total_size_of_building`, `is_closed`, `is_business_claimed_by_owner`, `estated_estimated_value`, `units_count`, `stories_count`, `current_owner_name`, `current_owner_address`, `yelp_rating`, `zoning_category`, `zoning_description`, `property_available_for`, `listedOn`, `updatedOn`) VALUES
(46, 'pt_code_45', 'Best Western Plus Garden Court Inn', '5400 Mowry Ave', NULL, NULL, 'b_type_9', 'Others', 'https://lh3.googleusercontent.com/p/AF1QipNpmzU32ta7jzBh1iu-Gtnt1tL2Eqxl6FLgrjFX=s1600-w500', NULL, 'Fremont', 'CA', 37.5324355, -121.9999217, 94538, '(510) 792-4300', 1975, 1975, 223485, 63564, 0, 1, 5599110, 126, 3, 'THUNDERBIRD LODGE FREMONT', '5400 Mowry Ave, Fremont, CA 94538', 3.5, 'Commercial', 'Commercial', 'List', NULL, NULL);
INSERT INTO `rw_property_details` (`id`, `property_code`, `property_name`, `property_address`, `property_id`, `property_type`, `business_type_code`, `business_type`, `img_url`, `mls_number`, `city`, `state`, `latitude`, `longitude`, `zip_code`, `phone_number`, `year_built`, `effective_year_built`, `lot_size`, `total_size_of_building`, `is_closed`, `is_business_claimed_by_owner`, `estated_estimated_value`, `units_count`, `stories_count`, `current_owner_name`, `current_owner_address`, `yelp_rating`, `zoning_category`, `zoning_description`, `property_available_for`, `listedOn`, `updatedOn`) VALUES
(47, 'pt_code_46', 'Mission Peak Lodge', '43643 Mission Blvd', NULL, NULL, 'b_type_9', 'Others', 'https://lh3.googleusercontent.com/p/AF1QipPlGDniI0D7R-mDqpKf1LE7I_63oAPTpelJF3d3=s1600-w500', NULL, 'Fremont', 'CA', 37.5271184, -121.9187431, 94539, '(510) 656-2366', 2002, 2002, 35325, 16090, 0, 1, 4538462, 40, 2, 'KAPADIA JAY & KIRAN', '', 2.5, 'Commercial', 'Commercial', 'List', NULL, NULL);
INSERT INTO `rw_property_details` (`id`, `property_code`, `property_name`, `property_address`, `property_id`, `property_type`, `business_type_code`, `business_type`, `img_url`, `mls_number`, `city`, `state`, `latitude`, `longitude`, `zip_code`, `phone_number`, `year_built`, `effective_year_built`, `lot_size`, `total_size_of_building`, `is_closed`, `is_business_claimed_by_owner`, `estated_estimated_value`, `units_count`, `stories_count`, `current_owner_name`, `current_owner_address`, `yelp_rating`, `zoning_category`, `zoning_description`, `property_available_for`, `listedOn`, `updatedOn`) VALUES
(48, 'pt_code_47', 'La Quinta Inn & Suites Fremont / Silicon Valley', '46200 Landing Pkwy', NULL, NULL, 'b_type_9', 'Others', 'https://lh3.googleusercontent.com/p/AF1QipP_858CtPiz1Wm--5kr8Xgi83u4Q8dFizBVow8a=s1600-w500', NULL, 'Fremont', 'CA', 37.489604, -121.9456821, 94538, '(510) 445-0808', 1999, 1999, 110562, 76847, 0, 1, 13749660, 148, 5, 'BRE LQ PROPERTIES LLC', '909 Hidden Rdg Ste 600, Irving, TX 75038', 3, 'Commercial', 'Commercial', 'List', NULL, NULL);
INSERT INTO `rw_property_details` (`id`, `property_code`, `property_name`, `property_address`, `property_id`, `property_type`, `business_type_code`, `business_type`, `img_url`, `mls_number`, `city`, `state`, `latitude`, `longitude`, `zip_code`, `phone_number`, `year_built`, `effective_year_built`, `lot_size`, `total_size_of_building`, `is_closed`, `is_business_claimed_by_owner`, `estated_estimated_value`, `units_count`, `stories_count`, `current_owner_name`, `current_owner_address`, `yelp_rating`, `zoning_category`, `zoning_description`, `property_available_for`, `listedOn`, `updatedOn`) VALUES
(49, 'pt_code_48', 'Comfort Inn Silicon Valley East', '47031 Kato Rd', NULL, NULL, 'b_type_9', 'Others', 'https://lh3.googleusercontent.com/p/AF1QipMMtOnJJE9GpovyCXwB1rnJOwogvHDsvXkLDoUl=s1600-w500', NULL, 'Fremont', 'CA', 37.484722, -121.933281, 94538, '(510) 490-2900', 1987, 1987, 100963, 55814, 0, 1, 13594864, 0, 3, 'PREMIER BAY INVESTMENT LLC', '47031 Kato Rd, Fremont, CA 94538', 2.5, 'Commercial', 'Commercial', 'List', NULL, NULL);
INSERT INTO `rw_property_details` (`id`, `property_code`, `property_name`, `property_address`, `property_id`, `property_type`, `business_type_code`, `business_type`, `img_url`, `mls_number`, `city`, `state`, `latitude`, `longitude`, `zip_code`, `phone_number`, `year_built`, `effective_year_built`, `lot_size`, `total_size_of_building`, `is_closed`, `is_business_claimed_by_owner`, `estated_estimated_value`, `units_count`, `stories_count`, `current_owner_name`, `current_owner_address`, `yelp_rating`, `zoning_category`, `zoning_description`, `property_available_for`, `listedOn`, `updatedOn`) VALUES
(50, 'pt_code_49', 'Cork n Bottle Liquors', '5200 Mowry Ave', NULL, NULL, 'b_type_3', 'Liquor Store', 'https://lh3.googleusercontent.com/p/AF1QipMJFNGfMKDp21nKRhEmnCfwnphX_ESblolS3GjN=s1600-w500', NULL, 'Fremont', 'CA', 37.5333437, -121.9996011, 94538, '', 0, 1976, 198198, 44364, 0, 0, 2642831, 13, 1, 'STEVENSON ENTS', '121 Wildwood Gdns, Piedmont, CA 94611', 0, 'Commercial', 'Commercial', 'List', NULL, NULL);
INSERT INTO `rw_property_details` (`id`, `property_code`, `property_name`, `property_address`, `property_id`, `property_type`, `business_type_code`, `business_type`, `img_url`, `mls_number`, `city`, `state`, `latitude`, `longitude`, `zip_code`, `phone_number`, `year_built`, `effective_year_built`, `lot_size`, `total_size_of_building`, `is_closed`, `is_business_claimed_by_owner`, `estated_estimated_value`, `units_count`, `stories_count`, `current_owner_name`, `current_owner_address`, `yelp_rating`, `zoning_category`, `zoning_description`, `property_available_for`, `listedOn`, `updatedOn`) VALUES
(5, 'pt_code_5', 'New park mall', '23232 S Figueroa St', NULL, NULL, 'b_type_9', 'Others', 'https://photos.zillowstatic.com/p_h/IS2f4c0vcvb37g1000000000.jpg', 0, '', '', 0, 0, 0, '', 0, 0, 0, 0, 0, 0, 0, 0, 0, '', '', 0, '', '', 'Lease', '0000-00-00', '0000-00-00');
INSERT INTO `rw_property_details` (`id`, `property_code`, `property_name`, `property_address`, `property_id`, `property_type`, `business_type_code`, `business_type`, `img_url`, `mls_number`, `city`, `state`, `latitude`, `longitude`, `zip_code`, `phone_number`, `year_built`, `effective_year_built`, `lot_size`, `total_size_of_building`, `is_closed`, `is_business_claimed_by_owner`, `estated_estimated_value`, `units_count`, `stories_count`, `current_owner_name`, `current_owner_address`, `yelp_rating`, `zoning_category`, `zoning_description`, `property_available_for`, `listedOn`, `updatedOn`) VALUES
(51, 'pt_code_50', 'C & C Liquors', '43100 Sumter Ave', NULL, NULL, 'b_type_3', 'Liquor Store', 'https://lh3.googleusercontent.com/p/AF1QipNF-WTFzmS03OJpmr0cRX0e7rjWePIKNtV4Aa-X=s1600-w500', NULL, 'Fremont', 'CA', 37.5185164, -121.9541072, 94538, '(510) 651-7030', 1992, 1992, 11930, 3060, 0, 0, 1098124, 1, 1, 'C & C PTSHP', '', 4.5, 'Commercial', 'Commercial', 'List', NULL, NULL);
INSERT INTO `rw_property_details` (`id`, `property_code`, `property_name`, `property_address`, `property_id`, `property_type`, `business_type_code`, `business_type`, `img_url`, `mls_number`, `city`, `state`, `latitude`, `longitude`, `zip_code`, `phone_number`, `year_built`, `effective_year_built`, `lot_size`, `total_size_of_building`, `is_closed`, `is_business_claimed_by_owner`, `estated_estimated_value`, `units_count`, `stories_count`, `current_owner_name`, `current_owner_address`, `yelp_rating`, `zoning_category`, `zoning_description`, `property_available_for`, `listedOn`, `updatedOn`) VALUES
(52, 'pt_code_51', 'Mission Liquors', '39945 Mission Blvd', NULL, NULL, 'b_type_3', 'Liquor Store', 'https://lh3.googleusercontent.com/p/AF1QipPQ9l9lWaAQJWBf3almKev9bDB3A-wWxM0pQW4I=s1600-w500', NULL, 'Fremont', 'CA', 37.5567235, -121.9525484, 94539, '(510) 573-0333', 1978, 1978, 29224, 7372, 0, 1, 200775, 1, 1, 'MENG 1996 LIVING TRUST', '10788 Cherry Hill Dr, San Diego, CA 92130', 4, 'Commercial', 'Commercial', 'List', NULL, NULL);
INSERT INTO `rw_property_details` (`id`, `property_code`, `property_name`, `property_address`, `property_id`, `property_type`, `business_type_code`, `business_type`, `img_url`, `mls_number`, `city`, `state`, `latitude`, `longitude`, `zip_code`, `phone_number`, `year_built`, `effective_year_built`, `lot_size`, `total_size_of_building`, `is_closed`, `is_business_claimed_by_owner`, `estated_estimated_value`, `units_count`, `stories_count`, `current_owner_name`, `current_owner_address`, `yelp_rating`, `zoning_category`, `zoning_description`, `property_available_for`, `listedOn`, `updatedOn`) VALUES
(53, 'pt_code_52', 'Ka Yumi', '40645 Fremont Blvd', 1, NULL, 'b_type_1', 'Restaurants and Food', 'https://lh3.googleusercontent.com/p/AF1QipPHzUQfD2FIi0-PE7nygzrMTIWZn-YRx2-1z2FJ=s1600-w500', NULL, 'Fremont', 'CA', 37.5347708, -121.9649559, 94538, '(510) 353-1088', 1959, 1960, 326501, 108501, 0, 1, 15920000, 12, 1, 'ACV FSD FREMONT', '465 1st St W, Sonoma, CA 95476', 4, 'Commercial', 'Commercial', 'List', NULL, NULL);
INSERT INTO `rw_property_details` (`id`, `property_code`, `property_name`, `property_address`, `property_id`, `property_type`, `business_type_code`, `business_type`, `img_url`, `mls_number`, `city`, `state`, `latitude`, `longitude`, `zip_code`, `phone_number`, `year_built`, `effective_year_built`, `lot_size`, `total_size_of_building`, `is_closed`, `is_business_claimed_by_owner`, `estated_estimated_value`, `units_count`, `stories_count`, `current_owner_name`, `current_owner_address`, `yelp_rating`, `zoning_category`, `zoning_description`, `property_available_for`, `listedOn`, `updatedOn`) VALUES
(54, 'pt_code_53', 'Cut The Crab', '4949 Stevenson Blvd', 1, NULL, 'b_type_1', 'Restaurants and Food', 'https://lh3.googleusercontent.com/p/AF1QipNUkijt9LZJam--XN6WLCZ0o1HEUXjEkhC6ziA6=s1600-w500', NULL, 'Fremont', 'CA', 37.52957800000001, -121.9833044, 94538, '(510) 573-2264', 1963, 1963, 22610, 22195, 0, 1, 1985022, 14, 1, 'B F PROPERTIES CO & BROOKMAT CORP', '4725 Thornton Ave, Fremont, CA 94536', 3.5, 'Commercial', 'Commercial', 'List', NULL, NULL);
INSERT INTO `rw_property_details` (`id`, `property_code`, `property_name`, `property_address`, `property_id`, `property_type`, `business_type_code`, `business_type`, `img_url`, `mls_number`, `city`, `state`, `latitude`, `longitude`, `zip_code`, `phone_number`, `year_built`, `effective_year_built`, `lot_size`, `total_size_of_building`, `is_closed`, `is_business_claimed_by_owner`, `estated_estimated_value`, `units_count`, `stories_count`, `current_owner_name`, `current_owner_address`, `yelp_rating`, `zoning_category`, `zoning_description`, `property_available_for`, `listedOn`, `updatedOn`) VALUES
(55, 'pt_code_54', 'Peralta Discount Liquors', '3850 Peralta Blvd', NULL, NULL, 'b_type_3', 'Liquor Store', 'https://s3-media3.fl.yelpcdn.com/bphoto/_Tydktl9IgkmaxWqgs8OWA/o.jpg', NULL, 'Fremont', 'CA', 37.5585393, -122.0061851, 94536, '(510) 797-0200', 1964, 1964, 5250, 1570, 0, 0, 276782, 1, 1, 'CHENG JOHN', '3055 Wolsey Pl, Fremont, CA 94555', 4.5, 'Commercial', 'Commercial', 'List', NULL, NULL);
INSERT INTO `rw_property_details` (`id`, `property_code`, `property_name`, `property_address`, `property_id`, `property_type`, `business_type_code`, `business_type`, `img_url`, `mls_number`, `city`, `state`, `latitude`, `longitude`, `zip_code`, `phone_number`, `year_built`, `effective_year_built`, `lot_size`, `total_size_of_building`, `is_closed`, `is_business_claimed_by_owner`, `estated_estimated_value`, `units_count`, `stories_count`, `current_owner_name`, `current_owner_address`, `yelp_rating`, `zoning_category`, `zoning_description`, `property_available_for`, `listedOn`, `updatedOn`) VALUES
(56, 'pt_code_55', 'Midnight Liquor', '3601 Thornton Ave', NULL, NULL, 'b_type_3', 'Liquor Store', 'https://s3-media2.fl.yelpcdn.com/bphoto/ZBzH3Qk8glqxO4JCkcR3aA/o.jpg', NULL, 'Fremont', 'CA', 37.5632467, -122.0098906, 94536, '(510) 797-5539', 0, 1985, 79625, 26386, 0, 1, 3221274, 17, 1, 'CHIU FAMILY TRUST', '3601 Thornton Ave, Fremont, CA 94536', 2.5, 'Commercial', 'Commercial', 'List', NULL, NULL);
INSERT INTO `rw_property_details` (`id`, `property_code`, `property_name`, `property_address`, `property_id`, `property_type`, `business_type_code`, `business_type`, `img_url`, `mls_number`, `city`, `state`, `latitude`, `longitude`, `zip_code`, `phone_number`, `year_built`, `effective_year_built`, `lot_size`, `total_size_of_building`, `is_closed`, `is_business_claimed_by_owner`, `estated_estimated_value`, `units_count`, `stories_count`, `current_owner_name`, `current_owner_address`, `yelp_rating`, `zoning_category`, `zoning_description`, `property_available_for`, `listedOn`, `updatedOn`) VALUES
(57, 'pt_code_56', 'Cut The Crab', '4949 Stevenson Blvd', 1, NULL, 'b_type_1', 'Restaurants and Food', 'https://lh3.googleusercontent.com/p/AF1QipNUkijt9LZJam--XN6WLCZ0o1HEUXjEkhC6ziA6=s1600-w500', NULL, 'Fremont', 'CA', 37.52957800000001, -121.9833044, 94538, '(510) 573-2264', 1963, 1963, 22610, 22195, 0, 1, 1985022, 14, 1, 'B F PROPERTIES CO & BROOKMAT CORP', '4725 Thornton Ave, Fremont, CA 94536', 3.5, 'Commercial', 'Commercial', 'List', NULL, NULL);
INSERT INTO `rw_property_details` (`id`, `property_code`, `property_name`, `property_address`, `property_id`, `property_type`, `business_type_code`, `business_type`, `img_url`, `mls_number`, `city`, `state`, `latitude`, `longitude`, `zip_code`, `phone_number`, `year_built`, `effective_year_built`, `lot_size`, `total_size_of_building`, `is_closed`, `is_business_claimed_by_owner`, `estated_estimated_value`, `units_count`, `stories_count`, `current_owner_name`, `current_owner_address`, `yelp_rating`, `zoning_category`, `zoning_description`, `property_available_for`, `listedOn`, `updatedOn`) VALUES
(58, 'pt_code_57', 'FoodMaxx', '39441 Fremont Blvd', NULL, NULL, 'b_type_5', 'Convenience Store', 'https://lh3.googleusercontent.com/p/AF1QipNqYBaelTPp9Gu0T_Zflstqdy-0QvfF_i4f5FoT=s1600-w500', NULL, 'Fremont', 'CA', 37.543988, -121.982644, 94538, '(510) 651-1920', 0, 1984, 173804, 43500, 0, 1, 3563592, 1, 1, 'SAVE MART SUPERMARKETS', 'PO Box 4278, Modesto, CA 95352', 3, 'Commercial', 'Commercial', 'List', NULL, NULL);
INSERT INTO `rw_property_details` (`id`, `property_code`, `property_name`, `property_address`, `property_id`, `property_type`, `business_type_code`, `business_type`, `img_url`, `mls_number`, `city`, `state`, `latitude`, `longitude`, `zip_code`, `phone_number`, `year_built`, `effective_year_built`, `lot_size`, `total_size_of_building`, `is_closed`, `is_business_claimed_by_owner`, `estated_estimated_value`, `units_count`, `stories_count`, `current_owner_name`, `current_owner_address`, `yelp_rating`, `zoning_category`, `zoning_description`, `property_available_for`, `listedOn`, `updatedOn`) VALUES
(59, 'pt_code_58', 'Middle East Food Market', '4097 Peralta Blvd', NULL, NULL, 'b_type_5', 'Convenience Store', 'https://lh3.googleusercontent.com/p/AF1QipMK_K_AnIwlcMmgSkqqqaYKWOpDwZPVXD82OzmK=s1600-w500', NULL, 'Fremont', 'CA', 37.5573225, -122.0076822, 94536, '(510) 739-3800', 1966, 1966, 29925, 8000, 0, 0, 2352052, 4, 1, 'BASRAI LIVING TRUST', '436050 VISTA DEL MAR, FREMONT, CA 94539', 4, 'Commercial', 'Commercial', 'List', NULL, NULL);
INSERT INTO `rw_property_details` (`id`, `property_code`, `property_name`, `property_address`, `property_id`, `property_type`, `business_type_code`, `business_type`, `img_url`, `mls_number`, `city`, `state`, `latitude`, `longitude`, `zip_code`, `phone_number`, `year_built`, `effective_year_built`, `lot_size`, `total_size_of_building`, `is_closed`, `is_business_claimed_by_owner`, `estated_estimated_value`, `units_count`, `stories_count`, `current_owner_name`, `current_owner_address`, `yelp_rating`, `zoning_category`, `zoning_description`, `property_available_for`, `listedOn`, `updatedOn`) VALUES
(60, 'pt_code_59', 'Ste 206 46560 Fremont Blvd', 'Ste 206 46560 Fremont Blvd', NULL, NULL, 'b_type_5', 'Convenience Store', 'https://photos.zillowstatic.com/p_h/IS2f4c0vcvb37g1000000000.jpg', NULL, 'Fremont', 'CA', 37.48362, -121.94492, 94538, '', 1989, 1989, 355131, 957, 0, 0, 326509, 47, 1, 'KORD ENTS LP', '', 0, 'Industrial', 'Industrial', 'List', NULL, NULL);
INSERT INTO `rw_property_details` (`id`, `property_code`, `property_name`, `property_address`, `property_id`, `property_type`, `business_type_code`, `business_type`, `img_url`, `mls_number`, `city`, `state`, `latitude`, `longitude`, `zip_code`, `phone_number`, `year_built`, `effective_year_built`, `lot_size`, `total_size_of_building`, `is_closed`, `is_business_claimed_by_owner`, `estated_estimated_value`, `units_count`, `stories_count`, `current_owner_name`, `current_owner_address`, `yelp_rating`, `zoning_category`, `zoning_description`, `property_available_for`, `listedOn`, `updatedOn`) VALUES
(6, 'pt_code_6', 'New park', '2226 Market St', NULL, NULL, 'b_type_9', 'Others', 'https://photos.zillowstatic.com/p_h/IS2f4c0vcvb37g1000000000.jpg', 0, '', '', 0, 0, 0, '', 0, 0, 0, 0, 0, 0, 0, 0, 0, '', '', 0, '', '', 'buy', '0000-00-00', '0000-00-00');
INSERT INTO `rw_property_details` (`id`, `property_code`, `property_name`, `property_address`, `property_id`, `property_type`, `business_type_code`, `business_type`, `img_url`, `mls_number`, `city`, `state`, `latitude`, `longitude`, `zip_code`, `phone_number`, `year_built`, `effective_year_built`, `lot_size`, `total_size_of_building`, `is_closed`, `is_business_claimed_by_owner`, `estated_estimated_value`, `units_count`, `stories_count`, `current_owner_name`, `current_owner_address`, `yelp_rating`, `zoning_category`, `zoning_description`, `property_available_for`, `listedOn`, `updatedOn`) VALUES
(61, 'pt_code_60', 'Bharat Bazar', '3400 Mowry Ave', NULL, NULL, 'b_type_5', 'Convenience Store', 'https://lh3.googleusercontent.com/p/AF1QipP0PXX6FUSaGFEAFD--QfJ9BLwkGt8sAIlf99B6=s1600-w500', NULL, 'Fremont', 'CA', 37.5520269, -121.9851249, 94538, '(510) 687-0100', 0, 1971, 43250, 13660, 0, 1, 6395973, 1, 1, 'BUI THAO', '', 3.5, 'Commercial', 'Commercial', 'List', NULL, NULL);
INSERT INTO `rw_property_details` (`id`, `property_code`, `property_name`, `property_address`, `property_id`, `property_type`, `business_type_code`, `business_type`, `img_url`, `mls_number`, `city`, `state`, `latitude`, `longitude`, `zip_code`, `phone_number`, `year_built`, `effective_year_built`, `lot_size`, `total_size_of_building`, `is_closed`, `is_business_claimed_by_owner`, `estated_estimated_value`, `units_count`, `stories_count`, `current_owner_name`, `current_owner_address`, `yelp_rating`, `zoning_category`, `zoning_description`, `property_available_for`, `listedOn`, `updatedOn`) VALUES
(62, 'pt_code_61', 'MyGoods Market', '2950 Auto Mall Pkwy', 1, NULL, 'b_type_2', 'Gas Station', 'https://lh3.googleusercontent.com/p/AF1QipMPLfO3uyVPnecuSFBGA-TtyhN-fJdr8b473wyJ=s1600-w500', NULL, 'Fremont', 'CA', 37.5133058, -121.9415782, 94538, '', 1995, 1996, 103571, 3549, 0, 0, 5740502, 1, 1, 'CONVENIENCE RETAILERS LLC', '7180 Koll Center Pkwy # 100, Pleasanton, CA 94566', 0, 'Commercial', 'Commercial', 'List', NULL, NULL);
INSERT INTO `rw_property_details` (`id`, `property_code`, `property_name`, `property_address`, `property_id`, `property_type`, `business_type_code`, `business_type`, `img_url`, `mls_number`, `city`, `state`, `latitude`, `longitude`, `zip_code`, `phone_number`, `year_built`, `effective_year_built`, `lot_size`, `total_size_of_building`, `is_closed`, `is_business_claimed_by_owner`, `estated_estimated_value`, `units_count`, `stories_count`, `current_owner_name`, `current_owner_address`, `yelp_rating`, `zoning_category`, `zoning_description`, `property_available_for`, `listedOn`, `updatedOn`) VALUES
(63, 'pt_code_62', 'Bharat Bazar', '34301 Alvarado Niles Rd', NULL, NULL, 'b_type_5', 'Convenience Store', 'https://s3-media2.fl.yelpcdn.com/bphoto/90VQJXw1HpXQzBe-7rFiqA/o.jpg', NULL, 'Union City', 'CA', 37.58722, -122.023, 94587, '(510) 324-1011', 1988, 1988, 57064, 17012, 0, 1, 9138349, 6, 1, 'SANDEEP BIRLA', '227 Pilgrim Loop, Fremont, CA 94539', 3, 'Commercial', 'Commercial', 'List', NULL, NULL);
INSERT INTO `rw_property_details` (`id`, `property_code`, `property_name`, `property_address`, `property_id`, `property_type`, `business_type_code`, `business_type`, `img_url`, `mls_number`, `city`, `state`, `latitude`, `longitude`, `zip_code`, `phone_number`, `year_built`, `effective_year_built`, `lot_size`, `total_size_of_building`, `is_closed`, `is_business_claimed_by_owner`, `estated_estimated_value`, `units_count`, `stories_count`, `current_owner_name`, `current_owner_address`, `yelp_rating`, `zoning_category`, `zoning_description`, `property_available_for`, `listedOn`, `updatedOn`) VALUES
(64, 'pt_code_63', 'Marina Food', '1791 Decoto Rd', NULL, NULL, 'b_type_5', 'Convenience Store', 'https://lh3.googleusercontent.com/p/AF1QipPKTJhswsPX7Jf4NeUxQi6VK8SWVQPWe5USLuUm=s1600-w500', NULL, 'Union City', 'CA', 37.5887453, -122.0230989, 94587, '(510) 324-5668', 0, 1981, 156816, 35250, 0, 0, 2078919, 1, 1, 'EL MERCADO SPE LLC', '4546 El Camino Real Ste 222, Los Altos, CA 94022', 3, 'Commercial', 'Commercial', 'List', NULL, NULL);
INSERT INTO `rw_property_details` (`id`, `property_code`, `property_name`, `property_address`, `property_id`, `property_type`, `business_type_code`, `business_type`, `img_url`, `mls_number`, `city`, `state`, `latitude`, `longitude`, `zip_code`, `phone_number`, `year_built`, `effective_year_built`, `lot_size`, `total_size_of_building`, `is_closed`, `is_business_claimed_by_owner`, `estated_estimated_value`, `units_count`, `stories_count`, `current_owner_name`, `current_owner_address`, `yelp_rating`, `zoning_category`, `zoning_description`, `property_available_for`, `listedOn`, `updatedOn`) VALUES
(65, 'pt_code_64', '31301 Alvarado Niles Rd', '31301 Alvarado Niles Rd', 1, NULL, 'b_type_2', 'Gas Station', 'https://photos.zillowstatic.com/p_h/IS2f4c0vcvb37g1000000000.jpg', NULL, 'Union City', 'CA', 37.597888, -122.065962, 94587, '', 0, 0, 20121, 0, 0, 0, 1642705, 0, 0, 'ALVARADO NILES ROAD LLC', '31301 Alvarado Niles Rd, Union City, CA 94587', 0, 'Commercial', 'Commercial', 'List', NULL, NULL);
INSERT INTO `rw_property_details` (`id`, `property_code`, `property_name`, `property_address`, `property_id`, `property_type`, `business_type_code`, `business_type`, `img_url`, `mls_number`, `city`, `state`, `latitude`, `longitude`, `zip_code`, `phone_number`, `year_built`, `effective_year_built`, `lot_size`, `total_size_of_building`, `is_closed`, `is_business_claimed_by_owner`, `estated_estimated_value`, `units_count`, `stories_count`, `current_owner_name`, `current_owner_address`, `yelp_rating`, `zoning_category`, `zoning_description`, `property_available_for`, `listedOn`, `updatedOn`) VALUES
(66, 'pt_code_65', 'Chevron', '1990 Decoto Rd', 1, NULL, 'b_type_2', 'Gas Station', 'https://lh3.googleusercontent.com/p/AF1QipPaIKMCWJsVhTbYSrZbLmyJe035SzLpdjIlpX-F=s1600-w500', NULL, 'Union City', 'CA', 37.587514, -122.0211091, 94587, '(510) 651-6334', 0, 0, 24864, 0, 0, 0, 1754000, 0, 0, 'KERRY JEFFREY W', '1818 Wales Dr, Walnut Creek, CA 94595', 3, 'Commercial', 'Commercial', 'List', NULL, NULL);
INSERT INTO `rw_property_details` (`id`, `property_code`, `property_name`, `property_address`, `property_id`, `property_type`, `business_type_code`, `business_type`, `img_url`, `mls_number`, `city`, `state`, `latitude`, `longitude`, `zip_code`, `phone_number`, `year_built`, `effective_year_built`, `lot_size`, `total_size_of_building`, `is_closed`, `is_business_claimed_by_owner`, `estated_estimated_value`, `units_count`, `stories_count`, `current_owner_name`, `current_owner_address`, `yelp_rating`, `zoning_category`, `zoning_description`, `property_available_for`, `listedOn`, `updatedOn`) VALUES
(67, 'pt_code_66', 'Alvarado Niles Shell', '32187 Alvarado Niles Rd', 1, NULL, 'b_type_2', 'Gas Station', 'https://s3-media4.fl.yelpcdn.com/bphoto/B0Z2on-I9w2hzAar9DAwrg/o.jpg', NULL, 'Union City', 'CA', 37.596088, -122.054563, 94587, '(510) 487-4387', 1974, 1974, 20091, 1265, 0, 1, 339279, 1, 1, 'JOHNSON ROBERT A', 'PO Box 51790, Pacific Grove, CA 93950', 2, 'Commercial', 'Commercial', 'List', NULL, NULL);
INSERT INTO `rw_property_details` (`id`, `property_code`, `property_name`, `property_address`, `property_id`, `property_type`, `business_type_code`, `business_type`, `img_url`, `mls_number`, `city`, `state`, `latitude`, `longitude`, `zip_code`, `phone_number`, `year_built`, `effective_year_built`, `lot_size`, `total_size_of_building`, `is_closed`, `is_business_claimed_by_owner`, `estated_estimated_value`, `units_count`, `stories_count`, `current_owner_name`, `current_owner_address`, `yelp_rating`, `zoning_category`, `zoning_description`, `property_available_for`, `listedOn`, `updatedOn`) VALUES
(68, 'pt_code_67', 'Chevron', '31889 Alvarado Blvd', 1, NULL, 'b_type_1', 'Restaurants and Food', 'https://lh3.googleusercontent.com/p/AF1QipNLKi0h6U5u5N-dZ6RwnfBZdzNY6q6kjuoO1cc=s1600-w500', NULL, 'Union City', 'CA', 37.589651, -122.070495, 94587, '(510) 651-6334', 1971, 1975, 24798, 1806, 0, 0, 1791406, 1, 1, 'HARJAS PETROLEUM INC', '31889 Alvarado Blvd, Union City, CA 94587', 3, 'Commercial', 'Commercial', 'List', NULL, NULL);
INSERT INTO `rw_property_details` (`id`, `property_code`, `property_name`, `property_address`, `property_id`, `property_type`, `business_type_code`, `business_type`, `img_url`, `mls_number`, `city`, `state`, `latitude`, `longitude`, `zip_code`, `phone_number`, `year_built`, `effective_year_built`, `lot_size`, `total_size_of_building`, `is_closed`, `is_business_claimed_by_owner`, `estated_estimated_value`, `units_count`, `stories_count`, `current_owner_name`, `current_owner_address`, `yelp_rating`, `zoning_category`, `zoning_description`, `property_available_for`, `listedOn`, `updatedOn`) VALUES
(69, 'pt_code_68', 'The Beauty Bar', '31772 Alvarado Blvd', NULL, NULL, 'b_type_4', 'Beauty Salon/Spa/Nail', 'https://photos.zillowstatic.com/p_h/IS2f4c0vcvb37g1000000000.jpg', NULL, 'Union City', 'CA', 37.5914899, -122.0724234, 94587, '', 1981, 1981, 12503, 3279, 0, 0, 343606, 4, 1, 'ALVARADO PLAZA ASSOCIATES', '11150 Santa Monica Blvd Ste 760, Los Angeles, CA 90025', 0, 'Commercial', 'Commercial', 'List', NULL, NULL);
INSERT INTO `rw_property_details` (`id`, `property_code`, `property_name`, `property_address`, `property_id`, `property_type`, `business_type_code`, `business_type`, `img_url`, `mls_number`, `city`, `state`, `latitude`, `longitude`, `zip_code`, `phone_number`, `year_built`, `effective_year_built`, `lot_size`, `total_size_of_building`, `is_closed`, `is_business_claimed_by_owner`, `estated_estimated_value`, `units_count`, `stories_count`, `current_owner_name`, `current_owner_address`, `yelp_rating`, `zoning_category`, `zoning_description`, `property_available_for`, `listedOn`, `updatedOn`) VALUES
(70, 'pt_code_69', 'Nail Spa Boutique', '31080 Union City Blvd', 1, NULL, 'b_type_1', 'Beauty Nails ', 'https://lh3.googleusercontent.com/p/AF1QipPyKAQpT22rypfY6WW3T7D0-QibLkaNxJL_omfH=s1600-w500', NULL, 'Union City', 'CA', 37.595772, -122.080394, 94587, '(510) 400-3253', 1988, 1989, 21600, 15752, 0, 1, 2311074, 11, 2, 'SIMON L A LIVING TRUST', '', 4.5, 'Commercial', 'Commercial', 'List', NULL, NULL);
INSERT INTO `rw_property_details` (`id`, `property_code`, `property_name`, `property_address`, `property_id`, `property_type`, `business_type_code`, `business_type`, `img_url`, `mls_number`, `city`, `state`, `latitude`, `longitude`, `zip_code`, `phone_number`, `year_built`, `effective_year_built`, `lot_size`, `total_size_of_building`, `is_closed`, `is_business_claimed_by_owner`, `estated_estimated_value`, `units_count`, `stories_count`, `current_owner_name`, `current_owner_address`, `yelp_rating`, `zoning_category`, `zoning_description`, `property_available_for`, `listedOn`, `updatedOn`) VALUES
(7, 'pt_code_7', 'New prop', '111 US-1', NULL, NULL, 'b_type_9', 'Others', 'https://photos.zillowstatic.com/p_h/IS2f4c0vcvb37g1000000000.jpg', 0, '', '', 0, 0, 0, '', 0, 0, 0, 0, 0, 0, 0, 0, 0, '', '', 0, '', '', 'Lease', '0000-00-00', '0000-00-00');
INSERT INTO `rw_property_details` (`id`, `property_code`, `property_name`, `property_address`, `property_id`, `property_type`, `business_type_code`, `business_type`, `img_url`, `mls_number`, `city`, `state`, `latitude`, `longitude`, `zip_code`, `phone_number`, `year_built`, `effective_year_built`, `lot_size`, `total_size_of_building`, `is_closed`, `is_business_claimed_by_owner`, `estated_estimated_value`, `units_count`, `stories_count`, `current_owner_name`, `current_owner_address`, `yelp_rating`, `zoning_category`, `zoning_description`, `property_available_for`, `listedOn`, `updatedOn`) VALUES
(71, 'pt_code_70', 'Double OO Liquors', '1800 Whipple Rd', NULL, NULL, 'b_type_3', 'Liquor Store', 'https://s3-media1.fl.yelpcdn.com/bphoto/MmmmhR2Xc27k28fK2W1KvQ/o.jpg', NULL, 'Union City', 'CA', 37.6055201, -122.0519213, 94587, '(510) 471-1800', 1969, 1969, 62726, 11620, 0, 0, 6109431, 9, 1, 'JEE MIYE', '2715 Ingalls St # C, San Francisco, CA 94124', 4, 'Commercial', 'Commercial', 'List', NULL, NULL);
INSERT INTO `rw_property_details` (`id`, `property_code`, `property_name`, `property_address`, `property_id`, `property_type`, `business_type_code`, `business_type`, `img_url`, `mls_number`, `city`, `state`, `latitude`, `longitude`, `zip_code`, `phone_number`, `year_built`, `effective_year_built`, `lot_size`, `total_size_of_building`, `is_closed`, `is_business_claimed_by_owner`, `estated_estimated_value`, `units_count`, `stories_count`, `current_owner_name`, `current_owner_address`, `yelp_rating`, `zoning_category`, `zoning_description`, `property_available_for`, `listedOn`, `updatedOn`) VALUES
(72, 'pt_code_71', 'Bronco Billy\'s Pizza Palace', '3940 Smith St', 1, NULL, 'b_type_1', 'Restaurants and Food', 'https://lh3.googleusercontent.com/p/AF1QipP351PDYMqtcw07hkqxCJH53Y0Jfi4IGa_qegla=s1600-w500', NULL, 'Union City', 'CA', 37.5962421, -122.0797452, 94587, '(510) 489-4601', 1895, 1930, 21701, 6552, 0, 0, 1343416, 0, 2, '3940 SMITH ST LLC', '5309 Audubon Park Ct, Fremont, CA 94538', 3.5, 'Commercial', 'Commercial', 'List', NULL, NULL);
INSERT INTO `rw_property_details` (`id`, `property_code`, `property_name`, `property_address`, `property_id`, `property_type`, `business_type_code`, `business_type`, `img_url`, `mls_number`, `city`, `state`, `latitude`, `longitude`, `zip_code`, `phone_number`, `year_built`, `effective_year_built`, `lot_size`, `total_size_of_building`, `is_closed`, `is_business_claimed_by_owner`, `estated_estimated_value`, `units_count`, `stories_count`, `current_owner_name`, `current_owner_address`, `yelp_rating`, `zoning_category`, `zoning_description`, `property_available_for`, `listedOn`, `updatedOn`) VALUES
(73, 'pt_code_72', 'In-N-Out Burger', '32060 Union Lndg', 1, NULL, 'b_type_1', 'Restaurants and Food', 'https://s3-media1.fl.yelpcdn.com/bphoto/gadHWJ3gwjIiDyRXqOr0EA/o.jpg', NULL, 'Union City', 'CA', 37.599197, -122.06581, 94587, '(800) 786-1000', 2001, 2001, 47421, 3179, 0, 1, 2164318, 0, 1, 'PAPPAS UNION CITY NO 2', '2020 L St Fl 5, Sacramento, CA 95811', 4, 'Commercial', 'Commercial', 'List', NULL, NULL);
INSERT INTO `rw_property_details` (`id`, `property_code`, `property_name`, `property_address`, `property_id`, `property_type`, `business_type_code`, `business_type`, `img_url`, `mls_number`, `city`, `state`, `latitude`, `longitude`, `zip_code`, `phone_number`, `year_built`, `effective_year_built`, `lot_size`, `total_size_of_building`, `is_closed`, `is_business_claimed_by_owner`, `estated_estimated_value`, `units_count`, `stories_count`, `current_owner_name`, `current_owner_address`, `yelp_rating`, `zoning_category`, `zoning_description`, `property_available_for`, `listedOn`, `updatedOn`) VALUES
(74, 'pt_code_73', 'Burger King', '1801 Decoto Rd', 1, NULL, 'b_type_1', 'Restaurants and Food', 'https://lh3.googleusercontent.com/p/AF1QipOYXih-GfxNFX6o0WEBixTzamQa1EWbrL_dQJCc=s1600-w500', NULL, 'Union City', 'CA', 37.58871389999999, -122.0214853, 94587, '(510) 471-2272', 1981, 1981, 12458, 3244, 0, 0, 2078919, 1, 1, 'EL MERCADO SPE LLC', '4546 El Camino Real Ste 222, Los Altos, CA 94022', 1.5, 'Commercial', 'Commercial', 'List', NULL, NULL);
INSERT INTO `rw_property_details` (`id`, `property_code`, `property_name`, `property_address`, `property_id`, `property_type`, `business_type_code`, `business_type`, `img_url`, `mls_number`, `city`, `state`, `latitude`, `longitude`, `zip_code`, `phone_number`, `year_built`, `effective_year_built`, `lot_size`, `total_size_of_building`, `is_closed`, `is_business_claimed_by_owner`, `estated_estimated_value`, `units_count`, `stories_count`, `current_owner_name`, `current_owner_address`, `yelp_rating`, `zoning_category`, `zoning_description`, `property_available_for`, `listedOn`, `updatedOn`) VALUES
(75, 'pt_code_74', 'TGI Fridays', '31900 Dyer St', 1, NULL, 'b_type_1', 'Restaurants and Food', 'https://lh3.googleusercontent.com/p/AF1QipMLItQy_HE8Kzx3_YU2taweyoJEM2VTpfRpX-Kn=s1600-w500', NULL, 'Union City', 'CA', 37.6005634, -122.0694838, 94587, '(510) 489-2797', 2000, 2000, 49014, 6526, 0, 1, 5789968, 1, 1, 'MAJESTIC EMPIRE HOLDINGS LLC', '78 Okner Pkwy, Livingston, NJ 07039', 2.5, 'Commercial', 'Commercial', 'List', NULL, NULL);
INSERT INTO `rw_property_details` (`id`, `property_code`, `property_name`, `property_address`, `property_id`, `property_type`, `business_type_code`, `business_type`, `img_url`, `mls_number`, `city`, `state`, `latitude`, `longitude`, `zip_code`, `phone_number`, `year_built`, `effective_year_built`, `lot_size`, `total_size_of_building`, `is_closed`, `is_business_claimed_by_owner`, `estated_estimated_value`, `units_count`, `stories_count`, `current_owner_name`, `current_owner_address`, `yelp_rating`, `zoning_category`, `zoning_description`, `property_available_for`, `listedOn`, `updatedOn`) VALUES
(76, 'pt_code_75', '33476 Alvarado Niles Rd', '33476 Alvarado Niles Rd', 1, NULL, 'b_type_1', 'Restaurants and Food', 'https://photos.zillowstatic.com/p_h/IS2f4c0vcvb37g1000000000.jpg', NULL, 'Union City', 'CA', 37.59278, -122.03597, 94587, '', 0, 1988, 1759822, 75313, 0, 0, 4440691, 7, 1, 'PUBLIC STORAGE EURO PARTNERSHIP XII', 'PO Box 25025, Glendale, CA 91221', 0, 'Commercial', 'Commercial', 'List', NULL, NULL);
INSERT INTO `rw_property_details` (`id`, `property_code`, `property_name`, `property_address`, `property_id`, `property_type`, `business_type_code`, `business_type`, `img_url`, `mls_number`, `city`, `state`, `latitude`, `longitude`, `zip_code`, `phone_number`, `year_built`, `effective_year_built`, `lot_size`, `total_size_of_building`, `is_closed`, `is_business_claimed_by_owner`, `estated_estimated_value`, `units_count`, `stories_count`, `current_owner_name`, `current_owner_address`, `yelp_rating`, `zoning_category`, `zoning_description`, `property_available_for`, `listedOn`, `updatedOn`) VALUES
(77, 'pt_code_76', 'Nail Spa Boutique', '31080 Union City Blvd', 1, NULL, 'b_type_1', 'Beauty Nails ', 'https://lh3.googleusercontent.com/p/AF1QipPyKAQpT22rypfY6WW3T7D0-QibLkaNxJL_omfH=s1600-w500', NULL, 'Union City', 'CA', 37.595772, -122.080394, 94587, '(510) 400-3253', 1988, 1989, 21600, 15752, 0, 1, 2311074, 11, 2, 'SIMON L A LIVING TRUST', '', 4.5, 'Commercial', 'Commercial', 'List', NULL, NULL);
INSERT INTO `rw_property_details` (`id`, `property_code`, `property_name`, `property_address`, `property_id`, `property_type`, `business_type_code`, `business_type`, `img_url`, `mls_number`, `city`, `state`, `latitude`, `longitude`, `zip_code`, `phone_number`, `year_built`, `effective_year_built`, `lot_size`, `total_size_of_building`, `is_closed`, `is_business_claimed_by_owner`, `estated_estimated_value`, `units_count`, `stories_count`, `current_owner_name`, `current_owner_address`, `yelp_rating`, `zoning_category`, `zoning_description`, `property_available_for`, `listedOn`, `updatedOn`) VALUES
(78, 'pt_code_77', 'The Mark Green Sports Center', '31224 Union City Blvd', NULL, NULL, 'b_type_9', 'Others', 'https://lh3.googleusercontent.com/p/AF1QipMJkNtgP60Cl-mzNw-jbZbK3Ul_VfDtNMR6ReK2=s1600-w500', NULL, 'Union City', 'CA', 37.5934847, -122.0801237, 94587, '', 0, 1928, 114562, 21751, 0, 0, 4881793, 4, 1, 'SCHMOECKEL TRUST', '', 0, 'Other', 'Other', 'List', NULL, NULL);
INSERT INTO `rw_property_details` (`id`, `property_code`, `property_name`, `property_address`, `property_id`, `property_type`, `business_type_code`, `business_type`, `img_url`, `mls_number`, `city`, `state`, `latitude`, `longitude`, `zip_code`, `phone_number`, `year_built`, `effective_year_built`, `lot_size`, `total_size_of_building`, `is_closed`, `is_business_claimed_by_owner`, `estated_estimated_value`, `units_count`, `stories_count`, `current_owner_name`, `current_owner_address`, `yelp_rating`, `zoning_category`, `zoning_description`, `property_available_for`, `listedOn`, `updatedOn`) VALUES
(79, 'pt_code_78', 'Manila Dental Center & Orthodontics', '31210 Alvarado Niles Rd', NULL, NULL, 'b_type_9', 'Others', 'https://s3-media3.fl.yelpcdn.com/bphoto/z8XI88o-WtcpcKSjtDnoyw/o.jpg', NULL, 'Union City', 'CA', 37.598218, -122.067153, 94587, '(510) 429-9500', 2007, 2007, 7528, 3137, 0, 1, 653793, 1, 1, 'VIRAY CHRISTOPHER', '1100 Zamora Ct, Milpitas, CA 95035', 4.5, 'Commercial', 'Commercial', 'List', NULL, NULL);
INSERT INTO `rw_property_details` (`id`, `property_code`, `property_name`, `property_address`, `property_id`, `property_type`, `business_type_code`, `business_type`, `img_url`, `mls_number`, `city`, `state`, `latitude`, `longitude`, `zip_code`, `phone_number`, `year_built`, `effective_year_built`, `lot_size`, `total_size_of_building`, `is_closed`, `is_business_claimed_by_owner`, `estated_estimated_value`, `units_count`, `stories_count`, `current_owner_name`, `current_owner_address`, `yelp_rating`, `zoning_category`, `zoning_description`, `property_available_for`, `listedOn`, `updatedOn`) VALUES
(80, 'pt_code_79', 'The Three Sheep 喜气羊羊', '35201 Newark Blvd', 1, NULL, 'b_type_1', 'Restaurants and Food', 'https://lh3.googleusercontent.com/p/AF1QipPeNLlMTDRIqsVs3U29LF-pKBo6oX12CPdMHxgC=s1600-w500', NULL, 'Newark', 'CA', 37.547896, -122.047273, 94560, '', 0, 1966, 432551, 105765, 0, 0, 85363, 9, 1, 'CHANG INCOME PROPERTY PTSHP LP', '520 S El Camino Real, San Mateo, CA 94402', 0, 'Commercial', 'Commercial', 'List', NULL, NULL);
INSERT INTO `rw_property_details` (`id`, `property_code`, `property_name`, `property_address`, `property_id`, `property_type`, `business_type_code`, `business_type`, `img_url`, `mls_number`, `city`, `state`, `latitude`, `longitude`, `zip_code`, `phone_number`, `year_built`, `effective_year_built`, `lot_size`, `total_size_of_building`, `is_closed`, `is_business_claimed_by_owner`, `estated_estimated_value`, `units_count`, `stories_count`, `current_owner_name`, `current_owner_address`, `yelp_rating`, `zoning_category`, `zoning_description`, `property_available_for`, `listedOn`, `updatedOn`) VALUES
(8, 'pt_code_8', 'prop1', '23432 Ford Rd', NULL, NULL, 'b_type_9', 'Others', 'https://photos.zillowstatic.com/p_h/IS2f4c0vcvb37g1000000000.jpg', 0, '', '', 0, 0, 0, '', 0, 0, 0, 0, 0, 0, 0, 0, 0, '', '', 0, '', '', 'buy', '0000-00-00', '0000-00-00');
INSERT INTO `rw_property_details` (`id`, `property_code`, `property_name`, `property_address`, `property_id`, `property_type`, `business_type_code`, `business_type`, `img_url`, `mls_number`, `city`, `state`, `latitude`, `longitude`, `zip_code`, `phone_number`, `year_built`, `effective_year_built`, `lot_size`, `total_size_of_building`, `is_closed`, `is_business_claimed_by_owner`, `estated_estimated_value`, `units_count`, `stories_count`, `current_owner_name`, `current_owner_address`, `yelp_rating`, `zoning_category`, `zoning_description`, `property_available_for`, `listedOn`, `updatedOn`) VALUES
(81, 'pt_code_80', 'Shell', '6788 Thornton Ave', 1, NULL, 'b_type_2', 'Gas Station', 'https://lh3.googleusercontent.com/p/AF1QipNZG9dNUIPFYgVYUrIeF9E8gNZlQMYlSI9-MQe4=s1600-w500', NULL, 'Newark', 'CA', 37.531105, -122.035025, 94560, '(510) 490-0810', 1961, 1962, 11963, 1050, 0, 0, 2838959, 0, 1, 'TESORO SIERRA PROPERTIES LLC', 'PO Box 592809, San Antonio, TX 78259', 3.5, 'Commercial', 'Commercial', 'List', NULL, NULL);
INSERT INTO `rw_property_details` (`id`, `property_code`, `property_name`, `property_address`, `property_id`, `property_type`, `business_type_code`, `business_type`, `img_url`, `mls_number`, `city`, `state`, `latitude`, `longitude`, `zip_code`, `phone_number`, `year_built`, `effective_year_built`, `lot_size`, `total_size_of_building`, `is_closed`, `is_business_claimed_by_owner`, `estated_estimated_value`, `units_count`, `stories_count`, `current_owner_name`, `current_owner_address`, `yelp_rating`, `zoning_category`, `zoning_description`, `property_available_for`, `listedOn`, `updatedOn`) VALUES
(82, 'pt_code_81', 'Chevron', '5895 Stevenson Blvd', 1, NULL, 'b_type_2', 'Gas Station', 'https://lh3.googleusercontent.com/p/AF1QipNBJgKYY7aK7OzjEwtKc6uQptJJMnhAaGY8lgj2=s1600-w500', NULL, 'Newark', 'CA', 37.51866200000001, -121.991448, 94560, '(510) 651-6334', 0, 1998, 23871, 1519, 0, 0, 804660, 0, 1, 'NGUYEN PHUONGUYEN T', '2404 Greengate Dr, San Jose, CA 95132', 3, 'Commercial', 'Commercial', 'List', NULL, NULL);
INSERT INTO `rw_property_details` (`id`, `property_code`, `property_name`, `property_address`, `property_id`, `property_type`, `business_type_code`, `business_type`, `img_url`, `mls_number`, `city`, `state`, `latitude`, `longitude`, `zip_code`, `phone_number`, `year_built`, `effective_year_built`, `lot_size`, `total_size_of_building`, `is_closed`, `is_business_claimed_by_owner`, `estated_estimated_value`, `units_count`, `stories_count`, `current_owner_name`, `current_owner_address`, `yelp_rating`, `zoning_category`, `zoning_description`, `property_available_for`, `listedOn`, `updatedOn`) VALUES
(83, 'pt_code_82', 'ANDOIL', '5835 Thornton Ave', 1, NULL, 'b_type_2', 'Gas Station', 'https://lh3.googleusercontent.com/p/AF1QipM573OvhK-HR-fNWpxjxeFeAUw3TuEU8tps13-0=s1600-w500', NULL, 'Newark', 'CA', 37.5390197, -122.0292533, 94560, '', 1969, 1969, 29288, 1764, 0, 0, 2268684, 1, 1, 'ANDARYS ENT INC', '4995 Mowry Ave, Fremont, CA 94538', 0, 'Commercial', 'Commercial', 'List', NULL, NULL);
INSERT INTO `rw_property_details` (`id`, `property_code`, `property_name`, `property_address`, `property_id`, `property_type`, `business_type_code`, `business_type`, `img_url`, `mls_number`, `city`, `state`, `latitude`, `longitude`, `zip_code`, `phone_number`, `year_built`, `effective_year_built`, `lot_size`, `total_size_of_building`, `is_closed`, `is_business_claimed_by_owner`, `estated_estimated_value`, `units_count`, `stories_count`, `current_owner_name`, `current_owner_address`, `yelp_rating`, `zoning_category`, `zoning_description`, `property_available_for`, `listedOn`, `updatedOn`) VALUES
(84, 'pt_code_83', '7275 Thornton Ave', '7275 Thornton Ave', 1, NULL, 'b_type_1', 'Restaurants and Food', 'https://photos.zillowstatic.com/p_h/IS2f4c0vcvb37g1000000000.jpg', NULL, 'Newark', 'CA', 37.530348, -122.038155, 94560, '', 2001, 2001, 18050, 4324, 0, 0, 465115, 1, 2, 'SAHA APARNA', '43570 Vista Del Mar, Fremont, CA 94539', 0, 'Commercial', 'Commercial', 'List', NULL, NULL);
INSERT INTO `rw_property_details` (`id`, `property_code`, `property_name`, `property_address`, `property_id`, `property_type`, `business_type_code`, `business_type`, `img_url`, `mls_number`, `city`, `state`, `latitude`, `longitude`, `zip_code`, `phone_number`, `year_built`, `effective_year_built`, `lot_size`, `total_size_of_building`, `is_closed`, `is_business_claimed_by_owner`, `estated_estimated_value`, `units_count`, `stories_count`, `current_owner_name`, `current_owner_address`, `yelp_rating`, `zoning_category`, `zoning_description`, `property_available_for`, `listedOn`, `updatedOn`) VALUES
(85, 'pt_code_84', '76', '35425 Newark Blvd', 1, NULL, 'b_type_2', 'Gas Station', 'https://lh3.googleusercontent.com/p/AF1QipPoQkKkkREYIvlsoM1WeFslkhSI2hRHM2EjNDTg=s1600-w500', NULL, 'Newark', 'CA', 37.5475173, -122.0443029, 94560, '(510) 796-1203', 0, 1962, 28000, 1860, 0, 1, 275966, 1, 1, 'LIDO AUTO CARE INC', '35425 Newark Blvd, Newark, CA 94560', 3, 'Commercial', 'Commercial', 'List', NULL, NULL);
INSERT INTO `rw_property_details` (`id`, `property_code`, `property_name`, `property_address`, `property_id`, `property_type`, `business_type_code`, `business_type`, `img_url`, `mls_number`, `city`, `state`, `latitude`, `longitude`, `zip_code`, `phone_number`, `year_built`, `effective_year_built`, `lot_size`, `total_size_of_building`, `is_closed`, `is_business_claimed_by_owner`, `estated_estimated_value`, `units_count`, `stories_count`, `current_owner_name`, `current_owner_address`, `yelp_rating`, `zoning_category`, `zoning_description`, `property_available_for`, `listedOn`, `updatedOn`) VALUES
(86, 'pt_code_85', 'The MadHouse Salon', '6449 Thornton Ave', NULL, NULL, 'b_type_4', 'Beauty Salon/Spa/Nail', 'https://lh3.googleusercontent.com/p/AF1QipNS8-R7VDRn6R_n2EK-XcgqABAzIteL-3eWvJAC=s1600-w500', NULL, 'Newark', 'CA', 37.53347979999999, -122.0337659, 94560, '(510) 894-2885', 0, 1951, 10653, 1541, 0, 1, 77044, 0, 0, 'TERRANOVA P M LIVING TRUST', '45945 Las Colinas, La Quinta, CA 92253', 5, 'Commercial', 'Commercial', 'List', NULL, NULL);
INSERT INTO `rw_property_details` (`id`, `property_code`, `property_name`, `property_address`, `property_id`, `property_type`, `business_type_code`, `business_type`, `img_url`, `mls_number`, `city`, `state`, `latitude`, `longitude`, `zip_code`, `phone_number`, `year_built`, `effective_year_built`, `lot_size`, `total_size_of_building`, `is_closed`, `is_business_claimed_by_owner`, `estated_estimated_value`, `units_count`, `stories_count`, `current_owner_name`, `current_owner_address`, `yelp_rating`, `zoning_category`, `zoning_description`, `property_available_for`, `listedOn`, `updatedOn`) VALUES
(87, 'pt_code_86', 'Newark Excellent Massage', '6170 Thornton Ave', NULL, NULL, 'b_type_4', 'Beauty Salon/Spa/Nail', 'https://lh3.googleusercontent.com/p/AF1QipN0sBb90fQiER8zv-Vtl53aIhtzMA9y4_4FrFPD=s1600-w500', NULL, 'Newark', 'CA', 37.535927, -122.031079, 94560, '(510) 794-5678', 1965, 1965, 36970, 9202, 0, 1, 1535067, 10, 1, 'WELCH BUSINESS SYSTEMS INC', '', 3.5, 'Commercial', 'Commercial', 'List', NULL, NULL);
INSERT INTO `rw_property_details` (`id`, `property_code`, `property_name`, `property_address`, `property_id`, `property_type`, `business_type_code`, `business_type`, `img_url`, `mls_number`, `city`, `state`, `latitude`, `longitude`, `zip_code`, `phone_number`, `year_built`, `effective_year_built`, `lot_size`, `total_size_of_building`, `is_closed`, `is_business_claimed_by_owner`, `estated_estimated_value`, `units_count`, `stories_count`, `current_owner_name`, `current_owner_address`, `yelp_rating`, `zoning_category`, `zoning_description`, `property_available_for`, `listedOn`, `updatedOn`) VALUES
(88, 'pt_code_87', 'Best Nail', '36601 Newark Blvd', NULL, NULL, 'b_type_4', 'Beauty Salon/Spa/Nail', 'https://lh3.googleusercontent.com/p/AF1QipO8MQd6zY6DXC7kVz_VEP24qazlAS_8ipCyVs7V=s1600-w500', NULL, 'Newark', 'CA', 37.5389411, -122.0344225, 94560, '', 0, 1964, 209959, 58828, 0, 0, 1971743, 29, 1, 'FRIES PROPERTIES INC', '39678 Mission Blvd, Fremont, CA 94539', 0, 'Commercial', 'Commercial', 'List', NULL, NULL);
INSERT INTO `rw_property_details` (`id`, `property_code`, `property_name`, `property_address`, `property_id`, `property_type`, `business_type_code`, `business_type`, `img_url`, `mls_number`, `city`, `state`, `latitude`, `longitude`, `zip_code`, `phone_number`, `year_built`, `effective_year_built`, `lot_size`, `total_size_of_building`, `is_closed`, `is_business_claimed_by_owner`, `estated_estimated_value`, `units_count`, `stories_count`, `current_owner_name`, `current_owner_address`, `yelp_rating`, `zoning_category`, `zoning_description`, `property_available_for`, `listedOn`, `updatedOn`) VALUES
(89, 'pt_code_88', 'Ste A 5970 Mowry Ave', 'Ste A 5970 Mowry Ave', 1, NULL, 'b_type_1', 'Beauty Nails ', 'https://photos.zillowstatic.com/p_h/IS2f4c0vcvb37g1000000000.jpg', NULL, 'Newark', 'CA', 37.525093, -122.006565, 94560, '', 1989, 1989, 45738, 11395, 0, 0, 3792001, 9, 1, 'SADRUDDIN SALEEM K', '104 Woodland Valley Dr, San Ramon, CA 94582', 0, 'Commercial', 'Commercial', 'List', NULL, NULL);
INSERT INTO `rw_property_details` (`id`, `property_code`, `property_name`, `property_address`, `property_id`, `property_type`, `business_type_code`, `business_type`, `img_url`, `mls_number`, `city`, `state`, `latitude`, `longitude`, `zip_code`, `phone_number`, `year_built`, `effective_year_built`, `lot_size`, `total_size_of_building`, `is_closed`, `is_business_claimed_by_owner`, `estated_estimated_value`, `units_count`, `stories_count`, `current_owner_name`, `current_owner_address`, `yelp_rating`, `zoning_category`, `zoning_description`, `property_available_for`, `listedOn`, `updatedOn`) VALUES
(90, 'pt_code_89', '5 Star Liquor', '35111 Newark Blvd', NULL, NULL, 'b_type_3', 'Liquor Store', 'https://lh3.googleusercontent.com/p/AF1QipNvzIe1GR6rn6A9d0zII5fft6cEjTpRKcFnM576=s1600-w500', NULL, 'Newark', 'CA', 37.5496747, -122.0487101, 94560, '(510) 791-1959', 1986, 1987, 32865, 9420, 0, 1, 2497000, 7, 1, 'SHYU & YU ENTS', '15650AA VINEYARD BLVD, MORGAN HILL, CA 95037', 4.5, 'Commercial', 'Commercial', 'List', NULL, NULL);
INSERT INTO `rw_property_details` (`id`, `property_code`, `property_name`, `property_address`, `property_id`, `property_type`, `business_type_code`, `business_type`, `img_url`, `mls_number`, `city`, `state`, `latitude`, `longitude`, `zip_code`, `phone_number`, `year_built`, `effective_year_built`, `lot_size`, `total_size_of_building`, `is_closed`, `is_business_claimed_by_owner`, `estated_estimated_value`, `units_count`, `stories_count`, `current_owner_name`, `current_owner_address`, `yelp_rating`, `zoning_category`, `zoning_description`, `property_available_for`, `listedOn`, `updatedOn`) VALUES
(9, 'pt_code_9', 'prop22', '4052 Kettering Terrace', NULL, NULL, 'b_type_9', 'Others', 'https://photos.zillowstatic.com/p_h/IS6eyxl7mvq3880000000000.jpg', 412421, 'Fremont', 'CA', 37.5669, -122.026, 94536, '(510) 000-1234', 0, 0, 1, 1000, 0, 0, 0, 0, 0, '', '', 0, '', '', 'Lease', '0000-00-00', '0000-00-00');
INSERT INTO `rw_property_details` (`id`, `property_code`, `property_name`, `property_address`, `property_id`, `property_type`, `business_type_code`, `business_type`, `img_url`, `mls_number`, `city`, `state`, `latitude`, `longitude`, `zip_code`, `phone_number`, `year_built`, `effective_year_built`, `lot_size`, `total_size_of_building`, `is_closed`, `is_business_claimed_by_owner`, `estated_estimated_value`, `units_count`, `stories_count`, `current_owner_name`, `current_owner_address`, `yelp_rating`, `zoning_category`, `zoning_description`, `property_available_for`, `listedOn`, `updatedOn`) VALUES
(91, 'pt_code_90', 'Ste A 5970 Mowry Ave', 'Ste A 5970 Mowry Ave', 1, NULL, 'b_type_1', 'Beauty Nails ', 'https://photos.zillowstatic.com/p_h/IS2f4c0vcvb37g1000000000.jpg', NULL, 'Newark', 'CA', 37.525093, -122.006565, 94560, '', 1989, 1989, 45738, 11395, 0, 0, 3792001, 9, 1, 'SADRUDDIN SALEEM K', '104 Woodland Valley Dr, San Ramon, CA 94582', 0, 'Commercial', 'Commercial', 'List', NULL, NULL);
INSERT INTO `rw_property_details` (`id`, `property_code`, `property_name`, `property_address`, `property_id`, `property_type`, `business_type_code`, `business_type`, `img_url`, `mls_number`, `city`, `state`, `latitude`, `longitude`, `zip_code`, `phone_number`, `year_built`, `effective_year_built`, `lot_size`, `total_size_of_building`, `is_closed`, `is_business_claimed_by_owner`, `estated_estimated_value`, `units_count`, `stories_count`, `current_owner_name`, `current_owner_address`, `yelp_rating`, `zoning_category`, `zoning_description`, `property_available_for`, `listedOn`, `updatedOn`) VALUES
(92, 'pt_code_91', 'Mountain Mike\'s Pizza', '5333 Thornton Ave', 1, NULL, 'b_type_1', 'Restaurants and Food', 'https://lh3.googleusercontent.com/p/AF1QipOzzYA0E7GC-YablhR-DLILq4mlu9cn_AX1TbfA=s1600-w500', NULL, 'Newark', 'CA', 37.5446056, -122.0250972, 94560, '(510) 494-8177', 1981, 1981, 19500, 2596, 0, 1, 766299, 1, 1, 'PLAZA HOTEL INC', '1156 Tanglewood Way, San Mateo, CA 94403', 2.5, 'Commercial', 'Commercial', 'List', NULL, NULL);
INSERT INTO `rw_property_details` (`id`, `property_code`, `property_name`, `property_address`, `property_id`, `property_type`, `business_type_code`, `business_type`, `img_url`, `mls_number`, `city`, `state`, `latitude`, `longitude`, `zip_code`, `phone_number`, `year_built`, `effective_year_built`, `lot_size`, `total_size_of_building`, `is_closed`, `is_business_claimed_by_owner`, `estated_estimated_value`, `units_count`, `stories_count`, `current_owner_name`, `current_owner_address`, `yelp_rating`, `zoning_category`, `zoning_description`, `property_available_for`, `listedOn`, `updatedOn`) VALUES
(93, 'pt_code_92', 'BJ\'s Restaurant & Brewhouse', '5699 Mowry Ave', 1, NULL, 'b_type_1', 'Restaurants and Food', 'https://lh3.googleusercontent.com/p/AF1QipNmLXqRV5QQIvYjQu1lP-r76hz5B0tVvtbRMBMd=s1600-w500', NULL, 'Newark', 'CA', 37.52807689999999, -122.0057656, 94560, '(510) 456-3750', 2008, 2009, 143748, 8600, 0, 1, 8400000, 1, 1, 'CAPELLA-MOWRY LLC', '', 3, 'Commercial', 'Commercial', 'List', NULL, NULL);
INSERT INTO `rw_property_details` (`id`, `property_code`, `property_name`, `property_address`, `property_id`, `property_type`, `business_type_code`, `business_type`, `img_url`, `mls_number`, `city`, `state`, `latitude`, `longitude`, `zip_code`, `phone_number`, `year_built`, `effective_year_built`, `lot_size`, `total_size_of_building`, `is_closed`, `is_business_claimed_by_owner`, `estated_estimated_value`, `units_count`, `stories_count`, `current_owner_name`, `current_owner_address`, `yelp_rating`, `zoning_category`, `zoning_description`, `property_available_for`, `listedOn`, `updatedOn`) VALUES
(94, 'pt_code_93', 'Minia\'s Bake Shop', '5445 Central Ave', 1, NULL, 'b_type_1', 'Restaurants and Food', 'https://lh3.googleusercontent.com/p/AF1QipOb34d_wCgQHkkP7mLWC_lKY4-h2Z41ZIjuHl5b=s1600-w500', NULL, 'Newark', 'CA', 37.5388704, -122.019333, 94560, '(510) 791-8343', 1987, 1987, 18033, 7920, 0, 1, 495291, 3, 2, 'CENTRAL PARK ASSOCIATES', '2596 Bay Rd, Redwood City, CA 94063', 4.5, 'Commercial', 'Commercial', 'List', NULL, NULL);
INSERT INTO `rw_property_details` (`id`, `property_code`, `property_name`, `property_address`, `property_id`, `property_type`, `business_type_code`, `business_type`, `img_url`, `mls_number`, `city`, `state`, `latitude`, `longitude`, `zip_code`, `phone_number`, `year_built`, `effective_year_built`, `lot_size`, `total_size_of_building`, `is_closed`, `is_business_claimed_by_owner`, `estated_estimated_value`, `units_count`, `stories_count`, `current_owner_name`, `current_owner_address`, `yelp_rating`, `zoning_category`, `zoning_description`, `property_available_for`, `listedOn`, `updatedOn`) VALUES
(95, 'pt_code_94', 'The Three Sheep 喜气羊羊', '35201 Newark Blvd', 1, NULL, 'b_type_1', 'Restaurants and Food', 'https://lh3.googleusercontent.com/p/AF1QipPeNLlMTDRIqsVs3U29LF-pKBo6oX12CPdMHxgC=s1600-w500', NULL, 'Newark', 'CA', 37.547896, -122.047273, 94560, '', 0, 1966, 432551, 105765, 0, 0, 85363, 9, 1, 'CHANG INCOME PROPERTY PTSHP LP', '520 S El Camino Real, San Mateo, CA 94402', 0, 'Commercial', 'Commercial', 'List', NULL, NULL);
INSERT INTO `rw_property_details` (`id`, `property_code`, `property_name`, `property_address`, `property_id`, `property_type`, `business_type_code`, `business_type`, `img_url`, `mls_number`, `city`, `state`, `latitude`, `longitude`, `zip_code`, `phone_number`, `year_built`, `effective_year_built`, `lot_size`, `total_size_of_building`, `is_closed`, `is_business_claimed_by_owner`, `estated_estimated_value`, `units_count`, `stories_count`, `current_owner_name`, `current_owner_address`, `yelp_rating`, `zoning_category`, `zoning_description`, `property_available_for`, `listedOn`, `updatedOn`) VALUES
(96, 'pt_code_95', 'Best Nail', '36601 Newark Blvd', NULL, NULL, 'b_type_4', 'Beauty Salon/Spa/Nail', 'https://lh3.googleusercontent.com/p/AF1QipO8MQd6zY6DXC7kVz_VEP24qazlAS_8ipCyVs7V=s1600-w500', NULL, 'Newark', 'CA', 37.5389411, -122.0344225, 94560, '', 0, 1964, 209959, 58828, 0, 0, 1971743, 29, 1, 'FRIES PROPERTIES INC', '39678 Mission Blvd, Fremont, CA 94539', 0, 'Commercial', 'Commercial', 'List', NULL, NULL);
INSERT INTO `rw_property_details` (`id`, `property_code`, `property_name`, `property_address`, `property_id`, `property_type`, `business_type_code`, `business_type`, `img_url`, `mls_number`, `city`, `state`, `latitude`, `longitude`, `zip_code`, `phone_number`, `year_built`, `effective_year_built`, `lot_size`, `total_size_of_building`, `is_closed`, `is_business_claimed_by_owner`, `estated_estimated_value`, `units_count`, `stories_count`, `current_owner_name`, `current_owner_address`, `yelp_rating`, `zoning_category`, `zoning_description`, `property_available_for`, `listedOn`, `updatedOn`) VALUES
(97, 'pt_code_96', 'Fresh & Natural Cafe', '39399 Cherry St', NULL, NULL, 'b_type_8', 'Cafe', 'https://s3-media4.fl.yelpcdn.com/bphoto/zM4_JnnUbu0lOLzCt3e9dA/o.jpg', NULL, 'Newark', 'CA', 37.517016, -122.004773, 94560, '(510) 742-3177', 0, 0, 1254053, 0, 0, 0, 0, 0, 0, 'OHLONE COMMUNITY COLLEGE DISTRICT', '43600 Mission Blvd # 27, Fremont, CA 94539', 2.5, 'Other', 'Other', 'List', NULL, NULL);
INSERT INTO `rw_property_details` (`id`, `property_code`, `property_name`, `property_address`, `property_id`, `property_type`, `business_type_code`, `business_type`, `img_url`, `mls_number`, `city`, `state`, `latitude`, `longitude`, `zip_code`, `phone_number`, `year_built`, `effective_year_built`, `lot_size`, `total_size_of_building`, `is_closed`, `is_business_claimed_by_owner`, `estated_estimated_value`, `units_count`, `stories_count`, `current_owner_name`, `current_owner_address`, `yelp_rating`, `zoning_category`, `zoning_description`, `property_available_for`, `listedOn`, `updatedOn`) VALUES
(98, 'pt_code_97', 'Best Nail', '36601 Newark Blvd', NULL, NULL, 'b_type_4', 'Beauty Salon/Spa/Nail', 'https://lh3.googleusercontent.com/p/AF1QipO8MQd6zY6DXC7kVz_VEP24qazlAS_8ipCyVs7V=s1600-w500', NULL, 'Newark', 'CA', 37.5389411, -122.0344225, 94560, '', 0, 1964, 209959, 58828, 0, 0, 1971743, 29, 1, 'FRIES PROPERTIES INC', '39678 Mission Blvd, Fremont, CA 94539', 0, 'Commercial', 'Commercial', 'List', NULL, NULL);
INSERT INTO `rw_property_details` (`id`, `property_code`, `property_name`, `property_address`, `property_id`, `property_type`, `business_type_code`, `business_type`, `img_url`, `mls_number`, `city`, `state`, `latitude`, `longitude`, `zip_code`, `phone_number`, `year_built`, `effective_year_built`, `lot_size`, `total_size_of_building`, `is_closed`, `is_business_claimed_by_owner`, `estated_estimated_value`, `units_count`, `stories_count`, `current_owner_name`, `current_owner_address`, `yelp_rating`, `zoning_category`, `zoning_description`, `property_available_for`, `listedOn`, `updatedOn`) VALUES
(99, 'pt_code_98', 'Best Nail', '36601 Newark Blvd', NULL, NULL, 'b_type_4', 'Beauty Salon/Spa/Nail', 'https://lh3.googleusercontent.com/p/AF1QipO8MQd6zY6DXC7kVz_VEP24qazlAS_8ipCyVs7V=s1600-w500', NULL, 'Newark', 'CA', 37.5389411, -122.0344225, 94560, '', 0, 1964, 209959, 58828, 0, 0, 1971743, 29, 1, 'FRIES PROPERTIES INC', '39678 Mission Blvd, Fremont, CA 94539', 0, 'Commercial', 'Commercial', 'List', NULL, NULL);
INSERT INTO `rw_property_details` (`id`, `property_code`, `property_name`, `property_address`, `property_id`, `property_type`, `business_type_code`, `business_type`, `img_url`, `mls_number`, `city`, `state`, `latitude`, `longitude`, `zip_code`, `phone_number`, `year_built`, `effective_year_built`, `lot_size`, `total_size_of_building`, `is_closed`, `is_business_claimed_by_owner`, `estated_estimated_value`, `units_count`, `stories_count`, `current_owner_name`, `current_owner_address`, `yelp_rating`, `zoning_category`, `zoning_description`, `property_available_for`, `listedOn`, `updatedOn`) VALUES
(100, 'pt_code_99', 'Ste A 37070 Newark Blvd', 'Ste A 37070 Newark Blvd', NULL, NULL, 'b_type_9', 'Others', 'https://photos.zillowstatic.com/p_h/IS2f4c0vcvb37g1000000000.jpg', NULL, 'Newark', 'CA', 37.536574, -122.0292, 94560, '', 1977, 1977, 30361, 5112, 0, 0, 476836, 6, 1, 'BUTTERFLY PROPERTY LP', '37070 Newark Blvd, Newark, CA 94560', 0, 'Commercial', 'Commercial', 'List', NULL, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `rw_property_images`
--

CREATE TABLE `rw_property_images` (
  `id` int(15) NOT NULL,
  `property_code` varchar(15) DEFAULT NULL,
  `image_url` varchar(100) DEFAULT NULL,
  `property_details_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `rw_property_images`
--

INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(1, 'pt_code_18', 'https://lh3.googleusercontent.com/p/AF1QipNwY-hw2pjziqNELvBo12yiN2ufutiiXYET1Kit=s1600-w500', 19);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(2, 'pt_code_18', 'https://lh3.googleusercontent.com/p/AF1QipPnRHp4O8kuERaNBg5LmqQKjD3TiEzx5znfZBm3=s1600-w500', 19);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(3, 'pt_code_18', 'https://lh3.googleusercontent.com/p/AF1QipPaiKNDvC2FPKud_j_1oBzpCclgBPrPT7QlGPC_=s1600-w500', 19);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(4, 'pt_code_18', 'https://lh3.googleusercontent.com/p/AF1QipMC6jrumMCaQPiKgidAxG730Y9FZCdyn-eYwoDd=s1600-w500', 19);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(5, 'pt_code_18', 'https://lh3.googleusercontent.com/p/AF1QipMchW91KSgO_5NGBZaRpdy3zGQPtJFAl9-XIv3_=s1600-w500', 19);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(6, 'pt_code_18', 'https://lh3.googleusercontent.com/p/AF1QipOOCoINUi-4DAL90FcFKByHl9H9Gjigtg4wzv4o=s1600-w500', 19);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(7, 'pt_code_18', 'https://lh3.googleusercontent.com/p/AF1QipMO5fondNDxOGGyclAouEbQPC05LTqBW5zK5Pi5=s1600-w500', 19);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(8, 'pt_code_18', 'https://lh3.googleusercontent.com/p/AF1QipMC-lielMWS5lqI4NfQITtoC7rlNpBCLM9opdmr=s1600-w500', 19);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(9, 'pt_code_18', 'https://lh3.googleusercontent.com/p/AF1QipNphnte52_G9biGtDOs82pdMu9UFlxuCYYKYeQL=s1600-w500', 19);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(10, 'pt_code_18', 'https://lh3.googleusercontent.com/p/AF1QipOT5LKOq1j9Z4AzXkgU-zsS1glLldd3TojE8j7z=s1600-w500', 19);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(11, 'pt_code_18', 'https://s3-media3.fl.yelpcdn.com/bphoto/bhC0G2kM1ri0HIkiQk_zZA/o.jpg', 19);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(12, 'pt_code_18', 'https://s3-media4.fl.yelpcdn.com/bphoto/0q2k3cQPBLCwIpkU524lQA/o.jpg', 19);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(13, 'pt_code_18', 'https://s3-media4.fl.yelpcdn.com/bphoto/nK1yOfH2D4Pkcb9R2Sc1CQ/o.jpg', 19);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(14, 'pt_code_19', 'https://lh3.googleusercontent.com/p/AF1QipNbEVsmNQL9ehrLw-2sMVv_VOBIPcYd54CApQyw=s1600-w500', 20);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(15, 'pt_code_19', 'https://lh3.googleusercontent.com/p/AF1QipN-Zs5MwrRgFWraYbl6pJh2vHB0bPthjh7gFNQH=s1600-w500', 20);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(16, 'pt_code_19', 'https://lh3.googleusercontent.com/p/AF1QipOGFLQWqVvmPrLpr-t3S6j-7zvK6QIn4nqZDAZO=s1600-w500', 20);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(17, 'pt_code_19', 'https://lh3.googleusercontent.com/p/AF1QipOI0LK5UuhnYVoObdI1N8Xv7PVIvXQYQT-k2IMp=s1600-w500', 20);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(18, 'pt_code_19', 'https://lh3.googleusercontent.com/p/AF1QipOsj-qqK3I-ZmRvuAvi5ZfZPipmn6P1agnL4FFy=s1600-w500', 20);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(19, 'pt_code_19', 'https://lh3.googleusercontent.com/p/AF1QipNO4bNJVKgHkFb53waDFaed8JRyd0XGe0OLUseo=s1600-w500', 20);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(20, 'pt_code_19', 'https://lh3.googleusercontent.com/p/AF1QipPZzzQWmMTr9mw1OIuD66ggCSMVwXZhHAszpFp3=s1600-w500', 20);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(21, 'pt_code_19', 'https://lh3.googleusercontent.com/p/AF1QipOAp1ZJQwWa0HojqNWlJo-8BFELk3ygZlgs17z9=s1600-w500', 20);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(22, 'pt_code_19', 'https://lh3.googleusercontent.com/p/AF1QipPsRqRwfF-GF5jhoIixMO9CAWId_Ur6VYtRqCBq=s1600-w500', 20);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(23, 'pt_code_19', 'https://lh3.googleusercontent.com/p/AF1QipNQGMe_ATS_l-gWoI8AvvSggqC8rCEOCRceDCLe=s1600-w500', 20);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(24, 'pt_code_19', 'https://s3-media1.fl.yelpcdn.com/bphoto/UV2ZGTDOoUyf1ZZborDcaQ/o.jpg', 20);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(25, 'pt_code_19', 'https://s3-media1.fl.yelpcdn.com/bphoto/1Mvjv2ZNkad08dJTM2970w/o.jpg', 20);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(26, 'pt_code_19', 'https://s3-media2.fl.yelpcdn.com/bphoto/JHig8zMNa2cNgI2qaufPyQ/o.jpg', 20);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(27, 'pt_code_20', 'https://lh3.googleusercontent.com/p/AF1QipPHzUQfD2FIi0-PE7nygzrMTIWZn-YRx2-1z2FJ=s1600-w500', 21);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(28, 'pt_code_20', 'https://lh3.googleusercontent.com/p/AF1QipMcFSlWmwcrRPTWkH7Zn8faXSIIjlQrZpeoVHng=s1600-w500', 21);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(29, 'pt_code_20', 'https://lh3.googleusercontent.com/p/AF1QipNHy45_gz_28DXscdvZkx1kJh4yLCLrqRuAz8nG=s1600-w500', 21);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(30, 'pt_code_20', 'https://lh3.googleusercontent.com/p/AF1QipNU-2oVzwy0FtX_YclBEi6a2oxpy0AufcDsS57M=s1600-w500', 21);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(31, 'pt_code_20', 'https://lh3.googleusercontent.com/p/AF1QipPZDc3RDavb7cJ2QS8NwjDt6AHSDe6aQczoIC-S=s1600-w500', 21);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(32, 'pt_code_20', 'https://lh3.googleusercontent.com/p/AF1QipNnSDYWqAW8qv2hZHwKiil_h5uK8XtWuJbNGu3K=s1600-w500', 21);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(33, 'pt_code_20', 'https://lh3.googleusercontent.com/p/AF1QipMzcVTCDtCgJan4E7nIJQe_pZ7DJs_u8aGO_9Gt=s1600-w500', 21);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(34, 'pt_code_20', 'https://lh3.googleusercontent.com/p/AF1QipO96YWR7lyh0kxKEc-DsRSrvfFn5Iw6DOSBVaX3=s1600-w500', 21);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(35, 'pt_code_20', 'https://lh3.googleusercontent.com/p/AF1QipNh9zii0kol2SihpEfgYa1o0rPkjzC541mQ7C_d=s1600-w500', 21);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(36, 'pt_code_20', 'https://lh3.googleusercontent.com/p/AF1QipPet0Lono2boEqk2KbZbKJ-d5AsaxKyh9Ind9do=s1600-w500', 21);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(37, 'pt_code_20', 'https://s3-media4.fl.yelpcdn.com/bphoto/8fNbCBVH_ApNeYf6xTSvdQ/o.jpg', 21);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(38, 'pt_code_20', 'https://s3-media2.fl.yelpcdn.com/bphoto/5dtQyTNeLLXNfwiYXhWEfg/o.jpg', 21);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(39, 'pt_code_20', 'https://s3-media3.fl.yelpcdn.com/bphoto/76sXvmE6ZyAynZdNnf482g/o.jpg', 21);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(40, 'pt_code_21', 'https://lh3.googleusercontent.com/p/AF1QipM2Y4UzHxlVMeET7rba9cqPIYMXcKs3ap2DHXMS=s1600-w500', 22);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(41, 'pt_code_21', 'https://lh3.googleusercontent.com/p/AF1QipMSXTW9Yi0fgVRHx5PdPbSzYJKjWxP-mRpwzoKc=s1600-w500', 22);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(42, 'pt_code_21', 'https://lh3.googleusercontent.com/p/AF1QipO-rYRCjg-3xllOMWY2Zv1coOqUZzLHC_8vNkQD=s1600-w500', 22);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(43, 'pt_code_21', 'https://lh3.googleusercontent.com/p/AF1QipNbmpii5xhl5EIHNeCmomHR1iizQa2FWjqZaWFT=s1600-w500', 22);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(44, 'pt_code_21', 'https://lh3.googleusercontent.com/p/AF1QipMT2N1T2k0V9H80UtuIAF5Gxy5SxzIuC1WHgXw=s1600-w500', 22);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(45, 'pt_code_21', 'https://lh3.googleusercontent.com/p/AF1QipOLxvoxxKXH4tlGQPp84LVUOXSw2sRsRZzVZng=s1600-w500', 22);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(46, 'pt_code_21', 'https://lh3.googleusercontent.com/p/AF1QipMg9EhvhD4p1h1sAX9YBeUeSLzf0TfWFzDdKyyg=s1600-w500', 22);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(47, 'pt_code_21', 'https://lh3.googleusercontent.com/p/AF1QipNd_nhRBZ-i01p_l-CXncQPLiR_hBH0X14yLjnG=s1600-w500', 22);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(48, 'pt_code_21', 'https://lh3.googleusercontent.com/p/AF1QipMkNP6Dmw9iH9j_Zt7v7OaHvcUYkGWCuMbDl2Ez=s1600-w500', 22);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(49, 'pt_code_21', 'https://lh3.googleusercontent.com/p/AF1QipPKHuEywZjP8abL46aM4N7drceQ2bj2Hpfwvu4o=s1600-w500', 22);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(50, 'pt_code_22', 'https://lh3.googleusercontent.com/p/AF1QipOiAdex4NxUs-o17jO7BI61_arSUYFy7rnUgtQj=s1600-w500', 23);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(51, 'pt_code_22', 'https://lh3.googleusercontent.com/p/AF1QipP0PbkNKiVc5pmUAmnCC9-NhwRdcpDE1LkLD5Jk=s1600-w500', 23);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(52, 'pt_code_22', 'https://lh3.googleusercontent.com/p/AF1QipM6I62qPkmt4zERNi14KgoE-a6XUeGdI3Bb5TF9=s1600-w500', 23);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(53, 'pt_code_22', 'https://lh3.googleusercontent.com/p/AF1QipMwFUzg6BLVzASgm3jDIauH9Jx55T7LpwiO5F_-=s1600-w500', 23);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(54, 'pt_code_22', 'https://lh3.googleusercontent.com/p/AF1QipNa44FAz5zaKWzcBRL6AD-rLwnxa8Z91dU1lk1Z=s1600-w500', 23);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(55, 'pt_code_22', 'https://lh3.googleusercontent.com/p/AF1QipMtQaJK00tLUeYwjky_oPojwvHq2-Z1-GNUso6M=s1600-w500', 23);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(56, 'pt_code_22', 'https://lh3.googleusercontent.com/p/AF1QipMfS-lXa_m_8UlAUjWq0A6llpFZz84K_U7xFFci=s1600-w500', 23);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(57, 'pt_code_22', 'https://lh3.googleusercontent.com/p/AF1QipPCsNF4G7lOnbLWG6NRuiBIwR8Ikd8gbsWs0RMQ=s1600-w500', 23);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(58, 'pt_code_22', 'https://lh3.googleusercontent.com/p/AF1QipM9odOukDO_uoUCnLbfTjiGf8O_lmqx71DP02FI=s1600-w500', 23);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(59, 'pt_code_22', 'https://lh3.googleusercontent.com/p/AF1QipMdtJJl55OKRDDEWPU4wLmlYMD0qZkWBARt49_e=s1600-w500', 23);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(60, 'pt_code_22', 'https://s3-media2.fl.yelpcdn.com/bphoto/VP9CpyhQ6whANwkTuds09g/o.jpg', 23);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(61, 'pt_code_22', 'https://s3-media4.fl.yelpcdn.com/bphoto/tLAFykTRzJZtKuzUrr7XcA/o.jpg', 23);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(62, 'pt_code_22', 'https://s3-media4.fl.yelpcdn.com/bphoto/FxzS62OfhqG_F-7Et5CYkw/o.jpg', 23);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(63, 'pt_code_23', 'https://lh3.googleusercontent.com/p/AF1QipNUkijt9LZJam--XN6WLCZ0o1HEUXjEkhC6ziA6=s1600-w500', 24);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(64, 'pt_code_23', 'https://lh3.googleusercontent.com/p/AF1QipM1_RPVBbYSBxXRV4sKmngqagELazoHoK7QzjiX=s1600-w500', 24);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(65, 'pt_code_23', 'https://lh3.googleusercontent.com/p/AF1QipOK41epFoKrFuP5rb2jeaqO6T3bPDttVgr7U0yT=s1600-w500', 24);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(66, 'pt_code_23', 'https://lh3.googleusercontent.com/p/AF1QipOUVC2l_xKDnHBJjV4OWT9z4kEs91wCMQKyC3PG=s1600-w500', 24);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(67, 'pt_code_23', 'https://lh3.googleusercontent.com/p/AF1QipM4038Gr5YFiSSxL8EwKY-5kGK-VnPOeiJKn2m1=s1600-w500', 24);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(68, 'pt_code_23', 'https://lh3.googleusercontent.com/p/AF1QipMsVDRN53EWfVSAw70hfbV0uZHv33MW8OVpv6gM=s1600-w500', 24);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(69, 'pt_code_23', 'https://lh3.googleusercontent.com/p/AF1QipNkwpv9L3PvU7rXtVW0ENKULngDSQpK2yjMKI-K=s1600-w500', 24);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(70, 'pt_code_23', 'https://lh3.googleusercontent.com/p/AF1QipOao5HpHuQbVQKxvwNuWS2dxxEudA2c8GkeZRBs=s1600-w500', 24);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(71, 'pt_code_23', 'https://lh3.googleusercontent.com/p/AF1QipNGhDlTa9NI43qD3FMfC5mRZoWwV3APVVt6QSKn=s1600-w500', 24);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(72, 'pt_code_23', 'https://lh3.googleusercontent.com/p/AF1QipONwP55TvCPkSMYhXq9zcqcjXghLa0PVgUAfCT8=s1600-w500', 24);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(73, 'pt_code_23', 'https://s3-media1.fl.yelpcdn.com/bphoto/XefYi4kSgfvRSSZBUWGRBw/o.jpg', 24);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(74, 'pt_code_23', 'https://s3-media3.fl.yelpcdn.com/bphoto/YUBW9KBqoMZ4Kb6Nzt2DZA/o.jpg', 24);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(75, 'pt_code_23', 'https://s3-media1.fl.yelpcdn.com/bphoto/vQODFeqzFHQ_TS8lBMvr-Q/o.jpg', 24);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(76, 'pt_code_24', 'https://lh3.googleusercontent.com/p/AF1QipMN63NsBD3F6vx65-jgsHg9taW3UZFaaUVdebnR=s1600-w500', 25);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(77, 'pt_code_24', 'https://lh3.googleusercontent.com/p/AF1QipN8kyF03dSk1f-7bEIAs2T1mfk3kAS-hexjmPo8=s1600-w500', 25);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(78, 'pt_code_24', 'https://lh3.googleusercontent.com/p/AF1QipObc6jCIk0GychFI8skhCKf5Ce5Qir1TnK9-uzC=s1600-w500', 25);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(79, 'pt_code_24', 'https://lh3.googleusercontent.com/p/AF1QipMq4iHFfsQqQcPPpTlnU9-qy_u0UmgHEA8fVNo6=s1600-w500', 25);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(80, 'pt_code_24', 'https://lh3.googleusercontent.com/p/AF1QipNpIaRVW_yHOx4C7kfJ-gnuZs7pMeEn8Uc2L2gT=s1600-w500', 25);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(81, 'pt_code_24', 'https://lh3.googleusercontent.com/p/AF1QipMqrgFekamTBAcPDcyu_pjZuJ71iwZavaVoFrml=s1600-w303', 25);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(82, 'pt_code_24', 'https://s3-media3.fl.yelpcdn.com/bphoto/CxaK0pYw6IUx27EXYcLdFA/o.jpg', 25);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(83, 'pt_code_24', 'https://s3-media4.fl.yelpcdn.com/bphoto/20NW6soYY95YA6rk8M7qWw/o.jpg', 25);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(84, 'pt_code_24', 'https://s3-media3.fl.yelpcdn.com/bphoto/6M5HjId2PE_FECR8Rnkkzw/o.jpg', 25);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(85, 'pt_code_25', 'https://lh3.googleusercontent.com/p/AF1QipMOaw-EYRywOqs8aiqZh7q0H7Gtb_FDoUxML2zi=s1600-w500', 26);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(86, 'pt_code_25', 'https://lh3.googleusercontent.com/p/AF1QipM13e5BOKM_tTHR3ZnAhlglq3FtW3XXfAjkrQtN=s1600-w500', 26);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(87, 'pt_code_25', 'https://lh3.googleusercontent.com/p/AF1QipMLhhPtbCA6EgvxMI0X-6PKdbl7FQ45dP1yozJv=s1600-w500', 26);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(88, 'pt_code_25', 'https://s3-media3.fl.yelpcdn.com/bphoto/ys47z9oYULwO8Hkp02wznA/o.jpg', 26);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(89, 'pt_code_25', 'https://s3-media2.fl.yelpcdn.com/bphoto/AMM4q8UVcn0gxktKRNE2HA/o.jpg', 26);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(90, 'pt_code_25', 'https://s3-media4.fl.yelpcdn.com/bphoto/7eYK0XnfUIhOqE-a0lvszg/o.jpg', 26);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(91, 'pt_code_26', 'https://lh3.googleusercontent.com/p/AF1QipMIikkDqnSfN56SBJkrfWdmT2Y-InQLVVI4-e-O=s1600-w500', 27);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(92, 'pt_code_26', 'https://lh3.googleusercontent.com/p/AF1QipPcKB_TUrH6maWcC38PLutttwFtUgyan316tHel=s1600-w500', 27);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(93, 'pt_code_26', 'https://lh3.googleusercontent.com/p/AF1QipMvzAzPx6a7aTZe-Ncp4pDcqeRl7bWt0xBBL7Ma=s1600-w500', 27);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(94, 'pt_code_26', 'https://lh3.googleusercontent.com/p/AF1QipPLqsILoRQ1OVJs9btpDjBa7XZf6y1nDuVZBIo=s1600-w500', 27);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(95, 'pt_code_26', 'https://lh3.googleusercontent.com/p/AF1QipNeUqWISmUz9qMyN1wFOIFYSQZOVVmAxh2OKCS2=s1600-w500', 27);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(96, 'pt_code_26', 'https://lh3.googleusercontent.com/p/AF1QipMjYV6lU9-FV4SBmMNWcKBxcIb9wiNK58CKKRM=s1600-w500', 27);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(97, 'pt_code_26', 'https://lh3.googleusercontent.com/p/AF1QipOBDV8j22HiviyzbnJjVxHf_3e1MxM8FpiNBbnc=s1600-w500', 27);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(98, 'pt_code_26', 'https://lh3.googleusercontent.com/p/AF1QipNp0e6L1fLqNcSZDcqUo7xzt72w0r7DcnW6glVs=s1600-w500', 27);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(99, 'pt_code_26', 'https://lh3.googleusercontent.com/p/AF1QipNcdnwHWis3XeSztQZajPTrXuRDaacK7AYGEWBS=s1600-w500', 27);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(100, 'pt_code_26', 'https://lh3.googleusercontent.com/p/AF1QipOALX_rafokS7Ja_69N2U5vNhQkwJhPUue3RXpC=s1600-w500', 27);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(101, 'pt_code_27', 'https://lh3.googleusercontent.com/p/AF1QipMb8zYd4rhz66l6edWK8Fsj9wqmR7Eg0xYlwUR4=s1600-w500', 28);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(102, 'pt_code_27', 'https://lh3.googleusercontent.com/p/AF1QipPV9CRrpq7qD523vNl-J7w_oRiO0dNYA_U4mqdw=s1600-w500', 28);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(103, 'pt_code_27', 'https://lh3.googleusercontent.com/p/AF1QipNvh0Q8UIuUF5qG9PgVUZ83AYuLvGZVwuj1WKYx=s1600-w500', 28);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(104, 'pt_code_27', 'https://lh3.googleusercontent.com/p/AF1QipPt11BuAvyEUvWSEAxNxLlfVlma74IvHJG8MasW=s1600-w500', 28);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(105, 'pt_code_27', 'https://lh3.googleusercontent.com/p/AF1QipOcvjkmjXhqOibpBamAjnyc7OKYKTQGa9Fig1po=s1600-w500', 28);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(106, 'pt_code_27', 'https://lh3.googleusercontent.com/p/AF1QipPG88JD23eyV_CrPR59i7ZHLxOFImT4C8R7d6Qm=s1600-w500', 28);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(107, 'pt_code_27', 'https://s3-media3.fl.yelpcdn.com/bphoto/SCR0y9kDLWXI-qydYH9iKg/o.jpg', 28);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(108, 'pt_code_27', 'https://s3-media1.fl.yelpcdn.com/bphoto/8lt26Tt1BRzZyWUiTv2s3w/o.jpg', 28);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(109, 'pt_code_27', 'https://s3-media1.fl.yelpcdn.com/bphoto/5fdG9Xu7PW4p6vMKRmA-Jw/o.jpg', 28);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(110, 'pt_code_28', 'https://lh3.googleusercontent.com/p/AF1QipM34ergsW8kJ2zN6ZWJSTabWdVlzxocDRQ5M0WV=s1600-w500', 29);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(111, 'pt_code_28', 'https://s3-media2.fl.yelpcdn.com/bphoto/STxtXz3JquGvwZ1D4pmxoA/o.jpg', 29);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(112, 'pt_code_28', 'https://s3-media3.fl.yelpcdn.com/bphoto/YUFHnRjTh2VQwMuW3jZ1TQ/o.jpg', 29);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(113, 'pt_code_28', 'https://s3-media2.fl.yelpcdn.com/bphoto/RLUoVWrTVvNgoLLQ4dE2JA/o.jpg', 29);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(114, 'pt_code_29', 'https://lh3.googleusercontent.com/p/AF1QipNATkYqMOsgUtVqEW4lYZ3RPDmelxxBDDmfzIdp=s1600-w500', 30);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(115, 'pt_code_29', 'https://lh3.googleusercontent.com/p/AF1QipMtMKK3arEWVpgoGHT7SfOey_k1L8IoHQV2iGo5=s1600-w500', 30);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(116, 'pt_code_29', 'https://lh3.googleusercontent.com/p/AF1QipPpbFAhnInyqD31IiZAr38-I6inD04kppHjuM6l=s1600-w500', 30);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(117, 'pt_code_29', 'https://lh3.googleusercontent.com/p/AF1QipO_d0l1b1YbzZF-wS_BGmdpyJUidf_-lUt7tr9t=s1600-w500', 30);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(118, 'pt_code_29', 'https://lh3.googleusercontent.com/p/AF1QipNMG02ZXT6uezuy9LttwFoypvYa2P4swHcNqt3s=s1600-w500', 30);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(119, 'pt_code_29', 'https://lh3.googleusercontent.com/p/AF1QipNRh0uHrHYSlvSxTkIgZEcaNTBsWvI3Mm-f_q18=s1600-w500', 30);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(120, 'pt_code_29', 'https://lh3.googleusercontent.com/p/AF1QipPSz5g-Z7BZA3csyIU9mds1impgWeCUk-iBGJx8=s1600-w500', 30);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(121, 'pt_code_29', 'https://lh3.googleusercontent.com/p/AF1QipNCPR1HwqmIIIc0Vh3jtApWZU20Gja7lKmhGnTZ=s1600-w500', 30);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(122, 'pt_code_29', 'https://lh3.googleusercontent.com/p/AF1QipMu6pIvC3nq_CHR7Xl3U35la-rePlT_LnP2n6Ng=s1600-w500', 30);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(123, 'pt_code_29', 'https://s3-media3.fl.yelpcdn.com/bphoto/ys47z9oYULwO8Hkp02wznA/o.jpg', 30);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(124, 'pt_code_29', 'https://s3-media2.fl.yelpcdn.com/bphoto/AMM4q8UVcn0gxktKRNE2HA/o.jpg', 30);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(125, 'pt_code_29', 'https://s3-media4.fl.yelpcdn.com/bphoto/7eYK0XnfUIhOqE-a0lvszg/o.jpg', 30);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(126, 'pt_code_30', 'https://lh3.googleusercontent.com/p/AF1QipPA5gzPOoWWlCG61ODvPctACZNk2QEgBSQgAJ_O=s1600-w500', 31);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(127, 'pt_code_30', 'https://lh3.googleusercontent.com/p/AF1QipO0A4ppXU1rqOAbgHts6uRpNrkrYV5TnbVc-onx=s1600-w303', 31);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(128, 'pt_code_30', 'https://s3-media3.fl.yelpcdn.com/bphoto/CxaK0pYw6IUx27EXYcLdFA/o.jpg', 31);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(129, 'pt_code_30', 'https://s3-media4.fl.yelpcdn.com/bphoto/20NW6soYY95YA6rk8M7qWw/o.jpg', 31);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(130, 'pt_code_30', 'https://s3-media3.fl.yelpcdn.com/bphoto/6M5HjId2PE_FECR8Rnkkzw/o.jpg', 31);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(131, 'pt_code_31', 'https://lh3.googleusercontent.com/p/AF1QipMPLfO3uyVPnecuSFBGA-TtyhN-fJdr8b473wyJ=s1600-w500', 32);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(132, 'pt_code_32', 'https://lh3.googleusercontent.com/p/AF1QipMU1UwdSp6IZVj8v6lZKQq7FypF_Bva7ozNUMo2=s1600-w500', 33);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(133, 'pt_code_32', 'https://lh3.googleusercontent.com/p/AF1QipNURA2nvtFbc3geK3wsDYwhHgxRaBSlm4cOZJJA=s1600-w500', 33);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(134, 'pt_code_32', 'https://lh3.googleusercontent.com/p/AF1QipP4N6U9sosec42Ddc-Ok9N8Q5ahXr5cohri2zpU=s1600-w500', 33);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(135, 'pt_code_32', 'https://lh3.googleusercontent.com/p/AF1QipObExZ642VGEOwAxWrEZzE7iu4tqwhdX4FODV5i=s1600-w500', 33);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(136, 'pt_code_32', 'https://lh3.googleusercontent.com/p/AF1QipM6CQJCuymqJvefVfmb3NyCYVIuTN8hFP1pOJnv=s1600-w500', 33);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(137, 'pt_code_32', 'https://lh3.googleusercontent.com/p/AF1QipMaAHV96QBEogUO2blHFz1GPMPbcrvaEKsqPeX1=s1600-w500', 33);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(138, 'pt_code_32', 'https://s3-media3.fl.yelpcdn.com/bphoto/SCR0y9kDLWXI-qydYH9iKg/o.jpg', 33);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(139, 'pt_code_32', 'https://s3-media1.fl.yelpcdn.com/bphoto/8lt26Tt1BRzZyWUiTv2s3w/o.jpg', 33);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(140, 'pt_code_32', 'https://s3-media1.fl.yelpcdn.com/bphoto/5fdG9Xu7PW4p6vMKRmA-Jw/o.jpg', 33);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(141, 'pt_code_33', 'https://lh3.googleusercontent.com/p/AF1QipMfoHbADmB5JWFRq3GA-_N-ARQ7kbOfveza09Mv=s1600-w500', 34);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(142, 'pt_code_33', 'https://lh3.googleusercontent.com/p/AF1QipPqqyGOeRau0oVxoHhiDjApJAZZqX0ZLZ0tLM3M=s1600-w500', 34);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(143, 'pt_code_33', 'https://lh3.googleusercontent.com/p/AF1QipOGccrKp44_igElR_NqrgCqq4nEPMp5ByilWVu3=s1600-w500', 34);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(144, 'pt_code_33', 'https://lh3.googleusercontent.com/p/AF1QipNXRGVHD5E73660LLoHcmy6xZ4fpintPtJ6g7To=s1600-w500', 34);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(145, 'pt_code_33', 'https://lh3.googleusercontent.com/p/AF1QipN6xSWbuDb4BZIiDVuuJ8QAe2rsM-17go2b8baU=s1600-w500', 34);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(146, 'pt_code_33', 'https://lh3.googleusercontent.com/p/AF1QipNBIt9Kg_C9Xd0_gpiM79xwITMuyBOPUapbAZ0j=s1600-w500', 34);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(147, 'pt_code_33', 'https://lh3.googleusercontent.com/p/AF1QipP3Ytv4sZPiSwnLkB4tiq4W73NNvVJxrAlLuv55=s1600-w500', 34);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(148, 'pt_code_33', 'https://s3-media3.fl.yelpcdn.com/bphoto/ys47z9oYULwO8Hkp02wznA/o.jpg', 34);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(149, 'pt_code_33', 'https://s3-media2.fl.yelpcdn.com/bphoto/AMM4q8UVcn0gxktKRNE2HA/o.jpg', 34);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(150, 'pt_code_33', 'https://s3-media4.fl.yelpcdn.com/bphoto/7eYK0XnfUIhOqE-a0lvszg/o.jpg', 34);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(151, 'pt_code_34', 'https://lh3.googleusercontent.com/p/AF1QipPd1aAq4QJZzH7Ol7oRh-_g2FmuXD1WYIw4ost7=s1600-w500', 35);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(152, 'pt_code_34', 'https://lh3.googleusercontent.com/p/AF1QipOh2bdZ8sFNXwznn3UxejKXs5ZbcQCGPl1lKWdT=s1600-w500', 35);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(153, 'pt_code_34', 'https://lh3.googleusercontent.com/p/AF1QipO342cw3qTRLtKugYTFrCpk3FtsNqiVbw48DIJL=s1600-w500', 35);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(154, 'pt_code_34', 'https://lh3.googleusercontent.com/p/AF1QipPJdT5oi4mxQXolfwv4jHov38BgTXb7gZXssklD=s1600-w500', 35);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(155, 'pt_code_34', 'https://lh3.googleusercontent.com/p/AF1QipNRpuDaQI65CQUaMx9jxu_44B53dBn73jCKSsgs=s1600-w500', 35);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(156, 'pt_code_34', 'https://lh3.googleusercontent.com/p/AF1QipOE226Rz0_9MLa24rNVikYn7NyTh0cQcEHAeGPA=s1600-w340', 35);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(157, 'pt_code_34', 'https://lh3.googleusercontent.com/p/AF1QipNYralpDGAbxWK46lYZnKxPfgu1VXvB4QmZpEFy=s1600-w500', 35);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(158, 'pt_code_34', 'https://lh3.googleusercontent.com/p/AF1QipOz4GbuPIIbcx6Ewk1q7bLSz2u9A_Oobr_DYB4z=s1600-w250', 35);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(159, 'pt_code_34', 'https://lh3.googleusercontent.com/p/AF1QipNF9Fn46wKqaJCLF_la8rdPhjNmRAKwRliJiyER=s1600-w500', 35);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(160, 'pt_code_34', 'https://lh3.googleusercontent.com/p/AF1QipNn0qCLZtD1GpoxoeAss7iYOpALNa0uC6WKmrHG=s1600-w500', 35);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(161, 'pt_code_34', 'https://s3-media2.fl.yelpcdn.com/bphoto/Ijy7snmDHjiekqVWYFUrBQ/o.jpg', 35);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(162, 'pt_code_34', 'https://s3-media1.fl.yelpcdn.com/bphoto/cP44wwwXYrSxFPWh5WKxXw/o.jpg', 35);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(163, 'pt_code_34', 'https://s3-media3.fl.yelpcdn.com/bphoto/rPSyXMSVRDU895yNWlOwRg/o.jpg', 35);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(164, 'pt_code_35', 'https://lh3.googleusercontent.com/p/AF1QipNeve-BQGiJ9EDrN-IA67h_n1EOslQpKV0898pl=s1600-w500', 36);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(165, 'pt_code_35', 'https://lh3.googleusercontent.com/p/AF1QipM2GzbC-ybAm6hqa-VlnL-MOYC0Kj6Fd4daARnH=s1600-w500', 36);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(166, 'pt_code_35', 'https://lh3.googleusercontent.com/p/AF1QipOk2uEizkQ2zX_38pzxhF7mI15xWULQ_9WAZflb=s1600-w500', 36);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(167, 'pt_code_35', 'https://lh3.googleusercontent.com/p/AF1QipOY9xc3sSLIaCp3zdWAjH4YIC7c9E01WTbs1XIo=s1600-w500', 36);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(168, 'pt_code_35', 'https://lh3.googleusercontent.com/p/AF1QipN4AkiizK90UBDZm34gLPtNhES3D962Z77gUNsy=s1600-w500', 36);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(169, 'pt_code_35', 'https://s3-media2.fl.yelpcdn.com/bphoto/STxtXz3JquGvwZ1D4pmxoA/o.jpg', 36);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(170, 'pt_code_35', 'https://s3-media3.fl.yelpcdn.com/bphoto/YUFHnRjTh2VQwMuW3jZ1TQ/o.jpg', 36);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(171, 'pt_code_35', 'https://s3-media2.fl.yelpcdn.com/bphoto/RLUoVWrTVvNgoLLQ4dE2JA/o.jpg', 36);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(172, 'pt_code_36', 'https://lh3.googleusercontent.com/p/AF1QipMiMx3GP2bxfdm-EOfWAObhm8ymAOhl9GGnLili=s1600-w500', 37);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(173, 'pt_code_36', 'https://lh3.googleusercontent.com/p/AF1QipPnjWsDiafHnjdvbhems10tWGUsJ1yBjfXlyaAL=s1600-w500', 37);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(174, 'pt_code_36', 'https://lh3.googleusercontent.com/p/AF1QipPXk6RcAU46-xpnq8_X4xpGU4BoAmZMgRRiMYtu=s1600-w500', 37);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(175, 'pt_code_36', 'https://lh3.googleusercontent.com/p/AF1QipPlv3f35dPcWqiYutMLGdomg5wUQKSj075zOMG0=s1600-w500', 37);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(176, 'pt_code_36', 'https://s3-media3.fl.yelpcdn.com/bphoto/ys47z9oYULwO8Hkp02wznA/o.jpg', 37);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(177, 'pt_code_36', 'https://s3-media2.fl.yelpcdn.com/bphoto/AMM4q8UVcn0gxktKRNE2HA/o.jpg', 37);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(178, 'pt_code_36', 'https://s3-media4.fl.yelpcdn.com/bphoto/7eYK0XnfUIhOqE-a0lvszg/o.jpg', 37);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(179, 'pt_code_37', 'https://s3-media1.fl.yelpcdn.com/bphoto/qBdONgB9_gda0ewv2yOKmg/o.jpg', 38);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(180, 'pt_code_37', 'https://s3-media3.fl.yelpcdn.com/bphoto/3fJe7CNqKa39aVRPl6ILeQ/o.jpg', 38);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(181, 'pt_code_37', 'https://s3-media2.fl.yelpcdn.com/bphoto/5qhuX9htJ9ypwqJkfc5T6Q/o.jpg', 38);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(182, 'pt_code_38', 'https://lh3.googleusercontent.com/p/AF1QipOh6IR-8uenps-R7JvFLZBhvzVclsN87pYHSYmG=s1600-w500', 39);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(183, 'pt_code_38', 'https://lh3.googleusercontent.com/p/AF1QipPsfn1Pu-0dKe76oxkXiFDPbxfK4nOKilLuBMo=s1600-w500', 39);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(184, 'pt_code_38', 'https://lh3.googleusercontent.com/p/AF1QipNPBlkwddCltzGCYI-d7Qar0MwCuhcrVknxTzzU=s1600-w500', 39);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(185, 'pt_code_38', 'https://lh3.googleusercontent.com/p/AF1QipPaw4-3oU0xJgHQBq6xdnyOLSIAk0W_w3-TNCWm=s1600-w500', 39);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(186, 'pt_code_38', 'https://lh3.googleusercontent.com/p/AF1QipPxG0VlzyH6lfgw0caW7sv7hItLbq2Pc6Itty53=s1600-w500', 39);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(187, 'pt_code_38', 'https://lh3.googleusercontent.com/p/AF1QipOansq9Om4blwAfMd5L4A1bepPtDXeDR-rbXySz=s1600-w500', 39);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(188, 'pt_code_38', 'https://lh3.googleusercontent.com/p/AF1QipM76iQNd9f1FFRWwSIFyFfQfZX5TAazECDVMSzl=s1600-w500', 39);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(189, 'pt_code_38', 'https://lh3.googleusercontent.com/p/AF1QipNCyPIDE2AGPJHdFmNukaJNoT7hUw24bC7s5YB-=s1600-w500', 39);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(190, 'pt_code_38', 'https://lh3.googleusercontent.com/p/AF1QipPJywpvvhdGv6f66kb1Ysd3s4pMcKDFn44aY8Cw=s1600-w500', 39);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(191, 'pt_code_38', 'https://lh3.googleusercontent.com/p/AF1QipPA1e9-wl8XbdDyeOU8lHjVsAq0ZNLaoH6sIaVy=s1600-w500', 39);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(192, 'pt_code_38', 'https://s3-media4.fl.yelpcdn.com/bphoto/oaNpK2uQX4QntCx2eKTq8Q/o.jpg', 39);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(193, 'pt_code_38', 'https://s3-media3.fl.yelpcdn.com/bphoto/3kIyV1jm7z2zTN1YwkdZ4g/o.jpg', 39);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(194, 'pt_code_38', 'https://s3-media2.fl.yelpcdn.com/bphoto/qLhJLqpUcxk_jha-UYlLlA/o.jpg', 39);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(195, 'pt_code_39', 'https://lh3.googleusercontent.com/p/AF1QipO4QHmXW6FCblpBoDlUAPjcLs4jjQAeAkWBXMWF=s1600-w500', 40);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(196, 'pt_code_39', 'https://lh3.googleusercontent.com/p/AF1QipNnBwwTJa_KNhiQrnvijwptpCQqF_PkilSjBcGG=s1600-w500', 40);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(197, 'pt_code_39', 'https://lh3.googleusercontent.com/p/AF1QipMvxhDxJXIs2EZZySWbuD7wqAQGft4G57kSa2Zf=s1600-w500', 40);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(198, 'pt_code_39', 'https://lh3.googleusercontent.com/p/AF1QipPzRfTeWDJILBxHC9tm8tlfm7-phcrywCSzw0ER=s1600-w500', 40);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(199, 'pt_code_39', 'https://lh3.googleusercontent.com/p/AF1QipNL3yduue45YkTqDuyyYNj6d70mjOZT8Ye_kJoL=s1600-w500', 40);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(200, 'pt_code_39', 'https://lh3.googleusercontent.com/p/AF1QipOlPTX151rTRRRWBY0UuAtj7_j3J8xNOONV1zol=s1600-w500', 40);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(201, 'pt_code_39', 'https://lh3.googleusercontent.com/p/AF1QipOB8-VRp6cneqGmgBavhbqQ6NK606h8E7j2nNYO=s1600-w500', 40);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(202, 'pt_code_39', 'https://lh3.googleusercontent.com/p/AF1QipNbQmprf9_Bbd7LI4hmrquZrFQjdviwdlG60w8K=s1600-w500', 40);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(203, 'pt_code_39', 'https://lh3.googleusercontent.com/p/AF1QipNhPWb1ASkb790FotyOGYG-lSrhPeqtFRIVHJcr=s1600-w500', 40);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(204, 'pt_code_39', 'https://lh3.googleusercontent.com/p/AF1QipP4O6YHEue461Fh25Rv1wnMoXM_c2bLC-5V_nSc=s1600-w500', 40);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(205, 'pt_code_39', 'https://s3-media1.fl.yelpcdn.com/bphoto/3oEbIFTQpS0-TdSpZoTz1g/o.jpg', 40);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(206, 'pt_code_39', 'https://s3-media1.fl.yelpcdn.com/bphoto/xSeZyP-UMIHGoJBIWFr_Bw/o.jpg', 40);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(207, 'pt_code_39', 'https://s3-media4.fl.yelpcdn.com/bphoto/7qXBJooyhLSQ3j7Rqw4okg/o.jpg', 40);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(208, 'pt_code_40', 'https://lh3.googleusercontent.com/p/AF1QipPZKqc25XW-3vlWtYzPMC2knvtYRVAidAp0KlRz=s1600-w500', 41);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(209, 'pt_code_40', 'https://lh3.googleusercontent.com/p/AF1QipN0F6mVtjrqnKRPKDkjPAP7gtA3oxgLEJwNPUPF=s1600-w500', 41);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(210, 'pt_code_41', 'https://s3-media2.fl.yelpcdn.com/bphoto/QTvaKD66xs4wJ5idEGE-DQ/o.jpg', 42);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(211, 'pt_code_41', 'https://s3-media3.fl.yelpcdn.com/bphoto/1aYsTPXde_Hcu9KI_8ezYw/o.jpg', 42);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(212, 'pt_code_41', 'https://s3-media1.fl.yelpcdn.com/bphoto/CVjbHXAiA_aAiR-78SIhQA/o.jpg', 42);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(213, 'pt_code_42', 'https://lh3.googleusercontent.com/p/AF1QipPA15MaF4yZWb8fFRbPnXakAZT0ZoZ_go25NUBV=s1600-w500', 43);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(214, 'pt_code_42', 'https://lh3.googleusercontent.com/p/AF1QipNAFIbUH-r6K3yQMPKQH3L0T0D_4l9JInYCgwWo=s1600-w500', 43);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(215, 'pt_code_42', 'https://lh3.googleusercontent.com/p/AF1QipM-iLT8R3V5xzYZ-bTOjrrD2olBlEJRKRcg1sjj=s1600-w500', 43);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(216, 'pt_code_42', 'https://lh3.googleusercontent.com/p/AF1QipOs7ScPHhhgE52B5V5gRL3u9EkXoWErSx6veo6c=s1600-w500', 43);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(217, 'pt_code_42', 'https://lh3.googleusercontent.com/p/AF1QipM8_y8BPvc62Y6-9rpUAldFB8EEjF0qm7jTN5h5=s1600-w500', 43);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(218, 'pt_code_42', 'https://lh3.googleusercontent.com/p/AF1QipOch4XqTOre3iB4ANODmwSUGSTsd4L3557bveY6=s1600-w500', 43);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(219, 'pt_code_42', 'https://lh3.googleusercontent.com/p/AF1QipP8nGIIguiiR4a0PQUfumOitC0JPocfx2_uDIhh=s1600-w500', 43);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(220, 'pt_code_42', 'https://lh3.googleusercontent.com/p/AF1QipPbT-OhACtgaRUz2J5ExvW_MP3ZxDagYhRhSGyX=s1600-w500', 43);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(221, 'pt_code_42', 'https://lh3.googleusercontent.com/p/AF1QipMVJOZiSQe7pzfnAK9KtTwJcNJ24eqVVFbAH3BE=s1600-w500', 43);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(222, 'pt_code_42', 'https://lh3.googleusercontent.com/p/AF1QipPamEakjuHYL9bpFBdIJMq5LlmCQasW7t2cbPJ-=s1600-w500', 43);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(223, 'pt_code_42', 'https://s3-media4.fl.yelpcdn.com/bphoto/e0lOxAVSaEySsWdyZktrbQ/o.jpg', 43);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(224, 'pt_code_42', 'https://s3-media2.fl.yelpcdn.com/bphoto/6aPpubcs4nlk0RGjUvKn0w/o.jpg', 43);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(225, 'pt_code_42', 'https://s3-media1.fl.yelpcdn.com/bphoto/cUr3RtaAxF01o9n4sRu90g/o.jpg', 43);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(226, 'pt_code_43', 'https://lh3.googleusercontent.com/p/AF1QipP3nBRCxPkytVW6YBsct8UxJ84p9-ojvdELpp-V=s1600-w338', 44);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(227, 'pt_code_43', 'https://lh3.googleusercontent.com/p/AF1QipNFY4c4nvGXMWYniKAq4DTAi1AaveEW1UyLTZBY=s1600-w500', 44);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(228, 'pt_code_43', 'https://lh3.googleusercontent.com/p/AF1QipOFjUUUitTOVK3jV0Ec-dI6yj3E-yzH4uWx40B5=s1600-w500', 44);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(229, 'pt_code_43', 'https://lh3.googleusercontent.com/p/AF1QipNn-IHpW4HUAMWZcJKdeNQE8fX-fg8OMQRWO920=s1600-w338', 44);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(230, 'pt_code_43', 'https://lh3.googleusercontent.com/p/AF1QipNZk6a4b_dGoteNrhgN-jw3T6TfjTfjyCByel34=s1600-w500', 44);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(231, 'pt_code_43', 'https://lh3.googleusercontent.com/p/AF1QipPIMUe0UhAhRc_DbMsbR5-nTHmABTwoasGdbXXw=s1600-w500', 44);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(232, 'pt_code_43', 'https://lh3.googleusercontent.com/p/AF1QipNDW8a0xon-yDE_9DcOTVD6RX-y4W0Aqbnpd7XW=s1600-w500', 44);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(233, 'pt_code_43', 'https://lh3.googleusercontent.com/p/AF1QipP1PvuzyLxqO_xbPqViqpfqTuIh1FhHp-5D9yx2=s1600-w500', 44);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(234, 'pt_code_43', 'https://lh3.googleusercontent.com/p/AF1QipO1HC538Bk9kryMQU3MlnkeioSAWTJhQLOG3ri0=s1600-w500', 44);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(235, 'pt_code_43', 'https://lh3.googleusercontent.com/p/AF1QipPKSMpI-zVRVFd7DfxI5StNgIsToquAZumtOJPr=s1600-w500', 44);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(236, 'pt_code_43', 'https://s3-media2.fl.yelpcdn.com/bphoto/5ByrnD1Ljf140kujHWgbsA/o.jpg', 44);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(237, 'pt_code_43', 'https://s3-media4.fl.yelpcdn.com/bphoto/sf3uO_yUlQN-Yjua2J5lLg/o.jpg', 44);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(238, 'pt_code_43', 'https://s3-media2.fl.yelpcdn.com/bphoto/mOhHG4tfgCQ8DOgtCZT9yA/o.jpg', 44);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(239, 'pt_code_44', 'https://lh3.googleusercontent.com/p/AF1QipODdfz6FmRCTt3dCzi9NOIkiBJAhvf5cA_Ra539=s1600-w500', 45);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(240, 'pt_code_44', 'https://lh3.googleusercontent.com/p/AF1QipMO6Fo6JeRdZwvUlG-AR4T2Qp12bkhkoVZ4vu3v=s1600-w500', 45);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(241, 'pt_code_44', 'https://lh3.googleusercontent.com/p/AF1QipNopar3AJOkbDeR8sQdRfMUGlSePzo98Yz483Jr=s1600-w500', 45);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(242, 'pt_code_44', 'https://lh3.googleusercontent.com/p/AF1QipMFmzbv79aNtAtpMHzR31K-aQv8Ss3-_Fl1Yl3E=s1600-w500', 45);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(243, 'pt_code_44', 'https://lh3.googleusercontent.com/p/AF1QipNeRLB2izm1PsoNicPLE0Nt1pzCzClKe0HvsU2h=s1600-w500', 45);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(244, 'pt_code_44', 'https://lh3.googleusercontent.com/p/AF1QipNf0KxLJvX_JeiSKpRjFjA3zYDdMfhV8nETQjOx=s1600-w500', 45);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(245, 'pt_code_44', 'https://lh3.googleusercontent.com/p/AF1QipPEsOeowuJFop9VU91DNCKt2r7DUNucUEiTkAoR=s1600-w500', 45);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(246, 'pt_code_44', 'https://lh3.googleusercontent.com/p/AF1QipMST_ETiUULCgelcinaHApZFc9idNtnTXjnGnlX=s1600-w500', 45);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(247, 'pt_code_44', 'https://lh3.googleusercontent.com/p/AF1QipPkepGEwixcrC5NjOeh8ZKFtytszFEU2hHw1rCH=s1600-w500', 45);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(248, 'pt_code_44', 'https://lh3.googleusercontent.com/p/AF1QipPWnaemx7mEf6lnCSYVtnlp5MWbWx_K8OtDXjfF=s1600-w500', 45);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(249, 'pt_code_44', 'https://s3-media2.fl.yelpcdn.com/bphoto/-5tEdAxXffaUEmH8qXkS_g/o.jpg', 45);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(250, 'pt_code_44', 'https://s3-media1.fl.yelpcdn.com/bphoto/p25k9vlfVp4WQYVS_MAAXw/o.jpg', 45);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(251, 'pt_code_44', 'https://s3-media1.fl.yelpcdn.com/bphoto/bmtksmIQRta4cEgqO3JtLg/o.jpg', 45);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(252, 'pt_code_45', 'https://lh3.googleusercontent.com/p/AF1QipNpmzU32ta7jzBh1iu-Gtnt1tL2Eqxl6FLgrjFX=s1600-w500', 46);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(253, 'pt_code_45', 'https://lh3.googleusercontent.com/p/AF1QipNlN4LNpu01fa6H1RT66BKaGPCXsPAZJMbFViOu=s1600-w500', 46);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(254, 'pt_code_45', 'https://lh3.googleusercontent.com/p/AF1QipNc7Z086EqpcIoKTdONA3J3wymicDDBJMMC7G2H=s1600-w500', 46);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(255, 'pt_code_45', 'https://lh3.googleusercontent.com/p/AF1QipMjqSC34jJo1-l_DAKT-7SDf5OUM7lMkhnf6Tba=s1600-w500', 46);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(256, 'pt_code_45', 'https://lh3.googleusercontent.com/p/AF1QipPlBcgniZMp_laZwYD6GhXZIuRz9h18LYRyokLh=s1600-w500', 46);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(257, 'pt_code_45', 'https://lh3.googleusercontent.com/p/AF1QipNm5uduXxgyugB1CKC9h0FEdbkTa--EqaIlqPIH=s1600-w500', 46);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(258, 'pt_code_45', 'https://lh3.googleusercontent.com/p/AF1QipNm2uymAZLV6UbZTuJ48k-FeVt4BsArXnPD4mmM=s1600-w500', 46);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(259, 'pt_code_45', 'https://lh3.googleusercontent.com/p/AF1QipNyuO-2Dxd9FnSnj2lC0wimAUKvuG9xaA6GIRYy=s1600-w500', 46);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(260, 'pt_code_45', 'https://lh3.googleusercontent.com/p/AF1QipPvbFescd3eQTrBK6qRhXvxyI7XTMXjkMfE_s5Q=s1600-w500', 46);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(261, 'pt_code_45', 'https://lh3.googleusercontent.com/p/AF1QipPmV1y-i6KCqX1Umy3i-cJnDswpHJiRhVoK4v_P=s1600-w500', 46);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(262, 'pt_code_45', 'https://s3-media2.fl.yelpcdn.com/bphoto/8jelgHxyHVNSnH4id7hBGQ/o.jpg', 46);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(263, 'pt_code_45', 'https://s3-media3.fl.yelpcdn.com/bphoto/qpLAG77KCpITnq4wfQLzVA/o.jpg', 46);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(264, 'pt_code_45', 'https://s3-media2.fl.yelpcdn.com/bphoto/ihkOHC3cWoe7wMk2tNXFBA/o.jpg', 46);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(265, 'pt_code_46', 'https://lh3.googleusercontent.com/p/AF1QipPlGDniI0D7R-mDqpKf1LE7I_63oAPTpelJF3d3=s1600-w500', 47);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(266, 'pt_code_46', 'https://lh3.googleusercontent.com/p/AF1QipPRoi038RqnpLnSbYmlLA6xawsH5yZeoJ7q15F4=s1600-w500', 47);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(267, 'pt_code_46', 'https://lh3.googleusercontent.com/p/AF1QipOihqNKDOjt5O-6L-MD9WPFBcHB83pq7zUwJqUr=s1600-w500', 47);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(268, 'pt_code_46', 'https://lh3.googleusercontent.com/p/AF1QipM9KsyWfwVMpJN7R6hQKJ7-rQ9hzNDwtZ0wYhcd=s1600-w500', 47);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(269, 'pt_code_46', 'https://lh3.googleusercontent.com/p/AF1QipPBp4Ss87GuXT-77gyhL6UINi0QbUoHi9utQxZM=s1600-w500', 47);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(270, 'pt_code_46', 'https://lh3.googleusercontent.com/p/AF1QipNUERkNaZDaFHZsajicqNEqIuKDh7bUhaR96eXb=s1600-w500', 47);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(271, 'pt_code_46', 'https://lh3.googleusercontent.com/p/AF1QipNvLwD0G2h79pt6B_oFVepiRYPXyyg24ETbZoRx=s1600-w500', 47);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(272, 'pt_code_46', 'https://lh3.googleusercontent.com/p/AF1QipNWPEvmWqtF6x_FjENm0BLjubqdbMxmvRLdKBtJ=s1600-w500', 47);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(273, 'pt_code_46', 'https://lh3.googleusercontent.com/p/AF1QipP2yxp2f0v9ClSvh5JHll2bCfEWePJPzMd-8qBq=s1600-w500', 47);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(274, 'pt_code_46', 'https://lh3.googleusercontent.com/p/AF1QipPTZOzT3UeypXDarK3ro_2nnHWN070wDmfHFJYU=s1600-w500', 47);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(275, 'pt_code_46', 'https://s3-media4.fl.yelpcdn.com/bphoto/fEQYxgabfAA8qDDFOCPY7Q/o.jpg', 47);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(276, 'pt_code_46', 'https://s3-media1.fl.yelpcdn.com/bphoto/uHFTL-BSWYjaq6AxKsOucA/o.jpg', 47);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(277, 'pt_code_46', 'https://s3-media2.fl.yelpcdn.com/bphoto/FGcRZYzCO25c9Gf9JCrkgw/o.jpg', 47);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(278, 'pt_code_47', 'https://lh3.googleusercontent.com/p/AF1QipP_858CtPiz1Wm--5kr8Xgi83u4Q8dFizBVow8a=s1600-w500', 48);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(279, 'pt_code_47', 'https://lh3.googleusercontent.com/p/AF1QipOZ5pF5-rP8QIQCkTaU3CxY6MiJ_PjpPEb3wZqF=s1600-w500', 48);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(280, 'pt_code_47', 'https://lh3.googleusercontent.com/p/AF1QipPerTh3Yt4pmgV5kS8I3BjEuzQYVUd3EcSkgd1N=s1600-w500', 48);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(281, 'pt_code_47', 'https://lh3.googleusercontent.com/p/AF1QipPZko_IWo-fN2MGB0LApV36D1iuOQxJ3AU3NbU6=s1600-w500', 48);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(282, 'pt_code_47', 'https://lh3.googleusercontent.com/p/AF1QipOgGIxUGMFp3xPAeL9sh0n18_gerxBDwn9rvUGx=s1600-w500', 48);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(283, 'pt_code_47', 'https://lh3.googleusercontent.com/p/AF1QipO71yb7mk_JKalbSdHu7evCCMXs9Ro_xt5IECwW=s1600-w480', 48);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(284, 'pt_code_47', 'https://lh3.googleusercontent.com/p/AF1QipOc5cKSDAuCo7XioaTGyQ1EBJkcn5X4HTU28Rsv=s1600-w500', 48);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(285, 'pt_code_47', 'https://lh3.googleusercontent.com/p/AF1QipPMDfoQSxKxlLBOFHYD-4_qL7spjRPsyRoWK1mq=s1600-w500', 48);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(286, 'pt_code_47', 'https://lh3.googleusercontent.com/p/AF1QipOxQWFPHs01bh5zvHytYIGOT5tzDdwcPiKMweGR=s1600-w500', 48);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(287, 'pt_code_47', 'https://lh3.googleusercontent.com/p/AF1QipOVt7JpiM6jz4YnA2_L2IjzD1PtwXIdZbshGK6a=s1600-w500', 48);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(288, 'pt_code_47', 'https://s3-media1.fl.yelpcdn.com/bphoto/ciV36ag7rAa5A94ligGyrA/o.jpg', 48);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(289, 'pt_code_47', 'https://s3-media3.fl.yelpcdn.com/bphoto/tv6thviLnRGzrmSypN_-pQ/o.jpg', 48);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(290, 'pt_code_47', 'https://s3-media3.fl.yelpcdn.com/bphoto/6KsXi49chbHqVTsiQI0kEg/o.jpg', 48);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(291, 'pt_code_48', 'https://lh3.googleusercontent.com/p/AF1QipMMtOnJJE9GpovyCXwB1rnJOwogvHDsvXkLDoUl=s1600-w500', 49);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(292, 'pt_code_48', 'https://lh3.googleusercontent.com/p/AF1QipPl3zC18o9WHXlnJPyXWLP4BdfhG9h0_nnDx59y=s1600-w500', 49);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(293, 'pt_code_48', 'https://lh3.googleusercontent.com/p/AF1QipNXI-eIVZ2-R0QVER6MogN2rpG7pd7Uh6oGd5ou=s1600-w500', 49);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(294, 'pt_code_48', 'https://lh3.googleusercontent.com/p/AF1QipNHPwvm73fV8EKwWJbn1yZqPXqFfG0g2KXmDgU=s1600-w500', 49);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(295, 'pt_code_48', 'https://lh3.googleusercontent.com/p/AF1QipP8zIAFt-01vcKVkJyp_LzEkzz2WZM9ZNOb35i7=s1600-w500', 49);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(296, 'pt_code_48', 'https://lh3.googleusercontent.com/p/AF1QipO-gzMISBAl4K9hq_j9a_vMEN6UrmY4tmuU7C6O=s1600-w480', 49);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(297, 'pt_code_48', 'https://lh3.googleusercontent.com/p/AF1QipOv56xT1WlrU1qKJXht2WEoqyJagmtgiw1wiSZE=s1600-w500', 49);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(298, 'pt_code_48', 'https://lh3.googleusercontent.com/p/AF1QipODrPHOdgdIeNeiV3YaWH-DQ5SaZkMIYpAoGD7s=s1600-w500', 49);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(299, 'pt_code_48', 'https://lh3.googleusercontent.com/p/AF1QipNHQQx90CKiHkv5Me80t869I10Zs_PTOwF7e4j4=s1600-w500', 49);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(300, 'pt_code_48', 'https://lh3.googleusercontent.com/p/AF1QipPHvMLugkFh5UX7FyrBUn2LH6-w_msCgbjP7ti7=s1600-w500', 49);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(301, 'pt_code_48', 'https://s3-media3.fl.yelpcdn.com/bphoto/nfSKF3eI7NKVBzKlCrNojQ/o.jpg', 49);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(302, 'pt_code_48', 'https://s3-media4.fl.yelpcdn.com/bphoto/lyXRXLWf__82BObzT7VnZQ/o.jpg', 49);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(303, 'pt_code_48', 'https://s3-media2.fl.yelpcdn.com/bphoto/xG3ar8Se19WYLbczpn8WYQ/o.jpg', 49);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(304, 'pt_code_49', 'https://lh3.googleusercontent.com/p/AF1QipMJFNGfMKDp21nKRhEmnCfwnphX_ESblolS3GjN=s1600-w500', 50);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(305, 'pt_code_49', 'https://lh3.googleusercontent.com/p/AF1QipOyH14XatAmOqFjnsgMWUXAe6vZmIztD8HxcbRI=s1600-w500', 50);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(306, 'pt_code_49', 'https://lh3.googleusercontent.com/p/AF1QipPmf0GJSWhnaPG53YFY9Mp7TbyWqdUnfaQDOTus=s1600-w500', 50);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(307, 'pt_code_49', 'https://lh3.googleusercontent.com/p/AF1QipOmSy7dudN9xDGXl6rywL5LcAqHJEG7B1KzKrjZ=s1600-w500', 50);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(308, 'pt_code_49', 'https://lh3.googleusercontent.com/p/AF1QipMRJpFqEmiQKPCpAtRG5_QsKvIkzH7FBMR2Ohlr=s1600-w500', 50);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(309, 'pt_code_49', 'https://lh3.googleusercontent.com/p/AF1QipNzHO-rNQU11Cb48uU-d4f8dKI-AgktOD62KRDB=s1600-w500', 50);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(310, 'pt_code_49', 'https://lh3.googleusercontent.com/p/AF1QipMGBI0tbLkYsrv2kiKmA9ATnOWrOdf3BDg92hyf=s1600-w500', 50);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(311, 'pt_code_49', 'https://lh3.googleusercontent.com/p/AF1QipNMnzc2zJUFHfQfYecIvKhJ5r4tUaVekxtHv721=s1600-w500', 50);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(312, 'pt_code_49', 'https://lh3.googleusercontent.com/p/AF1QipN0ullmqfDUwaG4_SolPpJk5bkLPDzimQghhGyt=s1600-w500', 50);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(313, 'pt_code_49', 'https://lh3.googleusercontent.com/p/AF1QipNNUExsvZmlhTo13gFEWdg46CR-9iI6kts1k1-u=s1600-w500', 50);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(314, 'pt_code_50', 'https://lh3.googleusercontent.com/p/AF1QipNF-WTFzmS03OJpmr0cRX0e7rjWePIKNtV4Aa-X=s1600-w500', 51);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(315, 'pt_code_50', 'https://lh3.googleusercontent.com/p/AF1QipMZRGC2TDvnQsesVmRbKXlqaSF6bvQort7UiDTY=s1600-w500', 51);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(316, 'pt_code_50', 'https://lh3.googleusercontent.com/p/AF1QipMo-RBvC_6SQ0GMTYM805oXxM5CsF_RefiNjMrH=s1600-w500', 51);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(317, 'pt_code_50', 'https://lh3.googleusercontent.com/p/AF1QipNtJB3BTuOL6Zw8TkBCtNzyWwZhUkA4sa-WXEVo=s1600-w500', 51);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(318, 'pt_code_50', 'https://lh3.googleusercontent.com/p/AF1QipPTGo0nWV4HhsxrpbNCKeoXLGaYDyQRAdxOR_6v=s1600-w500', 51);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(319, 'pt_code_50', 'https://lh3.googleusercontent.com/p/AF1QipPJaTnMs3upGyXbd8PyqQVeuOBYKUdMh1xASO-N=s1600-w500', 51);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(320, 'pt_code_50', 'https://s3-media3.fl.yelpcdn.com/bphoto/RLUeOuDuHJ4JTChGnGJwGA/o.jpg', 51);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(321, 'pt_code_50', 'https://s3-media3.fl.yelpcdn.com/bphoto/uoU95dZZ6D-b0kjOVaA6DQ/o.jpg', 51);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(322, 'pt_code_50', 'https://s3-media1.fl.yelpcdn.com/bphoto/pSg6nWRp7aUauPUwVh1OpQ/o.jpg', 51);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(323, 'pt_code_51', 'https://lh3.googleusercontent.com/p/AF1QipPQ9l9lWaAQJWBf3almKev9bDB3A-wWxM0pQW4I=s1600-w500', 52);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(324, 'pt_code_51', 'https://lh3.googleusercontent.com/p/AF1QipP7MskgOXPvrR2ko6tHZid6VfkinzhDi3hjnRPj=s1600-w500', 52);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(325, 'pt_code_51', 'https://lh3.googleusercontent.com/p/AF1QipMEDGlgF1Cg79w8SIey8yx8xaPMTPWElu_r1FZY=s1600-w500', 52);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(326, 'pt_code_51', 'https://lh3.googleusercontent.com/p/AF1QipMVsK-eDJxbyMys0_arJMv2w5W2SBOTaFAm3VNy=s1600-w500', 52);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(327, 'pt_code_51', 'https://lh3.googleusercontent.com/p/AF1QipNefEiF617dS_eX5iOfFJzhbdatX8cDDbymGtd0=s1600-w500', 52);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(328, 'pt_code_51', 'https://lh3.googleusercontent.com/p/AF1QipPoa8mM-_5jLe37FRlLFoSSIeJespKKq_FDllJR=s1600-w500', 52);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(329, 'pt_code_51', 'https://lh3.googleusercontent.com/p/AF1QipMaR0DHTmpOI26yglQz4siKMrljyNtXZyLKhGtJ=s1600-w500', 52);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(330, 'pt_code_51', 'https://lh3.googleusercontent.com/p/AF1QipN87PLTQKopLOeWxpGAzIBTgA6i9n_KRnkUHyPS=s1600-w500', 52);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(331, 'pt_code_51', 'https://lh3.googleusercontent.com/p/AF1QipNaskADo1iRkrKzHxRYMfXJpe0eWkBpo1IpL1W7=s1600-w327', 52);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(332, 'pt_code_51', 'https://s3-media2.fl.yelpcdn.com/bphoto/3umV74vqmvKMNIyYsg-H8g/o.jpg', 52);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(333, 'pt_code_51', 'https://s3-media4.fl.yelpcdn.com/bphoto/ibAOW10q7JrqB05oRQlMwQ/o.jpg', 52);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(334, 'pt_code_51', 'https://s3-media4.fl.yelpcdn.com/bphoto/bSDwj1EXMrdJH2P9vcYaYQ/o.jpg', 52);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(335, 'pt_code_52', 'https://lh3.googleusercontent.com/p/AF1QipPHzUQfD2FIi0-PE7nygzrMTIWZn-YRx2-1z2FJ=s1600-w500', 53);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(336, 'pt_code_52', 'https://lh3.googleusercontent.com/p/AF1QipMcFSlWmwcrRPTWkH7Zn8faXSIIjlQrZpeoVHng=s1600-w500', 53);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(337, 'pt_code_52', 'https://lh3.googleusercontent.com/p/AF1QipNHy45_gz_28DXscdvZkx1kJh4yLCLrqRuAz8nG=s1600-w500', 53);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(338, 'pt_code_52', 'https://lh3.googleusercontent.com/p/AF1QipNU-2oVzwy0FtX_YclBEi6a2oxpy0AufcDsS57M=s1600-w500', 53);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(339, 'pt_code_52', 'https://lh3.googleusercontent.com/p/AF1QipPZDc3RDavb7cJ2QS8NwjDt6AHSDe6aQczoIC-S=s1600-w500', 53);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(340, 'pt_code_52', 'https://lh3.googleusercontent.com/p/AF1QipNnSDYWqAW8qv2hZHwKiil_h5uK8XtWuJbNGu3K=s1600-w500', 53);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(341, 'pt_code_52', 'https://lh3.googleusercontent.com/p/AF1QipMzcVTCDtCgJan4E7nIJQe_pZ7DJs_u8aGO_9Gt=s1600-w500', 53);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(342, 'pt_code_52', 'https://lh3.googleusercontent.com/p/AF1QipO96YWR7lyh0kxKEc-DsRSrvfFn5Iw6DOSBVaX3=s1600-w500', 53);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(343, 'pt_code_52', 'https://lh3.googleusercontent.com/p/AF1QipNh9zii0kol2SihpEfgYa1o0rPkjzC541mQ7C_d=s1600-w500', 53);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(344, 'pt_code_52', 'https://lh3.googleusercontent.com/p/AF1QipPet0Lono2boEqk2KbZbKJ-d5AsaxKyh9Ind9do=s1600-w500', 53);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(345, 'pt_code_52', 'https://s3-media4.fl.yelpcdn.com/bphoto/8fNbCBVH_ApNeYf6xTSvdQ/o.jpg', 53);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(346, 'pt_code_52', 'https://s3-media2.fl.yelpcdn.com/bphoto/5dtQyTNeLLXNfwiYXhWEfg/o.jpg', 53);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(347, 'pt_code_52', 'https://s3-media3.fl.yelpcdn.com/bphoto/76sXvmE6ZyAynZdNnf482g/o.jpg', 53);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(348, 'pt_code_53', 'https://lh3.googleusercontent.com/p/AF1QipNUkijt9LZJam--XN6WLCZ0o1HEUXjEkhC6ziA6=s1600-w500', 54);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(349, 'pt_code_53', 'https://lh3.googleusercontent.com/p/AF1QipM1_RPVBbYSBxXRV4sKmngqagELazoHoK7QzjiX=s1600-w500', 54);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(350, 'pt_code_53', 'https://lh3.googleusercontent.com/p/AF1QipOK41epFoKrFuP5rb2jeaqO6T3bPDttVgr7U0yT=s1600-w500', 54);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(351, 'pt_code_53', 'https://lh3.googleusercontent.com/p/AF1QipOUVC2l_xKDnHBJjV4OWT9z4kEs91wCMQKyC3PG=s1600-w500', 54);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(352, 'pt_code_53', 'https://lh3.googleusercontent.com/p/AF1QipM4038Gr5YFiSSxL8EwKY-5kGK-VnPOeiJKn2m1=s1600-w500', 54);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(353, 'pt_code_53', 'https://lh3.googleusercontent.com/p/AF1QipMsVDRN53EWfVSAw70hfbV0uZHv33MW8OVpv6gM=s1600-w500', 54);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(354, 'pt_code_53', 'https://lh3.googleusercontent.com/p/AF1QipNkwpv9L3PvU7rXtVW0ENKULngDSQpK2yjMKI-K=s1600-w500', 54);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(355, 'pt_code_53', 'https://lh3.googleusercontent.com/p/AF1QipOao5HpHuQbVQKxvwNuWS2dxxEudA2c8GkeZRBs=s1600-w500', 54);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(356, 'pt_code_53', 'https://lh3.googleusercontent.com/p/AF1QipNGhDlTa9NI43qD3FMfC5mRZoWwV3APVVt6QSKn=s1600-w500', 54);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(357, 'pt_code_53', 'https://lh3.googleusercontent.com/p/AF1QipONwP55TvCPkSMYhXq9zcqcjXghLa0PVgUAfCT8=s1600-w500', 54);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(358, 'pt_code_53', 'https://s3-media1.fl.yelpcdn.com/bphoto/XefYi4kSgfvRSSZBUWGRBw/o.jpg', 54);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(359, 'pt_code_53', 'https://s3-media3.fl.yelpcdn.com/bphoto/YUBW9KBqoMZ4Kb6Nzt2DZA/o.jpg', 54);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(360, 'pt_code_53', 'https://s3-media1.fl.yelpcdn.com/bphoto/vQODFeqzFHQ_TS8lBMvr-Q/o.jpg', 54);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(361, 'pt_code_54', 'https://s3-media3.fl.yelpcdn.com/bphoto/_Tydktl9IgkmaxWqgs8OWA/o.jpg', 55);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(362, 'pt_code_54', 'https://s3-media4.fl.yelpcdn.com/bphoto/Ny24KdrfXqQ8OrMR0N4ZEw/o.jpg', 55);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(363, 'pt_code_55', 'https://s3-media2.fl.yelpcdn.com/bphoto/ZBzH3Qk8glqxO4JCkcR3aA/o.jpg', 56);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(364, 'pt_code_55', 'https://s3-media2.fl.yelpcdn.com/bphoto/sZsazdG7WwxCsoJFydnGgw/o.jpg', 56);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(365, 'pt_code_55', 'https://s3-media1.fl.yelpcdn.com/bphoto/lP1Nry_ewxVC2y74gtpiVw/o.jpg', 56);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(366, 'pt_code_56', 'https://lh3.googleusercontent.com/p/AF1QipNUkijt9LZJam--XN6WLCZ0o1HEUXjEkhC6ziA6=s1600-w500', 57);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(367, 'pt_code_56', 'https://lh3.googleusercontent.com/p/AF1QipM1_RPVBbYSBxXRV4sKmngqagELazoHoK7QzjiX=s1600-w500', 57);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(368, 'pt_code_56', 'https://lh3.googleusercontent.com/p/AF1QipOK41epFoKrFuP5rb2jeaqO6T3bPDttVgr7U0yT=s1600-w500', 57);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(369, 'pt_code_56', 'https://lh3.googleusercontent.com/p/AF1QipOUVC2l_xKDnHBJjV4OWT9z4kEs91wCMQKyC3PG=s1600-w500', 57);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(370, 'pt_code_56', 'https://lh3.googleusercontent.com/p/AF1QipM4038Gr5YFiSSxL8EwKY-5kGK-VnPOeiJKn2m1=s1600-w500', 57);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(371, 'pt_code_56', 'https://lh3.googleusercontent.com/p/AF1QipMsVDRN53EWfVSAw70hfbV0uZHv33MW8OVpv6gM=s1600-w500', 57);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(372, 'pt_code_56', 'https://lh3.googleusercontent.com/p/AF1QipNkwpv9L3PvU7rXtVW0ENKULngDSQpK2yjMKI-K=s1600-w500', 57);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(373, 'pt_code_56', 'https://lh3.googleusercontent.com/p/AF1QipOao5HpHuQbVQKxvwNuWS2dxxEudA2c8GkeZRBs=s1600-w500', 57);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(374, 'pt_code_56', 'https://lh3.googleusercontent.com/p/AF1QipNGhDlTa9NI43qD3FMfC5mRZoWwV3APVVt6QSKn=s1600-w500', 57);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(375, 'pt_code_56', 'https://lh3.googleusercontent.com/p/AF1QipONwP55TvCPkSMYhXq9zcqcjXghLa0PVgUAfCT8=s1600-w500', 57);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(376, 'pt_code_56', 'https://s3-media1.fl.yelpcdn.com/bphoto/XefYi4kSgfvRSSZBUWGRBw/o.jpg', 57);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(377, 'pt_code_56', 'https://s3-media3.fl.yelpcdn.com/bphoto/YUBW9KBqoMZ4Kb6Nzt2DZA/o.jpg', 57);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(378, 'pt_code_56', 'https://s3-media1.fl.yelpcdn.com/bphoto/vQODFeqzFHQ_TS8lBMvr-Q/o.jpg', 57);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(379, 'pt_code_57', 'https://lh3.googleusercontent.com/p/AF1QipNqYBaelTPp9Gu0T_Zflstqdy-0QvfF_i4f5FoT=s1600-w500', 58);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(380, 'pt_code_57', 'https://lh3.googleusercontent.com/p/AF1QipN0zLoFKvzUvViuYHFTPWU8bVcR53u9YGw3M4_H=s1600-w500', 58);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(381, 'pt_code_57', 'https://lh3.googleusercontent.com/p/AF1QipPZ8DP4FJndAsFd4-q172mPpdX3EeEP6Mpdxh3e=s1600-w500', 58);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(382, 'pt_code_57', 'https://lh3.googleusercontent.com/p/AF1QipNBD1z4eolK2Ry4kkj8JVphBEi2F42rRzASca6x=s1600-w500', 58);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(383, 'pt_code_57', 'https://lh3.googleusercontent.com/p/AF1QipOGhSmBQxeMxrVxpfPG7Dw5fmb3Iu_d-KxYDjbd=s1600-w500', 58);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(384, 'pt_code_57', 'https://lh3.googleusercontent.com/p/AF1QipOHsx8tWFPvFpbW6Vn4HsymcApccEcpfQbtdp3h=s1600-w500', 58);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(385, 'pt_code_57', 'https://lh3.googleusercontent.com/p/AF1QipP4Yx1XrxjwmbCodm2dE31ml6N9iozCIpghRHff=s1600-w500', 58);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(386, 'pt_code_57', 'https://lh3.googleusercontent.com/p/AF1QipNA8wZbXZamx05ZDWvOzpXRmcigOpAU3gFY112K=s1600-w500', 58);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(387, 'pt_code_57', 'https://lh3.googleusercontent.com/p/AF1QipNBs83QqOCkM0RXfmINhYrbQg2PZ7lXtF7w6guM=s1600-w500', 58);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(388, 'pt_code_57', 'https://lh3.googleusercontent.com/p/AF1QipOfpc_uDKlFQukUm39hQqU8vUPtVwHiPd1dEti8=s1600-w500', 58);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(389, 'pt_code_57', 'https://s3-media4.fl.yelpcdn.com/bphoto/OdojR4gi0gyPbIs2VxRiUg/o.jpg', 58);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(390, 'pt_code_57', 'https://s3-media2.fl.yelpcdn.com/bphoto/rSrU_n9RjRZts755kzVg9Q/o.jpg', 58);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(391, 'pt_code_57', 'https://s3-media2.fl.yelpcdn.com/bphoto/jfcB1vEkaVzU4fvrMuLe-Q/o.jpg', 58);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(392, 'pt_code_58', 'https://lh3.googleusercontent.com/p/AF1QipMK_K_AnIwlcMmgSkqqqaYKWOpDwZPVXD82OzmK=s1600-w500', 59);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(393, 'pt_code_58', 'https://lh3.googleusercontent.com/p/AF1QipNnxvP9f_2p1ihMhlbXZUbydvXopNu1A5bkjgqm=s1600-w500', 59);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(394, 'pt_code_58', 'https://lh3.googleusercontent.com/p/AF1QipPEn7OetSUd9MfM9VArhuEls_IVzlLaplWZodvc=s1600-w500', 59);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(395, 'pt_code_58', 'https://lh3.googleusercontent.com/p/AF1QipNG1TqHbjS3-qZyoCNw7DSLQhLq1IYDKHKd9pYi=s1600-w500', 59);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(396, 'pt_code_58', 'https://lh3.googleusercontent.com/p/AF1QipMI2kQX8nm71s848T1yT6luASl-dJQtHAMCk4IT=s1600-w500', 59);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(397, 'pt_code_58', 'https://lh3.googleusercontent.com/p/AF1QipNI-PkcLlfKpsGS20QHhY8RwDLPn25M9y4Pibnc=s1600-w500', 59);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(398, 'pt_code_58', 'https://lh3.googleusercontent.com/p/AF1QipNsU_JCAq7hIJ38QDYE25-NxjmQHq5_EPARBN6e=s1600-w500', 59);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(399, 'pt_code_58', 'https://s3-media4.fl.yelpcdn.com/bphoto/n2O4TgvM-RndviFxHRITZw/o.jpg', 59);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(400, 'pt_code_58', 'https://s3-media2.fl.yelpcdn.com/bphoto/LNG5q8DePzUvo-_k4gO-qQ/o.jpg', 59);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(401, 'pt_code_58', 'https://s3-media1.fl.yelpcdn.com/bphoto/EGKLU9ONw4oisceZWiG37w/o.jpg', 59);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(402, 'pt_code_60', 'https://lh3.googleusercontent.com/p/AF1QipP0PXX6FUSaGFEAFD--QfJ9BLwkGt8sAIlf99B6=s1600-w500', 61);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(403, 'pt_code_60', 'https://lh3.googleusercontent.com/p/AF1QipN1mc6ZYKbJo_m_9XI-iQIVw7AZPiTkipa1zbI=s1600-w500', 61);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(404, 'pt_code_60', 'https://lh3.googleusercontent.com/p/AF1QipNhXn2RXH1C_Uff8A_Avp_Nl9A1JLWyhgS3Mom4=s1600-w500', 61);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(405, 'pt_code_60', 'https://lh3.googleusercontent.com/p/AF1QipNdouu6Vkh2HzTmFnsdSCPHhYPszvHT32Sv2uE=s1600-w500', 61);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(406, 'pt_code_60', 'https://lh3.googleusercontent.com/p/AF1QipMkdGxA33fn7VC5lGVG05mM1zGCIkDsJDU_4I4D=s1600-w500', 61);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(407, 'pt_code_60', 'https://lh3.googleusercontent.com/p/AF1QipNPZZNmg2GdaB4Pr57OF1Y60U_iITB4VtlMbpM=s1600-w500', 61);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(408, 'pt_code_60', 'https://lh3.googleusercontent.com/p/AF1QipOHp37cNmhinQJPcch6yC5OM5aHRc1wmloJ8qpc=s1600-w500', 61);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(409, 'pt_code_60', 'https://lh3.googleusercontent.com/p/AF1QipOML4WHSbnZ7fNstxDh2pMBbeHQFhfGQxVqN-o=s1600-w500', 61);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(410, 'pt_code_60', 'https://lh3.googleusercontent.com/p/AF1QipO7wcouHQOEEiVJObkqA4jvDu4Kv94Ougcx0etN=s1600-w500', 61);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(411, 'pt_code_60', 'https://lh3.googleusercontent.com/p/AF1QipMGkpU9OdQorr0Vj1PYI5_VFC-ICgVyWVxsb1gi=s1600-w500', 61);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(412, 'pt_code_60', 'https://s3-media3.fl.yelpcdn.com/bphoto/pEYJOCY5LgckAHOlueDExw/o.jpg', 61);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(413, 'pt_code_60', 'https://s3-media4.fl.yelpcdn.com/bphoto/T7POXlJ93kd0iYwAQVVLHQ/o.jpg', 61);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(414, 'pt_code_60', 'https://s3-media3.fl.yelpcdn.com/bphoto/Jj27TFBLzg6gNDNEKPizpQ/o.jpg', 61);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(415, 'pt_code_61', 'https://lh3.googleusercontent.com/p/AF1QipMPLfO3uyVPnecuSFBGA-TtyhN-fJdr8b473wyJ=s1600-w500', 62);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(416, 'pt_code_62', 'https://s3-media2.fl.yelpcdn.com/bphoto/90VQJXw1HpXQzBe-7rFiqA/o.jpg', 63);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(417, 'pt_code_62', 'https://s3-media1.fl.yelpcdn.com/bphoto/iGPhg8cqPCHRb8QnXZrF7g/o.jpg', 63);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(418, 'pt_code_62', 'https://s3-media2.fl.yelpcdn.com/bphoto/cMDZdzS5ijR0OLP0IDXamQ/o.jpg', 63);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(419, 'pt_code_63', 'https://lh3.googleusercontent.com/p/AF1QipPKTJhswsPX7Jf4NeUxQi6VK8SWVQPWe5USLuUm=s1600-w500', 64);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(420, 'pt_code_63', 'https://lh3.googleusercontent.com/p/AF1QipNzmGowxO0Z4dfDFumr7U5AuljOe-JKnebdm1Q=s1600-w500', 64);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(421, 'pt_code_63', 'https://lh3.googleusercontent.com/p/AF1QipOq4-zcZVDT9e5cx36I9-pN8KKll1P40EluTFyd=s1600-w500', 64);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(422, 'pt_code_63', 'https://lh3.googleusercontent.com/p/AF1QipOoFNoNlPBHBMMqvVaLYYUs_vrYxKQrJ6i75f0=s1600-w500', 64);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(423, 'pt_code_63', 'https://lh3.googleusercontent.com/p/AF1QipO3BNdTs_-2kD95TyvhCGYUv3IMmpBD2ep06TBP=s1600-w500', 64);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(424, 'pt_code_63', 'https://lh3.googleusercontent.com/p/AF1QipP0ZY8iRaK3RAtPy4WDlTMkrGF2vmDRhEnRH_LA=s1600-w500', 64);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(425, 'pt_code_63', 'https://lh3.googleusercontent.com/p/AF1QipMeyegHNbaCn091l3ii4GXArvj22LJGhiR1Aho=s1600-w500', 64);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(426, 'pt_code_63', 'https://lh3.googleusercontent.com/p/AF1QipNLff6_Qtu4WhR4Y8n7LDtCzOUsVFVJ7iqBdv0=s1600-w500', 64);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(427, 'pt_code_63', 'https://lh3.googleusercontent.com/p/AF1QipOyjU2Ppg-_zcfBrcOvCx220Zk9nATwcv9DWp8c=s1600-w500', 64);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(428, 'pt_code_63', 'https://lh3.googleusercontent.com/p/AF1QipPr8eG6DA5itL5t6qsCuTij8jqqnvlq4Odx-G4=s1600-w500', 64);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(429, 'pt_code_63', 'https://s3-media2.fl.yelpcdn.com/bphoto/bg5GpdFkNSJ-43WDRdSvHA/o.jpg', 64);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(430, 'pt_code_63', 'https://s3-media1.fl.yelpcdn.com/bphoto/mV8Gn7w7fnwvV_rs3I-lxw/o.jpg', 64);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(431, 'pt_code_63', 'https://s3-media1.fl.yelpcdn.com/bphoto/Zhes5Q9joDumP-qkjvs4gw/o.jpg', 64);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(432, 'pt_code_65', 'https://lh3.googleusercontent.com/p/AF1QipPaIKMCWJsVhTbYSrZbLmyJe035SzLpdjIlpX-F=s1600-w500', 66);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(433, 'pt_code_65', 'https://lh3.googleusercontent.com/p/AF1QipOJeMMtn6NGwiHD3vHiZeJEHUw6ovBK9fxg61eP=s1600-w500', 66);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(434, 'pt_code_65', 'https://lh3.googleusercontent.com/p/AF1QipOEoo2fBMWVZVuZxPGSsUGCzNHV-mY83ahyqegE=s1600-w500', 66);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(435, 'pt_code_65', 'https://s3-media3.fl.yelpcdn.com/bphoto/ys47z9oYULwO8Hkp02wznA/o.jpg', 66);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(436, 'pt_code_65', 'https://s3-media2.fl.yelpcdn.com/bphoto/AMM4q8UVcn0gxktKRNE2HA/o.jpg', 66);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(437, 'pt_code_65', 'https://s3-media4.fl.yelpcdn.com/bphoto/7eYK0XnfUIhOqE-a0lvszg/o.jpg', 66);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(438, 'pt_code_66', 'https://s3-media4.fl.yelpcdn.com/bphoto/B0Z2on-I9w2hzAar9DAwrg/o.jpg', 67);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(439, 'pt_code_66', 'https://s3-media2.fl.yelpcdn.com/bphoto/To4L24ciR_3lpJXzqy05cg/o.jpg', 67);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(440, 'pt_code_66', 'https://s3-media2.fl.yelpcdn.com/bphoto/er-jNgVg8pzgZOq2yhyxsw/o.jpg', 67);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(441, 'pt_code_67', 'https://lh3.googleusercontent.com/p/AF1QipNLKi0h6U5u5N-dZ6RwnfBZdzNY6q6kjuoO1cc=s1600-w500', 68);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(442, 'pt_code_67', 'https://s3-media3.fl.yelpcdn.com/bphoto/ys47z9oYULwO8Hkp02wznA/o.jpg', 68);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(443, 'pt_code_67', 'https://s3-media2.fl.yelpcdn.com/bphoto/AMM4q8UVcn0gxktKRNE2HA/o.jpg', 68);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(444, 'pt_code_67', 'https://s3-media4.fl.yelpcdn.com/bphoto/7eYK0XnfUIhOqE-a0lvszg/o.jpg', 68);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(445, 'pt_code_69', 'https://lh3.googleusercontent.com/p/AF1QipPyKAQpT22rypfY6WW3T7D0-QibLkaNxJL_omfH=s1600-w500', 70);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(446, 'pt_code_69', 'https://lh3.googleusercontent.com/p/AF1QipO_gs264cuHLJAQlC0DdkobQMvsxBbnMV_CiH8_=s1600-w500', 70);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(447, 'pt_code_69', 'https://lh3.googleusercontent.com/p/AF1QipOHZuABEEleUyyj_NVpHM9Cd2SD-TzJFS-3oFqq=s1600-w500', 70);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(448, 'pt_code_69', 'https://lh3.googleusercontent.com/p/AF1QipNT-jaUvEqPZhpD8OXaGRhI4KEMTqjoTzJq8V2M=s1600-w500', 70);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(449, 'pt_code_69', 'https://lh3.googleusercontent.com/p/AF1QipPbx5h_nzX8fUHi2Uuos5PLh1OEFUlTOfWED80z=s1600-w500', 70);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(450, 'pt_code_69', 'https://lh3.googleusercontent.com/p/AF1QipN_n_mD1s89bIMQS-lwfpfNy4YSmOGRNmKMFkYu=s1600-w500', 70);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(451, 'pt_code_69', 'https://lh3.googleusercontent.com/p/AF1QipMDZOXyEEO5b0fRX7ePFEVF2XRQNSbQmPMm8Gpr=s1600-w500', 70);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(452, 'pt_code_69', 'https://lh3.googleusercontent.com/p/AF1QipPAETYTmz005tGzV_ZKpYlx-rYuaBeF7cWNpCv0=s1600-w500', 70);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(453, 'pt_code_69', 'https://lh3.googleusercontent.com/p/AF1QipPuUoWemetwY0c9aSVhc8WPApnSLZHp-8wkSkAZ=s1600-w500', 70);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(454, 'pt_code_69', 'https://lh3.googleusercontent.com/p/AF1QipP4cNF1KspfMB94cLNlxjlc_-pGSSOps_Nmu1ZA=s1600-w500', 70);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(455, 'pt_code_69', 'https://s3-media3.fl.yelpcdn.com/bphoto/3YgJ7OPtWDruhUrQajLmTw/o.jpg', 70);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(456, 'pt_code_69', 'https://s3-media3.fl.yelpcdn.com/bphoto/6aAAUYt7PkBa1kxVlqL9_Q/o.jpg', 70);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(457, 'pt_code_69', 'https://s3-media3.fl.yelpcdn.com/bphoto/Q7SvYa-nmyn-9JzWiN8HIw/o.jpg', 70);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(458, 'pt_code_70', 'https://s3-media1.fl.yelpcdn.com/bphoto/MmmmhR2Xc27k28fK2W1KvQ/o.jpg', 71);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(459, 'pt_code_70', 'https://s3-media4.fl.yelpcdn.com/bphoto/6PhjEH0mSaftWbdbatn0tQ/o.jpg', 71);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(460, 'pt_code_71', 'https://lh3.googleusercontent.com/p/AF1QipP351PDYMqtcw07hkqxCJH53Y0Jfi4IGa_qegla=s1600-w500', 72);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(461, 'pt_code_71', 'https://lh3.googleusercontent.com/p/AF1QipNnFGmVlQkwMR17adrFkIAXPd57BvWfHbJivbpx=s1600-w500', 72);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(462, 'pt_code_71', 'https://lh3.googleusercontent.com/p/AF1QipOlgBtCaisBrRspcB9IUUr5K7W-ReGlJ5-k9Dm7=s1600-w500', 72);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(463, 'pt_code_71', 'https://lh3.googleusercontent.com/p/AF1QipNK_Zf55rC61JCvHTmULQDmafNkJRmm9k1EXuaq=s1600-w500', 72);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(464, 'pt_code_71', 'https://lh3.googleusercontent.com/p/AF1QipPmmYSCFjH5B9CKYhDIkSwZlBO99sLt7vWOcJ4v=s1600-w500', 72);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(465, 'pt_code_71', 'https://lh3.googleusercontent.com/p/AF1QipOzbxZUOjsKQlD7l-RzCwSHQhX7KBNT-9R5_PkX=s1600-w500', 72);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(466, 'pt_code_71', 'https://lh3.googleusercontent.com/p/AF1QipPXkKUipDRQ4AX6DXyeWA10H4SuRSF1eRGleIVz=s1600-w500', 72);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(467, 'pt_code_71', 'https://lh3.googleusercontent.com/p/AF1QipNFMZshIuHu0tlVe2Q4f72ju_FqUaILYFRVljK1=s1600-w500', 72);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(468, 'pt_code_71', 'https://lh3.googleusercontent.com/p/AF1QipMWQG8fheMCw18LWFAdxaFA2nDw_a52jcsH6xU5=s1600-w500', 72);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(469, 'pt_code_71', 'https://lh3.googleusercontent.com/p/AF1QipNOqpogBxRQOcbnrzO6y-Mz2QRhTcZTnDPjMYsc=s1600-w500', 72);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(470, 'pt_code_71', 'https://s3-media3.fl.yelpcdn.com/bphoto/iiDVq-NXgy6DdeIDBFwHkg/o.jpg', 72);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(471, 'pt_code_71', 'https://s3-media2.fl.yelpcdn.com/bphoto/5ea_EFXxHP0v0AEO75e5lA/o.jpg', 72);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(472, 'pt_code_71', 'https://s3-media1.fl.yelpcdn.com/bphoto/sblA8Uh6vhUWnmUKnYhGkg/o.jpg', 72);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(473, 'pt_code_72', 'https://s3-media1.fl.yelpcdn.com/bphoto/gadHWJ3gwjIiDyRXqOr0EA/o.jpg', 73);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(474, 'pt_code_72', 'https://s3-media1.fl.yelpcdn.com/bphoto/rxD2mtjpxtpVCdZ8Qw_MdQ/o.jpg', 73);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(475, 'pt_code_72', 'https://s3-media3.fl.yelpcdn.com/bphoto/HRvdm29XsYnrsGlHEDvoVQ/o.jpg', 73);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(476, 'pt_code_73', 'https://lh3.googleusercontent.com/p/AF1QipOYXih-GfxNFX6o0WEBixTzamQa1EWbrL_dQJCc=s1600-w500', 74);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(477, 'pt_code_73', 'https://lh3.googleusercontent.com/p/AF1QipOiEhB_pChlhU8lN_oXe7pp3uhhHUvXEY11b9Wy=s1600-w500', 74);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(478, 'pt_code_73', 'https://lh3.googleusercontent.com/p/AF1QipO0KmwxmeJkavmd1cS2Ti7DPhQ42FG4KZbxctaj=s1600-w500', 74);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(479, 'pt_code_73', 'https://lh3.googleusercontent.com/p/AF1QipPYTvXdQ-jt9H0PXG5XQ-ugkqapY8dZZVRbaLeX=s1600-w500', 74);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(480, 'pt_code_73', 'https://lh3.googleusercontent.com/p/AF1QipMcDv5zJszW9ieeA99r035O2Pr61Sz1iICocsCU=s1600-w500', 74);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(481, 'pt_code_73', 'https://lh3.googleusercontent.com/p/AF1QipMXWrrJGXp_mkuOnIpc_1ghA8-5E2dFXveWiE2B=s1600-w500', 74);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(482, 'pt_code_73', 'https://lh3.googleusercontent.com/p/AF1QipP3uP6NRHf5wAhIekSks3jS0P-izxcDvG_EkQLC=s1600-w500', 74);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(483, 'pt_code_73', 'https://lh3.googleusercontent.com/p/AF1QipMCOszfRcSXSMydzO0EdLJlBnDjKEkH3A8SW0Kj=s1600-w500', 74);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(484, 'pt_code_73', 'https://lh3.googleusercontent.com/p/AF1QipP2eqKjc-_B6f0WnNSee4kndQFOowPjw84Z01H1=s1600-w500', 74);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(485, 'pt_code_73', 'https://lh3.googleusercontent.com/p/AF1QipO5Bm6wxI8L-MMhjVO1h1iZ0vnqqsfpwOjkRp6b=s1600-w500', 74);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(486, 'pt_code_73', 'https://s3-media4.fl.yelpcdn.com/bphoto/LD4jRX78SaQ2mbO_G0Vgbw/o.jpg', 74);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(487, 'pt_code_73', 'https://s3-media4.fl.yelpcdn.com/bphoto/LFNyD9NCbSc0UQLlV-dBrQ/o.jpg', 74);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(488, 'pt_code_73', 'https://s3-media1.fl.yelpcdn.com/bphoto/jBnzzW5CYXkwfKt9n_6BEg/o.jpg', 74);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(489, 'pt_code_74', 'https://lh3.googleusercontent.com/p/AF1QipMLItQy_HE8Kzx3_YU2taweyoJEM2VTpfRpX-Kn=s1600-w500', 75);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(490, 'pt_code_74', 'https://lh3.googleusercontent.com/p/AF1QipNTTEKcPoDarSW-Lc364LcGOVEcUFkkYxRY2eFK=s1600-w500', 75);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(491, 'pt_code_74', 'https://lh3.googleusercontent.com/p/AF1QipPKPsx42z5UhU370x1sjp1RHSjUmQoIAgOA3ZTS=s1600-w500', 75);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(492, 'pt_code_74', 'https://lh3.googleusercontent.com/p/AF1QipNPmNb3yjTjmBzfAveSpoLH7eRseD1bhcynNJye=s1600-w500', 75);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(493, 'pt_code_74', 'https://lh3.googleusercontent.com/p/AF1QipOBV2F2-yOFwpx2kbiRED05juji_NC5sebYiGox=s1600-w500', 75);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(494, 'pt_code_74', 'https://lh3.googleusercontent.com/p/AF1QipPcZomgEBlrVskgY68Xd4esF4nvgkwlQgxPLCvm=s1600-w500', 75);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(495, 'pt_code_74', 'https://lh3.googleusercontent.com/p/AF1QipNiqmHFtefVSzDoiBCV7mdKXWcb_s4nanT98wBa=s1600-w500', 75);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(496, 'pt_code_74', 'https://lh3.googleusercontent.com/p/AF1QipO5qHUOmyuYE394hCPoqu0dy3Sq-onvssXC-sW2=s1600-w500', 75);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(497, 'pt_code_74', 'https://lh3.googleusercontent.com/p/AF1QipO5IV3o1yGTadA1NjqFihWOl1ANEdCKiL4buVKK=s1600-w500', 75);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(498, 'pt_code_74', 'https://lh3.googleusercontent.com/p/AF1QipNi27NPm2jmpes-N9MGtdTGqHah4dObkf4yqn-J=s1600-w500', 75);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(499, 'pt_code_74', 'https://s3-media3.fl.yelpcdn.com/bphoto/KD1RCeiYNMgpyu5AUGtYNA/o.jpg', 75);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(500, 'pt_code_74', 'https://s3-media1.fl.yelpcdn.com/bphoto/exWZ4z_0s0j8efdn-pqjdw/o.jpg', 75);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(501, 'pt_code_74', 'https://s3-media2.fl.yelpcdn.com/bphoto/gDlmyR9QaO67lBUcpVtTzA/o.jpg', 75);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(502, 'pt_code_76', 'https://lh3.googleusercontent.com/p/AF1QipPyKAQpT22rypfY6WW3T7D0-QibLkaNxJL_omfH=s1600-w500', 77);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(503, 'pt_code_76', 'https://lh3.googleusercontent.com/p/AF1QipO_gs264cuHLJAQlC0DdkobQMvsxBbnMV_CiH8_=s1600-w500', 77);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(504, 'pt_code_76', 'https://lh3.googleusercontent.com/p/AF1QipOHZuABEEleUyyj_NVpHM9Cd2SD-TzJFS-3oFqq=s1600-w500', 77);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(505, 'pt_code_76', 'https://lh3.googleusercontent.com/p/AF1QipNT-jaUvEqPZhpD8OXaGRhI4KEMTqjoTzJq8V2M=s1600-w500', 77);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(506, 'pt_code_76', 'https://lh3.googleusercontent.com/p/AF1QipPbx5h_nzX8fUHi2Uuos5PLh1OEFUlTOfWED80z=s1600-w500', 77);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(507, 'pt_code_76', 'https://lh3.googleusercontent.com/p/AF1QipN_n_mD1s89bIMQS-lwfpfNy4YSmOGRNmKMFkYu=s1600-w500', 77);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(508, 'pt_code_76', 'https://lh3.googleusercontent.com/p/AF1QipMDZOXyEEO5b0fRX7ePFEVF2XRQNSbQmPMm8Gpr=s1600-w500', 77);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(509, 'pt_code_76', 'https://lh3.googleusercontent.com/p/AF1QipPAETYTmz005tGzV_ZKpYlx-rYuaBeF7cWNpCv0=s1600-w500', 77);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(510, 'pt_code_76', 'https://lh3.googleusercontent.com/p/AF1QipPuUoWemetwY0c9aSVhc8WPApnSLZHp-8wkSkAZ=s1600-w500', 77);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(511, 'pt_code_76', 'https://lh3.googleusercontent.com/p/AF1QipP4cNF1KspfMB94cLNlxjlc_-pGSSOps_Nmu1ZA=s1600-w500', 77);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(512, 'pt_code_76', 'https://s3-media3.fl.yelpcdn.com/bphoto/3YgJ7OPtWDruhUrQajLmTw/o.jpg', 77);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(513, 'pt_code_76', 'https://s3-media3.fl.yelpcdn.com/bphoto/6aAAUYt7PkBa1kxVlqL9_Q/o.jpg', 77);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(514, 'pt_code_76', 'https://s3-media3.fl.yelpcdn.com/bphoto/Q7SvYa-nmyn-9JzWiN8HIw/o.jpg', 77);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(515, 'pt_code_77', 'https://lh3.googleusercontent.com/p/AF1QipMJkNtgP60Cl-mzNw-jbZbK3Ul_VfDtNMR6ReK2=s1600-w500', 78);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(516, 'pt_code_77', 'https://lh3.googleusercontent.com/p/AF1QipOmCZkhd4AwVaEkWHGn4Cfb2CAW4uQ0jduH79nI=s1600-w500', 78);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(517, 'pt_code_77', 'https://lh3.googleusercontent.com/p/AF1QipP_Vy7IObJS3yy9erd_3EFnyr45PCM4uMcL6Cc7=s1600-w500', 78);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(518, 'pt_code_77', 'https://lh3.googleusercontent.com/p/AF1QipMdMb5ASPYk1cyq3q55cyDJkHlWQUIByu0zCwXC=s1600-w500', 78);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(519, 'pt_code_77', 'https://lh3.googleusercontent.com/p/AF1QipMggxnA-7zdCoUqUygT2-9wdJpcBAvIzXToCt9x=s1600-w500', 78);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(520, 'pt_code_77', 'https://lh3.googleusercontent.com/p/AF1QipOD-hkLOH7IaYihmjoMNANJQ_Md3sODv-044lxj=s1600-w500', 78);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(521, 'pt_code_77', 'https://lh3.googleusercontent.com/p/AF1QipNDSGtk51zWaSt-QjekO8SYDoGQzPCRkJjSv8od=s1600-w500', 78);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(522, 'pt_code_77', 'https://lh3.googleusercontent.com/p/AF1QipPJYrvAhuS9uBoYOeiDgq7Mo7vN255XgAvRF6rH=s1600-w500', 78);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(523, 'pt_code_77', 'https://lh3.googleusercontent.com/p/AF1QipNpZP94GVxzaBW--tvqvLlc0PzdAM5lH-l6OpX7=s1600-w500', 78);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(524, 'pt_code_77', 'https://lh3.googleusercontent.com/p/AF1QipPgx9Vr0yX52_SJmTeaABoVN-pld9-KBEXqN7zg=s1600-w500', 78);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(525, 'pt_code_78', 'https://s3-media3.fl.yelpcdn.com/bphoto/z8XI88o-WtcpcKSjtDnoyw/o.jpg', 79);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(526, 'pt_code_78', 'https://s3-media4.fl.yelpcdn.com/bphoto/de1agh18PYi3Wi58FKcsHg/o.jpg', 79);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(527, 'pt_code_78', 'https://s3-media2.fl.yelpcdn.com/bphoto/8Nzp0jcnjyLRW_5oqSNtTA/o.jpg', 79);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(528, 'pt_code_79', 'https://lh3.googleusercontent.com/p/AF1QipPeNLlMTDRIqsVs3U29LF-pKBo6oX12CPdMHxgC=s1600-w500', 80);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(529, 'pt_code_79', 'https://lh3.googleusercontent.com/p/AF1QipOKwCMmIEsrIFaxSbC-J3d0rt4dLlXzziKjKPVC=s1600-w500', 80);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(530, 'pt_code_79', 'https://lh3.googleusercontent.com/p/AF1QipPmBXExy9boZeupnPhnqkC9ZyNeH26_F0MwhrHS=s1600-w500', 80);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(531, 'pt_code_79', 'https://lh3.googleusercontent.com/p/AF1QipMe4gAgMFXBokb6TBmkC3qetb1ULs76TcNrxKsz=s1600-w500', 80);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(532, 'pt_code_79', 'https://lh3.googleusercontent.com/p/AF1QipNLSx1SFNPdt6s8yUL-gGPAdgv2h3lhmjAEg1ej=s1600-w500', 80);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(533, 'pt_code_79', 'https://lh3.googleusercontent.com/p/AF1QipMhBBSs_UdvgPFCkFiUXzyEPzRrx97CY8FrrFfL=s1600-w500', 80);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(534, 'pt_code_79', 'https://lh3.googleusercontent.com/p/AF1QipO9M4JyIfoOGzxJwlNrmMiOOLo9ZxRnWWYTgEFZ=s1600-w500', 80);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(535, 'pt_code_79', 'https://lh3.googleusercontent.com/p/AF1QipPOkjY-WK-bSwk50bVGxCL5JM31iIDAEsjSHV66=s1600-w500', 80);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(536, 'pt_code_79', 'https://lh3.googleusercontent.com/p/AF1QipMmxyPwV_tLngvhJ_EKL0LJ5oP9silyad4YlFZh=s1600-w500', 80);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(537, 'pt_code_79', 'https://lh3.googleusercontent.com/p/AF1QipPOd96V_nyJ0fwgHpJBzP5aBeJbqH0Gc3ntMVxX=s1600-w500', 80);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(538, 'pt_code_80', 'https://lh3.googleusercontent.com/p/AF1QipNZG9dNUIPFYgVYUrIeF9E8gNZlQMYlSI9-MQe4=s1600-w500', 81);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(539, 'pt_code_80', 'https://lh3.googleusercontent.com/p/AF1QipNDhlZnnlJrLCB869oFWNS5tbVQrQr-FiMykhbG=s1600-w500', 81);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(540, 'pt_code_80', 'https://lh3.googleusercontent.com/p/AF1QipNK96wuLB3vEv9KAZKwO609YRrXGrdNnAIX_Kyt=s1600-w500', 81);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(541, 'pt_code_80', 'https://lh3.googleusercontent.com/p/AF1QipNYp_gf6zgncThqJBI14mjmXKryvdfiEu_M7j2d=s1600-w303', 81);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(542, 'pt_code_80', 'https://lh3.googleusercontent.com/p/AF1QipO-qL5LUKRm9-h2S5cjP_qDA7lwYRirpzC2Kv80=s1600-w500', 81);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(543, 'pt_code_80', 'https://s3-media3.fl.yelpcdn.com/bphoto/CxaK0pYw6IUx27EXYcLdFA/o.jpg', 81);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(544, 'pt_code_80', 'https://s3-media4.fl.yelpcdn.com/bphoto/20NW6soYY95YA6rk8M7qWw/o.jpg', 81);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(545, 'pt_code_80', 'https://s3-media3.fl.yelpcdn.com/bphoto/6M5HjId2PE_FECR8Rnkkzw/o.jpg', 81);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(546, 'pt_code_81', 'https://lh3.googleusercontent.com/p/AF1QipNBJgKYY7aK7OzjEwtKc6uQptJJMnhAaGY8lgj2=s1600-w500', 82);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(547, 'pt_code_81', 'https://lh3.googleusercontent.com/p/AF1QipOXOEiXnuZ5OmPkvgFTvNQn1joDKxFkXU7wwuCJ=s1600-w500', 82);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(548, 'pt_code_81', 'https://lh3.googleusercontent.com/p/AF1QipNWuWTgl6-w2JwUD9mgeHyvRMonjLja5MMNjWQm=s1600-w500', 82);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(549, 'pt_code_81', 'https://lh3.googleusercontent.com/p/AF1QipM7l-RO6ExKfsexEc5mboAAK64VLOQHDCcUFtdP=s1600-w500', 82);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(550, 'pt_code_81', 'https://s3-media3.fl.yelpcdn.com/bphoto/ys47z9oYULwO8Hkp02wznA/o.jpg', 82);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(551, 'pt_code_81', 'https://s3-media2.fl.yelpcdn.com/bphoto/AMM4q8UVcn0gxktKRNE2HA/o.jpg', 82);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(552, 'pt_code_81', 'https://s3-media4.fl.yelpcdn.com/bphoto/7eYK0XnfUIhOqE-a0lvszg/o.jpg', 82);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(553, 'pt_code_82', 'https://lh3.googleusercontent.com/p/AF1QipM573OvhK-HR-fNWpxjxeFeAUw3TuEU8tps13-0=s1600-w500', 83);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(554, 'pt_code_82', 'https://lh3.googleusercontent.com/p/AF1QipO0Jj9A7bCC0q-jzcf3aCx2_-hgOOBspqY2cqEJ=s1600-w500', 83);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(555, 'pt_code_82', 'https://lh3.googleusercontent.com/p/AF1QipMMCFbEqpVYoeCLpGU8OFvcdMr_4OwtxQePCUhS=s1600-w500', 83);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(556, 'pt_code_82', 'https://lh3.googleusercontent.com/p/AF1QipPl6k-LMWg_rI2CSK5XdnfCZXHyQfuUDstKUTfD=s1600-w500', 83);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(557, 'pt_code_84', 'https://lh3.googleusercontent.com/p/AF1QipPoQkKkkREYIvlsoM1WeFslkhSI2hRHM2EjNDTg=s1600-w500', 85);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(558, 'pt_code_84', 'https://lh3.googleusercontent.com/p/AF1QipMUsseMKlp4Y1Z8yF4Rv5Y6NdVMFhMRAvy8STfx=s1600-w500', 85);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(559, 'pt_code_84', 'https://lh3.googleusercontent.com/p/AF1QipO1Jl4iWANtFlcrmjXs4IP36-BecRtZwAhUrs_o=s1600-w500', 85);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(560, 'pt_code_84', 'https://lh3.googleusercontent.com/p/AF1QipO7_ZNFY7LDy3PHm7ekP4GiBKq4sbH9jzYLiGhs=s1600-w500', 85);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(561, 'pt_code_84', 'https://s3-media2.fl.yelpcdn.com/bphoto/STxtXz3JquGvwZ1D4pmxoA/o.jpg', 85);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(562, 'pt_code_84', 'https://s3-media3.fl.yelpcdn.com/bphoto/YUFHnRjTh2VQwMuW3jZ1TQ/o.jpg', 85);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(563, 'pt_code_84', 'https://s3-media2.fl.yelpcdn.com/bphoto/RLUoVWrTVvNgoLLQ4dE2JA/o.jpg', 85);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(564, 'pt_code_85', 'https://lh3.googleusercontent.com/p/AF1QipNS8-R7VDRn6R_n2EK-XcgqABAzIteL-3eWvJAC=s1600-w500', 86);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(565, 'pt_code_85', 'https://lh3.googleusercontent.com/p/AF1QipNHgYAwqYO9TtkQaIU7pokwO1kobZTtepWr-AU3=s1600-w500', 86);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(566, 'pt_code_85', 'https://lh3.googleusercontent.com/p/AF1QipPt5WyqK9xIk3ACtWSiNcmbNwWgY9BaR8HTO5y_=s1600-w500', 86);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(567, 'pt_code_85', 'https://lh3.googleusercontent.com/p/AF1QipPoZpZaf3gJ2LueSzDdzv05EUSdoW7BItabpnZ8=s1600-w500', 86);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(568, 'pt_code_85', 'https://lh3.googleusercontent.com/p/AF1QipNJdbuZYJXQDCy8lBVDmnZCALJi5nIpOGOhAHXg=s1600-w500', 86);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(569, 'pt_code_85', 'https://lh3.googleusercontent.com/p/AF1QipM_wm1rhC0dC2N5ISBqgmBoJSi-dEUTAo4q2KcD=s1600-w500', 86);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(570, 'pt_code_85', 'https://lh3.googleusercontent.com/p/AF1QipNAWHyD4vpcdQKhF_1jQA6wrxXK8qbgwFe_FqgP=s1600-w500', 86);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(571, 'pt_code_85', 'https://lh3.googleusercontent.com/p/AF1QipMui9pBR5h_X8PERj1_21RUEEjHy0uh9166VUZz=s1600-w500', 86);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(572, 'pt_code_85', 'https://lh3.googleusercontent.com/p/AF1QipOVx8Tih3XCE4a-HP_4lVFOniYRh_BjrN8dF2IE=s1600-w500', 86);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(573, 'pt_code_85', 'https://lh3.googleusercontent.com/p/AF1QipNHkULWPs1aS-y-zIpR3cwDnLB0Dx_ZAfmr8oeW=s1600-w500', 86);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(574, 'pt_code_85', 'https://s3-media1.fl.yelpcdn.com/bphoto/mbBNYYknCvpDMfhualHsAw/o.jpg', 86);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(575, 'pt_code_85', 'https://s3-media3.fl.yelpcdn.com/bphoto/nQjVmuHdlLpM2NOF2hjNeg/o.jpg', 86);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(576, 'pt_code_85', 'https://s3-media2.fl.yelpcdn.com/bphoto/Od7cltAzk_Q65cRIx7mE-Q/o.jpg', 86);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(577, 'pt_code_86', 'https://lh3.googleusercontent.com/p/AF1QipN0sBb90fQiER8zv-Vtl53aIhtzMA9y4_4FrFPD=s1600-w500', 87);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(578, 'pt_code_86', 'https://lh3.googleusercontent.com/p/AF1QipM85yDyJvJLU-gJI4lph0fG0saOkzDKomDqgyi3=s1600-w500', 87);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(579, 'pt_code_86', 'https://s3-media4.fl.yelpcdn.com/bphoto/Xf1bFwk4OJNGebhjp9ystw/o.jpg', 87);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(580, 'pt_code_86', 'https://s3-media1.fl.yelpcdn.com/bphoto/K2cwf_JocgJlKSpHb3lvjg/o.jpg', 87);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(581, 'pt_code_86', 'https://s3-media1.fl.yelpcdn.com/bphoto/daUb0SN2Mw-HYjVPwiiN9g/o.jpg', 87);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(582, 'pt_code_87', 'https://lh3.googleusercontent.com/p/AF1QipO8MQd6zY6DXC7kVz_VEP24qazlAS_8ipCyVs7V=s1600-w500', 88);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(583, 'pt_code_87', 'https://lh3.googleusercontent.com/p/AF1QipO80qskQhBH_kV6VKIAGHexWGzAfv8mVKaw-VuF=s1600-w500', 88);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(584, 'pt_code_87', 'https://lh3.googleusercontent.com/p/AF1QipPqFO_jcEU9QGB3n6mQfwp7hFpmbsSgWgxBDYGR=s1600-w500', 88);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(585, 'pt_code_87', 'https://lh3.googleusercontent.com/p/AF1QipOuCAfcmDtwiiK_G8QaUlBMnt4_3St9q6g6OHux=s1600-w500', 88);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(586, 'pt_code_87', 'https://lh3.googleusercontent.com/p/AF1QipPfdan5NCjlCcgFsg4S9WX6-_Fa048KGL2Frng4=s1600-w500', 88);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(587, 'pt_code_87', 'https://lh3.googleusercontent.com/p/AF1QipNd1CVGsuSJYdbflPMMlHWQ-OqQpZth7qdn3QRx=s1600-w500', 88);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(588, 'pt_code_87', 'https://lh3.googleusercontent.com/p/AF1QipPWGRQ4zarmTmBXEDPiXRsmmDugFQ3b_-xkr1Y7=s1600-w500', 88);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(589, 'pt_code_89', 'https://lh3.googleusercontent.com/p/AF1QipNvzIe1GR6rn6A9d0zII5fft6cEjTpRKcFnM576=s1600-w500', 90);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(590, 'pt_code_89', 'https://s3-media2.fl.yelpcdn.com/bphoto/AQ-Gd5gmcaOJfGkqKexd-A/o.jpg', 90);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(591, 'pt_code_89', 'https://s3-media1.fl.yelpcdn.com/bphoto/sFnxWPTe7h2F439GhUzc3w/o.jpg', 90);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(592, 'pt_code_89', 'https://s3-media2.fl.yelpcdn.com/bphoto/RMgtXzgHnnDKVUqYEzC-hw/o.jpg', 90);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(593, 'pt_code_91', 'https://lh3.googleusercontent.com/p/AF1QipOzzYA0E7GC-YablhR-DLILq4mlu9cn_AX1TbfA=s1600-w500', 92);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(594, 'pt_code_91', 'https://lh3.googleusercontent.com/p/AF1QipP3olk0fstkHeDWsQtxMN8XJbBsN1Cx9ana3HjD=s1600-w500', 92);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(595, 'pt_code_91', 'https://lh3.googleusercontent.com/p/AF1QipMhgwS9t63W8nNr9GW1N1BRFU3kXzZIDbZ91T39=s1600-w500', 92);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(596, 'pt_code_91', 'https://lh3.googleusercontent.com/p/AF1QipOoW7LCmXg1bjx3-rrvsY1WFb2h4fXDohbCkXJ9=s1600-w500', 92);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(597, 'pt_code_91', 'https://lh3.googleusercontent.com/p/AF1QipPzvLsCwDbj4WK8jRh4f7nd87Kkp3HoPYBI9VxR=s1600-w500', 92);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(598, 'pt_code_91', 'https://lh3.googleusercontent.com/p/AF1QipNNuYpOmEMjEsKAS_sXpKI6nTh4sbDFPWmmqi4y=s1600-w500', 92);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(599, 'pt_code_91', 'https://lh3.googleusercontent.com/p/AF1QipPP4ZICjtauN6NHTZxlqsJnx7tjzavmGceTWVDU=s1600-w500', 92);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(600, 'pt_code_91', 'https://lh3.googleusercontent.com/p/AF1QipNRGFwsVL5h06Fxh88k73u40cpv3Leyme3tUGll=s1600-w500', 92);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(601, 'pt_code_91', 'https://lh3.googleusercontent.com/p/AF1QipPYZhjeiLYgTu67o-OycuYg-xq_4gNjnCKVQBoD=s1600-w500', 92);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(602, 'pt_code_91', 'https://lh3.googleusercontent.com/p/AF1QipNpnFP950ejHwQHWWDddc9x18dPen8iW2ZMmvfJ=s1600-w500', 92);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(603, 'pt_code_91', 'https://s3-media4.fl.yelpcdn.com/bphoto/bbT-Nh0aM5GldVSnOfJjYg/o.jpg', 92);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(604, 'pt_code_91', 'https://s3-media1.fl.yelpcdn.com/bphoto/cxIsSj4TJNAOTpiKf72iQA/o.jpg', 92);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(605, 'pt_code_91', 'https://s3-media1.fl.yelpcdn.com/bphoto/4oi7IBhg0tINZulcPEUawg/o.jpg', 92);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(606, 'pt_code_92', 'https://lh3.googleusercontent.com/p/AF1QipNmLXqRV5QQIvYjQu1lP-r76hz5B0tVvtbRMBMd=s1600-w500', 93);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(607, 'pt_code_92', 'https://lh3.googleusercontent.com/p/AF1QipPXgi6EtexzkeD3IO2_GKRB2U6SeOJ7RzaXS3Ei=s1600-w500', 93);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(608, 'pt_code_92', 'https://lh3.googleusercontent.com/p/AF1QipP2l9ovY_LZK14BEC75iu9ueMO6zmzlv2_et2B7=s1600-w500', 93);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(609, 'pt_code_92', 'https://lh3.googleusercontent.com/p/AF1QipMcKWwGXc_A3ZyqhJayGlE_H_T5zoigxS9iurQO=s1600-w500', 93);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(610, 'pt_code_92', 'https://lh3.googleusercontent.com/p/AF1QipO0uJEj4meLY4A6FrZfGHH1K1cvzmoYZ1iZsnJc=s1600-w500', 93);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(611, 'pt_code_92', 'https://lh3.googleusercontent.com/p/AF1QipOWjlBcUXYw5OAH_zfQwVshZ2Nt4AzoUKCcxkhP=s1600-w500', 93);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(612, 'pt_code_92', 'https://lh3.googleusercontent.com/p/AF1QipN_CVL63vJ-AoJLEleCNPl3JBFLTnAWxKQxUSql=s1600-w500', 93);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(613, 'pt_code_92', 'https://lh3.googleusercontent.com/p/AF1QipMTRTJnsK_EhG3sB-3t4N-wn2qV_z53AIuEbflU=s1600-w300', 93);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(614, 'pt_code_92', 'https://lh3.googleusercontent.com/p/AF1QipMAvpyjWrONEV6_RL89GAQehSiV-I0u7u0T9pDN=s1600-w500', 93);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(615, 'pt_code_92', 'https://lh3.googleusercontent.com/p/AF1QipPJc1IVa391HvK7ehlDKZJGU5BKoLfZ4CrhLxqg=s1600-w500', 93);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(616, 'pt_code_92', 'https://s3-media4.fl.yelpcdn.com/bphoto/oj0Ymoj1eM0N3JF5OsZ09w/o.jpg', 93);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(617, 'pt_code_92', 'https://s3-media2.fl.yelpcdn.com/bphoto/bdwwSMJs9y_64kjUvGJYxQ/o.jpg', 93);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(618, 'pt_code_92', 'https://s3-media1.fl.yelpcdn.com/bphoto/PW7o6K0xSG9leQ-1tUd27Q/o.jpg', 93);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(619, 'pt_code_93', 'https://lh3.googleusercontent.com/p/AF1QipOb34d_wCgQHkkP7mLWC_lKY4-h2Z41ZIjuHl5b=s1600-w500', 94);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(620, 'pt_code_93', 'https://lh3.googleusercontent.com/p/AF1QipMkZ-GwrjqgEjimmhJCpOCW12XgVWbr3x_7rFBQ=s1600-w500', 94);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(621, 'pt_code_93', 'https://lh3.googleusercontent.com/p/AF1QipMIUYZPeijqFd4NZkz156b5rZjN2IdpqJxUYhxx=s1600-w500', 94);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(622, 'pt_code_93', 'https://lh3.googleusercontent.com/p/AF1QipOgGInESbrBbI2dRlQ3m7ylwPbNG0sHCiL2lYkU=s1600-w500', 94);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(623, 'pt_code_93', 'https://lh3.googleusercontent.com/p/AF1QipMdNMMAE0c5QT_YWBtuPIQeKfflL1wiJMX4hBkB=s1600-w500', 94);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(624, 'pt_code_93', 'https://lh3.googleusercontent.com/p/AF1QipNzunZaCgYKUN2XjUSRX52D6Dr4StGJCkwVKOTU=s1600-w500', 94);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(625, 'pt_code_93', 'https://lh3.googleusercontent.com/p/AF1QipNWiJzIPL7_Hdk7yRWDHi-xBzeJir2wWl5-qUX4=s1600-w500', 94);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(626, 'pt_code_93', 'https://lh3.googleusercontent.com/p/AF1QipMgpZ-kI8z2dRGnWu2p8iyShtnQ88KkgmWTkply=s1600-w500', 94);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(627, 'pt_code_93', 'https://lh3.googleusercontent.com/p/AF1QipNzEdHdzK9Wrzz1dPUWK-5cq63WwGB8C-thIH_D=s1600-w500', 94);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(628, 'pt_code_93', 'https://lh3.googleusercontent.com/p/AF1QipPwfJkLTvyRs58i10F-bcdA6J-v2CCEDRbSSAVC=s1600-w500', 94);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(629, 'pt_code_93', 'https://s3-media4.fl.yelpcdn.com/bphoto/biXG88XRRNQDNId0eztvtQ/o.jpg', 94);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(630, 'pt_code_93', 'https://s3-media3.fl.yelpcdn.com/bphoto/nE280QPt9Th5_F8foW7WQw/o.jpg', 94);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(631, 'pt_code_93', 'https://s3-media2.fl.yelpcdn.com/bphoto/bDE6IiW1cJdZBh5wuqSmog/o.jpg', 94);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(632, 'pt_code_94', 'https://lh3.googleusercontent.com/p/AF1QipPeNLlMTDRIqsVs3U29LF-pKBo6oX12CPdMHxgC=s1600-w500', 95);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(633, 'pt_code_94', 'https://lh3.googleusercontent.com/p/AF1QipOKwCMmIEsrIFaxSbC-J3d0rt4dLlXzziKjKPVC=s1600-w500', 95);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(634, 'pt_code_94', 'https://lh3.googleusercontent.com/p/AF1QipPmBXExy9boZeupnPhnqkC9ZyNeH26_F0MwhrHS=s1600-w500', 95);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(635, 'pt_code_94', 'https://lh3.googleusercontent.com/p/AF1QipMe4gAgMFXBokb6TBmkC3qetb1ULs76TcNrxKsz=s1600-w500', 95);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(636, 'pt_code_94', 'https://lh3.googleusercontent.com/p/AF1QipNLSx1SFNPdt6s8yUL-gGPAdgv2h3lhmjAEg1ej=s1600-w500', 95);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(637, 'pt_code_94', 'https://lh3.googleusercontent.com/p/AF1QipMhBBSs_UdvgPFCkFiUXzyEPzRrx97CY8FrrFfL=s1600-w500', 95);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(638, 'pt_code_94', 'https://lh3.googleusercontent.com/p/AF1QipO9M4JyIfoOGzxJwlNrmMiOOLo9ZxRnWWYTgEFZ=s1600-w500', 95);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(639, 'pt_code_94', 'https://lh3.googleusercontent.com/p/AF1QipPOkjY-WK-bSwk50bVGxCL5JM31iIDAEsjSHV66=s1600-w500', 95);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(640, 'pt_code_94', 'https://lh3.googleusercontent.com/p/AF1QipMmxyPwV_tLngvhJ_EKL0LJ5oP9silyad4YlFZh=s1600-w500', 95);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(641, 'pt_code_94', 'https://lh3.googleusercontent.com/p/AF1QipPOd96V_nyJ0fwgHpJBzP5aBeJbqH0Gc3ntMVxX=s1600-w500', 95);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(642, 'pt_code_95', 'https://lh3.googleusercontent.com/p/AF1QipO8MQd6zY6DXC7kVz_VEP24qazlAS_8ipCyVs7V=s1600-w500', 96);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(643, 'pt_code_95', 'https://lh3.googleusercontent.com/p/AF1QipO80qskQhBH_kV6VKIAGHexWGzAfv8mVKaw-VuF=s1600-w500', 96);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(644, 'pt_code_95', 'https://lh3.googleusercontent.com/p/AF1QipPqFO_jcEU9QGB3n6mQfwp7hFpmbsSgWgxBDYGR=s1600-w500', 96);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(645, 'pt_code_95', 'https://lh3.googleusercontent.com/p/AF1QipOuCAfcmDtwiiK_G8QaUlBMnt4_3St9q6g6OHux=s1600-w500', 96);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(646, 'pt_code_95', 'https://lh3.googleusercontent.com/p/AF1QipPfdan5NCjlCcgFsg4S9WX6-_Fa048KGL2Frng4=s1600-w500', 96);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(647, 'pt_code_95', 'https://lh3.googleusercontent.com/p/AF1QipNd1CVGsuSJYdbflPMMlHWQ-OqQpZth7qdn3QRx=s1600-w500', 96);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(648, 'pt_code_95', 'https://lh3.googleusercontent.com/p/AF1QipPWGRQ4zarmTmBXEDPiXRsmmDugFQ3b_-xkr1Y7=s1600-w500', 96);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(649, 'pt_code_96', 'https://s3-media4.fl.yelpcdn.com/bphoto/zM4_JnnUbu0lOLzCt3e9dA/o.jpg', 97);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(650, 'pt_code_96', 'https://s3-media3.fl.yelpcdn.com/bphoto/RAyW7kGSIrtYc7aSgJDrxw/o.jpg', 97);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(651, 'pt_code_96', 'https://s3-media1.fl.yelpcdn.com/bphoto/VsY14k1VuJjKy3KbxA7nCg/o.jpg', 97);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(652, 'pt_code_97', 'https://lh3.googleusercontent.com/p/AF1QipO8MQd6zY6DXC7kVz_VEP24qazlAS_8ipCyVs7V=s1600-w500', 98);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(653, 'pt_code_97', 'https://lh3.googleusercontent.com/p/AF1QipO80qskQhBH_kV6VKIAGHexWGzAfv8mVKaw-VuF=s1600-w500', 98);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(654, 'pt_code_97', 'https://lh3.googleusercontent.com/p/AF1QipPqFO_jcEU9QGB3n6mQfwp7hFpmbsSgWgxBDYGR=s1600-w500', 98);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(655, 'pt_code_97', 'https://lh3.googleusercontent.com/p/AF1QipOuCAfcmDtwiiK_G8QaUlBMnt4_3St9q6g6OHux=s1600-w500', 98);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(656, 'pt_code_97', 'https://lh3.googleusercontent.com/p/AF1QipPfdan5NCjlCcgFsg4S9WX6-_Fa048KGL2Frng4=s1600-w500', 98);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(657, 'pt_code_97', 'https://lh3.googleusercontent.com/p/AF1QipNd1CVGsuSJYdbflPMMlHWQ-OqQpZth7qdn3QRx=s1600-w500', 98);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(658, 'pt_code_97', 'https://lh3.googleusercontent.com/p/AF1QipPWGRQ4zarmTmBXEDPiXRsmmDugFQ3b_-xkr1Y7=s1600-w500', 98);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(659, 'pt_code_98', 'https://lh3.googleusercontent.com/p/AF1QipO8MQd6zY6DXC7kVz_VEP24qazlAS_8ipCyVs7V=s1600-w500', 99);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(660, 'pt_code_98', 'https://lh3.googleusercontent.com/p/AF1QipO80qskQhBH_kV6VKIAGHexWGzAfv8mVKaw-VuF=s1600-w500', 99);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(661, 'pt_code_98', 'https://lh3.googleusercontent.com/p/AF1QipPqFO_jcEU9QGB3n6mQfwp7hFpmbsSgWgxBDYGR=s1600-w500', 99);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(662, 'pt_code_98', 'https://lh3.googleusercontent.com/p/AF1QipOuCAfcmDtwiiK_G8QaUlBMnt4_3St9q6g6OHux=s1600-w500', 99);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(663, 'pt_code_98', 'https://lh3.googleusercontent.com/p/AF1QipPfdan5NCjlCcgFsg4S9WX6-_Fa048KGL2Frng4=s1600-w500', 99);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(664, 'pt_code_98', 'https://lh3.googleusercontent.com/p/AF1QipNd1CVGsuSJYdbflPMMlHWQ-OqQpZth7qdn3QRx=s1600-w500', 99);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(665, 'pt_code_98', 'https://lh3.googleusercontent.com/p/AF1QipPWGRQ4zarmTmBXEDPiXRsmmDugFQ3b_-xkr1Y7=s1600-w500', 99);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(666, 'pt_code_100', 'https://lh3.googleusercontent.com/p/AF1QipMifuq8Or1OcgtS8Ms3SY70WIb5AxrD_eWkxe_1=s1600-w500', 101);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(667, 'pt_code_100', 'https://lh3.googleusercontent.com/p/AF1QipPjEcOEonUQP-nF6tgmqxFk0qVlduznqkbLHbcm=s1600-w500', 101);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(668, 'pt_code_100', 'https://lh3.googleusercontent.com/p/AF1QipPUyvP4Soa9rgDTCJfJ_YklDBPe2ZlD2b-Re9lu=s1600-w500', 101);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(669, 'pt_code_100', 'https://lh3.googleusercontent.com/p/AF1QipPYFXG0le2LGlkCTFEh9Be_bPeaCuK9EgDeagYX=s1600-w500', 101);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(670, 'pt_code_100', 'https://lh3.googleusercontent.com/p/AF1QipMOL3Kh7UqHeGr1Mn6IxX52GUGLYzz455USXP2a=s1600-w500', 101);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(671, 'pt_code_100', 'https://lh3.googleusercontent.com/p/AF1QipO5e0CtZ-g-2ONqIS5g8lhy5tSjVrSg7YAsxvQq=s1600-w500', 101);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(672, 'pt_code_100', 'https://lh3.googleusercontent.com/p/AF1QipM9EXt_7B2ZgB3KVqd8Q6GbHnZONj8AcR4QKTE_=s1600-w500', 101);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(673, 'pt_code_100', 'https://lh3.googleusercontent.com/p/AF1QipP3MWMCHdI34N4S6BpWok3kkhtQNbHN0PqpXoT1=s1600-w500', 101);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(674, 'pt_code_100', 'https://lh3.googleusercontent.com/p/AF1QipNh899xEcyN5_Gnq631fkNGI1NM8teRWC2SGhSC=s1600-w500', 101);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(675, 'pt_code_100', 'https://lh3.googleusercontent.com/p/AF1QipOa6LjvpZrOVEdajBMG31iKmLfapjMrfO_oyaQ7=s1600-w500', 101);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(676, 'pt_code_100', 'https://s3-media1.fl.yelpcdn.com/bphoto/IXV8FkcIFOSAJ7pfTJ07zA/o.jpg', 101);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(677, 'pt_code_100', 'https://s3-media1.fl.yelpcdn.com/bphoto/LVhz9K-876lIQgtx98dbQw/o.jpg', 101);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(678, 'pt_code_100', 'https://s3-media2.fl.yelpcdn.com/bphoto/sVKMJYNP4Pn354luXQ3ffg/o.jpg', 101);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(679, 'pt_code_101', 'https://lh3.googleusercontent.com/p/AF1QipPBnsiRISfLZKBpN6Ft43fb-xf7LWJ-FyzhvbCU=s1600-w500', 102);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(680, 'pt_code_101', 'https://lh3.googleusercontent.com/p/AF1QipMzvyCxNZn8XgSDwIG7CZYqp2A4FIpJpFAnyd10=s1600-w500', 102);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(681, 'pt_code_101', 'https://lh3.googleusercontent.com/p/AF1QipMtOXRqub7gqM7EGa3ssUxLKuIjjioTbE2O5pKZ=s1600-w500', 102);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(682, 'pt_code_101', 'https://lh3.googleusercontent.com/p/AF1QipMZf8hPRAn8jY7QIGqOCQkP7JW5iGABz_u_1kKF=s1600-w500', 102);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(683, 'pt_code_101', 'https://lh3.googleusercontent.com/p/AF1QipN2FpppdrpIW-N1vtf4XGXVGLipnm3R4zyeFtg7=s1600-w500', 102);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(684, 'pt_code_101', 'https://lh3.googleusercontent.com/p/AF1QipNivV3h_JMF-7rcbtP4h_hnYGOJwdORZefG_in-=s1600-w250', 102);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(685, 'pt_code_102', 'https://lh3.googleusercontent.com/p/AF1QipMfnnpgR3cEP9L46mExXFpRdxsPrA1xbMQrm4op=s1600-w500', 103);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(686, 'pt_code_102', 'https://lh3.googleusercontent.com/p/AF1QipMtwe-Iz4AIYhSGe5JfEWiyoTFlI2PASo-N-oLL=s1600-w500', 103);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(687, 'pt_code_102', 'https://lh3.googleusercontent.com/p/AF1QipNJdNKpU8drQh-pHLjpB1tB_wu9A9UqKDEKn1A-=s1600-w500', 103);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(688, 'pt_code_102', 'https://lh3.googleusercontent.com/p/AF1QipNYR3oLJFEyw4f6gBtgOS2mL9YFx8Pe35MVSjv9=s1600-w500', 103);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(689, 'pt_code_102', 'https://lh3.googleusercontent.com/p/AF1QipMxky3EfdlDVqINrBFY_3hTANTFsIvOazEj0ADn=s1600-w500', 103);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(690, 'pt_code_102', 'https://lh3.googleusercontent.com/p/AF1QipPjy9JGAQlusQZkOAdIch8YNJANKJScEwSRDbSt=s1600-w500', 103);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(691, 'pt_code_102', 'https://lh3.googleusercontent.com/p/AF1QipNMhtZ8JCi2v4EAYuS87Qz7VC4WPrKi4msYbH08=s1600-w500', 103);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(692, 'pt_code_102', 'https://lh3.googleusercontent.com/p/AF1QipORGhnyVFtJooMrTy6hTdcAFcGrzIDXuHXD463u=s1600-w500', 103);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(693, 'pt_code_102', 'https://lh3.googleusercontent.com/p/AF1QipMhIn_hSLOJKxcXKfPNyG1-k-Wn5l56lV1xaBFc=s1600-w500', 103);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(694, 'pt_code_102', 'https://lh3.googleusercontent.com/p/AF1QipO1hKYDJEnN1WuQdI8lw9eyeHF9n7CCf5F5UzbT=s1600-w500', 103);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(695, 'pt_code_102', 'https://s3-media3.fl.yelpcdn.com/bphoto/ntWSdY4Wua0FNUb31XmbPg/o.jpg', 103);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(696, 'pt_code_102', 'https://s3-media1.fl.yelpcdn.com/bphoto/RJ_zyltsIBlNTV2Sr0MIlA/o.jpg', 103);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(697, 'pt_code_102', 'https://s3-media1.fl.yelpcdn.com/bphoto/ZXsCUo2yWgi_5f0FLyjptw/o.jpg', 103);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(698, 'pt_code_103', 'https://lh3.googleusercontent.com/p/AF1QipO_6U04Gby9eBFTG6_IZBEdKjnUECZRD7-185Yq=s1600-w500', 104);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(699, 'pt_code_103', 'https://s3-media2.fl.yelpcdn.com/bphoto/xxi0yTvSZxnvh6Kh5mrFUw/o.jpg', 104);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(700, 'pt_code_103', 'https://s3-media2.fl.yelpcdn.com/bphoto/Ns2Xo53Ed7pweud1CUIxVQ/o.jpg', 104);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(701, 'pt_code_103', 'https://s3-media3.fl.yelpcdn.com/bphoto/SJKw88cxV6Koza_MsnX52g/o.jpg', 104);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(702, 'pt_code_105', 'https://lh3.googleusercontent.com/p/AF1QipPIqV5SrOwA_YkTBqjlxH08OUarAq-Emz0m5LbI=s1600-w500', 106);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(703, 'pt_code_105', 'https://lh3.googleusercontent.com/p/AF1QipNSkYG10A82Qg7e0pdceNkV5S_iEvRPxamNs_4j=s1600-w500', 106);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(704, 'pt_code_105', 'https://lh3.googleusercontent.com/p/AF1QipNIv84tt9sTGNl4w7il5u3nyGO5DNtrEUmPr5mX=s1600-w500', 106);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(705, 'pt_code_105', 'https://lh3.googleusercontent.com/p/AF1QipOZNOnko0iD2zN4BYOk2XP-hhcLFLBNdF2DZtqt=s1600-w500', 106);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(706, 'pt_code_105', 'https://lh3.googleusercontent.com/p/AF1QipOcWDU0av_0vSPyQy-ZWV42d-A18f5Qf9e5mcxP=s1600-w500', 106);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(707, 'pt_code_105', 'https://lh3.googleusercontent.com/p/AF1QipP4SOrdYSlBmZ7Ni38hhU59w3t0dy9XLoqWGFDI=s1600-w500', 106);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(708, 'pt_code_105', 'https://lh3.googleusercontent.com/p/AF1QipPJthyqPES3dBXcGKBkfF9Dokrx0AgYc_HQ5EoU=s1600-w500', 106);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(709, 'pt_code_105', 'https://lh3.googleusercontent.com/p/AF1QipO4rRZHxpX16vTKd8pS16ocehCXa2pH9munMrN5=s1600-w500', 106);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(710, 'pt_code_105', 'https://lh3.googleusercontent.com/p/AF1QipP1Oo_2KAQo_iLIvum3m99kh1WiOJ6ErOZV13o9=s1600-w500', 106);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(711, 'pt_code_105', 'https://lh3.googleusercontent.com/p/AF1QipNV1DvJUFoTZH3fZ8hcoSGVzsxvfGaeXLin2-Dy=s1600-w500', 106);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(712, 'pt_code_106', 'https://lh3.googleusercontent.com/p/AF1QipO9s4Ow1HPk1W9ynCaK4Zy6m_nqDCvRqvWxtlHE=s1600-w500', 107);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(713, 'pt_code_106', 'https://lh3.googleusercontent.com/p/AF1QipOV8fkogQM6IfEwMGTH964dX4hx1M_Ba7DIQkPo=s1600-w500', 107);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(714, 'pt_code_106', 'https://lh3.googleusercontent.com/p/AF1QipPcQJJmRjH3aRt7ejF7yJe4FzS6JGNSdfgpXZiW=s1600-w500', 107);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(715, 'pt_code_106', 'https://lh3.googleusercontent.com/p/AF1QipOp2Z3J1lfW4mr1WtFhRPeFb0PzYVeY_kvUhMo3=s1600-w500', 107);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(716, 'pt_code_106', 'https://lh3.googleusercontent.com/p/AF1QipM37ok49CRkB7L1oQU4kVI_yRe3b1X_FPkZ6heV=s1600-w500', 107);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(717, 'pt_code_106', 'https://lh3.googleusercontent.com/p/AF1QipMlSDbP3tO7ImmqSW3V2n60oSDKcAO4r60XFQpc=s1600-w500', 107);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(718, 'pt_code_106', 'https://lh3.googleusercontent.com/p/AF1QipOU4Ei9fldNEcUAozjX2TuTLxoeCzrJEZIvfOWc=s1600-w500', 107);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(719, 'pt_code_106', 'https://lh3.googleusercontent.com/p/AF1QipPKtguw_cuT6RB7T_NVYY5DcUaZjrhiU-Svj2dd=s1600-w500', 107);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(720, 'pt_code_107', 'https://lh3.googleusercontent.com/p/AF1QipO8MQd6zY6DXC7kVz_VEP24qazlAS_8ipCyVs7V=s1600-w500', 108);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(721, 'pt_code_107', 'https://lh3.googleusercontent.com/p/AF1QipO80qskQhBH_kV6VKIAGHexWGzAfv8mVKaw-VuF=s1600-w500', 108);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(722, 'pt_code_107', 'https://lh3.googleusercontent.com/p/AF1QipPqFO_jcEU9QGB3n6mQfwp7hFpmbsSgWgxBDYGR=s1600-w500', 108);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(723, 'pt_code_107', 'https://lh3.googleusercontent.com/p/AF1QipOuCAfcmDtwiiK_G8QaUlBMnt4_3St9q6g6OHux=s1600-w500', 108);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(724, 'pt_code_107', 'https://lh3.googleusercontent.com/p/AF1QipPfdan5NCjlCcgFsg4S9WX6-_Fa048KGL2Frng4=s1600-w500', 108);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(725, 'pt_code_107', 'https://lh3.googleusercontent.com/p/AF1QipNd1CVGsuSJYdbflPMMlHWQ-OqQpZth7qdn3QRx=s1600-w500', 108);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(726, 'pt_code_107', 'https://lh3.googleusercontent.com/p/AF1QipPWGRQ4zarmTmBXEDPiXRsmmDugFQ3b_-xkr1Y7=s1600-w500', 108);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(727, 'pt_code_108', 'https://lh3.googleusercontent.com/p/AF1QipOdPH4E9rTwVh5Vf98HphSEoZmta2nGU366XqbH=s1600-w500', 109);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(728, 'pt_code_108', 'https://lh3.googleusercontent.com/p/AF1QipOS3CBp3dmFRLaBeGkxS7Vegr6sHQRawXDPRmAm=s1600-w500', 109);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(729, 'pt_code_109', 'https://lh3.googleusercontent.com/p/AF1QipPXZ94aT7-ea-pjKw3KqXwAklqGdhJo6HSSKieo=s1600-w500', 110);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(730, 'pt_code_109', 'https://lh3.googleusercontent.com/p/AF1QipOyCOm9tz6MJLJPuN4EDh8-csa1xlCIhiuwSwSz=s1600-w500', 110);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(731, 'pt_code_109', 'https://lh3.googleusercontent.com/p/AF1QipOxFrOexLoGSV-A0S-r83wJKNcILUTPGmoTyedo=s1600-w500', 110);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(732, 'pt_code_109', 'https://lh3.googleusercontent.com/p/AF1QipONrcAvWX4Ugymxc461eeaEjE6uUGTCq6KQ0sV8=s1600-w500', 110);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(733, 'pt_code_109', 'https://lh3.googleusercontent.com/p/AF1QipMghPX3eARiknErH9gx9r3oteidrWIDrp5CEf5S=s1600-w500', 110);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(734, 'pt_code_109', 'https://lh3.googleusercontent.com/p/AF1QipMnJ4zR09qiD83WibG-444REnef8vSKq4MamCFo=s1600-w500', 110);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(735, 'pt_code_109', 'https://s3-media4.fl.yelpcdn.com/bphoto/TzYDBVuK1pwU1j1XtRSPNA/o.jpg', 110);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(736, 'pt_code_109', 'https://s3-media3.fl.yelpcdn.com/bphoto/406OHJnQK-2sSwl7nn-fOg/o.jpg', 110);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(737, 'pt_code_109', 'https://s3-media2.fl.yelpcdn.com/bphoto/_7Al5sK1ivFIdjR5WRoQAQ/o.jpg', 110);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(738, 'pt_code_112', 'https://s3-media2.fl.yelpcdn.com/bphoto/T2nYt8p_W7gdO3gFT_bqAg/o.jpg', 113);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(739, 'pt_code_112', 'https://s3-media2.fl.yelpcdn.com/bphoto/rfqYIjqlwUE8tjZxE8UsGA/o.jpg', 113);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(740, 'pt_code_112', 'https://s3-media1.fl.yelpcdn.com/bphoto/Q1DVQauW8yMQEFqRhM4UbQ/o.jpg', 113);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(741, 'pt_code_114', 'https://lh3.googleusercontent.com/p/AF1QipM0ZzM5hRlxUGCxBL_1uRu8A1r7pM7gdrhgU2o=s1600-w500', 115);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(742, 'pt_code_114', 'https://lh3.googleusercontent.com/p/AF1QipP3F9kln6Q9QPfUbOOV-DpmduoZFo4NAa-RMlc=s1600-w500', 115);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(743, 'pt_code_114', 'https://lh3.googleusercontent.com/p/AF1QipPBmiLFS5ILaOwh6mdFtkOeVR16tZnbroNtiAoT=s1600-w500', 115);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(744, 'pt_code_114', 'https://lh3.googleusercontent.com/p/AF1QipPRZ7zR1ch59SPxK5ba-DhpCHdGBlRIFhu0B08=s1600-w500', 115);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(745, 'pt_code_114', 'https://lh3.googleusercontent.com/p/AF1QipNhfRcFsUaOpeIox5odqo8kt8jHSa-j57Xq_d2o=s1600-w500', 115);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(746, 'pt_code_114', 'https://lh3.googleusercontent.com/p/AF1QipOtPAmK_dZVP2N5CZPeXSc3UaUP6hUJP3Il68k=s1600-w500', 115);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(747, 'pt_code_114', 'https://lh3.googleusercontent.com/p/AF1QipN2DIYhGEqQVGubCdWqt7Cz7lGNrg5W7QEDAmQ=s1600-w500', 115);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(748, 'pt_code_114', 'https://lh3.googleusercontent.com/p/AF1QipNpMXnrskzPgYu44POGJezfCesXG4p_mgvwNj8=s1600-w500', 115);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(749, 'pt_code_114', 'https://lh3.googleusercontent.com/p/AF1QipOWSJp4toa1FtK0_4OA9WpPp_xyafXEeuUc0sZw=s1600-w500', 115);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(750, 'pt_code_114', 'https://lh3.googleusercontent.com/p/AF1QipNuko1FmrgRjL9kHEWuaGv8bnULV1lfSxGk26-P=s1600-w500', 115);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(751, 'pt_code_114', 'https://s3-media4.fl.yelpcdn.com/bphoto/S_WeUmWWMArmL9Q161FuwQ/o.jpg', 115);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(752, 'pt_code_114', 'https://s3-media2.fl.yelpcdn.com/bphoto/KixWUinFkVlhRwwS4hdDIA/o.jpg', 115);
INSERT INTO `rw_property_images` (`id`, `property_code`, `image_url`, `property_details_id`) VALUES
(753, 'pt_code_114', 'https://s3-media1.fl.yelpcdn.com/bphoto/qyvvqwIJJJEWOF6s0WYqUA/o.jpg', 115);

-- --------------------------------------------------------

--
-- Table structure for table `rw_property_tax_details`
--

CREATE TABLE `rw_property_tax_details` (
  `id` int(15) NOT NULL,
  `tax_account_id` varchar(50) DEFAULT NULL,
  `property_code` varchar(15) DEFAULT NULL,
  `assessed_land_value` int(15) DEFAULT NULL,
  `assessed_improvement_value` int(15) DEFAULT NULL,
  `total_assessment` int(15) DEFAULT NULL,
  `tax_amount` int(15) DEFAULT NULL,
  `tax_year` int(15) DEFAULT NULL,
  `outstanding_tax` int(15) DEFAULT NULL,
  `appraised_total` int(15) DEFAULT NULL,
  `appraised_land` int(15) DEFAULT NULL,
  `appraised_improvement` int(15) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `rw_property_tax_details`
--

INSERT INTO `rw_property_tax_details` (`id`, `tax_account_id`, `property_code`, `assessed_land_value`, `assessed_improvement_value`, `total_assessment`, `tax_amount`, `tax_year`, `outstanding_tax`, `appraised_total`, `appraised_land`, `appraised_improvement`) VALUES
(1, '501-1130-044-03', 'pt_code_19', 1090073, 902187, 1992260, 37088, 2016, NULL, NULL, NULL, NULL);
INSERT INTO `rw_property_tax_details` (`id`, `tax_account_id`, `property_code`, `assessed_land_value`, `assessed_improvement_value`, `total_assessment`, `tax_amount`, `tax_year`, `outstanding_tax`, `appraised_total`, `appraised_land`, `appraised_improvement`) VALUES
(2, '525-1052-011', 'pt_code_20', 13060000, 2860000, 15920000, 256915, 2016, NULL, NULL, NULL, NULL);
INSERT INTO `rw_property_tax_details` (`id`, `tax_account_id`, `property_code`, `assessed_land_value`, `assessed_improvement_value`, `total_assessment`, `tax_amount`, `tax_year`, `outstanding_tax`, `appraised_total`, `appraised_land`, `appraised_improvement`) VALUES
(3, '507-0085-024', 'pt_code_21', 896, NULL, 896, 108, 2016, NULL, NULL, NULL, NULL);
INSERT INTO `rw_property_tax_details` (`id`, `tax_account_id`, `property_code`, `assessed_land_value`, `assessed_improvement_value`, `total_assessment`, `tax_amount`, `tax_year`, `outstanding_tax`, `appraised_total`, `appraised_land`, `appraised_improvement`) VALUES
(4, '531-0006-009', 'pt_code_22', 152309, 362046, 514355, 20480, 2016, NULL, NULL, NULL, NULL);
INSERT INTO `rw_property_tax_details` (`id`, `tax_account_id`, `property_code`, `assessed_land_value`, `assessed_improvement_value`, `total_assessment`, `tax_amount`, `tax_year`, `outstanding_tax`, `appraised_total`, `appraised_land`, `appraised_improvement`) VALUES
(5, '531-0026-040-06', 'pt_code_23', 386924, 1598098, 1985022, 23641, 2016, NULL, NULL, NULL, NULL);
INSERT INTO `rw_property_tax_details` (`id`, `tax_account_id`, `property_code`, `assessed_land_value`, `assessed_improvement_value`, `total_assessment`, `tax_amount`, `tax_year`, `outstanding_tax`, `appraised_total`, `appraised_land`, `appraised_improvement`) VALUES
(6, '525-0716-084', 'pt_code_24', 597381, 494118, 1091499, 23507, 2016, NULL, NULL, NULL, NULL);
INSERT INTO `rw_property_tax_details` (`id`, `tax_account_id`, `property_code`, `assessed_land_value`, `assessed_improvement_value`, `total_assessment`, `tax_amount`, `tax_year`, `outstanding_tax`, `appraised_total`, `appraised_land`, `appraised_improvement`) VALUES
(7, '525-0850-010-15', 'pt_code_25', 434172, 280745, 714917, 14634, 2016, NULL, NULL, NULL, NULL);
INSERT INTO `rw_property_tax_details` (`id`, `tax_account_id`, `property_code`, `assessed_land_value`, `assessed_improvement_value`, `total_assessment`, `tax_amount`, `tax_year`, `outstanding_tax`, `appraised_total`, `appraised_land`, `appraised_improvement`) VALUES
(8, '501-0976-003', 'pt_code_26', 771000, 1544806, 2315806, 37059, 2016, NULL, NULL, NULL, NULL);
INSERT INTO `rw_property_tax_details` (`id`, `tax_account_id`, `property_code`, `assessed_land_value`, `assessed_improvement_value`, `total_assessment`, `tax_amount`, `tax_year`, `outstanding_tax`, `appraised_total`, `appraised_land`, `appraised_improvement`) VALUES
(9, '525-0969-149-06', 'pt_code_27', 883112, 1052062, 1935174, 24073, 2016, NULL, NULL, NULL, NULL);
INSERT INTO `rw_property_tax_details` (`id`, `tax_account_id`, `property_code`, `assessed_land_value`, `assessed_improvement_value`, `total_assessment`, `tax_amount`, `tax_year`, `outstanding_tax`, `appraised_total`, `appraised_land`, `appraised_improvement`) VALUES
(10, '501-0976-001', 'pt_code_28', 998586, 473718, 1472304, 17934, 2016, NULL, NULL, NULL, NULL);
INSERT INTO `rw_property_tax_details` (`id`, `tax_account_id`, `property_code`, `assessed_land_value`, `assessed_improvement_value`, `total_assessment`, `tax_amount`, `tax_year`, `outstanding_tax`, `appraised_total`, `appraised_land`, `appraised_improvement`) VALUES
(11, '519-0850-121', 'pt_code_29', 1545446, 1295394, 2840840, 43371, 2016, NULL, NULL, NULL, NULL);
INSERT INTO `rw_property_tax_details` (`id`, `tax_account_id`, `property_code`, `assessed_land_value`, `assessed_improvement_value`, `total_assessment`, `tax_amount`, `tax_year`, `outstanding_tax`, `appraised_total`, `appraised_land`, `appraised_improvement`) VALUES
(12, '513-0748-001-03', 'pt_code_30', 714285, 434023, 1148308, 14843, 2016, NULL, NULL, NULL, NULL);
INSERT INTO `rw_property_tax_details` (`id`, `tax_account_id`, `property_code`, `assessed_land_value`, `assessed_improvement_value`, `total_assessment`, `tax_amount`, `tax_year`, `outstanding_tax`, `appraised_total`, `appraised_land`, `appraised_improvement`) VALUES
(13, '519-1351-009-02', 'pt_code_31', 3716959, 2023543, 5740502, 85601, 2016, NULL, NULL, NULL, NULL);
INSERT INTO `rw_property_tax_details` (`id`, `tax_account_id`, `property_code`, `assessed_land_value`, `assessed_improvement_value`, `total_assessment`, `tax_amount`, `tax_year`, `outstanding_tax`, `appraised_total`, `appraised_land`, `appraised_improvement`) VALUES
(14, '525-0008-004', 'pt_code_32', 695247, 160324, 855571, 12198, 2016, NULL, NULL, NULL, NULL);
INSERT INTO `rw_property_tax_details` (`id`, `tax_account_id`, `property_code`, `assessed_land_value`, `assessed_improvement_value`, `total_assessment`, `tax_amount`, `tax_year`, `outstanding_tax`, `appraised_total`, `appraised_land`, `appraised_improvement`) VALUES
(15, '513-0609-030', 'pt_code_33', 616560, 169027, 785587, 10490, 2016, NULL, NULL, NULL, NULL);
INSERT INTO `rw_property_tax_details` (`id`, `tax_account_id`, `property_code`, `assessed_land_value`, `assessed_improvement_value`, `total_assessment`, `tax_amount`, `tax_year`, `outstanding_tax`, `appraised_total`, `appraised_land`, `appraised_improvement`) VALUES
(16, '543-0256-005-04', 'pt_code_34', 203588, NULL, 203588, 3260, 2016, NULL, NULL, NULL, NULL);
INSERT INTO `rw_property_tax_details` (`id`, `tax_account_id`, `property_code`, `assessed_land_value`, `assessed_improvement_value`, `total_assessment`, `tax_amount`, `tax_year`, `outstanding_tax`, `appraised_total`, `appraised_land`, `appraised_improvement`) VALUES
(17, '537-0521-029-01', 'pt_code_35', 2940281, 943109, 3883390, 57693, 2016, NULL, NULL, NULL, NULL);
INSERT INTO `rw_property_tax_details` (`id`, `tax_account_id`, `property_code`, `assessed_land_value`, `assessed_improvement_value`, `total_assessment`, `tax_amount`, `tax_year`, `outstanding_tax`, `appraised_total`, `appraised_land`, `appraised_improvement`) VALUES
(18, '501-0499-057-09', 'pt_code_36', 195616, NULL, 195616, 4468, 2016, NULL, NULL, NULL, NULL);
INSERT INTO `rw_property_tax_details` (`id`, `tax_account_id`, `property_code`, `assessed_land_value`, `assessed_improvement_value`, `total_assessment`, `tax_amount`, `tax_year`, `outstanding_tax`, `appraised_total`, `appraised_land`, `appraised_improvement`) VALUES
(19, '501-1425-016-54', 'pt_code_37', 132269, 284720, 416989, 5429, 2016, NULL, NULL, NULL, NULL);
INSERT INTO `rw_property_tax_details` (`id`, `tax_account_id`, `property_code`, `assessed_land_value`, `assessed_improvement_value`, `total_assessment`, `tax_amount`, `tax_year`, `outstanding_tax`, `appraised_total`, `appraised_land`, `appraised_improvement`) VALUES
(20, '519-1244-079-07', 'pt_code_38', 75572, NULL, 75572, 1070, 2016, NULL, NULL, NULL, NULL);
INSERT INTO `rw_property_tax_details` (`id`, `tax_account_id`, `property_code`, `assessed_land_value`, `assessed_improvement_value`, `total_assessment`, `tax_amount`, `tax_year`, `outstanding_tax`, `appraised_total`, `appraised_land`, `appraised_improvement`) VALUES
(21, '525-1651-095', 'pt_code_39', 941253, 181759, 1123012, 25986, 2016, NULL, NULL, NULL, NULL);
INSERT INTO `rw_property_tax_details` (`id`, `tax_account_id`, `property_code`, `assessed_land_value`, `assessed_improvement_value`, `total_assessment`, `tax_amount`, `tax_year`, `outstanding_tax`, `appraised_total`, `appraised_land`, `appraised_improvement`) VALUES
(22, '525-1655-057-01', 'pt_code_40', 723524, 528120, 1251644, 15362, 2016, NULL, NULL, NULL, NULL);
INSERT INTO `rw_property_tax_details` (`id`, `tax_account_id`, `property_code`, `assessed_land_value`, `assessed_improvement_value`, `total_assessment`, `tax_amount`, `tax_year`, `outstanding_tax`, `appraised_total`, `appraised_land`, `appraised_improvement`) VALUES
(23, '519-1194-074-04', 'pt_code_41', 911284, 207110, 1118394, 13509, 2016, NULL, NULL, NULL, NULL);
INSERT INTO `rw_property_tax_details` (`id`, `tax_account_id`, `property_code`, `assessed_land_value`, `assessed_improvement_value`, `total_assessment`, `tax_amount`, `tax_year`, `outstanding_tax`, `appraised_total`, `appraised_land`, `appraised_improvement`) VALUES
(24, '525-1350-047', 'pt_code_42', 2263299, 2807021, 5070320, 84613, 2016, NULL, NULL, NULL, NULL);
INSERT INTO `rw_property_tax_details` (`id`, `tax_account_id`, `property_code`, `assessed_land_value`, `assessed_improvement_value`, `total_assessment`, `tax_amount`, `tax_year`, `outstanding_tax`, `appraised_total`, `appraised_land`, `appraised_improvement`) VALUES
(25, '519-0850-007-18', 'pt_code_43', 773431, 1385330, 2158761, 33693, 2016, NULL, NULL, NULL, NULL);
INSERT INTO `rw_property_tax_details` (`id`, `tax_account_id`, `property_code`, `assessed_land_value`, `assessed_improvement_value`, `total_assessment`, `tax_amount`, `tax_year`, `outstanding_tax`, `appraised_total`, `appraised_land`, `appraised_improvement`) VALUES
(26, '519-0850-087-04', 'pt_code_44', 3311670, 5188283, 8499953, 117449, 2016, NULL, NULL, NULL, NULL);
INSERT INTO `rw_property_tax_details` (`id`, `tax_account_id`, `property_code`, `assessed_land_value`, `assessed_improvement_value`, `total_assessment`, `tax_amount`, `tax_year`, `outstanding_tax`, `appraised_total`, `appraised_land`, `appraised_improvement`) VALUES
(27, '531-0411-007-03', 'pt_code_45', 1896052, 3703058, 5599110, 92920, 2016, NULL, NULL, NULL, NULL);
INSERT INTO `rw_property_tax_details` (`id`, `tax_account_id`, `property_code`, `assessed_land_value`, `assessed_improvement_value`, `total_assessment`, `tax_amount`, `tax_year`, `outstanding_tax`, `appraised_total`, `appraised_land`, `appraised_improvement`) VALUES
(28, '513-0610-087', 'pt_code_46', 1272738, 2456459, 3729197, 48744, 2016, NULL, NULL, NULL, NULL);
INSERT INTO `rw_property_tax_details` (`id`, `tax_account_id`, `property_code`, `assessed_land_value`, `assessed_improvement_value`, `total_assessment`, `tax_amount`, `tax_year`, `outstanding_tax`, `appraised_total`, `appraised_land`, `appraised_improvement`) VALUES
(29, '519-0850-088-05', 'pt_code_47', 3485592, 10264068, 13749660, 182754, 2016, NULL, NULL, NULL, NULL);
INSERT INTO `rw_property_tax_details` (`id`, `tax_account_id`, `property_code`, `assessed_land_value`, `assessed_improvement_value`, `total_assessment`, `tax_amount`, `tax_year`, `outstanding_tax`, `appraised_total`, `appraised_land`, `appraised_improvement`) VALUES
(30, '519-1680-027-05', 'pt_code_48', 3696840, 6126192, 9823032, 138339, 2016, NULL, NULL, NULL, NULL);
INSERT INTO `rw_property_tax_details` (`id`, `tax_account_id`, `property_code`, `assessed_land_value`, `assessed_improvement_value`, `total_assessment`, `tax_amount`, `tax_year`, `outstanding_tax`, `appraised_total`, `appraised_land`, `appraised_improvement`) VALUES
(31, '531-0412-008', 'pt_code_49', 672921, 1969910, 2642831, 54001, 2016, NULL, NULL, NULL, NULL);
INSERT INTO `rw_property_tax_details` (`id`, `tax_account_id`, `property_code`, `assessed_land_value`, `assessed_improvement_value`, `total_assessment`, `tax_amount`, `tax_year`, `outstanding_tax`, `appraised_total`, `appraised_land`, `appraised_improvement`) VALUES
(32, '525-1604-079', 'pt_code_50', 600000, 400000, 1000000, 9102, 2016, NULL, NULL, NULL, NULL);
INSERT INTO `rw_property_tax_details` (`id`, `tax_account_id`, `property_code`, `assessed_land_value`, `assessed_improvement_value`, `total_assessment`, `tax_amount`, `tax_year`, `outstanding_tax`, `appraised_total`, `appraised_land`, `appraised_improvement`) VALUES
(33, '525-0008-009', 'pt_code_51', 260813, 774049, 1034862, 17572, 2016, NULL, NULL, NULL, NULL);
INSERT INTO `rw_property_tax_details` (`id`, `tax_account_id`, `property_code`, `assessed_land_value`, `assessed_improvement_value`, `total_assessment`, `tax_amount`, `tax_year`, `outstanding_tax`, `appraised_total`, `appraised_land`, `appraised_improvement`) VALUES
(34, '525-1052-011', 'pt_code_52', 13060000, 2860000, 15920000, 256915, 2016, NULL, NULL, NULL, NULL);
INSERT INTO `rw_property_tax_details` (`id`, `tax_account_id`, `property_code`, `assessed_land_value`, `assessed_improvement_value`, `total_assessment`, `tax_amount`, `tax_year`, `outstanding_tax`, `appraised_total`, `appraised_land`, `appraised_improvement`) VALUES
(35, '531-0026-040-06', 'pt_code_53', 386924, 1598098, 1985022, 23641, 2016, NULL, NULL, NULL, NULL);
INSERT INTO `rw_property_tax_details` (`id`, `tax_account_id`, `property_code`, `assessed_land_value`, `assessed_improvement_value`, `total_assessment`, `tax_amount`, `tax_year`, `outstanding_tax`, `appraised_total`, `appraised_land`, `appraised_improvement`) VALUES
(36, '501-1475-044-07', 'pt_code_54', 161090, 115692, 276782, 3761, 2016, NULL, NULL, NULL, NULL);
INSERT INTO `rw_property_tax_details` (`id`, `tax_account_id`, `property_code`, `assessed_land_value`, `assessed_improvement_value`, `total_assessment`, `tax_amount`, `tax_year`, `outstanding_tax`, `appraised_total`, `appraised_land`, `appraised_improvement`) VALUES
(37, '501-1425-033', 'pt_code_55', 1350750, 1870524, 3221274, 58212, 2016, NULL, NULL, NULL, NULL);
INSERT INTO `rw_property_tax_details` (`id`, `tax_account_id`, `property_code`, `assessed_land_value`, `assessed_improvement_value`, `total_assessment`, `tax_amount`, `tax_year`, `outstanding_tax`, `appraised_total`, `appraised_land`, `appraised_improvement`) VALUES
(38, '531-0026-040-06', 'pt_code_56', 386924, 1598098, 1985022, 23641, 2016, NULL, NULL, NULL, NULL);
INSERT INTO `rw_property_tax_details` (`id`, `tax_account_id`, `property_code`, `assessed_land_value`, `assessed_improvement_value`, `total_assessment`, `tax_amount`, `tax_year`, `outstanding_tax`, `appraised_total`, `appraised_land`, `appraised_improvement`) VALUES
(39, '501-0975-021', 'pt_code_57', 1268153, 2295439, 3563592, 52902, 2016, NULL, NULL, NULL, NULL);
INSERT INTO `rw_property_tax_details` (`id`, `tax_account_id`, `property_code`, `assessed_land_value`, `assessed_improvement_value`, `total_assessment`, `tax_amount`, `tax_year`, `outstanding_tax`, `appraised_total`, `appraised_land`, `appraised_improvement`) VALUES
(40, '501-0536-003-05', 'pt_code_58', 763704, 769468, 1533172, 19004, 2016, NULL, NULL, NULL, NULL);
INSERT INTO `rw_property_tax_details` (`id`, `tax_account_id`, `property_code`, `assessed_land_value`, `assessed_improvement_value`, `total_assessment`, `tax_amount`, `tax_year`, `outstanding_tax`, `appraised_total`, `appraised_land`, `appraised_improvement`) VALUES
(41, '519-1729-025', 'pt_code_59', 72488, 174593, 247081, 3373, 2016, NULL, NULL, NULL, NULL);
INSERT INTO `rw_property_tax_details` (`id`, `tax_account_id`, `property_code`, `assessed_land_value`, `assessed_improvement_value`, `total_assessment`, `tax_amount`, `tax_year`, `outstanding_tax`, `appraised_total`, `appraised_land`, `appraised_improvement`) VALUES
(42, '501-1130-022-01', 'pt_code_60', 3264000, 2346000, 5610000, 23489, 2016, NULL, NULL, NULL, NULL);
INSERT INTO `rw_property_tax_details` (`id`, `tax_account_id`, `property_code`, `assessed_land_value`, `assessed_improvement_value`, `total_assessment`, `tax_amount`, `tax_year`, `outstanding_tax`, `appraised_total`, `appraised_land`, `appraised_improvement`) VALUES
(43, '519-1351-009-02', 'pt_code_61', 3716959, 2023543, 5740502, 85601, 2016, NULL, NULL, NULL, NULL);
INSERT INTO `rw_property_tax_details` (`id`, `tax_account_id`, `property_code`, `assessed_land_value`, `assessed_improvement_value`, `total_assessment`, `tax_amount`, `tax_year`, `outstanding_tax`, `appraised_total`, `appraised_land`, `appraised_improvement`) VALUES
(44, '486-0099-036', 'pt_code_62', 2551942, 3789686, 6341628, 85683, 2016, NULL, NULL, NULL, NULL);
INSERT INTO `rw_property_tax_details` (`id`, `tax_account_id`, `property_code`, `assessed_land_value`, `assessed_improvement_value`, `total_assessment`, `tax_amount`, `tax_year`, `outstanding_tax`, `appraised_total`, `appraised_land`, `appraised_improvement`) VALUES
(45, '486-0051-010', 'pt_code_63', 2249983, 2855085, 5105068, 139272, 2016, NULL, NULL, NULL, NULL);
INSERT INTO `rw_property_tax_details` (`id`, `tax_account_id`, `property_code`, `assessed_land_value`, `assessed_improvement_value`, `total_assessment`, `tax_amount`, `tax_year`, `outstanding_tax`, `appraised_total`, `appraised_land`, `appraised_improvement`) VALUES
(46, '483-0042-108-02', 'pt_code_64', 703462, 270562, 974024, 12780, 2016, NULL, NULL, NULL, NULL);
INSERT INTO `rw_property_tax_details` (`id`, `tax_account_id`, `property_code`, `assessed_land_value`, `assessed_improvement_value`, `total_assessment`, `tax_amount`, `tax_year`, `outstanding_tax`, `appraised_total`, `appraised_land`, `appraised_improvement`) VALUES
(47, '087-0019-002', 'pt_code_65', 347792, 600894, 948686, 13633, 2016, NULL, NULL, NULL, NULL);
INSERT INTO `rw_property_tax_details` (`id`, `tax_account_id`, `property_code`, `assessed_land_value`, `assessed_improvement_value`, `total_assessment`, `tax_amount`, `tax_year`, `outstanding_tax`, `appraised_total`, `appraised_land`, `appraised_improvement`) VALUES
(48, '475-0158-012', 'pt_code_66', 224355, 114924, 339279, 12469, 2016, NULL, NULL, NULL, NULL);
INSERT INTO `rw_property_tax_details` (`id`, `tax_account_id`, `property_code`, `assessed_land_value`, `assessed_improvement_value`, `total_assessment`, `tax_amount`, `tax_year`, `outstanding_tax`, `appraised_total`, `appraised_land`, `appraised_improvement`) VALUES
(49, '483-0076-005-05', 'pt_code_67', 1146020, 238516, 1384536, 26408, 2016, NULL, NULL, NULL, NULL);
INSERT INTO `rw_property_tax_details` (`id`, `tax_account_id`, `property_code`, `assessed_land_value`, `assessed_improvement_value`, `total_assessment`, `tax_amount`, `tax_year`, `outstanding_tax`, `appraised_total`, `appraised_land`, `appraised_improvement`) VALUES
(50, '483-0040-001-06', 'pt_code_68', 12563, 331043, 343606, 7677, 2016, NULL, NULL, NULL, NULL);
INSERT INTO `rw_property_tax_details` (`id`, `tax_account_id`, `property_code`, `assessed_land_value`, `assessed_improvement_value`, `total_assessment`, `tax_amount`, `tax_year`, `outstanding_tax`, `appraised_total`, `appraised_land`, `appraised_improvement`) VALUES
(51, '483-0010-043', 'pt_code_69', 569552, 1219360, 1788912, 24760, 2016, NULL, NULL, NULL, NULL);
INSERT INTO `rw_property_tax_details` (`id`, `tax_account_id`, `property_code`, `assessed_land_value`, `assessed_improvement_value`, `total_assessment`, `tax_amount`, `tax_year`, `outstanding_tax`, `appraised_total`, `appraised_land`, `appraised_improvement`) VALUES
(52, '475-0141-002', 'pt_code_70', 2040000, 3162000, 5202000, 71838, 2016, NULL, NULL, NULL, NULL);
INSERT INTO `rw_property_tax_details` (`id`, `tax_account_id`, `property_code`, `assessed_land_value`, `assessed_improvement_value`, `total_assessment`, `tax_amount`, `tax_year`, `outstanding_tax`, `appraised_total`, `appraised_land`, `appraised_improvement`) VALUES
(53, '483-0010-041', 'pt_code_71', 621330, 424575, 1045905, 15472, 2016, NULL, NULL, NULL, NULL);
INSERT INTO `rw_property_tax_details` (`id`, `tax_account_id`, `property_code`, `assessed_land_value`, `assessed_improvement_value`, `total_assessment`, `tax_amount`, `tax_year`, `outstanding_tax`, `appraised_total`, `appraised_land`, `appraised_improvement`) VALUES
(54, '463-0060-045-02', 'pt_code_72', 625455, 1538863, 2164318, 56473, 2016, NULL, NULL, NULL, NULL);
INSERT INTO `rw_property_tax_details` (`id`, `tax_account_id`, `property_code`, `assessed_land_value`, `assessed_improvement_value`, `total_assessment`, `tax_amount`, `tax_year`, `outstanding_tax`, `appraised_total`, `appraised_land`, `appraised_improvement`) VALUES
(55, '486-0051-008', 'pt_code_73', 318718, 1142859, 1461577, 23040, 2016, NULL, NULL, NULL, NULL);
INSERT INTO `rw_property_tax_details` (`id`, `tax_account_id`, `property_code`, `assessed_land_value`, `assessed_improvement_value`, `total_assessment`, `tax_amount`, `tax_year`, `outstanding_tax`, `appraised_total`, `appraised_land`, `appraised_improvement`) VALUES
(56, '463-0060-037', 'pt_code_74', 2200000, 2340000, 4540000, 91088, 2016, NULL, NULL, NULL, NULL);
INSERT INTO `rw_property_tax_details` (`id`, `tax_account_id`, `property_code`, `assessed_land_value`, `assessed_improvement_value`, `total_assessment`, `tax_amount`, `tax_year`, `outstanding_tax`, `appraised_total`, `appraised_land`, `appraised_improvement`) VALUES
(57, '475-0100-038', 'pt_code_75', 1655350, 5098478, 6753828, 97609, 2016, NULL, NULL, NULL, NULL);
INSERT INTO `rw_property_tax_details` (`id`, `tax_account_id`, `property_code`, `assessed_land_value`, `assessed_improvement_value`, `total_assessment`, `tax_amount`, `tax_year`, `outstanding_tax`, `appraised_total`, `appraised_land`, `appraised_improvement`) VALUES
(58, '483-0010-043', 'pt_code_76', 569552, 1219360, 1788912, 24760, 2016, NULL, NULL, NULL, NULL);
INSERT INTO `rw_property_tax_details` (`id`, `tax_account_id`, `property_code`, `assessed_land_value`, `assessed_improvement_value`, `total_assessment`, `tax_amount`, `tax_year`, `outstanding_tax`, `appraised_total`, `appraised_land`, `appraised_improvement`) VALUES
(59, '463-0060-029', 'pt_code_78', 490008, 1301501, 1791509, 26506, 2016, NULL, NULL, NULL, NULL);
INSERT INTO `rw_property_tax_details` (`id`, `tax_account_id`, `property_code`, `assessed_land_value`, `assessed_improvement_value`, `total_assessment`, `tax_amount`, `tax_year`, `outstanding_tax`, `appraised_total`, `appraised_land`, `appraised_improvement`) VALUES
(60, '092A-0601-008-02', 'pt_code_79', 2276064, 2191633, 4467697, 190788, 2016, NULL, NULL, NULL, NULL);
INSERT INTO `rw_property_tax_details` (`id`, `tax_account_id`, `property_code`, `assessed_land_value`, `assessed_improvement_value`, `total_assessment`, `tax_amount`, `tax_year`, `outstanding_tax`, `appraised_total`, `appraised_land`, `appraised_improvement`) VALUES
(61, '092-0051-002-03', 'pt_code_80', 692616, 205987, 898603, 22465, 2016, NULL, NULL, NULL, NULL);
INSERT INTO `rw_property_tax_details` (`id`, `tax_account_id`, `property_code`, `assessed_land_value`, `assessed_improvement_value`, `total_assessment`, `tax_amount`, `tax_year`, `outstanding_tax`, `appraised_total`, `appraised_land`, `appraised_improvement`) VALUES
(62, '901-0197-007', 'pt_code_81', 463467, 341193, 804660, 11739, 2016, NULL, NULL, NULL, NULL);
INSERT INTO `rw_property_tax_details` (`id`, `tax_account_id`, `property_code`, `assessed_land_value`, `assessed_improvement_value`, `total_assessment`, `tax_amount`, `tax_year`, `outstanding_tax`, `appraised_total`, `appraised_land`, `appraised_improvement`) VALUES
(63, '092A-0933-025-03', 'pt_code_82', 753002, 288659, 1041661, 13268, 2016, NULL, NULL, NULL, NULL);
INSERT INTO `rw_property_tax_details` (`id`, `tax_account_id`, `property_code`, `assessed_land_value`, `assessed_improvement_value`, `total_assessment`, `tax_amount`, `tax_year`, `outstanding_tax`, `appraised_total`, `appraised_land`, `appraised_improvement`) VALUES
(64, '092-0032-011-02', 'pt_code_83', 243329, 942863, 1186192, 14447, 2016, NULL, NULL, NULL, NULL);
INSERT INTO `rw_property_tax_details` (`id`, `tax_account_id`, `property_code`, `assessed_land_value`, `assessed_improvement_value`, `total_assessment`, `tax_amount`, `tax_year`, `outstanding_tax`, `appraised_total`, `appraised_land`, `appraised_improvement`) VALUES
(65, '092A-0617-001-01', 'pt_code_84', 989049, 276681, 1265730, 16059, 2016, NULL, NULL, NULL, NULL);
INSERT INTO `rw_property_tax_details` (`id`, `tax_account_id`, `property_code`, `assessed_land_value`, `assessed_improvement_value`, `total_assessment`, `tax_amount`, `tax_year`, `outstanding_tax`, `appraised_total`, `appraised_land`, `appraised_improvement`) VALUES
(66, '092A-0919-022-02', 'pt_code_85', 33344, 43700, 77044, 1433, 2016, NULL, NULL, NULL, NULL);
INSERT INTO `rw_property_tax_details` (`id`, `tax_account_id`, `property_code`, `assessed_land_value`, `assessed_improvement_value`, `total_assessment`, `tax_amount`, `tax_year`, `outstanding_tax`, `appraised_total`, `appraised_land`, `appraised_improvement`) VALUES
(67, '092A-1036-030-02', 'pt_code_86', 640188, 700868, 1341056, 17112, 2016, NULL, NULL, NULL, NULL);
INSERT INTO `rw_property_tax_details` (`id`, `tax_account_id`, `property_code`, `assessed_land_value`, `assessed_improvement_value`, `total_assessment`, `tax_amount`, `tax_year`, `outstanding_tax`, `appraised_total`, `appraised_land`, `appraised_improvement`) VALUES
(68, '092A-0900-001-02', 'pt_code_87', 1004044, 967699, 1971743, 35639, 2016, NULL, NULL, NULL, NULL);
INSERT INTO `rw_property_tax_details` (`id`, `tax_account_id`, `property_code`, `assessed_land_value`, `assessed_improvement_value`, `total_assessment`, `tax_amount`, `tax_year`, `outstanding_tax`, `appraised_total`, `appraised_land`, `appraised_improvement`) VALUES
(69, '901-0111-015', 'pt_code_88', 1008191, 1833854, 2842045, 34664, 2016, NULL, NULL, NULL, NULL);
INSERT INTO `rw_property_tax_details` (`id`, `tax_account_id`, `property_code`, `assessed_land_value`, `assessed_improvement_value`, `total_assessment`, `tax_amount`, `tax_year`, `outstanding_tax`, `appraised_total`, `appraised_land`, `appraised_improvement`) VALUES
(70, '092A-0601-017', 'pt_code_89', 612925, 1884075, 2497000, 30363, 2016, NULL, NULL, NULL, NULL);
INSERT INTO `rw_property_tax_details` (`id`, `tax_account_id`, `property_code`, `assessed_land_value`, `assessed_improvement_value`, `total_assessment`, `tax_amount`, `tax_year`, `outstanding_tax`, `appraised_total`, `appraised_land`, `appraised_improvement`) VALUES
(71, '901-0111-015', 'pt_code_90', 1008191, 1833854, 2842045, 34664, 2016, NULL, NULL, NULL, NULL);
INSERT INTO `rw_property_tax_details` (`id`, `tax_account_id`, `property_code`, `assessed_land_value`, `assessed_improvement_value`, `total_assessment`, `tax_amount`, `tax_year`, `outstanding_tax`, `appraised_total`, `appraised_land`, `appraised_improvement`) VALUES
(72, '092A-0985-018', 'pt_code_91', 379746, 386553, 766299, 10682, 2016, NULL, NULL, NULL, NULL);
INSERT INTO `rw_property_tax_details` (`id`, `tax_account_id`, `property_code`, `assessed_land_value`, `assessed_improvement_value`, `total_assessment`, `tax_amount`, `tax_year`, `outstanding_tax`, `appraised_total`, `appraised_land`, `appraised_improvement`) VALUES
(73, '092A-2587-008-02', 'pt_code_92', 2386992, 1655845, 4042837, 85234, 2016, NULL, NULL, NULL, NULL);
INSERT INTO `rw_property_tax_details` (`id`, `tax_account_id`, `property_code`, `assessed_land_value`, `assessed_improvement_value`, `total_assessment`, `tax_amount`, `tax_year`, `outstanding_tax`, `appraised_total`, `appraised_land`, `appraised_improvement`) VALUES
(74, '092A-2010-011', 'pt_code_93', 53057, 442234, 495291, 7974, 2016, NULL, NULL, NULL, NULL);
INSERT INTO `rw_property_tax_details` (`id`, `tax_account_id`, `property_code`, `assessed_land_value`, `assessed_improvement_value`, `total_assessment`, `tax_amount`, `tax_year`, `outstanding_tax`, `appraised_total`, `appraised_land`, `appraised_improvement`) VALUES
(75, '092A-0601-008-02', 'pt_code_94', 2276064, 2191633, 4467697, 190788, 2016, NULL, NULL, NULL, NULL);
INSERT INTO `rw_property_tax_details` (`id`, `tax_account_id`, `property_code`, `assessed_land_value`, `assessed_improvement_value`, `total_assessment`, `tax_amount`, `tax_year`, `outstanding_tax`, `appraised_total`, `appraised_land`, `appraised_improvement`) VALUES
(76, '092A-0900-001-02', 'pt_code_95', 1004044, 967699, 1971743, 35639, 2016, NULL, NULL, NULL, NULL);
INSERT INTO `rw_property_tax_details` (`id`, `tax_account_id`, `property_code`, `assessed_land_value`, `assessed_improvement_value`, `total_assessment`, `tax_amount`, `tax_year`, `outstanding_tax`, `appraised_total`, `appraised_land`, `appraised_improvement`) VALUES
(77, '092A-0900-001-02', 'pt_code_97', 1004044, 967699, 1971743, 35639, 2016, NULL, NULL, NULL, NULL);
INSERT INTO `rw_property_tax_details` (`id`, `tax_account_id`, `property_code`, `assessed_land_value`, `assessed_improvement_value`, `total_assessment`, `tax_amount`, `tax_year`, `outstanding_tax`, `appraised_total`, `appraised_land`, `appraised_improvement`) VALUES
(78, '092A-0900-001-02', 'pt_code_98', 1004044, 967699, 1971743, 35639, 2016, NULL, NULL, NULL, NULL);
INSERT INTO `rw_property_tax_details` (`id`, `tax_account_id`, `property_code`, `assessed_land_value`, `assessed_improvement_value`, `total_assessment`, `tax_amount`, `tax_year`, `outstanding_tax`, `appraised_total`, `appraised_land`, `appraised_improvement`) VALUES
(79, '092A-1036-040', 'pt_code_99', 238243, 556211, 794454, 10116, 2016, NULL, NULL, NULL, NULL);
INSERT INTO `rw_property_tax_details` (`id`, `tax_account_id`, `property_code`, `assessed_land_value`, `assessed_improvement_value`, `total_assessment`, `tax_amount`, `tax_year`, `outstanding_tax`, `appraised_total`, `appraised_land`, `appraised_improvement`) VALUES
(80, '092A-0601-007', 'pt_code_100', 257837, 508270, 766107, 10569, 2016, NULL, NULL, NULL, NULL);
INSERT INTO `rw_property_tax_details` (`id`, `tax_account_id`, `property_code`, `assessed_land_value`, `assessed_improvement_value`, `total_assessment`, `tax_amount`, `tax_year`, `outstanding_tax`, `appraised_total`, `appraised_land`, `appraised_improvement`) VALUES
(81, '092A-0601-016', 'pt_code_101', 312290, 807460, 1119750, 14201, 2016, NULL, NULL, NULL, NULL);
INSERT INTO `rw_property_tax_details` (`id`, `tax_account_id`, `property_code`, `assessed_land_value`, `assessed_improvement_value`, `total_assessment`, `tax_amount`, `tax_year`, `outstanding_tax`, `appraised_total`, `appraised_land`, `appraised_improvement`) VALUES
(82, '901-0197-013', 'pt_code_102', 1114374, 3341376, 4455750, 55027, 2016, NULL, NULL, NULL, NULL);
INSERT INTO `rw_property_tax_details` (`id`, `tax_account_id`, `property_code`, `assessed_land_value`, `assessed_improvement_value`, `total_assessment`, `tax_amount`, `tax_year`, `outstanding_tax`, `appraised_total`, `appraised_land`, `appraised_improvement`) VALUES
(83, '092A-2010-007', 'pt_code_103', 271124, 1779778, 2050902, 26986, 2016, NULL, NULL, NULL, NULL);
INSERT INTO `rw_property_tax_details` (`id`, `tax_account_id`, `property_code`, `assessed_land_value`, `assessed_improvement_value`, `total_assessment`, `tax_amount`, `tax_year`, `outstanding_tax`, `appraised_total`, `appraised_land`, `appraised_improvement`) VALUES
(84, '092-0116-079', 'pt_code_104', 82629, 431167, 513796, 6767, 2016, NULL, NULL, NULL, NULL);
INSERT INTO `rw_property_tax_details` (`id`, `tax_account_id`, `property_code`, `assessed_land_value`, `assessed_improvement_value`, `total_assessment`, `tax_amount`, `tax_year`, `outstanding_tax`, `appraised_total`, `appraised_land`, `appraised_improvement`) VALUES
(85, '092-0045-003', 'pt_code_105', 150521, 279539, 430060, 6445, 2016, NULL, NULL, NULL, NULL);
INSERT INTO `rw_property_tax_details` (`id`, `tax_account_id`, `property_code`, `assessed_land_value`, `assessed_improvement_value`, `total_assessment`, `tax_amount`, `tax_year`, `outstanding_tax`, `appraised_total`, `appraised_land`, `appraised_improvement`) VALUES
(86, '901-0111-024', 'pt_code_106', 2396491, 15673044, 18069535, 215985, 2016, NULL, NULL, NULL, NULL);
INSERT INTO `rw_property_tax_details` (`id`, `tax_account_id`, `property_code`, `assessed_land_value`, `assessed_improvement_value`, `total_assessment`, `tax_amount`, `tax_year`, `outstanding_tax`, `appraised_total`, `appraised_land`, `appraised_improvement`) VALUES
(87, '092A-0900-001-02', 'pt_code_107', 1004044, 967699, 1971743, 35639, 2016, NULL, NULL, NULL, NULL);
INSERT INTO `rw_property_tax_details` (`id`, `tax_account_id`, `property_code`, `assessed_land_value`, `assessed_improvement_value`, `total_assessment`, `tax_amount`, `tax_year`, `outstanding_tax`, `appraised_total`, `appraised_land`, `appraised_improvement`) VALUES
(88, '486-0030-058-02', 'pt_code_108', 159256, 33841, 193097, 3919, 2016, NULL, NULL, NULL, NULL);
INSERT INTO `rw_property_tax_details` (`id`, `tax_account_id`, `property_code`, `assessed_land_value`, `assessed_improvement_value`, `total_assessment`, `tax_amount`, `tax_year`, `outstanding_tax`, `appraised_total`, `appraised_land`, `appraised_improvement`) VALUES
(89, '463-0060-032', 'pt_code_109', 1557936, 2405667, 3963603, 71339, 2016, NULL, NULL, NULL, NULL);
INSERT INTO `rw_property_tax_details` (`id`, `tax_account_id`, `property_code`, `assessed_land_value`, `assessed_improvement_value`, `total_assessment`, `tax_amount`, `tax_year`, `outstanding_tax`, `appraised_total`, `appraised_land`, `appraised_improvement`) VALUES
(90, '475-0080-012-02', 'pt_code_110', 1584436, 2942524, 4526960, 60234, 2016, NULL, NULL, NULL, NULL);
INSERT INTO `rw_property_tax_details` (`id`, `tax_account_id`, `property_code`, `assessed_land_value`, `assessed_improvement_value`, `total_assessment`, `tax_amount`, `tax_year`, `outstanding_tax`, `appraised_total`, `appraised_land`, `appraised_improvement`) VALUES
(91, '463-0045-045-02', 'pt_code_111', 4822381, 11837411, 16659792, 241638, 2016, NULL, NULL, NULL, NULL);
INSERT INTO `rw_property_tax_details` (`id`, `tax_account_id`, `property_code`, `assessed_land_value`, `assessed_improvement_value`, `total_assessment`, `tax_amount`, `tax_year`, `outstanding_tax`, `appraised_total`, `appraised_land`, `appraised_improvement`) VALUES
(92, '486-0051-013', 'pt_code_112', 766616, 2070427, 2837043, 70794, 2016, NULL, NULL, NULL, NULL);
INSERT INTO `rw_property_tax_details` (`id`, `tax_account_id`, `property_code`, `assessed_land_value`, `assessed_improvement_value`, `total_assessment`, `tax_amount`, `tax_year`, `outstanding_tax`, `appraised_total`, `appraised_land`, `appraised_improvement`) VALUES
(93, '486-0099-007-05', 'pt_code_113', 889744, 435516, 1325260, 25347, 2016, NULL, NULL, NULL, NULL);
INSERT INTO `rw_property_tax_details` (`id`, `tax_account_id`, `property_code`, `assessed_land_value`, `assessed_improvement_value`, `total_assessment`, `tax_amount`, `tax_year`, `outstanding_tax`, `appraised_total`, `appraised_land`, `appraised_improvement`) VALUES
(94, '463-0060-022-05', 'pt_code_114', 5719990, 8854027, 14574017, 257084, 2016, NULL, NULL, NULL, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `rw_property_user_mapping`
--

CREATE TABLE `rw_property_user_mapping` (
  `id` int(11) NOT NULL,
  `property_id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `rw_property_user_mapping`
--

INSERT INTO `rw_property_user_mapping` (`id`, `property_id`, `user_id`) VALUES
(1, 6, 1),
(2, 7, 2);
INSERT INTO `rw_property_user_mapping` (`id`, `property_id`, `user_id`) VALUES
(3, 8, 2),
(4, 9, 2);
INSERT INTO `rw_property_user_mapping` (`id`, `property_id`, `user_id`) VALUES
(5, 10, 2),
(6, 12, 2);
INSERT INTO `rw_property_user_mapping` (`id`, `property_id`, `user_id`) VALUES
(7, 13, 2),
(8, 16, 2);
INSERT INTO `rw_property_user_mapping` (`id`, `property_id`, `user_id`) VALUES
(9, 17, 2),
(10, 18, 2);
INSERT INTO `rw_property_user_mapping` (`id`, `property_id`, `user_id`) VALUES
(11, 19, 2);
INSERT INTO `rw_property_user_mapping` (`id`, `property_id`, `user_id`) VALUES
(12, 20, 2);
INSERT INTO `rw_property_user_mapping` (`id`, `property_id`, `user_id`) VALUES
(13, 116, 4);
INSERT INTO `rw_property_user_mapping` (`id`, `property_id`, `user_id`) VALUES
(14, 117, 4);

-- --------------------------------------------------------

--
-- Table structure for table `rw_restaurant`
--

CREATE TABLE `rw_restaurant` (
  `id` int(10) NOT NULL,
  `type` varchar(40) NOT NULL,
  `description` varchar(50) NOT NULL,
  `indoor_seating_capacity` varchar(40) DEFAULT NULL,
  `outdoor_seating_capacity` varchar(50) DEFAULT NULL,
  `kitchen_hood_size` varchar(50) DEFAULT NULL,
  `kitchen_sqft` varchar(50) DEFAULT NULL,
  `available_appliances` varchar(50) DEFAULT NULL,
  `dish_washer` varchar(50) DEFAULT NULL,
  `oven` varchar(40) DEFAULT NULL,
  `cooking_range` varchar(100) DEFAULT NULL,
  `fryers` varchar(50) DEFAULT NULL,
  `total_cost_utensils` varchar(50) DEFAULT NULL,
  `interior_sqft` varchar(50) DEFAULT NULL,
  `interior_seating_arrangement` varchar(50) DEFAULT NULL,
  `interior_cost` varchar(50) DEFAULT NULL,
  `interior_features` varchar(50) DEFAULT NULL,
  `interior_electronics` varchar(50) DEFAULT NULL,
  `interior_restrooms` varchar(50) DEFAULT NULL,
  `interior_restrooms_ADA` varchar(50) DEFAULT NULL,
  `bar_type` varchar(50) DEFAULT NULL,
  `bar_seating_capacity` varchar(50) DEFAULT NULL,
  `last_renovation_date` date DEFAULT NULL,
  `conidtion` varchar(50) DEFAULT NULL,
  `waiting_area` varchar(50) DEFAULT NULL,
  `dry_storage` varchar(50) DEFAULT NULL,
  `exterior_type` varchar(50) DEFAULT NULL,
  `parking` varchar(50) DEFAULT NULL,
  `security` varchar(50) DEFAULT NULL,
  `surrounding_business` varchar(50) DEFAULT NULL,
  `monthly_rent` varchar(50) DEFAULT NULL,
  `nnn_expense` varchar(50) DEFAULT NULL,
  `garbage_expense` varchar(50) DEFAULT NULL,
  `utilities_expense` varchar(50) DEFAULT NULL,
  `residential_area` varchar(50) DEFAULT NULL,
  `wiki_demo_link` varchar(50) DEFAULT NULL,
  `walkscore` varchar(50) DEFAULT NULL,
  `avg_age` varchar(50) DEFAULT NULL,
  `avg_income` varchar(50) DEFAULT NULL,
  `crime_indicator` varchar(50) DEFAULT NULL,
  `avg_revenue_in_resto` varchar(50) DEFAULT NULL,
  `avg_revenue_to_go` varchar(50) DEFAULT NULL,
  `avg_revenue_catering` varchar(50) DEFAULT NULL,
  `avg_revenue_liquer` varchar(50) DEFAULT NULL,
  `total_emp` varchar(50) DEFAULT NULL,
  `certified_emp` varchar(50) DEFAULT NULL,
  `fulltime_emp` varchar(50) DEFAULT NULL,
  `parttiem_emp` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `rw_restaurant`
--

INSERT INTO `rw_restaurant` (`id`, `type`, `description`, `indoor_seating_capacity`, `outdoor_seating_capacity`, `kitchen_hood_size`, `kitchen_sqft`, `available_appliances`, `dish_washer`, `oven`, `cooking_range`, `fryers`, `total_cost_utensils`, `interior_sqft`, `interior_seating_arrangement`, `interior_cost`, `interior_features`, `interior_electronics`, `interior_restrooms`, `interior_restrooms_ADA`, `bar_type`, `bar_seating_capacity`, `last_renovation_date`, `conidtion`, `waiting_area`, `dry_storage`, `exterior_type`, `parking`, `security`, `surrounding_business`, `monthly_rent`, `nnn_expense`, `garbage_expense`, `utilities_expense`, `residential_area`, `wiki_demo_link`, `walkscore`, `avg_age`, `avg_income`, `crime_indicator`, `avg_revenue_in_resto`, `avg_revenue_to_go`, `avg_revenue_catering`, `avg_revenue_liquer`, `total_emp`, `certified_emp`, `fulltime_emp`, `parttiem_emp`) VALUES
(1, 'Asian', 'All foods', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `rw_user_profile`
--

CREATE TABLE `rw_user_profile` (
  `id` int(11) NOT NULL,
  `first_name` varchar(50) NOT NULL,
  `last_name` varchar(50) DEFAULT NULL,
  `email_id` varchar(50) DEFAULT NULL,
  `contact_number` varchar(50) DEFAULT NULL,
  `about_agent` varchar(100) DEFAULT NULL,
  `agent_title` varchar(50) DEFAULT NULL,
  `location` varchar(100) DEFAULT NULL,
  `address` varchar(50) DEFAULT NULL,
  `city` varchar(50) DEFAULT NULL,
  `state` varchar(50) DEFAULT NULL,
  `country` varchar(50) DEFAULT NULL,
  `zipcode` int(11) DEFAULT NULL,
  `user_img_url` varchar(1000) DEFAULT NULL,
  `user_type` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `rw_user_profile`
--

INSERT INTO `rw_user_profile` (`id`, `first_name`, `last_name`, `email_id`, `contact_number`, `about_agent`, `agent_title`, `location`, `address`, `city`, `state`, `country`, `zipcode`, `user_img_url`, `user_type`) VALUES
(1, 'Abhijeet', 'darade', 'abhijeet darade', '', '', '', '', '', '', '', '', 0, '', '');
INSERT INTO `rw_user_profile` (`id`, `first_name`, `last_name`, `email_id`, `contact_number`, `about_agent`, `agent_title`, `location`, `address`, `city`, `state`, `country`, `zipcode`, `user_img_url`, `user_type`) VALUES
(2, 'Abhijeet', 'Darade', 'abhijit.darade@gmail.com', '', '', '', '', '', '', '', '', 0, '', '');
INSERT INTO `rw_user_profile` (`id`, `first_name`, `last_name`, `email_id`, `contact_number`, `about_agent`, `agent_title`, `location`, `address`, `city`, `state`, `country`, `zipcode`, `user_img_url`, `user_type`) VALUES
(3, 'Pooja', 'Darade', 'poojadarade25@gmail.com', '', '', '', '', '', '', '', '', 0, '', '');
INSERT INTO `rw_user_profile` (`id`, `first_name`, `last_name`, `email_id`, `contact_number`, `about_agent`, `agent_title`, `location`, `address`, `city`, `state`, `country`, `zipcode`, `user_img_url`, `user_type`) VALUES
(4, 'Anisha', 'Jain', 'jainanisha90@gmail.com', '222-222-2222', 'Working on it', 'Business Agent', '2140 Peralta Blvd, Fremont, CA', '2140 Peralta Blvd', 'Fremont', 'CA', 'US', 94536, 'https://lh6.googleusercontent.com/-8IhVtO-Nejs/AAAAAAAAAAI/AAAAAAAAAQk/Mjq3hsUL-I0/photo.jpg', 'Agent');
INSERT INTO `rw_user_profile` (`id`, `first_name`, `last_name`, `email_id`, `contact_number`, `about_agent`, `agent_title`, `location`, `address`, `city`, `state`, `country`, `zipcode`, `user_img_url`, `user_type`) VALUES
(5, 'test', 'test', 'test56789.test56789@gmail.com', '222-222-1111', 'Testing', 'Business Agent', '2140 Peralta Blvd, Fremont, CA', '2140 Peralta Blvd', 'Fremont', 'CA', 'US', 94536, 'https://lh4.googleusercontent.com/-CmLNa9saffw/AAAAAAAAAAI/AAAAAAAAAAA/ABtNlbBQ5tEKmyZFYSyYBg3gwWb8tAFAhg/mo/photo.jpg', 'Agent');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `rw_business_definition`
--
ALTER TABLE `rw_business_definition`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `rw_business_details`
--
ALTER TABLE `rw_business_details`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `rw_business_valuation`
--
ALTER TABLE `rw_business_valuation`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `rw_buy_business_requirements`
--
ALTER TABLE `rw_buy_business_requirements`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `rw_coin_laundry`
--
ALTER TABLE `rw_coin_laundry`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `rw_cre_units`
--
ALTER TABLE `rw_cre_units`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `rw_cre_valuation`
--
ALTER TABLE `rw_cre_valuation`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `rw_customer_definition`
--
ALTER TABLE `rw_customer_definition`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `rw_gas_station`
--
ALTER TABLE `rw_gas_station`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `rw_property_definition`
--
ALTER TABLE `rw_property_definition`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `rw_property_details`
--
ALTER TABLE `rw_property_details`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `rw_property_images`
--
ALTER TABLE `rw_property_images`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `rw_property_tax_details`
--
ALTER TABLE `rw_property_tax_details`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `rw_property_user_mapping`
--
ALTER TABLE `rw_property_user_mapping`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `rw_restaurant`
--
ALTER TABLE `rw_restaurant`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `rw_user_profile`
--
ALTER TABLE `rw_user_profile`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `rw_business_definition`
--
ALTER TABLE `rw_business_definition`
  MODIFY `id` int(15) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT for table `rw_business_details`
--
ALTER TABLE `rw_business_details`
  MODIFY `id` int(15) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `rw_business_valuation`
--
ALTER TABLE `rw_business_valuation`
  MODIFY `id` int(15) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `rw_buy_business_requirements`
--
ALTER TABLE `rw_buy_business_requirements`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `rw_coin_laundry`
--
ALTER TABLE `rw_coin_laundry`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `rw_cre_units`
--
ALTER TABLE `rw_cre_units`
  MODIFY `id` int(15) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `rw_cre_valuation`
--
ALTER TABLE `rw_cre_valuation`
  MODIFY `id` int(15) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `rw_customer_definition`
--
ALTER TABLE `rw_customer_definition`
  MODIFY `id` int(15) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `rw_gas_station`
--
ALTER TABLE `rw_gas_station`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `rw_property_definition`
--
ALTER TABLE `rw_property_definition`
  MODIFY `id` int(15) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `rw_property_details`
--
ALTER TABLE `rw_property_details`
  MODIFY `id` int(15) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=118;

--
-- AUTO_INCREMENT for table `rw_property_images`
--
ALTER TABLE `rw_property_images`
  MODIFY `id` int(15) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=754;

--
-- AUTO_INCREMENT for table `rw_property_tax_details`
--
ALTER TABLE `rw_property_tax_details`
  MODIFY `id` int(15) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=95;

--
-- AUTO_INCREMENT for table `rw_property_user_mapping`
--
ALTER TABLE `rw_property_user_mapping`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;

--
-- AUTO_INCREMENT for table `rw_restaurant`
--
ALTER TABLE `rw_restaurant`
  MODIFY `id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `rw_user_profile`
--
ALTER TABLE `rw_user_profile`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- Constraints for dumped tables
--


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

ALTER TABLE `rw_property_details` CHANGE `property_available_for` `property_available_for` VARCHAR(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL;
ALTER TABLE `rw_property_details` CHANGE `property_code` `property_code` VARCHAR(15) CHARACTER SET utf8 COLLATE utf8_general_ci NULL;

