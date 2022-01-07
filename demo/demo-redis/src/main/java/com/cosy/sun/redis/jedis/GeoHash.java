package com.cosy.sun.redis.jedis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import redis.clients.jedis.Jedis;

@Service
public class GeoHash {

	@Autowired
	private Jedis jedis;
	
	public void getAdd() {
		jedis.geoadd("geo", 116.48105, 39.996794, "ireader");
	}
	
}
