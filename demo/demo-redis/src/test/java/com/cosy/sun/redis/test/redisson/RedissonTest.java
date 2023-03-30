package com.cosy.sun.redis.test.redisson;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.redisson.api.RKeys;
import org.redisson.api.RedissonClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.cosy.sun.redis.redisson.BloomFilterByRedisson;
import com.cosy.sun.redis.redisson.DistributeLockByRedisson;

@SpringBootTest
@RunWith(SpringRunner.class)
public class RedissonTest {

	private static final Logger logger = LoggerFactory.getLogger(RedissonTest.class);

	@Autowired
	private RedissonClient client;

	@Autowired
	private BloomFilterByRedisson filter;

	@Autowired
	private DistributeLockByRedisson lock;

	@Test
	public void testLock() {
		for(int i = 0; i < 10; i ++) {
			lock.lock("redissonlock" + i);
		}
	}

	@Test
	public void testPing() {
		RKeys keys = client.getKeys();
		Iterable<String> keys2 = keys.getKeys();
		keys2.forEach(key -> {
			logger.info("key : {}", key);
		});
	}

	@Test
	public void testBloom() {
		boolean add = filter.add("szh");
		boolean contains = filter.contains("szh");
		boolean contains2 = filter.contains("szh1");
		logger.info("添加结果: {}, 判断szh结果{}, 判断szh1结果:{}", add, contains, contains2);
	}

}
