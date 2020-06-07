CREATE DEFINER=`admin`@`%` PROCEDURE `delete_duplicate_business`()
BEGIN
    
	-- declare variables
	-- DECLARE done INT DEFAULT 0;
    -- DECLARE dup_cur_done INT DEFAULT 0;
    DECLARE del_cur_done INT DEFAULT 0;
    
	declare v_single_biz_id int(10) DEFAULT 0;
	declare v_del_biz_id int(10) DEFAULT 0;
    
	declare v_count int(10) DEFAULT 0;
    declare v_dup_count int(10) DEFAULT 0;
    declare v_del_count int(10) DEFAULT 0;

    declare v_bizName varchar(45);
    declare v_street1 varchar(45);
	declare v_city varchar(45);
    declare v_state varchar(2);

	declare dup_cursor cursor for select name_dba, add_street1, add_city, add_state, count(*) cnt 
	from t_brw_business 
	where add_state = 'CA'
    -- and add_city = 'FREMONT'
	group by name_dba, add_street1, add_city, add_state 
	having cnt > 1
	order by cnt desc 
	limit 1000;
    
    -- declare dup_cursor cursor for select name_dba, add_street1, add_city, add_state, count(*) cnt 
	-- from t_brw_business 
	-- where name_dba = 'Infosys Technologies Limited'
	-- and add_street1 = '6607 KAISER DR'
	-- and add_city = 'FREMONT'
	-- and add_state = 'CA'
    -- limit 1;
    -- DECLARE CONTINUE HANDLER FOR NOT FOUND SET dup_cur_done = 1;
    
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
            
            DECLARE CONTINUE HANDLER FOR NOT FOUND SET del_cur_done = 1;
    
    -- select duplicates
    select '***** JUST BEFORE dupLoop 111';
    open dup_cursor;
    dupLoop: loop fetch dup_cursor into v_bizName, v_street1, v_city, v_state, v_count;
		set v_dup_count = v_dup_count + 1;
        
        select '***** INSIDE dupLoop v_dup_count: '+v_dup_count;
        select '***** INSIDE dupLoop v_count: '+v_count;
        
        -- set v_single_biz_id = 0;
        -- IF v_bizName.length() = 0 THEN
            -- LEAVE dupLoop;
        -- END IF;
       
        open rule_1_cursor;
        fetch rule_1_cursor into v_single_biz_id;
        close rule_1_cursor;
		select '*** AFTER rule_1_cursor Fetch v_single_biz_id: '+v_single_biz_id;
        
		if (v_single_biz_id = 0) then 
			-- select '***** I am here 222';
            open rule_2_cursor;
			fetch rule_2_cursor into v_single_biz_id;
            select '*** AFTER rule_2_cursor Fetch v_single_biz_id: '+v_single_biz_id;
            close rule_2_cursor;
            -- select '***** I am here 222';
            
		elseif (v_single_biz_id = 0) then 
			-- select '***** I am here 333';
            open rule_3_cursor;
			fetch rule_3_cursor into v_single_biz_id;
            select '*** AFTER rule_3_cursor Fetch v_single_biz_id: '+v_single_biz_id;
			close rule_3_cursor;
            
		elseif (v_single_biz_id = 0) then
			-- select '***** I am here 444';
            open rule_4_cursor;
			fetch rule_4_cursor into v_single_biz_id;
            select '*** AFTER rule_4_cursor Fetch v_single_biz_id: '+v_single_biz_id;
            close rule_4_cursor;
			
		else
			-- select '***** I am here 555';
            open rule_5_cursor;
			fetch rule_5_cursor into v_single_biz_id;
            select '*** AFTER rule_5_cursor Fetch v_single_biz_id: '+v_single_biz_id;
			close rule_5_cursor;	
			
		end if;
        
        -- Leave the dupLoop if v_single_biz_id is 0 at this point
        IF v_single_biz_id = 0 THEN
			select '***** EXITING OUTER dupLoop *****';
			LEAVE dupLoop;
		END IF;
		-- select '***** I am here 666';

        -- Update the updatedby_user_id to 9999 for single biz id
        select '*** BEFORE Updating "updatedby_user_id = 9999" for v_single_biz_id: '+v_single_biz_id;
        update t_brw_business 
		set updatedby_user_id = 9999
		where 
		biz_id = v_single_biz_id;
        commit;
        set v_single_biz_id = 0;
        -- select '***** I am here 666.1';
        
        -- delete duplicates - delete all records that have updatedby_user_id != 9999
        open del_cursor;
        set v_del_count = 0;
		delLoop: loop fetch del_cursor into v_del_biz_id;
			set v_del_count = v_del_count + 1;
        
			select '***** INSIDE delLoop v_dup_count: '+v_dup_count;
			select '***** INSIDE delLoop v_del_count: '+v_del_count;
			
            select '***** DELETING v_del_biz_id: '+v_del_biz_id;
            
			-- IF v_del_biz_id.length() = 0 THEN
				-- LEAVE delLoop;
			-- END IF;
            
            IF v_del_biz_id = 0 THEN
				select '***** EXITING delLoop *****';
				LEAVE delLoop;
			END IF;

			delete from t_brw_business 
			where 
			biz_id = v_del_biz_id;
            commit;
            set v_del_biz_id = 0;
            
			select '***** I am here 999';
		end loop delLoop;
        close del_cursor;
        
        select 'Deleted TOTAL # of Duplicates: '+v_del_count;
        
        set v_bizName = null;
        set v_street1 = null;
        set v_city = null;
        set v_state = null;
        
        select '***** I am here 101010';
        -- select 'Coming OUT of the dupLoop';
	end loop dupLoop;	
    close dup_cursor;
    
    select 'Deleted Duplicates for TOTAL # of Business: '+v_dup_count;
    select 'Done with SP Execution!';
END