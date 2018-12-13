package com.brw.entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.Table;
import javax.persistence.InheritanceType;

@Entity
@Table(name = "rw_gas_station")
@Inheritance(strategy = InheritanceType.JOINED)
public class GasStation implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2940769117336790377L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "brand")
	private String brand;
	
	@Column(name = "fuel_type")
	private String fuelType;
	
	@Column(name = "frannchise")
	private String frannchise;
	
	@Column(name = "no_of_pumps")
	private String numberOfPumps;
	
	@Column(name = "gasoline_capacity")
	private String gasolineCapacity;
	
	
	@Column(name = "disel_capacity")
	private String diselCapacity;
	
	@Column(name = "store_brand")
	private String storeBrand;
	
	@Column(name = "store_approx_inventory_cost")
	private String storeApproxInventoryCost;
	
	@Column(name = "food_court_seating_capacity")
	private String foodCourtSeatingCapacity;
	
	@Column(name = "car_wash_equip_cost")
	private String carWashEquipCost;
	
	@Column(name = "atm")
	private String atm;
	
	@Column(name = "restroom")
	private String 	restroom;
	
	@Column(name = "lot_size")
	private String lotSize;
	
	@Column(name = "number_of_parking")
	private String numberOfParking;
	
	@Column(name = "fire_equip")
	private String fireEquip;
	
	@Column(name = "fire_capacity")
	private String fireCapacity;
	
	@Column(name = "auto_supply_repair_maint_shop")
	private String autoSupplyRepairMaintShop;
	
	@Column(name = "liquer_store")
	private String liquerStore;
	
	@Column(name = "local_community")
	private String localCommunity;
	
	@Column(name = "truck_parking")
	private String truckParking;
	
	@Column(name = "signage_size")
	private String signageSize;
	
	@Column(name = "signage_highvisibility")
	private String signagehighvisibility;
	
	@Column(name = "timings")
	private String timings;
	
	@Column(name = "type_of_service")
	private String typeOfService;
	
	
	public String getFrannchise() {
		return frannchise;
	}

	public void setFrannchise(String frannchise) {
		this.frannchise = frannchise;
	}

	public String getNumberOfPumps() {
		return numberOfPumps;
	}

	public void setNumberOfPumps(String numberOfPumps) {
		this.numberOfPumps = numberOfPumps;
	}

	public String getGasolineCapacity() {
		return gasolineCapacity;
	}

	public void setGasolineCapacity(String gasolineCapacity) {
		this.gasolineCapacity = gasolineCapacity;
	}

	public String getDiselCapacity() {
		return diselCapacity;
	}

	public void setDiselCapacity(String diselCapacity) {
		this.diselCapacity = diselCapacity;
	}

	public String getStoreBrand() {
		return storeBrand;
	}

	public void setStoreBrand(String storeBrand) {
		this.storeBrand = storeBrand;
	}

	public String getStoreApproxInventoryCost() {
		return storeApproxInventoryCost;
	}

	public void setStoreApproxInventoryCost(String storeApproxInventoryCost) {
		this.storeApproxInventoryCost = storeApproxInventoryCost;
	}

	public String getFoodCourtSeatingCapacity() {
		return foodCourtSeatingCapacity;
	}

	public void setFoodCourtSeatingCapacity(String foodCourtSeatingCapacity) {
		this.foodCourtSeatingCapacity = foodCourtSeatingCapacity;
	}

	public String getCarWashEquipCost() {
		return carWashEquipCost;
	}

	public void setCarWashEquipCost(String carWashEquipCost) {
		this.carWashEquipCost = carWashEquipCost;
	}

	public String getAtm() {
		return atm;
	}

	public void setAtm(String atm) {
		this.atm = atm;
	}

	public String getRestroom() {
		return restroom;
	}

	public void setRestroom(String restroom) {
		this.restroom = restroom;
	}

	public String getLotSize() {
		return lotSize;
	}

	public void setLotSize(String lotSize) {
		this.lotSize = lotSize;
	}

	public String getNumberOfParking() {
		return numberOfParking;
	}

	public void setNumberOfParking(String numberOfParking) {
		this.numberOfParking = numberOfParking;
	}

	public String getFireEquip() {
		return fireEquip;
	}

	public void setFireEquip(String fireEquip) {
		this.fireEquip = fireEquip;
	}

	public String getFireCapacity() {
		return fireCapacity;
	}

	public void setFireCapacity(String fireCapacity) {
		this.fireCapacity = fireCapacity;
	}

	public String getAutoSupplyRepairMaintShop() {
		return autoSupplyRepairMaintShop;
	}

	public void setAutoSupplyRepairMaintShop(String autoSupplyRepairMaintShop) {
		this.autoSupplyRepairMaintShop = autoSupplyRepairMaintShop;
	}

	public String getLiquerStore() {
		return liquerStore;
	}

	public void setLiquerStore(String liquerStore) {
		this.liquerStore = liquerStore;
	}

	public String getLocalCommunity() {
		return localCommunity;
	}

	public void setLocalCommunity(String localCommunity) {
		this.localCommunity = localCommunity;
	}

	public String getTruckParking() {
		return truckParking;
	}

	public void setTruckParking(String truckParking) {
		this.truckParking = truckParking;
	}

	public String getSignageSize() {
		return signageSize;
	}

	public void setSignageSize(String signageSize) {
		this.signageSize = signageSize;
	}

	public String getSignagehighvisibility() {
		return signagehighvisibility;
	}

	public void setSignagehighvisibility(String signagehighvisibility) {
		this.signagehighvisibility = signagehighvisibility;
	}

	public String getTimings() {
		return timings;
	}

	public void setTimings(String timings) {
		this.timings = timings;
	}

	public String getTypeOfService() {
		return typeOfService;
	}

	public void setTypeOfService(String typeOfService) {
		this.typeOfService = typeOfService;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getFuelType() {
		return fuelType;
	}

	public void setFuelType(String fuelType) {
		this.fuelType = fuelType;
	}
	
	

}
