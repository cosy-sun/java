//package com.sun.stream;
//
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.cloud.stream.annotation.EnableBinding;
//import org.springframework.cloud.stream.annotation.StreamListener;
//import org.springframework.cloud.stream.messaging.Sink;
//import org.springframework.messaging.Message;
//
//@EnableBinding(Sink.class)
//public class RabbitMqStreamConsume {
//
//	@Value("${server.port}")
//	private String port;
//	
//	@StreamListener(Sink.INPUT)
//	public void consume(Message<String> message) {
//		String payload = message.getPayload();
//	}
//	
//}
