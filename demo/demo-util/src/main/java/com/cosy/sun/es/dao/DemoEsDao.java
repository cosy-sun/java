package com.cosy.sun.es.dao;

import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Component
public class DemoEsDao {

	private static final Logger logger = LoggerFactory.getLogger(DemoEsDao.class);
	
	@Autowired
	private RestHighLevelClient client;
	
	public void indexReq() throws IOException {
		IndexRequest ndexRequest = new IndexRequest("szh");
		ndexRequest.id("2");
		ndexRequest.type("doc");
		Map<String, String> map = new HashMap<>();
		map.put("username", "sunzhenhua");
		map.put("age", "26");
		ndexRequest.source(map);
		IndexResponse index = client.index(ndexRequest, RequestOptions.DEFAULT);
		logger.info("response: {}", index);
	}
	
}
