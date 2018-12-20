package com.brw.dao;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.brw.entities.CoinLaundry;
import com.brw.entities.PropertyDetails;

@Repository
public interface CoinLaundryDAO extends PagingAndSortingRepository<CoinLaundry, Integer> {



}
