package com.cosy.sun.kafka.consumer;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class DemoKafkaConsumer {
	
	private static final Logger logger = LoggerFactory.getLogger(DemoKafkaConsumer.class);

	@KafkaListener(topics = "topic1", groupId = "group1")
	public void handler(ConsumerRecord<Integer,String> record) {
		logger.info("接受消息{},{}",record.topic(), record.value());
	}
	
}
