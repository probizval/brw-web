package com.brw.dao;

import org.springframework.data.repository.PagingAndSortingRepository;
import com.brw.entities.AutoService;

public interface AutoServiceDAO extends PagingAndSortingRepository<AutoService, Integer> {

}
