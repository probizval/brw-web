package com.brw.dao;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import com.brw.entities.Restaurant;

@Repository
public interface RestaurentDAO  extends PagingAndSortingRepository<Restaurant, Integer> {

}
