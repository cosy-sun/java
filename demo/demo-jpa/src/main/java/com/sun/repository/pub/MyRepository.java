package com.sun.repository.pub;

import java.io.Serializable;

import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.PagingAndSortingRepository;

@NoRepositoryBean
public interface MyRepository<T, ID  extends Serializable> extends PagingAndSortingRepository<T, Serializable>{

	T findById(ID id);
	
}
