package com.cosy.sun.api.redis;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

//@FeignClient("demo-redis")
public interface JedisOpApi {

	@RequestMapping("/jedis-get")
	public String get(@RequestParam("key") String key);
	
}
