package com.sun.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.sun.entity.Example;
import com.sun.entity.ExamplesKey;

public interface IdclassRepository extends CrudRepository<Example, ExamplesKey>{

	@Query("select e from Example e where e.mingzi = ?1 and e.dianhua = ?2")
	Example findByIdclass(String name, String phone);
	
}
