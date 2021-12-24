package com.cosy.sun.api.redis;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient("demo-redis")
public interface JedisOpApi {

	@RequestMapping("/jedis-get")
	public String get(@RequestBody String key);
	
}
