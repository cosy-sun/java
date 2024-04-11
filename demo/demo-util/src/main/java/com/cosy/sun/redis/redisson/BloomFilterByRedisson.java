package com.cosy.sun.redis.redisson;

import org.redisson.api.RBloomFilter;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BloomFilterByRedisson {

	@Autowired
	private RedissonClient client;
	
	public boolean add(String value) {
		RBloomFilter<Object> bloomFilter = client.getBloomFilter("bloomFilter");
		bloomFilter.tryInit(10000, 0.01);
		boolean add = bloomFilter.add(value);
		return add;
	}
	
	public boolean contains(String value) {
		RBloomFilter<Object> bloomFilter = client.getBloomFilter("bloomFilter");
		boolean contains = bloomFilter.contains(value);
		return contains;
	}

}