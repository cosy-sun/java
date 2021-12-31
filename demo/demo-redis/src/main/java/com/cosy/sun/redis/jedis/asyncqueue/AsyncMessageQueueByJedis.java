package com.cosy.sun.redis.jedis.asyncqueue;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Service;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * 基于redis的异步消费
 * 
 * @author cosy-sun
 *
 */
@Service
public class AsyncMessageQueueByJedis {

	private static final Logger logger = LoggerFactory.getLogger(AsyncMessageQueueByJedis.class);

	private ThreadLocal<Set<Long>> threadId = new ThreadLocal<>();
	
	@Autowired
	private JedisPool pool;

	@Autowired
	private ThreadPoolTaskExecutor threadPool;

	/**
	 * 生产
	 * 
	 * @param queue
	 * @param message
	 * @return
	 */
	public boolean producer(String queue, String... message) {
		Jedis resource = pool.getResource();
		resource.lpush(queue, message);
		logger.info("数据 : {} 成功加入异步队列: {}", message, queue);
		return true;
	}

	/**
	 * 消费
	 * @param queue
	 * @param consumer
	 * @throws Exception
	 */
	public void consumer(String queue, Consumer<String> consumer) {
		try {
			List<String> brpop = pool.getResource().brpop(1000, queue);
			threadPool.execute(() -> {
				brpop.forEach(item -> {
					try {
						long threadId = Thread.currentThread().getId();
						threadLocalSet().add(threadId);
						pool.getResource().zadd("doing", threadId, item + System.currentTimeMillis());
						consumer.accept(item);
						pool.getResource().zrem(queue, item);
						threadLocalSet().remove(threadId);
					} catch(Exception e) {
						pool.getResource().zrem(queue, item);
						producer(queue, item);
					}
				});
			});
			logger.info("数据: {} 成功被消费: {}", queue, consumer.toString());
		} catch (Exception e) {
			logger.error("queue: {} 阻塞消费异常", queue, e);
			consumer(queue, consumer);
		}
	}

	private Set<Long> threadLocalSet() {
		Set<Long> set = threadId.get();
		if(set == null) {
			threadId.set(new HashSet<>());
		}
		return threadId.get();
	}
	
	@Scheduled(cron = "*/1 * * * * *")
	public void scanQueueNoHandler() {
		pool.getResource().zrangeByScore("doing", 0, -1).forEach(item -> {
			long zscore = pool.getResource().zscore("doing", item).longValue();
			boolean contains = threadLocalSet().contains(zscore);
			if(!contains) {
				pool.getResource().zrem("doing", item);
				producer("", item);
			}
		});
		
	}
}
