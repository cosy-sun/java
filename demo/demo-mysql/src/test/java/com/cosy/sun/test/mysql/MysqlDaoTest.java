package com.cosy.sun.test.mysql;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.cosy.sun.mysql.DemoMysqlApplication;
import com.cosy.sun.mysql.dao.DemoMysqlDao;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = DemoMysqlApplication.class)
public class MysqlDaoTest {

	@Autowired
	private DemoMysqlDao dao;
	
	@Test
	public void test() {
		List<Integer> selectAll = dao.selectAll();
		selectAll.forEach(System.out::println);
	}
	
}
