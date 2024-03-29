package com.batch.repository.self;

import org.springframework.data.jpa.repository.Query;

import com.batch.entity.User;

public interface UserRepository {

	@Query(value = "select * from user where id = ?1", nativeQuery = true)
	public User findByName(long id);
	
}
