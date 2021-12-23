package com.sun.repository.self;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.sun.entity.User;

public class UserRepositoryImpl implements UserRepository{

	@PersistenceContext
	EntityManager entityManager;
	
	@Override
	public User findByName(long id) {
		return entityManager.find(User.class, id);
	}

}
