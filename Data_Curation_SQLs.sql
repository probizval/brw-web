-- ***********************************************************
-- 1. Data Curation Scripts start here
-- 2. Open Terminal on MAC
-- 3. Goto - cd /usr/local/mysql-shell/bin/
-- 4. run command - mysqlsh
-- 5. rum command - \connect brw_app_dev@brwdev.cx4tgyitha5s.us-east-1.rds.amazonaws.com/brwdev PWD - HDYnCWRnjn8qxTA81y3iNAikCeCJ
-- 6. Enter password if it asks
-- 7. Switch to SQL mode by command - \sql
-- 8. Execute SQLs by ending them with ;

-- Create User on MySql and grant permissions to particular table
select * from mysql.user;

-- delete from mysql.user where user = 'brw_app_dev'

USER/PWD - read_only/brw_2020
USER/PWD - brw_app_dev/HDYnCWRnjn8qxTA81y3iNAikCeCJ

CREATE USER 'brw_app_dev'@'%' IDENTIFIED BY 'HDYnCWRnjn8qxTA81y3iNAikCeCJ';
GRANT SELECT ON *.* TO 'brw_app_dev'@'%';
GRANT INSERT ON *.* TO 'brw_app_dev'@'%';
GRANT DELETE ON *.* TO 'brw_app_dev'@'%';
-- GRANT CREATE ON *.* TO 'brw_app_dev'@'brwdev.cx4tgyitha5s.us-east-1.rds.amazonaws.com';
GRANT UPDATE ON *.* TO 'brw_app_dev'@'%';
-- GRANT ALTER ON *.* TO 'brw_app_dev'@'brwdev.cx4tgyitha5s.us-east-1.rds.amazonaws.com';

revoke create ON *.* from 'read_only'@'brwdev.cx4tgyitha5s.us-east-1.rds.amazonaws.com';
revoke alter ON *.* from 'read_only'@'brwdev.cx4tgyitha5s.us-east-1.rds.amazonaws.com';
revoke insert ON *.* from 'read_only'@'brwdev.cx4tgyitha5s.us-east-1.rds.amazonaws.com';
revoke DELETE ON *.* from 'read_only'@'brwdev.cx4tgyitha5s.us-east-1.rds.amazonaws.com';
revoke UPDATE ON *.* from 'read_only'@'brwdev.cx4tgyitha5s.us-east-1.rds.amazonaws.com';

FLUSH PRIVILEGES;

SELECT file_priv FROM mysql.user WHERE user='admin';

UPDATE mysql.user
SET file_priv='Y'
WHERE user='admin';



select * from t_brw_business where biz_id = 10010331;

update t_brw_business 
set updatedby_user_id = 9999
where
updatedby_user_id = 999;

select count(*) from t_brw_business where updatedby_user_id = 999;

SELECT max(biz_id) FROM brwdev.t_brw_business;

SELECT count(*) FROM brwdev.t_brw_business;

SELECT count(biz_id) FROM brwdev.t_brw_business where add_state = 'WY';

select distinct sic_description, sic_code 
INTO OUTFILE '/Users/sidpatil/Work/z_data/sic_desc_code.csv' 
from t_brw_business 
where add_state = 'CA' 
order by sic_description asc;

select distinct add_state from t_brw_business
-- where biz_id < 6000

-- To list all DB process
SHOW FULL PROCESSLIST;

-- To kill the DB process
CALL mysql.rds_kill()

-- call Delete SP
-- call brwdev.delete_duplicate_business();

-- SQL to find the duplicates 1
select name_dba, add_street1, add_city, add_state, count(*) cnt  
from t_brw_business  
where 
-- add_city = 'Fremont' and
add_state = 'CA' 
group by name_dba, add_street1, add_city, add_state  
having cnt > 1 
order by cnt desc 
limit 12;

select * from t_brw_business 
where name_dba = 'SYNNEX Corporation'
and add_street1 = '6607 KAISER DR'
and add_city = 'FREMONT'
and add_state = 'CA';
-- 302

select name_dba, add_street1, add_city, add_state, count(*) cnt 
from t_brw_business 
where add_state = 'CA'
and add_city = 'Fremont'
group by name_dba, add_street1, add_city, add_state 
having cnt > 1
order by cnt desc 
limit 10;

select name_dba, add_street1, add_city, add_state, count(*) cnt 
	from t_brw_business 
	where add_state = 'CA'
	group by name_dba, add_street1, add_city, add_state 
	having cnt > 1
	order by cnt desc 
	limit 1000;

-- SQL to find the duplicates 2
select t1 from contacts t1
inner join contacts 2
where
	t.biz_id 
    
    select count(*) from t_brw_business b1
	where 
	b1.biz_id in (select b2.biz_id 
		from t_brw_business b2
		where b2.name_dba = 'PLAYBOY ENTERPRISES INC'
		and b2.add_street1 = '10236 CHARING CROSS RD'
		and b2.add_city = 'LOS ANGELES'
		and b2.add_state = 'CA'
        and b2.updatedby_user_id != 9999);


