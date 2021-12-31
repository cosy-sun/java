package com.cosy.sun.redis.redisson;

import com.cosy.sun.api.redis.RedissonOpApi;
import org.redisson.api.RSet;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RedisOperatorByRedisson implements RedissonOpApi {
	
	@Autowired
	private RedissonClient redissonClient;
	
	public void set(String key, String value) {
		RSet<Object> set = redissonClient.getSet("test");
		set.add("abc");
	}

	public void lock() {
	}
	
}
