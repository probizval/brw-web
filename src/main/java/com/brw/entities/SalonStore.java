package com.brw.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Table(name = "rw_nail_care_store")
@Inheritance(strategy = InheritanceType.JOINED)
public class SalonStore implements Serializable {

	private static final long serialVersionUID = -2576554907834223751L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "nail_care")
	private Boolean nailCare;
	
	@Column(name = "skin_care")
	private Boolean skinCare;
	
	@Column(name = "lash_extension")
	private Boolean lashExtension;
	
	@Column(name = "massage")
	private Boolean massage;
	
	@Column(name = "body_treatments")
	private Boolean bodyTreatments;
	
	@Column(name = "location_of_spa")
	private String locationOfspa;
	
	@Column(name = "walkscore")
	private String walkscore;
	
	@Column(name = "avg_age")
	private String avgAge;
	
	@Column(name = "avg_income")
	private String avgIncome;
	
	@Column(name = "interior_sqft")
	private String interiorSqft;
	
	@Column(name = "manicure_tables")
	private String manicureTables;
	
	@Column(name = "nail_dryers")
	private String nailDryers;
	
	@Column(name = "portable_pedicure_spa")
	private String portablePedicureSpa;
	
	@Column(name = "nail_salon_trolleys")
	private String nailSalonTrolleys;
	
	@Column(name = "pedicure_spa_chairs")
	private String pedicureSpaChairs;
	
	@Column(name = "interior_features")
	private String interiorFeatures;
	
	@Column(name = "restrooms")
	private String restrooms;
	
	@Column(name = "waiting_area")
	private String waitingArea;
	
	@Column(name = "reception_area")
	private String receptionArea;
	
	
	@Column(name = "capacity")
	private String capacity;
	
	@Column(name = "last_renovation")
	private String lastRenovation;

	@Column(name = "staff_rooms")
	private String staffRooms;
	
	@Column(name = "exterior_signage")
	private String exteriorSignage;
	
	@Column(name = "anchor_business")
	private String anchorBusiness;
	
	@Column(name = "type_of_building")
	private String typeOfBuilding;
	
	@Column(name = "parking")
	private String parking;
	
	@Column(name = "rent")
	private String rent;
	
	@Column(name = "water")
	private String water;
	
	@Column(name = "electricity")
	private String electricity;
	
	@Column(name = "garbage")
	private String garbage;
	
	@Column(name = "employee")
	private String employee;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Boolean getNailCare() {
		return nailCare;
	}

	public void setNailCare(Boolean nailCare) {
		this.nailCare = nailCare;
	}

	public Boolean getSkinCare() {
		return skinCare;
	}

	public void setSkinCare(Boolean skinCare) {
		this.skinCare = skinCare;
	}

	public Boolean getLashExtension() {
		return lashExtension;
	}

	public void setLashExtension(Boolean lashExtension) {
		this.lashExtension = lashExtension;
	}

	public Boolean getMassage() {
		return massage;
	}

	public void setMassage(Boolean massage) {
		this.massage = massage;
	}

	public Boolean getBodyTreatments() {
		return bodyTreatments;
	}

	public void setBodyTreatments(Boolean bodyTreatments) {
		this.bodyTreatments = bodyTreatments;
	}

	public String getLocationOfspa() {
		return locationOfspa;
	}

	public void setLocationOfspa(String locationOfspa) {
		this.locationOfspa = locationOfspa;
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

	public String getInteriorSqft() {
		return interiorSqft;
	}

	public void setInteriorSqft(String interiorSqft) {
		this.interiorSqft = interiorSqft;
	}

	public String getManicureTables() {
		return manicureTables;
	}

	public void setManicureTables(String manicureTables) {
		this.manicureTables = manicureTables;
	}

	public String getNailDryers() {
		return nailDryers;
	}

	public void setNailDryers(String nailDryers) {
		this.nailDryers = nailDryers;
	}

	public String getPortablePedicureSpa() {
		return portablePedicureSpa;
	}

	public void setPortablePedicureSpa(String portablePedicureSpa) {
		this.portablePedicureSpa = portablePedicureSpa;
	}

	public String getNailSalonTrolleys() {
		return nailSalonTrolleys;
	}

	public void setNailSalonTrolleys(String nailSalonTrolleys) {
		this.nailSalonTrolleys = nailSalonTrolleys;
	}

	public String getPedicureSpaChairs() {
		return pedicureSpaChairs;
	}

	public void setPedicureSpaChairs(String pedicureSpaChairs) {
		this.pedicureSpaChairs = pedicureSpaChairs;
	}

	public String getInteriorFeatures() {
		return interiorFeatures;
	}

	public void setInteriorFeatures(String interiorFeatures) {
		this.interiorFeatures = interiorFeatures;
	}

	public String getRestrooms() {
		return restrooms;
	}

	public void setRestrooms(String restrooms) {
		this.restrooms = restrooms;
	}

	public String getWaitingArea() {
		return waitingArea;
	}

	public void setWaitingArea(String waitingArea) {
		this.waitingArea = waitingArea;
	}

	public String getReceptionArea() {
		return receptionArea;
	}

	public void setReceptionArea(String receptionArea) {
		this.receptionArea = receptionArea;
	}

	public String getCapacity() {
		return capacity;
	}

	public void setCapacity(String capacity) {
		this.capacity = capacity;
	}

	public String getLastRenovation() {
		return lastRenovation;
	}

	public void setLastRenovation(String lastRenovation) {
		this.lastRenovation = lastRenovation;
	}

	public String getStaffRooms() {
		return staffRooms;
	}

	public void setStaffRooms(String staffRooms) {
		this.staffRooms = staffRooms;
	}

	public String getExteriorSignage() {
		return exteriorSignage;
	}

	public void setExteriorSignage(String exteriorSignage) {
		this.exteriorSignage = exteriorSignage;
	}

	public String getAnchorBusiness() {
		return anchorBusiness;
	}

	public void setAnchorBusiness(String anchorBusiness) {
		this.anchorBusiness = anchorBusiness;
	}

	public String getTypeOfBuilding() {
		return typeOfBuilding;
	}

	public void setTypeOfBuilding(String typeOfBuilding) {
		this.typeOfBuilding = typeOfBuilding;
	}

	public String getParking() {
		return parking;
	}

	public void setParking(String parking) {
		this.parking = parking;
	}

	public String getRent() {
		return rent;
	}

	public void setRent(String rent) {
		this.rent = rent;
	}

	public String getWater() {
		return water;
	}

	public void setWater(String water) {
		this.water = water;
	}

	public String getElectricity() {
		return electricity;
	}

	public void setElectricity(String electricity) {
		this.electricity = electricity;
	}

	public String getGarbage() {
		return garbage;
	}

	public void setGarbage(String garbage) {
		this.garbage = garbage;
	}

	public String getEmployee() {
		return employee;
	}

	public void setEmployee(String employee) {
		this.employee = employee;
	}
	
	
}
