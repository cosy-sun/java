package com.sun.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.sun.entity.Usercustomer;

public interface UsercustomerRepository extends JpaRepository<Usercustomer, Long>{

	@Query(value = "update usercustomer set customername = ?1 where id = ?2", nativeQuery = true)
	@Modifying
	@Transactional
	int update(String customername, int id);
	
}
