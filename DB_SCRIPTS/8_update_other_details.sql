CREATE DEFINER=`admin`@`%` PROCEDURE `7_update_other_details`()
BEGIN
	-- This SP is to update rest of the bizness details as listed below in update statement
    -- declare an array with various business tyeps - this is achieved using temp tables in mysql
    -- CREATE TEMPORARY TABLE t_brw_temp_types SELECT type FROM t_brw_business_type_def;
    -- call 7_update_other_details();
    
    DECLARE cur_done INT DEFAULT 0;
	declare v_count int(10) DEFAULT 0;
    -- for testing
    declare v_id int(10) DEFAULT 99;
    
    declare v_biz_id int(10) DEFAULT 0;
    declare v_state varchar(45) DEFAULT '';
    declare v_county varchar(45) DEFAULT '';
    
	declare v_vc_sales_range varchar(45) DEFAULT '0';
	declare v_int_sales_range int(10) DEFAULT 0;
    
	declare v_sales_range_Plus50P int(10) DEFAULT 0;
	declare v_sales_range_Minus50P int(10) DEFAULT 0;
        
    declare v_vc_emp_range varchar(45) DEFAULT '0';
	declare v_int_emp_range int(10) DEFAULT 0;
	
	declare v_emp_range_Plus30P int(10) DEFAULT 0;
	declare v_emp_range_Minus30P int(10) DEFAULT 0;
    
    -- declare v_county_pop int(10) DEFAULT 0;
    declare v_county_pop_den double DEFAULT 0.0;
    declare v_vc_county_pop_den varchar(45) DEFAULT '0.0';
    -- declare v_county_hos_den double DEFAULT 0.0;
    
    -- variables to capture the values to set in the table
    declare v_annual_cash_flow int(10) DEFAULT 0;
	declare v_monthly_payroll_cost int(10) DEFAULT 0;
	declare v_inventory_cost int(10) DEFAULT 0;
	declare v_market_based_est int(10) DEFAULT 0;
	declare v_rev_monthly int(10) DEFAULT 0;
	declare v_exp_monthly_rent int(10) DEFAULT 0;
	declare v_exp_monthly_material int(10) DEFAULT 0;
	declare v_exp_monthly_emp int(10) DEFAULT 0;
	declare v_exp_monthly_utility int(10) DEFAULT 0;
	declare v_value_total_equipment int(10) DEFAULT 0;
	declare v_value_total_furniture int(10) DEFAULT 0;
	
	declare v_emp_FT_num int(10) DEFAULT 0;
	declare v_emp_PT_num int(10) DEFAULT 0;
	
	declare v_1mile_rad_popln int(10) DEFAULT 0;
	declare v_3mile_rad_popln int(10) DEFAULT 0;
	declare v_5mile_rad_popln int(10) DEFAULT 0;
	declare v_dailypeople_doorfront_num int(10) DEFAULT 0;
	declare v_dailycar_parklot_num int(10) DEFAULT 0;
    
	-- declare cursor to pull all records which are NOT ALREADY UPDATED
    declare all_records_cursor cursor for select biz_id, add_state, add_county, sales_range, employee_range   
	from t_brw_business 
    where 
    -- updatedby_user_id != 9999;
    biz_id in(18796151, 18796263, 8796269);
    -- biz_id = 8796269;
    -- for validation run below sql
	-- select biz_id, type, sales_range, market_based_est where bizId in (8796269, 18796263, 18796151);
    
    -- declare cursor to get counties stats
    declare county_stats_cursor cursor for select pop_density 
	from t_brw_state_counties 
    where 
    state_code = v_state 
    and county_name = v_county_name;

	DECLARE CONTINUE HANDLER FOR NOT FOUND SET cur_done = 1;

    open all_records_cursor;
    all_records_Loop: loop fetch all_records_cursor into v_biz_id, v_state, v_county, v_vc_sales_range, v_vc_emp_range;
		set v_count = v_count + 1;
		
        IF v_biz_id = 0 THEN
			select '***** EXITING all_records_Loop *****';
			LEAVE all_records_Loop;
		END IF;
        
		select '**** v_biz_id: '+v_biz_id;
		select '**** v_state: '+v_state;
		select '**** v_county: '+v_county;
		select '**** v_vc_sales_range: '+v_vc_sales_range;
		select '**** v_vc_emp_range: '+v_vc_emp_range;
		
        select '**** 111 v_county_pop_den: '+v_county_pop_den;
        select '**** 111 v_id: '+v_id;
        
        IF v_count = 1 THEN
			select '***** v_count: '+v_count;
			set v_county_pop_den = 2171.5;
		END IF;
        
        IF v_count = 2 THEN
			select '***** v_count: '+v_count;
			set v_county_pop_den = 2171.5;
		END IF;
        
        IF v_count = 3 THEN
			select '***** v_count: '+v_count;
			set v_county_pop_den = 459.2;
		END IF;
        
		-- Open the county statistics cursor
		-- open county_stats_cursor;
        -- select '**** 111.1 v_id: '+v_id;
		-- fetch county_stats_cursor into v_county_pop_den;
        -- fetch county_stats_cursor into v_id;
        -- select '**** 111.2 v_id: '+v_id;
		-- close county_stats_cursor;
        
		select '**** 222 v_county_pop_den: '+v_county_pop_den;
        select '**** 222 v_id: '+v_id;
		
		-- sales range calculations	
		set v_int_sales_range = cast(v_vc_sales_range as UNSIGNED);
        select '**** 222 v_int_sales_range: '+v_int_sales_range;
		set v_sales_range_Plus50P = (v_int_sales_range * 1.5);
        select '**** 222 v_sales_range_Plus50P: '+v_sales_range_Plus50P;
		set v_sales_range_Minus50P = (v_int_sales_range * 0.5);
        select '**** 222 v_sales_range_Minus50P: '+v_sales_range_Minus50P;
        
        -- employee range calculations
        set v_int_emp_range = cast(v_vc_emp_range as UNSIGNED);
        select '**** 222 v_int_emp_range: '+v_int_emp_range;
		set v_emp_range_Plus30P = (v_vc_emp_range * 1.3);
        select '**** 222 v_emp_range_Plus30P: '+v_emp_range_Plus30P;
		set v_emp_range_Minus30P = (v_int_emp_range * 0.7);
        select '**** 222 v_emp_range_Minus30P: '+v_emp_range_Minus30P;
		
		IF v_int_sales_range != 0 THEN
			select '**** IN HERE: 111';
			set v_annual_cash_flow = ROUND(FLOOR(RAND() * (v_sales_range_Plus50P - v_sales_range_Minus50P + 1) + v_sales_range_Minus50P), - 2);
			set v_monthly_payroll_cost = ROUND(FLOOR(RAND() * (v_sales_range_Plus50P - v_sales_range_Minus50P + 1)+v_sales_range_Minus50P)/12 * 0.3, - 2);
			set v_inventory_cost = ROUND(FLOOR(RAND() * (v_sales_range_Plus50P - v_sales_range_Minus50P + 1) + v_sales_range_Minus50P)/12 * 0.3, - 2);
			set v_market_based_est = ROUND(FLOOR(RAND() * (v_sales_range_Plus50P - v_sales_range_Minus50P + 1) + v_sales_range_Minus50P), - 2);
			set v_rev_monthly = ROUND(FLOOR(RAND() * (v_sales_range_Plus50P - v_sales_range_Minus50P + 1) + v_sales_range_Minus50P)/12, - 2);
			set v_exp_monthly_rent = ROUND(FLOOR(RAND() * (v_sales_range_Plus50P - v_sales_range_Minus50P + 1)+ v_sales_range_Minus50P)/12 * 0.2, - 2);
			set v_exp_monthly_material = ROUND(FLOOR(RAND() * (v_sales_range_Plus50P - v_sales_range_Minus50P + 1)+v_sales_range_Minus50P)/12 * 0.2, - 2);
			set v_exp_monthly_emp = ROUND(FLOOR(RAND() * (v_sales_range_Plus50P - v_sales_range_Minus50P + 1)+v_sales_range_Minus50P)/12 * 0.3, - 2);
			set v_exp_monthly_utility = ROUND(FLOOR(RAND() * (v_sales_range_Plus50P - v_sales_range_Minus50P + 1)+v_sales_range_Minus50P)/12 * 0.1, - 2);
			set v_value_total_equipment = ROUND(FLOOR(RAND() * (v_sales_range_Plus50P - v_sales_range_Minus50P + 1) + v_sales_range_Minus50P), - 2);
			set v_value_total_furniture = ROUND(FLOOR(RAND() * (v_sales_range_Plus50P - v_sales_range_Minus50P + 1) + v_sales_range_Minus50P), - 2);
		ELSE
			-- TODO: set these values based on comparable business
			select '**** IN HERE: 222';
			set v_annual_cash_flow = 0;
			set v_monthly_payroll_cost = 0;
			set v_inventory_cost = 0;
			set v_market_based_est = 0;
			set v_rev_monthly = 0;
			set v_exp_monthly_rent = 0;
			set v_exp_monthly_material = 0;
			set v_exp_monthly_emp = 0;
			set v_exp_monthly_utility = 0;
			set v_value_total_equipment = 0;
			set v_value_total_furniture = 0;
		END IF;
		
		IF v_int_emp_range != 0 THEN
			select '**** IN HERE: 333';
			set v_emp_FT_num = ROUND(FLOOR(RAND() * (v_emp_range_Plus30P - v_emp_range_Minus30P + 1) + v_emp_range_Minus30P) * 0.7, - 1);
			set v_emp_PT_num = ROUND(FLOOR(RAND() * (v_emp_range_Plus30P - v_emp_range_Minus30P + 1) + v_emp_range_Minus30P) * 0.3, - 1);
		ELSE
			select '**** IN HERE: 444';
			set v_emp_FT_num = 0;
			set v_emp_PT_num = 0;
        END IF;
        
        IF v_county_pop_den != 0 THEN
        	select '**** IN HERE: 555';
			set v_1mile_rad_popln = ROUND(FLOOR(RAND() * (10 - 2 + 2) + 1)) * v_county_pop_den;
			set v_3mile_rad_popln = ROUND(FLOOR(RAND() * (10 - 2 + 2) + 1)) * v_county_pop_den * 3;
			set v_5mile_rad_popln = ROUND(FLOOR(RAND() * (10 - 2 + 2) + 1)) * v_county_pop_den * 5;
			set v_dailypeople_doorfront_num = ROUND(FLOOR(RAND() * (10 - 2 + 2) + 1)) * v_county_pop_den/40;
			set v_dailycar_parklot_num = ROUND(FLOOR(RAND() * (10 - 2 + 2) + 1)) * v_county_pop_den/20;
        ELSE
        	select '**** IN HERE: 666';
        	set v_1mile_rad_popln = 0;
			set v_3mile_rad_popln = 0;
			set v_5mile_rad_popln = 0;
			set v_dailypeople_doorfront_num = 0;
			set v_dailycar_parklot_num = 0;
        END IF;
		
        -- update the record with above values
		update t_brw_business 
			-- below attributes are based on type of business TODO: Write seperate SP for this one
			-- naics_num = '',
			-- naics_description = '',
			-- sqft_indoor = '',
			-- sqft_outdoor = '',
			-- sqft_lot = '',
			-- bldg_type = '',
			-- image_first = '',
			-- description = ''
			
			set 
			-- below attributes are based on revenue range
			annual_cash_flow = v_annual_cash_flow,
			monthly_payroll_cost = v_monthly_payroll_cost,
			inventory_cost = v_inventory_cost,
			market_based_est = v_market_based_est,
			rev_monthly = v_rev_monthly,
			exp_monthly_rent = v_exp_monthly_rent,
			exp_monthly_material = v_exp_monthly_material,
			exp_monthly_emp = v_exp_monthly_emp,
			exp_monthly_utility = v_exp_monthly_utility,
			value_total_equipment = v_value_total_equipment,
			value_total_furniture = v_value_total_furniture,
			
            -- below attributes are based on employee range
			emp_FT_num = v_emp_FT_num,
			emp_PT_num = v_emp_PT_num,
           
            -- below attributes will be based on county population
			1mile_rad_popln = v_1mile_rad_popln,
			3mile_rad_popln = v_3mile_rad_popln,
			5mile_rad_popln = v_5mile_rad_popln,
			dailypeople_doorfront_num = v_dailypeople_doorfront_num,
			dailycar_parklot_num = v_dailycar_parklot_num,
            
			-- below attributes will come from data vendors
            area_crime_score = ROUND(FLOOR(RAND()*(80 - 30 + 1) + 30)),
			area_walk_score = ROUND(FLOOR(RAND()*(80 - 20 + 1) + 20)),
			area_transit_score = ROUND(FLOOR(RAND()*(80 - 20 + 1) + 20)),
			social_media_score = ROUND(FLOOR(RAND()*(80 - 30 + 1) + 30)),
			area_attractions_score = ROUND(FLOOR(RAND()*(80 - 20 + 1) + 20)),
			data_completeness_score = ROUND(FLOOR(RAND()*(70 - 40 + 1) + 40)),
			1mile_rad_incoscore = ROUND(FLOOR(RAND()*(80 - 40 + 1) + 40)),
            3mile_rad_incoscore = ROUND(FLOOR(RAND()*(80 - 40 + 1) + 40)),
            5mile_rad_incoscore = ROUND(FLOOR(RAND()*(80 - 40 + 1) + 40)),
            
            -- below attributes will be updated by users/user activity or by customers or business owners
            view_counter = 0,
			for_sell_YN = 'N',
			hidden_YN = 'N',
			for_sell_price = 0,
			total_debt = 0,
			ff_and_e = 0,
			brw_listing_number = 0,
			ebtda = 0,
			paid_listing_YN = 'N',
			asset_based_est = 0,
			income_based_est = 0,
            -- DO NOT UNCOMMENT market_based_est = 0,
            -- DO NOT UNCOMMENT image_first = '',
			image_logo = '',
			franchise_YN = 'N',
			owner_claim_YN = 'N',
			vendor_call_YN = 'N',
			estimate_done_YN = 'N',
			bldg_owned_YN = 'N',
			value_indoor_deco = 0,
			value_outdoor_deco = 0,
			year_equipment = 0,
			year_furniture = 0,
			year_outdoor_deco = 0,
            bvr_avg_sp = 0,
			factor = 0,
			
			-- audit columns
			createdby_user_id = 999,
			create_date = CURDATE(),
			updatedby_user_id = 9999,
			update_date = CURDATE()
			where 
			biz_id = v_biz_id;
    		
			select '**** DONE WITH UPDATE';
            
            -- reset all the variables
            set v_biz_id = 0;
			set v_state = '';
			set v_county = '';
			set v_vc_sales_range = '0';
			set v_vc_emp_range = '0';
            
            set v_county_pop_den = 0.0;
            
            set v_int_sales_range = 0;
			set v_sales_range_Plus50P = 0;
			set v_sales_range_Minus50P = 0;
            
            set v_int_emp_range = 0;
			set v_emp_range_Plus30P = 0;
			set v_emp_range_Minus30P = 0;
            
            set v_annual_cash_flow = 0;
			set v_monthly_payroll_cost = 0;
			set v_inventory_cost = 0;
			set v_market_based_est = 0;
			set v_rev_monthly = 0;
			set v_exp_monthly_rent = 0;
			set v_exp_monthly_material = 0;
			set v_exp_monthly_emp = 0;
			set v_exp_monthly_utility = 0;
			set v_value_total_equipment = 0;
			set v_value_total_furniture = 0;
            
            set v_emp_FT_num = 0;
			set v_emp_PT_num = 0;
            
            set v_1mile_rad_popln = 0;
			set v_3mile_rad_popln = 0;
			set v_5mile_rad_popln = 0;
			set v_dailypeople_doorfront_num = 0;
			set v_dailycar_parklot_num = 0;
			
    end loop all_records_Loop;
	close all_records_cursor;

    select 'UPDATED total records: '+v_count;
    -- **** END OF all_records_Loop LOOP ****** --
END