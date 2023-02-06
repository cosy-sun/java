package com.cosy.sun.redis.redisson;

import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DistributeLockByRedisson {

	@Autowired
	private RedissonClient client;
	
	public void lock(String lockName) {
		RLock lock = client.getLock(lockName);
		lock.lock();
	}
	
	public void unlock(String lockName) {
		RLock lock = client.getLock(lockName);
		lock.unlock();
	}
}
