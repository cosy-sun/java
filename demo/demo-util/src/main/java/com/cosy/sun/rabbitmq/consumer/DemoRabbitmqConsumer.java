package com.cosy.sun.rabbitmq.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "queue1")
public class DemoRabbitmqConsumer {

	@RabbitHandler
	public void handler(String msg) {
		System.out.println(msg);
	}
	
}
