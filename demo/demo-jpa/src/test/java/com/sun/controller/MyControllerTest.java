//package com.sun.controller;
//
//import java.util.Iterator;
//import java.util.List;
//
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.data.domain.ExampleMatcher;
//import org.springframework.data.domain.ExampleMatcher.GenericPropertyMatchers;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//
//import com.sun.SpringdatajpaApplication;
//import com.sun.entity.Address;
//import com.sun.entity.Article;
//import com.sun.entity.Author;
//import com.sun.entity.Book;
//import com.sun.entity.Example;
//import com.sun.entity.User;
//import com.sun.entity.UserAddress;
//import com.sun.entity.Usercustomer;
//import com.sun.repository.AddressAndUserRepository;
//import com.sun.repository.Articlerepostitory;
//import com.sun.repository.Authorrepository;
//import com.sun.repository.BookRepository;
//import com.sun.repository.IdclassRepository;
//import com.sun.repository.RepositoryExample;
//import com.sun.repository.RepositoryTest;
//import com.sun.repository.UsercustomerRepository;
//import com.sun.repository.pub.MyRepositorySelf;
//import com.sun.repository.self.UserRepository;
//import com.sun.repository.self.UserRepositoryuser;
//
//@DataJpaTest
//@RunWith(SpringJUnit4ClassRunner.class)
//@SpringBootTest(classes = SpringdatajpaApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
//public class MyControllerTest {
//	@Autowired
//	private RepositoryTest repository;
//	@Autowired
//	private RepositoryExample repositoryExample;
//	@Autowired
//	private IdclassRepository idclassRepository;
//	@Autowired
//	private AddressAndUserRepository repositoryaddress;
//	@Autowired
//	private Authorrepository authorrepository;
//	@Autowired
//	private Articlerepostitory article;
//	@Autowired
//	private BookRepository bookrepository;
//	@Autowired
//	private UserRepositoryuser repositoryuser;
//	@Autowired
//	private UserRepository test;
//	@Autowired
//	private MyRepositorySelf selfRepository;
//	@Autowired
//	private UsercustomerRepository usercustomer;
//
//
//	@Test
//	public void update2() {
//		int update = usercustomer.update("sss33",8);
//		System.out.println(update);
//	}
//
//	@Test
//	public void update() {
//		Usercustomer entity = new Usercustomer();
//		entity.setId(3);
//		entity.setCustomeremail("737387998@qq.com");
//		usercustomer.save(entity);
//	}
//
//	@Test
//	public void auditing() {
//		Usercustomer entity = new Usercustomer();
//		entity.setCustomername("sunzhenhua");
//		entity.setCustomeremail("sunzhenhua_csii.com.cn");
//		usercustomer.save(entity);
//	}
//
//	@Test
//	public void shared() {
//		User user = selfRepository.findById((long)1);
//		System.out.println(user.getEamli());
//	}
//
//	@Test
//	public void self() {
//		User findByName = test.findByName((long)1);
//		System.out.println(findByName.getEamli());
//
//	}
//
//	@Test
//	public void test() {
//		User findByName = repositoryuser.findByName((long)1);
//		System.out.println(findByName.getEamli());
//
//	}
//
//	@Test
//	public void book() {
//		Book book = new Book("szh", "2018-10-1", "szh");
//		ExampleMatcher matcher = ExampleMatcher.matching().withMatcher("name", GenericPropertyMatchers.startsWith());
//		org.springframework.data.domain.Example<Book> of = org.springframework.data.domain.Example.of(book, matcher);
//		boolean findAll = bookrepository.exists(of);
//		System.out.println(findAll);
//	}
//
//	@Test
//	public void findAllByName() {
//		List<Author> findAllByName = article.findAllByName("szh");
//		Iterator<Author> iterator = findAllByName.iterator();
//		while(iterator.hasNext()) {
//			System.out.println(iterator.next());
//		}
//	}
//
//	@Test
//	public void author() {
//		Article fingByName = authorrepository.fingByName(1);
//		System.out.println(fingByName.getConten());
//	}
//
//	@Test
//	public void article() {
//		Author author = article.findByName(1);
//		System.out.println(author);
//	}
////	@Test
////	public void test() {
////		List<User> list = repository.findByName("szh");
////		Iterator<User> iterator = list.iterator();
////		while(iterator.hasNext()) {
////			System.out.println(iterator.next().getEamli());
////		}
////	}
//
//
//	@Test
//	public void saveAddress() {
//		Address address = new Address(1, "锦绣东路");
//		UserAddress user = new UserAddress((long)2, "szh", "sunzhenhua_csii.com.cn", address);
//		UserAddress save = repositoryaddress.save(user);
//		System.out.println(save.toString());
//	}
//
//	@Test
//	public void address() {
//		UserAddress userAddress = repositoryaddress.findByName("szh");
//		System.out.println(userAddress.toString());
//	}
//
//	@Test
//	public void idclass() {
//		Example example = idclassRepository.findByIdclass("szh", "18406504782");
//		System.out.println(example.getDianhua()+example.getMingzi());
//	}
//
//	@Test
//	public void table() {
//		Example example = repositoryExample.findByName("szh");
//		System.out.println(example.getDianhua()+example.getMingzi());
//	}
//
//	@Test
//	public void test1() {
//		User email = repository.findByName2("szh");
//		System.out.println(email.getEamli()+email.getName()+email.getId());
//	}
//
//	@Test
//	public void test2() {
//		User email = repository.findByEamli("737387998@qq.com");
//		System.out.println(email.getEamli()+email.getName()+email.getId());
//	}
//
//	@Test
//	public void spel() {
//		User user = repository.findByName3("szh");
//		System.out.println(user.getEamli()+user.getName());
//	}
//
//
//	@Test
//	public void modify() {
//		int count = repository.updateByName("sunzhenhua", "szh");
//		System.out.println(count);
//		System.out.println(repository.findByName3("szh").getEamli());
//	}
//
//	@Test
//	public void procedure() {
//		Integer integer = repository.findByProcedure(10);
//		System.out.println(integer);
//	}
//
//	@Test
//	public void namedQuery() {
//		User user = repository.findByName("szh");
//
//		System.out.println(user.getEamli()+user.getName()+user.getId());
//	}
//}
