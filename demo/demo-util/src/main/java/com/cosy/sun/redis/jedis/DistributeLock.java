package com.cosy.sun.redis.jedis;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.params.SetParams;

/**
 * redis实现分布式锁
 * @author cosy-sun
 *
 */
@Service
public class DistributeLock {

	private static final String LOCK_SUCCESS = "OK";
	private static final long RELEASE_SUCCESS = 1L;
	private ThreadLocal<Map<String, Integer>> locks = new ThreadLocal<>();
	
	@Autowired
	private Jedis jedis;
	
	/**
	 * 获取锁
	 * 
	 * @param lockKey key
	 * @param value 请求id或者锁的值
	 * @param expireTime 过期时间,毫秒
	 * @return
	 */
	private boolean _tryLock(String lockKey, String value, int expireTime) {
		SetParams px = SetParams.setParams().nx().px(expireTime);
		return LOCK_SUCCESS.equals(jedis.set(lockKey, value, px));
	}
	
	private Map<String, Integer> currentLock() {
		Map<String, Integer> map = locks.get();
		if(map != null) {
			return map;
		}
		locks.set(new HashMap<>());
		return locks.get();
	}
	
	public boolean tryLock(String lockKey, String value, int expireTime) {
		Map<String, Integer> currentLock = currentLock();
		Integer currentLockCount = currentLock.get(lockKey);
		if(currentLockCount != null) {
			currentLock.put(lockKey, currentLockCount + 1);
			return true;
		}
		boolean _tryLock = _tryLock(lockKey, value, expireTime);
		if(_tryLock) {
			currentLock.put(lockKey, 1);
		}
		return _tryLock;
		
	}
	
	/**
	 * 释放锁
	 * @param lockKey key
	 * @param value 锁的值
	 * @return
	 */
	private boolean _tryRelease(String lockKey, String value) {
		String scrpit = "if redis.call('get', KEYS[1]) == ARGV[1] then return redis.call('del', KEYS[1]) else return 0 end";
		Object eval = jedis.eval(scrpit, Collections.singletonList(lockKey), Collections.singletonList(value));
		return eval.equals(RELEASE_SUCCESS);
	}
	
	public boolean tryRelease(String lockKey, String vlaue) {
		Map<String, Integer> currentLock = currentLock();
		Integer integer = currentLock.get(lockKey);
		if(integer == null) {
			return false;
		}
		integer -= 1;
		if(integer > 0) {
			currentLock.put(lockKey, integer);
			return false;
		} else {
			currentLock.remove(lockKey);
			_tryRelease(lockKey, vlaue);
		}
		return true;
	}
	
}
