package com.cosy.sun.rabbitmq.api;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient("consumer-api")
public interface DemoRabbitmqConsumerApi {

}
