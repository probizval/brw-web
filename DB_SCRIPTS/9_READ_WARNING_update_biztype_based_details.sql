CREATE DEFINER=`admin`@`%` PROCEDURE `9_READ_WARNING_update_biztype_based_details`()
BEGIN
	-- WARNING - complete below 2 pre-steps
    -- 1. Find out how many biz type are MISC 
    -- select count(*) from t_brw_business where type = 'BTYPE_MISC';
    
	-- 2. Update the Biz Type with SIC Code to BRW Biz Type mapping tables and spread sheets
    
    -- This SP is to update some of the bizness details as listed below in update statement
    -- declare an array with various business tyeps - this is achieved using temp tables in mysql
    -- CREATE TEMPORARY TABLE t_brw_temp_types SELECT type FROM t_brw_business_type_def;
    -- call 9_READ_WARNING_update_biztype_based_details();
    
    DECLARE cur_done INT DEFAULT 0;
	declare v_count int(10) DEFAULT 0;
	
	declare v_ran_num_1 int(2) DEFAULT 1;
	declare v_ran_num_2 int(2) DEFAULT 1;
	declare v_ran_num_3 int(2) DEFAULT 1;
	declare v_ran_num_4 int(2) DEFAULT 1;
	declare v_ran_num_5 int(2) DEFAULT 1;
    
    declare v_biz_id int(10) DEFAULT 0;
    declare v_biz_type varchar(45) DEFAULT '';
    declare v_state varchar(45) DEFAULT '';
    declare v_county varchar(45) DEFAULT '';
    
    declare v_naics_num int(10) DEFAULT 0;
	declare v_naics_description varchar(45) DEFAULT '';
	declare v_sqft_indoor int(10) DEFAULT 0;
	declare v_sqft_outdoor int(10) DEFAULT 0;
	declare v_sqft_lot int(10) DEFAULT 0;
	declare v_bldg_type varchar(500) DEFAULT '';
	declare v_image_first varchar(500) DEFAULT '';
	declare v_description varchar(45) DEFAULT '';
    
	-- declare cursor to pull all records from BIZ table
    declare all_records_cursor cursor for select biz_id, type  
	from t_brw_business 
    where 
    -- updatedby_user_id != 9999;
    biz_id in(18796151, 18796263, 18796269);
    -- biz_id = 8796269;
    -- for validation run below sql
	-- select biz_id, type, sales_range, market_based_est where bizId in (18796269, 18796263, 18796151);
        
	DECLARE CONTINUE HANDLER FOR NOT FOUND SET cur_done = 1;

    open all_records_cursor;
    all_records_Loop: loop fetch all_records_cursor into v_biz_id, v_biz_type;
    
		set v_count = v_count + 1;
		select 'INSIDE all_records_Loop v_count: '+v_count;
        
        IF v_biz_id = 0 THEN
			select '***** EXITING all_records_Loop *****';
			LEAVE all_records_Loop;
		END IF;
        
		select '**** v_biz_id: '+v_biz_id;
		
		set v_ran_num_1 = RAND() * (10 - 1 + 1) + 1;
		set v_ran_num_2 = RAND() * (10 - 1 + 1) + 1;
		set v_ran_num_3 = RAND() * (10 - 1 + 1) + 1;
		set v_ran_num_4 = RAND() * (10 - 1 + 1) + 1;
		set v_ran_num_5 = RAND() * (10 - 1 + 1) + 1;
		
		IF v_biz_type = 'BTYPE_MISC' THEN
			select '**** INSIDE TYPE - BTYPE_MISC';
			set v_naics_num = 0000;
			
			set v_naics_description = 'Not Available';
			
			set v_sqft_indoor = ROUND(FLOOR(RAND() * (5000 - 2000 + 1) + 2000), - 1);
			
			set v_sqft_outdoor = ROUND(FLOOR(RAND() * (5000 - 2000 + 1) + 2000), - 1);
			
			set v_sqft_lot = ROUND(FLOOR(RAND() * (15000 - 5000 + 1) + 5000), - 1);
			
			-- to decide building type
			if v_ran_num_1 %2 then
				if v_ran_num_4 %2 then
					set v_bldg_type = 'FREE_STANDING';
				end if;
				if v_ran_num_5 %2 then
					set v_bldg_type = 'MULTI_UNIT';
				end if;
			end if;
			if v_ran_num_2 %2 then
				if v_ran_num_4 %2 then
					set v_bldg_type = 'SPECIAL_PURPOSE';
				end if;
				if v_ran_num_5 %2 then
					set v_bldg_type = 'MULTI_PURPOSE';
				end if;
			end if;
			if v_ran_num_3 %2 then
				if v_ran_num_4 %2 then
					set v_bldg_type = 'OFFICE';
				end if;
				if v_ran_num_5 %2 then
					set v_bldg_type = 'NOT_AVAILABLE';
				end if;
			end if;
			
			-- to decide first image
			if v_ran_num_1 %2 then
				if v_ran_num_4 %2 then
					set v_image_first = '';
				end if;
				if v_ran_num_5 %2 then
					set v_image_first = '';
				end if;
			end if;
			if v_ran_num_2 %2 then
				if v_ran_num_4 %2 then
					set v_image_first = '';
				end if;
				if v_ran_num_5 %2 then
					set v_image_first = '';
				end if;
			end if;
			if v_ran_num_3 %2 then
				if v_ran_num_4 %2 then
					set v_image_first = '';
				end if;
				if v_ran_num_5 %2 then
					set v_image_first = '';
				end if;
			end if;
			
			set v_description = '<P>As per the information we have this business type is undetermined.&ast;</P><P>But we are sure this is yet another impressive business that has great potential and is worth significant.</P><P>If you are the owner or authorized person to update this business related information. Please claim the business by clicking "Claim Business" button. You can also report any issues regarding this business listing by sending an email to admin@bizrealworth.com or calling to 1-855-5-CALL-RW (1-855-522-5579)</P><P>&ast; We gather and process data provided by multiple sources, it may be outdated or inaccurate.</P>';
		END IF;
        
		IF v_biz_type = 'BTYPE_MISC' THEN
			select '**** INSIDE TYPE - BTYPE_MISC';
			set v_naics_num = 0000;
			
			set v_naics_description = 'Not Available';
			
			set v_sqft_indoor = ROUND(FLOOR(RAND() * (5000 - 2000 + 1) + 2000), - 1);
			
			set v_sqft_outdoor = ROUND(FLOOR(RAND() * (5000 - 2000 + 1) + 2000), - 1);
			
			set v_sqft_lot = ROUND(FLOOR(RAND() * (15000 - 5000 + 1) + 5000), - 1);
			
			-- to decide building type
			if v_ran_num_1 %2 then
				if v_ran_num_4 %2 then
					set v_bldg_type = 'FREE_STANDING';
				end if;
				if v_ran_num_5 %2 then
					set v_bldg_type = 'MULTI_UNIT';
				end if;
			end if;
			if v_ran_num_2 %2 then
				if v_ran_num_4 %2 then
					set v_bldg_type = 'SPECIAL_PURPOSE';
				end if;
				if v_ran_num_5 %2 then
					set v_bldg_type = 'MULTI_PURPOSE';
				end if;
			end if;
			if v_ran_num_3 %2 then
				if v_ran_num_4 %2 then
					set v_bldg_type = 'OFFICE';
				end if;
				if v_ran_num_5 %2 then
					set v_bldg_type = 'NOT_AVAILABLE';
				end if;
			end if;
			
			-- to decide first image
			if v_ran_num_1 %2 then
				if v_ran_num_4 %2 then
					set v_image_first = '';
				end if;
				if v_ran_num_5 %2 then
					set v_image_first = '';
				end if;
			end if;
			if v_ran_num_2 %2 then
				if v_ran_num_4 %2 then
					set v_image_first = '';
				end if;
				if v_ran_num_5 %2 then
					set v_image_first = '';
				end if;
			end if;
			if v_ran_num_3 %2 then
				if v_ran_num_4 %2 then
					set v_image_first = '';
				end if;
				if v_ran_num_5 %2 then
					set v_image_first = '';
				end if;
			end if;
			
			set v_description = '<P>As per the information we have this business type is undetermined.&ast;</P><P>But we are sure this is yet another impressive business that has great potential and is worth significant.</P><P>If you are the owner or authorized person to update this business related information. Please claim the business by clicking "Claim Business" button. You can also report any issues regarding this business listing by sending an email to admin@bizrealworth.com or calling to 1-855-5-CALL-RW (1-855-522-5579)</P><P>&ast; We gather and process data provided by multiple sources, it may be outdated or inaccurate.</P>';
		END IF;	
		IF v_biz_type = 'BTYPE_MISC' THEN
			select '**** INSIDE TYPE - BTYPE_MISC';
			set v_naics_num = 0000;
			
			set v_naics_description = 'Not Available';
			
			set v_sqft_indoor = ROUND(FLOOR(RAND() * (5000 - 2000 + 1) + 2000), - 1);
			
			set v_sqft_outdoor = ROUND(FLOOR(RAND() * (5000 - 2000 + 1) + 2000), - 1);
			
			set v_sqft_lot = ROUND(FLOOR(RAND() * (15000 - 5000 + 1) + 5000), - 1);
			
			-- to decide building type
			if v_ran_num_1 %2 then
				if v_ran_num_4 %2 then
					set v_bldg_type = 'FREE_STANDING';
				end if;
				if v_ran_num_5 %2 then
					set v_bldg_type = 'MULTI_UNIT';
				end if;
			end if;
			if v_ran_num_2 %2 then
				if v_ran_num_4 %2 then
					set v_bldg_type = 'SPECIAL_PURPOSE';
				end if;
				if v_ran_num_5 %2 then
					set v_bldg_type = 'MULTI_PURPOSE';
				end if;
			end if;
			if v_ran_num_3 %2 then
				if v_ran_num_4 %2 then
					set v_bldg_type = 'OFFICE';
				end if;
				if v_ran_num_5 %2 then
					set v_bldg_type = 'NOT_AVAILABLE';
				end if;
			end if;
			
			-- to decide first image
			if v_ran_num_1 %2 then
				if v_ran_num_4 %2 then
					set v_image_first = '';
				end if;
				if v_ran_num_5 %2 then
					set v_image_first = '';
				end if;
			end if;
			if v_ran_num_2 %2 then
				if v_ran_num_4 %2 then
					set v_image_first = '';
				end if;
				if v_ran_num_5 %2 then
					set v_image_first = '';
				end if;
			end if;
			if v_ran_num_3 %2 then
				if v_ran_num_4 %2 then
					set v_image_first = '';
				end if;
				if v_ran_num_5 %2 then
					set v_image_first = '';
				end if;
			end if;
			
			set v_description = '<P>As per the information we have this business type is undetermined.&ast;</P><P>But we are sure this is yet another impressive business that has great potential and is worth significant.</P><P>If you are the owner or authorized person to update this business related information. Please claim the business by clicking "Claim Business" button. You can also report any issues regarding this business listing by sending an email to admin@bizrealworth.com or calling to 1-855-5-CALL-RW (1-855-522-5579)</P><P>&ast; We gather and process data provided by multiple sources, it may be outdated or inaccurate.</P>';
		END IF;	
		IF v_biz_type = 'BTYPE_MISC' THEN
			select '**** INSIDE TYPE - BTYPE_MISC';
			set v_naics_num = 0000;
			
			set v_naics_description = 'Not Available';
			
			set v_sqft_indoor = ROUND(FLOOR(RAND() * (5000 - 2000 + 1) + 2000), - 1);
			
			set v_sqft_outdoor = ROUND(FLOOR(RAND() * (5000 - 2000 + 1) + 2000), - 1);
			
			set v_sqft_lot = ROUND(FLOOR(RAND() * (15000 - 5000 + 1) + 5000), - 1);
			
			-- to decide building type
			if v_ran_num_1 %2 then
				if v_ran_num_4 %2 then
					set v_bldg_type = 'FREE_STANDING';
				end if;
				if v_ran_num_5 %2 then
					set v_bldg_type = 'MULTI_UNIT';
				end if;
			end if;
			if v_ran_num_2 %2 then
				if v_ran_num_4 %2 then
					set v_bldg_type = 'SPECIAL_PURPOSE';
				end if;
				if v_ran_num_5 %2 then
					set v_bldg_type = 'MULTI_PURPOSE';
				end if;
			end if;
			if v_ran_num_3 %2 then
				if v_ran_num_4 %2 then
					set v_bldg_type = 'OFFICE';
				end if;
				if v_ran_num_5 %2 then
					set v_bldg_type = 'NOT_AVAILABLE';
				end if;
			end if;
			
			-- to decide first image
			if v_ran_num_1 %2 then
				if v_ran_num_4 %2 then
					set v_image_first = '';
				end if;
				if v_ran_num_5 %2 then
					set v_image_first = '';
				end if;
			end if;
			if v_ran_num_2 %2 then
				if v_ran_num_4 %2 then
					set v_image_first = '';
				end if;
				if v_ran_num_5 %2 then
					set v_image_first = '';
				end if;
			end if;
			if v_ran_num_3 %2 then
				if v_ran_num_4 %2 then
					set v_image_first = '';
				end if;
				if v_ran_num_5 %2 then
					set v_image_first = '';
				end if;
			end if;
			
			set v_description = '<P>As per the information we have this business type is undetermined.&ast;</P><P>But we are sure this is yet another impressive business that has great potential and is worth significant.</P><P>If you are the owner or authorized person to update this business related information. Please claim the business by clicking "Claim Business" button. You can also report any issues regarding this business listing by sending an email to admin@bizrealworth.com or calling to 1-855-5-CALL-RW (1-855-522-5579)</P><P>&ast; We gather and process data provided by multiple sources, it may be outdated or inaccurate.</P>';
		END IF;	
		IF v_biz_type = 'BTYPE_MISC' THEN
			select '**** INSIDE TYPE - BTYPE_MISC';
			set v_naics_num = 0000;
			
			set v_naics_description = 'Not Available';
			
			set v_sqft_indoor = ROUND(FLOOR(RAND() * (5000 - 2000 + 1) + 2000), - 1);
			
			set v_sqft_outdoor = ROUND(FLOOR(RAND() * (5000 - 2000 + 1) + 2000), - 1);
			
			set v_sqft_lot = ROUND(FLOOR(RAND() * (15000 - 5000 + 1) + 5000), - 1);
			
			-- to decide building type
			if v_ran_num_1 %2 then
				if v_ran_num_4 %2 then
					set v_bldg_type = 'FREE_STANDING';
				end if;
				if v_ran_num_5 %2 then
					set v_bldg_type = 'MULTI_UNIT';
				end if;
			end if;
			if v_ran_num_2 %2 then
				if v_ran_num_4 %2 then
					set v_bldg_type = 'SPECIAL_PURPOSE';
				end if;
				if v_ran_num_5 %2 then
					set v_bldg_type = 'MULTI_PURPOSE';
				end if;
			end if;
			if v_ran_num_3 %2 then
				if v_ran_num_4 %2 then
					set v_bldg_type = 'OFFICE';
				end if;
				if v_ran_num_5 %2 then
					set v_bldg_type = 'NOT_AVAILABLE';
				end if;
			end if;
			
			-- to decide first image
			if v_ran_num_1 %2 then
				if v_ran_num_4 %2 then
					set v_image_first = '';
				end if;
				if v_ran_num_5 %2 then
					set v_image_first = '';
				end if;
			end if;
			if v_ran_num_2 %2 then
				if v_ran_num_4 %2 then
					set v_image_first = '';
				end if;
				if v_ran_num_5 %2 then
					set v_image_first = '';
				end if;
			end if;
			if v_ran_num_3 %2 then
				if v_ran_num_4 %2 then
					set v_image_first = '';
				end if;
				if v_ran_num_5 %2 then
					set v_image_first = '';
				end if;
			end if;
			
			set v_description = '<P>As per the information we have this business type is undetermined.&ast;</P><P>But we are sure this is yet another impressive business that has great potential and is worth significant.</P><P>If you are the owner or authorized person to update this business related information. Please claim the business by clicking "Claim Business" button. You can also report any issues regarding this business listing by sending an email to admin@bizrealworth.com or calling to 1-855-5-CALL-RW (1-855-522-5579)</P><P>&ast; We gather and process data provided by multiple sources, it may be outdated or inaccurate.</P>';
		END IF;	
		IF v_biz_type = 'BTYPE_MISC' THEN
			select '**** INSIDE TYPE - BTYPE_MISC';
			set v_naics_num = 0000;
			
			set v_naics_description = 'Not Available';
			
			set v_sqft_indoor = ROUND(FLOOR(RAND() * (5000 - 2000 + 1) + 2000), - 1);
			
			set v_sqft_outdoor = ROUND(FLOOR(RAND() * (5000 - 2000 + 1) + 2000), - 1);
			
			set v_sqft_lot = ROUND(FLOOR(RAND() * (15000 - 5000 + 1) + 5000), - 1);
			
			-- to decide building type
			if v_ran_num_1 %2 then
				if v_ran_num_4 %2 then
					set v_bldg_type = 'FREE_STANDING';
				end if;
				if v_ran_num_5 %2 then
					set v_bldg_type = 'MULTI_UNIT';
				end if;
			end if;
			if v_ran_num_2 %2 then
				if v_ran_num_4 %2 then
					set v_bldg_type = 'SPECIAL_PURPOSE';
				end if;
				if v_ran_num_5 %2 then
					set v_bldg_type = 'MULTI_PURPOSE';
				end if;
			end if;
			if v_ran_num_3 %2 then
				if v_ran_num_4 %2 then
					set v_bldg_type = 'OFFICE';
				end if;
				if v_ran_num_5 %2 then
					set v_bldg_type = 'NOT_AVAILABLE';
				end if;
			end if;
			
			-- to decide first image
			if v_ran_num_1 %2 then
				if v_ran_num_4 %2 then
					set v_image_first = '';
				end if;
				if v_ran_num_5 %2 then
					set v_image_first = '';
				end if;
			end if;
			if v_ran_num_2 %2 then
				if v_ran_num_4 %2 then
					set v_image_first = '';
				end if;
				if v_ran_num_5 %2 then
					set v_image_first = '';
				end if;
			end if;
			if v_ran_num_3 %2 then
				if v_ran_num_4 %2 then
					set v_image_first = '';
				end if;
				if v_ran_num_5 %2 then
					set v_image_first = '';
				end if;
			end if;
			
			set v_description = '<P>As per the information we have this business type is undetermined.&ast;</P><P>But we are sure this is yet another impressive business that has great potential and is worth significant.</P><P>If you are the owner or authorized person to update this business related information. Please claim the business by clicking "Claim Business" button. You can also report any issues regarding this business listing by sending an email to admin@bizrealworth.com or calling to 1-855-5-CALL-RW (1-855-522-5579)</P><P>&ast; We gather and process data provided by multiple sources, it may be outdated or inaccurate.</P>';
		END IF;	
		IF v_biz_type = 'BTYPE_MISC' THEN
			select '**** INSIDE TYPE - BTYPE_MISC';
			set v_naics_num = 0000;
			
			set v_naics_description = 'Not Available';
			
			set v_sqft_indoor = ROUND(FLOOR(RAND() * (5000 - 2000 + 1) + 2000), - 1);
			
			set v_sqft_outdoor = ROUND(FLOOR(RAND() * (5000 - 2000 + 1) + 2000), - 1);
			
			set v_sqft_lot = ROUND(FLOOR(RAND() * (15000 - 5000 + 1) + 5000), - 1);
			
			-- to decide building type
			if v_ran_num_1 %2 then
				if v_ran_num_4 %2 then
					set v_bldg_type = 'FREE_STANDING';
				end if;
				if v_ran_num_5 %2 then
					set v_bldg_type = 'MULTI_UNIT';
				end if;
			end if;
			if v_ran_num_2 %2 then
				if v_ran_num_4 %2 then
					set v_bldg_type = 'SPECIAL_PURPOSE';
				end if;
				if v_ran_num_5 %2 then
					set v_bldg_type = 'MULTI_PURPOSE';
				end if;
			end if;
			if v_ran_num_3 %2 then
				if v_ran_num_4 %2 then
					set v_bldg_type = 'OFFICE';
				end if;
				if v_ran_num_5 %2 then
					set v_bldg_type = 'NOT_AVAILABLE';
				end if;
			end if;
			
			-- to decide first image
			if v_ran_num_1 %2 then
				if v_ran_num_4 %2 then
					set v_image_first = '';
				end if;
				if v_ran_num_5 %2 then
					set v_image_first = '';
				end if;
			end if;
			if v_ran_num_2 %2 then
				if v_ran_num_4 %2 then
					set v_image_first = '';
				end if;
				if v_ran_num_5 %2 then
					set v_image_first = '';
				end if;
			end if;
			if v_ran_num_3 %2 then
				if v_ran_num_4 %2 then
					set v_image_first = '';
				end if;
				if v_ran_num_5 %2 then
					set v_image_first = '';
				end if;
			end if;
			
			set v_description = '<P>As per the information we have this business type is undetermined.&ast;</P><P>But we are sure this is yet another impressive business that has great potential and is worth significant.</P><P>If you are the owner or authorized person to update this business related information. Please claim the business by clicking "Claim Business" button. You can also report any issues regarding this business listing by sending an email to admin@bizrealworth.com or calling to 1-855-5-CALL-RW (1-855-522-5579)</P><P>&ast; We gather and process data provided by multiple sources, it may be outdated or inaccurate.</P>';
		END IF;	
		IF v_biz_type = 'BTYPE_MISC' THEN
			select '**** INSIDE TYPE - BTYPE_MISC';
			set v_naics_num = 0000;
			
			set v_naics_description = 'Not Available';
			
			set v_sqft_indoor = ROUND(FLOOR(RAND() * (5000 - 2000 + 1) + 2000), - 1);
			
			set v_sqft_outdoor = ROUND(FLOOR(RAND() * (5000 - 2000 + 1) + 2000), - 1);
			
			set v_sqft_lot = ROUND(FLOOR(RAND() * (15000 - 5000 + 1) + 5000), - 1);
			
			-- to decide building type
			if v_ran_num_1 %2 then
				if v_ran_num_4 %2 then
					set v_bldg_type = 'FREE_STANDING';
				end if;
				if v_ran_num_5 %2 then
					set v_bldg_type = 'MULTI_UNIT';
				end if;
			end if;
			if v_ran_num_2 %2 then
				if v_ran_num_4 %2 then
					set v_bldg_type = 'SPECIAL_PURPOSE';
				end if;
				if v_ran_num_5 %2 then
					set v_bldg_type = 'MULTI_PURPOSE';
				end if;
			end if;
			if v_ran_num_3 %2 then
				if v_ran_num_4 %2 then
					set v_bldg_type = 'OFFICE';
				end if;
				if v_ran_num_5 %2 then
					set v_bldg_type = 'NOT_AVAILABLE';
				end if;
			end if;
			
			-- to decide first image
			if v_ran_num_1 %2 then
				if v_ran_num_4 %2 then
					set v_image_first = '';
				end if;
				if v_ran_num_5 %2 then
					set v_image_first = '';
				end if;
			end if;
			if v_ran_num_2 %2 then
				if v_ran_num_4 %2 then
					set v_image_first = '';
				end if;
				if v_ran_num_5 %2 then
					set v_image_first = '';
				end if;
			end if;
			if v_ran_num_3 %2 then
				if v_ran_num_4 %2 then
					set v_image_first = '';
				end if;
				if v_ran_num_5 %2 then
					set v_image_first = '';
				end if;
			end if;
			
			set v_description = '<P>As per the information we have this business type is undetermined.&ast;</P><P>But we are sure this is yet another impressive business that has great potential and is worth significant.</P><P>If you are the owner or authorized person to update this business related information. Please claim the business by clicking "Claim Business" button. You can also report any issues regarding this business listing by sending an email to admin@bizrealworth.com or calling to 1-855-5-CALL-RW (1-855-522-5579)</P><P>&ast; We gather and process data provided by multiple sources, it may be outdated or inaccurate.</P>';
		END IF;	
		IF v_biz_type = 'BTYPE_MISC' THEN
			select '**** INSIDE TYPE - BTYPE_MISC';
			set v_naics_num = 0000;
			
			set v_naics_description = 'Not Available';
			
			set v_sqft_indoor = ROUND(FLOOR(RAND() * (5000 - 2000 + 1) + 2000), - 1);
			
			set v_sqft_outdoor = ROUND(FLOOR(RAND() * (5000 - 2000 + 1) + 2000), - 1);
			
			set v_sqft_lot = ROUND(FLOOR(RAND() * (15000 - 5000 + 1) + 5000), - 1);
			
			-- to decide building type
			if v_ran_num_1 %2 then
				if v_ran_num_4 %2 then
					set v_bldg_type = 'FREE_STANDING';
				end if;
				if v_ran_num_5 %2 then
					set v_bldg_type = 'MULTI_UNIT';
				end if;
			end if;
			if v_ran_num_2 %2 then
				if v_ran_num_4 %2 then
					set v_bldg_type = 'SPECIAL_PURPOSE';
				end if;
				if v_ran_num_5 %2 then
					set v_bldg_type = 'MULTI_PURPOSE';
				end if;
			end if;
			if v_ran_num_3 %2 then
				if v_ran_num_4 %2 then
					set v_bldg_type = 'OFFICE';
				end if;
				if v_ran_num_5 %2 then
					set v_bldg_type = 'NOT_AVAILABLE';
				end if;
			end if;
			
			-- to decide first image
			if v_ran_num_1 %2 then
				if v_ran_num_4 %2 then
					set v_image_first = '';
				end if;
				if v_ran_num_5 %2 then
					set v_image_first = '';
				end if;
			end if;
			if v_ran_num_2 %2 then
				if v_ran_num_4 %2 then
					set v_image_first = '';
				end if;
				if v_ran_num_5 %2 then
					set v_image_first = '';
				end if;
			end if;
			if v_ran_num_3 %2 then
				if v_ran_num_4 %2 then
					set v_image_first = '';
				end if;
				if v_ran_num_5 %2 then
					set v_image_first = '';
				end if;
			end if;
			
			set v_description = '<P>As per the information we have this business type is undetermined.&ast;</P><P>But we are sure this is yet another impressive business that has great potential and is worth significant.</P><P>If you are the owner or authorized person to update this business related information. Please claim the business by clicking "Claim Business" button. You can also report any issues regarding this business listing by sending an email to admin@bizrealworth.com or calling to 1-855-5-CALL-RW (1-855-522-5579)</P><P>&ast; We gather and process data provided by multiple sources, it may be outdated or inaccurate.</P>';
		END IF;	
		IF v_biz_type = 'BTYPE_MISC' THEN
			select '**** INSIDE TYPE - BTYPE_MISC';
			set v_naics_num = 0000;
			
			set v_naics_description = 'Not Available';
			
			set v_sqft_indoor = ROUND(FLOOR(RAND() * (5000 - 2000 + 1) + 2000), - 1);
			
			set v_sqft_outdoor = ROUND(FLOOR(RAND() * (5000 - 2000 + 1) + 2000), - 1);
			
			set v_sqft_lot = ROUND(FLOOR(RAND() * (15000 - 5000 + 1) + 5000), - 1);
			
			-- to decide building type
			if v_ran_num_1 %2 then
				if v_ran_num_4 %2 then
					set v_bldg_type = 'FREE_STANDING';
				end if;
				if v_ran_num_5 %2 then
					set v_bldg_type = 'MULTI_UNIT';
				end if;
			end if;
			if v_ran_num_2 %2 then
				if v_ran_num_4 %2 then
					set v_bldg_type = 'SPECIAL_PURPOSE';
				end if;
				if v_ran_num_5 %2 then
					set v_bldg_type = 'MULTI_PURPOSE';
				end if;
			end if;
			if v_ran_num_3 %2 then
				if v_ran_num_4 %2 then
					set v_bldg_type = 'OFFICE';
				end if;
				if v_ran_num_5 %2 then
					set v_bldg_type = 'NOT_AVAILABLE';
				end if;
			end if;
			
			-- to decide first image
			if v_ran_num_1 %2 then
				if v_ran_num_4 %2 then
					set v_image_first = '';
				end if;
				if v_ran_num_5 %2 then
					set v_image_first = '';
				end if;
			end if;
			if v_ran_num_2 %2 then
				if v_ran_num_4 %2 then
					set v_image_first = '';
				end if;
				if v_ran_num_5 %2 then
					set v_image_first = '';
				end if;
			end if;
			if v_ran_num_3 %2 then
				if v_ran_num_4 %2 then
					set v_image_first = '';
				end if;
				if v_ran_num_5 %2 then
					set v_image_first = '';
				end if;
			end if;
			
			set v_description = '<P>As per the information we have this business type is undetermined.&ast;</P><P>But we are sure this is yet another impressive business that has great potential and is worth significant.</P><P>If you are the owner or authorized person to update this business related information. Please claim the business by clicking "Claim Business" button. You can also report any issues regarding this business listing by sending an email to admin@bizrealworth.com or calling to 1-855-5-CALL-RW (1-855-522-5579)</P><P>&ast; We gather and process data provided by multiple sources, it may be outdated or inaccurate.</P>';
		END IF;	
		IF v_biz_type = 'BTYPE_MISC' THEN
			select '**** INSIDE TYPE - BTYPE_MISC';
			set v_naics_num = 0000;
			
			set v_naics_description = 'Not Available';
			
			set v_sqft_indoor = ROUND(FLOOR(RAND() * (5000 - 2000 + 1) + 2000), - 1);
			
			set v_sqft_outdoor = ROUND(FLOOR(RAND() * (5000 - 2000 + 1) + 2000), - 1);
			
			set v_sqft_lot = ROUND(FLOOR(RAND() * (15000 - 5000 + 1) + 5000), - 1);
			
			-- to decide building type
			if v_ran_num_1 %2 then
				if v_ran_num_4 %2 then
					set v_bldg_type = 'FREE_STANDING';
				end if;
				if v_ran_num_5 %2 then
					set v_bldg_type = 'MULTI_UNIT';
				end if;
			end if;
			if v_ran_num_2 %2 then
				if v_ran_num_4 %2 then
					set v_bldg_type = 'SPECIAL_PURPOSE';
				end if;
				if v_ran_num_5 %2 then
					set v_bldg_type = 'MULTI_PURPOSE';
				end if;
			end if;
			if v_ran_num_3 %2 then
				if v_ran_num_4 %2 then
					set v_bldg_type = 'OFFICE';
				end if;
				if v_ran_num_5 %2 then
					set v_bldg_type = 'NOT_AVAILABLE';
				end if;
			end if;
			
			-- to decide first image
			if v_ran_num_1 %2 then
				if v_ran_num_4 %2 then
					set v_image_first = '';
				end if;
				if v_ran_num_5 %2 then
					set v_image_first = '';
				end if;
			end if;
			if v_ran_num_2 %2 then
				if v_ran_num_4 %2 then
					set v_image_first = '';
				end if;
				if v_ran_num_5 %2 then
					set v_image_first = '';
				end if;
			end if;
			if v_ran_num_3 %2 then
				if v_ran_num_4 %2 then
					set v_image_first = '';
				end if;
				if v_ran_num_5 %2 then
					set v_image_first = '';
				end if;
			end if;
			
			set v_description = '<P>As per the information we have this business type is undetermined.&ast;</P><P>But we are sure this is yet another impressive business that has great potential and is worth significant.</P><P>If you are the owner or authorized person to update this business related information. Please claim the business by clicking "Claim Business" button. You can also report any issues regarding this business listing by sending an email to admin@bizrealworth.com or calling to 1-855-5-CALL-RW (1-855-522-5579)</P><P>&ast; We gather and process data provided by multiple sources, it may be outdated or inaccurate.</P>';
		END IF;	
		IF v_biz_type = 'BTYPE_MISC' THEN
			select '**** INSIDE TYPE - BTYPE_MISC';
			set v_naics_num = 0000;
			
			set v_naics_description = 'Not Available';
			
			set v_sqft_indoor = ROUND(FLOOR(RAND() * (5000 - 2000 + 1) + 2000), - 1);
			
			set v_sqft_outdoor = ROUND(FLOOR(RAND() * (5000 - 2000 + 1) + 2000), - 1);
			
			set v_sqft_lot = ROUND(FLOOR(RAND() * (15000 - 5000 + 1) + 5000), - 1);
			
			-- to decide building type
			if v_ran_num_1 %2 then
				if v_ran_num_4 %2 then
					set v_bldg_type = 'FREE_STANDING';
				end if;
				if v_ran_num_5 %2 then
					set v_bldg_type = 'MULTI_UNIT';
				end if;
			end if;
			if v_ran_num_2 %2 then
				if v_ran_num_4 %2 then
					set v_bldg_type = 'SPECIAL_PURPOSE';
				end if;
				if v_ran_num_5 %2 then
					set v_bldg_type = 'MULTI_PURPOSE';
				end if;
			end if;
			if v_ran_num_3 %2 then
				if v_ran_num_4 %2 then
					set v_bldg_type = 'OFFICE';
				end if;
				if v_ran_num_5 %2 then
					set v_bldg_type = 'NOT_AVAILABLE';
				end if;
			end if;
			
			-- to decide first image
			if v_ran_num_1 %2 then
				if v_ran_num_4 %2 then
					set v_image_first = '';
				end if;
				if v_ran_num_5 %2 then
					set v_image_first = '';
				end if;
			end if;
			if v_ran_num_2 %2 then
				if v_ran_num_4 %2 then
					set v_image_first = '';
				end if;
				if v_ran_num_5 %2 then
					set v_image_first = '';
				end if;
			end if;
			if v_ran_num_3 %2 then
				if v_ran_num_4 %2 then
					set v_image_first = '';
				end if;
				if v_ran_num_5 %2 then
					set v_image_first = '';
				end if;
			end if;
			
			set v_description = '<P>As per the information we have this business type is undetermined.&ast;</P><P>But we are sure this is yet another impressive business that has great potential and is worth significant.</P><P>If you are the owner or authorized person to update this business related information. Please claim the business by clicking "Claim Business" button. You can also report any issues regarding this business listing by sending an email to admin@bizrealworth.com or calling to 1-855-5-CALL-RW (1-855-522-5579)</P><P>&ast; We gather and process data provided by multiple sources, it may be outdated or inaccurate.</P>';
		END IF;	
		IF v_biz_type = 'BTYPE_MISC' THEN
			select '**** INSIDE TYPE - BTYPE_MISC';
			set v_naics_num = 0000;
			
			set v_naics_description = 'Not Available';
			
			set v_sqft_indoor = ROUND(FLOOR(RAND() * (5000 - 2000 + 1) + 2000), - 1);
			
			set v_sqft_outdoor = ROUND(FLOOR(RAND() * (5000 - 2000 + 1) + 2000), - 1);
			
			set v_sqft_lot = ROUND(FLOOR(RAND() * (15000 - 5000 + 1) + 5000), - 1);
			
			-- to decide building type
			if v_ran_num_1 %2 then
				if v_ran_num_4 %2 then
					set v_bldg_type = 'FREE_STANDING';
				end if;
				if v_ran_num_5 %2 then
					set v_bldg_type = 'MULTI_UNIT';
				end if;
			end if;
			if v_ran_num_2 %2 then
				if v_ran_num_4 %2 then
					set v_bldg_type = 'SPECIAL_PURPOSE';
				end if;
				if v_ran_num_5 %2 then
					set v_bldg_type = 'MULTI_PURPOSE';
				end if;
			end if;
			if v_ran_num_3 %2 then
				if v_ran_num_4 %2 then
					set v_bldg_type = 'OFFICE';
				end if;
				if v_ran_num_5 %2 then
					set v_bldg_type = 'NOT_AVAILABLE';
				end if;
			end if;
			
			-- to decide first image
			if v_ran_num_1 %2 then
				if v_ran_num_4 %2 then
					set v_image_first = '';
				end if;
				if v_ran_num_5 %2 then
					set v_image_first = '';
				end if;
			end if;
			if v_ran_num_2 %2 then
				if v_ran_num_4 %2 then
					set v_image_first = '';
				end if;
				if v_ran_num_5 %2 then
					set v_image_first = '';
				end if;
			end if;
			if v_ran_num_3 %2 then
				if v_ran_num_4 %2 then
					set v_image_first = '';
				end if;
				if v_ran_num_5 %2 then
					set v_image_first = '';
				end if;
			end if;
			
			set v_description = '<P>As per the information we have this business type is undetermined.&ast;</P><P>But we are sure this is yet another impressive business that has great potential and is worth significant.</P><P>If you are the owner or authorized person to update this business related information. Please claim the business by clicking "Claim Business" button. You can also report any issues regarding this business listing by sending an email to admin@bizrealworth.com or calling to 1-855-5-CALL-RW (1-855-522-5579)</P><P>&ast; We gather and process data provided by multiple sources, it may be outdated or inaccurate.</P>';
		END IF;	
		IF v_biz_type = 'BTYPE_MISC' THEN
			select '**** INSIDE TYPE - BTYPE_MISC';
			set v_naics_num = 0000;
			
			set v_naics_description = 'Not Available';
			
			set v_sqft_indoor = ROUND(FLOOR(RAND() * (5000 - 2000 + 1) + 2000), - 1);
			
			set v_sqft_outdoor = ROUND(FLOOR(RAND() * (5000 - 2000 + 1) + 2000), - 1);
			
			set v_sqft_lot = ROUND(FLOOR(RAND() * (15000 - 5000 + 1) + 5000), - 1);
			
			-- to decide building type
			if v_ran_num_1 %2 then
				if v_ran_num_4 %2 then
					set v_bldg_type = 'FREE_STANDING';
				end if;
				if v_ran_num_5 %2 then
					set v_bldg_type = 'MULTI_UNIT';
				end if;
			end if;
			if v_ran_num_2 %2 then
				if v_ran_num_4 %2 then
					set v_bldg_type = 'SPECIAL_PURPOSE';
				end if;
				if v_ran_num_5 %2 then
					set v_bldg_type = 'MULTI_PURPOSE';
				end if;
			end if;
			if v_ran_num_3 %2 then
				if v_ran_num_4 %2 then
					set v_bldg_type = 'OFFICE';
				end if;
				if v_ran_num_5 %2 then
					set v_bldg_type = 'NOT_AVAILABLE';
				end if;
			end if;
			
			-- to decide first image
			if v_ran_num_1 %2 then
				if v_ran_num_4 %2 then
					set v_image_first = '';
				end if;
				if v_ran_num_5 %2 then
					set v_image_first = '';
				end if;
			end if;
			if v_ran_num_2 %2 then
				if v_ran_num_4 %2 then
					set v_image_first = '';
				end if;
				if v_ran_num_5 %2 then
					set v_image_first = '';
				end if;
			end if;
			if v_ran_num_3 %2 then
				if v_ran_num_4 %2 then
					set v_image_first = '';
				end if;
				if v_ran_num_5 %2 then
					set v_image_first = '';
				end if;
			end if;
			
			set v_description = '<P>As per the information we have this business type is undetermined.&ast;</P><P>But we are sure this is yet another impressive business that has great potential and is worth significant.</P><P>If you are the owner or authorized person to update this business related information. Please claim the business by clicking "Claim Business" button. You can also report any issues regarding this business listing by sending an email to admin@bizrealworth.com or calling to 1-855-5-CALL-RW (1-855-522-5579)</P><P>&ast; We gather and process data provided by multiple sources, it may be outdated or inaccurate.</P>';
		END IF;	
		IF v_biz_type = 'BTYPE_MISC' THEN
			select '**** INSIDE TYPE - BTYPE_MISC';
			set v_naics_num = 0000;
			
			set v_naics_description = 'Not Available';
			
			set v_sqft_indoor = ROUND(FLOOR(RAND() * (5000 - 2000 + 1) + 2000), - 1);
			
			set v_sqft_outdoor = ROUND(FLOOR(RAND() * (5000 - 2000 + 1) + 2000), - 1);
			
			set v_sqft_lot = ROUND(FLOOR(RAND() * (15000 - 5000 + 1) + 5000), - 1);
			
			-- to decide building type
			if v_ran_num_1 %2 then
				if v_ran_num_4 %2 then
					set v_bldg_type = 'FREE_STANDING';
				end if;
				if v_ran_num_5 %2 then
					set v_bldg_type = 'MULTI_UNIT';
				end if;
			end if;
			if v_ran_num_2 %2 then
				if v_ran_num_4 %2 then
					set v_bldg_type = 'SPECIAL_PURPOSE';
				end if;
				if v_ran_num_5 %2 then
					set v_bldg_type = 'MULTI_PURPOSE';
				end if;
			end if;
			if v_ran_num_3 %2 then
				if v_ran_num_4 %2 then
					set v_bldg_type = 'OFFICE';
				end if;
				if v_ran_num_5 %2 then
					set v_bldg_type = 'NOT_AVAILABLE';
				end if;
			end if;
			
			-- to decide first image
			if v_ran_num_1 %2 then
				if v_ran_num_4 %2 then
					set v_image_first = '';
				end if;
				if v_ran_num_5 %2 then
					set v_image_first = '';
				end if;
			end if;
			if v_ran_num_2 %2 then
				if v_ran_num_4 %2 then
					set v_image_first = '';
				end if;
				if v_ran_num_5 %2 then
					set v_image_first = '';
				end if;
			end if;
			if v_ran_num_3 %2 then
				if v_ran_num_4 %2 then
					set v_image_first = '';
				end if;
				if v_ran_num_5 %2 then
					set v_image_first = '';
				end if;
			end if;
			
			set v_description = '<P>As per the information we have this business type is undetermined.&ast;</P><P>But we are sure this is yet another impressive business that has great potential and is worth significant.</P><P>If you are the owner or authorized person to update this business related information. Please claim the business by clicking "Claim Business" button. You can also report any issues regarding this business listing by sending an email to admin@bizrealworth.com or calling to 1-855-5-CALL-RW (1-855-522-5579)</P><P>&ast; We gather and process data provided by multiple sources, it may be outdated or inaccurate.</P>';
		END IF;	
		IF v_biz_type = 'BTYPE_MISC' THEN
			select '**** INSIDE TYPE - BTYPE_MISC';
			set v_naics_num = 0000;
			
			set v_naics_description = 'Not Available';
			
			set v_sqft_indoor = ROUND(FLOOR(RAND() * (5000 - 2000 + 1) + 2000), - 1);
			
			set v_sqft_outdoor = ROUND(FLOOR(RAND() * (5000 - 2000 + 1) + 2000), - 1);
			
			set v_sqft_lot = ROUND(FLOOR(RAND() * (15000 - 5000 + 1) + 5000), - 1);
			
			-- to decide building type
			if v_ran_num_1 %2 then
				if v_ran_num_4 %2 then
					set v_bldg_type = 'FREE_STANDING';
				end if;
				if v_ran_num_5 %2 then
					set v_bldg_type = 'MULTI_UNIT';
				end if;
			end if;
			if v_ran_num_2 %2 then
				if v_ran_num_4 %2 then
					set v_bldg_type = 'SPECIAL_PURPOSE';
				end if;
				if v_ran_num_5 %2 then
					set v_bldg_type = 'MULTI_PURPOSE';
				end if;
			end if;
			if v_ran_num_3 %2 then
				if v_ran_num_4 %2 then
					set v_bldg_type = 'OFFICE';
				end if;
				if v_ran_num_5 %2 then
					set v_bldg_type = 'NOT_AVAILABLE';
				end if;
			end if;
			
			-- to decide first image
			if v_ran_num_1 %2 then
				if v_ran_num_4 %2 then
					set v_image_first = '';
				end if;
				if v_ran_num_5 %2 then
					set v_image_first = '';
				end if;
			end if;
			if v_ran_num_2 %2 then
				if v_ran_num_4 %2 then
					set v_image_first = '';
				end if;
				if v_ran_num_5 %2 then
					set v_image_first = '';
				end if;
			end if;
			if v_ran_num_3 %2 then
				if v_ran_num_4 %2 then
					set v_image_first = '';
				end if;
				if v_ran_num_5 %2 then
					set v_image_first = '';
				end if;
			end if;
			
			set v_description = '<P>As per the information we have this business type is undetermined.&ast;</P><P>But we are sure this is yet another impressive business that has great potential and is worth significant.</P><P>If you are the owner or authorized person to update this business related information. Please claim the business by clicking "Claim Business" button. You can also report any issues regarding this business listing by sending an email to admin@bizrealworth.com or calling to 1-855-5-CALL-RW (1-855-522-5579)</P><P>&ast; We gather and process data provided by multiple sources, it may be outdated or inaccurate.</P>';
		END IF;	
		IF v_biz_type = 'BTYPE_MISC' THEN
			select '**** INSIDE TYPE - BTYPE_MISC';
			set v_naics_num = 0000;
			
			set v_naics_description = 'Not Available';
			
			set v_sqft_indoor = ROUND(FLOOR(RAND() * (5000 - 2000 + 1) + 2000), - 1);
			
			set v_sqft_outdoor = ROUND(FLOOR(RAND() * (5000 - 2000 + 1) + 2000), - 1);
			
			set v_sqft_lot = ROUND(FLOOR(RAND() * (15000 - 5000 + 1) + 5000), - 1);
			
			-- to decide building type
			if v_ran_num_1 %2 then
				if v_ran_num_4 %2 then
					set v_bldg_type = 'FREE_STANDING';
				end if;
				if v_ran_num_5 %2 then
					set v_bldg_type = 'MULTI_UNIT';
				end if;
			end if;
			if v_ran_num_2 %2 then
				if v_ran_num_4 %2 then
					set v_bldg_type = 'SPECIAL_PURPOSE';
				end if;
				if v_ran_num_5 %2 then
					set v_bldg_type = 'MULTI_PURPOSE';
				end if;
			end if;
			if v_ran_num_3 %2 then
				if v_ran_num_4 %2 then
					set v_bldg_type = 'OFFICE';
				end if;
				if v_ran_num_5 %2 then
					set v_bldg_type = 'NOT_AVAILABLE';
				end if;
			end if;
			
			-- to decide first image
			if v_ran_num_1 %2 then
				if v_ran_num_4 %2 then
					set v_image_first = '';
				end if;
				if v_ran_num_5 %2 then
					set v_image_first = '';
				end if;
			end if;
			if v_ran_num_2 %2 then
				if v_ran_num_4 %2 then
					set v_image_first = '';
				end if;
				if v_ran_num_5 %2 then
					set v_image_first = '';
				end if;
			end if;
			if v_ran_num_3 %2 then
				if v_ran_num_4 %2 then
					set v_image_first = '';
				end if;
				if v_ran_num_5 %2 then
					set v_image_first = '';
				end if;
			end if;
			
			set v_description = '<P>As per the information we have this business type is undetermined.&ast;</P><P>But we are sure this is yet another impressive business that has great potential and is worth significant.</P><P>If you are the owner or authorized person to update this business related information. Please claim the business by clicking "Claim Business" button. You can also report any issues regarding this business listing by sending an email to admin@bizrealworth.com or calling to 1-855-5-CALL-RW (1-855-522-5579)</P><P>&ast; We gather and process data provided by multiple sources, it may be outdated or inaccurate.</P>';
		END IF;	
		IF v_biz_type = 'BTYPE_MISC' THEN
			select '**** INSIDE TYPE - BTYPE_MISC';
			set v_naics_num = 0000;
			
			set v_naics_description = 'Not Available';
			
			set v_sqft_indoor = ROUND(FLOOR(RAND() * (5000 - 2000 + 1) + 2000), - 1);
			
			set v_sqft_outdoor = ROUND(FLOOR(RAND() * (5000 - 2000 + 1) + 2000), - 1);
			
			set v_sqft_lot = ROUND(FLOOR(RAND() * (15000 - 5000 + 1) + 5000), - 1);
			
			-- to decide building type
			if v_ran_num_1 %2 then
				if v_ran_num_4 %2 then
					set v_bldg_type = 'FREE_STANDING';
				end if;
				if v_ran_num_5 %2 then
					set v_bldg_type = 'MULTI_UNIT';
				end if;
			end if;
			if v_ran_num_2 %2 then
				if v_ran_num_4 %2 then
					set v_bldg_type = 'SPECIAL_PURPOSE';
				end if;
				if v_ran_num_5 %2 then
					set v_bldg_type = 'MULTI_PURPOSE';
				end if;
			end if;
			if v_ran_num_3 %2 then
				if v_ran_num_4 %2 then
					set v_bldg_type = 'OFFICE';
				end if;
				if v_ran_num_5 %2 then
					set v_bldg_type = 'NOT_AVAILABLE';
				end if;
			end if;
			
			-- to decide first image
			if v_ran_num_1 %2 then
				if v_ran_num_4 %2 then
					set v_image_first = '';
				end if;
				if v_ran_num_5 %2 then
					set v_image_first = '';
				end if;
			end if;
			if v_ran_num_2 %2 then
				if v_ran_num_4 %2 then
					set v_image_first = '';
				end if;
				if v_ran_num_5 %2 then
					set v_image_first = '';
				end if;
			end if;
			if v_ran_num_3 %2 then
				if v_ran_num_4 %2 then
					set v_image_first = '';
				end if;
				if v_ran_num_5 %2 then
					set v_image_first = '';
				end if;
			end if;
			
			set v_description = '<P>As per the information we have this business type is undetermined.&ast;</P><P>But we are sure this is yet another impressive business that has great potential and is worth significant.</P><P>If you are the owner or authorized person to update this business related information. Please claim the business by clicking "Claim Business" button. You can also report any issues regarding this business listing by sending an email to admin@bizrealworth.com or calling to 1-855-5-CALL-RW (1-855-522-5579)</P><P>&ast; We gather and process data provided by multiple sources, it may be outdated or inaccurate.</P>';
		END IF;	
		IF v_biz_type = 'BTYPE_MISC' THEN
			select '**** INSIDE TYPE - BTYPE_MISC';
			set v_naics_num = 0000;
			
			set v_naics_description = 'Not Available';
			
			set v_sqft_indoor = ROUND(FLOOR(RAND() * (5000 - 2000 + 1) + 2000), - 1);
			
			set v_sqft_outdoor = ROUND(FLOOR(RAND() * (5000 - 2000 + 1) + 2000), - 1);
			
			set v_sqft_lot = ROUND(FLOOR(RAND() * (15000 - 5000 + 1) + 5000), - 1);
			
			-- to decide building type
			if v_ran_num_1 %2 then
				if v_ran_num_4 %2 then
					set v_bldg_type = 'FREE_STANDING';
				end if;
				if v_ran_num_5 %2 then
					set v_bldg_type = 'MULTI_UNIT';
				end if;
			end if;
			if v_ran_num_2 %2 then
				if v_ran_num_4 %2 then
					set v_bldg_type = 'SPECIAL_PURPOSE';
				end if;
				if v_ran_num_5 %2 then
					set v_bldg_type = 'MULTI_PURPOSE';
				end if;
			end if;
			if v_ran_num_3 %2 then
				if v_ran_num_4 %2 then
					set v_bldg_type = 'OFFICE';
				end if;
				if v_ran_num_5 %2 then
					set v_bldg_type = 'NOT_AVAILABLE';
				end if;
			end if;
			
			-- to decide first image
			if v_ran_num_1 %2 then
				if v_ran_num_4 %2 then
					set v_image_first = '';
				end if;
				if v_ran_num_5 %2 then
					set v_image_first = '';
				end if;
			end if;
			if v_ran_num_2 %2 then
				if v_ran_num_4 %2 then
					set v_image_first = '';
				end if;
				if v_ran_num_5 %2 then
					set v_image_first = '';
				end if;
			end if;
			if v_ran_num_3 %2 then
				if v_ran_num_4 %2 then
					set v_image_first = '';
				end if;
				if v_ran_num_5 %2 then
					set v_image_first = '';
				end if;
			end if;
			
			set v_description = '<P>As per the information we have this business type is undetermined.&ast;</P><P>But we are sure this is yet another impressive business that has great potential and is worth significant.</P><P>If you are the owner or authorized person to update this business related information. Please claim the business by clicking "Claim Business" button. You can also report any issues regarding this business listing by sending an email to admin@bizrealworth.com or calling to 1-855-5-CALL-RW (1-855-522-5579)</P><P>&ast; We gather and process data provided by multiple sources, it may be outdated or inaccurate.</P>';
		END IF;	
		IF v_biz_type = 'BTYPE_MISC' THEN
			select '**** INSIDE TYPE - BTYPE_MISC';
			set v_naics_num = 0000;
			
			set v_naics_description = 'Not Available';
			
			set v_sqft_indoor = ROUND(FLOOR(RAND() * (5000 - 2000 + 1) + 2000), - 1);
			
			set v_sqft_outdoor = ROUND(FLOOR(RAND() * (5000 - 2000 + 1) + 2000), - 1);
			
			set v_sqft_lot = ROUND(FLOOR(RAND() * (15000 - 5000 + 1) + 5000), - 1);
			
			-- to decide building type
			if v_ran_num_1 %2 then
				if v_ran_num_4 %2 then
					set v_bldg_type = 'FREE_STANDING';
				end if;
				if v_ran_num_5 %2 then
					set v_bldg_type = 'MULTI_UNIT';
				end if;
			end if;
			if v_ran_num_2 %2 then
				if v_ran_num_4 %2 then
					set v_bldg_type = 'SPECIAL_PURPOSE';
				end if;
				if v_ran_num_5 %2 then
					set v_bldg_type = 'MULTI_PURPOSE';
				end if;
			end if;
			if v_ran_num_3 %2 then
				if v_ran_num_4 %2 then
					set v_bldg_type = 'OFFICE';
				end if;
				if v_ran_num_5 %2 then
					set v_bldg_type = 'NOT_AVAILABLE';
				end if;
			end if;
			
			-- to decide first image
			if v_ran_num_1 %2 then
				if v_ran_num_4 %2 then
					set v_image_first = '';
				end if;
				if v_ran_num_5 %2 then
					set v_image_first = '';
				end if;
			end if;
			if v_ran_num_2 %2 then
				if v_ran_num_4 %2 then
					set v_image_first = '';
				end if;
				if v_ran_num_5 %2 then
					set v_image_first = '';
				end if;
			end if;
			if v_ran_num_3 %2 then
				if v_ran_num_4 %2 then
					set v_image_first = '';
				end if;
				if v_ran_num_5 %2 then
					set v_image_first = '';
				end if;
			end if;
			
			set v_description = '<P>As per the information we have this business type is undetermined.&ast;</P><P>But we are sure this is yet another impressive business that has great potential and is worth significant.</P><P>If you are the owner or authorized person to update this business related information. Please claim the business by clicking "Claim Business" button. You can also report any issues regarding this business listing by sending an email to admin@bizrealworth.com or calling to 1-855-5-CALL-RW (1-855-522-5579)</P><P>&ast; We gather and process data provided by multiple sources, it may be outdated or inaccurate.</P>';
		END IF;

        -- update the record with above values
		update t_brw_business 
			set 
			-- below attributes are based on type of business TODO: Write seperate SP for this one
			naics_num = v_naics_num,
			naics_description = v_naics_description,
			sqft_indoor = v_sqft_indoor,
			sqft_outdoor = v_sqft_outdoor,
			sqft_lot = v_sqft_lot,
			bldg_type = v_bldg_type,
			image_first = v_image_first,
			description = v_description,
			
			-- audit columns
			createdby_user_id = 888,
			create_date = CURDATE(),
			updatedby_user_id = 8888,
			update_date = CURDATE()
			where 
			biz_id = v_biz_id;
    		
			select '**** DONE WITH UPDATE';
            
            -- reset all the variables
            set v_biz_id = 0;
			set v_biz_type = '';
			
			set v_naics_num = 0;
			set v_naics_description = '';
			set v_sqft_indoor = 0;
			set v_sqft_outdoor = 0;
			set v_sqft_lot = 0;
			set v_bldg_type = '';
			set v_image_first = '';
			set v_description = '';

    end loop all_records_Loop;
	close all_records_cursor;

    select 'UPDATED total records: '+v_count;
    -- **** END OF all_records_Loop LOOP ****** --
END