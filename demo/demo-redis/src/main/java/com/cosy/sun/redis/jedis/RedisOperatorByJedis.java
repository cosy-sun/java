package com.cosy.sun.redis.jedis;

import org.springframework.web.bind.annotation.RestController;

import com.cosy.sun.redis.api.JedisOpApi;

@RestController
public class RedisOperatorByJedis implements JedisOpApi {

	@Override
	public String get() {
		return "test";
	}

}
