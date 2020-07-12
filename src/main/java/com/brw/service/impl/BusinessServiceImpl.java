package com.brw.service.impl;

/**
 * @author sidpatil
 * 2019-20
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.brw.dao.BusinessDetailsDAO;
import com.brw.dao.BusinessInfoDAO;
import com.brw.dao.RelatedBusinessDAO;
import com.brw.dao.UserBusinessDAO;
import com.brw.dto.BusinessDetailsDTO;
import com.brw.dto.BusinessDetailsListDTO;
import com.brw.dto.BusinessInfoDTO;
import com.brw.dto.BusinessInfoListDTO;
import com.brw.dto.EstimatesDTO;
import com.brw.dto.EstimatesListDTO;
import com.brw.dto.RelatedBusinessDTO;
import com.brw.dto.RelatedBusinessListDTO;
import com.brw.dto.UserActivityDTO;
import com.brw.common.constants.Constants;

import com.brw.entities.BusinessDetails;
import com.brw.entities.BusinessInfo;
import com.brw.entities.RelatedBusiness;
import com.brw.entities.UserBusiness;
import com.brw.service.BizTransactionService;
import com.brw.service.EstimateService;
import com.brw.service.ImageService;
import com.brw.service.UserService;

@Component
public class BusinessServiceImpl implements com.brw.service.BusinessService {
    
	private static final Logger logger = LoggerFactory.getLogger(BusinessServiceImpl.class);

	@Autowired
	EstimateService estimateService;
	
	@Autowired
	BizTransactionService bizTransactionService;
	
	@Autowired
	UserService userService;
	
	@Autowired
	ImageService imageService;
	
	@Autowired
	private UserBusinessDAO userBusinessDAO;
	
	@Autowired
	private BusinessDetailsDAO businessDetailsDAO;
	
	@Autowired
	private BusinessInfoDAO businessInfoDAO;
	
	@Autowired
	private RelatedBusinessDAO relatedBusinessDAO;

	@Override
	public BusinessInfoListDTO searchBusiness(BusinessDetailsDTO businessDTO) {
		long start = System.currentTimeMillis();

		//TODO:TEMPORARY translation of zip code - need to fix it on UI and then remove this code
		if (businessDTO.getZip().equals("94536")) {
			businessDTO.setZip(null);
		}
				
		// TODO Auto-generated method stub
		logger.info("**** 222 Inside BusinessServiceImpl.searchBusiness() getInvokerId: "+businessDTO.getInvokerId());
		
		logger.info("**** 222 Inside BusinessServiceImpl.searchBusiness() getName: "+businessDTO.getName());
		
		logger.info("**** 222 Inside BusinessServiceImpl.searchBusiness() getType: "+businessDTO.getType());

		logger.info("**** 222 Inside BusinessServiceImpl.searchBusiness() getStreet1: "+businessDTO.getStreet1());

		logger.info("**** 222 Inside BusinessServiceImpl.searchBusiness() getStreet2: "+businessDTO.getStreet2());

		logger.info("**** 222 Inside BusinessServiceImpl.searchBusiness() getCity: "+businessDTO.getCity());

		logger.info("**** 222 Inside BusinessServiceImpl.searchBusiness() getZip: "+businessDTO.getZip());

		logger.info("**** 222 Inside BusinessServiceImpl.searchBusiness() getCounty: "+businessDTO.getCounty());

		logger.info("**** 222 Inside BusinessServiceImpl.searchBusiness() getStateCode: "+businessDTO.getStateCode());
		
		logger.info("**** 222 Inside BusinessServiceImpl.searchBusiness() getIsFranchise: "+businessDTO.getIsFranchise());
		
		logger.info("**** 222 Inside BusinessServiceImpl.searchBusiness() getIsForSell: "+businessDTO.getIsForSell());

		logger.info("**** 222 Inside BusinessServiceImpl.searchBusiness() getLatitude: "+businessDTO.getLatitude());

		logger.info("**** 222 Inside BusinessServiceImpl.searchBusiness() getLongitude: "+businessDTO.getLongitude());

		logger.info("**** 222 Inside BusinessServiceImpl.searchBusiness() getRangeMile: "+businessDTO.getRangeMile());
		
		List<BusinessInfo> businessList = null;
		
		if(businessDTO.getIsForSell().equals(Constants.Y)) {
			if (null != businessDTO.getZip() && businessDTO.getZip().equals(Constants.EMPTY_STRING)) {
				if (null != businessDTO.getName() && null != businessDTO.getType() && null != businessDTO.getStreet1() && !Constants.EMPTY_STRING.equals(businessDTO.getName()) && !Constants.EMPTY_STRING.equals(businessDTO.getType()) && !Constants.EMPTY_STRING.equals(businessDTO.getStreet1())) {
					logger.info("**** 333 Executing searchBusiness_1");
					
					businessList = (List<BusinessInfo>) businessInfoDAO.searchBusiness_1(businessDTO.getName(), businessDTO.getType(), businessDTO.getStreet1(), businessDTO.getZip(), businessDTO.getIsFranchise(), businessDTO.getIsForSell());
				
				} else if (null != businessDTO.getName() && null != businessDTO.getType() && !Constants.EMPTY_STRING.equals(businessDTO.getName()) && !Constants.EMPTY_STRING.equals(businessDTO.getType())) {
					logger.info("**** 333 Executing searchBusiness_2");
					
					businessList = (List<BusinessInfo>) businessInfoDAO.searchBusiness_2(businessDTO.getName(), businessDTO.getType(), businessDTO.getZip(), businessDTO.getIsFranchise(), businessDTO.getIsForSell());
				
				} else if (null != businessDTO.getName() && null != businessDTO.getStreet1() && !Constants.EMPTY_STRING.equals(businessDTO.getName()) && !Constants.EMPTY_STRING.equals(businessDTO.getStreet1())) {
					logger.info("**** 333 Executing searchBusiness_3");
					
					businessList = (List<BusinessInfo>) businessInfoDAO.searchBusiness_3(businessDTO.getName(), businessDTO.getStreet1(), businessDTO.getZip(), businessDTO.getIsFranchise(), businessDTO.getIsForSell());
				
				} else if (null != businessDTO.getType() && null != businessDTO.getStreet1() && !Constants.EMPTY_STRING.equals(businessDTO.getType()) && !Constants.EMPTY_STRING.equals(businessDTO.getStreet1())) {
					logger.info("**** 333 Executing searchBusiness_4");
	
					businessList = (List<BusinessInfo>) businessInfoDAO.searchBusiness_4(businessDTO.getType(), businessDTO.getStreet1(), businessDTO.getZip(), businessDTO.getIsFranchise(), businessDTO.getIsForSell());
				
				} else if (null != businessDTO.getName() && !Constants.EMPTY_STRING.equals(businessDTO.getName())) {
					logger.info("**** 333 Executing searchBusiness_5");
	
					businessList = (List<BusinessInfo>) businessInfoDAO.searchBusiness_5(businessDTO.getName(), businessDTO.getZip(), businessDTO.getIsFranchise(), businessDTO.getIsForSell());
				
				} else if (null != businessDTO.getType() && !Constants.EMPTY_STRING.equals(businessDTO.getType())) {
					logger.info("**** 333 Executing searchBusiness_6");
	
					businessList = (List<BusinessInfo>) businessInfoDAO.searchBusiness_6(businessDTO.getType(), businessDTO.getZip(), businessDTO.getIsFranchise(), businessDTO.getIsForSell());
		
				} else {
					logger.info("**** 333 Executing searchBusiness_7");
	
					businessList = (List<BusinessInfo>) businessInfoDAO.searchBusiness_7(businessDTO.getZip(), businessDTO.getIsFranchise(), businessDTO.getIsForSell());
				}
			} else if (null != businessDTO.getCity() && !Constants.EMPTY_STRING.equals(businessDTO.getCity())) {
				if (null != businessDTO.getName() && null != businessDTO.getType() && null != businessDTO.getStreet1() && !Constants.EMPTY_STRING.equals(businessDTO.getName()) && !Constants.EMPTY_STRING.equals(businessDTO.getType()) && !Constants.EMPTY_STRING.equals(businessDTO.getStreet1())) {
					logger.info("**** 333 Executing searchBusiness_8");
	
					businessList = (List<BusinessInfo>) businessInfoDAO.searchBusiness_8(businessDTO.getName(), businessDTO.getType(), businessDTO.getStreet1(), businessDTO.getCity(), businessDTO.getStateCode(), businessDTO.getIsFranchise(), businessDTO.getIsForSell());
				
				} else if (null != businessDTO.getName() && null != businessDTO.getType() && !Constants.EMPTY_STRING.equals(businessDTO.getName()) && !Constants.EMPTY_STRING.equals(businessDTO.getType())) {
					logger.info("**** 333 Executing searchBusiness_9");
	
					businessList = (List<BusinessInfo>) businessInfoDAO.searchBusiness_9(businessDTO.getName(), businessDTO.getType(), businessDTO.getCity(), businessDTO.getStateCode(), businessDTO.getIsFranchise(), businessDTO.getIsForSell());
					
					logger.info("**** 333 Executing searchBusiness_9 businessList SIZE: "+businessList.size());
	
				} else if (null != businessDTO.getName() && null != businessDTO.getStreet1() && !Constants.EMPTY_STRING.equals(businessDTO.getName()) && !Constants.EMPTY_STRING.equals(businessDTO.getStreet1())) {
					logger.info("**** 333 Executing searchBusiness_10");
	
					businessList = (List<BusinessInfo>) businessInfoDAO.searchBusiness_10(businessDTO.getName(), businessDTO.getStreet1(), businessDTO.getCity(), businessDTO.getStateCode(), businessDTO.getIsFranchise(), businessDTO.getIsForSell());
				
				} else if (null != businessDTO.getType() && null != businessDTO.getStreet1() && !Constants.EMPTY_STRING.equals(businessDTO.getType()) && !Constants.EMPTY_STRING.equals(businessDTO.getStreet1())) {
					logger.info("**** 333 Executing searchBusiness_11");
	
					businessList = (List<BusinessInfo>) businessInfoDAO.searchBusiness_11(businessDTO.getType(), businessDTO.getStreet1(), businessDTO.getCity(), businessDTO.getStateCode(), businessDTO.getIsFranchise(), businessDTO.getIsForSell());
				
				} else if (null != businessDTO.getName() && !Constants.EMPTY_STRING.equals(businessDTO.getName())) {
					logger.info("**** 333 Executing searchBusiness_12");
	
					businessList = (List<BusinessInfo>) businessInfoDAO.searchBusiness_12(businessDTO.getName(), businessDTO.getCity(), businessDTO.getStateCode(), businessDTO.getIsFranchise(), businessDTO.getIsForSell());
					
					logger.info("**** 333 Executing searchBusiness_12 businessList SIZE: "+businessList.size());
	
				} else if (null != businessDTO.getType() && !Constants.EMPTY_STRING.equals(businessDTO.getType())) {
					logger.info("**** 333 Executing searchBusiness_13");
	
					businessList = (List<BusinessInfo>) businessInfoDAO.searchBusiness_13(businessDTO.getType(), businessDTO.getCity(), businessDTO.getStateCode(), businessDTO.getIsFranchise(), businessDTO.getIsForSell());
		
				} else {
					logger.info("**** 333 Executing searchBusiness_14");
	
					businessList = (List<BusinessInfo>) businessInfoDAO.searchBusiness_14(businessDTO.getCity(), businessDTO.getStateCode(), businessDTO.getIsFranchise(), businessDTO.getIsForSell());
	
				}
			} else if (null != businessDTO.getCounty() && !Constants.EMPTY_STRING.equals(businessDTO.getCounty())) {
				if (null != businessDTO.getName() && null != businessDTO.getType() && null != businessDTO.getStreet1() && !Constants.EMPTY_STRING.equals(businessDTO.getName()) && !Constants.EMPTY_STRING.equals(businessDTO.getType()) && !Constants.EMPTY_STRING.equals(businessDTO.getStreet1())) {
					logger.info("**** 333 Executing searchBusiness_15");
	
					businessList = (List<BusinessInfo>) businessInfoDAO.searchBusiness_15(businessDTO.getName(), businessDTO.getType(), businessDTO.getStreet1(), businessDTO.getCounty(), businessDTO.getStateCode(), businessDTO.getIsFranchise(), businessDTO.getIsForSell());
				
				} else if (null != businessDTO.getName() && null != businessDTO.getType() && !Constants.EMPTY_STRING.equals(businessDTO.getName()) && !Constants.EMPTY_STRING.equals(businessDTO.getType())) {
					logger.info("**** 333 Executing searchBusiness_16");
	
					businessList = (List<BusinessInfo>) businessInfoDAO.searchBusiness_16(businessDTO.getName(),businessDTO.getType(), businessDTO.getCounty(), businessDTO.getStateCode(), businessDTO.getIsFranchise(), businessDTO.getIsForSell());
				
				} else if (null != businessDTO.getName() && null != businessDTO.getStreet1() && !Constants.EMPTY_STRING.equals(businessDTO.getName()) && !Constants.EMPTY_STRING.equals(businessDTO.getStreet1())) {
					logger.info("**** 333 Executing searchBusiness_17");
					
					businessList = (List<BusinessInfo>) businessInfoDAO.searchBusiness_17(businessDTO.getName(), businessDTO.getStreet1(), businessDTO.getCounty(), businessDTO.getStateCode(), businessDTO.getIsFranchise(), businessDTO.getIsForSell());
				
				} else if (null != businessDTO.getType() && null != businessDTO.getStreet1() && !Constants.EMPTY_STRING.equals(businessDTO.getType()) && !Constants.EMPTY_STRING.equals(businessDTO.getStreet1())) {
					logger.info("**** 333 Executing searchBusiness_18");
	
					businessList = (List<BusinessInfo>) businessInfoDAO.searchBusiness_18(businessDTO.getType(), businessDTO.getStreet1(), businessDTO.getCounty(), businessDTO.getStateCode(), businessDTO.getIsFranchise(), businessDTO.getIsForSell());
				
				} else if (null != businessDTO.getName() && !Constants.EMPTY_STRING.equals(businessDTO.getName())) {
					logger.info("**** 333 Executing searchBusiness_19");
	
					businessList = (List<BusinessInfo>) businessInfoDAO.searchBusiness_19(businessDTO.getName(), businessDTO.getCounty(), businessDTO.getStateCode(), businessDTO.getIsFranchise(), businessDTO.getIsForSell());
				
				} else if (null != businessDTO.getType() && !Constants.EMPTY_STRING.equals(businessDTO.getType())) {
					logger.info("**** 333 Executing searchBusiness_20");
	
					businessList = (List<BusinessInfo>) businessInfoDAO.searchBusiness_20(businessDTO.getType(), businessDTO.getCounty(), businessDTO.getStateCode(), businessDTO.getIsFranchise(), businessDTO.getIsForSell());
		
				} else {
					logger.info("**** 333 Executing searchBusiness_21");
	
					businessList = (List<BusinessInfo>) businessInfoDAO.searchBusiness_21(businessDTO.getCounty(), businessDTO.getStateCode(), businessDTO.getIsFranchise(), businessDTO.getIsForSell());
	
				}
			} else if (businessDTO.getLatitude() != 0 && businessDTO.getLongitude() != 0) {
				logger.info("**** XXX Constants.PERCENT+businessDTO.getName()+Constants.PERCENT: "+Constants.PERCENT+businessDTO.getName()+Constants.PERCENT);
	
				if (null != businessDTO.getName() && null != businessDTO.getType() && !Constants.EMPTY_STRING.equals(businessDTO.getName()) && !Constants.EMPTY_STRING.equals(businessDTO.getType())) {
					logger.info("**** 333 Executing searchBusiness_22");
					businessList = (List<BusinessInfo>) businessInfoDAO.searchBusiness_22(Constants.PERCENT+businessDTO.getName()+Constants.PERCENT, businessDTO.getType(), businessDTO.getIsFranchise(), businessDTO.getIsForSell(), businessDTO.getLatitude(), businessDTO.getLongitude(), businessDTO.getRangeMile());
				
				} else if (null != businessDTO.getName() && !Constants.EMPTY_STRING.equals(businessDTO.getName())) {
					logger.info("**** 333 Executing searchBusiness_23");
					businessList = (List<BusinessInfo>) businessInfoDAO.searchBusiness_23(Constants.PERCENT+businessDTO.getName()+Constants.PERCENT, businessDTO.getIsFranchise(), businessDTO.getIsForSell(), businessDTO.getLatitude(), businessDTO.getLongitude(), businessDTO.getRangeMile());
				
				} else if (null != businessDTO.getType() && !Constants.EMPTY_STRING.equals(businessDTO.getType())) {
					logger.info("**** 333 Executing searchBusiness_24");
					businessList = (List<BusinessInfo>) businessInfoDAO.searchBusiness_24(businessDTO.getType(), businessDTO.getIsFranchise(), businessDTO.getIsForSell(), businessDTO.getLatitude(), businessDTO.getLongitude(), businessDTO.getRangeMile());
				}
			}
		} else {
			if (null != businessDTO.getZip() && businessDTO.getZip() != Constants.EMPTY_STRING) {
				if (null != businessDTO.getName() && null != businessDTO.getType() && null != businessDTO.getStreet1() && !Constants.EMPTY_STRING.equals(businessDTO.getName()) && !Constants.EMPTY_STRING.equals(businessDTO.getType()) && !Constants.EMPTY_STRING.equals(businessDTO.getStreet1())) {
					logger.info("**** 333 Executing searchBusiness_1_FSN");
					
					businessList = (List<BusinessInfo>) businessInfoDAO.searchBusiness_1_FSN(businessDTO.getName(), businessDTO.getType(), businessDTO.getStreet1(), businessDTO.getZip());
				
				} else if (null != businessDTO.getName() && null != businessDTO.getType() && !Constants.EMPTY_STRING.equals(businessDTO.getName()) && !Constants.EMPTY_STRING.equals(businessDTO.getType())) {
					logger.info("**** 333 Executing searchBusiness_2_FSN");
					
					businessList = (List<BusinessInfo>) businessInfoDAO.searchBusiness_2_FSN(businessDTO.getName(), businessDTO.getType(), businessDTO.getZip());
				
				} else if (null != businessDTO.getName() && null != businessDTO.getStreet1() && !Constants.EMPTY_STRING.equals(businessDTO.getName()) && !Constants.EMPTY_STRING.equals(businessDTO.getStreet1())) {
					logger.info("**** 333 Executing searchBusiness_3_FSN");
					
					businessList = (List<BusinessInfo>) businessInfoDAO.searchBusiness_3_FSN(businessDTO.getName(), businessDTO.getStreet1(), businessDTO.getZip());
				
				} else if (null != businessDTO.getType() && null != businessDTO.getStreet1() && !Constants.EMPTY_STRING.equals(businessDTO.getType()) && !Constants.EMPTY_STRING.equals(businessDTO.getStreet1())) {
					logger.info("**** 333 Executing searchBusiness_4_FSN");

					businessList = (List<BusinessInfo>) businessInfoDAO.searchBusiness_4_FSN(businessDTO.getType(), businessDTO.getStreet1(), businessDTO.getZip());
				
				} else if (null != businessDTO.getName() && !Constants.EMPTY_STRING.equals(businessDTO.getName())) {
					logger.info("**** 333 Executing searchBusiness_5_FSN");

					businessList = (List<BusinessInfo>) businessInfoDAO.searchBusiness_5_FSN(businessDTO.getName(), businessDTO.getZip());
				
				} else if (null != businessDTO.getType() && !Constants.EMPTY_STRING.equals(businessDTO.getType())) {
					logger.info("**** 333 Executing searchBusiness_6_FSN");

					businessList = (List<BusinessInfo>) businessInfoDAO.searchBusiness_6_FSN(businessDTO.getType(), businessDTO.getZip());
		
				} else {
					logger.info("**** 333 Executing searchBusiness_7_FSN");

					businessList = (List<BusinessInfo>) businessInfoDAO.searchBusiness_7_FSN(businessDTO.getZip());
				}
			} else if (null != businessDTO.getCity() && !Constants.EMPTY_STRING.equals(businessDTO.getCity())) {
				if (null != businessDTO.getName() && null != businessDTO.getType() && null != businessDTO.getStreet1() && !Constants.EMPTY_STRING.equals(businessDTO.getName()) && !Constants.EMPTY_STRING.equals(businessDTO.getType()) && !Constants.EMPTY_STRING.equals(businessDTO.getStreet1())) {
					logger.info("**** 333 Executing searchBusiness_8_FSN");

					businessList = (List<BusinessInfo>) businessInfoDAO.searchBusiness_8_FSN(businessDTO.getName(), businessDTO.getType(), businessDTO.getStreet1(), businessDTO.getCity(), businessDTO.getStateCode());
				
				} else if (null != businessDTO.getName() && null != businessDTO.getType() && !Constants.EMPTY_STRING.equals(businessDTO.getName()) && !Constants.EMPTY_STRING.equals(businessDTO.getType())) {
					logger.info("**** 333 Executing searchBusiness_9_FSN");

					businessList = (List<BusinessInfo>) businessInfoDAO.searchBusiness_9_FSN(businessDTO.getName(), businessDTO.getType(), businessDTO.getCity(), businessDTO.getStateCode());
					
					logger.info("**** 333 Executing searchBusiness_9_FSN businessList SIZE: "+businessList.size());

				} else if (null != businessDTO.getName() && null != businessDTO.getStreet1() && !Constants.EMPTY_STRING.equals(businessDTO.getName()) && !Constants.EMPTY_STRING.equals(businessDTO.getStreet1())) {
					logger.info("**** 333 Executing searchBusiness_10_FSN");

					businessList = (List<BusinessInfo>) businessInfoDAO.searchBusiness_10_FSN(businessDTO.getName(), businessDTO.getStreet1(), businessDTO.getCity(), businessDTO.getStateCode());
				
				} else if (null != businessDTO.getType() && null != businessDTO.getStreet1() && !Constants.EMPTY_STRING.equals(businessDTO.getType()) && !Constants.EMPTY_STRING.equals(businessDTO.getStreet1())) {
					logger.info("**** 333 Executing searchBusiness_11_FSN");

					businessList = (List<BusinessInfo>) businessInfoDAO.searchBusiness_11_FSN(businessDTO.getType(), businessDTO.getStreet1(), businessDTO.getCity(), businessDTO.getStateCode());
				
				} else if (null != businessDTO.getName() && !Constants.EMPTY_STRING.equals(businessDTO.getName())) {
					logger.info("**** 333 Executing searchBusiness_12_FSN");

					businessList = (List<BusinessInfo>) businessInfoDAO.searchBusiness_12_FSN(businessDTO.getName(), businessDTO.getCity(), businessDTO.getStateCode());
					
					logger.info("**** 333 Executing searchBusiness_12 businessList SIZE: "+businessList.size());

				} else if (null != businessDTO.getType() && !Constants.EMPTY_STRING.equals(businessDTO.getType())) {
					logger.info("**** 333 Executing searchBusiness_13_FSN");

					businessList = (List<BusinessInfo>) businessInfoDAO.searchBusiness_13_FSN(businessDTO.getType(), businessDTO.getCity(), businessDTO.getStateCode());
		
				} else {
					logger.info("**** 333 Executing searchBusiness_14_FSN");

					businessList = (List<BusinessInfo>) businessInfoDAO.searchBusiness_14_FSN(businessDTO.getCity(), businessDTO.getStateCode());

				}
			} else if (null != businessDTO.getCounty() && !Constants.EMPTY_STRING.equals(businessDTO.getCounty())) {
				if (null != businessDTO.getName() && null != businessDTO.getType() && null != businessDTO.getStreet1() && !Constants.EMPTY_STRING.equals(businessDTO.getName()) && !Constants.EMPTY_STRING.equals(businessDTO.getType()) && !Constants.EMPTY_STRING.equals(businessDTO.getStreet1())) {
					logger.info("**** 333 Executing searchBusiness_15_FSN");

					businessList = (List<BusinessInfo>) businessInfoDAO.searchBusiness_15_FSN(businessDTO.getName(), businessDTO.getType(), businessDTO.getStreet1(), businessDTO.getCounty(), businessDTO.getStateCode());
				
				} else if (null != businessDTO.getName() && null != businessDTO.getType() && !Constants.EMPTY_STRING.equals(businessDTO.getName()) && !Constants.EMPTY_STRING.equals(businessDTO.getType())) {
					logger.info("**** 333 Executing searchBusiness_16_FSN");

					businessList = (List<BusinessInfo>) businessInfoDAO.searchBusiness_16_FSN(businessDTO.getName(),businessDTO.getType(), businessDTO.getCounty(), businessDTO.getStateCode());
				
				} else if (null != businessDTO.getName() && null != businessDTO.getStreet1() && !Constants.EMPTY_STRING.equals(businessDTO.getName()) && !Constants.EMPTY_STRING.equals(businessDTO.getStreet1())) {
					logger.info("**** 333 Executing searchBusiness_17_FSN");
					
					businessList = (List<BusinessInfo>) businessInfoDAO.searchBusiness_17_FSN(businessDTO.getName(), businessDTO.getStreet1(), businessDTO.getCounty(), businessDTO.getStateCode());
				
				} else if (null != businessDTO.getType() && null != businessDTO.getStreet1() && !Constants.EMPTY_STRING.equals(businessDTO.getType()) && !Constants.EMPTY_STRING.equals(businessDTO.getStreet1())) {
					logger.info("**** 333 Executing searchBusiness_18_FSN");

					businessList = (List<BusinessInfo>) businessInfoDAO.searchBusiness_18_FSN(businessDTO.getType(), businessDTO.getStreet1(), businessDTO.getCounty(), businessDTO.getStateCode());
				
				} else if (null != businessDTO.getName() && !Constants.EMPTY_STRING.equals(businessDTO.getName())) {
					logger.info("**** 333 Executing searchBusiness_19_FSN");

					businessList = (List<BusinessInfo>) businessInfoDAO.searchBusiness_19_FSN(businessDTO.getName(), businessDTO.getCounty(), businessDTO.getStateCode());
				
				} else if (null != businessDTO.getType() && !Constants.EMPTY_STRING.equals(businessDTO.getType())) {
					logger.info("**** 333 Executing searchBusiness_20_FSN");

					businessList = (List<BusinessInfo>) businessInfoDAO.searchBusiness_20_FSN(businessDTO.getType(), businessDTO.getCounty(), businessDTO.getStateCode());
		
				} else {
					logger.info("**** 333 Executing searchBusiness_21_FSN");

					businessList = (List<BusinessInfo>) businessInfoDAO.searchBusiness_21_FSN(businessDTO.getCounty(), businessDTO.getStateCode());

				}
			} else if (businessDTO.getLatitude() != 0 && businessDTO.getLongitude() != 0) {
				logger.info("**** XXX Constants.PERCENT+businessDTO.getName()+Constants.PERCENT: "+Constants.PERCENT+businessDTO.getName()+Constants.PERCENT);

				if (null != businessDTO.getName() && null != businessDTO.getType() && !Constants.EMPTY_STRING.equals(businessDTO.getName()) && !Constants.EMPTY_STRING.equals(businessDTO.getType())) {
					logger.info("**** 333 Executing searchBusiness_22_FSN");
					businessList = (List<BusinessInfo>) businessInfoDAO.searchBusiness_22_FSN(Constants.PERCENT+businessDTO.getName()+Constants.PERCENT, businessDTO.getType(), businessDTO.getLatitude(), businessDTO.getLongitude(), businessDTO.getRangeMile());
				
				} else if (null != businessDTO.getName() && !Constants.EMPTY_STRING.equals(businessDTO.getName())) {
					logger.info("**** 333 Executing searchBusiness_23_FSN");
					businessList = (List<BusinessInfo>) businessInfoDAO.searchBusiness_23_FSN(Constants.PERCENT+businessDTO.getName()+Constants.PERCENT, businessDTO.getLatitude(), businessDTO.getLongitude(), businessDTO.getRangeMile());
				
				} else if (null != businessDTO.getType() && !Constants.EMPTY_STRING.equals(businessDTO.getType())) {
					logger.info("**** 333 Executing searchBusiness_24_FSN");
					businessList = (List<BusinessInfo>) businessInfoDAO.searchBusiness_24_FSN(businessDTO.getType(), businessDTO.getLatitude(), businessDTO.getLongitude(), businessDTO.getRangeMile());
				}
			}
		}

		logger.info("**** TOTAL NUMBER OF RECORDS IN SEARCH RESULT: "+businessList.size());

		List<BusinessInfoDTO> businessInfoDTOList = new ArrayList<BusinessInfoDTO>();
		BusinessInfoListDTO businessInfoListDTO = new BusinessInfoListDTO();
		
		for (BusinessInfo businessInfo: businessList) {
			
			BusinessInfoDTO businessInfoDTO = new BusinessInfoDTO();
			businessInfoDTO.setInvokerId(businessDTO.getInvokerId());
			businessInfoDTO.setBusinessId(businessInfo.getBusinessId());
			businessInfoDTO.setIsHidden(businessInfo.getIsHidden());
			businessInfoDTO.setType(businessInfo.getType());
			businessInfoDTO.setSubType(businessInfo.getSubType());
			businessInfoDTO.setIsForSell(businessInfo.getIsForSell());
			businessInfoDTO.setForSellPrice(businessInfo.getForSellPrice());
			businessInfoDTO.setIsVendorCall(businessInfo.getIsVendorCall());
			businessInfoDTO.setIsFranchise(businessInfo.getIsFranchise());

			//This IF block is written to avoid showing Hidden Business address and lat/long
			if (businessInfo.getIsHidden().equals(Constants.Y)) {
				businessInfoDTO.setName("Business for Sell in " + businessInfo.getCity() + " city of " + businessInfo.getCounty() + " " + "County" );
				
			} else {		
				businessInfoDTO.setName(businessInfo.getName());
				businessInfoDTO.setStreet1(businessInfo.getStreet1());
				businessInfoDTO.setStreet2(businessInfo.getStreet2());
				businessInfoDTO.setCity(businessInfo.getCity());
				businessInfoDTO.setCounty(businessInfo.getCounty());
				businessInfoDTO.setStateCode(businessInfo.getStateCode());
				businessInfoDTO.setZip(businessInfo.getZip());
				businessInfoDTO.setFormattedAddress(businessInfo.getgFormattedAdd());
				businessInfoDTO.setLatitude(businessInfo.getLatitude());
				businessInfoDTO.setLongitude(businessInfo.getLongitude());
				
				//logger.info("**** LAT in BRW DB businessInfo.getLatitude(): "+businessInfo.getLatitude());
				//logger.info("**** LONG in BRW DB businessInfo.getLongitude(): "+businessInfo.getLongitude());
				//logger.info("**** LONG in BRW DB businessInfo.getImageFirst(): "+businessInfo.getImageFirst());

				//set call google flag true if latitude and longitude do not exist in BRW DB
				if (businessInfo.getIsVendorCall().equals(Constants.N) && (0.0 == businessInfo.getLatitude() || 0.0 == businessInfo.getLongitude() || businessInfo.getImageFirst().equals(Constants.EMPTY_STRING))) {
					logger.info("**** Lat/Lng NOT-FOUND in BRW DB");					
					String gSearchString = null;

					List<String> pobAddress = new ArrayList<>();
					pobAddress.add(Constants.PO_BOX_1);
					pobAddress.add(Constants.PO_BOX_2);
					pobAddress.add(Constants.PO_BOX_3);
					pobAddress.add(Constants.PO_BOX_4);
					pobAddress.add(Constants.PO_BOX_5);
					
					logger.info("**** businessInfo.getStreet1(): "+businessInfo.getStreet1());
					if (null != businessInfo.getStreet1() && pobAddress.stream().anyMatch(s -> s.equals(businessInfo.getStreet1().toLowerCase()))) {
						gSearchString = ""+businessInfo.getStreet1()+", "+businessInfo.getCity()+", "+businessInfo.getStateCode()+", "+businessInfo.getZip()+Constants.EMPTY_STRING;
						businessInfoDTO.setGoogleBizSearchString(gSearchString);
						logger.info("**** ADDRESS Input gSearchString to Google API: "+gSearchString);
						
					} else {
						gSearchString = ""+businessInfo.getName()+", "+businessInfo.getCity()+", "+businessInfo.getStateCode()+", "+businessInfo.getZip()+Constants.EMPTY_STRING;
						businessInfoDTO.setGoogleBizSearchString(gSearchString);
						logger.info("**** BIZ NAME Input gSearchString to Google API: "+gSearchString);
						
					}
				}
			}
			
			//logger.info("**** businessInfo.getImageFirst(): "+businessInfo.getImageFirst());
			if(null != businessInfo.getImageFirst() && !businessInfo.getImageFirst().equals(Constants.EMPTY_STRING)) {
				//If ImageFirst Exist then pick up Image First
				businessInfoDTO.setImageFirst(businessInfo.getImageFirst());
				logger.info("222 Setting REGULAR IMAGE FIRST");

			} else {
				//If there is no first image saved in BRW DB and also we can't get it from google then call this method
				//TODO: Come up with better Solution - Right now we are picking up random image based on the business type
				try {
					//businessInfoDTO.setAlternateImageFirst(imageService.getDefaultImageForBizType(businessInfo.getType()));
					businessInfoDTO.setImageFirst(imageService.getDefaultImageForBizType(businessInfo.getType()));
					logger.info("222 Setting ALTERNATE IMAGE FIRST");

				} catch (Exception e) {
					e.printStackTrace();
				}
			}

			businessInfoDTOList.add(businessInfoDTO);	
		}// end of for loop
		
		businessInfoListDTO.setBusinessList(businessInfoDTOList);
		logger.info("Elapsed time in SearchBusiness(): " + (System.currentTimeMillis() - start));

		return businessInfoListDTO;
	}

	//Method to retrieve LIMITED Business Attributes from t_brw_busines table based on biz_id used in UserServiceImpl
	@Override
	public BusinessInfoDTO getBusinessInfoFromBRWDB(int businessId) {
		long start = System.currentTimeMillis();

		logger.info("**** 222 Inside BusinessServiceImpl.getBusinessInfoFromBRWDB() businessId: "+businessId);
		
		BusinessInfo businessInfo = (BusinessInfo) businessInfoDAO.getBusinessInfo(businessId);
		
		BusinessInfoDTO businessInfoDTO = new BusinessInfoDTO();
		businessInfoDTO.setBusinessId(businessInfo.getBusinessId());
		businessInfoDTO.setType(businessInfo.getType());
		businessInfoDTO.setSubType(businessInfo.getSubType());
		businessInfoDTO.setIsForSell(businessInfo.getIsForSell());
		businessInfoDTO.setIsHidden(businessInfo.getIsHidden());
		businessInfoDTO.setForSellPrice(businessInfo.getForSellPrice());
		//businessInfoDTO.setImageFirst(businessInfo.getImageFirst());
		if(null != businessInfo.getImageFirst() || !Constants.EMPTY_STRING.equals(businessInfo.getImageFirst())) {
			//If ImageFirst Exist then pick up Image First
			businessInfoDTO.setImageFirst(businessInfo.getImageFirst());
		} else {
			try {
				//TODO: Come up with better Solution - Right now we are picking up random image based on the business type
				businessInfoDTO.setAlternateImageFirst(imageService.getDefaultImageForBizType(businessInfo.getType()));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		logger.info("**** 222 Inside BusinessServiceImpl.getBusinessDetails() businessDetails.getIsHidden(): "+businessInfo.getIsHidden());

		if (businessInfo.getIsHidden().equals(Constants.Y)) {			
			businessInfoDTO.setName("Business for Sell in " + businessInfo.getCity() + ", " + businessInfo.getCounty() + " " + "County" );
			
			logger.info("**** 222 Inside BusinessServiceImpl.getBusinessDetails() businessInfoDTO.getName(): "+businessInfoDTO.getName());
		} else {
			businessInfoDTO.setName(businessInfo.getName());
			businessInfoDTO.setStreet1(businessInfo.getStreet1());
			businessInfoDTO.setStreet2(businessInfo.getStreet2());
			businessInfoDTO.setCity(businessInfo.getCity());
			businessInfoDTO.setCounty(businessInfo.getCounty());
			businessInfoDTO.setStateCode(businessInfo.getStateCode());
			businessInfoDTO.setZip(businessInfo.getZip());	
			businessInfoDTO.setLatitude(businessInfo.getLatitude());
			businessInfoDTO.setLongitude(businessInfo.getLongitude());
		}
		logger.info("Elapsed time in GetBusinessInfoFromBRWDB: " + (System.currentTimeMillis() - start));

		return businessInfoDTO;
	}
	
	//Method to retrieve ALL Business Attributes from t_brw_busines table based on biz_id
	@Override
	public BusinessDetailsDTO getBusinessDetailsFromBRWDB(int businessId) {
		long start = System.currentTimeMillis();

		// TODO Auto-generated method stub
		logger.info("**** 222 Inside BusinessServiceImpl.getBusinessDetailsFromBRWDB() businessId: "+businessId);
		
		BusinessDetails businessDetails = (BusinessDetails) businessDetailsDAO.getBusinessDetails(businessId);
		
		BusinessDetailsDTO businessDetailsDTO = new BusinessDetailsDTO();
		
		businessDetailsDTO.setBusinessId(businessDetails.getBusinessId());
		
		businessDetailsDTO.setFirstOwnerName(businessDetails.getFirstOwnerName());
		businessDetailsDTO.setSecondOwnerName(businessDetails.getSecondOwnerName());
		businessDetailsDTO.setBrandName(businessDetails.getBrandName());
		businessDetailsDTO.setType(businessDetails.getType());
		businessDetailsDTO.setSubType(businessDetails.getSubType());
		businessDetailsDTO.setRegCityName(businessDetails.getRegCityName());
		businessDetailsDTO.setRegCityCode(businessDetails.getRegCityCode());
		if (null != businessDetails.getRegCityDate()) {
			businessDetailsDTO.setRegCityDate(businessDetails.getRegCityDate().format(DateTimeFormatter.ofPattern(Constants.DATE_FORMAT)));
		}
		businessDetailsDTO.setRegStateName(businessDetails.getRegStateName());
		businessDetailsDTO.setRegStateCode(businessDetails.getRegStateCode());
		if (null != businessDetails.getRegStateDate()) {
			businessDetailsDTO.setRegStateDate(businessDetails.getRegStateDate().format(DateTimeFormatter.ofPattern(Constants.DATE_FORMAT)));
		}
		businessDetailsDTO.setDataCompletionScore(businessDetails.getDataCompletenessScore());
		businessDetailsDTO.setViewCounter(businessDetails.getViewCounter());
		businessDetailsDTO.setIsForSell(businessDetails.getIsForSell());
		businessDetailsDTO.setIsHidden(businessDetails.getIsHidden());
		businessDetailsDTO.setForSellPrice(businessDetails.getForSellPrice());
		businessDetailsDTO.setBrokerFirstName(businessDetails.getBrokerFirstName());
		businessDetailsDTO.setBrokerLastName(businessDetails.getBrokerLastName());
		businessDetailsDTO.setBrokerPhone(businessDetails.getBrokerPhone());
		businessDetailsDTO.setBrokerEmail(businessDetails.getBrokerEmail());
		businessDetailsDTO.setIsPaidListing(businessDetails.getIsPaidListing());
		businessDetailsDTO.setImageLogo(businessDetails.getImageLogo());
		//businessDetailsDTO.setImageFirst(businessDetails.getImageFirst());
		if(null != businessDetails.getImageFirst() || !Constants.EMPTY_STRING.equals(businessDetails.getImageFirst())) {
			//If ImageFirst Exist then pick up Image First
			businessDetailsDTO.setImageFirst(businessDetails.getImageFirst());
		} else {
			try {
				//TODO: Come up with better Solution - Right now we are picking up random image based on the business type
				businessDetailsDTO.setAlternateImageFirst(imageService.getDefaultImageForBizType(businessDetails.getType()));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		logger.info("**** 222 Inside BusinessServiceImpl.getBusinessDetails() businessDetails.getIsHidden(): "+businessDetails.getIsHidden());

		if (businessDetails.getIsHidden().equals(Constants.Y)) {
			
			businessDetailsDTO.setLegalName("Business for Sell in " + businessDetails.getCity() + ", of " + businessDetails.getCounty() + " " + "County" );
			businessDetailsDTO.setName("Business for Sell in " + businessDetails.getCity() + ", of " + businessDetails.getCounty() + " " + "County" );
			
			logger.info("**** 222 Inside BusinessServiceImpl.getBusinessDetails() businessDetailsDTO.getName(): "+businessDetailsDTO.getName());
		} else {
			businessDetailsDTO.setLegalName(businessDetails.getLegalName());
			businessDetailsDTO.setName(businessDetails.getName());
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
		}
		
		//Generate Random Numbers and Use floor function
		Random randNum= new Random(); 
		//int num = randNum.nextInt(10 - 5 + 1) + 5;
		
		int assetBasedEst = businessDetails.getAsset_based_est();
		int abelmax = (int)(assetBasedEst * 0.9);
		int abelmin = (int)(assetBasedEst * 0.8);
		int abehmax = (int)(assetBasedEst * 1.3);
		int abehmin = (int)(assetBasedEst * 1.2);
		
		businessDetailsDTO.setAssetBasedEst(assetBasedEst);
		businessDetailsDTO.setAssetBasedEstLow(randNum.nextInt(abelmax - abelmin + 1) + abelmin);
		businessDetailsDTO.setAssetBasedEstHigh(randNum.nextInt(abehmax - abelmin + 1) + abehmin);

		int incomeBasedEst = businessDetails.getIncome_based_est();
		int ibelmax = (int)(incomeBasedEst * 0.9);
		int ibelmin = (int)(incomeBasedEst * 0.8);
		int ibehmax = (int)(incomeBasedEst * 1.3);
		int ibehmin = (int)(incomeBasedEst * 1.2);
		
		businessDetailsDTO.setIncomeBasedEst(incomeBasedEst);
		businessDetailsDTO.setIncomeBasedEstLow(randNum.nextInt(ibelmax - ibelmin + 1) + ibelmin);
		businessDetailsDTO.setIncomeBasedEstHigh(randNum.nextInt(ibehmax - ibehmin + 1) + ibehmin);

		int marketBasedEst = businessDetails.getMarket_based_est();
		int mbelmax = (int)(marketBasedEst * 0.9);
		int mbelmin = (int)(marketBasedEst * 0.8);
		int mbehmax = (int)(marketBasedEst * 1.3);
		int mbehmin = (int)(marketBasedEst * 1.2);
		
		businessDetailsDTO.setMarketBasedEst(marketBasedEst);
		businessDetailsDTO.setMarketBasedEstLow(randNum.nextInt(mbelmax - mbelmin + 1) + mbelmin);
		businessDetailsDTO.setMarketBasedEstHigh(randNum.nextInt(mbehmax - mbehmin + 1) + mbehmin);
		
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
		logger.info("Elapsed time in GetBusinessDetailsFromBRWDB: " + (System.currentTimeMillis() - start));

		return businessDetailsDTO;
	}
	
	@Override
	public BusinessDetailsDTO addBusinessDetails(BusinessDetailsDTO businessDetailsDTO) {
		long start = System.currentTimeMillis();

		//Log the User Action - START
		UserActivityDTO userActivityDTO = new UserActivityDTO();
		
		if(null == businessDetailsDTO.getInvokerId()) {
			businessDetailsDTO.setInvokerId(1001);
		}
		userActivityDTO.setUserId(businessDetailsDTO.getInvokerId());
		
		if(null == businessDetailsDTO.getBusinessId()) {
			businessDetailsDTO.setBusinessId(1000000);
		}
		userActivityDTO.setBusinessId(businessDetailsDTO.getBusinessId());
		
		userActivityDTO.setType(Constants.CREATE);
		userActivityDTO.setSubType(Constants.BUSINESS);
		try {
			userService.trackUserActivity(userActivityDTO);
		} catch (Exception e) {
			e.printStackTrace();
		}
		//Log the User Action - END
		
		//TODO:TEMPORARY translation of City and State Code - need to fix it on UI and then remove this code
		if(null == businessDetailsDTO.getCity()) {
			businessDetailsDTO.setCity("Fremont");
		}
		
		if(null == businessDetailsDTO.getStateCode()) {
			businessDetailsDTO.setStateCode("CA");
		}
		
		logger.info("222 **** Inside BusinessServiceImpl.addBusinessDetails()");
		
		logger.info("222 **** businessDetailsDTO.getInvokerId(): "+businessDetailsDTO.getInvokerId());
		
		logger.info("222 **** businessDetailsDTO.getBuRelationship(): "+businessDetailsDTO.getBuRelationship());
		
		logger.info("222 **** businessDetailsDTO.getName(): "+businessDetailsDTO.getName());
		
		logger.info("222 **** businessDetailsDTO.getLegalName(): "+businessDetailsDTO.getLegalName());
		
		logger.info("222 **** businessDetailsDTO.getFirstOwnerName(): "+businessDetailsDTO.getFirstOwnerName());

		logger.info("222 **** businessDetailsDTO.getSecondOwnerName(): "+businessDetailsDTO.getSecondOwnerName());

		logger.info("222 **** businessDetailsDTO.getBrandName(): "+businessDetailsDTO.getBrandName());

		logger.info("222 **** businessDetailsDTO.getType(): "+businessDetailsDTO.getType());

		logger.info("222 **** businessDetailsDTO.getSubType(): "+businessDetailsDTO.getSubType());

		logger.info("222 **** businessDetailsDTO.getRegCityName(): "+businessDetailsDTO.getRegCityName());

		logger.info("222 **** businessDetailsDTO.getRegCityCode(): "+businessDetailsDTO.getRegCityCode());

		logger.info("222 **** businessDetailsDTO.getRegCityDate(): "+businessDetailsDTO.getRegCityDate());

		logger.info("222 **** businessDetailsDTO.getRegStateName(): "+businessDetailsDTO.getRegStateName());

		logger.info("222 **** businessDetailsDTO.getRegStateCode(): "+businessDetailsDTO.getRegStateCode());

		logger.info("222 **** businessDetailsDTO.getRegStateDate(): "+businessDetailsDTO.getRegStateDate());

		logger.info("222 **** businessDetailsDTO.getDataCompletionScore(): "+businessDetailsDTO.getDataCompletionScore());

		logger.info("222 **** businessDetailsDTO.getIsForSell(): "+businessDetailsDTO.getIsForSell());
		
		logger.info("222 **** businessDetailsDTO.getIsHidden(): "+businessDetailsDTO.getIsHidden());

		logger.info("222 **** businessDetailsDTO.getForSellPrice(): "+businessDetailsDTO.getForSellPrice());

		logger.info("222 **** businessDetailsDTO.getImageLogo(): "+businessDetailsDTO.getImageLogo());
		
		logger.info("222 **** businessDetailsDTO.getImageFirst(): "+businessDetailsDTO.getImageFirst());

		logger.info("222 **** businessDetailsDTO.getStreet1(): "+businessDetailsDTO.getStreet1());

		logger.info("222 **** businessDetailsDTO.getStreet2(): "+businessDetailsDTO.getStreet2());

		logger.info("222 **** businessDetailsDTO.getCity(): "+businessDetailsDTO.getCity());

		logger.info("222 **** businessDetailsDTO.getCounty(): "+businessDetailsDTO.getCounty());

		logger.info("222 **** businessDetailsDTO.getStateCode(): "+businessDetailsDTO.getStateCode());

		logger.info("222 **** businessDetailsDTO.getZip(): "+businessDetailsDTO.getZip());

		logger.info("222 **** businessDetailsDTO.getLatitude(): "+businessDetailsDTO.getLatitude());

		logger.info("222 **** businessDetailsDTO.getLongitude(): "+businessDetailsDTO.getLongitude());

		logger.info("222 **** businessDetailsDTO.getPhone(): "+businessDetailsDTO.getPhone());

		logger.info("222 **** businessDetailsDTO.getPhoneExt(): "+businessDetailsDTO.getPhoneExt());

		logger.info("222 **** businessDetailsDTO.getEmail(): "+businessDetailsDTO.getEmail());

		logger.info("222 **** businessDetailsDTO.getWebsite(): "+businessDetailsDTO.getWebsite());

		logger.info("222 **** businessDetailsDTO.getDescription(): "+businessDetailsDTO.getDescription());

		logger.info("222 **** businessDetailsDTO.getNAICSNum(): "+businessDetailsDTO.getNAICSNum());

		logger.info("222 **** businessDetailsDTO.getNAICSDescription(): "+businessDetailsDTO.getNAICSDescription());

		logger.info("222 **** businessDetailsDTO.getIsFranchise(): "+businessDetailsDTO.getIsFranchise());

		logger.info("222 **** businessDetailsDTO.getIsOwnerClaimed(): "+businessDetailsDTO.getIsOwnerClaimed());

		logger.info("222 **** businessDetailsDTO.getSqftOutdoor(): "+businessDetailsDTO.getSqftOutdoor());

		logger.info("222 **** businessDetailsDTO.getBuildingType(): "+businessDetailsDTO.getBuildingType());

		logger.info("222 **** businessDetailsDTO.getIsBuildingOwned(): "+businessDetailsDTO.getIsBuildingOwned());

		logger.info("222 **** businessDetailsDTO.getRevenueMonthly(): "+businessDetailsDTO.getRevenueMonthly());
		
		logger.info("222 **** businessDetailsDTO.getExpenseMonthlyRent(): "+businessDetailsDTO.getExpenseMonthlyRent());

		logger.info("222 **** businessDetailsDTO.getExpenseMonthlyMortgage(): "+businessDetailsDTO.getExpenseMonthlyMortgage());

		logger.info("222 **** businessDetailsDTO.getExpenseMonthlyMaterial(): "+businessDetailsDTO.getExpenseMonthlyMaterial());

		logger.info("222 **** businessDetailsDTO.getExpenseMonthlyEmp(): "+businessDetailsDTO.getExpenseMonthlyEmp());

		logger.info("222 **** businessDetailsDTO.getExpenseMonthlyUtility(): "+businessDetailsDTO.getExpenseMonthlyUtility());

		logger.info("222 **** businessDetailsDTO.getExpenseMonthlyOther(): "+businessDetailsDTO.getExpenseMonthlyOther());

		logger.info("222 **** businessDetailsDTO.getValueTotalEquipment(): "+businessDetailsDTO.getValueTotalEquipment());

		logger.info("222 **** businessDetailsDTO.getValueTotalFurniture(): "+businessDetailsDTO.getValueTotalFurniture());

		logger.info("222 **** businessDetailsDTO.getValueIndoorDeco(): "+businessDetailsDTO.getValueIndoorDeco());

		logger.info("222 **** businessDetailsDTO.getValueOutdoorDeco(): "+businessDetailsDTO.getValueOutdoorDeco());

		logger.info("222 **** businessDetailsDTO.getYearEquipment(): "+businessDetailsDTO.getYearEquipment());

		logger.info("222 **** businessDetailsDTO.getYearFurniture(): "+businessDetailsDTO.getYearFurniture());

		logger.info("222 **** businessDetailsDTO.getYearIndoorDeco(): "+businessDetailsDTO.getYearIndoorDeco());

		logger.info("222 **** businessDetailsDTO.getYearOutdoorDeco(): "+businessDetailsDTO.getYearOutdoorDeco());

		logger.info("222 **** businessDetailsDTO.getEmpFullTimeNum(): "+businessDetailsDTO.getEmpFullTimeNum());

		logger.info("222 **** businessDetailsDTO.getEmpPartTimeNum(): "+businessDetailsDTO.getEmpPartTimeNum());

		logger.info("222 **** businessDetailsDTO.getAreaCrimeScore(): "+businessDetailsDTO.getAreaCrimeScore());

		logger.info("222 **** businessDetailsDTO.getAreaWalkScore(): "+businessDetailsDTO.getAreaWalkScore());

		logger.info("222 **** businessDetailsDTO.getAreaAttractionsScore(): "+businessDetailsDTO.getAreaAttractionsScore());

		logger.info("222 **** businessDetailsDTO.getAreaTransitScore(): "+businessDetailsDTO.getAreaTransitScore());
		
		logger.info("222 **** businessDetailsDTO.getSocialMediaScore(): "+businessDetailsDTO.getSocialMediaScore());

		logger.info("222 **** businessDetailsDTO.getPopulationIn1mileRadius(): "+businessDetailsDTO.getPopulationIn1mileRadius());

		logger.info("222 **** businessDetailsDTO.getIncomeScoreIn1mileRadius(): "+businessDetailsDTO.getIncomeScoreIn1mileRadius());

		logger.info("222 **** businessDetailsDTO.getPopulationIn3mileRadius(): "+businessDetailsDTO.getPopulationIn3mileRadius());

		logger.info("222 **** businessDetailsDTO.getIncomeScoreIn3mileRadius(): "+businessDetailsDTO.getIncomeScoreIn3mileRadius());

		logger.info("222 **** businessDetailsDTO.getPopulationIn5mileRadius(): "+businessDetailsDTO.getPopulationIn5mileRadius());

		logger.info("222 **** businessDetailsDTO.getIncomeScoreIn5mileRadius(): "+businessDetailsDTO.getIncomeScoreIn5mileRadius());

		logger.info("222 **** businessDetailsDTO.getDailyPeoplAtDoorNum(): "+businessDetailsDTO.getDailyPeoplAtDoorNum());

		logger.info("222 **** businessDetailsDTO.getDailyCarsAtParklotNum(): "+businessDetailsDTO.getDailyCarsAtParklotNum());

		logger.info("222 **** businessDetailsDTO.getYearEstablished(): "+businessDetailsDTO.getYearEstablished());
		
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
		if (null != businessDetailsDTO.getRegCityDate() && !Constants.EMPTY_STRING.equals(businessDetailsDTO.getRegCityDate())) {
			businessDetails.setRegCityDate(LocalDateTime.parse(businessDetailsDTO.getRegCityDate(), DateTimeFormatter.ofPattern(Constants.DATE_FORMAT)));
		}
		businessDetails.setRegStateName(businessDetailsDTO.getRegStateName());
		businessDetails.setRegStateCode(businessDetailsDTO.getRegStateCode());
		if (null != businessDetailsDTO.getRegStateDate() && !Constants.EMPTY_STRING.equals(businessDetailsDTO.getRegStateDate())) {
			businessDetails.setRegStateDate(LocalDateTime.parse(businessDetailsDTO.getRegStateDate(), DateTimeFormatter.ofPattern(Constants.DATE_FORMAT)));
		}
		if (null != businessDetailsDTO.getDataCompletionScore()) {
			businessDetails.setDataCompletenessScore(businessDetailsDTO.getDataCompletionScore());
		} else {
			businessDetails.setDataCompletenessScore(0);
		}
		businessDetails.setIsForSell(businessDetailsDTO.getIsForSell());
		businessDetails.setIsHidden(businessDetailsDTO.getIsHidden());
		businessDetails.setForSellPrice(businessDetailsDTO.getForSellPrice());
		businessDetails.setImageLogo(businessDetailsDTO.getImageLogo());
		businessDetails.setImageFirst(Constants.IMAGE_FIRST);
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
		if (null != businessDetailsDTO.getNAICSNum()) {
			businessDetails.setNAICSNum(businessDetailsDTO.getNAICSNum());
		} else {
			businessDetails.setNAICSNum(0);
		}
		businessDetails.setNAICSDescription(businessDetailsDTO.getNAICSDescription());
		businessDetails.setIsFranchise(businessDetailsDTO.getIsFranchise());
		businessDetails.setIsOwnerClaimed(businessDetailsDTO.getIsOwnerClaimed());
		if (null != businessDetailsDTO.getNAICSNum()) {
			businessDetails.setNAICSNum(businessDetailsDTO.getNAICSNum());
		} else {
			businessDetails.setNAICSNum(0);
		}
		if (null != businessDetailsDTO.getSqftOutdoor()) {
			businessDetails.setSqftOutdoor(businessDetailsDTO.getSqftOutdoor());
		} else {
			businessDetails.setSqftOutdoor(0);
		}
		if (null != businessDetailsDTO.getSqftLot()) {
			businessDetails.setSqftLot(businessDetailsDTO.getSqftLot());
		} else {
			businessDetails.setSqftLot(0);
		}
		businessDetails.setBuildingType(businessDetailsDTO.getBuildingType());
		businessDetails.setIsBuildingOwned(businessDetailsDTO.getIsBuildingOwned());
		if (null != businessDetailsDTO.getRevenueMonthly()) {
			businessDetails.setRevenueMonthly(businessDetailsDTO.getRevenueMonthly());
		} else {
			businessDetails.setRevenueMonthly(0);
		}
		if (null != businessDetailsDTO.getExpenseMonthlyRent()) {
			businessDetails.setExpenseMonthlyRent(businessDetailsDTO.getExpenseMonthlyRent());
		} else {
			businessDetails.setExpenseMonthlyRent(0);
		}
		if (null != businessDetailsDTO.getExpenseMonthlyMortgage()) {
			businessDetails.setExpenseMonthlyMortgage(businessDetailsDTO.getExpenseMonthlyMortgage());
		} else {
			businessDetails.setExpenseMonthlyMortgage(0);
		}
		if (null != businessDetailsDTO.getExpenseMonthlyMaterial()) {
			businessDetails.setExpenseMonthlyMaterial(businessDetailsDTO.getExpenseMonthlyMaterial());
		} else {
			businessDetails.setExpenseMonthlyMaterial(0);
		}
		if (null != businessDetailsDTO.getExpenseMonthlyEmp()) {
			businessDetails.setExpenseMonthlyEmp(businessDetailsDTO.getExpenseMonthlyEmp());
		} else {
			businessDetails.setExpenseMonthlyEmp(0);
		}
		if (null != businessDetailsDTO.getExpenseMonthlyUtility()) {
			businessDetails.setExpenseMonthlyUtility(businessDetailsDTO.getExpenseMonthlyUtility());
		} else {
			businessDetails.setExpenseMonthlyUtility(0);
		}
		if (null != businessDetailsDTO.getExpenseMonthlyOther()) {
			businessDetails.setExpenseMonthlyOther(businessDetailsDTO.getExpenseMonthlyOther());
		} else {
			businessDetails.setExpenseMonthlyOther(0);
		}
		if (null != businessDetailsDTO.getValueTotalEquipment()) {
			businessDetails.setValueTotalEquipment(businessDetailsDTO.getValueTotalEquipment());
		} else {
			businessDetails.setValueTotalEquipment(0);
		}
		if (null != businessDetailsDTO.getValueTotalFurniture()) {
			businessDetails.setValueTotalFurniture(businessDetailsDTO.getValueTotalFurniture());
		} else {
			businessDetails.setValueTotalFurniture(0);
		}
		if (null != businessDetailsDTO.getValueIndoorDeco()) {
			businessDetails.setValueIndoorDeco(businessDetailsDTO.getValueIndoorDeco());
		} else {
			businessDetails.setValueIndoorDeco(0);
		}
		//businessDetails.setValueOutdoorDeco(businessDetailsDTO.getValueOutdoorDeco());
		if (null != businessDetailsDTO.getValueOutdoorDeco()) {
			businessDetails.setValueOutdoorDeco(businessDetailsDTO.getValueOutdoorDeco());
		} else {
			businessDetails.setValueOutdoorDeco(0);
		}
		//businessDetails.setYearEquipment(businessDetailsDTO.getYearEquipment());
		if (null != businessDetailsDTO.getYearEquipment()) {
			businessDetails.setYearEquipment(businessDetailsDTO.getYearEquipment());
		} else {
			businessDetails.setYearEquipment(0);
		}
		//businessDetails.setYearFurniture(businessDetailsDTO.getYearFurniture());
		if (null != businessDetailsDTO.getYearFurniture()) {
			businessDetails.setYearFurniture(businessDetailsDTO.getYearFurniture());
		} else {
			businessDetails.setYearFurniture(0);
		}
		//businessDetails.setYearIndoorDeco(businessDetailsDTO.getYearIndoorDeco());
		if (null != businessDetailsDTO.getYearIndoorDeco()) {
			businessDetails.setYearIndoorDeco(businessDetailsDTO.getYearIndoorDeco());
		} else {
			businessDetails.setYearIndoorDeco(0);
		}
		//businessDetails.setYearOutdoorDeco(businessDetailsDTO.getYearOutdoorDeco());
		if (null != businessDetailsDTO.getYearOutdoorDeco()) {
			businessDetails.setYearOutdoorDeco(businessDetailsDTO.getYearOutdoorDeco());
		} else {
			businessDetails.setYearOutdoorDeco(0);
		}
		//businessDetails.setEmpFullTimeNum(businessDetailsDTO.getEmpFullTimeNum());
		if (null != businessDetailsDTO.getEmpFullTimeNum()) {
			businessDetails.setEmpFullTimeNum(businessDetailsDTO.getEmpFullTimeNum());
		} else {
			businessDetails.setEmpFullTimeNum(0);
		}
		//businessDetails.setEmpPartTimeNum(businessDetailsDTO.getEmpPartTimeNum());
		if (null != businessDetailsDTO.getEmpPartTimeNum()) {
			businessDetails.setEmpPartTimeNum(businessDetailsDTO.getEmpPartTimeNum());
		} else {
			businessDetails.setEmpPartTimeNum(0);
		}
		//businessDetails.setAreaCrimeScore(businessDetailsDTO.getAreaCrimeScore());
		if (null != businessDetailsDTO.getAreaCrimeScore()) {
			businessDetails.setAreaCrimeScore(businessDetailsDTO.getAreaCrimeScore());
		} else {
			businessDetails.setAreaCrimeScore(0);
		}
		//businessDetails.setAreaWalkScore(businessDetailsDTO.getAreaWalkScore());
		if (null != businessDetailsDTO.getAreaWalkScore()) {
			businessDetails.setAreaWalkScore(businessDetailsDTO.getAreaWalkScore());
		} else {
			businessDetails.setAreaWalkScore(0);
		}
		//businessDetails.setAreaAttractionsScore(businessDetailsDTO.getAreaAttractionsScore());
		if (null != businessDetailsDTO.getAreaAttractionsScore()) {
			businessDetails.setAreaAttractionsScore(businessDetailsDTO.getAreaAttractionsScore());
		} else {
			businessDetails.setAreaAttractionsScore(0);
		}
		//businessDetails.setAreaTransitScore(businessDetailsDTO.getAreaTransitScore());
		if (null != businessDetailsDTO.getAreaTransitScore()) {
			businessDetails.setAreaTransitScore(businessDetailsDTO.getAreaTransitScore());
		} else {
			businessDetails.setAreaTransitScore(0);
		}
		//businessDetails.setSocialMediaScore(businessDetailsDTO.getSocialMediaScore());
		if (null != businessDetailsDTO.getSocialMediaScore()) {
			businessDetails.setSocialMediaScore(businessDetailsDTO.getSocialMediaScore());
		} else {
			businessDetails.setSocialMediaScore(0);
		}
		//businessDetails.setPopulationIn1mileRadius(businessDetailsDTO.getPopulationIn1mileRadius());
		if (null != businessDetailsDTO.getPopulationIn1mileRadius()) {
			businessDetails.setPopulationIn1mileRadius(businessDetailsDTO.getPopulationIn1mileRadius());
		} else {
			businessDetails.setPopulationIn1mileRadius(0);
		}
		//businessDetails.setIncomeScoreIn1mileRadius(businessDetailsDTO.getIncomeScoreIn1mileRadius());
		if (null != businessDetailsDTO.getIncomeScoreIn1mileRadius()) {
			businessDetails.setIncomeScoreIn1mileRadius(businessDetailsDTO.getIncomeScoreIn1mileRadius());
		} else {
			businessDetails.setIncomeScoreIn1mileRadius(0);
		}
		//businessDetails.setPopulationIn3mileRadius(businessDetailsDTO.getPopulationIn3mileRadius());
		if (null != businessDetailsDTO.getPopulationIn3mileRadius()) {
			businessDetails.setPopulationIn3mileRadius(businessDetailsDTO.getPopulationIn3mileRadius());
		} else {
			businessDetails.setPopulationIn3mileRadius(0);
		}
		//businessDetails.setIncomeScoreIn3mileRadius(businessDetailsDTO.getIncomeScoreIn3mileRadius());
		if (null != businessDetailsDTO.getIncomeScoreIn3mileRadius()) {
			businessDetails.setIncomeScoreIn3mileRadius(businessDetailsDTO.getIncomeScoreIn3mileRadius());
		} else {
			businessDetails.setIncomeScoreIn3mileRadius(0);
		}
		//businessDetails.setPopulationIn5mileRadius(businessDetailsDTO.getPopulationIn5mileRadius());
		if (null != businessDetailsDTO.getPopulationIn5mileRadius()) {
			businessDetails.setPopulationIn5mileRadius(businessDetailsDTO.getPopulationIn5mileRadius());
		} else {
			businessDetails.setPopulationIn5mileRadius(0);
		}
		//businessDetails.setIncomeScoreIn5mileRadius(businessDetailsDTO.getIncomeScoreIn5mileRadius());
		if (null != businessDetailsDTO.getIncomeScoreIn5mileRadius()) {
			businessDetails.setIncomeScoreIn5mileRadius(businessDetailsDTO.getIncomeScoreIn5mileRadius());
		} else {
			businessDetails.setIncomeScoreIn5mileRadius(0);
		}
		//businessDetails.setDailyPeoplAtDoorNum(businessDetailsDTO.getDailyPeoplAtDoorNum());
		if (null != businessDetailsDTO.getDailyPeoplAtDoorNum()) {
			businessDetails.setDailyPeoplAtDoorNum(businessDetailsDTO.getDailyPeoplAtDoorNum());
		} else {
			businessDetails.setDailyPeoplAtDoorNum(0);
		}
		//businessDetails.setDailyCarsAtParklotNum(businessDetailsDTO.getDailyCarsAtParklotNum());
		if (null != businessDetailsDTO.getDailyCarsAtParklotNum()) {
			businessDetails.setDailyCarsAtParklotNum(businessDetailsDTO.getDailyCarsAtParklotNum());
		} else {
			businessDetails.setDailyCarsAtParklotNum(0);
		}
		businessDetails.setYearEstablished(businessDetailsDTO.getYearEstablished());
		businessDetails.setCreatedByUserId(businessDetailsDTO.getInvokerId());
		businessDetails.setCreateDate(LocalDateTime.now());
		businessDetails.setUpdatedByUserId(businessDetailsDTO.getInvokerId());
		businessDetails.setUpdateDate(LocalDateTime.now());
		
		//Add Business to t_brw_business table
		BusinessDetails business = businessDetailsDAO.save(businessDetails);
		
		BusinessDetailsDTO bizDTO = new BusinessDetailsDTO();
		bizDTO.setBusinessId(business.getBusinessId());
		bizDTO.setLegalName(business.getLegalName());
		bizDTO.setType(business.getType());
		
		//BusinessDetails businessDetails = new BusinessDetails();
		bizDTO.setLegalName(business.getLegalName());
		bizDTO.setName(business.getName());
		bizDTO.setFirstOwnerName(business.getFirstOwnerName());
		bizDTO.setSecondOwnerName(business.getSecondOwnerName());
		bizDTO.setBrandName(business.getBrandName());
		bizDTO.setType(business.getType());
		bizDTO.setSubType(business.getSubType());
		bizDTO.setRegCityName(business.getRegCityName());
		bizDTO.setRegCityCode(business.getRegCityCode());
		if (null != business.getRegCityDate()) {
			bizDTO.setRegCityDate(business.getRegCityDate().toString());
		}
		bizDTO.setRegStateName(business.getRegStateName());
		bizDTO.setRegStateCode(business.getRegStateCode());
		if (null != business.getRegStateDate()) {
			bizDTO.setRegStateDate(business.getRegStateDate().toString());
		}
		bizDTO.setDataCompletionScore(business.getDataCompletenessScore());
		bizDTO.setIsForSell(business.getIsForSell());
		bizDTO.setIsHidden(business.getIsHidden());
		bizDTO.setForSellPrice(business.getForSellPrice());
		bizDTO.setImageLogo(business.getImageLogo());
		bizDTO.setImageFirst(business.getImageFirst());
		bizDTO.setStreet1(business.getStreet1());
		bizDTO.setStreet2(business.getStreet2());
		bizDTO.setCity(business.getCity());
		bizDTO.setCounty(business.getCounty());
		bizDTO.setStateCode(business.getStateCode());
		bizDTO.setZip(business.getZip());	
		bizDTO.setLatitude(business.getLatitude());
		bizDTO.setLongitude(business.getLongitude());
		bizDTO.setPhone(business.getPhoneNumber());
		bizDTO.setPhoneExt(business.getPhoneExtentionNumber());
		bizDTO.setEmail(business.getEmail());
		bizDTO.setWebsite(business.getWebsite());
		bizDTO.setDescription(business.getFreeformDescription());
		bizDTO.setNAICSNum(business.getNAICSNum());
		bizDTO.setNAICSDescription(business.getNAICSDescription());
		bizDTO.setIsFranchise(business.getIsFranchise());
		bizDTO.setIsOwnerClaimed(business.getIsOwnerClaimed());
		bizDTO.setSqftIndoor(business.getSqftIndoor());
		bizDTO.setSqftOutdoor(business.getSqftOutdoor());
		bizDTO.setSqftLot(business.getSqftLot());
		bizDTO.setBuildingType(business.getBuildingType());
		bizDTO.setIsBuildingOwned(business.getIsBuildingOwned());
		bizDTO.setRevenueMonthly(business.getRevenueMonthly());
		bizDTO.setExpenseMonthlyRent(business.getExpenseMonthlyRent());
		bizDTO.setExpenseMonthlyMortgage(business.getExpenseMonthlyMortgage());
		bizDTO.setExpenseMonthlyMaterial(business.getExpenseMonthlyMaterial());
		bizDTO.setExpenseMonthlyEmp(business.getExpenseMonthlyEmp());
		bizDTO.setExpenseMonthlyUtility(business.getExpenseMonthlyUtility());
		bizDTO.setExpenseMonthlyOther(business.getExpenseMonthlyOther());
		bizDTO.setValueTotalEquipment(business.getValueTotalEquipment());
		bizDTO.setValueTotalFurniture(business.getValueTotalFurniture());
		bizDTO.setValueIndoorDeco(business.getValueIndoorDeco());
		bizDTO.setValueOutdoorDeco(business.getValueOutdoorDeco());
		bizDTO.setYearEquipment(business.getYearEquipment());
		bizDTO.setYearFurniture(business.getYearFurniture());
		bizDTO.setYearIndoorDeco(business.getYearIndoorDeco());
		bizDTO.setYearOutdoorDeco(business.getYearOutdoorDeco());
		bizDTO.setEmpFullTimeNum(business.getEmpFullTimeNum());
		bizDTO.setEmpPartTimeNum(business.getEmpPartTimeNum());
		bizDTO.setAreaCrimeScore(business.getAreaCrimeScore());
		bizDTO.setAreaWalkScore(business.getAreaWalkScore());
		bizDTO.setAreaAttractionsScore(business.getAreaAttractionsScore());
		bizDTO.setAreaTransitScore(business.getAreaTransitScore());
		bizDTO.setSocialMediaScore(business.getSocialMediaScore());
		bizDTO.setPopulationIn1mileRadius(business.getPopulationIn1mileRadius());
		bizDTO.setIncomeScoreIn1mileRadius(business.getIncomeScoreIn1mileRadius());
		bizDTO.setPopulationIn3mileRadius(business.getPopulationIn3mileRadius());
		bizDTO.setIncomeScoreIn3mileRadius(business.getIncomeScoreIn3mileRadius());
		bizDTO.setPopulationIn5mileRadius(business.getPopulationIn5mileRadius());
		bizDTO.setIncomeScoreIn5mileRadius(business.getIncomeScoreIn5mileRadius());
		bizDTO.setDailyPeoplAtDoorNum(business.getDailyPeoplAtDoorNum());
		bizDTO.setDailyCarsAtParklotNum(business.getDailyCarsAtParklotNum());
		bizDTO.setYearEstablished(business.getYearEstablished());
		bizDTO.setCreatedByUserId(business.getCreatedByUserId());
		bizDTO.setCreateDate(business.getCreateDate().format(DateTimeFormatter.ofPattern(Constants.DATE_FORMAT)));
		bizDTO.setUpdatedByUserId(business.getUpdatedByUserId());
		bizDTO.setUpdateDate(business.getUpdateDate().format(DateTimeFormatter.ofPattern(Constants.DATE_FORMAT)));
		
		//Add Business and User relationship in t_brw_user_business table
		addUserBusiness(bizDTO, businessDetailsDTO.getBuRelationship());
		
		logger.info("Elapsed time in AddBusinessDetails: " + (System.currentTimeMillis() - start));

		return bizDTO;
	}
	
	@Override
	public BusinessDetailsDTO updateBusinessDetails(BusinessDetailsDTO businessDetailsDTO) {
		long start = System.currentTimeMillis();

		logger.info("222 **** Inside BusinessServiceImpl.updateBusinessDetails() businessDetailsDTO.getBusinessId(): "+businessDetailsDTO.getBusinessId());
		logger.info("222 **** Inside BusinessServiceImpl.updateBusinessDetails() businessDetailsDTO.getLegalName(): "+businessDetailsDTO.getLegalName());

		BusinessDetails businessDetails = businessDetailsDAO.findById(businessDetailsDTO.getBusinessId()).get();
		//BusinessDetails businessDetails = new BusinessDetails();
		if (null != businessDetailsDTO.getLegalName() && businessDetailsDTO.getLegalName() != Constants.EMPTY_STRING) {
			businessDetails.setLegalName(businessDetailsDTO.getLegalName());
		}
		
		if (null != businessDetailsDTO.getName() && businessDetailsDTO.getName() != Constants.EMPTY_STRING) {
			businessDetails.setName(businessDetailsDTO.getName());
		}
		
		if (null != businessDetailsDTO.getFirstOwnerName() && businessDetailsDTO.getFirstOwnerName() != Constants.EMPTY_STRING) {
			businessDetails.setFirstOwnerName(businessDetailsDTO.getFirstOwnerName());
		}
		
		if (null != businessDetailsDTO.getSecondOwnerName() && businessDetailsDTO.getSecondOwnerName() != Constants.EMPTY_STRING) {
			businessDetails.setSecondOwnerName(businessDetailsDTO.getSecondOwnerName());
		}
		
		if (null != businessDetailsDTO.getBrandName() && businessDetailsDTO.getBrandName() != Constants.EMPTY_STRING) {
			businessDetails.setBrandName(businessDetailsDTO.getBrandName());
		}
		
		if (null != businessDetailsDTO.getType() && businessDetailsDTO.getType() != Constants.EMPTY_STRING) {
			businessDetails.setType(businessDetailsDTO.getType());
		}
		
		if (null != businessDetailsDTO.getSubType() && businessDetailsDTO.getSubType() != Constants.EMPTY_STRING) {
			businessDetails.setSubType(businessDetailsDTO.getSubType());
		}
		
		if (null != businessDetailsDTO.getRegCityName() && businessDetailsDTO.getRegCityName() != Constants.EMPTY_STRING) {
			businessDetails.setRegCityName(businessDetailsDTO.getRegCityName());
		}
		
		if (null != businessDetailsDTO.getRegCityCode() && businessDetailsDTO.getRegCityCode() != Constants.EMPTY_STRING) {
			businessDetails.setRegCityCode(businessDetailsDTO.getRegCityCode());
		}
		
		if (null != businessDetailsDTO.getRegCityDate()) {
			businessDetails.setRegCityDate(LocalDateTime.parse(businessDetailsDTO.getRegCityDate(), DateTimeFormatter.ofPattern(Constants.DATE_FORMAT)));
		}
		
		if (null != businessDetailsDTO.getRegStateName() && businessDetailsDTO.getRegCityCode() != Constants.EMPTY_STRING) {
			businessDetails.setRegStateName(businessDetailsDTO.getRegStateName());
		}
		
		if (null != businessDetailsDTO.getRegStateCode() && businessDetailsDTO.getRegCityCode() != Constants.EMPTY_STRING) {
			businessDetails.setRegStateCode(businessDetailsDTO.getRegStateCode());
		}
		
		if (null != businessDetailsDTO.getRegStateDate()) {
			businessDetails.setRegStateDate(LocalDateTime.parse(businessDetailsDTO.getRegStateDate(), DateTimeFormatter.ofPattern(Constants.DATE_FORMAT)));
		}
		
		if (null != businessDetailsDTO.getDataCompletionScore()) {
			businessDetails.setDataCompletenessScore(businessDetailsDTO.getDataCompletionScore());
		}
		
		if (null != businessDetailsDTO.getIsForSell() && businessDetailsDTO.getIsForSell() != Constants.EMPTY_STRING) {
			businessDetails.setIsForSell(businessDetailsDTO.getIsForSell());
		}
		
		if (null != businessDetailsDTO.getIsHidden() && businessDetailsDTO.getIsHidden() != Constants.EMPTY_STRING) {
			businessDetails.setIsHidden(businessDetailsDTO.getIsHidden());
		}
		
		if (null != businessDetailsDTO.getForSellPrice()) {
			businessDetails.setForSellPrice(businessDetailsDTO.getForSellPrice());
		}
		
		if (null != businessDetailsDTO.getImageLogo() && businessDetailsDTO.getImageLogo() != Constants.EMPTY_STRING) {
			businessDetails.setImageLogo(businessDetailsDTO.getImageLogo());
		}
		
		if (null != businessDetailsDTO.getImageFirst() && businessDetailsDTO.getImageFirst() != Constants.EMPTY_STRING) {
			businessDetails.setImageFirst(businessDetailsDTO.getImageFirst());
		}
		
		if (null != businessDetailsDTO.getStreet1() && businessDetailsDTO.getStreet1() != Constants.EMPTY_STRING) {
			businessDetails.setStreet1(businessDetailsDTO.getStreet1());
		}
		
		if (null != businessDetailsDTO.getStreet2() && businessDetailsDTO.getStreet2() != Constants.EMPTY_STRING) {
			businessDetails.setStreet2(businessDetailsDTO.getStreet2());
		}
		
		if (null != businessDetailsDTO.getCity() && businessDetailsDTO.getCity() != Constants.EMPTY_STRING) {
			businessDetails.setCity(businessDetailsDTO.getCity());
		}
		
		if (null != businessDetailsDTO.getCounty() && businessDetailsDTO.getCounty() != Constants.EMPTY_STRING) {
			businessDetails.setCounty(businessDetailsDTO.getCounty());
		}
		
		if (null != businessDetailsDTO.getStateCode() && businessDetailsDTO.getStateCode() != Constants.EMPTY_STRING) {
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
		
		if (null != businessDetailsDTO.getPhone() && businessDetailsDTO.getPhone() != Constants.EMPTY_STRING) {
			businessDetails.setPhoneNumber(businessDetailsDTO.getPhone());
		}
		
		if (null != businessDetailsDTO.getPhoneExt() && businessDetailsDTO.getPhoneExt() != Constants.EMPTY_STRING) {
			businessDetails.setPhoneExtentionNumber(businessDetailsDTO.getPhoneExt());
		}
		
		if (null != businessDetailsDTO.getEmail() && businessDetailsDTO.getEmail() != Constants.EMPTY_STRING) {
			businessDetails.setEmail(businessDetailsDTO.getEmail());
		}
		
		if (null != businessDetailsDTO.getWebsite() && businessDetailsDTO.getWebsite() != Constants.EMPTY_STRING) {
			businessDetails.setWebsite(businessDetailsDTO.getWebsite());
		}
		
		if (null != businessDetailsDTO.getDescription() && businessDetailsDTO.getDescription() != Constants.EMPTY_STRING) {
			businessDetails.setFreeformDescription(businessDetailsDTO.getDescription());
		}
		
		if (null != businessDetailsDTO.getNAICSNum()) {
			businessDetails.setNAICSNum(businessDetailsDTO.getNAICSNum());
		}
		
		if (null != businessDetailsDTO.getNAICSDescription() && businessDetailsDTO.getNAICSDescription() != Constants.EMPTY_STRING) {
			businessDetails.setNAICSDescription(businessDetailsDTO.getNAICSDescription());
		}
		
		if (null != businessDetailsDTO.getIsFranchise() && businessDetailsDTO.getIsFranchise() != Constants.EMPTY_STRING) {
			businessDetails.setIsFranchise(businessDetailsDTO.getIsFranchise());
		}
		
		if (null != businessDetailsDTO.getIsOwnerClaimed() && businessDetailsDTO.getIsOwnerClaimed() != Constants.EMPTY_STRING) {
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
		
		if (null != businessDetailsDTO.getBuildingType() && businessDetailsDTO.getBuildingType() != Constants.EMPTY_STRING) {
			businessDetails.setBuildingType(businessDetailsDTO.getBuildingType());
		}
		
		if (null != businessDetailsDTO.getIsBuildingOwned() && businessDetailsDTO.getIsBuildingOwned() != Constants.EMPTY_STRING) {
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
		
		businessDetails.setUpdatedByUserId(businessDetailsDTO.getInvokerId());
		businessDetails.setUpdateDate(LocalDateTime.now());
		
		BusinessDetails business = businessDetailsDAO.save(businessDetails);
		
		BusinessDetailsDTO bizDTO = new BusinessDetailsDTO();
		bizDTO.setBusinessId(business.getBusinessId());
		bizDTO.setLegalName(business.getLegalName());
		bizDTO.setType(business.getType());
		
		//BusinessDetails businessDetails = new BusinessDetails();
		bizDTO.setLegalName(business.getLegalName());
		bizDTO.setName(business.getName());
		bizDTO.setFirstOwnerName(business.getFirstOwnerName());
		bizDTO.setSecondOwnerName(business.getSecondOwnerName());
		bizDTO.setBrandName(business.getBrandName());
		bizDTO.setType(business.getType());
		bizDTO.setSubType(business.getSubType());
		bizDTO.setRegCityName(business.getRegCityName());
		bizDTO.setRegCityCode(business.getRegCityCode());
		if(null != business.getRegCityDate()) {
			bizDTO.setRegCityDate(business.getRegCityDate().format(DateTimeFormatter.ofPattern(Constants.DATE_FORMAT)));
		}
		bizDTO.setRegStateName(business.getRegStateName());
		bizDTO.setRegStateCode(business.getRegStateCode());
		if(null != business.getRegStateDate()) {
			bizDTO.setRegStateDate(business.getRegStateDate().format(DateTimeFormatter.ofPattern(Constants.DATE_FORMAT)));
		}
		bizDTO.setDataCompletionScore(business.getDataCompletenessScore());
		bizDTO.setIsForSell(business.getIsForSell());
		bizDTO.setIsHidden(business.getIsHidden());
		bizDTO.setForSellPrice(business.getForSellPrice());
		bizDTO.setImageLogo(business.getImageLogo());
		bizDTO.setImageFirst(business.getImageFirst());
		bizDTO.setStreet1(business.getStreet1());
		bizDTO.setStreet2(business.getStreet2());
		bizDTO.setCity(business.getCity());
		bizDTO.setCounty(business.getCounty());
		bizDTO.setStateCode(business.getStateCode());
		bizDTO.setZip(business.getZip());	
		bizDTO.setLatitude(business.getLatitude());
		bizDTO.setLongitude(business.getLongitude());
		bizDTO.setPhone(business.getPhoneNumber());
		bizDTO.setPhoneExt(business.getPhoneExtentionNumber());
		bizDTO.setEmail(business.getEmail());
		bizDTO.setWebsite(business.getWebsite());
		bizDTO.setDescription(business.getFreeformDescription());
		bizDTO.setNAICSNum(business.getNAICSNum());
		bizDTO.setNAICSDescription(business.getNAICSDescription());
		bizDTO.setIsFranchise(business.getIsFranchise());
		bizDTO.setIsOwnerClaimed(business.getIsOwnerClaimed());
		bizDTO.setSqftIndoor(business.getSqftIndoor());
		bizDTO.setSqftOutdoor(business.getSqftOutdoor());
		bizDTO.setSqftLot(business.getSqftLot());
		bizDTO.setBuildingType(business.getBuildingType());
		bizDTO.setIsBuildingOwned(business.getIsBuildingOwned());
		bizDTO.setRevenueMonthly(business.getRevenueMonthly());
		bizDTO.setExpenseMonthlyRent(business.getExpenseMonthlyRent());
		bizDTO.setExpenseMonthlyMortgage(business.getExpenseMonthlyMortgage());
		bizDTO.setExpenseMonthlyMaterial(business.getExpenseMonthlyMaterial());
		bizDTO.setExpenseMonthlyEmp(business.getExpenseMonthlyEmp());
		bizDTO.setExpenseMonthlyUtility(business.getExpenseMonthlyUtility());
		bizDTO.setExpenseMonthlyOther(business.getExpenseMonthlyOther());
		bizDTO.setValueTotalEquipment(business.getValueTotalEquipment());
		bizDTO.setValueTotalFurniture(business.getValueTotalFurniture());
		bizDTO.setValueIndoorDeco(business.getValueIndoorDeco());
		bizDTO.setValueOutdoorDeco(business.getValueOutdoorDeco());
		bizDTO.setYearEquipment(business.getYearEquipment());
		bizDTO.setYearFurniture(business.getYearFurniture());
		bizDTO.setYearIndoorDeco(business.getYearIndoorDeco());
		bizDTO.setYearOutdoorDeco(business.getYearOutdoorDeco());
		bizDTO.setEmpFullTimeNum(business.getEmpFullTimeNum());
		bizDTO.setEmpPartTimeNum(business.getEmpPartTimeNum());
		bizDTO.setAreaCrimeScore(business.getAreaCrimeScore());
		bizDTO.setAreaWalkScore(business.getAreaWalkScore());
		bizDTO.setAreaAttractionsScore(business.getAreaAttractionsScore());
		bizDTO.setAreaTransitScore(business.getAreaTransitScore());
		bizDTO.setSocialMediaScore(business.getSocialMediaScore());
		bizDTO.setPopulationIn1mileRadius(business.getPopulationIn1mileRadius());
		bizDTO.setIncomeScoreIn1mileRadius(business.getIncomeScoreIn1mileRadius());
		bizDTO.setPopulationIn3mileRadius(business.getPopulationIn3mileRadius());
		bizDTO.setIncomeScoreIn3mileRadius(business.getIncomeScoreIn3mileRadius());
		bizDTO.setPopulationIn5mileRadius(business.getPopulationIn5mileRadius());
		bizDTO.setIncomeScoreIn5mileRadius(business.getIncomeScoreIn5mileRadius());
		bizDTO.setDailyPeoplAtDoorNum(business.getDailyPeoplAtDoorNum());
		bizDTO.setDailyCarsAtParklotNum(business.getDailyCarsAtParklotNum());
		bizDTO.setYearEstablished(business.getYearEstablished());
		bizDTO.setCreatedByUserId(business.getCreatedByUserId());
		bizDTO.setCreateDate(business.getCreateDate().format(DateTimeFormatter.ofPattern(Constants.DATE_FORMAT)));
		bizDTO.setUpdatedByUserId(business.getUpdatedByUserId());
		bizDTO.setUpdateDate(business.getUpdateDate().format(DateTimeFormatter.ofPattern(Constants.DATE_FORMAT)));
		
		//Add Business and User relationship in t_brw_user_business table
		//addUserBusiness(bizDTO, businessDetailsDTO.getBuRelationship());
		logger.info("Elapsed time in UpdateBusinessDetails: " + (System.currentTimeMillis() - start));

		return bizDTO;
	}
	
	@Override
	public BusinessDetailsListDTO searchComparableBusiness(BusinessDetailsDTO businessInQuestion) {
		// TODO Auto-generated method stub
		logger.info("**** 222 Inside BusinessServiceImpl.searchComparableBusiness()");
		
		List<BusinessDetails> comparableBusinessList = (List<BusinessDetails>) businessDetailsDAO.searchComparableBusiness(businessInQuestion.getType(), businessInQuestion.getSubType(), businessInQuestion.getStateCode(), businessInQuestion.getCity());
		List<BusinessDetailsDTO> businessDetailsDTOList = new ArrayList<BusinessDetailsDTO>();
		BusinessDetailsListDTO businessListDTO = new BusinessDetailsListDTO();
		
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
			businessDetailsDTO.setRegCityDate(businessDetails.getRegCityDate().format(DateTimeFormatter.ofPattern(Constants.DATE_FORMAT)));
			businessDetailsDTO.setRegStateName(businessDetails.getRegStateName());
			businessDetailsDTO.setRegStateCode(businessDetails.getRegStateCode());
			businessDetailsDTO.setRegStateDate(businessDetails.getRegStateDate().format(DateTimeFormatter.ofPattern(Constants.DATE_FORMAT)));
			businessDetailsDTO.setDataCompletionScore(businessDetails.getDataCompletenessScore());
			businessDetailsDTO.setIsForSell(businessDetails.getIsForSell());
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
			businessDetailsDTO.setCreateDate(businessDetails.getCreateDate().format(DateTimeFormatter.ofPattern(Constants.DATE_FORMAT)));
			businessDetailsDTO.setUpdatedByUserId(businessDetails.getUpdatedByUserId());
			businessDetailsDTO.setUpdateDate(businessDetails.getUpdateDate().format(DateTimeFormatter.ofPattern(Constants.DATE_FORMAT)));
			
			businessDetailsDTOList.add(businessDetailsDTO);
		}
		businessListDTO.setBusinessList(businessDetailsDTOList);
		return businessListDTO;
	}
	
	/**
	 * 
	 * @author sidpatil
	 * 2018-20
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
		
		logger.info("**** 111 Inside BusinessController.estimateRealWorth()");
		
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
			return Constants.Y;
		} catch (Exception e) {
			e.printStackTrace();
			return Constants.N;
		}
	}
	
	/**
	 * @author sidpatil
	 * estimateRealWorthBasedOnAssets
	 */
	private EstimatesDTO estimateRealWorthBasedOnAssets(BusinessDetailsDTO businessInQuestion) {
		
		logger.info("**** 111 Inside BusinessController.estimateRealWorthBasedOnAssets()");		
		
		EstimatesDTO assetBasedEstimatesDTO = new EstimatesDTO();
		// TODO Implement the logic to estimate the Business Worth Based on Assets and store to t_wgpr_estimate table
		
		return assetBasedEstimatesDTO;
	}

	/**
	 * @author sidpatil
	 * estimateRealWorthBasedOnIncome
	 */
	private EstimatesDTO estimateRealWorthBasedOnIncome(BusinessDetailsDTO businessInQuestion) {
		
		logger.info("**** 111 Inside BusinessController.estimateRealWorthBasedOnIncome()");
		
		EstimatesDTO incomeBasedEstimatesDTO = new EstimatesDTO();
		// TODO Implement the logic to estimate the Business Worth Based on Income and store to t_wgpr_estimate table
		
		return incomeBasedEstimatesDTO;
	}

	/**
	 * @author sidpatil
	 * estimateRealWorthBasedOnMarket
	 */
	private EstimatesDTO estimateRealWorthBasedOnMarket(BusinessDetailsDTO businessInQuestionDTO) {
		
		logger.info("**** 222 Inside BusinessController.estimateRealWorthBasedOnMarket()");
			
		EstimatesDTO marketBasedestimatesDTO = new EstimatesDTO();
		Integer estimatedWorth = 0;
		Integer estimatedWorthHigh = 0;
		Integer estimatedWorthLow = 0;
		
		//1. Find as many as 5 comparable business based on type, state and city
		BusinessDetailsListDTO comparableBusinessDTOList = null;
		
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
		marketBasedestimatesDTO.setEstimateType(Constants.MARKET_BASED);
		marketBasedestimatesDTO.setEstimateSubType(Constants.MARKET_BASED);
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
  /*
    // Test code 
    public static void main(String[] args) 
    { 
        int arr[] = { 1, 2, 4, 5, 6, 6, 8, 10, 12}; 
        int target = 11; 
        logger.info(findClosest(arr, target)); 
    } 
    */
    
    @Override
	public RelatedBusinessDTO addRelatedBusiness(RelatedBusinessDTO relatedBusinessDTO) {
		
		logger.info("222 **** Inside UserServiceImpl.addRelatedBusiness() BusinessId: "+relatedBusinessDTO.getBusinessId());
		logger.info("222 **** Inside UserServiceImpl.addRelatedBusiness() RelatedBizId: "+relatedBusinessDTO.getRelatedBizId());
		
		RelatedBusiness relatedBusiness = new RelatedBusiness();
		RelatedBusinessDTO returnRelatedBusinessDTO = new RelatedBusinessDTO();
		
		relatedBusiness.setBusinessId(relatedBusinessDTO.getBusinessId());
		relatedBusiness.setRelatedBizId(relatedBusinessDTO.getRelatedBizId());
		relatedBusiness.setCreatedByUserId(relatedBusinessDTO.getInvokerId());
		relatedBusiness.setCreateDate(LocalDateTime.now());
		relatedBusiness.setUpdatedByUserId(relatedBusinessDTO.getInvokerId());
		relatedBusiness.setUpdateDate(LocalDateTime.now());
		
		RelatedBusiness returnRelatedBusiness = relatedBusinessDAO.save(relatedBusiness);
		
		returnRelatedBusinessDTO.setBusinessId(returnRelatedBusiness.getBusinessId());
		returnRelatedBusinessDTO.setRelatedBizId(returnRelatedBusiness.getRelatedBizId());
		returnRelatedBusinessDTO.setCreatedByUserId(returnRelatedBusiness.getCreatedByUserId());
		returnRelatedBusinessDTO.setCreateDate(returnRelatedBusiness.getCreateDate().format(DateTimeFormatter.ofPattern(Constants.DATE_FORMAT)));
		returnRelatedBusinessDTO.setUpdatedByUserId(returnRelatedBusiness.getUpdatedByUserId());
		returnRelatedBusinessDTO.setUpdateDate(returnRelatedBusiness.getUpdateDate().format(DateTimeFormatter.ofPattern(Constants.DATE_FORMAT)));
		
		return returnRelatedBusinessDTO;
	}
	
	@Override
	public RelatedBusinessListDTO getRelatedBusinesses(int businessId) {
		logger.info("222 **** Inside SearchAgentServiceImpl.getRelatedBusinesses()");
		
		List<RelatedBusiness> relatedBusinessList = (List<RelatedBusiness>)relatedBusinessDAO.getRelatedBusinesses(businessId);
		List<RelatedBusinessDTO> relatedBusinessDTOList = new ArrayList<RelatedBusinessDTO>();
		RelatedBusinessListDTO relatedBusinessListDTO = new RelatedBusinessListDTO();
		
		for (RelatedBusiness returnRelatedBusiness: relatedBusinessList) {
			RelatedBusinessDTO returnRelatedBusinessDTO = new RelatedBusinessDTO();
			
			returnRelatedBusinessDTO.setBusinessId(returnRelatedBusiness.getBusinessId());
			returnRelatedBusinessDTO.setRelatedBizId(returnRelatedBusiness.getRelatedBizId());
			returnRelatedBusinessDTO.setCreatedByUserId(returnRelatedBusiness.getCreatedByUserId());
			returnRelatedBusinessDTO.setCreateDate(returnRelatedBusiness.getCreateDate().format(DateTimeFormatter.ofPattern(Constants.DATE_FORMAT)));
			returnRelatedBusinessDTO.setUpdatedByUserId(returnRelatedBusiness.getUpdatedByUserId());
			returnRelatedBusinessDTO.setUpdateDate(returnRelatedBusiness.getUpdateDate().format(DateTimeFormatter.ofPattern(Constants.DATE_FORMAT)));
		
			relatedBusinessDTOList.add(returnRelatedBusinessDTO);
		}
		relatedBusinessListDTO.setRelatedBusinessList(relatedBusinessDTOList);
		return relatedBusinessListDTO;
	}
	
	@Override
	public void deleteRelatedBusiness(int businessId, int relatedBizId) {
		logger.info("222 **** Inside BusinessServiceImpl.deleteRelatedBusiness()");
		
		int nurDeleted = relatedBusinessDAO.deleteRelatedBusiness(businessId, relatedBizId);
		
		logger.info("222 **** Inside BusinessServiceImpl.deleteRelatedBusiness() nurDeleted: "+nurDeleted);
	}
	
	private void addUserBusiness(BusinessDetailsDTO businessDetailsDTO, String relationshipType) {
		
		logger.info("222 **** Inside BusinessServiceImpl.addUserBusiness - businessDetailsDTO.getCreatedByUserId(): "+businessDetailsDTO.getCreatedByUserId());
		
		UserBusiness userBusiness = new UserBusiness();
		
		userBusiness.setUserId(businessDetailsDTO.getCreatedByUserId());
		userBusiness.setRelationship(relationshipType);
		userBusiness.setBusinessId(businessDetailsDTO.getBusinessId());
		userBusiness.setCreatedByUserId(businessDetailsDTO.getCreatedByUserId());
		userBusiness.setCreateDate(LocalDateTime.now());
		userBusiness.setUpdatedByUserId(businessDetailsDTO.getCreatedByUserId());
		userBusiness.setUpdateDate(LocalDateTime.now());
		
		userBusinessDAO.save(userBusiness);
	}
}