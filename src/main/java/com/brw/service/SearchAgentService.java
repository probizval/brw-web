package com.brw.service;

/**
 * @author sidpatil
 * 2020
 */

import com.brw.dto.SearchAgentDTO;
import com.brw.exceptions.SearchAgentException;

public interface SearchAgentService {
	
	public SearchAgentDTO addSearchAgent(SearchAgentDTO searchAgentDTO) throws SearchAgentException;
}