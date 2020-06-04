
-- Author: Sid Patil
-- Date: 06/04/2020
-- select duplicates in cursor
-- run loop on the cursor and select the multiple biz_ids based on name, address
-- insert those biz_ids in duplicates table
-- select one single biz_id that we want to keep based on criteria about range of rev and range of employee
-- if thats not possible then pick up one random biz_id
-- update the row for that biz_id with updatedby_user_id to 9999
-- change all the select SQLs to pick up records only with updatedby_user_id as 9999
-- or just delete the records

CREATE DEFINER =`admin`@`%` PROCEDURE `delete_duplicate_business`()
BEGIN
	-- declare variables
	declare v_bizId int(10);
    declare v_bizName varchar(45);
    declare v_street1 varchar(45);
	declare v_city varchar(45);
    declare v_state varchar(2);

	-- declare the duplicates cursor
	declare dup_cursor cursor for select name_dba, add_street1, add_city, add_state, count(*) cnt 
	from t_brw_business 
	where add_state = 'CA'
	group by name_dba, add_street1, add_city, add_state 
	having cnt > 1
	order by cnt desc 
	limit 1000;
    
    open dup_cursor;
    dupLoop: loop
        fetch dup_cursor into v_bizName, v_street1, v_city, v_state;
        select biz_id 
		from t_brw_business 
		where 
		biz_id in (select biz_id 
		from t_brw_business 
        -- where name_dba = v_bizName
		-- and add_street1 = v_street1
		-- and add_city = v_city
		-- and add_state = v_state)
        
		where name_dba = 'PLAYBOY ENTERPRISES INC'
		and add_street1 = '10236 CHARING CROSS RD'
		and add_city = 'LOS ANGELES'
		and add_state = 'CA')
	and sales_range is not null
	and employee_range is not null
	-- and biz_contact_title = 'owner' 
	limit 1;
    -- debug statement to print on console
    select concate('Deleting DUPLICATES for: ', v_bizName, 'located at: ', v_street1, 'in the city of: ', v_city, 'in the state of: ' v_state);
	end loop dupLoop;
    close dup_cursor;
END
