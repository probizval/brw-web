package com.brw.dto;

import java.util.List;
import com.brw.entities.PropertyDetails;
import com.brw.entities.PropertyImages;

public class CoinLaundryDetailsDTO {
	
	private int id;
	
	private String numberOfWashers;
	
	private String numberOfDryers;
	
	private String costOfEquip;
	
	private String features;
	
	private String restrooms;
	
	private String supplies;
	
	private String coinDispensers;
	
	private String seatingCapacity;
	
	private String totalSqft;
	
	private String counterSpace;
	
	private String carts;
	
	private String waterFactor;
	
	private String utilities;
	
	private String demographicsPopulation;
	
	private String maintenanceContracts;
	
	private String machinManufactures;
	
	private String machineEfficiences;
	
	private String machineLifespan;
	
	private String associationWithOthers;
	
    private PropertyDetails propertyMetaData;
	
	private List<PropertyImages> propertyImages;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNumberOfWashers() {
		return numberOfWashers;
	}

	public void setNumberOfWashers(String numberOfWashers) {
		this.numberOfWashers = numberOfWashers;
	}

	public String getNumberOfDryers() {
		return numberOfDryers;
	}

	public void setNumberOfDryers(String numberOfDryers) {
		this.numberOfDryers = numberOfDryers;
	}

	public String getCostOfEquip() {
		return costOfEquip;
	}

	public void setCostOfEquip(String costOfEquip) {
		this.costOfEquip = costOfEquip;
	}

	public String getFeatures() {
		return features;
	}

	public void setFeatures(String features) {
		this.features = features;
	}

	public String getRestrooms() {
		return restrooms;
	}

	public void setRestrooms(String restrooms) {
		this.restrooms = restrooms;
	}

	public String getSupplies() {
		return supplies;
	}

	public void setSupplies(String supplies) {
		this.supplies = supplies;
	}

	public String getCoinDispensers() {
		return coinDispensers;
	}

	public void setCoinDispensers(String coinDispensers) {
		this.coinDispensers = coinDispensers;
	}

	public String getSeatingCapacity() {
		return seatingCapacity;
	}

	public void setSeatingCapacity(String seatingCapacity) {
		this.seatingCapacity = seatingCapacity;
	}

	public String getTotalSqft() {
		return totalSqft;
	}

	public void setTotalSqft(String totalSqft) {
		this.totalSqft = totalSqft;
	}

	public String getCounterSpace() {
		return counterSpace;
	}

	public void setCounterSpace(String counterSpace) {
		this.counterSpace = counterSpace;
	}

	public String getCarts() {
		return carts;
	}

	public void setCarts(String carts) {
		this.carts = carts;
	}

	public String getWaterFactor() {
		return waterFactor;
	}

	public void setWaterFactor(String waterFactor) {
		this.waterFactor = waterFactor;
	}

	public String getUtilities() {
		return utilities;
	}

	public void setUtilities(String utilities) {
		this.utilities = utilities;
	}

	public String getDemographicsPopulation() {
		return demographicsPopulation;
	}

	public void setDemographicsPopulation(String demographicsPopulation) {
		this.demographicsPopulation = demographicsPopulation;
	}

	public String getMaintenanceContracts() {
		return maintenanceContracts;
	}

	public void setMaintenanceContracts(String maintenanceContracts) {
		this.maintenanceContracts = maintenanceContracts;
	}

	public String getMachinManufactures() {
		return machinManufactures;
	}

	public void setMachinManufactures(String machinManufactures) {
		this.machinManufactures = machinManufactures;
	}

	public String getMachineEfficiences() {
		return machineEfficiences;
	}

	public void setMachineEfficiences(String machineEfficiences) {
		this.machineEfficiences = machineEfficiences;
	}

	public String getMachineLifespan() {
		return machineLifespan;
	}

	public void setMachineLifespan(String machineLifespan) {
		this.machineLifespan = machineLifespan;
	}

	public String getAssociationWithOthers() {
		return associationWithOthers;
	}

	public void setAssociationWithOthers(String associationWithOthers) {
		this.associationWithOthers = associationWithOthers;
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