SELECT max(biz_id) FROM brwdev.t_brw_business;

SELECT *  FROM brwdev.t_brw_business where biz_id < 6000

SELECT count(*) FROM brwdev.t_brw_business where add_city like 'fremont'

SELECT count(*) FROM brwdev.t_brw_business where add_state = 'UT'

SELECT count(biz_id)  FROM brwdev.t_brw_business where add_state = 'UT'


select * from t_brw_business where name_legal like "%On Lock, Inc%"

select * from t_brw_business where biz_id = 10724720

select * from t_brw_business where name_legal = "TEST_1"


select count(distinct add_city) from t_brw_business

select distinct add_city from t_brw_business order by add_city asc

select count(*) from t_brw_business where add_city like 'san francisco'


select max(biz_id) from t_brw_business 
where add_state = 'AZ' 

select * from t_brw_business where biz_id = 15402854



-- find duplicates
select a.biz_id, b.biz_id, a. name_dba, a.add_street1, b.add_street1, a.add_city 
from t_brw_business a, t_brw_business b
where 
a.biz_id != b.biz_id
and a.add_street1 != null
and b.add_street1 != null
and a.name_dba = b.name_dba
-- and a.add_street1 = b.add_street1
and a.add_street1 like b.add_street1
and a.add_city = b.add_city
and a.add_city = 'CA';


select add_street1, add_city, add_state, count(*) 
from t_brw_business 
where add_city like 'fremont'
group by add_street1, add_city, add_state


