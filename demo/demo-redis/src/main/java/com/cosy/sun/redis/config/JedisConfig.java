package com.cosy.sun.redis.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

@Configuration
public class JedisConfig {

	@Bean
	public Jedis jedisPool() {
		JedisPoolConfig config = new JedisPoolConfig();
		JedisPool pool =  new JedisPool("test");
		Jedis resource = pool.getResource();
		return resource;
	}
	
}
