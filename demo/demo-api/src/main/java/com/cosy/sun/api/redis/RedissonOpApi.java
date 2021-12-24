package com.cosy.sun.api.redis;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient("redisson-api")
public interface RedissonOpApi {

}
