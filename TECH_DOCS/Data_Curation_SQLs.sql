-- ***********************************************************
-- 1. Data Curation Scripts start here
-- 2. Open Terminal on MAC
-- 3. Goto - cd /usr/local/mysql-shell/bin/
-- 4. run command - mysqlsh
-- 5. rum command - \connect admin@brwdev.cx4tgyitha5s.us-east-1.rds.amazonaws.com/brwdev
-- 6. Switch to SQL mode by command - \sql
-- 7. Enter password if it asks - PWD - HDYnCWRnjn8qxTA81y3iNAikCeCJ
-- 8. Execute SQLs by ending them with;

SELECT * FROM brwdev.t_brw_user_activity order by create_date desc;
07/13 - 2622
07/16 - 2626
07/18 - 2641
07/18 - 2657
07/29 - 2669
08/01 - 2705
08/04 - 2745
08/04 - 2789

SELECT * FROM brwdev.t_brw_user_activity order by create_date desc;

select * from t_brw_business where biz_id = 17821340;

delete from t_brw_image where biz_id = 17821340;

select count(*) from t_brw_business 
where 
sales_range < 500000
and sales_range != 0

select count(biz_id) from t_brw_business where hidden_YN = 'N';

select distinct(image_first) from t_brw_business;

select count(biz_id) from t_brw_business where image_first is null;


select count(*) from t_brw_business where market_based_est != '';
-- 1114687

select count(*) from t_brw_business where sales_range != '';
-- 2619004

select count(*) from t_brw_business where sales_range != 0;
-- 1114688

select * from t_brw_business where biz_id = 17821340;

delete from t_brw_image where biz_id = 17821340;

select biz_id from t_brw_business where 
createdby_user_id = 777 
and updatedby_user_id = 7777 order by biz_id desc limit 100;
-- 18527507

select biz_id from t_brw_business where 
createdby_user_id = 888 
and updatedby_user_id = 8888 order by biz_id desc limit 100;
-- 18837135

select count(*) from  t_brw_business where hidden_YN = 'Y';
-- 0
update t_brw_business set hidden_YN = 'N' where hidden_YN = 'Y';

select *   
	from t_brw_business 
    where 
    -- biz_id = 1003126
    -- updatedby_user_id != 9999;
    biz_id in(18796269, 18796263, 18796151);
    

select distinct type from t_brw_business;

select count(*) from t_brw_business where type = 'BTYPE_MISC';
-- 977334

select count(*) from t_brw_business;
-- 26619004

select count(biz_id) from t_brw_business where 
createdby_user_id = 888 
and updatedby_user_id = 8888 order by biz_id desc limit 100;
-- 2477

select max(biz_id) from t_brw_business 
-- 18837135

select max(biz_id) from t_brw_business where 
createdby_user_id = 777 
and updatedby_user_id = 7777 order by biz_id desc limit 100;
-- 14179171

select count(*) from t_brw_business where add_county = ''

update t_brw_business
set sales_range = '0'
where sales_range = '510';

update t_brw_business
set sales_range = '1000000000'
where sales_range = '$1 bil and above';

update t_brw_business
set sales_range = '2500000'
where sales_range = '$1 mil to less than $5 mi';

update t_brw_business
set sales_range = '0'
where sales_range = '';

update t_brw_business
set sales_range = '15000000'
where sales_range = '$10 mil to less than $25';

update t_brw_business
set sales_range = '35000000'
where sales_range = '$25 mil to less than $50';

update t_brw_business
set sales_range = '150000000'
where sales_range = '$100 mil to less than $25';

update t_brw_business
set sales_range = '350000000'
where sales_range = '$250 mil to less than $50';

update t_brw_business
set sales_range = '750000000'
where sales_range = '$500 mil to less than $1';

update t_brw_business
set sales_range = '7500000'
where sales_range = '$5 mil to less than $10 m';

update t_brw_business
set sales_range = '75000000'
where sales_range = '$50 mil to less than $100';

update t_brw_business
set sales_range = '1000000'
where sales_range = 'Less than $1 mil';

update t_brw_business
set sales_range = '750000'
where sales_range = '$500,000 TO $1 MILLION';

update t_brw_business
set sales_range = '500000'
where sales_range = 'LESS THAN $500,000';

update t_brw_business
set sales_range = '0'
where sales_range = 'UNKNOWN';

update t_brw_business
set sales_range = '15000000'
where sales_range = '$10 TO 20 MILLION';

update t_brw_business
set sales_range = '7500000'
where sales_range = '$5 TO 10 MILLION';

update t_brw_business
set sales_range = '3500000'
where sales_range = '$2.5 TO 5 MILLION';

