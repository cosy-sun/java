//package com.sun.repository.pub;
//
//import java.io.Serializable;
//
//import javax.persistence.EntityManager;
//import javax.persistence.PersistenceContext;
//
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.Pageable;
//import org.springframework.data.domain.Sort;
//
//public class MyRepositoryImpl<T, ID extends Serializable> implements MyRepository<T, ID>{
//
//
//	@PersistenceContext
//	private EntityManager em;
//	private Class<T> domain;
//	
//	public Class<T> getCla(){
//		return domain;
//	}
//	
//	@Override
//	public T findById(Serializable id) {
//		return (T) em.find(getCla(), id);
//	}
//
//	@Override
//	public Iterable<T> findAll(Sort sort) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public Page<T> findAll(Pageable pageable) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public <S extends T> S save(S entity) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public <S extends T> Iterable<S> saveAll(Iterable<S> entities) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public boolean existsById(Serializable id) {
//		// TODO Auto-generated method stub
//		return false;
//	}
//
//	@Override
//	public Iterable<T> findAll() {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public Iterable<T> findAllById(Iterable<Serializable> ids) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public long count() {
//		// TODO Auto-generated method stub
//		return 0;
//	}
//
//	@Override
//	public void deleteById(Serializable id) {
//		// TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	public void delete(T entity) {
//		// TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	public void deleteAll(Iterable<? extends T> entities) {
//		// TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	public void deleteAll() {
//		// TODO Auto-generated method stub
//		
//	}
//
//}
