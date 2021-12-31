package com.cosy.sun.redis.jedis;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import redis.clients.jedis.JedisPool;
import redis.clients.jedis.StreamEntryID;
import redis.clients.jedis.resps.StreamEntry;

@Service
public class RedisStream {

	@Autowired
	private JedisPool pool;
	
	public String xAdd(String key, Map<String, String> map) {
		return pool.getResource().xadd("key", StreamEntryID.NEW_ENTRY, map).toString();
	}
	
	public long xlen(String key) {
		return pool.getResource().xlen(key);
	}
	
	public List<StreamEntry> xRange(String key) {
		return pool.getResource().xrange(key, "-", "+", 10);
	}

	
}
