package com.cosy.sun.rabbitmq.producer;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DemoRabbitmqProducer {

	@Autowired
	private AmqpTemplate template;
	
	public void send() {
		template.convertAndSend("queue1", "abcd1234");
	}
	
}
