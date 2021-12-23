package com.cosy.sun.rabbitmq.api;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient("producer-api")
public interface DemoRabbitmqProducerApi {

}
