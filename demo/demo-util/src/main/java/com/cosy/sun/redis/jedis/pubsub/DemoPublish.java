package com.cosy.sun.redis.jedis.pubsub;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import redis.clients.jedis.Jedis;

@Service
public class DemoPublish {

	private static final Logger logger = LoggerFactory.getLogger(DemoPublish.class);
	
	@Autowired
	private Jedis jedis;
	
	public void publish(String channel, String value) {
		long publish = jedis.publish(channel, value);
		logger.info("publish推送通知后的返回:{}", publish);
	}
	

}
