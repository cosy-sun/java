package com.cosy.sun.es;

import com.cosy.sun.es.dao.DemoEsDao;
import org.elasticsearch.client.RestHighLevelClient;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class DemoEsTest {

	private static final Logger logger = LoggerFactory.getLogger(DemoEsTest.class);

	@Autowired
	private RestHighLevelClient client;
	
	@Autowired
	private DemoEsDao dao;

	@Test
	public void test() {
		logger.info(client.toString());
	}

	@Test
	public void testIndex() {
		try {
			dao.indexReq();
		} catch (Exception e) {
			logger.error("", e);
		}
	}

}