-- create index for better performance
-- CREATE INDEX idx_brw_primary_key
-- ON t_brw_business (name_dba, add_street1, add_city, add_state);

-- To list all DB process
SHOW FULL PROCESSLIST;

-- To kill the DB process
CALL mysql.rds_kill(46);

-- Delete SQL to delete duplicates for a particular business based on its 
-- name and address
-- update t_brw_business b1
set b1.updatedby_user_id = 9999
where 
b1.biz_id = (select b2.biz_id 
	from t_brw_business b2
	where 
	b2.biz_id in (select b3.biz_id 
		from t_brw_business b3
		where b3.name_dba = 'Chaffey College'
		and b3.add_street1 = '5885 Haven Ave'
		and b3.add_city = 'Rancho Cucamonga'
		and b3.add_state = 'CA')
	and b2.sales_range is not null
	and b2.employee_range is not null
	-- and b2.biz_contact_title = 'owner' 
	limit 1);

-- DELETE SQL to delete the record where updatedby_user_id IS NOT 9999
-- delete from t_brw_business 
select count(*) from t_brw_business 
	where 
	biz_id in (select biz_id 
		from t_brw_business 
		where name_dba = 'PLAYBOY ENTERPRISES INC'
		and add_street1 = '10236 CHARING CROSS RD'
		and add_city = 'LOS ANGELES'
		and add_state = 'CA'
        and updatedby_user_id != 9999);



select count(biz_id) 
		from t_brw_business 
		where name_dba = 'PLAYBOY ENTERPRISES INC'
		and add_street1 = '10236 CHARING CROSS RD'
		and add_city = 'LOS ANGELES'
		and add_state = 'CA';
        
        
-- ******************************************************
-- *** Data Curation Rules and steps sequence ***
-- 1. Delete Duplicates - Keep the record that has most columns, especially with 
-- revenue range, employee range, specific SIC description, contact title as owner 
-- and contact details.
--
-- 2. Based on SIC description decide the Biz Type - update type, sub type 
-- and naics attributes
--
-- 3. Based on Biz Type, revenue range, area decide range of market based estimates
--
-- 4. Based on Biz Type and location (state and/or city) decide values of other attributes but randomize while 
-- setting them up, so they don't look similar for all business


-- 1. SQLs to Find and Delete Duplicates - Keep the record that has most columns, especially with 
-- revenue range, employee range, specific SIC description, contact title as owner 
-- and contact details.
--

-- If the count is more than 1 for any row thats the duplicate
select name_dba, add_street1, add_city, add_state, count(*) cnt 
from t_brw_business 
where add_state = 'CA' 
and add_city = 'Fremont' 
group by name_dba, add_street1, add_city, add_state 
having cnt > 1 
order by cnt desc 
limit 10;


-- Delete Duplicates - This has to be a SP
-- Sudo Code
-- Select duplicates name and address 
-- select miltiple biz_ids based on above name and address
-- select one single biz_id that has all necessary attributes filled in (revenue, employee etc)
-- keep that selected biz_id row active while in-actibe rest all rows
-- if all rows has same data just pick random one row
-- change all selects to always return just the active rows

-- call delete_duplicate_business;

1.1 FUNDAMENTAL UPDATES AND CLEAN UPS *********************


select count(*) from t_brw_business where sic_code is null and sic_description is null; -- result: 21
select count(*) from t_brw_business where sic_code = '' and sic_description = ''; -- result: 295410!!
-- If sic code and sic descriptions is empty then update it with 0000 and miscellaneous respectively
update t_brw_business
set sic_code = '0000',
set sic_description = 'Miscellaneous'
where
name_dba is null and name_legal is null or 
name_dba = '' and name_legal = '';

select count(*) from t_brw_business where name_dba is null and name_legal is null;
select count(*) from t_brw_business where name_dba = '' and name_legal = '';
-- If the name is null or empty update it with business type
update t_brw_business
set name_dba = 'sic_description',
set name_legal = 'sic_description'
where
name_dba is null and name_legal is null or 
name_dba = '' and name_legal = '';


-- 2. Based on SIC description decide the Biz Type - update type, sub type 
-- and naics attributes

2.1. Search based on known keywords
-- SEARCH KEYWORDS - food, restaurant, eat

select distinct sic_code, sic_description 
from t_brw_business 
where 
add_state = 'CA' and 
(sic_description like '%food%'or
sic_description like '%restaurant%' or
sic_description like 'eat%')
order by sic_code asc;

2.2. Based on above response pick up sic_code that are relevant.
Validate the SIC_CODEs with referance SQLs down below.


2.3. Update the business with below SQL keep adding sic_code to the where clause
-- SEARCH KEYWORDS - food, restaurant, eating
update t_brw_business 
set type = 'BTYPE_REST_FOOD', 
sub_type = 'BTYPE_REST_FOOD'
where 
add_state = 'CA' and 
(sic_description like '%food%'or 
sic_description like '%restaurant%' or 
sic_description like 'eat%' or
sic_description like '%cafe%' or
sic_description like '%bar%' or
sic_description like '%club%');

sic_description like '%cafe%' or sic_description like '%bar%' or sic_description like '%club%'

