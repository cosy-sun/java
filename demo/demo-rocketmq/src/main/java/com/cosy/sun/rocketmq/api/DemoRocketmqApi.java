package com.cosy.sun.rocketmq.api;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient("rocketmq-api")
public interface DemoRocketmqApi {

}