update t_brw_business
set sales_range = '350000000'
where sales_range = '$100 TO 500 MILLION';

update t_brw_business
set sales_range = '1500000'
where sales_range = '$1 TO 2.5 MILLION';

update t_brw_business
set sales_range = '35000000'
where sales_range = '$20 TO 50 MILLION';

update t_brw_business
set sales_range = '750000000'
where sales_range = '$500 MILLION TO $1 BILLION';

update t_brw_business
set sales_range = '75000000'
where sales_range = '$50 TO 100 MILLION';

update t_brw_business
set sales_range = '1000000000'
where sales_range = 'OVER $1 BILLION';


select * from t_brw_business where biz_id = 1003688;

select count(*) from t_brw_business where updatedby_user_id = 9999

select * from t_brw_business where updatedby_user_id = 9999 order by biz_id desc limit 100;


select count(*) from t_brw_business where add_zip is null;

select count(*) from t_brw_business where add_zip = '';


select count(*) from t_brw_business where reg_city_date is null;

select count(*) from t_brw_business where reg_city_date = '0000-00-00 00:00:00';

select count(*) from t_brw_business where reg_state_date = '0000-00-00 00:00:00'; 

select count(*) from t_brw_business where create_date = '0000-00-00 00:00:00';

select distinct update_date from t_brw_business;
-- 2020-05-10 00:00:00
select count(*) from t_brw_business where update_date = '0000-00-00 00:00:00'; 

update t_brw_business
set create_date = '2020-05-10 00:00:00'
where create_date = '0000-00-00 00:00:00';

update t_brw_business
set update_date = '2020-05-10 00:00:00'
where update_date = '0000-00-00 00:00:00';


select count(*) from t_brw_business where add_county = '';
-- 1149030
-- 38972


select count(*) from t_brw_business where type = '';
-- 16438

update t_brw_business 
set type = 'BTYPE_MISC', 
sub_type = 'BTYPE_MISC'
where 
type = '';
-- 16438

select count(*) from t_brw_business where type = 'BTYPE_MISC';
-- 977334

-- delete from t_brw_business where add_city = '';

 -- where biz_id < 6000

-- To list all DB process
SHOW FULL PROCESSLIST;

-- To kill the DB process
CALL mysql.rds_kill(13974)

select count(*) from t_brw_business t1, t_brw_state_county_cities t2 
where 
t1.add_state = t2.state_code 
and t1.add_city = t2.city_name
and t1.add_county = '';

select t1.add_city, t1.add_county, t1.add_state, t2.city_name, t2.county_name, t2.state_code 
from t_brw_business t1, t_brw_state_county_cities t2 
where 
t1.add_state = t2.state_code 
and t1.add_city = t2.city_name
and t1.add_county = '' limit 100;

update t_brw_business t1, t_brw_state_county_cities t2 
set t1.add_county = t2.county_name 
where 
t1.add_state = t2.state_code 
and t1.add_city = t2.city_name
and t1.add_county = '';

select ROUND(FLOOR(RAND() * (10 - 2 + 1) + 2) * 2171.5, -1);

select *   
	from t_brw_business 
    where 
    -- biz_id = 1003126
    -- updatedby_user_id != 9999;
    biz_id in(18796269, 18796263, 18796151);
    
select biz_id, type, sales_range, market_based_est where bizId in (18796269, 18796263, 18796151);
    
select biz_id, sales_range, employee_range   
	from t_brw_business 
    where 
    -- biz_id = 1003126
    -- updatedby_user_id != 9999;
    biz_id in(18796269, 18796263, 18796151);
    
-- '18796151','1000000000', '3500'
-- '18796263','1000000', '5'
-- '18796269','500000', '8'

    

select id, pop_density 
	from t_brw_state_counties 
    where 
    state_code = 'IN' 
    and county_name = 'MARION';

select biz_id, add_state, add_county, sales_range, employee_range   
	from t_brw_business 
    where 
    -- updatedby_user_id != 9999;
    biz_id in(18796269, 18796263, 18796151);
    
    select biz_id, add_state, add_county, sales_range, employee_range   
	from t_brw_business 
    where 
    -- updatedby_user_id != 9999;
    biz_id = 18796269;

update t_brw_business
set employee_range = '1'
where employee_range = '0100000000';




select biz_id, employee_range 
    from t_brw_business 
    where 
    -- employee_range like '%,%';
    biz_id in(18796269, 18796263, 18796151);
    
    select * 
    from t_brw_business 
    where 
    -- employee_range like '%,%';
    biz_id in(18796269, 18796263, 18796151);


