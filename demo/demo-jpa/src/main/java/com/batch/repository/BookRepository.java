package com.batch.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.batch.entity.Book;

public interface BookRepository extends JpaRepository<Book, String> {

	
	
}
