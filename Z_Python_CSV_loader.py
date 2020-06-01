# -*- coding: utf-8 -*-
#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Created on Wed May 28 21:02:26 2020

@author: sidpatil

This script uploads the CSV file to MySQL DB.
CSV file has to be formatted to match t_brw_business table.
This program is suppose to handle close to 1 MIL rows of data in each run.
Tyarget is to upload about 60 MIL rows of business data to cover all 50 states of US.

"""

#import xlrd
from csv import reader
import mysql.connector

# Open the workbook and define the worksheet
#bizDataFile = open("CA_2.csv")
bizDataFile = open("CA_1_t_brw_business.csv")
csvReader = reader(bizDataFile)

# Establish a MySQL connection
database = mysql.connector.connect (host="brwdev.cx4tgyitha5s.us-east-1.rds.amazonaws.com", user = "admin", passwd = "iX9pqyh1oSkEYVujHSu1", db = "brwdev")

# Get the cursor, which is used to traverse the database, line by line
cursor = database.cursor()

# build a sql query
query = """INSERT INTO t_brw_business
(`biz_id`,
`mongo_biz_id`,
`name_legal`,
`name_dba`,
`owner_first`,
`owner_second`,
`ownership_type`,
`biz_contact_name`,
`biz_contact_title`,
`biz_contact_phone`,
`biz_contact_email`,
`brand_name`,
`type`,
`sub_type`,
`city_business_type_1`,
`city_business_type_2`,
`gg_business_type_1`,
`gg_business_type_2`,
`gg_business_type_3`,
`yp_business_type_1`,
`yp_business_type_2`,
`yp_business_type_3`,
`year_established`,
`reg_city_name`,
`reg_city_code`,
`reg_city_date`,
`reg_state_name`,
`reg_state_code`,
`reg_state_date`,
`data_completeness_score`,
`view_counter`,
`for_sell_YN`,
`hidden_YN`,
`for_sell_price`,
`broker_first_name`,
`broker_last_name`,
`broker_phone`,
`broker_email`,
`listing_title`,
`reason_for_sell`,
`broker_license_number`,
`annual_cash_flow`,
`monthly_payroll_cost`,
`total_debt`,
`ff_and_e`,
`brw_listing_number`,
`ebtda`,
`inventory_cost`,
`paid_listing_YN`,
`asset_based_est`,
`income_based_est`,
`market_based_est`,
`image_logo`,
`image_first`,
`add_street1`,
`add_street2`,
`add_city`,
`add_county`,
`add_state`,
`add_zip`,
`latitude`,
`longitude`,
`phone`,
`phone_ext`,
`email`,
`website`,
`description`,
`naics_num`,
`naics_description`,
`sic_code`,
`sic_description`,
`franchise_YN`,
`owner_claim_YN`,
`vendor_call_YN`,
`estimate_done_YN`,
`sqft_indoor`,
`sqft_outdoor`,
`sqft_lot`,
`bldg_type`,
`bldg_owned_YN`,
`sales_range`,
`employee_range`,
`rev_monthly`,
`exp_monthly_rent`,
`exp_monthly_mortgage`,
`exp_monthly_material`,
`exp_monthly_emp`,
`exp_monthly_utility`,
`exp_monthly_other`,
`value_total_equipment`,
`value_total_furniture`,
`value_indoor_deco`,
`value_outdoor_deco`,
`year_equipment`,
`year_furniture`,
`year_indoor_deco`,
`year_outdoor_deco`,
`emp_FT_num`,
`emp_PT_num`,
`area_crime_score`,
`area_walk_score`,
`area_transit_score`,
`social_media_score`,
`area_attractions_score`,
`1mile_rad_popln`,
`1mile_rad_incoscore`,
`3mile_rad_popln`,
`3mile_rad_incoscore`,
`5mile_rad_popln`,
`5mile_rad_incoscore`,
`dailypeople_doorfront_num`,
`dailycar_parklot_num`,
`bvr_avg_sp`,
`factor`,
`createdby_user_id`,
`create_date`,
`updatedby_user_id`,
`update_date`)
VALUES
(%s,
%s,
%s,
%s,
%s,
%s,
%s,
%s,
%s,
%s,
%s,
%s,
%s,
%s,
%s,
%s,
%s,
%s,
%s,
%s,
%s,
%s,
%s,
%s,
%s,
%s,
%s,
%s,
%s,
%s,
%s,
%s,
%s,
%s,
%s,
%s,
%s,
%s,
%s,
%s,
%s,
%s,
%s,
%s,
%s,
%s,
%s,
%s,
%s,
%s,
%s,
%s,
%s,
%s,
%s,
%s,
%s,
%s,
%s,
%s,
%s,
%s,
%s,
%s,
%s,
%s,
%s,
%s,
%s,
%s,
%s,
%s,
%s,
%s,
%s,
%s,
%s,
%s,
%s,
%s,
%s,
%s,
%s,
%s,
%s,
%s,
%s,
%s,
%s,
%s,
%s,
%s,
%s,
%s,
%s,
%s,
%s,
%s,
%s,
%s,
%s,
%s,
%s,
%s,
%s,
%s,
%s,
%s,
%s,
%s,
%s,
%s,
%s,
%s,
%s,
%s,
%s,
%s)"""

counter = 0
# Create a For loop to iterate through each row in the XLS file, starting at row 2 to skip the headers
for row in csvReader:
    counter = counter + 1
    bizName = str(row[3])
    streetAdd = str(row[55])
    city = str(row[57])
    state = str(row[59])
    print ("About to add record #: "+str(counter))
    print ("Business name: "+bizName)
    print ("located at: "+streetAdd)
    print ("in the city of: "+city)
    print ("in state: "+state)
    print ("")
    #print ("adding record to DB")

	# Assign values from each row
    values = (row[1],
              row[2],
              row[3],
              row[4],
              row[5],
              row[6],
              row[7],
              row[8],
              row[9],
              row[10],
              row[11],
              row[12],
              row[13],
              row[14],
              row[15],
              row[16],
              row[17],
              row[18],
              row[19],
              row[20],
              row[21],
              row[22],
              row[23],
              row[24],
              row[25],
              row[26],
              row[27],
              row[28],
              row[29],
              row[30],
              row[31],
              row[32],
              row[33],
              row[34],
              row[35],
              row[36],
              row[37],
              row[38],
              row[39],
              row[40],
              row[41],
              row[42],
              row[43],
              row[44],
              row[45],
              row[46],
              row[47],
              row[48],
              row[49],
              row[50],
              row[51],
              row[52],
              row[53],
              row[54],
              row[55],
              row[56],
              row[57],
              row[58],
              row[59],
              row[60],
              row[61],
              row[62],
              row[63],
              row[64],
              row[65],
              row[66],
              row[67],
              row[68],
              row[69],
              row[70],
              row[71],
              row[72],
              row[73],
              row[74],
              row[75],
              row[76],
              row[77],
              row[78],
              row[79],
              row[80],
              row[81],
              row[82],
              row[83],
              row[84],
              row[85],
              row[86],
              row[87],
              row[88],
              row[89],
              row[90],
              row[91],
              row[92],
              row[93],
              row[94],
              row[95],
              row[96],
              row[97],
              row[98],
              row[99],
              row[100],
              row[101],
              row[102],
              row[103],
              row[104],
              row[105],
              row[106],
              row[107],
              row[108],
              row[109],
              row[110],
              row[111],
              row[112],
              row[113],
              row[114],
              row[115],
              row[116],
              row[117],
              row[118])
	
    # Execute sql Query
    cursor.execute(query, values)
    database.commit()
    
#print ("Row#: "+ r +" is imported to BRW DEV DB!")

# Close the cursor
cursor.close()

# Commit the transaction
database.commit()

# Close the database connection
database.close()

# Print results
print ("")
print ("All Done! Bye, for now.")
print ("")
#columns = str(sheet.ncols)
#rows = str(sheet.nrows)
#print ("I just imported "+ columns +" columns and "+ rows +" rows to MySQL!")