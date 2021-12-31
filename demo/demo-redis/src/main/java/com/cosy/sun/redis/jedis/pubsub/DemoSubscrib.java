package com.cosy.sun.redis.jedis.pubsub;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import redis.clients.jedis.JedisPubSub;

@Service
public class DemoSubscrib extends JedisPubSub {

	private static final Logger logger = LoggerFactory.getLogger(DemoSubscrib.class);
	
	public void onMessage(String channel, String message) {
		logger.info("channel : {}, message: {}", channel, message);
	}
	
}
