package com.cosy.sun.redis.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import redis.clients.jedis.JedisPool;

@Configuration
public class JedisConfig {

	@Bean
	public JedisPool jedisPool() {
		JedisPool pool =  new JedisPool("test", 6379);
		pool.setMaxIdle(10);
		pool.setMaxTotal(10);
		return pool;
	}
	
}
