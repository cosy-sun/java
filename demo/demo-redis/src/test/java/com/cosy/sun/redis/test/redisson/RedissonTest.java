package com.cosy.sun.redis.test.redisson;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.cosy.sun.redis.redisson.RedisOperatorByRedisson;

@SpringBootTest
@RunWith(SpringRunner.class)
public class RedissonTest {

	@Autowired
	private RedisOperatorByRedisson redisson;
	
	@Test
	public void testSet() {
		redisson.set(null, null);
	}
	
}
