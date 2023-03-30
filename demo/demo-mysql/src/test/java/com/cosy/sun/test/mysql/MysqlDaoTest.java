package com.cosy.sun.test.mysql;

import com.cosy.sun.mysql.DemoMysqlApplication;
import com.cosy.sun.mysql.dao.DemoMysqlDao;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

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
