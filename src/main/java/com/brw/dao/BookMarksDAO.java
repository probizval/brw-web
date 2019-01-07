package com.brw.dao;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import com.brw.entities.BookMarks;
import com.brw.entities.PropertyDetails;

public interface BookMarksDAO extends PagingAndSortingRepository<BookMarks, Integer> {

	List<BookMarks> findByUserIdAndPropertyDetailsId(@Param ("userId") int userId,@Param ("propertyDetailsId") int propertyDetailsId);

}

