package com.brw.entities;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.InheritanceType;

@Entity
@DynamicUpdate
@Table(name = "t_brw_business")
@Inheritance(strategy = InheritanceType.JOINED)
public class BusinessDetails implements Serializable {
	
	private static final long serialVersionUID = -8504035975938683238L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	@Column(name = "biz_id")
	private int businessId;
	
	@Column(name = "name_legal")
	private String legalName;
	
	@Column(name = "name_dba")
	private String name;
	
	@Column(name = "owner_first")
	private String firstOwnerName;
	
	@Column(name = "owner_second")
	private String secondOwnerName;
	
	@Column(name = "brand_name")
	private String brandName;
	
	@Column(name = "type")
	private String type;
	
	@Column(name = "sub_type")
	private String subType;
	
	@Column(name = "reg_city_name")
	private String regCityName;
	
	@Column(name = "reg_city_code")
	private String regCityCode;
	
	@Column(name = "reg_city_date")
	private LocalDateTime regCityDate;
	
	@Column(name = "reg_state_name")
	private String regStateName;
	
	@Column(name = "reg_state_code")
	private String regStateCode;
	
	@Column(name = "reg_state_date")
	private LocalDateTime regStateDate;
	
	@Column(name = "data_completeness_score")
	private int dataCompletenessScore;
	
	@Column(name = "for_sell_YN")
	private String isForSell;
	
	@Column(name = "for_sell_price")
	private int forSellPrice;
	
	@Column(name = "image_logo")
	private String imageLogo;
	
	@Column(name = "image_first")
	private String imageFirst;
	
	@Column(name = "add_street1")
	private String street1;
	
	@Column(name = "add_street2")
	private String street2;
	
	@Column(name = "add_city")
	private String city;
	
	@Column(name = "add_county")
	private String county;
	
	@Column(name = "add_state")
	private String stateCode;
	
	@Column(name = "add_zip")
	private int zip;
	
	@Column(name = "latitude")
	private double latitude;
	
	@Column(name = "longitude")
	private double longitude;
	
	@Column(name = "phone")
	private String phoneNumber;
	
