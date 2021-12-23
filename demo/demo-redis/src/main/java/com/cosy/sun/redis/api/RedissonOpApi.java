package com.cosy.sun.redis.api;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient("redisson-api")
public interface RedissonOpApi {

}
