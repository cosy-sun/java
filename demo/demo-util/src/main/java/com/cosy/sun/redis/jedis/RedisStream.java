package com.cosy.sun.redis.jedis;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.StreamEntryID;
import redis.clients.jedis.resps.StreamEntry;

@Service
public class RedisStream {

	@Autowired
	private Jedis jedis;
	
	public String xAdd(String key, Map<String, String> map) {
		return jedis.xadd("key", StreamEntryID.NEW_ENTRY, map).toString();
	}
	
	public long xlen(String key) {
		return jedis.xlen(key);
	}
	
	public List<StreamEntry> xRange(String key) {
		return jedis.xrange(key, "-", "+", 10);
	}

	
}
