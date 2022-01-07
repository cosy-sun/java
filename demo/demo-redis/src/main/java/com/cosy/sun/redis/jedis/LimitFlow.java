package com.cosy.sun.redis.jedis;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.hutool.core.lang.UUID;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.Pipeline;
import redis.clients.jedis.Response;

@Service
public class LimitFlow {
	
	@Autowired
	private Jedis jedis;
	
	public boolean limitFlow() {
		long del = System.currentTimeMillis() - 10;
		Pipeline pipelined = jedis.pipelined();
		Response<List<String>> zrangeByScore = pipelined.zrangeByScore("com:cosy:sun:limit:flow", del, System.currentTimeMillis());
		jedis.zremrangeByScore("com:cosy:sun:limit:flow", 0, del);
		pipelined.sync();
		if(zrangeByScore.get().size() >= 10) {
			return false;
		}
		jedis.zadd("com:cosy:sun:limit:flow", System.currentTimeMillis(), UUID.randomUUID().toString());
		return true;
	}

}
