//package com.batch.repository;
//
//import javax.transaction.Transactional;
//
//import org.springframework.data.jpa.repository.Modifying;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.jpa.repository.query.Procedure;
//import org.springframework.data.repository.CrudRepository;
//import org.springframework.data.repository.query.Param;
//
//import com.batch.entity.User;
//
//public interface RepositoryTest extends CrudRepository<User, Long>{
//
////	List<User> findByName(String name);
//
//	@Query(value = "select * from User where name = ?1", nativeQuery = true)
//	User findByName1(String name);
//
//	@Query(value = "select u from User u where u.eamli= ?1")
//	User findByEamli(String eamil);
//
//	@Query(value = "select u from User u where u.name = :name")
//	User findByName2(@Param("name") String name);
//
//	@Query(value = "select u from #{#entityName} u where u.name = :name")
//	User findByName3(@Param("name") String name);
//	//modifying在修改或者删除的时候必须使用事务的注解,@transactional
//	@Transactional
//	//在modifying注解中如果开启了以及缓存,需要设置属性为true,否则在同一
//	//接口中查询到的数据还是更新之前的数据.
//	@Modifying
//	@Query(value = "update User u set u.eamli = ?1 where u.name = ?2")
//	int updateByName(String eamli, String name);
//
//	@Procedure(procedureName = "pluslinout")
//	Integer findByProcedure(Integer arg);
//
//	User findByName(String name);
//}
