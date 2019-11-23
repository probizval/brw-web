package com.brw.dao;

import java.util.List;

/**
 * @author sidpatil
 * 2019
 */

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.query.Param;

import com.brw.entities.BizTransactions;

@Repository
public interface BizTransactionsDAO extends PagingAndSortingRepository<BizTransactions, Integer>{

	@Query(nativeQuery=true, value="SELECT * FROM t_brw_business_transactions WHERE (:businessId is null or biz_id = :businessId) ORDER BY date DESC;")
	List<BizTransactions> getBizTransactions(@Param ("businessId") int businessId);
	
	@Query(nativeQuery=true, value="SELECT * FROM t_brw_business_transactions WHERE (:businessId is null or biz_id = :businessId ) "
			+ "AND type = :transactionType ORDER BY date DESC LIMIT 1;")
	BizTransactions getBizLastSoldPrice(@Param ("businessId") int businessId, @Param ("transactionType") String transactionType);
	
	//@Query(nativeQuery=true, value="SELECT * FROM t_brw_estimate WHERE (:businessId is null or biz_id = :businessId) ORDER BY est_id DESC;")
	//List<Estimates> getEstimatesHistory(@Param ("businessId") int businessId);
}
