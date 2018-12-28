package com.brw.dao;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import com.brw.entities.SalonStore;

@Repository
public interface SalonStoreDAO extends PagingAndSortingRepository<SalonStore, Integer> {



}
