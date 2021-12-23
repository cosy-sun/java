package com.cosy.sun.test.es;

import org.elasticsearch.client.RestHighLevelClient;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.cosy.sun.es.DemoEsApplication;
import com.cosy.sun.es.dao.DemoEsDao;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = DemoEsApplication.class)
public class DemoEsTest {

	@Autowired
	private DemoEsDao dao;
	
	@Autowired
	private RestHighLevelClient client;
	
	private static final Logger logger = LoggerFactory.getLogger(DemoEsTest.class);
	
	@Test
	public void test() {
		logger.info(client.toString());
	}
	
}
