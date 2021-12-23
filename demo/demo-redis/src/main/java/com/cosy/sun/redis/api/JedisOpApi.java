package com.cosy.sun.redis.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient("demo-redis")
public interface JedisOpApi {

	@RequestMapping("/jedis-get")
	public String get();
	
}
