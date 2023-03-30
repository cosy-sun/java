package com.batch.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.batch.entity.Article;

public interface Authorrepository extends JpaRepository<Article, Long>{

	@Query("select a from Article a where a.id = ?1")
	Article fingByName(long id);
	
}
