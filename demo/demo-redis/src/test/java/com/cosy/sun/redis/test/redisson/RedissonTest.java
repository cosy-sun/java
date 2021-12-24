package com.cosy.sun.redis.test.redisson;

import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.cosy.sun.redis.redisson.RedisOperatorByRedisson;

@SpringBootTest
@RunWith(SpringRunner.class)
public class RedissonTest {

	private static final Logger logger = LoggerFactory.getLogger(RedissonTest.class);
	
	@Autowired
	private RedisOperatorByRedisson redisson;
	
}
