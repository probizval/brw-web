package com.brw.dao;

import org.springframework.data.repository.PagingAndSortingRepository;
import com.brw.entities.BusinessRequirement;

public interface BusinessRequirementDAO extends PagingAndSortingRepository<BusinessRequirement, Integer> {

}
