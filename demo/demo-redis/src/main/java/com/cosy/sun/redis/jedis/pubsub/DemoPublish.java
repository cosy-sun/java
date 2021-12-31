package com.cosy.sun.redis.jedis.pubsub;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import redis.clients.jedis.JedisPool;

@Service
public class DemoPublish {

	private static final Logger logger = LoggerFactory.getLogger(DemoPublish.class);
	
	@Autowired
	private JedisPool pool;
	
	@Autowired 
	private DemoSubscrib demoSubScribe;
	
	public void publish(String channel, String value) {
		long publish = pool.getResource().publish(channel, value);
		logger.info("publish推送通知后的返回:{}", publish);
	}
	
	@PostConstruct
	public void pubSub() {
		logger.info("启动的时候订阅channel");
		ExecutorService newSingleThreadExecutor = Executors.newSingleThreadExecutor();
		newSingleThreadExecutor.execute(() -> {
			pool.getResource().subscribe(demoSubScribe, "testchannel");
		});
	}

}
