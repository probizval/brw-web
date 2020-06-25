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
	declare v_bldg_type varchar(20) DEFAULT '';
	declare v_description varchar(10000) DEFAULT '';
    
	-- declare cursor to pull all records from BIZ table
    declare all_records_cursor cursor for select biz_id, type  
	from t_brw_business;
    -- where 
    -- updatedby_user_id != 9999;
    -- biz_id in(18796151, 18796263, 18796269);
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
            
            if v_bldg_type = '' then
				set v_bldg_type = 'NOT_AVAILABLE';
			end if;
			
			set v_description = '<P>As per the information we have this business type is undetermined.&ast;</P><P>But we are sure this is yet another impressive business that has great potential and is worth significant.</P><P>If you are the owner or authorized person to update this business related information. Please claim the business by clicking "Claim Business" button. You can also report any issues regarding this business listing by sending an email to admin@bizrealworth.com or calling to 1-855-5-CALL-RW (1-855-522-5579)</P><P>&ast; We gather and process data provided by multiple sources, it may be outdated or inaccurate.</P>';
		END IF;
        
		IF v_biz_type = 'BTYPE_AGRI' THEN
			select '**** INSIDE TYPE - BTYPE_AGRI';
			set v_naics_num = 11;
			
			set v_naics_description = 'Agriculture, Forestry, Fishing and Hunting';
			
			set v_sqft_indoor = ROUND(FLOOR(RAND() * (15000 - 2000 + 1) + 2000), - 1);
			
			set v_sqft_outdoor = ROUND(FLOOR(RAND() * (15000 - 2000 + 1) + 2000), - 1);
			
			set v_sqft_lot = ROUND(FLOOR(RAND() * (50000 - 15000 + 1) + 15000), - 1);
			
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
            
            if v_bldg_type = '' then
				set v_bldg_type = 'SPECIAL_PURPOSE';
			end if;
			
			set v_description = '<P>As per the information we have this business is of Agricultural Type.&ast;</P><P>Agricultural business, also known as agribusiness, is the farming, management, production, and marketing of agricultural commodities, such as livestock and crops. The agricultural business field includes resource management, farming, conservation, ranching, and sales.</P><P>Agriculture is the science and art of cultivating plants and livestock. Agriculture was the key development in the rise of sedentary human civilization, whereby farming of domesticated species created food surpluses that enabled people to live in cities. The history of agriculture began thousands of years ago.</P><P>If you are the owner or authorized person to update this business related information. Please claim the business by clicking "Claim Business" button. You can also report any issues regarding this business listing by sending an email to admin@bizrealworth.com or calling to 1-855-5-CALL-RW (1-855-522-5579)</P><P>&ast; We gather and process data provided by multiple sources, it may be outdated or inaccurate.</P>';
		END IF;	

		IF v_biz_type = 'BTYPE_AUTO_BOAT' THEN
			select '**** INSIDE TYPE - BTYPE_AUTO_BOAT';
			set v_naics_num = 811110;
			
			set v_naics_description = 'Automotive Mechanical and Electrical Repair and Maintenance';
			
			set v_sqft_indoor = ROUND(FLOOR(RAND() * (5000 - 1000 + 1) + 1000), - 1);
			
			set v_sqft_outdoor = ROUND(FLOOR(RAND() * (10000 - 2000 + 1) + 2000), - 1);
			
			set v_sqft_lot = ROUND(FLOOR(RAND() * (25000 - 5000 + 1) + 5000), - 1);
			
			-- to decide building type
			if v_ran_num_1 %2 then
				if v_ran_num_4 %2 then
					set v_bldg_type = 'FREE_STANDING';
				end if;
				if v_ran_num_5 %2 then
					set v_bldg_type = 'SPECIAL_PURPOSE';
				end if;
			end if;
			if v_ran_num_2 %2 then
				if v_ran_num_4 %2 then
					set v_bldg_type = 'OFFICE';
				end if;
				if v_ran_num_5 %2 then
					set v_bldg_type = 'MULTI_PURPOSE';
				end if;
			end if;
			if v_ran_num_3 %2 then
				if v_ran_num_4 %2 then
					set v_bldg_type = 'MULTI_UNIT';
				end if;
				if v_ran_num_5 %2 then
					set v_bldg_type = 'NOT_AVAILABLE';
				end if;
			end if;
            
            if v_bldg_type = '' then
				set v_bldg_type = 'MULTI_PURPOSE';
			end if;
			
			set v_description = '<P>The automotive industry comprises a wide range of companies and organizations involved in the design, development, manufacturing, marketing, and selling of motor vehicles. It is one of the worlds largest economic sectors by revenue.</P><P>The automotive industry listings on our website also include industries dedicated to the maintenance of automobiles following delivery to the end-user,[citation needed] such as automobile repair shops and motor fuel filling stations.</P><P>The automotive industry is a term that covers a wide range of companies and organisations involved in the design, development, manufacture, marketing, and selling of motor vehicles, towed vehicles, motorcycles and mopeds. It is one of the worlds most important economic sectors by revenue.industry revenue is expected to grow at an annualized rate of 2.7% to $4.0 trillion over the five years to 2019, including revenue growing 2.3% in 2019 alone.</P><P>If you are the owner or authorized person to update this business related information. Please claim the business by clicking "Claim Business" button. You can also report any issues regarding this business listing by sending an email to admin@bizrealworth.com or calling to 1-855-5-CALL-RW (1-855-522-5579)</P><P>&ast; We gather and process data provided by multiple sources, it may be outdated or inaccurate.</P>';
		END IF;	

		IF v_biz_type = 'BTYPE_BEAUTY_PERSONA' THEN
			select '**** INSIDE TYPE - BTYPE_BEAUTY_PERSONA';
			set v_naics_num = 8121;
			
			set v_naics_description = 'Personal Care Services';
			
			set v_sqft_indoor = ROUND(FLOOR(RAND() * (3000 - 500 + 1) + 500), - 1);
			
			set v_sqft_outdoor = ROUND(FLOOR(RAND() * (2000 - 500 + 1) + 500), - 1);
			
			set v_sqft_lot = ROUND(FLOOR(RAND() * (15000 - 5000 + 1) + 5000), - 1);
			
			-- to decide building type
			if v_ran_num_1 %2 then
				if v_ran_num_4 %2 then
					set v_bldg_type = 'MULTI_UNIT';
				end if;
				if v_ran_num_5 %2 then
					set v_bldg_type = 'OFFICE';
				end if;
			end if;
			if v_ran_num_2 %2 then
				if v_ran_num_4 %2 then
					set v_bldg_type = 'FREE_STANDING';
				end if;
				if v_ran_num_5 %2 then
					set v_bldg_type = 'MULTI_PURPOSE';
				end if;
			end if;
			if v_ran_num_3 %2 then
				if v_ran_num_4 %2 then
					set v_bldg_type = 'SPECIAL_PURPOSE';
				end if;
				if v_ran_num_5 %2 then
					set v_bldg_type = 'NOT_AVAILABLE';
				end if;
			end if;
            
            if v_bldg_type = '' then
				set v_bldg_type = 'MULTI_UNIT';
			end if;
			
			set v_description = '<P>The beauty industry comprises cosmetics sales, perfume sales and skin and hair care products. Beauty salons and spas are deemed the beauty industrys service sector. Worldwide sales of beauty-related products and services are estimated to exceed US$ 159 billion ( USD) per annum.</P><P>If you are the owner or authorized person to update this business related information. Please claim the business by clicking "Claim Business" button. You can also report any issues regarding this business listing by sending an email to admin@bizrealworth.com or calling to 1-855-5-CALL-RW (1-855-522-5579)</P><P>&ast; We gather and process data provided by multiple sources, it may be outdated or inaccurate.</P>';
		END IF;	

		IF v_biz_type = 'BTYPE_BUILD_CONS' THEN
			select '**** INSIDE TYPE - BTYPE_BUILD_CONS';
			set v_naics_num = 236220;
			
			set v_naics_description = 'Buidings and Construction';
			
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
					set v_bldg_type = 'OFFICE';
				end if;
				if v_ran_num_5 %2 then
					set v_bldg_type = 'MULTI_PURPOSE';
				end if;
			end if;
			if v_ran_num_3 %2 then
				if v_ran_num_4 %2 then
					set v_bldg_type = 'SPECIAL_PURPOSE';
				end if;
				if v_ran_num_5 %2 then
					set v_bldg_type = 'NOT_AVAILABLE';
				end if;
			end if;
            
            if v_bldg_type = '' then
				set v_bldg_type = 'FREE_STANDING';
			end if;
			
			set v_description = '<P>Construction industry is engaged in land and building preparation, alteration, and repair of buildings , structures, and other real estate. There are three construction sectors: buildings, infrastructure and the industrial sector. Construction of buildings is usually further divided into residential and non-residential ones. The health of the economy is often gauged by monitoring new home construction starts as an indicator of consumer confidence. According to the U.S. Census, spending on construction projects totaled more than $993 billion in 2014.</P><P>If you are the owner or authorized person to update this business related information. Please claim the business by clicking "Claim Business" button. You can also report any issues regarding this business listing by sending an email to admin@bizrealworth.com or calling to 1-855-5-CALL-RW (1-855-522-5579)</P><P>&ast; We gather and process data provided by multiple sources, it may be outdated or inaccurate.</P>';
		END IF;	

		IF v_biz_type = 'BTYPE_COM_MEDIA' THEN
			select '**** INSIDE TYPE - BTYPE_COM_MEDIA';
			set v_naics_num = 541840;
			
			set v_naics_description = 'Media and Communications';
			
			set v_sqft_indoor = ROUND(FLOOR(RAND() * (5000 - 2000 + 1) + 2000), - 1);
			
			set v_sqft_outdoor = ROUND(FLOOR(RAND() * (5000 - 2000 + 1) + 2000), - 1);
			
			set v_sqft_lot = ROUND(FLOOR(RAND() * (15000 - 5000 + 1) + 5000), - 1);
			
			-- to decide building type
			if v_ran_num_1 %2 then
				if v_ran_num_4 %2 then
					set v_bldg_type = 'FREE_STANDING';
				end if;
				if v_ran_num_5 %2 then
					set v_bldg_type = 'OFFICE';
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
					set v_bldg_type = 'MULTI_UNIT';
				end if;
				if v_ran_num_5 %2 then
					set v_bldg_type = 'NOT_AVAILABLE';
				end if;
			end if;
            
            if v_bldg_type = '' then
				set v_bldg_type = 'OFFICE';
			end if;
			
			set v_description = '<P>Media and Communications industry, broadly defined, the business of conveying information. As such, it covers television and radio broadcasting, telegraphs, publishing, advertising, telecommunications, motion pictures, home videos, public relations, computer databases, and other information industries. The communications industry is a multibillion dollar business. The different industries that fall under the communications umbrella, as reported by the market research group IBISWorld, include public relations, advertising, publishing, and social networking sites. The public relations industry generates approximately $13 billion in revenue. The advertising industry is a $44 billion business, with more than 66,000 advertising firms in the United States.</P><P>If you are the owner or authorized person to update this business related information. Please claim the business by clicking "Claim Business" button. You can also report any issues regarding this business listing by sending an email to admin@bizrealworth.com or calling to 1-855-5-CALL-RW (1-855-522-5579)</P><P>&ast; We gather and process data provided by multiple sources, it may be outdated or inaccurate.</P>';
		END IF;	
        
		IF v_biz_type = 'BTYPE_EDU_CHILD' THEN
			select '**** INSIDE TYPE - BTYPE_EDU_CHILD';
			set v_naics_num = 624410;
			
			set v_naics_description = 'Educational Guidance';
			
			set v_sqft_indoor = ROUND(FLOOR(RAND() * (5000 - 2000 + 1) + 2000), - 1);
			
			set v_sqft_outdoor = ROUND(FLOOR(RAND() * (5000 - 2000 + 1) + 2000), - 1);
			
			set v_sqft_lot = ROUND(FLOOR(RAND() * (15000 - 5000 + 1) + 5000), - 1);
			
			-- to decide building type
			if v_ran_num_1 %2 then
				if v_ran_num_4 %2 then
					set v_bldg_type = 'FREE_STANDING';
				end if;
				if v_ran_num_5 %2 then
					set v_bldg_type = 'OFFICE';
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
					set v_bldg_type = 'MULTI_UNIT';
				end if;
				if v_ran_num_5 %2 then
					set v_bldg_type = 'NOT_AVAILABLE';
				end if;
			end if;
            
            if v_bldg_type = '' then
				set v_bldg_type = 'FREE_STANDING';
			end if;
			
			set v_description = '<P>This industry consists of establishments that provide paid care for infants, toddlers, preschool children, and older children in before- and after-school programs. Companies in this industry provide supervision and educational programs for pre-school and school-age children. Two main types of child care make up the child day care services industry: center-based care and family child care. Formal child day care centers include part and full day preschools, child care centers, school and community based pre-kindergartens and Head Start and Early Head Start centers. Family child care providers care for children in their home for a fee and are the majority of self-employed workers in this industry.The US child care services industry includes about 54,000 commercial facilities with combined annual revenue of $27 billion, plus about 21,000 facilities run by nonprofit organizations with combined annual revenue of about $14 billion.</P><P>If you are the owner or authorized person to update this business related information. Please claim the business by clicking "Claim Business" button. You can also report any issues regarding this business listing by sending an email to admin@bizrealworth.com or calling to 1-855-5-CALL-RW (1-855-522-5579)</P><P>&ast; We gather and process data provided by multiple sources, it may be outdated or inaccurate.</P>';
		END IF;	
        
		IF v_biz_type = 'BTYPE_ENT_REC' THEN
			select '**** INSIDE TYPE - BTYPE_ENT_REC';
			set v_naics_num = 71;
			
			set v_naics_description = 'Arts, Entertainment, and Recreation';
			
			set v_sqft_indoor = ROUND(FLOOR(RAND() * (10000 - 2000 + 1) + 2000), - 1);
			
			set v_sqft_outdoor = ROUND(FLOOR(RAND() * (10000 - 2000 + 1) + 2000), - 1);
			
			set v_sqft_lot = ROUND(FLOOR(RAND() * (50000 - 10000 + 1) + 10000), - 1);
			
			-- to decide building type
			if v_ran_num_1 %2 then
				if v_ran_num_4 %2 then
					set v_bldg_type = 'FREE_STANDING';
				end if;
				if v_ran_num_5 %2 then
					set v_bldg_type = 'SPECIAL_PURPOSE';
				end if;
			end if;
			if v_ran_num_2 %2 then
				if v_ran_num_4 %2 then
					set v_bldg_type = 'MULTI_UNIT';
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
            
            if v_bldg_type = '' then
				set v_bldg_type = 'SPECIAL_PURPOSE';
			end if;
			
			set v_description = '<P>Entertainment industry consists of film, television, radio and print. These segments include movies, TV shows, radio shows, news, music, newspapers, magazines, and books. In the United States the entertainment and media market was worth an estimated 678 billion U.S. dollars in 2018 and is expected to grow to over 720 billion U.S. dollars by 2020.SBusinesses which define the recreation industry: Sports stadiums. Sports teams and leagues. Amusement parks. Movie theatres. outdoor recreation economy grew by 3.9 percent in 2017, faster than the 2.4 percent growth of the overall U.S. economy.</P><P>If you are the owner or authorized person to update this business related information. Please claim the business by clicking "Claim Business" button. You can also report any issues regarding this business listing by sending an email to admin@bizrealworth.com or calling to 1-855-5-CALL-RW (1-855-522-5579)</P><P>&ast; We gather and process data provided by multiple sources, it may be outdated or inaccurate.</P>';
		END IF;	
        
		IF v_biz_type = 'BTYPE_FINANCIAL' THEN
			select '**** INSIDE TYPE - BTYPE_FINANCIAL';
			set v_naics_num = 541611;
			
			set v_naics_description = 'Financial and Insurance';
			
			set v_sqft_indoor = ROUND(FLOOR(RAND() * (5000 - 2000 + 1) + 2000), - 1);
			
			set v_sqft_outdoor = ROUND(FLOOR(RAND() * (5000 - 2000 + 1) + 2000), - 1);
			
			set v_sqft_lot = ROUND(FLOOR(RAND() * (15000 - 5000 + 1) + 5000), - 1);
			
			-- to decide building type
			if v_ran_num_1 %2 then
				if v_ran_num_4 %2 then
					set v_bldg_type = 'OFFICE';
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
					set v_bldg_type = 'FREE_STANDING';
				end if;
				if v_ran_num_5 %2 then
					set v_bldg_type = 'NOT_AVAILABLE';
				end if;
			end if;
            
            if v_bldg_type = '' then
				set v_bldg_type = 'OFFICE';
			end if;
			
			set v_description = '<P>Finance is a broad term that describes activities associated with banking, leverage or debt, credit, capital markets, money, and investments. Finance also encompasses the oversight, creation, and study of money, banking, credit, investments, assets, and liabilities that make up financial systems.The financial sector is a section of the economy made up of firms and institutions that provide financial services to commercial and retail customers.</P><P>This segment of the economy is made up of a variety of financial firms including banks, investment houses, lenders, finance companies, real estate brokers, and insurance companies.market estimates believe that by 2022, the financial services market is expected to reach $26.5 trillion, growing at a rate of 6% during the forecasted period.</P><P>If you are the owner or authorized person to update this business related information. Please claim the business by clicking "Claim Business" button. You can also report any issues regarding this business listing by sending an email to admin@bizrealworth.com or calling to 1-855-5-CALL-RW (1-855-522-5579)</P><P>&ast; We gather and process data provided by multiple sources, it may be outdated or inaccurate.</P>';
		END IF;	
        
		IF v_biz_type = 'BTYPE_HEALTH_FIT' THEN
			select '**** INSIDE TYPE - BTYPE_HEALTH_FIT';
			set v_naics_num = 621999;
			
			set v_naics_description = 'Health Care Services';
			
			set v_sqft_indoor = ROUND(FLOOR(RAND() * (10000 - 2000 + 1) + 2000), - 1);
			
			set v_sqft_outdoor = ROUND(FLOOR(RAND() * (10000 - 2000 + 1) + 2000), - 1);
			
			set v_sqft_lot = ROUND(FLOOR(RAND() * (50000 - 5000 + 1) + 5000), - 1);
			
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
					set v_bldg_type = 'OFFICE';
				end if;
			end if;
			if v_ran_num_3 %2 then
				if v_ran_num_4 %2 then
					set v_bldg_type = 'MULTI_PURPOSE';
				end if;
				if v_ran_num_5 %2 then
					set v_bldg_type = 'NOT_AVAILABLE';
				end if;
			end if;
            
            if v_bldg_type = '' then
				set v_bldg_type = 'MULTI_PURPOSE';
			end if;
			
			set v_description = '<P>The health and fitness industry includes a wide range of opportunities that involve helping people achieve and maintain wellness. The largest portion of this segment includes gyms and exercise studios. Others include businesses that provide specialized types of ancillary health services. Companies in this industry operate fitness and recreational sports facilities that offer exercise equipment and recreational sports activities for consumers.</P><P>The global fitness and health club industry generates more than 80 billion U.S. dollars in revenue per year. The North American market had an estimated size of more than 32 billion U.S. dollars in 2017, of which around 90 percent, around 30 billion U.S. dollars, was attributable to the United States.<P><P>If you are the owner or authorized person to update this business related information. Please claim the business by clicking "Claim Business" button. You can also report any issues regarding this business listing by sending an email to admin@bizrealworth.com or calling to 1-855-5-CALL-RW (1-855-522-5579)</P><P>&ast; We gather and process data provided by multiple sources, it may be outdated or inaccurate.</P>';
		END IF;
        
		IF v_biz_type = 'BTYPE_MANUFACTURING' THEN
			select '**** INSIDE TYPE - BTYPE_MANUFACTURING';
			set v_naics_num = 32;
			
			set v_naics_description = 'Manufacturing';
			
			set v_sqft_indoor = ROUND(FLOOR(RAND() * (15000 - 2000 + 1) + 2000), - 1);
			
			set v_sqft_outdoor = ROUND(FLOOR(RAND() * (15000 - 2000 + 1) + 2000), - 1);
			
			set v_sqft_lot = ROUND(FLOOR(RAND() * (50000 - 15000 + 1) + 15000), - 1);
			
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
            
            if v_bldg_type = '' then
				set v_bldg_type = 'SPECIAL_PURPOSE';
			end if;
			
			set v_description = '<P>The manufacturing industry is the sector of the economy that produces finished products. This can be compared to primary industries that produce raw materials and service industries that produce intangible value. Common businesses of manufacturing industry can be automobile manufacturing, heavy industry such as aerospace and shipbuilding. Fast moving consumer goods such as food, beverages, cosmetics and toiletries.</P><P>Other manufacturing industry can be categorized into electronics, chemical ,pharmaceutical, paper, printing ,publishing, industrial equipment, furnitures&fixtures, building materials, fashion, sports, toys, household goods, equipment manufacturing. Manufacturers in the United States account for 11.39% of the total output in the economy, employing 8.51% of the workforce. Total output from manufacturing was $2,334.60 billion in 2018.</P><P>If you are the owner or authorized person to update this business related information. Please claim the business by clicking "Claim Business" button. You can also report any issues regarding this business listing by sending an email to admin@bizrealworth.com or calling to 1-855-5-CALL-RW (1-855-522-5579)</P><P>&ast; We gather and process data provided by multiple sources, it may be outdated or inaccurate.</P>';
		END IF;	
		IF v_biz_type = 'BTYPE_ONLINE_TECH' THEN
			select '**** INSIDE TYPE - BTYPE_ONLINE_TECH';
			set v_naics_num = 541511;
			
			set v_naics_description = 'Internet and Technology';
			
			set v_sqft_indoor = ROUND(FLOOR(RAND() * (5000 - 2000 + 1) + 2000), - 1);
			
			set v_sqft_outdoor = ROUND(FLOOR(RAND() * (5000 - 2000 + 1) + 2000), - 1);
			
			set v_sqft_lot = ROUND(FLOOR(RAND() * (15000 - 5000 + 1) + 5000), - 1);
			
			-- to decide building type
			if v_ran_num_1 %2 then
				if v_ran_num_4 %2 then
					set v_bldg_type = 'OFFICE';
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
					set v_bldg_type = 'FREE_STANDING';
				end if;
				if v_ran_num_5 %2 then
					set v_bldg_type = 'NOT_AVAILABLE';
				end if;
			end if;
            
            if v_bldg_type = '' then
				set v_bldg_type = 'OFFICE';
			end if;
			
			set v_description = '<P>A technology company is a type of business entity that focuses mainly on the development and manufacturing of technology products or providing technology as a service. This can include business relating to digital electronics, software, and internet-related services, such as e-commerce services. CompTIA projects the global information technology industry will grow at a rate of 4.0% in 2019. The optimistic upside forecast is in the 6.4% range.</P><P>If you are the owner or authorized person to update this business related information. Please claim the business by clicking "Claim Business" button. You can also report any issues regarding this business listing by sending an email to admin@bizrealworth.com or calling to 1-855-5-CALL-RW (1-855-522-5579)</P><P>&ast; We gather and process data provided by multiple sources, it may be outdated or inaccurate.</P>';
		END IF;	

		IF v_biz_type = 'BTYPE_PET_SER' THEN 
			select '**** INSIDE TYPE - BTYPE_PET_SER';
			set v_naics_num = 812910;
			
			set v_naics_description = 'Pet Care Services';
			
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
            
			if v_bldg_type = '' then
				set v_bldg_type = 'MULTI_UNIT';
			end if;
			
			set v_description = '<P>The pet industry spans veterinary pharmaceuticals, diagnostics, product distributors and services, manufacturers of pet food and pet supplies, and online and traditional pet and pet supply stores. ... The global pet care industry is expected to grow from $132 billion in 2016 to as much as $203 billion by 2025. For 2020, it estimated that $99.0 billion will be spent on our pets in the U.S.</P><P>If you are the owner or authorized person to update this business related information. Please claim the business by clicking "Claim Business" button. You can also report any issues regarding this business listing by sending an email to admin@bizrealworth.com or calling to 1-855-5-CALL-RW (1-855-522-5579)</P><P>&ast; We gather and process data provided by multiple sources, it may be outdated or inaccurate.</P>';
		END IF;

		IF v_biz_type = 'BTYPE_REAL_EST' THEN
			select '**** INSIDE TYPE - BTYPE_REAL_EST';
			set v_naics_num = 531390;
			
			set v_naics_description = 'Real Estate related services';
			
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
            
            if v_bldg_type = '' then
				set v_bldg_type = 'MULTI_UNIT';
			end if;
			
			set v_description = '<P>Real estate is real property that consists of land and improvements, which include buildings, fixtures, roads, structures, and utility systems. There are several types of real estate, each with a unique purpose and utility. The main categories are Land , Residential, Commercial, Industrial. The industry foremost jobs and careers are Development , Sales and marketing ,Brokerage, Property management,Lending, Professional services (law, accounting, etc.) .According to federal statistics, the Real Estate industry contributed more than $2.7 trillion to the U.S. economy in 2018 or about 13 percent of GDP.</P><P>If you are the owner or authorized person to update this business related information. Please claim the business by clicking "Claim Business" button. You can also report any issues regarding this business listing by sending an email to admin@bizrealworth.com or calling to 1-855-5-CALL-RW (1-855-522-5579)</P><P>&ast; We gather and process data provided by multiple sources, it may be outdated or inaccurate.</P>';
		END IF;	
        
		IF v_biz_type = 'BTYPE_REST_FOOD' THEN
			select '**** INSIDE TYPE - BTYPE_REST_FOOD';
			set v_naics_num = 722511;
			
			set v_naics_description = 'Food and Restaurants';
			
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
            
            if v_bldg_type = '' then
				set v_bldg_type = 'MULTI_UNIT';
			end if;
			
			set v_description = '<P>The restaurant and meals service industry is a $660 billion enterprise within the United States. Restaurants are categorized in lot of ways but the  primary factor  are usually the food  itself, the delicacies or the style of offering, speed like fast food restaurants, style of offering like bar or buffet restaurant, besides this restaurants may differ with respect to formality, location, cost, service, or novelty themes like an automated  restaurants, fine dining, casual dinning, cafes, food trucks, pop-up restaurants, and ghost restaurants.</P><P>The restaurant enterprise’s percentage of the food dollar has risen from 25% in 1955 to 51% in 2019. According to the National Restaurant Association, industry sales are projected to reach $863 billion in 2019In 2020, ongoing economic boom fueled by effective purchaser sentiment and increase in jobs and wages will hold to drive sales across the restaurant industry.</P><P>If you are the owner or authorized person to update this business related information. Please claim the business by clicking "Claim Business" button. You can also report any issues regarding this business listing by sending an email to admin@bizrealworth.com or calling to 1-855-5-CALL-RW (1-855-522-5579)</P><P>&ast; We gather and process data provided by multiple sources, it may be outdated or inaccurate.</P>';
		END IF;

		IF v_biz_type = 'BTYPE_RETAIL' THEN
			select '**** INSIDE TYPE - BTYPE_RETAIL';
			set v_naics_num = 452990;
			
			set v_naics_description = 'General Merchandise and Stores';
			
			set v_sqft_indoor = ROUND(FLOOR(RAND() * (10000 - 2000 + 1) + 2000), - 1);
			
			set v_sqft_outdoor = ROUND(FLOOR(RAND() * (10000 - 2000 + 1) + 2000), - 1);
			
			set v_sqft_lot = ROUND(FLOOR(RAND() * (25000 - 10000 + 1) + 10000), - 1);
			
			-- to decide building type
			if v_ran_num_1 %2 then
				if v_ran_num_4 %2 then
					set v_bldg_type = 'FREE_STANDING';
				end if;
				if v_ran_num_5 %2 then
					set v_bldg_type = 'MULTI_PURPOSE';
				end if;
			end if;
			if v_ran_num_2 %2 then
				if v_ran_num_4 %2 then
					set v_bldg_type = 'SPECIAL_PURPOSE';
				end if;
				if v_ran_num_5 %2 then
					set v_bldg_type = 'MULTI_UNIT';
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
            
            if v_bldg_type = '' then
				set v_bldg_type = 'MULTI_PURPOSE';
			end if;
			
			set v_description = '<P>Retail businesses sell items or services to customers for their consumption, use, or pleasure. They typically sell items and services in-store but some items may be sold online or over the phone and then shipped to the customer. Examples of retail businesses include clothing, drug, grocery, and convenience stores. Retail business is relatively easy to get into with fewer barriers to entry than most small businesses.The US retail industry has grown at an average annual rate of 3.76 percent, U.S. retail sales are expected to rise between 3.8 percent and 4.4 percent to more than $3.8 trillion in 2019, according to the National Retail Federation (NRF).</P><P>If you are the owner or authorized person to update this business related information. Please claim the business by clicking "Claim Business" button. You can also report any issues regarding this business listing by sending an email to admin@bizrealworth.com or calling to 1-855-5-CALL-RW (1-855-522-5579)</P><P>&ast; We gather and process data provided by multiple sources, it may be outdated or inaccurate.</P>';
		END IF;
        
		IF v_biz_type = 'BTYPE_SER_BIZ' THEN
			select '**** INSIDE TYPE - BTYPE_SER_BIZ';
			set v_naics_num = 81;
			
			set v_naics_description = 'Other Services';
			
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
            
            if v_bldg_type = '' then
				set v_bldg_type = 'MULTI_UNIT';
			end if;
			
			set v_description = '<P>Advisory services are referred to by many consulting companies in various fields as technical or expert advice according to the necessity of their client in specific matters. All advisory and consultancy services help companies or organizations develop and tackle a specific issue and find a solution to it. The consulting services are part of the tertiary sector and represent several hundred billion dollars in annual revenues. Between 2010 and 2015, the 10 largest consulting firms alone made 170 billion dollars growth revenue and the average annual growth rate is around 4%.</P><P>If you are the owner or authorized person to update this business related information. Please claim the business by clicking "Claim Business" button. You can also report any issues regarding this business listing by sending an email to admin@bizrealworth.com or calling to 1-855-5-CALL-RW (1-855-522-5579)</P><P>&ast; We gather and process data provided by multiple sources, it may be outdated or inaccurate.</P>';
		END IF;	
        
		IF v_biz_type = 'BTYPE_TRANS_STOR' THEN
			select '**** INSIDE TYPE - BTYPE_TRANS_STOR';
			set v_naics_num = 485999;
			
			set v_naics_description = 'Transportation and Storage';
			
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
            
            if v_bldg_type = '' then
				set v_bldg_type = 'SPECIAL_PURPOSE';
			end if;
			
			set v_description = '<P>The Transportation and Warehousing sector includes industries providing transportation of passengers and cargo, warehousing and storage for goods, scenic and Sightseeing transportation, and support activities related to modes of transportation. These industries are further broken down into the sub-industries air freight and logistics, airlines, marine, railroads, trucking, airport services, highways and rail tracks, and marine ports and services. These include companies such as airlines, trucking, railroads, shipping, and logistics firms, as well as those that provide transportation infrastructure. United States Business Logistics Costs reached $1.6 trillion in 2018 (8 percent of GDP that year).</P><P>If you are the owner or authorized person to update this business related information. Please claim the business by clicking "Claim Business" button. You can also report any issues regarding this business listing by sending an email to admin@bizrealworth.com or calling to 1-855-5-CALL-RW (1-855-522-5579)</P><P>&ast; We gather and process data provided by multiple sources, it may be outdated or inaccurate.</P>';
		END IF;	

		IF v_biz_type = 'BTYPE_TRAVEL' THEN
			select '**** INSIDE TYPE - BTYPE_TRAVEL';
			set v_naics_num = 561510;
			
			set v_naics_description = 'Travel and Tourism';
			
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
            
            if v_bldg_type = '' then
				set v_bldg_type = 'OFFICE';
			end if;
			
			set v_description = '<P>Travel industry is a business that is designed to help customers make various types of arrangements for trips such as tickets and hotel reservations. Travel agencies can provide outdoor recreation activities, airlines, car rentals, cruise lines, hotels, railways, travel insurance, package tours, insurance, guide books, public transport timetables, car rentals, and bureau de change services. As per World Travel and Tourism Council (WTTC), the global travel & tourism industry has grown from US$ 6.03 Trillion in 2006 and reached US$ 8.27 trillion by 2017 growing at a CAGR of 2.9%.</P><P>If you are the owner or authorized person to update this business related information. Please claim the business by clicking "Claim Business" button. You can also report any issues regarding this business listing by sending an email to admin@bizrealworth.com or calling to 1-855-5-CALL-RW (1-855-522-5579)</P><P>&ast; We gather and process data provided by multiple sources, it may be outdated or inaccurate.</P>';
		END IF;

		IF v_biz_type = 'BTYPE_WHLSL_DIST' THEN
			select '**** INSIDE TYPE - BTYPE_WHLSL_DIST';
			set v_naics_num = 423990;
			
			set v_naics_description = 'Wholesale and Distribution';
			
			set v_sqft_indoor = ROUND(FLOOR(RAND() * (15000 - 2000 + 1) + 2000), - 1);
			
			set v_sqft_outdoor = ROUND(FLOOR(RAND() * (15000 - 2000 + 1) + 2000), - 1);
			
			set v_sqft_lot = ROUND(FLOOR(RAND() * (35000 - 15000 + 1) + 15000), - 1);
			
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
            
            if v_bldg_type = '' then
				set v_bldg_type = 'MULTI_PURPOSE';
			end if;
			
			set v_description = '<P>Wholesale trade refers to the business-to-business (B2B) transaction of goods, it is a highly diversified industry. Wholesaling or distributing is the sale of goods or merchandise to retailers; to industrial, commercial, institutional or other professional business users; or to other wholesalers (wholesale businesses) and related subordinated services. In general, it is the sale of goods to anyone other than a standard consumer.With annual sales of about $7 trillion, the US wholesale distribution industry includes about 330,000 companies.</P><P>If you are the owner or authorized person to update this business related information. Please claim the business by clicking "Claim Business" button. You can also report any issues regarding this business listing by sending an email to admin@bizrealworth.com or calling to 1-855-5-CALL-RW (1-855-522-5579)</P><P>&ast; We gather and process data provided by multiple sources, it may be outdated or inaccurate.</P>';
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
			-- image_first = v_image_first,
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
			-- set v_image_first = '';
			set v_description = '';

    end loop all_records_Loop;
	close all_records_cursor;

    select 'UPDATED total records: '+v_count;
    -- **** END OF all_records_Loop LOOP ****** --
END