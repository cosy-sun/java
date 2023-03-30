package com.batch.repository.self;

import com.batch.entity.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

public class UserRepositoryImpl implements UserRepository{

	@PersistenceContext
	EntityManager entityManager;
	
	@Override
	public User findByName(long id) {
		return entityManager.find(User.class, id);
	}

}
