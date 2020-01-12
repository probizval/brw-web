package com.brw.service.impl;

/**
 * @author sidpatil
 * 2019
 */

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.brw.dao.SearchAgentDAO;
import com.brw.dto.SearchAgentDTO;
import com.brw.entities.SearchAgent;

@Component
public class SearchAgentServiceImpl implements com.brw.service.SearchAgentService {

	@Autowired
	private SearchAgentDAO searchAgentDAO;
	
	@Override
	public SearchAgentDTO addSearchAgent(SearchAgentDTO searchAgentDTO) {
		
		System.out.println("222 **** Inside SearchAgentServiceImpl.addSearchAgent()");
		SearchAgent searchAgent = new SearchAgent();
		searchAgent.setUserId(searchAgentDTO.getInvokerId());
		searchAgent.setEmail(searchAgentDTO.getEmail());
		searchAgent.setName(searchAgentDTO.getName());
		searchAgent.setFrequency(searchAgentDTO.getFrequency());
		searchAgent.setPriceLow(searchAgentDTO.getPriceLow());
		searchAgent.setPriceHigh(searchAgentDTO.getPriceHigh());
		searchAgent.setState(searchAgentDTO.getState());
		searchAgent.setCounty(searchAgentDTO.getCounty());
		searchAgent.setCreatedByUserId(searchAgentDTO.getInvokerId());
		searchAgent.setCreateDate(LocalDateTime.now());
		searchAgent.setUpdatedByUserId(searchAgentDTO.getInvokerId());
		searchAgent.setUpdateDate(LocalDateTime.now());
		
		SearchAgent returnSearchAgent = searchAgentDAO.save(searchAgent);
		
		SearchAgentDTO returnSearchAgentDTO = new SearchAgentDTO();
		returnSearchAgentDTO.setInvokerId(returnSearchAgent.getUserId());
		returnSearchAgentDTO.setEmail(returnSearchAgent.getEmail());
		returnSearchAgentDTO.setName(returnSearchAgent.getName());
		returnSearchAgentDTO.setFrequency(returnSearchAgent.getFrequency());
		returnSearchAgentDTO.setPriceLow(returnSearchAgent.getPriceLow());
		returnSearchAgentDTO.setPriceHigh(returnSearchAgent.getPriceHigh());
		returnSearchAgentDTO.setState(returnSearchAgent.getState());
		returnSearchAgentDTO.setCounty(returnSearchAgent.getCounty());
		
		return returnSearchAgentDTO;
	}
}