	@Column(name = "phone_ext")
	private String phoneExtentionNumber;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "website")
	private String website;
	
	@Column(name = "description")
	private String freeformDescription;
	
	@Column(name = "NAICS_num")
	private int NAICSNum;
	
	@Column(name = "NAICS_description")
	private String NAICSDescription;
	
	@Column(name = "franchise_YN")
	private String isFranchise;
	
	@Column(name = "owner_claim_YN")
	private String isOwnerClaimed;
	
	@Column(name = "sqft_indoor")
	private int sqftIndoor;
	
	@Column(name = "sqft_outdoor")
	private int sqftOutdoor;
	
	@Column(name = "sqft_lot")
	private int sqftLot;
	
	@Column(name = "bldg_type")
	private String buildingType;
	
	@Column(name = "bldg_owned_YN")
	private String isBuildingOwned;
	
	@Column(name = "exp_monthly_rent")
	private int expenseMonthlyRent;
	
	@Column(name = "exp_monthlyMortgage")
	private int expenseMonthlyMortgage;
	
	@Column(name = "rev_monthly")
	private int revenueMonthly;
	
	@Column(name = "exp_monthly_material")
	private int expenseMonthlyMaterial;
	
	@Column(name = "exp_monthly_emp")
	private int expenseMonthlyEmp;
	
	@Column(name = "exp_monthly_utility")
	private int expenseMonthlyUtility;
	
	@Column(name = "exp_monthly_other")
	private int expenseMonthlyOther;
	
	@Column(name = "value_total_equipment")
	private int valueTotalEquipment;
	
	@Column(name = "value_total_furniture")
	private int valueTotalFurniture;
	
	@Column(name = "value_indoor_deco")
	private int valueIndoorDeco;
	
	@Column(name = "value_outdoor_deco")
	private int valueOutdoorDeco;
	
	@Column(name = "year_equipment")
	private int yearEquipment;
	
	@Column(name = "year_furniture")
	private int yearFurniture;
	
	@Column(name = "year_indoor_deco")
	private int yearIndoorDeco;
	
	@Column(name = "year_outdoor_deco")
	private int yearOutdoorDeco;
	
	@Column(name = "emp_FT_num")
	private int empFullTimeNum;
	
	@Column(name = "emp_PT_num")
	private int empPartTimeNum;
	
	@Column(name = "area_crime_score")
	private int areaCrimeScore;
	
	@Column(name = "area_walk_score")
	private int areaWalkScore;
	
	@Column(name = "area_attractions_score")
	private int areaAttractionsScore;
	
	@Column(name = "area_transit_score")
	private int areaTransitScore;
	
	@Column(name = "social_media_score")
	private int socialMediaScore;
	
	@Column(name = "1mile_rad_popln")
	private int populationIn1mileRadius;
	
	@Column(name = "1mile_rad_incoscore")
	private int incomeScoreIn1mileRadius;
	
	@Column(name = "3mile_rad_popln")
	private int populationIn3mileRadius;
	
	@Column(name = "3mile_rad_incoscore")
	private int incomeScoreIn3mileRadius;
	
	@Column(name = "5mile_rad_popln")
	private int populationIn5mileRadius;
	
	@Column(name = "5mile_rad_incoscore")
	private int incomeScoreIn5mileRadius;
	
	@Column(name = "dailypeople_doorfront_num")
	private int dailyPeoplAtDoorNum;
	
	@Column(name = "dailycar_parklot_num")
	private int dailyCarsAtParklotNum;
	
	@Column(name = "year_established")
	private String yearEstablished;
	
	@Column(name = "vendor_call_YN")
	private String isVendorCall;
	
	@Column(name = "createdby_user_id")
	private int createdByUserId;
	
	@Column(name = "create_date")
	private LocalDateTime createDate;
	
	@Column(name = "updatedby_user_id")
	private int updatedByUserId;
	
	@Column(name = "update_date")
	private LocalDateTime updateDate;

	public int getBusinessId() {
		return businessId;
	}

	public void setBusinessId(int businessId) {
		this.businessId = businessId;
	}

	public String getLegalName() {
		return legalName;
	}

	public void setLegalName(String legalName) {
		this.legalName = legalName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFirstOwnerName() {
		return firstOwnerName;
	}

	public void setFirstOwnerName(String firstOwnerName) {
		this.firstOwnerName = firstOwnerName;
	}

	public String getSecondOwnerName() {
		return secondOwnerName;
	}

	public void setSecondOwnerName(String secondOwnerName) {
		this.secondOwnerName = secondOwnerName;
	}

	public String getBrandName() {
		return brandName;
	}

	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getSubType() {
		return subType;
	}

	public void setSubType(String subType) {
		this.subType = subType;
	}

	public String getRegCityName() {
		return regCityName;
	}

	public void setRegCityName(String regCityName) {
		this.regCityName = regCityName;
	}

	public String getRegCityCode() {
		return regCityCode;
	}

	public void setRegCityCode(String regCityCode) {
		this.regCityCode = regCityCode;
	}

	public LocalDateTime getRegCityDate() {
		return regCityDate;
	}

	public void setRegCityDate(LocalDateTime regCityDate) {
		this.regCityDate = regCityDate;
	}

	public String getRegStateName() {
		return regStateName;
	}

	public void setRegStateName(String regStateName) {
		this.regStateName = regStateName;
	}

	public String getRegStateCode() {
		return regStateCode;
	}

	public void setRegStateCode(String regStateCode) {
		this.regStateCode = regStateCode;
	}

	public LocalDateTime getRegStateDate() {
		return regStateDate;
	}

	public void setRegStateDate(LocalDateTime regStateDate) {
		this.regStateDate = regStateDate;
	}

	public int getDataCompletenessScore() {
		return dataCompletenessScore;
	}

	public void setDataCompletenessScore(int dataCompletenessScore) {
		this.dataCompletenessScore = dataCompletenessScore;
	}

	public String getIsForSell() {
		return isForSell;
	}

	public void setIsForSell(String isForSell) {
		this.isForSell = isForSell;
	}

	public int getForSellPrice() {
		return forSellPrice;
	}

	public void setForSellPrice(int forSellPrice) {
		this.forSellPrice = forSellPrice;
	}

	public String getImageLogo() {
		return imageLogo;
	}

	public void setImageLogo(String imageLogo) {
		this.imageLogo = imageLogo;
	}

	public String getImageFirst() {
		return imageFirst;
	}

	public void setImageFirst(String imageFirst) {
		this.imageFirst = imageFirst;
	}

	public String getStreet1() {
		return street1;
	}

	public void setStreet1(String street1) {
		this.street1 = street1;
	}

	public String getStreet2() {
		return street2;
	}

	public void setStreet2(String street2) {
		this.street2 = street2;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCounty() {
		return county;
	}

	public void setCounty(String county) {
		this.county = county;
	}

	public String getStateCode() {
		return stateCode;
	}

	public void setStateCode(String stateCode) {
		this.stateCode = stateCode;
	}

	public int getZip() {
		return zip;
	}

	public void setZip(int zip) {
		this.zip = zip;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getPhoneExtentionNumber() {
		return phoneExtentionNumber;
	}

	public void setPhoneExtentionNumber(String phoneExtentionNumber) {
		this.phoneExtentionNumber = phoneExtentionNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public String getFreeformDescription() {
		return freeformDescription;
	}

	public void setFreeformDescription(String freeformDescription) {
		this.freeformDescription = freeformDescription;
	}

	public int getNAICSNum() {
		return NAICSNum;
	}

	public void setNAICSNum(int nAICSNum) {
		NAICSNum = nAICSNum;
	}

	public String getNAICSDescription() {
		return NAICSDescription;
	}

	public void setNAICSDescription(String nAICSDescription) {
		NAICSDescription = nAICSDescription;
	}

	public String getIsFranchise() {
		return isFranchise;
	}

	public void setIsFranchise(String isFranchise) {
		this.isFranchise = isFranchise;
	}

	public String getIsOwnerClaimed() {
		return isOwnerClaimed;
	}

	public void setIsOwnerClaimed(String isOwnerClaimed) {
		this.isOwnerClaimed = isOwnerClaimed;
	}

	public int getSqftIndoor() {
		return sqftIndoor;
	}

	public void setSqftIndoor(int sqftIndoor) {
		this.sqftIndoor = sqftIndoor;
	}

	public int getSqftOutdoor() {
		return sqftOutdoor;
	}

	public void setSqftOutdoor(int sqftOutdoor) {
		this.sqftOutdoor = sqftOutdoor;
	}

	public int getSqftLot() {
		return sqftLot;
	}

	public void setSqftLot(int sqftLot) {
		this.sqftLot = sqftLot;
	}

	public String getBuildingType() {
		return buildingType;
	}

	public void setBuildingType(String buildingType) {
		this.buildingType = buildingType;
	}

	public String getIsBuildingOwned() {
		return isBuildingOwned;
	}

	public void setIsBuildingOwned(String isBuildingOwned) {
		this.isBuildingOwned = isBuildingOwned;
	}

	public int getExpenseMonthlyRent() {
		return expenseMonthlyRent;
	}

	public void setExpenseMonthlyRent(int expenseMonthlyRent) {
		this.expenseMonthlyRent = expenseMonthlyRent;
	}

	public int getExpenseMonthlyMortgage() {
		return expenseMonthlyMortgage;
	}

	public void setExpenseMonthlyMortgage(int expenseMonthlyMortgage) {
		this.expenseMonthlyMortgage = expenseMonthlyMortgage;
	}

	public int getRevenueMonthly() {
		return revenueMonthly;
	}

	public void setRevenueMonthly(int revenueMonthly) {
		this.revenueMonthly = revenueMonthly;
	}

	public int getExpenseMonthlyMaterial() {
		return expenseMonthlyMaterial;
	}

	public void setExpenseMonthlyMaterial(int expenseMonthlyMaterial) {
		this.expenseMonthlyMaterial = expenseMonthlyMaterial;
	}

	public int getExpenseMonthlyEmp() {
		return expenseMonthlyEmp;
	}

	public void setExpenseMonthlyEmp(int expenseMonthlyEmp) {
		this.expenseMonthlyEmp = expenseMonthlyEmp;
	}

	public int getExpenseMonthlyUtility() {
		return expenseMonthlyUtility;
	}

	public void setExpenseMonthlyUtility(int expenseMonthlyUtility) {
		this.expenseMonthlyUtility = expenseMonthlyUtility;
	}

	public int getExpenseMonthlyOther() {
		return expenseMonthlyOther;
	}

	public void setExpenseMonthlyOther(int expenseMonthlyOther) {
		this.expenseMonthlyOther = expenseMonthlyOther;
	}

	public int getValueTotalEquipment() {
		return valueTotalEquipment;
	}

	public void setValueTotalEquipment(int valueTotalEquipment) {
		this.valueTotalEquipment = valueTotalEquipment;
	}

	public int getValueTotalFurniture() {
		return valueTotalFurniture;
	}

	public void setValueTotalFurniture(int valueTotalFurniture) {
		this.valueTotalFurniture = valueTotalFurniture;
	}

	public int getValueIndoorDeco() {
		return valueIndoorDeco;
	}

	public void setValueIndoorDeco(int valueIndoorDeco) {
		this.valueIndoorDeco = valueIndoorDeco;
	}

	public int getValueOutdoorDeco() {
		return valueOutdoorDeco;
	}

	public void setValueOutdoorDeco(int valueOutdoorDeco) {
		this.valueOutdoorDeco = valueOutdoorDeco;
	}

	public int getYearEquipment() {
		return yearEquipment;
	}

	public void setYearEquipment(int yearEquipment) {
		this.yearEquipment = yearEquipment;
	}

	public int getYearFurniture() {
		return yearFurniture;
	}

	public void setYearFurniture(int yearFurniture) {
		this.yearFurniture = yearFurniture;
	}

	public int getYearIndoorDeco() {
		return yearIndoorDeco;
	}

	public void setYearIndoorDeco(int yearIndoorDeco) {
		this.yearIndoorDeco = yearIndoorDeco;
	}

	public int getYearOutdoorDeco() {
		return yearOutdoorDeco;
	}

	public void setYearOutdoorDeco(int yearOutdoorDeco) {
		this.yearOutdoorDeco = yearOutdoorDeco;
	}
	
	public int getEmpFullTimeNum() {
		return empFullTimeNum;
	}

	public void setEmpFullTimeNum(int empFullTimeNum) {
		this.empFullTimeNum = empFullTimeNum;
	}

	public int getEmpPartTimeNum() {
		return empPartTimeNum;
	}

	public void setEmpPartTimeNum(int empPartTimeNum) {
		this.empPartTimeNum = empPartTimeNum;
	}

	public int getAreaCrimeScore() {
		return areaCrimeScore;
	}

	public void setAreaCrimeScore(int areaCrimeScore) {
		this.areaCrimeScore = areaCrimeScore;
	}

	public int getAreaWalkScore() {
		return areaWalkScore;
	}

	public void setAreaWalkScore(int areaWalkScore) {
		this.areaWalkScore = areaWalkScore;
	}

	public int getAreaAttractionsScore() {
		return areaAttractionsScore;
	}

	public void setAreaAttractionsScore(int areaAttractionsScore) {
		this.areaAttractionsScore = areaAttractionsScore;
	}

	public int getAreaTransitScore() {
		return areaTransitScore;
	}

	public void setAreaTransitScore(int areaTransitScore) {
		this.areaTransitScore = areaTransitScore;
	}

	public int getSocialMediaScore() {
		return socialMediaScore;
	}

	public void setSocialMediaScore(int socialMediaScore) {
		this.socialMediaScore = socialMediaScore;
	}

	public int getPopulationIn1mileRadius() {
		return populationIn1mileRadius;
	}

	public void setPopulationIn1mileRadius(int populationIn1mileRadius) {
		this.populationIn1mileRadius = populationIn1mileRadius;
	}

	public int getIncomeScoreIn1mileRadius() {
		return incomeScoreIn1mileRadius;
	}

	public void setIncomeScoreIn1mileRadius(int incomeScoreIn1mileRadius) {
		this.incomeScoreIn1mileRadius = incomeScoreIn1mileRadius;
	}

	public int getPopulationIn3mileRadius() {
		return populationIn3mileRadius;
	}

	public void setPopulationIn3mileRadius(int populationIn3mileRadius) {
		this.populationIn3mileRadius = populationIn3mileRadius;
	}

	public int getIncomeScoreIn3mileRadius() {
		return incomeScoreIn3mileRadius;
	}

	public void setIncomeScoreIn3mileRadius(int incomeScoreIn3mileRadius) {
		this.incomeScoreIn3mileRadius = incomeScoreIn3mileRadius;
	}

	public int getPopulationIn5mileRadius() {
		return populationIn5mileRadius;
	}

	public void setPopulationIn5mileRadius(int populationIn5mileRadius) {
		this.populationIn5mileRadius = populationIn5mileRadius;
	}

	public int getIncomeScoreIn5mileRadius() {
		return incomeScoreIn5mileRadius;
	}

	public void setIncomeScoreIn5mileRadius(int incomeScoreIn5mileRadius) {
		this.incomeScoreIn5mileRadius = incomeScoreIn5mileRadius;
	}

	public int getDailyPeoplAtDoorNum() {
		return dailyPeoplAtDoorNum;
	}

	public void setDailyPeoplAtDoorNum(int dailyPeoplAtDoorNum) {
		this.dailyPeoplAtDoorNum = dailyPeoplAtDoorNum;
	}

	public int getDailyCarsAtParklotNum() {
		return dailyCarsAtParklotNum;
	}

	public void setDailyCarsAtParklotNum(int dailyCarsAtParklotNum) {
		this.dailyCarsAtParklotNum = dailyCarsAtParklotNum;
	}

	public String getYearEstablished() {
		return yearEstablished;
	}

	public void setYearEstablished(String yearEstablished) {
		this.yearEstablished = yearEstablished;
	}
	
	public String getIsVendorCall() {
		return isVendorCall;
	}

	public void setIsVendorCall(String isVendorCall) {
		this.isVendorCall = isVendorCall;
	}

	public int getCreatedByUserId() {
		return createdByUserId;
	}

	public void setCreatedByUserId(int createdByUserId) {
		this.createdByUserId = createdByUserId;
	}

	public LocalDateTime getCreateDate() {
		return createDate;
	}

	public void setCreateDate(LocalDateTime createDate) {
		this.createDate = createDate;
	}

	public int getUpdatedByUserId() {
		return updatedByUserId;
	}

	public void setUpdatedByUserId(int updatedByUserId) {
		this.updatedByUserId = updatedByUserId;
	}

	public LocalDateTime getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(LocalDateTime updateDate) {
		this.updateDate = updateDate;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}