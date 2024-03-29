package com.batch.repository;

import com.batch.entity.Usercustomer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface UsercustomerRepository extends JpaRepository<Usercustomer, Long>{

	@Query(value = "update usercustomer set customername = ?1 where id = ?2", nativeQuery = true)
	@Modifying
	@Transactional
	int update(String customername, int id);
	
}
