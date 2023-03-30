package com.batch.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.batch.entity.Example;

public interface RepositoryExample extends CrudRepository<Example, String>{

	@Query("select e from Example e where e.mingzi = ?1")
	Example findByName(String name);
	
}
