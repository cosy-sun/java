package com.sun.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sun.entity.Author;

public interface Articlerepostitory extends JpaRepository<Author, Long>{

	@Query(value = "select * from author where id = ?1", nativeQuery = true)
	Author findByName(long id);
	
	@Query(value = "select * from author where name = ?1" , nativeQuery = true)
	List<Author> findAllByName(String name);
}
