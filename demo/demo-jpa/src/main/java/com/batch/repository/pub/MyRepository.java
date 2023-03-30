package com.batch.repository.pub;

import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.io.Serializable;

@NoRepositoryBean
public interface MyRepository<T, ID  extends Serializable> extends PagingAndSortingRepository<T, Serializable>{

	T findById(ID id);
	
}
