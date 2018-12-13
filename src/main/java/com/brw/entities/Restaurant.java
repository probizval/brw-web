package com.brw.entities;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Table(name = "rw_restaurant")
@Inheritance(strategy = InheritanceType.JOINED)
public class Restaurant implements Serializable {

	private static final long serialVersionUID = 2213403845608642436L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "type")
	private String type;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "indoor_seating_capacity")
	private String indoorSeatingCapacity;
	
	@Column(name = "outdoor_seating_capacity")
	private String outdoorSeatingCapacity;
	
	@Column(name = "kitchen_hood_size")
	private String kitchenHoodSize;
	
	@Column(name = "kitchen_sqft")
	private String kitchenSqft;
	
	@Column(name = "available_appliances")
	private String availableAppliances;
	
	@Column(name = "dish_washer")
	private String dishWasher;
	
	@Column(name = "oven")
	private String oven;
	
	@Column(name = "cooking_range")
	private String cookingRange;
	
	@Column(name = "fryers")
	private String fryers;
	
	@Column(name = "total_cost_utensils")
	private String totalCostUtensils;
	
	@Column(name = "interior_sqft")
	private String interiorSqft;

	@Column(name = "interior_seating_arrangement")
	private String interiorSeatingArrangement;
	
	@Column(name = "interior_cost")
	private String interiorCost;
	
	@Column(name = "interior_features")
	private String interiorFeatures;
	
	@Column(name = "interior_electronics")
	private String interiorElectronics;
	
	@Column(name = "interior_restrooms")
	private String interiorRestrooms;
	
	@Column(name = "interior_restrooms_ADA")
	private String interiorRestroomsADA;
	
	@Column(name = "bar_type")
	private String barType;
	
	@Column(name = "bar_seating_capacity")
	private String barSeatingCapacity;
	
	@Column(name = "last_renovation_date")
	private Date lastRenovationDate;
	
	@Column(name = "conidtion")
	private String condition;
	
	@Column(name = "waiting_area")
	private String waitingArea;
	
	@Column(name = "dry_storage")
	private String dryStorage;
	
	@Column(name = "exterior_type")
	private String exteriorType;
	
	@Column(name = "parking")
	private String parking;
	
	@Column(name = "security")
	private String security;
	
	@Column(name = "surrounding_business")
	private String surroundingBusiness;
	
	@Column(name = "monthly_rent")
	private String monthlyRent;
	
	@Column(name = "nnn_expense")
	private String nnnExpense;
	
	@Column(name = "garbage_expense")
	private String garbageExpense;
	
	@Column(name = "utilities_expense")
	private String utilitiesExpense;
	
	@Column(name = "residential_area")
	private String residentialArea;
	
	@Column(name = "wiki_demo_link")
	private String wikiDemoLink;
	
	@Column(name = "walkscore")
	private String walkscore;
	
	@Column(name = "avg_age")
	private String avgAge;
	
	@Column(name = "avg_income")
	private String avgIncome;
	
	@Column(name = "crime_indicator")
	private String crimeIndicator;
	
	@Column(name = "avg_revenue_in_resto")
	private String avgRevenueInResto;
	
	@Column(name = "avg_revenue_to_go")
	private String avgRevenueToGo;
	
	@Column(name = "avg_revenue_catering")
	private String avgRevenueCatering;
	
	@Column(name = "avg_revenue_liquer")
	private String avgTevenueLiquer;
	
	@Column(name = "total_emp")
	private String total_emp;
	
	@Column(name = "certified_emp")
	private String certified_emp;
	
	@Column(name = "fulltime_emp")
	private String fulltime_emp;
	
	@Column(name = "parttiem_emp")
	private String parttime_emp;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getIndoorSeatingCapacity() {
		return indoorSeatingCapacity;
	}

	public void setIndoorSeatingCapacity(String indoorSeatingCapacity) {
		this.indoorSeatingCapacity = indoorSeatingCapacity;
	}

	public String getOutdoorSeatingCapacity() {
		return outdoorSeatingCapacity;
	}

	public void setOutdoorSeatingCapacity(String outdoorSeatingCapacity) {
		this.outdoorSeatingCapacity = outdoorSeatingCapacity;
	}

	public String getKitchenHoodSize() {
		return kitchenHoodSize;
	}

	public void setKitchenHoodSize(String kitchenHoodSize) {
		this.kitchenHoodSize = kitchenHoodSize;
	}

	public String getKitchenSqft() {
		return kitchenSqft;
	}

	public void setKitchenSqft(String kitchenSqft) {
		this.kitchenSqft = kitchenSqft;
	}

	public String getAvailableAppliances() {
		return availableAppliances;
	}

	public void setAvailableAppliances(String availableAppliances) {
		this.availableAppliances = availableAppliances;
	}

	public String getDishWasher() {
		return dishWasher;
	}

	public void setDishWasher(String dishWasher) {
		this.dishWasher = dishWasher;
	}

	public String getOven() {
		return oven;
	}

	public void setOven(String oven) {
		this.oven = oven;
	}

	public String getCookingRange() {
		return cookingRange;
	}

	public void setCookingRange(String cookingRange) {
		this.cookingRange = cookingRange;
	}

	public String getFryers() {
		return fryers;
	}

	public void setFryers(String fryers) {
		this.fryers = fryers;
	}

	public String getTotalCostUtensils() {
		return totalCostUtensils;
	}

	public void setTotalCostUtensils(String totalCostUtensils) {
		this.totalCostUtensils = totalCostUtensils;
	}

	public String getInteriorSqft() {
		return interiorSqft;
	}

	public void setInteriorSqft(String interiorSqft) {
		this.interiorSqft = interiorSqft;
	}

	public String getInteriorSeatingArrangement() {
		return interiorSeatingArrangement;
	}

	public void setInteriorSeatingArrangement(String interiorSeatingArrangement) {
		this.interiorSeatingArrangement = interiorSeatingArrangement;
	}

	public String getInteriorCost() {
		return interiorCost;
	}

	public void setInteriorCost(String interiorCost) {
		this.interiorCost = interiorCost;
	}

	public String getInteriorFeatures() {
		return interiorFeatures;
	}

	public void setInteriorFeatures(String interiorFeatures) {
		this.interiorFeatures = interiorFeatures;
	}

	public String getInteriorElectronics() {
		return interiorElectronics;
	}

	public void setInteriorElectronics(String interiorElectronics) {
		this.interiorElectronics = interiorElectronics;
	}

	public String getInteriorRestrooms() {
		return interiorRestrooms;
	}

	public void setInteriorRestrooms(String interiorRestrooms) {
		this.interiorRestrooms = interiorRestrooms;
	}

	public String getInteriorRestroomsADA() {
		return interiorRestroomsADA;
	}

	public void setInteriorRestroomsADA(String interiorRestroomsADA) {
		this.interiorRestroomsADA = interiorRestroomsADA;
	}

	public String getBarType() {
		return barType;
	}

	public void setBarType(String barType) {
		this.barType = barType;
	}

	public String getBarSeatingCapacity() {
		return barSeatingCapacity;
	}

	public void setBarSeatingCapacity(String barSeatingCapacity) {
		this.barSeatingCapacity = barSeatingCapacity;
	}

	public Date getLastRenovationDate() {
		return lastRenovationDate;
	}

	public void setLastRenovationDate(Date lastRenovationDate) {
		this.lastRenovationDate = lastRenovationDate;
	}

	public String getCondition() {
		return condition;
	}

	public void setCondition(String condition) {
		this.condition = condition;
	}

	public String getWaitingArea() {
		return waitingArea;
	}

	public void setWaitingArea(String waitingArea) {
		this.waitingArea = waitingArea;
	}

	public String getDryStorage() {
		return dryStorage;
	}

	public void setDryStorage(String dryStorage) {
		this.dryStorage = dryStorage;
	}

	public String getExteriorType() {
		return exteriorType;
	}

	public void setExteriorType(String exteriorType) {
		this.exteriorType = exteriorType;
	}

	public String getParking() {
		return parking;
	}

	public void setParking(String parking) {
		this.parking = parking;
	}

	public String getSecurity() {
		return security;
	}

	public void setSecurity(String security) {
		this.security = security;
	}

	public String getSurroundingBusiness() {
		return surroundingBusiness;
	}

	public void setSurroundingBusiness(String surroundingBusiness) {
		this.surroundingBusiness = surroundingBusiness;
	}

	public String getMonthlyRent() {
		return monthlyRent;
	}

	public void setMonthlyRent(String monthlyRent) {
		this.monthlyRent = monthlyRent;
	}

	public String getNnnExpense() {
		return nnnExpense;
	}

	public void setNnnExpense(String nnnExpense) {
		this.nnnExpense = nnnExpense;
	}

	public String getGarbageExpense() {
		return garbageExpense;
	}

	public void setGarbageExpense(String garbageExpense) {
		this.garbageExpense = garbageExpense;
	}

	public String getUtilitiesExpense() {
		return utilitiesExpense;
	}

	public void setUtilitiesExpense(String utilitiesExpense) {
		this.utilitiesExpense = utilitiesExpense;
	}

	public String getResidentialArea() {
		return residentialArea;
	}

	public void setResidentialArea(String residentialArea) {
		this.residentialArea = residentialArea;
	}

	public String getWikiDemoLink() {
		return wikiDemoLink;
	}

	public void setWikiDemoLink(String wikiDemoLink) {
		this.wikiDemoLink = wikiDemoLink;
	}

	public String getWalkscore() {
		return walkscore;
	}

	public void setWalkscore(String walkscore) {
		this.walkscore = walkscore;
	}

	public String getAvgAge() {
		return avgAge;
	}

	public void setAvgAge(String avgAge) {
		this.avgAge = avgAge;
	}

	public String getAvgIncome() {
		return avgIncome;
	}

	public void setAvgIncome(String avgIncome) {
		this.avgIncome = avgIncome;
	}

	public String getCrimeIndicator() {
		return crimeIndicator;
	}

	public void setCrimeIndicator(String crimeIndicator) {
		this.crimeIndicator = crimeIndicator;
	}

	public String getAvgRevenueInResto() {
		return avgRevenueInResto;
	}

	public void setAvgRevenueInResto(String avgRevenueInResto) {
		this.avgRevenueInResto = avgRevenueInResto;
	}

	public String getAvgRevenueToGo() {
		return avgRevenueToGo;
	}

	public void setAvgRevenueToGo(String avgRevenueToGo) {
		this.avgRevenueToGo = avgRevenueToGo;
	}

	public String getAvgRevenueCatering() {
		return avgRevenueCatering;
	}

	public void setAvgRevenueCatering(String avgRevenueCatering) {
		this.avgRevenueCatering = avgRevenueCatering;
	}

	public String getAvgTevenueLiquer() {
		return avgTevenueLiquer;
	}

	public void setAvgTevenueLiquer(String avgTevenueLiquer) {
		this.avgTevenueLiquer = avgTevenueLiquer;
	}

	public String getTotal_emp() {
		return total_emp;
	}

	public void setTotal_emp(String total_emp) {
		this.total_emp = total_emp;
	}

	public String getCertified_emp() {
		return certified_emp;
	}

	public void setCertified_emp(String certified_emp) {
		this.certified_emp = certified_emp;
	}

	public String getFulltime_emp() {
		return fulltime_emp;
	}

	public void setFulltime_emp(String fulltime_emp) {
		this.fulltime_emp = fulltime_emp;
	}

	public String getParttime_emp() {
		return parttime_emp;
	}

	public void setParttime_emp(String parttime_emp) {
		this.parttime_emp = parttime_emp;
	}

	
	
}
