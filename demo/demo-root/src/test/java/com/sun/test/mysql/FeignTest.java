package com.sun.test.mysql;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.sun.Api;
import com.sun.SimplebootprojectApplication;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SimplebootprojectApplication.class)
public class FeignTest {

	private static final Logger logger = LoggerFactory.getLogger(FeignTest.class);
	
	@Autowired
	private Api api;
	
	@Test
	public void test() {
		String api2 = api.api();
		logger.info("本次调用结果: {}", api2);
	}
	
}
