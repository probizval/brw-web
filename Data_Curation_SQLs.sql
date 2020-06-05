-- ***********************************************************
-- 1. Data Curation Scripts start here
-- 2. Open Terminal on MAC
-- 3. Goto - cd /usr/local/mysql-shell/bin/
-- 4. run command - mysqlsh
-- 5. rum command - \connect admin@brwdev.cx4tgyitha5s.us-east-1.rds.amazonaws.com/brwdev
-- 6. Enter password if it asks
-- 7. Switch to SQL mode by command - \sql
-- 8. Execute SQLs by ending them with ;

SELECT max(biz_id) FROM brwdev.t_brw_business;

SELECT count(*) FROM brwdev.t_brw_business;
-- where biz_id < 6000

-- create index for better performance
CREATE INDEX idx_brw_primary_key
ON t_brw_business (name_dba, add_street1, add_city, add_state);

-- To list all DB process
SHOW FULL PROCESSLIST;

-- To kill the DB process
CALL mysql.rds_kill(7);

-- Delete SQL to delete duplicates for a particular business based on its 
-- name and address
update t_brw_business 
set updatedby_user_id = 9999
where 
biz_id = (select biz_id 
	from t_brw_business 
	where 
	biz_id in (select biz_id 
		from t_brw_business 
		where name_dba = 'PLAYBOY ENTERPRISES INC'
		and add_street1 = '10236 CHARING CROSS RD'
		and add_city = 'LOS ANGELES'
		and add_state = 'CA')
	and sales_range is not null
	and employee_range is not null
	-- and biz_contact_title = 'owner' 
	limit 1);update_image_first

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
-- #1 find duplicates - not si effective SQL
select a.name_dba, a.add_street1, a.biz_id 
from t_brw_business a, t_brw_business b 
where a.biz_id != b.biz_id 
and a.name_dba = b.name_dba 
and a.add_street1 = b.add_street1 
and a.add_city = b.add_city 
and a.add_state = 'CA' 
and b.add_state = 'CA' 
order by a.name_dba;

-- #2 If the count is more than 1 for any row thats the duplicate
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

exec delete_duplicate_business;


-- 2. Based on SIC description decide the Biz Type - update type, sub type 
-- and naics attributes

-- select distinct SIC description to decide the business type and update type and subtype
select distinct sic_description, sic_code
from t_brw_business
where state = 'CA' order by sic_description asc;

update t_brw_business 
set type = 'BTYPE_REST_FOOD', 
sub_type = 'BTYPE_REST_FOOD'
where 
sic_description like 'restaurant'
or sic_description like 'food'
or sic_code in (712345, 2345);


-- 3. Based on Biz Type, revenue range, county decide range of market based estimates
update t_brw_business
set market_based_est = revenue/5
where type = 'BTYPE_REST_FOOD'
and add_county = 'ALAMEDA'
and add_state = 'CA';


-- 4. Based on Business Type update image_first - no icon or vector but actual image
update t_brw_business
set image_first = 's3//link_for_brw_aws_location_for_generic_restaurant_image.JPG'
where type = 'BTYPE_REST_FOOD'
and add_state = 'CA';


-- 5. Based on Biz Type and location (state, county and/or city) decide values of 
-- other attributes but randomize while setting them up, so they don't look similar 
-- for all business.
update t_brw_business
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
-- *************************************************


