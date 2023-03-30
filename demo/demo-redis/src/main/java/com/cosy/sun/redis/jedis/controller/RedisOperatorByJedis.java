//package com.cosy.sun.redis.jedis.controller;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.cosy.sun.api.redis.JedisOpApi;
//import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
//
//@RestController
//public class RedisOperatorByJedis implements JedisOpApi {
//
//	private static final Logger logger = LoggerFactory.getLogger(RedisOperatorByJedis.class);
//
//    @HystrixCommand(fallbackMethod = "fallbackCommon")
//    public String get(String key) {
//    	logger.info("redis 操作, key : {}", key);
//        return "test";
//    }
//
//    @SuppressWarnings("unused")
//	private String fallbackCommon(String key) {
//    	return "fallbackjedis";
//    }
//
//}
