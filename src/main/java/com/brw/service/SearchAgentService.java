package com.brw.service;

/**
 * @author sidpatil
 * 2020
 */

import com.brw.dto.SearchAgentDTO;
import com.brw.dto.SearchAgentsListDTO;
import com.brw.exceptions.SearchAgentException;

public interface SearchAgentService {
	
	public SearchAgentDTO addSearchAgent(SearchAgentDTO searchAgentDTO) throws SearchAgentException;
	public SearchAgentsListDTO getSearchAgents(int userId) throws SearchAgentException;
	public void deleteSearchAgent(int userId, int agentId) throws SearchAgentException;
}