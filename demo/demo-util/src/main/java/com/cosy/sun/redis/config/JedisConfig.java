package com.cosy.sun.redis.config;

import com.cosy.sun.redis.jedis.pubsub.DemoSubscrib;
import jakarta.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableMBeanExport;
import org.springframework.jmx.support.RegistrationPolicy;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Configuration
@EnableMBeanExport(registration = RegistrationPolicy.IGNORE_EXISTING)
public class JedisConfig {

	private static final Logger logger = LoggerFactory.getLogger(JedisConfig.class);

	@Autowired
	private DemoSubscrib demoSubScribe;



	@Bean
	public JedisPool jedisPool() {
		JedisPool pool =  new JedisPool("localhost", 6379);
		pool.setMaxIdle(10);
		pool.setMaxTotal(10);
		return pool;
	}

	@Bean
	public Jedis jedis() {
		Jedis resource = jedisPool().getResource();
		return resource;
	}

	@PostConstruct
	public void pubSub() {
		logger.info("启动的时候订阅channel");
		ExecutorService newSingleThreadExecutor = Executors.newSingleThreadExecutor();
		newSingleThreadExecutor.execute(() -> {
			jedisPool().getResource().subscribe(demoSubScribe, "testchannel");
		});
	}

}