select distinct(employee_range) from t_brw_business;

select distinct(employee_range) 
from t_brw_business order by cast(employee_range as UNSIGNED) asc;


select count(biz_id) from t_brw_business  where employee_range like '%,%';

select count(biz_id) from t_brw_business where employee_range = '3500';

select biz_id, add_state, add_county, sales_range, employee_range   
	from t_brw_business 
    where 
    -- updatedby_user_id != 9999;
    biz_id in(18796269, 18796263, 18796151);

SELECT count(*) FROM brwdev.t_brw_state_counties;

SELECT * FROM brwdev.t_brw_state_counties where state_code = 'FL';

update t_brw_state_counties
set county_name = 'Bedford Co' 
where id = 2830;

SELECT * FROM brwdev.t_brw_county_population where state_code = 'VA';

-- find difference/duplicates in two tables
select * from t_brw_state_counties where CONCAT(state_code,',', county_name) 
not in (select CONCAT(state_code,',', county_name) from t_brw_county_population)


select count(t1.id) 
from t_brw_state_counties t1, t_brw_county_population t2
where
t1.state_code = t2.state_code
and t1.county_name = t2.county_name



update t_brw_state_counties t1, t_brw_county_population t2
set t1.population = t2.population,
t1.pop_density = t2.pop_density,
t1.num_houses = t2.num_houses,
t1.hos_density = t2.hos_density
where
t1.state_code = t2.state_code
and t1.county_name = t2.county_name



-- find difference/duplicates in two tables
select * from t_brw_state_counties where CONCAT(state_code,',', county_name) 
not in (select CONCAT(state_code,',', county_name) from t_brw_state_county_cities)

SELECT * FROM brwdev.t_brw_state_counties where state_code = 'AL';

SELECT * FROM brwdev.t_brw_state_county_cities where state_code = 'AK';

********************************************************************************************************
-- find difference/duplicates in two tables
select * from t_brw_state_counties where CONCAT(state_code,',', county_name) 
not in (select CONCAT(add_state,',', add_county) from t_brw_business)

SELECT * FROM brwdev.t_brw_state_counties where state_code = 'GA';

SELECT distinct add_county FROM brwdev.t_brw_business where add_state = 'KS' order by add_county asc;

**********************
SELECT *  FROM brwdev.t_brw_business where add_state = 'KS'  and add_county = 'Alameda'
-- 1479

SELECT count(*) FROM brwdev.t_brw_business where add_state = 'MO'  and add_county = 'Saint Louis'
-- 1161

update t_brw_business
set add_county = 'St. Croix'
where
add_county = 'Saint Croix';

********************************************************************************************************







select count(*) from t_brw_business where sales_range is null;

select count(*) from t_brw_business where sales_range = 0;
-- 1247686
select count(*) from t_brw_business where sales_range = '0';
-- 1247686

select distinct sales_range 
from t_brw_business 
where cast(sales_range as UNSIGNED) > 100000
order by cast(sales_range as UNSIGNED) asc limit 10;


select biz_id, sales_range, market_based_est  
	from t_brw_business 
    where biz_id in(18796269, 18796263, 18796151)
    order by biz_id asc limit 100;
    
update t_brw_business 
set market_based_est = '0'
where biz_id in(18796269, 18796263, 18796151);

    
-- Create User on MySql and grant permissions to particular table
select * from mysql.user;

-- delete from mysql.user where user = 'brw_app_dev'

select distinct sales_range 
from t_brw_business 
order by sales_range asc;

-- How do I read revenue range that is in varchar and pick up just the numbers?
-- $1,931,283,000
SELECT CAST('1931283000' AS DECIMAL);

-- 20 to 50 million 
SELECT CAST('1931283000' AS DECIMAL);


SELECT CAST("2017-08-29" AS DATE);

SELECT INSTR('20 to 50 million','to');

select SUBSTRING('20 to 50 million', 1, (INSTR('20 to 50 million','to') - 1));
-- 20
-- *******

SELECT INSTR('20 to 50 million','to');

select SUBSTRING('$27,819,000,000  ', '$', length($27,819,000,000  ));
-- 
-- ******


USER/PWD - read_only/brw_2020
USER/PWD - brw_app_dev/HDYnCWRnjn8qxTA81y3iNAikCeCJ

CREATE USER 'read_only'@'%' IDENTIFIED BY 'brw_2020';
GRANT SELECT ON *.* TO 'read_only'@'%';
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

select * from t_brw_business where biz_id = 10105762;

2019-11-13 00:00:00
2020-05-10 00:00:00

