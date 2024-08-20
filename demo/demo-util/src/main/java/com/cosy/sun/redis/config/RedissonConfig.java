package com.cosy.sun.redis.config;

import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.redisson.config.TransportMode;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RedissonConfig {
	
	@Bean
	public RedissonClient redissonClient() {
		Config config = new Config();
		config.setTransportMode(TransportMode.NIO);
		config.useSingleServer().setAddress("redis://172.17.0.1:6379");
		return Redisson.create(config);
	}
}
