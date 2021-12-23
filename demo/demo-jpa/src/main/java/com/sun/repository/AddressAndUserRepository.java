package com.sun.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sun.entity.UserAddress;

public interface AddressAndUserRepository extends JpaRepository<UserAddress, Long>{

//	@Query("insert into UserAddress u (u.name,u.eamli,u.address) values (?1,?2,?3)")
//	int saveUserAddress(String name, String eamli, Address address);
	
	@Query(nativeQuery = true, value = "select * from user where name = ?1")
	UserAddress findByName(String name);
	
}
