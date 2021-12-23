package com.sun.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sun.entity.Book;

public interface BookRepository extends JpaRepository<Book, String> {

	
	
}
