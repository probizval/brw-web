package com.brw.dao;

import org.springframework.data.repository.PagingAndSortingRepository;
import com.brw.entities.UserActivity;

public interface UserActivityDAO extends PagingAndSortingRepository<UserActivity, Integer> {

}