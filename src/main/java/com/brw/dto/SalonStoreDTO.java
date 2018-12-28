package com.brw.dto;

import java.util.List;

import javax.persistence.Column;

import com.brw.entities.PropertyDetails;
import com.brw.entities.PropertyImages;

public class SalonStoreDTO {

	private int id;
	
	private Boolean nailCare;
	
	private Boolean skinCare;
	
	private Boolean lashExtension;
	
	private Boolean massage;
	
	private Boolean bodyTreatments;
	
	private String locationOfspa;
	
	private String walkscore;
	
	private String avgAge;
	
	private String avgIncome;
	
	private String interiorSqft;
	
	private String manicureTables;
	
	private String nailDryers;
	
	private String portablePedicureSpa;
	
	private String nailSalonTrolleys;
	
	private String pedicureSpaChairs;
	
	private String interiorFeatures;
	
	private String restrooms;
	
	private String waitingArea;
	
	private String receptionArea;
	
	private String capacity;
	
	private String lastRenovation;

	private String staffRooms;
	
	private String exteriorSignage;
	
	private String anchorBusiness;
	
	private String typeOfBuilding;
	
	private String parking;
	
	private String rent;
	
	private String water;
	
	private String electricity;
	
	private String garbage;
	
	private String employee;
	
    private PropertyDetails propertyMetaData;
	
	private List<PropertyImages> propertyImages;

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

	public PropertyDetails getPropertyMetaData() {
		return propertyMetaData;
	}

	public void setPropertyMetaData(PropertyDetails propertyMetaData) {
		this.propertyMetaData = propertyMetaData;
	}

	public List<PropertyImages> getPropertyImages() {
		return propertyImages;
	}

	public void setPropertyImages(List<PropertyImages> propertyImages) {
		this.propertyImages = propertyImages;
	}
	
	
}
