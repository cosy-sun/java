package com.cosy.sun.kafka.producer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

@Service
public class DemoKafkaProducer {
	
	private static final Logger log = LoggerFactory.getLogger(DemoKafkaProducer.class);
	
	@Autowired
	private KafkaTemplate<Integer, String> template;
	
	public void send(String topic, String msg) {
		ListenableFuture<SendResult<Integer,String>> send = template.send(topic, msg);
		send.addCallback(new ListenableFutureCallback<SendResult<Integer, String>>() {
			@Override
            public void onFailure(Throwable throwable) {
                log.error("send error,ex:{},topic:{},msg:{}",throwable,topic,msg);
            }

            @Override
            public void onSuccess(SendResult<Integer, String> stringStringSendResult) {
                log.info("send success,topic:{},msg:{}",topic,msg);
            }
		});
	}

}
