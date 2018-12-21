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
@Table(name = "rw_coin_laundry")
@Inheritance(strategy = InheritanceType.JOINED)
public class CoinLaundry implements Serializable {

	private static final long serialVersionUID = 6997167784266760272L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "no_of_washers")
	private String numberOfWashers;
	
	@Column(name = "no_of_dryers")
	private String numberOfDryers;
	
	@Column(name = "cost_of_equip")
	private String costOfEquip;
	
	@Column(name = "features")
	private String features;
	
	@Column(name = "restrooms")
	private String restrooms;
	
	@Column(name = "supplies")
	private String supplies;
	
	@Column(name = "coin_dispensers")
	private String coinDispensers;
	
	@Column(name = "seating_capacity")
	private String seatingCapacity;
	
	@Column(name = "total_sqft")
	private String totalSqft;
	
	@Column(name = "counter_space")
	private String counterSpace;
	
	@Column(name = "carts")
	private String carts;
	
	@Column(name = "water_factor")
	private String waterFactor;
	
	@Column(name = "utilities")
	private String utilities;
	
	@Column(name = "demographics_population")
	private String demographicsPopulation;
	
	@Column(name = "maintenance_contracts")
	private String maintenanceContracts;
	
	@Column(name = "machin_manufactures")
	private String machinManufactures;
	
	@Column(name = "machine_efficiences")
	private String machineEfficiences;
	
	@Column(name = "machine_lifespan")
	private String machineLifespan;
	
	@Column(name = "association_with_others")
	private String associationWithOthers;

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
}