Referance SQLs -
select  distinct sic_code, sic_description 
from t_brw_business  
where add_state = 'CA'  and 
sic_code like '58%';

select name_dba, sic_code, sic_description 
from t_brw_business  
where add_state = 'CA'  and 
sic_code like '58%' and 
sic_description = 'SIC Not Defined';

2.4 Long Term Solution
-- Come up with table that maps Distinct SIC_CODE to BRW_RO_BIZ_TYPES
-- Then on every time new business is getting added look at the mapping and put it


-- 3. Based on Biz Type, revenue range, county decide range of market based estimates
-- update t_brw_business

select distinct sales_range, count(*) cnt 
from t_brw_business 
where add_state = 'CA'
group by sales_range
order by cnt asc;

select distinct employee_range, count(*) cnt 
from t_brw_business 
where add_state = 'CA'
group by employee_range
order by cnt asc;

set market_based_est = revenue/5
where type = 'BTYPE_REST_FOOD'
and add_county = 'ALAMEDA'
and add_state = 'CA';

-- To create a random integer number between two values (range), you can use the following formula: SELECT FLOOR(RAND()*(b-a+1))+a; Where a is the smallest number and b is the largest number that you want to generate a random number for.
-- Return a random number >= 5 and <=10:
SELECT FLOOR(RAND()*(100000-50000+1)+50000);


-- 4. Based on Business Type update image_first - no icon or vector but actual image
-- update t_brw_business
set image_first = 's3//link_for_brw_aws_location_for_generic_restaurant_image.JPG'
where type = 'BTYPE_REST_FOOD'
and add_state = 'CA';


-- 5. Based on Biz Type and location (state, county and/or city) decide values of 
-- other attributes but randomize while setting them up, so they don't look similar 
-- for all business.
-- update t_brw_business
set description = 'Come up with about 20 lines and 3 paragraphs for each biz type - refer to current listings and make generic description',
naics_num = 'come up based on SIC code mapping and biz type',
naics_description = 'same as above',
sqft_indoor = 'randomized average value for this attribute based on type of business',
sqft_outdoor = 'randomized average value for this attribute based on type of business',
sqft_lot = 'randomized average value for this attribute based on type of business',
bldg_type = 'randomized average value for this attribute based on type of business',
rev_monthly = 'randomized,  refer sales range column or randomized average value for this attribute based on type of business',
exp_monthly_rent = 'randomized average value for this attribute based on type of business',
exp_monthly_material = ' % of revenue or randomized average value for this attribute based on type of business',
exp_monthly_emp = 'randomized average value for this attribute based on type of business',
exp_monthly_utility = 'randomized average value for this attribute based on type of business',
value_total_equipment = 'randomized average value for this attribute based on type of business',
value_total_furniture = 'randomized, if applicable for the type of business or randomized average value for this attribute based on type of business',
emp_FT_num = 'randomized, based on range_employee column or randomized average value for this attribute based on type of business',
area_crime_score = 'randomized, based on nelson report or based on county/city',
area_walk_score = 'randomized, if applicable for type of business - based on walk score website or city',
area_transit_score = 'randomized, if applicable for type of business - based on walk score website or city',
social_media_score = 'randomized, if applicable for type of business - from yelp or google',
area_attractions_score = 'randomized, if applicable to type of business',
1mile_rad_popln = 'randomized, if applicable to type of business - based on neilson report',
1mile_rad_incoscore = 'randomized, if applicable to type of business - based on neilson report',
3mile_rad_popln = 'randomized, if applicable to type of business - based on neilson report',
3mile_rad_incoscore = 'randomized, if applicable to type of business - based on neilson report',
5mile_rad_popln = 'randomized, if applicable to type of business - based on neilson report',
5mile_rad_incoscore = 'randomized, if applicable to type of business - based on neilson report',
dailypeople_doorfront_num = 'randomized, if applicable to type of business - based on neilson report',
dailycar_parklot_num = 'randomized, if applicable to type of business - based on neilson report'
where type = 'BTYPE_REST_FOOD'
and add_county = 'ALAMEDA'
and add_state = 'CA';


-- 6. update other images for business also same as #4 above - write a SP or function
for every biz_id from t_brw_business where biz_id > 10000000 and type = 'BTYPE_REST_FOOD' 
and state = 'CA'{
insert into t_brw_business_image (biz_id, image_URL)
values ('biz_id', 's3//link_for_brw_aws_location_for_generic_restaurant_image.JPG');
}


-- 7. Select ditinct combinations of sic_description and sic_code from business table and insert into sic
-- biz type mapping table

INSERT INTO t_brw_sic_biztype_mapping (sic_description, sic_code) 
select distinct sic_description, sic_code 
from t_brw_business 
where add_state = 'CA'
order by sic_description asc;

select count(*) from t_brw_sic_biztype_mapping

select * from t_brw_sic_biztype_mapping

delete from t_brw_sic_biztype_mapping

-- 8. Insert data in to state county city table
select * from t_brw_state_county_cities

-- ******** DONE WITH DATA CURATION!! :) :) *************************************************