select count(*) from t_brw_business 
where create_date = '0000-00-00 00:00:00'
and update_date = '0000-00-00 00:00:00'

update t_brw_business
set create_date = '2020-05-10 00:00:00',
create_date = '2020-05-10 00:00:00'
where create_date = '0000-00-00 00:00:00'
and update_date = '0000-00-00 00:00:00'

update t_brw_business
set
update_date = '2020-05-10 00:00:00'
where 
and update_date = '0000-00-00 00:00:00';

update t_brw_business
set create_date = '2020-05-10 00:00:00'
where 
create_date = '0000-00-00 00:00:00';


update t_brw_business 
set updatedby_user_id = 9999
where
updatedby_user_id = 999;

select count(*) from t_brw_business where updatedby_user_id = 999;


SELECT biz_id, name_dba, type, sub_type, for_sell_YN, hidden_YN, for_sell_price, market_based_est, 
image_first, add_street1, add_street2, add_city, add_zip, add_county, add_state, latitude, longitude, 
vendor_call_YN, franchise_YN 
FROM t_brw_business 
WHERE add_county = "Miami-dade" 
AND add_state = "FL" 
AND add_ZIP = '33131-3032'
ORDER BY for_sell_YN DESC


SELECT * FROM t_brw_image WHERE biz_id = 10000001 ORDER BY image_id ASC

SELECT max(biz_id) FROM brwdev.t_brw_business where add_state = 'LA';
-- 16803963

SELECT count(*) FROM brwdev.t_brw_business where biz_id = 10000001;
-- 31018

SELECT biz_id, latitude, longitude FROM brwdev.t_brw_business 
where latitude is not null
and longitude is not null;


SELECT * 
FROM brwdev.t_brw_business where 
-- biz_id = 17073476 and 
name_dba = 'Bancorpsouth Inc' and
owner_first = 'Jerry Fielder' and
add_state = 'LA';
-- 16803963

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
CALL mysql.rds_kill(7995)

-- call Delete SP
-- call brwdev.delete_duplicate_business();
-- call brwdev.delete_duplicate_business_STATES();

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

select count(*) from t_brw_business where type = 'BTYPE_MISC'

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
CALL mysql.rds_kill(11861);

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
        
        
-- **************************** START OF RULES DUMENTATION **************************************************--
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

-- **************************** END OF RULES DUMENTATION **************************************************--

-- 1. SQLs to Find and Delete Duplicates - Keep the record that has most columns, especially with 
-- revenue range, employee range, specific SIC description, contact title as owner 
-- and contact details.
--

-- If the count is more than 1 for any row thats the duplicate
select name_dba, add_street1, add_city, add_state, count(*) cnt 
from t_brw_business 
-- where add_state = 'CA' 
-- and add_city = 'Fremont' 
group by name_dba, add_street1, add_city, add_state 
having cnt > 1 
order by cnt desc 
limit 1000;


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

-- wherevere sic details are not avalable, set sic_code to 0000 and sic_description to Miscellaneous
select count(*) from t_brw_business where sic_code is null and sic_description is null; -- result: 21

update t_brw_business
set sic_code = '0000',
sic_description = 'Miscellaneous'
where
(sic_code is null and sic_description is null) or
(sic_code = '' and sic_description = '');
-- 115637 rows updated


select count(*) from t_brw_business where name_dba is null and name_legal is null;
select count(*) from t_brw_business where name_dba = '' and name_legal = '';
-- If the name is null or empty update it with business type
update t_brw_business
set name_dba = 'Name Not Available',
name_legal = 'Name Not Available'
where
(name_dba is null and name_legal is null) or 
(name_dba = '' and name_legal = '');


-- 2. Based on SIC description decide the Biz Type - update type, sub type 
-- and naics attributes

2.1. Search based on known keywords
-- SEARCH KEYWORDS - food, restaurant, eat

select type, count(*) cnt 
from t_brw_business 
group by type
having cnt > 1
order by cnt desc;

-- result as of 6/17
'BTYPE_MISC','1117320'
'BTYPE_RETAIL','191344'
'BTYPE_MANUFACTURING','183735'
'BTYPE_SER_BIZ','182628'
'BTYPE_EDU_CHILD','162189'
'BTYPE_REST_FOOD','147785'
'BTYPE_HEALTH_FIT','126930'
'BTYPE_TRANS_STOR','109820'
'BTYPE_WHLSL_DIST','98574'
'BTYPE_REAL_EST','93439'
'BTYPE_FINANCIAL','41777'
'BTYPE_BUILD_CONS','33683'
'BTYPE_COM_MEDIA','32829'
'BTYPE_ENT_REC','26208'
'BTYPE_ONLINE_TECH','23016'
'BTYPE_TRAVEL','11063'
'BTYPE_BEAUTY_PERSONA','10426'
'BTYPE_AGRI','7623'


