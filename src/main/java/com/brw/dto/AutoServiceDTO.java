package com.brw.dto;

import java.util.List;

import javax.persistence.Column;

import com.brw.entities.PropertyDetails;
import com.brw.entities.PropertyImages;

public class AutoServiceDTO {

	private int id;
	
	private String parkingSpace;
	
	private String equipmentPneumaticPlatform;
	
	private String equipmentCrane;
	
	private String equipmentOilStorage;
	
	private String equipmentApprCost;
	
	private String equipmentStorage;
	
	private String equipmentOthers;
	
	private String equipmentPressureWash;
	
	private String waitingAreaSqft;
	
	private String waitingAreaApprCost;
	
	private String avgMonthlyRepeatCustomers;
	
	private String avgMonthlyNewCustomers;
	
	private String avgMonthlyMaintanceContracts;
	
	private String totalNumberOfEmployees;
	
	private String totalCertifiedEmployees;
	
	private String totalFullTimeEmployees;
	
	private String totalPartTimeEmployees;
	
    private PropertyDetails propertyMetaData;
	
	private List<PropertyImages> propertyImages;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getParkingSpace() {
		return parkingSpace;
	}

	public void setParkingSpace(String parkingSpace) {
		this.parkingSpace = parkingSpace;
	}

	public String getEquipmentPneumaticPlatform() {
		return equipmentPneumaticPlatform;
	}

	public void setEquipmentPneumaticPlatform(String equipmentPneumaticPlatform) {
		this.equipmentPneumaticPlatform = equipmentPneumaticPlatform;
	}

	public String getEquipmentCrane() {
		return equipmentCrane;
	}

	public void setEquipmentCrane(String equipmentCrane) {
		this.equipmentCrane = equipmentCrane;
	}

	public String getEquipmentOilStorage() {
		return equipmentOilStorage;
	}

	public void setEquipmentOilStorage(String equipmentOilStorage) {
		this.equipmentOilStorage = equipmentOilStorage;
	}

	public String getEquipmentApprCost() {
		return equipmentApprCost;
	}

	public void setEquipmentApprCost(String equipmentApprCost) {
		this.equipmentApprCost = equipmentApprCost;
	}

	public String getEquipmentStorage() {
		return equipmentStorage;
	}

	public void setEquipmentStorage(String equipmentStorage) {
		this.equipmentStorage = equipmentStorage;
	}

	public String getEquipmentOthers() {
		return equipmentOthers;
	}

	public void setEquipmentOthers(String equipmentOthers) {
		this.equipmentOthers = equipmentOthers;
	}

	public String getEquipmentPressureWash() {
		return equipmentPressureWash;
	}

	public void setEquipmentPressureWash(String equipmentPressureWash) {
		this.equipmentPressureWash = equipmentPressureWash;
	}

	public String getWaitingAreaSqft() {
		return waitingAreaSqft;
	}

	public void setWaitingAreaSqft(String waitingAreaSqft) {
		this.waitingAreaSqft = waitingAreaSqft;
	}

	public String getWaitingAreaApprCost() {
		return waitingAreaApprCost;
	}

	public void setWaitingAreaApprCost(String waitingAreaApprCost) {
		this.waitingAreaApprCost = waitingAreaApprCost;
	}

	public String getAvgMonthlyRepeatCustomers() {
		return avgMonthlyRepeatCustomers;
	}

	public void setAvgMonthlyRepeatCustomers(String avgMonthlyRepeatCustomers) {
		this.avgMonthlyRepeatCustomers = avgMonthlyRepeatCustomers;
	}

	public String getAvgMonthlyNewCustomers() {
		return avgMonthlyNewCustomers;
	}

	public void setAvgMonthlyNewCustomers(String avgMonthlyNewCustomers) {
		this.avgMonthlyNewCustomers = avgMonthlyNewCustomers;
	}

	public String getAvgMonthlyMaintanceContracts() {
		return avgMonthlyMaintanceContracts;
	}

	public void setAvgMonthlyMaintanceContracts(String avgMonthlyMaintanceContracts) {
		this.avgMonthlyMaintanceContracts = avgMonthlyMaintanceContracts;
	}

	public String getTotalNumberOfEmployees() {
		return totalNumberOfEmployees;
	}

	public void setTotalNumberOfEmployees(String totalNumberOfEmployees) {
		this.totalNumberOfEmployees = totalNumberOfEmployees;
	}

	public String getTotalCertifiedEmployees() {
		return totalCertifiedEmployees;
	}

	public void setTotalCertifiedEmployees(String totalCertifiedEmployees) {
		this.totalCertifiedEmployees = totalCertifiedEmployees;
	}

	public String getTotalFullTimeEmployees() {
		return totalFullTimeEmployees;
	}

	public void setTotalFullTimeEmployees(String totalFullTimeEmployees) {
		this.totalFullTimeEmployees = totalFullTimeEmployees;
	}

	public String getTotalPartTimeEmployees() {
		return totalPartTimeEmployees;
	}

	public void setTotalPartTimeEmployees(String totalPartTimeEmployees) {
		this.totalPartTimeEmployees = totalPartTimeEmployees;
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
