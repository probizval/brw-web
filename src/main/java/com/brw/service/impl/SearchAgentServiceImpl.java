package com.brw.service.impl;

/**
 * @author sidpatil
 * 2020
 */

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.brw.common.constants.Constants;
import com.brw.dao.SearchAgentDAO;
import com.brw.dto.EmailDTO;
import com.brw.dto.SearchAgentDTO;
import com.brw.dto.SearchAgentsListDTO;
import com.brw.dto.UserActivityDTO;
import com.brw.entities.SearchAgent;
import com.brw.service.EmailService;
import com.brw.service.UserService;

@Component
public class SearchAgentServiceImpl implements com.brw.service.SearchAgentService {

	private static final Logger logger = LoggerFactory.getLogger(SearchAgentServiceImpl.class);

	@Autowired
	private SearchAgentDAO searchAgentDAO;
	
	@Autowired
	UserService userService;
	
	@Autowired
	EmailService emailService;
	
	@Override
	public SearchAgentDTO addSearchAgent(SearchAgentDTO searchAgentDTO) {
		long start = System.currentTimeMillis();
		//Log the User Action - START
		UserActivityDTO userActivityDTO = new UserActivityDTO();
		
		if(null == searchAgentDTO.getUserId()) {
			searchAgentDTO.setUserId(1001);
		}
		userActivityDTO.setUserId(searchAgentDTO.getUserId());
		userActivityDTO.setBusinessId(1000000);
		userActivityDTO.setType(Constants.BUTTON_CLICK);
		userActivityDTO.setSubType(Constants.SUBSCRIBE);
		
		try {
			userService.trackUserActivity(userActivityDTO);
		} catch (Exception e) {
			e.printStackTrace();
		}
		//Log the User Action - END
		
		logger.info("222 **** Inside SearchAgentServiceImpl.addSearchAgent()");
		SearchAgent searchAgent = new SearchAgent();
		searchAgent.setUserId(searchAgentDTO.getUserId());
		searchAgent.setEmail(searchAgentDTO.getEmail());
		searchAgent.setName(searchAgentDTO.getName());
		searchAgent.setBizType(searchAgentDTO.getBizType());
		searchAgent.setFrequency(searchAgentDTO.getFrequency());
		searchAgent.setPriceLow(searchAgentDTO.getPriceLow());
		searchAgent.setPriceHigh(searchAgentDTO.getPriceHigh());
		searchAgent.setState(searchAgentDTO.getState());
		searchAgent.setCounty(searchAgentDTO.getCounty());
		searchAgent.setCreatedByUserId(searchAgentDTO.getUserId());
		searchAgent.setCreateDate(LocalDateTime.now());
		searchAgent.setUpdatedByUserId(searchAgentDTO.getUserId());
		searchAgent.setUpdateDate(LocalDateTime.now());
		
		SearchAgent returnSearchAgent = searchAgentDAO.save(searchAgent);
		
		SearchAgentDTO returnSearchAgentDTO = new SearchAgentDTO();
		returnSearchAgentDTO.setUserId(returnSearchAgent.getUserId());
		returnSearchAgentDTO.setAgentId(returnSearchAgent.getAgentId());
		returnSearchAgentDTO.setEmail(returnSearchAgent.getEmail());
		returnSearchAgentDTO.setName(returnSearchAgent.getName());
		returnSearchAgentDTO.setFrequency(returnSearchAgent.getFrequency());
		returnSearchAgentDTO.setPriceLow(returnSearchAgent.getPriceLow());
		returnSearchAgentDTO.setPriceHigh(returnSearchAgent.getPriceHigh());
		returnSearchAgentDTO.setState(returnSearchAgent.getState());
		returnSearchAgentDTO.setCounty(returnSearchAgent.getCounty());
		
		//Send an email to user who is saving the Search Agent
		List<String> toList = new ArrayList();
		toList.add(searchAgentDTO.getEmail());
		
		EmailDTO emailDTO = new EmailDTO();
		emailDTO.setToList(toList);
		emailDTO.setFrom("admin@bizrealworth.com");
		emailDTO.setSubject("Confirmation: Subscription to www.BizRealWorth.com");
		emailDTO.setContent("Thank you for subcription with www.BizRealWorth.com, stay tuned!");
		emailDTO.setInvokerId(1001);
		
		try {
			emailService.sendEmail(emailDTO);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		logger.info("Elapsed time in addSearchAgent(): " + (System.currentTimeMillis() - start));
		return returnSearchAgentDTO;
	}
	
	@Override
	public SearchAgentsListDTO getSearchAgents(int userId) {
		
		logger.info("222 **** Inside SearchAgentServiceImpl.getSearchAgent()");
	
		List<SearchAgent> searchAgentsList = (List<SearchAgent>)searchAgentDAO.getSearchAgents(userId);
		List<SearchAgentDTO> searchAgentsDTOList = new ArrayList<SearchAgentDTO>();
		SearchAgentsListDTO searchAgentsListDTO = new SearchAgentsListDTO();
		
		for (SearchAgent searchAgent: searchAgentsList) {
			SearchAgentDTO searchAgentDTO = new SearchAgentDTO();
			
			searchAgentDTO.setUserId(searchAgent.getUserId());
			searchAgentDTO.setAgentId(searchAgent.getAgentId());
			searchAgentDTO.setEmail(searchAgent.getEmail());
			searchAgentDTO.setName(searchAgent.getName());
			searchAgentDTO.setBizType(searchAgent.getBizType());
			searchAgentDTO.setFrequency(searchAgent.getFrequency());
			searchAgentDTO.setPriceLow(searchAgent.getPriceLow());
			searchAgentDTO.setPriceHigh(searchAgent.getPriceHigh());
			searchAgentDTO.setState(searchAgent.getState());
			searchAgentDTO.setCounty(searchAgent.getCounty());
		
			searchAgentsDTOList.add(searchAgentDTO);
		}
		searchAgentsListDTO.setSearchAgentsList(searchAgentsDTOList);
		return searchAgentsListDTO;
	}
	
	@Override
	public void deleteSearchAgent(int userId, int agentId) {
		
		logger.info("222 **** Inside SearchAgentServiceImpl.deleteSearchAgent()");
		
		int nurDeleted = searchAgentDAO.deleteSearchAgent(userId, agentId);
		
		logger.info("222 **** Inside SearchAgentServiceImpl.deleteSearchAgent() nurDeleted: "+nurDeleted);
	}
}