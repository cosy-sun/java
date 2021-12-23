package com.sun;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cosy.sun.redis.api.JedisOpApi;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@SpringBootApplication
@RestController
@Api("simplebootapp")
public class SimplebootprojectApplication {

	private static final Logger logger = LoggerFactory.getLogger(SimplebootprojectApplication.class);
	
	public static void main(String[] args) {
		logger.info("**********************************");
		SpringApplication.run(SimplebootprojectApplication.class, args);
	}
	
	@Autowired
	private JedisOpApi jedis;
	
	@HystrixCommand(fallbackMethod = "get")
	@GetMapping("value")
	@ApiOperation("gettest")
	public Object get() {
		String string = jedis.get();
		logger.info("call demo-redis, result: {}", string);
		return string;
	}

}
