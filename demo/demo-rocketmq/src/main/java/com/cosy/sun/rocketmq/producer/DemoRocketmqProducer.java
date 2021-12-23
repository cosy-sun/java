package com.cosy.sun.rocketmq.producer;

import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DemoRocketmqProducer {
	
	@Autowired
	private RocketMQTemplate template;
	
	public void send() {
		template.convertAndSend("demo-topic", "abcd1234");
	}

}
