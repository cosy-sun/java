package com.sun.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sun.entity.Article;

public interface Authorrepository extends JpaRepository<Article, Long>{

	@Query("select a from Article a where a.id = ?1")
	Article fingByName(long id);
	
}
