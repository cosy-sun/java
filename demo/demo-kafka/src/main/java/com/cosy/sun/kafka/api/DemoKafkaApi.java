package com.cosy.sun.kafka.api;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient("kafka-api")
public interface DemoKafkaApi {

}
