package com.brw.dto;

import java.util.List;

import com.brw.entities.PropertyDetails;
import com.brw.entities.PropertyImages;

public class LiquorStoreDTO {
	private int id;
	
	private String apprInventoryCost;
	
	private String atmMachine;
	
	private String storageSqft;
	
	private String drinksCabinets;
	
	private String vendingMachine;
	
	private String goodsCabinets;
	
	private String residentialArea;
	
	private String demographicLink;
	
	private String walkscore;
	
	private String avgAge;
	
	private String avgIncome;
	
	private String crimeIndcator;
	
	private String associatedBusiness;
	
	private String convenienceStore;
	
	private String freshGoodsMarket;
	
	private String anchorBusiness;
	
	private String shoppingComplexTrafficScore;
	
    private PropertyDetails propertyMetaData;
	
	private List<PropertyImages> propertyImages;
	
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
