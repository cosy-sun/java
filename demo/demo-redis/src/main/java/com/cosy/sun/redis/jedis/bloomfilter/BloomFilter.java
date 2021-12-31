package com.cosy.sun.redis.jedis.bloomfilter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * 布隆过滤器 
 * 可以去重, 但是有误差
 * @author cosy-sun
 *
 */
@Service
public class BloomFilter {

	@Autowired
	private JedisPool pool;
	
	private Jedis jedis = pool.getResource();
	
	public void add() {
	}
	
}
