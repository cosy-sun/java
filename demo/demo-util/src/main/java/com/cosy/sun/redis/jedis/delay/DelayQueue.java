package com.cosy.sun.redis.jedis.delay;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * redis实现延时队列
 * @author cosy-sun
 *
 *	lua script :
 * local key = KYES[1]
 * local min = ARGV[1]
 * local max = ARGV[2]
 * local result = redis.call('zrangebyscore', key, min, max, 'LIMIT', 0, 10);
 * if next(result) ~= nil and #result > 0 then
 * 		local count  = redis.call('zrem', key, unpack(result));
 *		if count > 0 then 
 *			return result;
 *		end
 *else
 *		return {}
 *end
 */
@Service
public class DelayQueue {

	private static final Logger logger = LoggerFactory.getLogger(DelayQueue.class);
	
	@Autowired
	private Jedis jedis;
	
	private static final String key = "com:cosy:sun:delayQueue";
	
	
	/**
	 * 延时队列生产者
	 * @param value
	 * @param delayTime 延时时间
	 */
	public void producer(String value, double delayTime) {
		jedis.zadd(key.getBytes(), System.currentTimeMillis() + delayTime, value.getBytes());
	}
	
//	@Scheduled(cron = "*/1 * * * * *")
//	public void consumer() {
//		List<byte[]> zrange = jedis.zrangeByScore(key.getBytes(), 0, System.currentTimeMillis());
//		zrange.forEach(item -> {
//			jedis.zrem(key.getBytes(), item);
//			String value = new String(item);
//			logger.info(value);
//		});
//		
//	}
	
//	@Scheduled(cron = "*/1 * * * * *")
	public void consumerLua() {
		String script = "local key = KEYS[1]"
				+ "local min = ARGV[1]"
				+ "local max = ARGV[2]"
				+ "local result = redis.call('zrangebyscore', key, min, max, 'LIMIT', 0, 2);"
				+ "if next(result) ~= nil and #result > 0 then"
				+ "	   local count  = redis.call('zrem', key, unpack(result));"
				+ "	   if count > 0 then "
				+ "		   return result;"
				+ "    end "
				+ "else"
				+ "	   return {} "
				+ "end";
		List<String> argv = new ArrayList<>();
		argv.add("0");
		argv.add(System.currentTimeMillis() + "");
		Object eval = jedis.eval(script, Collections.singletonList(key), argv);
		logger.info("result : {}", eval);
	}
	
}
