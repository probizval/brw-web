CREATE DEFINER=`admin`@`%` PROCEDURE `delete_duplicate_business`()
BEGIN
    
	-- declare variables
	declare v_single_biz_id int(10);
    
	declare v_count int(10);

    declare v_bizName varchar(45);
    declare v_street1 varchar(45);
	declare v_city varchar(45);
    declare v_state varchar(2);
    -- declare v_single_biz_id

	-- declare the duplicates cursor
	-- declare dup_cursor cursor for select name_dba, add_street1, add_city, add_state, count(*) cnt 
	-- from t_brw_business 
	-- where add_state = 'CA'
	-- group by name_dba, add_street1, add_city, add_state 
	-- having cnt > 1
	-- order by cnt desc 
	-- limit 1000;
    
    declare dup_cursor cursor for select name_dba, add_street1, add_city, add_state, count(*) cnt 
	from t_brw_business 
	where name_dba = 'PLAYBOY ENTERPRISES INC'
	and add_street1 = '10236 CHARING CROSS RD'
	and add_city = 'LOS ANGELES'
	and add_state = 'CA' 
	limit 1;
    
    declare rule_1_cursor cursor for select biz_id 
		from t_brw_business 
		where 
		biz_id in (select biz_id 
			from t_brw_business 
			where name_dba = v_bizName
			and add_street1 = v_street1
			and add_city = v_city
			and add_state = v_state)
        
			-- where name_dba = 'PLAYBOY ENTERPRISES INC'
			-- and add_street1 = '10236 CHARING CROSS RD'
			-- and add_city = 'LOS ANGELES'
			-- and add_state = 'CA')
		and sales_range is not null
		and employee_range is not null
		and biz_contact_title = 'owner' 
		limit 1;
        
        declare rule_2_cursor cursor for select biz_id 
		from t_brw_business 
		where 
		biz_id in (select biz_id 
			from t_brw_business 
			where name_dba = v_bizName
			and add_street1 = v_street1
			and add_city = v_city
			and add_state = v_state)
        
			-- where name_dba = 'PLAYBOY ENTERPRISES INC'
			-- and add_street1 = '10236 CHARING CROSS RD'
			-- and add_city = 'LOS ANGELES'
			-- and add_state = 'CA')
		and sales_range is not null
		and employee_range is not null
		-- and biz_contact_title = 'owner' 
		limit 1;
        
        declare rule_3_cursor cursor for select biz_id 
		from t_brw_business 
		where 
		biz_id in (select biz_id 
			from t_brw_business 
			where name_dba = v_bizName
			and add_street1 = v_street1
			and add_city = v_city
			and add_state = v_state)
        
			-- where name_dba = 'PLAYBOY ENTERPRISES INC'
			-- and add_street1 = '10236 CHARING CROSS RD'
			-- and add_city = 'LOS ANGELES'
			-- and add_state = 'CA')
		and sales_range is not null
		-- and employee_range is not null
		-- and biz_contact_title = 'owner' 
		limit 1;
        
        declare rule_4_cursor cursor for select biz_id 
		from t_brw_business 
		where 
		biz_id in (select biz_id 
			from t_brw_business 
			where name_dba = v_bizName
			and add_street1 = v_street1
			and add_city = v_city
			and add_state = v_state)
        
			-- where name_dba = 'PLAYBOY ENTERPRISES INC'
			-- and add_street1 = '10236 CHARING CROSS RD'
			-- and add_city = 'LOS ANGELES'
			-- and add_state = 'CA')
		-- and sales_range is not null
			and employee_range is not null
		-- and biz_contact_title = 'owner' 
		limit 1;
        
        declare rule_5_cursor cursor for select biz_id 
		from t_brw_business 
		where 
		biz_id in (select biz_id 
			from t_brw_business 
			where name_dba = v_bizName
			and add_street1 = v_street1
			and add_city = v_city
			and add_state = v_state)
        
			-- where name_dba = 'PLAYBOY ENTERPRISES INC'
			-- and add_street1 = '10236 CHARING CROSS RD'
			-- and add_city = 'LOS ANGELES'
			-- and add_state = 'CA')
		-- and sales_range is not null
		-- and employee_range is not null
		-- and biz_contact_title = 'owner' 
		limit 1;
        
        declare del_cursor cursor for select biz_id 
		from t_brw_business 
		where 
		biz_id in (select biz_id 
			from t_brw_business 
			where name_dba = v_bizName
			and add_street1 = v_street1
			and add_city = v_city
			and add_state = v_state
            and updatedby_user_id != 9999);
        
			-- where name_dba = 'PLAYBOY ENTERPRISES INC'
			-- and add_street1 = '10236 CHARING CROSS RD'
			-- and add_city = 'LOS ANGELES'
			-- and add_state = 'CA'
            -- and updatedby_user_id != 9999);
    
    -- select duplicates
    open dup_cursor;
    dupLoop: loop
		select '***** I am here 111';
        fetch dup_cursor into v_bizName, v_street1, v_city, v_state, v_count;
        
        -- debug statement to print on console
        -- select 'I am in the dupLoop';
        -- select concate('*** After dup_cursor FETCH v_bizName: ', v_bizName) as '';
		-- select concate('*** After dup_cursor FETCH v_street1: ', v_street1) as '';
        -- select concate('*** After dup_cursor FETCH v_city: ', v_city) as '';
        -- select concate('*** After dup_cursor FETCH v_state: ', v_state) as '';
       
        open rule_1_cursor;
        -- open rule_2_cursor;
        -- open rule_3_cursor;
        -- open rule_4_cursor;
        -- open rule_5_cursor;        
        
        fetch rule_1_cursor into v_single_biz_id;
        
		if (v_single_biz_id = null) then 
			select '***** I am here 222';
            open rule_2_cursor;
			fetch rule_2_cursor into v_single_biz_id;
            
		elseif (v_single_biz_id = null) then 
			select '***** I am here 333';
            open rule_3_cursor;
			fetch rule_3_cursor into v_single_biz_id;
			
		elseif (v_single_biz_id = null) then
			select '***** I am here 444';
            open rule_4_cursor;
			fetch rule_4_cursor into v_single_biz_id;
			
		else
			select '***** I am here 555';
            open rule_5_cursor;
			fetch rule_5_cursor into v_single_biz_id;
		
		end if;
        
        -- close all cursors
        close rule_1_cursor;
        close rule_2_cursor;
        close rule_3_cursor;
        close rule_4_cursor;
        close rule_5_cursor;  
        
        -- Update the updatedby_user_id to 9999 for single biz id
        update t_brw_business 
		set updatedby_user_id = 9999
		where 
		biz_id = v_single_biz_id;
        select '***** I am here 666';
        
        -- delete duplicates - delete all records that have updatedby_user_id != 9999
        delete from t_brw_business 
		where 
		biz_id in (select biz_id 
		from t_brw_business 
        where name_dba = v_bizName
		and add_street1 = v_street1
		and add_city = v_city
		and add_state = v_state
		and updatedby_user_id != 9999);
		select '***** I am here 777';
		
        -- where name_dba = 'PLAYBOY ENTERPRISES INC'
		-- and add_street1 = '10236 CHARING CROSS RD'
		-- and add_city = 'LOS ANGELES'
		-- and add_state = 'CA'
        -- and updatedby_user_id != 9999);
        
        select 'I am coming OUT of the dupLoop';
	end loop dupLoop;
    close dup_cursor;
END