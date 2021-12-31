package com.cosy.sun.redis.jedis.hyperloglog;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * hyperloglog 可以用来去重, 并统计数量, 占用空间小
 * @author cosy-sun
 *
 */
@Service
public class Hyperloglog {

	@Autowired
	private JedisPool pool;
	
	private Jedis jedis = pool.getResource();
	
	public long pfadd(String key, String... value) {
		long pfadd = jedis.pfadd(key, value);
		return pfadd;
	}
	
	public long pfCount(String key) {
		long pfcount = jedis.pfcount(key);
		return pfcount;
	}
	
	public void pfmerger(String destKey, String... sourceKeys) {
		jedis.pfmerge(destKey, sourceKeys);
	}
	
}
