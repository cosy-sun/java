package com.batch.repository.self;

import org.springframework.data.repository.CrudRepository;

import com.batch.entity.User;

public interface UserRepositoryuser extends CrudRepository<User, Long>, UserRepository{

}
