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
@Table(name = "rw_liquer_store")
@Inheritance(strategy = InheritanceType.JOINED)
public class LiquorStore implements Serializable {

	private static final long serialVersionUID = 8198534702201402693L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "appr_inventory_cost")
	private String apprInventoryCost;
	
	@Column(name = "atm_machine")
	private String atmMachine;
	
	@Column(name = "storage_sqft")
	private String storageSqft;
	
	@Column(name = "drinks_cabinets")
	private String drinksCabinets;
	
	@Column(name = "vending_machine")
	private String vendingMachine;
	
	@Column(name = "goods_Cabinets")
	private String goodsCabinets;
	
	@Column(name = "residential_area")
	private String residentialArea;
	
	@Column(name = "demographic_link")
	private String demographicLink;
	
	@Column(name = "walkscore")
	private String walkscore;
	
	@Column(name = "avg_age")
	private String avgAge;
	
	@Column(name = "avg_income")
	private String avgIncome;
	
	@Column(name = "crime_indcator")
	private String crimeIndcator;
	
	@Column(name = "associated_business")
	private String associatedBusiness;
	
	@Column(name = "convenience_store")
	private String convenienceStore;
	
	@Column(name = "fresh_goods_market")
	private String freshGoodsMarket;
	
	@Column(name = "anchor_business")
	private String anchorBusiness;
	
	@Column(name = "shopping_complex_traffic_score")
	private String shoppingComplexTrafficScore;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getApprInventoryCost() {
		return apprInventoryCost;
	}

	public void setApprInventoryCost(String apprInventoryCost) {
		this.apprInventoryCost = apprInventoryCost;
	}

	public String getAtmMachine() {
		return atmMachine;
	}

	public void setAtmMachine(String atmMachine) {
		this.atmMachine = atmMachine;
	}

	public String getStorageSqft() {
		return storageSqft;
	}

	public void setStorageSqft(String storageSqft) {
		this.storageSqft = storageSqft;
	}

	public String getDrinksCabinets() {
		return drinksCabinets;
	}

	public void setDrinksCabinets(String drinksCabinets) {
		this.drinksCabinets = drinksCabinets;
	}

	public String getVendingMachine() {
		return vendingMachine;
	}

	public void setVendingMachine(String vendingMachine) {
		this.vendingMachine = vendingMachine;
	}

	public String getGoodsCabinets() {
		return goodsCabinets;
	}

	public void setGoodsCabinets(String goodsCabinets) {
		this.goodsCabinets = goodsCabinets;
	}

	public String getResidentialArea() {
		return residentialArea;
	}

	public void setResidentialArea(String residentialArea) {
		this.residentialArea = residentialArea;
	}

	public String getDemographicLink() {
		return demographicLink;
	}

	public void setDemographicLink(String demographicLink) {
		this.demographicLink = demographicLink;
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

	public String getCrimeIndcator() {
		return crimeIndcator;
	}

	public void setCrimeIndcator(String crimeIndcator) {
		this.crimeIndcator = crimeIndcator;
	}

	public String getAssociatedBusiness() {
		return associatedBusiness;
	}

	public void setAssociatedBusiness(String associatedBusiness) {
		this.associatedBusiness = associatedBusiness;
	}

	public String getConvenienceStore() {
		return convenienceStore;
	}

	public void setConvenienceStore(String convenienceStore) {
		this.convenienceStore = convenienceStore;
	}

	public String getFreshGoodsMarket() {
		return freshGoodsMarket;
	}

	public void setFreshGoodsMarket(String freshGoodsMarket) {
		this.freshGoodsMarket = freshGoodsMarket;
	}

	public String getAnchorBusiness() {
		return anchorBusiness;
	}

	public void setAnchorBusiness(String anchorBusiness) {
		this.anchorBusiness = anchorBusiness;
	}

	public String getShoppingComplexTrafficScore() {
		return shoppingComplexTrafficScore;
	}

	public void setShoppingComplexTrafficScore(String shoppingComplexTrafficScore) {
		this.shoppingComplexTrafficScore = shoppingComplexTrafficScore;
	}

	
}
