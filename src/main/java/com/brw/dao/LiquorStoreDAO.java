package com.brw.dao;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import com.brw.entities.LiquorStore;

@Repository
public interface LiquorStoreDAO extends PagingAndSortingRepository<LiquorStore, Integer> {



}
