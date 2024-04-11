package com.cosy.sun.rabbitmq.config;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DemoRabbitmqConfig {


	@Bean
	public SimpleRabbitListenerContainerFactory rabbitListenerContainerFactory(@Autowired ConnectionFactory connection) {
		SimpleRabbitListenerContainerFactory factory = new SimpleRabbitListenerContainerFactory();
		factory.setConnectionFactory(connection);
		factory.setConcurrentConsumers(3);
		factory.setMaxConcurrentConsumers(10);
		// factory.setAcknowledgeMode(AcknowledgeMode.MANUAL);//设置确认模式手工确认
		return factory;
	}
	
	@Bean
    public Queue myQueue1() {
        Queue queue = new Queue("queue1");
        return queue;
    }

}
