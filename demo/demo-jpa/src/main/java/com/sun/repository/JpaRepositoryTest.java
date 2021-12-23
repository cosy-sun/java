package com.sun.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sun.entity.User;

public interface JpaRepositoryTest extends JpaRepository<User, Long>{

}
