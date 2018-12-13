package com.brw.dao;


import java.util.List;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.brw.entities.GasStation;

import org.springframework.data.repository.query.Param;


@Repository
public interface GasStationDAO  extends PagingAndSortingRepository<GasStation, Integer>{

}
