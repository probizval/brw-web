CREATE PROCEDURE `delete_duplicate_business` ()
BEGIN

-- select duplicates in cursor
-- run loop on the cursor and select the multiple biz_ids based on name, address
-- insert those biz_ids in duplicates table
-- select one single biz_id that we want to keep based on criteria about range of rev and range of employee
-- if thats not possible then pick up one random biz_id
-- update the row for that biz_id with updatedby_user_id to 9999
-- change all the select SQLs to pick up records only with updatedby_user_id as 9999
-- or just delete the records
END
