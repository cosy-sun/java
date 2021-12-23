package com.sun.repository.self;

import org.springframework.data.repository.CrudRepository;

import com.sun.entity.User;

public interface UserRepositoryuser extends CrudRepository<User, Long>, UserRepository{

}
