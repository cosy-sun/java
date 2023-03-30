package com.batch.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.batch.entity.Example;
import com.batch.entity.ExamplesKey;

public interface IdclassRepository extends CrudRepository<Example, ExamplesKey>{

	@Query("select e from Example e where e.mingzi = ?1 and e.dianhua = ?2")
	Example findByIdclass(String name, String phone);
	
}
