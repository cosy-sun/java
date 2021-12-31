//package com.sun.stream;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.cloud.stream.annotation.EnableBinding;
//import org.springframework.messaging.support.MessageBuilder;
//
//@EnableBinding(ChannelProducer.class)
//public class RabbitMqStreamProduce {
//
//	@Autowired
//	private ChannelProducer channel;
//	
//	public String send() {
//		channel.channel().send(MessageBuilder.withPayload("").build());
//		return "";
//	}
//	
//}
