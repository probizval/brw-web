package com.brw.service.impl;

/**
 * @author sidpatil
 * 2019
 */

import java.util.ArrayList;
import java.util.List;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.brw.dao.BusinessDetailsDAO;
import com.brw.dto.BusinessDetailsDTO;
import com.brw.dto.BusinessListDTO;
import com.brw.dto.EstimatesDTO;
import com.brw.dto.EstimatesListDTO;
import com.brw.dto.SimpleSearchFilterDTO;

import com.brw.entities.BusinessDetails;
import com.brw.service.BizTransactionService;
import com.brw.service.EstimateService;

@Component
public class BusinessServiceImpl implements com.brw.service.BusinessService {
	
	@Autowired
	private BusinessDetailsDAO businessDetailsDAO;
	
	@Autowired
	EstimateService estimateService;
	
	@Autowired
	BizTransactionService bizTransactionService;
	
	@Override
	public BusinessListDTO searchBusiness(SimpleSearchFilterDTO simpleSearchFilter) {
		// TODO Auto-generated method stub
		System.out.println("**** 222 Inside BusinessServiceImpl.searchBusiness() simpleSearchFilter: "+simpleSearchFilter.toString());
		
		List<BusinessDetails> businessList = (List<BusinessDetails>) businessDetailsDAO.searchBusiness(simpleSearchFilter.getBizName(), simpleSearchFilter.getBizType(), simpleSearchFilter.getStreet1(), simpleSearchFilter.getStreet2(), simpleSearchFilter.getCity(), simpleSearchFilter.getState(), simpleSearchFilter.getZip());
		List<BusinessDetailsDTO> businessDetailsDTOList = new ArrayList<BusinessDetailsDTO>();
		BusinessListDTO businessListDTO = new BusinessListDTO();
		
		for (BusinessDetails businessDetails: businessList) {
			BusinessDetailsDTO businessDetailsDTO = new BusinessDetailsDTO();
		
			businessDetailsDTO.setBusinessId(businessDetails.getBusinessId());
			businessDetailsDTO.setLegalName(businessDetails.getLegalName());
			businessDetailsDTO.setName(businessDetails.getName());
			businessDetailsDTO.setFirstOwnerName(businessDetails.getFirstOwnerName());
			businessDetailsDTO.setSecondOwnerName(businessDetails.getSecondOwnerName());
			businessDetailsDTO.setBrandName(businessDetails.getBrandName());
			businessDetailsDTO.setType(businessDetails.getType());
			businessDetailsDTO.setSubType(businessDetails.getSubType());
			businessDetailsDTO.setRegCityName(businessDetails.getRegCityName());
			businessDetailsDTO.setRegCityCode(businessDetails.getRegCityCode());
			businessDetailsDTO.setRegCityDate(businessDetails.getRegCityDate().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")));
			businessDetailsDTO.setRegStateName(businessDetails.getRegStateName());
			businessDetailsDTO.setRegStateCode(businessDetails.getRegStateCode());
			businessDetailsDTO.setRegStateDate(businessDetails.getRegStateDate().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")));
			businessDetailsDTO.setDataCompletionScore(businessDetails.getDataCompletenessScore());
			businessDetailsDTO.setIsforSell(businessDetails.getIsforSell());
			businessDetailsDTO.setForSellPrice(businessDetails.getForSellPrice());
			businessDetailsDTO.setImageLogo(businessDetails.getImageLogo());
			businessDetailsDTO.setImageFirst(businessDetails.getImageFirst());
			businessDetailsDTO.setStreet1(businessDetails.getStreet1());
			businessDetailsDTO.setStreet2(businessDetails.getStreet2());
			businessDetailsDTO.setCity(businessDetails.getCity());
			businessDetailsDTO.setCounty(businessDetails.getCounty());
			businessDetailsDTO.setStateCode(businessDetails.getStateCode());
			businessDetailsDTO.setZip(businessDetails.getZip());	
			businessDetailsDTO.setLatitude(businessDetails.getLatitude());
			businessDetailsDTO.setLongitude(businessDetails.getLongitude());
			businessDetailsDTO.setPhone(businessDetails.getPhoneNumber());
			businessDetailsDTO.setPhoneExt(businessDetails.getPhoneExtentionNumber());
			businessDetailsDTO.setEmail(businessDetails.getEmail());
			businessDetailsDTO.setWebsite(businessDetails.getWebsite());
			businessDetailsDTO.setDescription(businessDetails.getFreeformDescription());
			businessDetailsDTO.setNAICSNum(businessDetails.getNAICSNum());
			businessDetailsDTO.setNAICSDescription(businessDetails.getNAICSDescription());
			businessDetailsDTO.setIsFranchise(businessDetails.getIsFranchise());
			businessDetailsDTO.setIsOwnerClaimed(businessDetails.getIsOwnerClaimed());
			businessDetailsDTO.setSqftIndoor(businessDetails.getSqftIndoor());
			businessDetailsDTO.setSqftOutdoor(businessDetails.getSqftOutdoor());
			businessDetailsDTO.setSqftLot(businessDetails.getSqftLot());
			businessDetailsDTO.setBuildingType(businessDetails.getBuildingType());
			businessDetailsDTO.setIsBuildingOwned(businessDetails.getIsBuildingOwned());
			businessDetailsDTO.setRevenueMonthly(businessDetails.getRevenueMonthly());
			businessDetailsDTO.setExpenseMonthlyRent(businessDetails.getExpenseMonthlyRent());
			businessDetailsDTO.setExpenseMonthlyMortgage(businessDetails.getExpenseMonthlyMortgage());
			businessDetailsDTO.setExpenseMonthlyMaterial(businessDetails.getExpenseMonthlyMaterial());
			businessDetailsDTO.setExpenseMonthlyEmp(businessDetails.getExpenseMonthlyEmp());
			businessDetailsDTO.setExpenseMonthlyUtility(businessDetails.getExpenseMonthlyUtility());
			businessDetailsDTO.setExpenseMonthlyOther(businessDetails.getExpenseMonthlyOther());
			businessDetailsDTO.setValueTotalEquipment(businessDetails.getValueTotalEquipment());
			businessDetailsDTO.setValueTotalFurniture(businessDetails.getValueTotalFurniture());
			businessDetailsDTO.setValueIndoorDeco(businessDetails.getValueIndoorDeco());
			businessDetailsDTO.setValueOutdoorDeco(businessDetails.getValueOutdoorDeco());
			businessDetailsDTO.setYearEquipment(businessDetails.getYearEquipment());
			businessDetailsDTO.setYearFurniture(businessDetails.getYearFurniture());
			businessDetailsDTO.setYearIndoorDeco(businessDetails.getYearIndoorDeco());
			businessDetailsDTO.setYearOutdoorDeco(businessDetails.getYearOutdoorDeco());
			businessDetailsDTO.setEmpFullTimeNum(businessDetails.getEmpFullTimeNum());
			businessDetailsDTO.setEmpPartTimeNum(businessDetails.getEmpPartTimeNum());
			businessDetailsDTO.setAreaCrimeScore(businessDetails.getAreaCrimeScore());
			businessDetailsDTO.setAreaWalkScore(businessDetails.getAreaWalkScore());
			businessDetailsDTO.setAreaAttractionsScore(businessDetails.getAreaAttractionsScore());
			businessDetailsDTO.setAreaTransitScore(businessDetails.getAreaTransitScore());
			businessDetailsDTO.setSocialMediaScore(businessDetails.getSocialMediaScore());
			businessDetailsDTO.setPopulationIn1mileRadius(businessDetails.getPopulationIn1mileRadius());
			businessDetailsDTO.setIncomeScoreIn1mileRadius(businessDetails.getIncomeScoreIn1mileRadius());
			businessDetailsDTO.setPopulationIn3mileRadius(businessDetails.getPopulationIn3mileRadius());
			businessDetailsDTO.setIncomeScoreIn3mileRadius(businessDetails.getIncomeScoreIn3mileRadius());
			businessDetailsDTO.setPopulationIn5mileRadius(businessDetails.getPopulationIn5mileRadius());
			businessDetailsDTO.setIncomeScoreIn5mileRadius(businessDetails.getIncomeScoreIn5mileRadius());
			businessDetailsDTO.setDailyPeoplAtDoorNum(businessDetails.getDailyPeoplAtDoorNum());
			businessDetailsDTO.setDailyCarsAtParklotNum(businessDetails.getDailyCarsAtParklotNum());
			businessDetailsDTO.setYearEstablished(businessDetails.getYearEstablished());
			businessDetailsDTO.setCreatedByUserId(businessDetails.getCreatedByUserId());
			businessDetailsDTO.setCreateDate(businessDetails.getCreateDate().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")));
			businessDetailsDTO.setUpdatedByUserId(businessDetails.getUpdatedByUserId());
			businessDetailsDTO.setUpdateDate(businessDetails.getUpdateDate().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")));
			
			businessDetailsDTOList.add(businessDetailsDTO);
		}
		businessListDTO.setBusinessList(businessDetailsDTOList);
		return businessListDTO;
	}
	
	@Override
	public BusinessDetailsDTO getBusinessDetails(int businessId) {
		// TODO Auto-generated method stub
		System.out.println("**** 222 Inside BusinessServiceImpl.getBusinessDetails() businessId: "+businessId);
		
		BusinessDetails businessDetails = (BusinessDetails) businessDetailsDAO.getBusinessDetails(businessId);
		
		BusinessDetailsDTO businessDetailsDTO = new BusinessDetailsDTO();
		
		businessDetailsDTO.setBusinessId(businessDetails.getBusinessId());
		businessDetailsDTO.setLegalName(businessDetails.getLegalName());
		businessDetailsDTO.setName(businessDetails.getName());
		businessDetailsDTO.setFirstOwnerName(businessDetails.getFirstOwnerName());
		businessDetailsDTO.setSecondOwnerName(businessDetails.getSecondOwnerName());
		businessDetailsDTO.setBrandName(businessDetails.getBrandName());
		businessDetailsDTO.setType(businessDetails.getType());
		businessDetailsDTO.setSubType(businessDetails.getSubType());
		businessDetailsDTO.setRegCityName(businessDetails.getRegCityName());
		businessDetailsDTO.setRegCityCode(businessDetails.getRegCityCode());
		businessDetailsDTO.setRegCityDate(businessDetails.getRegCityDate().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")));
		businessDetailsDTO.setRegStateName(businessDetails.getRegStateName());
		businessDetailsDTO.setRegStateCode(businessDetails.getRegStateCode());
		businessDetailsDTO.setRegStateDate(businessDetails.getRegStateDate().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")));
		businessDetailsDTO.setDataCompletionScore(businessDetails.getDataCompletenessScore());
		businessDetailsDTO.setIsforSell(businessDetails.getIsforSell());
		businessDetailsDTO.setForSellPrice(businessDetails.getForSellPrice());
		businessDetailsDTO.setImageLogo(businessDetails.getImageLogo());
		businessDetailsDTO.setImageFirst(businessDetails.getImageFirst());
		businessDetailsDTO.setStreet1(businessDetails.getStreet1());
		businessDetailsDTO.setStreet2(businessDetails.getStreet2());
		businessDetailsDTO.setCity(businessDetails.getCity());
		businessDetailsDTO.setCounty(businessDetails.getCounty());
		businessDetailsDTO.setStateCode(businessDetails.getStateCode());
		businessDetailsDTO.setZip(businessDetails.getZip());	
		businessDetailsDTO.setLatitude(businessDetails.getLatitude());
		businessDetailsDTO.setLongitude(businessDetails.getLongitude());
		businessDetailsDTO.setPhone(businessDetails.getPhoneNumber());
		businessDetailsDTO.setPhoneExt(businessDetails.getPhoneExtentionNumber());
		businessDetailsDTO.setEmail(businessDetails.getEmail());
		businessDetailsDTO.setWebsite(businessDetails.getWebsite());
		businessDetailsDTO.setDescription(businessDetails.getFreeformDescription());
		businessDetailsDTO.setNAICSNum(businessDetails.getNAICSNum());
		businessDetailsDTO.setNAICSDescription(businessDetails.getNAICSDescription());
		businessDetailsDTO.setIsFranchise(businessDetails.getIsFranchise());
		businessDetailsDTO.setIsOwnerClaimed(businessDetails.getIsOwnerClaimed());
		businessDetailsDTO.setSqftIndoor(businessDetails.getSqftIndoor());
		businessDetailsDTO.setSqftOutdoor(businessDetails.getSqftOutdoor());
		businessDetailsDTO.setSqftLot(businessDetails.getSqftLot());
		businessDetailsDTO.setBuildingType(businessDetails.getBuildingType());
		businessDetailsDTO.setIsBuildingOwned(businessDetails.getIsBuildingOwned());
		businessDetailsDTO.setRevenueMonthly(businessDetails.getRevenueMonthly());
		businessDetailsDTO.setExpenseMonthlyRent(businessDetails.getExpenseMonthlyRent());
		businessDetailsDTO.setExpenseMonthlyMortgage(businessDetails.getExpenseMonthlyMortgage());
		businessDetailsDTO.setExpenseMonthlyMaterial(businessDetails.getExpenseMonthlyMaterial());
		businessDetailsDTO.setExpenseMonthlyEmp(businessDetails.getExpenseMonthlyEmp());
		businessDetailsDTO.setExpenseMonthlyUtility(businessDetails.getExpenseMonthlyUtility());
		businessDetailsDTO.setExpenseMonthlyOther(businessDetails.getExpenseMonthlyOther());
		businessDetailsDTO.setValueTotalEquipment(businessDetails.getValueTotalEquipment());
		businessDetailsDTO.setValueTotalFurniture(businessDetails.getValueTotalFurniture());
		businessDetailsDTO.setValueIndoorDeco(businessDetails.getValueIndoorDeco());
		businessDetailsDTO.setValueOutdoorDeco(businessDetails.getValueOutdoorDeco());
		businessDetailsDTO.setYearEquipment(businessDetails.getYearEquipment());
		businessDetailsDTO.setYearFurniture(businessDetails.getYearFurniture());
		businessDetailsDTO.setYearIndoorDeco(businessDetails.getYearIndoorDeco());
		businessDetailsDTO.setYearOutdoorDeco(businessDetails.getYearOutdoorDeco());
		businessDetailsDTO.setEmpFullTimeNum(businessDetails.getEmpFullTimeNum());
		businessDetailsDTO.setEmpPartTimeNum(businessDetails.getEmpPartTimeNum());
		businessDetailsDTO.setAreaCrimeScore(businessDetails.getAreaCrimeScore());
		businessDetailsDTO.setAreaWalkScore(businessDetails.getAreaWalkScore());
		businessDetailsDTO.setAreaAttractionsScore(businessDetails.getAreaAttractionsScore());
		businessDetailsDTO.setAreaTransitScore(businessDetails.getAreaTransitScore());
		businessDetailsDTO.setSocialMediaScore(businessDetails.getSocialMediaScore());
		businessDetailsDTO.setPopulationIn1mileRadius(businessDetails.getPopulationIn1mileRadius());
		businessDetailsDTO.setIncomeScoreIn1mileRadius(businessDetails.getIncomeScoreIn1mileRadius());
		businessDetailsDTO.setPopulationIn3mileRadius(businessDetails.getPopulationIn3mileRadius());
		businessDetailsDTO.setIncomeScoreIn3mileRadius(businessDetails.getIncomeScoreIn3mileRadius());
		businessDetailsDTO.setPopulationIn5mileRadius(businessDetails.getPopulationIn5mileRadius());
		businessDetailsDTO.setIncomeScoreIn5mileRadius(businessDetails.getIncomeScoreIn5mileRadius());
		businessDetailsDTO.setDailyPeoplAtDoorNum(businessDetails.getDailyPeoplAtDoorNum());
		businessDetailsDTO.setDailyCarsAtParklotNum(businessDetails.getDailyCarsAtParklotNum());
		businessDetailsDTO.setYearEstablished(businessDetails.getYearEstablished());
		businessDetailsDTO.setCreatedByUserId(businessDetails.getCreatedByUserId());
		businessDetailsDTO.setCreateDate(businessDetails.getCreateDate().toString());
		businessDetailsDTO.setUpdatedByUserId(businessDetails.getUpdatedByUserId());
		businessDetailsDTO.setUpdateDate(businessDetails.getUpdateDate().toString());
		
		return businessDetailsDTO;
	}
	
	@Override
	public BusinessDetailsDTO addBusinessDetails(BusinessDetailsDTO businessDetailsDTO) {
		
		System.out.println("222 **** Inside BusinessServiceImpl.addBusinessDetails() businessDetailsDTO.getRegCityDate(): "+businessDetailsDTO.getRegCityDate());

		// TODO Auto-generated method stub
		BusinessDetails businessDetails = new BusinessDetails();
		businessDetails.setLegalName(businessDetailsDTO.getLegalName());
		businessDetails.setName(businessDetailsDTO.getName());
		businessDetails.setFirstOwnerName(businessDetailsDTO.getFirstOwnerName());
		businessDetails.setSecondOwnerName(businessDetailsDTO.getSecondOwnerName());
		businessDetails.setBrandName(businessDetailsDTO.getBrandName());
		businessDetails.setType(businessDetailsDTO.getType());
		businessDetails.setSubType(businessDetailsDTO.getSubType());
		businessDetails.setRegCityName(businessDetailsDTO.getRegCityName());
		businessDetails.setRegCityCode(businessDetailsDTO.getRegCityCode());
		businessDetails.setRegCityDate(LocalDateTime.parse(businessDetailsDTO.getRegCityDate(), DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")));
		businessDetails.setRegStateName(businessDetailsDTO.getRegStateName());
		businessDetails.setRegStateCode(businessDetailsDTO.getRegStateCode());
		businessDetails.setRegStateDate(LocalDateTime.parse(businessDetailsDTO.getRegStateDate(), DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")));
		businessDetails.setDataCompletenessScore(businessDetailsDTO.getDataCompletionScore());
		businessDetails.setIsforSell(businessDetailsDTO.getIsforSell());
		businessDetails.setForSellPrice(businessDetailsDTO.getForSellPrice());
		businessDetails.setImageLogo(businessDetailsDTO.getImageLogo());
		businessDetails.setImageFirst(businessDetailsDTO.getImageFirst());
		businessDetails.setStreet1(businessDetailsDTO.getStreet1());
		businessDetails.setStreet2(businessDetailsDTO.getStreet2());
		businessDetails.setCity(businessDetailsDTO.getCity());
		businessDetails.setCounty(businessDetailsDTO.getCounty());
		businessDetails.setStateCode(businessDetailsDTO.getStateCode());
		businessDetails.setZip(businessDetailsDTO.getZip());	
		businessDetails.setLatitude(businessDetailsDTO.getLatitude());
		businessDetails.setLongitude(businessDetailsDTO.getLongitude());
		businessDetails.setPhoneNumber(businessDetailsDTO.getPhone());
		businessDetails.setPhoneExtentionNumber(businessDetailsDTO.getPhoneExt());
		businessDetails.setEmail(businessDetailsDTO.getEmail());
		businessDetails.setWebsite(businessDetailsDTO.getWebsite());
		businessDetails.setFreeformDescription(businessDetailsDTO.getDescription());
		businessDetails.setNAICSNum(businessDetailsDTO.getNAICSNum());
		businessDetails.setNAICSDescription(businessDetailsDTO.getNAICSDescription());
		businessDetails.setIsFranchise(businessDetailsDTO.getIsFranchise());
		businessDetails.setIsOwnerClaimed(businessDetailsDTO.getIsOwnerClaimed());
		businessDetails.setSqftIndoor(businessDetailsDTO.getSqftIndoor());
		businessDetails.setSqftOutdoor(businessDetailsDTO.getSqftOutdoor());
		businessDetails.setSqftLot(businessDetailsDTO.getSqftLot());
		businessDetails.setBuildingType(businessDetailsDTO.getBuildingType());
		businessDetails.setIsBuildingOwned(businessDetailsDTO.getIsBuildingOwned());
		businessDetails.setRevenueMonthly(businessDetailsDTO.getRevenueMonthly());
		businessDetails.setExpenseMonthlyRent(businessDetailsDTO.getExpenseMonthlyRent());
		businessDetails.setExpenseMonthlyMortgage(businessDetailsDTO.getExpenseMonthlyMortgage());
		businessDetails.setExpenseMonthlyMaterial(businessDetailsDTO.getExpenseMonthlyMaterial());
		businessDetails.setExpenseMonthlyEmp(businessDetailsDTO.getExpenseMonthlyEmp());
		businessDetails.setExpenseMonthlyUtility(businessDetailsDTO.getExpenseMonthlyUtility());
		businessDetails.setExpenseMonthlyOther(businessDetailsDTO.getExpenseMonthlyOther());
		businessDetails.setValueTotalEquipment(businessDetailsDTO.getValueTotalEquipment());
		businessDetails.setValueTotalFurniture(businessDetailsDTO.getValueTotalFurniture());
		businessDetails.setValueIndoorDeco(businessDetailsDTO.getValueIndoorDeco());
		businessDetails.setValueOutdoorDeco(businessDetailsDTO.getValueOutdoorDeco());
		businessDetails.setYearEquipment(businessDetailsDTO.getYearEquipment());
		businessDetails.setYearFurniture(businessDetailsDTO.getYearFurniture());
		businessDetails.setYearIndoorDeco(businessDetailsDTO.getYearIndoorDeco());
		businessDetails.setYearOutdoorDeco(businessDetailsDTO.getYearOutdoorDeco());
		businessDetails.setEmpFullTimeNum(businessDetailsDTO.getEmpFullTimeNum());
		businessDetails.setEmpPartTimeNum(businessDetailsDTO.getEmpPartTimeNum());
		businessDetails.setAreaCrimeScore(businessDetailsDTO.getAreaCrimeScore());
		businessDetails.setAreaWalkScore(businessDetailsDTO.getAreaWalkScore());
		businessDetails.setAreaAttractionsScore(businessDetailsDTO.getAreaAttractionsScore());
		businessDetails.setAreaTransitScore(businessDetailsDTO.getAreaTransitScore());
		businessDetails.setSocialMediaScore(businessDetailsDTO.getSocialMediaScore());
		businessDetails.setPopulationIn1mileRadius(businessDetailsDTO.getPopulationIn1mileRadius());
		businessDetails.setIncomeScoreIn1mileRadius(businessDetailsDTO.getIncomeScoreIn1mileRadius());
		businessDetails.setPopulationIn3mileRadius(businessDetailsDTO.getPopulationIn3mileRadius());
		businessDetails.setIncomeScoreIn3mileRadius(businessDetailsDTO.getIncomeScoreIn3mileRadius());
		businessDetails.setPopulationIn5mileRadius(businessDetailsDTO.getPopulationIn5mileRadius());
		businessDetails.setIncomeScoreIn5mileRadius(businessDetailsDTO.getIncomeScoreIn5mileRadius());
		businessDetails.setDailyPeoplAtDoorNum(businessDetailsDTO.getDailyPeoplAtDoorNum());
		businessDetails.setDailyCarsAtParklotNum(businessDetailsDTO.getDailyCarsAtParklotNum());
		businessDetails.setYearEstablished(businessDetailsDTO.getYearEstablished());
		businessDetails.setCreatedByUserId(businessDetailsDTO.getInvokerId());
		businessDetails.setCreateDate(LocalDateTime.now());
		businessDetails.setUpdatedByUserId(businessDetailsDTO.getInvokerId());
		businessDetails.setUpdateDate(LocalDateTime.now());
		
		BusinessDetails business = businessDetailsDAO.save(businessDetails);
		
		BusinessDetailsDTO bizDTO = new BusinessDetailsDTO();
		bizDTO.setBusinessId(business.getBusinessId());
		bizDTO.setLegalName(business.getLegalName());
		bizDTO.setType(business.getType());
		
		return bizDTO;
	}
	
	
	@Override
	public BusinessDetailsDTO updateBusinessDetails(BusinessDetailsDTO businessDetailsDTO) {
		// TODO Auto-generated method stub
		System.out.println("222 **** Inside BusinessServiceImpl.updateBusinessDetails() businessDetailsDTO.getRegCityDate(): "+businessDetailsDTO.getRegCityDate());

		BusinessDetails businessDetails = businessDetailsDAO.findById(businessDetailsDTO.getBusinessId()).get();
		//BusinessDetails businessDetails = new BusinessDetails();
		if (null != businessDetailsDTO.getLegalName() && businessDetailsDTO.getLegalName() != "") {
			businessDetails.setLegalName(businessDetailsDTO.getLegalName());
		}
		
		if (null != businessDetailsDTO.getName() && businessDetailsDTO.getName() != "") {
			businessDetails.setName(businessDetailsDTO.getName());
		}
		
		if (null != businessDetailsDTO.getFirstOwnerName() && businessDetailsDTO.getFirstOwnerName() != "") {
			businessDetails.setFirstOwnerName(businessDetailsDTO.getFirstOwnerName());
		}
		
		if (null != businessDetailsDTO.getSecondOwnerName() && businessDetailsDTO.getSecondOwnerName() != "") {
			businessDetails.setSecondOwnerName(businessDetailsDTO.getSecondOwnerName());
		}
		
		if (null != businessDetailsDTO.getBrandName() && businessDetailsDTO.getBrandName() != "") {
			businessDetails.setBrandName(businessDetailsDTO.getBrandName());
		}
		
		if (null != businessDetailsDTO.getType() && businessDetailsDTO.getType() != "") {
			businessDetails.setType(businessDetailsDTO.getType());
		}
		
		if (null != businessDetailsDTO.getSubType() && businessDetailsDTO.getSubType() != "") {
			businessDetails.setSubType(businessDetailsDTO.getSubType());
		}
		
		if (null != businessDetailsDTO.getRegCityName() && businessDetailsDTO.getRegCityName() != "") {
			businessDetails.setRegCityName(businessDetailsDTO.getRegCityName());
		}
		
		if (null != businessDetailsDTO.getRegCityCode() && businessDetailsDTO.getRegCityCode() != "") {
			businessDetails.setRegCityCode(businessDetailsDTO.getRegCityCode());
		}
		
		if (null != businessDetailsDTO.getRegCityDate()) {
			businessDetails.setRegCityDate(LocalDateTime.parse(businessDetailsDTO.getRegCityDate(), DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")));
		}
		
		if (null != businessDetailsDTO.getRegStateName() && businessDetailsDTO.getRegCityCode() != "") {
			businessDetails.setRegStateName(businessDetailsDTO.getRegStateName());
		}
		
		if (null != businessDetailsDTO.getRegStateCode() && businessDetailsDTO.getRegCityCode() != "") {
			businessDetails.setRegStateCode(businessDetailsDTO.getRegStateCode());
		}
		
		if (null != businessDetailsDTO.getRegStateDate()) {
			businessDetails.setRegStateDate(LocalDateTime.parse(businessDetailsDTO.getRegStateDate(), DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")));
		}
		
		if (null != businessDetailsDTO.getDataCompletionScore()) {
			businessDetails.setDataCompletenessScore(businessDetailsDTO.getDataCompletionScore());
		}
		
		if (null != businessDetailsDTO.getIsforSell() && businessDetailsDTO.getIsforSell() != "") {
			businessDetails.setIsforSell(businessDetailsDTO.getIsforSell());
		}
		
		if (null != businessDetailsDTO.getForSellPrice()) {
			businessDetails.setForSellPrice(businessDetailsDTO.getForSellPrice());
		}
		
		if (null != businessDetailsDTO.getImageLogo() && businessDetailsDTO.getImageLogo() != "") {
			businessDetails.setImageLogo(businessDetailsDTO.getImageLogo());
		}
		
		if (null != businessDetailsDTO.getImageFirst() && businessDetailsDTO.getImageFirst() != "") {
			businessDetails.setImageFirst(businessDetailsDTO.getImageFirst());
		}
		
		if (null != businessDetailsDTO.getStreet1() && businessDetailsDTO.getStreet1() != "") {
			businessDetails.setStreet1(businessDetailsDTO.getStreet1());
		}
		
		if (null != businessDetailsDTO.getStreet2() && businessDetailsDTO.getStreet2() != "") {
			businessDetails.setStreet2(businessDetailsDTO.getStreet2());
		}
		
		if (null != businessDetailsDTO.getCity() && businessDetailsDTO.getCity() != "") {
			businessDetails.setCity(businessDetailsDTO.getCity());
		}
		
		if (null != businessDetailsDTO.getCounty() && businessDetailsDTO.getCounty() != "") {
			businessDetails.setCounty(businessDetailsDTO.getCounty());
		}
		
		if (null != businessDetailsDTO.getStateCode() && businessDetailsDTO.getStateCode() != "") {
			businessDetails.setStateCode(businessDetailsDTO.getStateCode());
		}
		
		if (null != businessDetailsDTO.getZip()) {
			businessDetails.setZip(businessDetailsDTO.getZip());
		}
		
		if (0.0 != businessDetailsDTO.getLatitude()) {
			businessDetails.setLatitude(businessDetailsDTO.getLatitude());
		}
		
		if (0.0 != businessDetailsDTO.getLongitude()) {
			businessDetails.setLongitude(businessDetailsDTO.getLongitude());
		}
		
		if (null != businessDetailsDTO.getPhone() && businessDetailsDTO.getPhone() != "") {
			businessDetails.setPhoneNumber(businessDetailsDTO.getPhone());
		}
		
		if (null != businessDetailsDTO.getPhoneExt() && businessDetailsDTO.getPhoneExt() != "") {
			businessDetails.setPhoneExtentionNumber(businessDetailsDTO.getPhoneExt());
		}
		
		if (null != businessDetailsDTO.getEmail() && businessDetailsDTO.getEmail() != "") {
			businessDetails.setEmail(businessDetailsDTO.getEmail());
		}
		
		if (null != businessDetailsDTO.getWebsite() && businessDetailsDTO.getWebsite() != "") {
			businessDetails.setWebsite(businessDetailsDTO.getWebsite());
		}
		
		if (null != businessDetailsDTO.getDescription() && businessDetailsDTO.getDescription() != "") {
			businessDetails.setFreeformDescription(businessDetailsDTO.getDescription());
		}
		
		if (null != businessDetailsDTO.getNAICSNum()) {
			businessDetails.setNAICSNum(businessDetailsDTO.getNAICSNum());
		}
		
		if (null != businessDetailsDTO.getNAICSDescription() && businessDetailsDTO.getNAICSDescription() != "") {
			businessDetails.setNAICSDescription(businessDetailsDTO.getNAICSDescription());
		}
		
		if (null != businessDetailsDTO.getIsFranchise() && businessDetailsDTO.getIsFranchise() != "") {
			businessDetails.setIsFranchise(businessDetailsDTO.getIsFranchise());
		}
		
		if (null != businessDetailsDTO.getIsOwnerClaimed() && businessDetailsDTO.getIsOwnerClaimed() != "") {
			businessDetails.setIsOwnerClaimed(businessDetailsDTO.getIsOwnerClaimed());
		}
		
		if (null != businessDetailsDTO.getSqftIndoor()) {
			businessDetails.setSqftIndoor(businessDetailsDTO.getSqftIndoor());
		}
		
		if (null != businessDetailsDTO.getSqftOutdoor()) {
			businessDetails.setSqftOutdoor(businessDetailsDTO.getSqftOutdoor());
		}
		
		if (null != businessDetailsDTO.getSqftLot()) {
			businessDetails.setSqftLot(businessDetailsDTO.getSqftLot());
		}
		
		if (null != businessDetailsDTO.getBuildingType() && businessDetailsDTO.getBuildingType() != "") {
			businessDetails.setBuildingType(businessDetailsDTO.getBuildingType());
		}
		
		if (null != businessDetailsDTO.getIsBuildingOwned() && businessDetailsDTO.getIsBuildingOwned() != "") {
			businessDetails.setIsBuildingOwned(businessDetailsDTO.getIsBuildingOwned());
		}
		
		if (null != businessDetailsDTO.getRevenueMonthly()) {
			businessDetails.setRevenueMonthly(businessDetailsDTO.getRevenueMonthly());
		}
		
		if (null != businessDetailsDTO.getExpenseMonthlyRent()) {
			businessDetails.setExpenseMonthlyRent(businessDetailsDTO.getExpenseMonthlyRent());
		}
		
		if (null != businessDetailsDTO.getExpenseMonthlyMortgage()) {
			businessDetails.setExpenseMonthlyMortgage(businessDetailsDTO.getExpenseMonthlyMortgage());
		}
		
		if (null != businessDetailsDTO.getExpenseMonthlyMaterial()) {
			businessDetails.setExpenseMonthlyMaterial(businessDetailsDTO.getExpenseMonthlyMaterial());
		}
		
		if (null != businessDetailsDTO.getExpenseMonthlyEmp()) {
			businessDetails.setExpenseMonthlyEmp(businessDetailsDTO.getExpenseMonthlyEmp());
		}
		
		if (null != businessDetailsDTO.getExpenseMonthlyUtility()) {
			businessDetails.setExpenseMonthlyUtility(businessDetailsDTO.getExpenseMonthlyUtility());
		}
		
		if (null != businessDetailsDTO.getExpenseMonthlyOther()) {
			businessDetails.setExpenseMonthlyOther(businessDetailsDTO.getExpenseMonthlyOther());
		}
		
		if (null != businessDetailsDTO.getValueTotalEquipment()) {
			businessDetails.setValueTotalEquipment(businessDetailsDTO.getValueTotalEquipment());
		}
		
		if (null != businessDetailsDTO.getValueTotalFurniture()) {
			businessDetails.setValueTotalFurniture(businessDetailsDTO.getValueTotalFurniture());
		}
		
		if (null != businessDetailsDTO.getValueIndoorDeco()) {
			businessDetails.setValueIndoorDeco(businessDetailsDTO.getValueIndoorDeco());
		}
		
		if (null != businessDetailsDTO.getValueOutdoorDeco()) {
			businessDetails.setValueOutdoorDeco(businessDetailsDTO.getValueOutdoorDeco());
		}
		
		if (null != businessDetailsDTO.getYearEquipment()) {
			businessDetails.setYearEquipment(businessDetailsDTO.getYearEquipment());
		}
		
		if (null != businessDetailsDTO.getYearFurniture()) {
			businessDetails.setYearFurniture(businessDetailsDTO.getYearFurniture());
		}
		
		if (null != businessDetailsDTO.getYearIndoorDeco()) {
			businessDetails.setYearIndoorDeco(businessDetailsDTO.getYearIndoorDeco());
		}
		
		if (null != businessDetailsDTO.getYearOutdoorDeco()) {
			businessDetails.setYearOutdoorDeco(businessDetailsDTO.getYearOutdoorDeco());
		}
		
		if (null != businessDetailsDTO.getEmpFullTimeNum()) {
			businessDetails.setEmpFullTimeNum(businessDetailsDTO.getEmpFullTimeNum());
		}
		
		if (null != businessDetailsDTO.getEmpPartTimeNum()) {
			businessDetails.setEmpPartTimeNum(businessDetailsDTO.getEmpPartTimeNum());
		}
		
		if (null != businessDetailsDTO.getAreaCrimeScore()) {
			businessDetails.setAreaCrimeScore(businessDetailsDTO.getAreaCrimeScore());
		}
		
		if (null != businessDetailsDTO.getAreaWalkScore()) {
			businessDetails.setAreaWalkScore(businessDetailsDTO.getAreaWalkScore());
		}
		
		if (null != businessDetailsDTO.getAreaAttractionsScore()) {
			businessDetails.setAreaAttractionsScore(businessDetailsDTO.getAreaAttractionsScore());
		}
		
		if (null != businessDetailsDTO.getAreaTransitScore()) {
			businessDetails.setAreaTransitScore(businessDetailsDTO.getAreaTransitScore());
		}
		
		if (null != businessDetailsDTO.getSocialMediaScore()) {
			businessDetails.setSocialMediaScore(businessDetailsDTO.getSocialMediaScore());
		}
		
		if (null != businessDetailsDTO.getPopulationIn1mileRadius()) {
			businessDetails.setPopulationIn1mileRadius(businessDetailsDTO.getPopulationIn1mileRadius());
		}
		
		if (null != businessDetailsDTO.getIncomeScoreIn1mileRadius()) {
		businessDetails.setIncomeScoreIn1mileRadius(businessDetailsDTO.getIncomeScoreIn1mileRadius());
		}
		
		if (null != businessDetailsDTO.getPopulationIn3mileRadius()) {
		businessDetails.setPopulationIn3mileRadius(businessDetailsDTO.getPopulationIn3mileRadius());
		}
		
		if (null != businessDetailsDTO.getIncomeScoreIn3mileRadius()) {
			businessDetails.setIncomeScoreIn3mileRadius(businessDetailsDTO.getIncomeScoreIn3mileRadius());
		}
		
		if (null != businessDetailsDTO.getPopulationIn5mileRadius()) {
			businessDetails.setPopulationIn5mileRadius(businessDetailsDTO.getPopulationIn5mileRadius());
		}
		
		if (null != businessDetailsDTO.getIncomeScoreIn5mileRadius()) {
			businessDetails.setIncomeScoreIn5mileRadius(businessDetailsDTO.getIncomeScoreIn5mileRadius());
		}
		
		if (null != businessDetailsDTO.getDailyPeoplAtDoorNum()) {
			businessDetails.setDailyPeoplAtDoorNum(businessDetailsDTO.getDailyPeoplAtDoorNum());
		}
		
		if (null != businessDetailsDTO.getDailyCarsAtParklotNum()) {
			businessDetails.setDailyCarsAtParklotNum(businessDetailsDTO.getDailyCarsAtParklotNum());
		}
		
		if (null != businessDetailsDTO.getYearEstablished()) {
			businessDetails.setYearEstablished(businessDetailsDTO.getYearEstablished());
		}
		
		//businessDetails.setCreatedByUserId(businessDetailsDTO.getInvokerId());
		//businessDetails.setCreateDate(LocalDateTime.now());
		
		businessDetails.setUpdatedByUserId(businessDetailsDTO.getInvokerId());
		businessDetails.setUpdateDate(LocalDateTime.now());
		
		BusinessDetails business = businessDetailsDAO.save(businessDetails);
		
		BusinessDetailsDTO bizDTO = new BusinessDetailsDTO();
		bizDTO.setBusinessId(business.getBusinessId());
		bizDTO.setLegalName(business.getLegalName());
		bizDTO.setType(business.getType());
		
		return bizDTO;
	}
	
	@Override
	public BusinessListDTO searchComparableBusiness(BusinessDetailsDTO businessInQuestion) {
		// TODO Auto-generated method stub
		System.out.println("**** 222 Inside BusinessServiceImpl.searchComparableBusiness()");
		
		List<BusinessDetails> comparableBusinessList = (List<BusinessDetails>) businessDetailsDAO.searchComparableBusiness(businessInQuestion.getType(), businessInQuestion.getSubType(), businessInQuestion.getStateCode(), businessInQuestion.getCity());
		List<BusinessDetailsDTO> businessDetailsDTOList = new ArrayList<BusinessDetailsDTO>();
		BusinessListDTO businessListDTO = new BusinessListDTO();
		
		for (BusinessDetails businessDetails: comparableBusinessList) {
			BusinessDetailsDTO businessDetailsDTO = new BusinessDetailsDTO();
		
			businessDetailsDTO.setBusinessId(businessDetails.getBusinessId());
			businessDetailsDTO.setLegalName(businessDetails.getLegalName());
			businessDetailsDTO.setName(businessDetails.getName());
			businessDetailsDTO.setFirstOwnerName(businessDetails.getFirstOwnerName());
			businessDetailsDTO.setSecondOwnerName(businessDetails.getSecondOwnerName());
			businessDetailsDTO.setBrandName(businessDetails.getBrandName());
			businessDetailsDTO.setType(businessDetails.getType());
			businessDetailsDTO.setSubType(businessDetails.getSubType());
			businessDetailsDTO.setRegCityName(businessDetails.getRegCityName());
			businessDetailsDTO.setRegCityCode(businessDetails.getRegCityCode());
			businessDetailsDTO.setRegCityDate(businessDetails.getRegCityDate().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")));
			businessDetailsDTO.setRegStateName(businessDetails.getRegStateName());
			businessDetailsDTO.setRegStateCode(businessDetails.getRegStateCode());
			businessDetailsDTO.setRegStateDate(businessDetails.getRegStateDate().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")));
			businessDetailsDTO.setDataCompletionScore(businessDetails.getDataCompletenessScore());
			businessDetailsDTO.setIsforSell(businessDetails.getIsforSell());
			businessDetailsDTO.setForSellPrice(businessDetails.getForSellPrice());
			businessDetailsDTO.setImageLogo(businessDetails.getImageLogo());
			businessDetailsDTO.setImageFirst(businessDetails.getImageFirst());
			businessDetailsDTO.setStreet1(businessDetails.getStreet1());
			businessDetailsDTO.setStreet2(businessDetails.getStreet2());
			businessDetailsDTO.setCity(businessDetails.getCity());
			businessDetailsDTO.setCounty(businessDetails.getCounty());
			businessDetailsDTO.setStateCode(businessDetails.getStateCode());
			businessDetailsDTO.setZip(businessDetails.getZip());	
			businessDetailsDTO.setLatitude(businessDetails.getLatitude());
			businessDetailsDTO.setLongitude(businessDetails.getLongitude());
			businessDetailsDTO.setPhone(businessDetails.getPhoneNumber());
			businessDetailsDTO.setPhoneExt(businessDetails.getPhoneExtentionNumber());
			businessDetailsDTO.setEmail(businessDetails.getEmail());
			businessDetailsDTO.setWebsite(businessDetails.getWebsite());
			businessDetailsDTO.setDescription(businessDetails.getFreeformDescription());
			businessDetailsDTO.setNAICSNum(businessDetails.getNAICSNum());
			businessDetailsDTO.setNAICSDescription(businessDetails.getNAICSDescription());
			businessDetailsDTO.setIsFranchise(businessDetails.getIsFranchise());
			businessDetailsDTO.setIsOwnerClaimed(businessDetails.getIsOwnerClaimed());
			businessDetailsDTO.setSqftIndoor(businessDetails.getSqftIndoor());
			businessDetailsDTO.setSqftOutdoor(businessDetails.getSqftOutdoor());
			businessDetailsDTO.setSqftLot(businessDetails.getSqftLot());
			businessDetailsDTO.setBuildingType(businessDetails.getBuildingType());
			businessDetailsDTO.setIsBuildingOwned(businessDetails.getIsBuildingOwned());
			businessDetailsDTO.setRevenueMonthly(businessDetails.getRevenueMonthly());
			businessDetailsDTO.setExpenseMonthlyRent(businessDetails.getExpenseMonthlyRent());
			businessDetailsDTO.setExpenseMonthlyMortgage(businessDetails.getExpenseMonthlyMortgage());
			businessDetailsDTO.setExpenseMonthlyMaterial(businessDetails.getExpenseMonthlyMaterial());
			businessDetailsDTO.setExpenseMonthlyEmp(businessDetails.getExpenseMonthlyEmp());
			businessDetailsDTO.setExpenseMonthlyUtility(businessDetails.getExpenseMonthlyUtility());
			businessDetailsDTO.setExpenseMonthlyOther(businessDetails.getExpenseMonthlyOther());
			businessDetailsDTO.setValueTotalEquipment(businessDetails.getValueTotalEquipment());
			businessDetailsDTO.setValueTotalFurniture(businessDetails.getValueTotalFurniture());
			businessDetailsDTO.setValueIndoorDeco(businessDetails.getValueIndoorDeco());
			businessDetailsDTO.setValueOutdoorDeco(businessDetails.getValueOutdoorDeco());
			businessDetailsDTO.setYearEquipment(businessDetails.getYearEquipment());
			businessDetailsDTO.setYearFurniture(businessDetails.getYearFurniture());
			businessDetailsDTO.setYearIndoorDeco(businessDetails.getYearIndoorDeco());
			businessDetailsDTO.setYearOutdoorDeco(businessDetails.getYearOutdoorDeco());
			businessDetailsDTO.setEmpFullTimeNum(businessDetails.getEmpFullTimeNum());
			businessDetailsDTO.setEmpPartTimeNum(businessDetails.getEmpPartTimeNum());
			businessDetailsDTO.setAreaCrimeScore(businessDetails.getAreaCrimeScore());
			businessDetailsDTO.setAreaWalkScore(businessDetails.getAreaWalkScore());
			businessDetailsDTO.setAreaAttractionsScore(businessDetails.getAreaAttractionsScore());
			businessDetailsDTO.setAreaTransitScore(businessDetails.getAreaTransitScore());
			businessDetailsDTO.setSocialMediaScore(businessDetails.getSocialMediaScore());
			businessDetailsDTO.setPopulationIn1mileRadius(businessDetails.getPopulationIn1mileRadius());
			businessDetailsDTO.setIncomeScoreIn1mileRadius(businessDetails.getIncomeScoreIn1mileRadius());
			businessDetailsDTO.setPopulationIn3mileRadius(businessDetails.getPopulationIn3mileRadius());
			businessDetailsDTO.setIncomeScoreIn3mileRadius(businessDetails.getIncomeScoreIn3mileRadius());
			businessDetailsDTO.setPopulationIn5mileRadius(businessDetails.getPopulationIn5mileRadius());
			businessDetailsDTO.setIncomeScoreIn5mileRadius(businessDetails.getIncomeScoreIn5mileRadius());
			businessDetailsDTO.setDailyPeoplAtDoorNum(businessDetails.getDailyPeoplAtDoorNum());
			businessDetailsDTO.setDailyCarsAtParklotNum(businessDetails.getDailyCarsAtParklotNum());
			businessDetailsDTO.setYearEstablished(businessDetails.getYearEstablished());
			businessDetailsDTO.setCreatedByUserId(businessDetails.getCreatedByUserId());
			businessDetailsDTO.setCreateDate(businessDetails.getCreateDate().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")));
			businessDetailsDTO.setUpdatedByUserId(businessDetails.getUpdatedByUserId());
			businessDetailsDTO.setUpdateDate(businessDetails.getUpdateDate().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")));
			
			businessDetailsDTOList.add(businessDetailsDTO);
		}
		businessListDTO.setBusinessList(businessDetailsDTOList);
		return businessListDTO;
	}
	
	/**
	 * 
	 * @author sidpatil
	 * 
	 * estimateRealWorth
	 * 
	 * Business Real Worth Estimate will determine the value of business using below 3 Fundamental methods -
	 * 1. Assets Based -
	 * 1.1. In asset-based analysis the value of a business is equal to the sum of its parts. That is the theory underlying the asset-based approaches to 
	 * business valuation. The asset approach to business valuation reported on the books of the subject company at their acquisition value, net of 
	 * depreciation where applicable. 
	 * 1.2. These values must be adjusted to fair market value wherever possible. 
	 * 
	 * 2. Income Based -
	 * 2.1. The income approach relies upon the economic principle of expectation: the value of business is based on the expected economic benefit and level 
	 * of risk associated with the investment. 
	 * 21.2. Income based valuation methods determine fair market value by dividing the benefit stream generated by the 
	 * subject or target company times a discount or capitalization rate.
	 * 
	 * 3. Market Based -
	 * 3.1. Assign Weight Factor(WF - number betn 0-100) to each of the attribute that is critical in determining business valuation, the attributes will vary as per the type 
	 * of business. Eg. in case of restaurants Kitchen equipment price = 100, Customer Traffic = 100, Population density in 1 mile radius is = 80 and so on
	 * 3.2. Find 3 to 5 most recently sold business with approximately similar attributes in the same city or general area - call them comparable objects.
	 * 3.3. Get the average of top 10 or 20 most critical attributes of all comparable objects to come up with "super comparable" objects(SCO).
	 * 3.4. Start comparing attributes of business in question (BIQ) of which the worth is being determined and assign quality code(QC, a number betn -10 to 10) based on 
	 * if it is better or worse in comparison to SEO. Eg. If Kitchen Equipment Price(KEP) of SCO is 100K, and KEP for BIQ is 50K that is 100% more than SCO so QC in 
	 * this case can be 2.
	 * 3.5. Multiply WF and QC to come up with appropriate value... to be continued! 
	 */
	public String estimateRealWorth(BusinessDetailsDTO businessInQuestionDTO) {
		
		System.out.println("**** 111 Inside BusinessController.estimateRealWorth()");
		
		EstimatesListDTO estimateslistToAddDTO = new EstimatesListDTO();		
		List<EstimatesDTO> prosessedEstimatesDTOList = new ArrayList<EstimatesDTO>();

		//Asset Based
		EstimatesDTO estimatesBasedOnAssetsDTO = estimateRealWorthBasedOnAssets(businessInQuestionDTO);
		prosessedEstimatesDTOList.add(estimatesBasedOnAssetsDTO);
		
		//Income Based
		EstimatesDTO estimatesBasedOnIncomeDTO = estimateRealWorthBasedOnIncome(businessInQuestionDTO);
		prosessedEstimatesDTOList.add(estimatesBasedOnIncomeDTO);
		
		//Market Based
		EstimatesDTO estimatesBasedOnMarketDTO = estimateRealWorthBasedOnMarket(businessInQuestionDTO);
		prosessedEstimatesDTOList.add(estimatesBasedOnMarketDTO);
		
		estimateslistToAddDTO.setEstimatesList(prosessedEstimatesDTOList);
		
		try {
			estimateService.addEstimates(estimateslistToAddDTO);
			return "Y";
		} catch (Exception e) {
			e.printStackTrace();
			return "N";
		}
	}
	
	/**
	 * @author sidpatil
	 * estimateRealWorthBasedOnAssets
	 */
	private EstimatesDTO estimateRealWorthBasedOnAssets(BusinessDetailsDTO businessInQuestion) {
		
		System.out.println("**** 111 Inside BusinessController.estimateRealWorthBasedOnAssets()");		
		
		EstimatesDTO assetBasedEstimatesDTO = new EstimatesDTO();
		// TODO Implement the logic to estimate the Business Worth Based on Assets and store to t_wgpr_estimate table
		
		return assetBasedEstimatesDTO;
	}

	/**
	 * @author sidpatil
	 * estimateRealWorthBasedOnIncome
	 */
	private EstimatesDTO estimateRealWorthBasedOnIncome(BusinessDetailsDTO businessInQuestion) {
		
		System.out.println("**** 111 Inside BusinessController.estimateRealWorthBasedOnIncome()");
		
		EstimatesDTO incomeBasedEstimatesDTO = new EstimatesDTO();
		// TODO Implement the logic to estimate the Business Worth Based on Income and store to t_wgpr_estimate table
		
		return incomeBasedEstimatesDTO;
	}

	/**
	 * @author sidpatil
	 * estimateRealWorthBasedOnMarket
	 */
	private EstimatesDTO estimateRealWorthBasedOnMarket(BusinessDetailsDTO businessInQuestionDTO) {
		
		System.out.println("**** 222 Inside BusinessController.estimateRealWorthBasedOnMarket()");
			
		EstimatesDTO marketBasedestimatesDTO = new EstimatesDTO();
		Integer estimatedWorth = 0;
		Integer estimatedWorthHigh = 0;
		Integer estimatedWorthLow = 0;
		
		//1. Find as many as 5 comparable business based on type, state and city
		BusinessListDTO comparableBusinessDTOList = null;
		
		try {
			comparableBusinessDTOList = searchComparableBusiness(businessInQuestionDTO);
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		//
		
		for (BusinessDetailsDTO comparableBusinessDTO: comparableBusinessDTOList.getBusinessList()) {
			Integer compBizSoldPrice = 0;
			
			try {
				compBizSoldPrice = new Integer(bizTransactionService.getBizLastSoldPrice(comparableBusinessDTO.getBusinessId()).getTransactionAmount());
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			//Comparison based on revenue
			if((businessInQuestionDTO.getRevenueMonthly() - comparableBusinessDTO.getRevenueMonthly() >= businessInQuestionDTO.getRevenueMonthly() % 10) || 
					(businessInQuestionDTO.getRevenueMonthly() - comparableBusinessDTO.getRevenueMonthly() <= businessInQuestionDTO.getRevenueMonthly() % 10)) {			
				//skip - too big of a revenue difference
			} else {
				estimatedWorth = compBizSoldPrice;
				estimatedWorthHigh = estimatedWorth + estimatedWorth % 10;
				estimatedWorthLow = estimatedWorth - estimatedWorth % 10;
			}
		}
		
		marketBasedestimatesDTO.setBusinessId(businessInQuestionDTO.getBusinessId());
		marketBasedestimatesDTO.setEstimateType("MARKET_BASED");
		marketBasedestimatesDTO.setEstimateSubType("MARKET_BASED");
		marketBasedestimatesDTO.setEstimatedAmount(estimatedWorth.toString());
		marketBasedestimatesDTO.setEstimatedAmountHigh(estimatedWorthHigh.toString());
		marketBasedestimatesDTO.setEstimatedAmountLow(estimatedWorthLow.toString());
		
		return marketBasedestimatesDTO;
	}
	
	/**
	 * @author sidpatil
	 * findClosest
	 */
	public static int findClosest(int arr[], int target) 
    {
        int n = arr.length; 
  
        // Corner cases 
        if (target <= arr[0]){
            return arr[0];
        }
        if (target >= arr[n - 1]) {
            return arr[n - 1];
        }
  
        // Doing binary search  
        int i = 0, j = n, mid = 0;
        while (i < j) { 
            mid = (i + j)/2;
  
            if (arr[mid] == target){
                return arr[mid]; 
            }
            /* If target is less than array element, 
               then search in left */
            if (target < arr[mid]) { 
         
                // If target is greater than previous 
                // to mid, return closest of two 
                if (mid > 0 && target > arr[mid - 1]) { 
                    return getClosest(arr[mid - 1], arr[mid], target); 
                }
                /* Repeat for left half */
                j = mid;               
            } 
            // If target is greater than mid 
            else { 
                if (mid < n-1 && target < arr[mid + 1]) {
                    return getClosest(arr[mid], arr[mid + 1], target); 
                }
                i = mid + 1; // update i 
            } 
        } 
        // Only single element left after search 
        return arr[mid]; 
    } 
  
    // Method to compare which one is the more close 
    // We find the closest by taking the difference 
    //  between the target and both values. It assumes 
    // that val2 is greater than val1 and target lies 
    // between these two. 
    public static int getClosest(int val1, int val2, int target) 
    { 
        if (target - val1 >= val2 - target) { 
            return val2;
        }
        else {
            return val1;
        }
    } 
  
    // Test code 
    public static void main(String[] args) 
    { 
        int arr[] = { 1, 2, 4, 5, 6, 6, 8, 10, 12}; 
        int target = 11; 
        System.out.println(findClosest(arr, target)); 
    } 
}