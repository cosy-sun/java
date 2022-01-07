package com.cosy.sun.redis.test.jedis;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.cosy.sun.redis.DemoRedisApplication;
import com.cosy.sun.redis.jedis.DistributeLock;
import com.cosy.sun.redis.jedis.GeoHash;
import com.cosy.sun.redis.jedis.RedisStream;
import com.cosy.sun.redis.jedis.delay.DelayQueue;
import com.cosy.sun.redis.jedis.pubsub.DemoPublish;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = DemoRedisApplication.class)
public class JedisTest {

	private static final Logger logger = LoggerFactory.getLogger(JedisTest.class);
	
	@Autowired
	private RedisStream stream;
	
	@Autowired
	private DelayQueue queue;
	
	@Autowired
	private DemoPublish publish;
	
	@Autowired
	private DistributeLock lock;
	
	@Autowired
	private GeoHash geo;
	
	@Test
	public void geoHash() {
		geo.getAdd();
	}
	
	@Test
	public void testDistributeLock() {
		boolean tryLock = lock.tryLock("szh", "123456", 100);
		logger.info("加锁结果: {}", tryLock);
		boolean tryLock1 = lock.tryLock("szh", "123456", 100);
		logger.info("加锁结果: {}", tryLock1);
		boolean tryRelease = lock.tryRelease("szh", "123");
		logger.info("错误内容, 解锁结果: {}", tryRelease);
		boolean release = lock.tryRelease("szh", "123456");
		logger.info("正确内容, 解锁结果: {}", release);
	}
	
	@Test
	public void publish() {
		for(int i = 0; i < 10; i ++) {
			publish.publish("testchannel", "测试消息" + i);
		}
	}
	
	@Test
	public void streamXadd() {
		Map<String, String> hashMap = new HashMap<>();
		hashMap.put("szh", "abcfg");
		hashMap.put("szh1", "abcfg");
		hashMap.put("szh2", "abcfg");
		String xAdd = stream.xAdd("key", hashMap);
		logger.info("xadd方法调用后, 返回id: {}", xAdd);
	}
	
	@Test
	public void streamXlen() {
		long xlen = stream.xlen("key");
		logger.info("xlen方法调用后, 返回: {}", xlen);
	}
	
	@Test
	public void testXrange() {
		stream.xRange("key").forEach(item -> {
			item.getFields().forEach((key, value) -> {
				logger.info("id: {} === key : {}, value: {}", item.getID(), key, value);
			});
		});
		
	}
	
	@Test
	public void testProducer() {
		for(int i = 0; i< 100; i ++) {
			queue.producer("e3d4frdrfjwoghef" + i, System.currentTimeMillis()+i);
		}
	}
	
}
