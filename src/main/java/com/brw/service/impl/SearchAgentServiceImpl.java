package com.brw.service.impl;

/**
 * @author sidpatil
 * 2020
 */

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.brw.common.constants.Constants;
import com.brw.dao.SearchAgentDAO;
import com.brw.dto.SearchAgentDTO;
import com.brw.dto.SearchAgentsListDTO;
import com.brw.dto.UserActivityDTO;
import com.brw.entities.SearchAgent;
import com.brw.service.UserService;

@Component
public class SearchAgentServiceImpl implements com.brw.service.SearchAgentService {

	@Autowired
	private SearchAgentDAO searchAgentDAO;
	
	@Autowired
	UserService userService;
	
	@Override
	public SearchAgentDTO addSearchAgent(SearchAgentDTO searchAgentDTO) {
		
		//Log the User Action - START
		UserActivityDTO userActivityDTO = new UserActivityDTO();
		
		if(null == searchAgentDTO.getUserId()) {
			searchAgentDTO.setUserId(1001);
		}
		userActivityDTO.setUserId(searchAgentDTO.getUserId());
		userActivityDTO.setBusinessId(1000000);
		userActivityDTO.setType(Constants.BUTTON_CLICK);
		userActivityDTO.setSubType(Constants.SUBSCRIBE);

		userService.trackUserActivity(userActivityDTO);
		//Log the User Action - END
		
		System.out.println("222 **** Inside SearchAgentServiceImpl.addSearchAgent()");
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
		
		return returnSearchAgentDTO;
	}
	
	@Override
	public SearchAgentsListDTO getSearchAgents(int userId) {
		
		System.out.println("222 **** Inside SearchAgentServiceImpl.getSearchAgent()");
	
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
		
		System.out.println("222 **** Inside SearchAgentServiceImpl.deleteSearchAgent()");
		
		int nurDeleted = searchAgentDAO.deleteSearchAgent(userId, agentId);
		
		System.out.println("222 **** Inside SearchAgentServiceImpl.deleteSearchAgent() nurDeleted: "+nurDeleted);

	}
}