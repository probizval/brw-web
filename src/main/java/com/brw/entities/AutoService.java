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
@Table(name = "rw_auto_service")
@Inheritance(strategy = InheritanceType.JOINED)
public class AutoService implements Serializable {

	private static final long serialVersionUID = -213571308222357519L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "parking_space")
	private String parkingSpace;
	
	@Column(name = "equipment_pneumatic_platform")
	private String equipmentPneumaticPlatform;
	
	@Column(name = "equipment_crane")
	private String equipmentCrane;
	
	@Column(name = "equipment_oil_storage")
	private String equipmentOilStorage;
	
	@Column(name = "equipment_appr_cost")
	private String equipmentApprCost;
	
	@Column(name = "equipment_storage")
	private String equipmentStorage;
	
	@Column(name = "equipment_others")
	private String equipmentOthers;
	
	@Column(name = "equipment_pressure_wash")
	private String equipmentPressureWash;
	
	@Column(name = "waiting_area_sqft")
	private String waitingAreaSqft;
	
	@Column(name = "waiting_area_appr_cost")
	private String waitingAreaApprCost;
	
	@Column(name = "avg_monthly_repeat_customers")
	private String avgMonthlyRepeatCustomers;
	
	@Column(name = "avg_monthly_new_customers")
	private String avgMonthlyNewCustomers;
	
	@Column(name = "avg_monthly_maintance_contracts")
	private String avgMonthlyMaintanceContracts;
	
	@Column(name = "total_number_of_employees")
	private String totalNumberOfEmployees;
	
	@Column(name = "total_certified_employees")
	private String totalCertifiedEmployees;
	
	@Column(name = "total_full_time_employees")
	private String totalFullTimeEmployees;
	
	@Column(name = "total_part_time_employees")
	private String totalPartTimeEmployees;

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
	

}
