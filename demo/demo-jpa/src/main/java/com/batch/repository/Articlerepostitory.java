package com.batch.repository;

import com.batch.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface Articlerepostitory extends JpaRepository<Author, Long>{

	@Query(value = "select * from author where id = ?1", nativeQuery = true)
	Author findByName(long id);
	
	@Query(value = "select * from author where name = ?1" , nativeQuery = true)
	List<Author> findAllByName(String name);
}
