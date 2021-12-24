package com.cosy.sun.redis.jedis;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RestController;

import com.cosy.sun.api.redis.JedisOpApi;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
public class RedisOperatorByJedis implements JedisOpApi {

	private static final Logger logger = LoggerFactory.getLogger(RedisOperatorByJedis.class);
	
    @Override
    @HystrixCommand(fallbackMethod = "get")
    public String get(String key) {
    	logger.info("redis 操作, key : {}", key);
        return "test";
    }
    
    private String get() {
    	return "fallbackjedis";
    }

}
