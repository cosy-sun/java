package com.cosy.sun.test.mongo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.cosy.sun.mongo.DemoMongoApplication;
import com.cosy.sun.mongo.dao.MongoDao;
import com.cosy.sun.mongo.module.MongoModule;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = DemoMongoApplication.class)
public class DemoMongoTest {

	@Autowired
	private MongoDao dao;
	
	@Test
	public void test() {
		MongoModule mongoModule = new MongoModule();
		mongoModule.setId("123");
		mongoModule.setName("sunzhenhua");
		dao.saveTest(mongoModule);
	}
	
}