select count(*) from t_brw_business where type is null;

select count(*) from t_brw_business where type = 'BTYPE_MISC';

select count(*) from t_brw_business where type = 'BTYPE_MISC';

select count(*) from t_brw_business where type is null;


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
select * from t_brw_sic_biztype_mapping order by sic_description asc;
where 
(sic_description like '%food%'or 
sic_description like '%restaurant%' or 
sic_description like 'eat%' or
sic_description like '%cafe%' or
sic_description like 'bar') 
order by sic_description asc;

update t_brw_sic_biztype_mapping 
set biz_type = 'BTYPE_REST_FOOD'
where 
(sic_description like '%food%'or 
sic_description like '%restaurant%' or 
sic_description like 'eat%' or
sic_description like '%cafe%' or
sic_description like 'bar');

select * from t_brw_sic_biztype_mapping where biz_type = 'BTYPE_REST_FOOD'

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


select biz_type 
from t_brw_sic_biztype_mapping sbm
where sbm.sic_code = '142900'
and sbm.sic_description = 'Crushed and Broken Stone, NEC';

update t_brw_business bz
set bz.type = (select biz_type 
from t_brw_sic_biztype_mapping sbm
where sbm.sic_code = bz.sic_code
and sbm.sic_description = bz.sic_description);

update t_brw_business bz
set bz.sub_type = (select distinct biz_type 
from t_brw_sic_biztype_mapping sbm
where bz.sic_code = sbm.sic_code
and bz.sic_description = sbm.sic_description);


2.4 Long Term Solution
-- Come up with table that maps Distinct SIC_CODE to BRW_RO_BIZ_TYPES
-- Then on every time new business is getting added look at the mapping and put it


-- 3. Based on Biz Type, revenue range, county decide range of market based estimates
-- have the price range as 10-20% random number generator
-- update t_brw_business

-- 3.1.1 Make all range in number format
update t_brw_business 
set sales_range = '10000000'
where sales_range = '$10 mil to less than $25';

-- 3.1.2 Clean up the characters between numbers like '$' and ',' and keep only numbers
 
    
select distinct sales_range, count(*) cnt 
from t_brw_business 
where add_state = 'CA'
group by sales_range
order by cnt asc;


update t_brw_business 
	set sales_range = '10000000'
	where sales_range = '$10 mil to less than $25';
    
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
SELECT FLOOR(RAND()*(10-5+1)+5);

select count(*) from t_brw_business where market_based_est is null;
-- 0
select count(*) from t_brw_business where market_based_est != '';
-- 6

select count(*) from t_brw_business where asset_based_est != '';
-- 6

select count(*) from t_brw_business where income_based_est != '';
-- 6

select count(*) from t_brw_business where market_based_est = '';
-- 2600383

select count(*) from t_brw_business where sales_range != '';
-- 1621450
select count(*) from t_brw_business where sales_range = '';
-- 978939

select count(*) from t_brw_business where sales_range is null;
-- 0
select count(*) from t_brw_business where sales_range = '0';
-- 268746
select count(*) from t_brw_business where sales_range = 0;
-- 1247686

select sales_range from t_brw_business where sales_range != '0' limit 10;
-- 

select distinct sales_range from t_brw_business

-- 4. Based on Business Type update image_first - no icon or vector but actual image
-- Use 10 images per business type random
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


SELECT ROUND(FLOOR(RAND()*(100000-50000+1)+50000), -2);



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

-- delete from t_brw_sic_biztype_mapping

-- 8. Insert data in to state county city table
select * from t_brw_state_county_cities

SELECT * FROM t_brw_state_counties 
WHERE state_name = 'Not Available' ORDER BY county_name asc;

-- Update to update the state names in state counties table
update t_brw_state_counties sc
set state_name = (select distinct state_name 
from t_brw_state_county_cities scc
where sc.state_code = scc.state_code);

INSERT INTO t_brw_state_counties (state_code, state_name, county_name) 
select distinct state_code, state_name, county_name 
from t_brw_state_county_cities 
order by state_code, county_name asc;
-- where 
-- add_state = 'CA'

select count(distinct state_code, state_name, county_name) 
from t_brw_state_county_cities 
where 
state_code = 'NV'

select count(*) from t_brw_state_counties
where state_code = 'CA'

delete from t_brw_state_counties

-- delete from t_brw_state_county_cities

-- ******** DONE WITH DATA CURATION!! :) :) *************************************************
