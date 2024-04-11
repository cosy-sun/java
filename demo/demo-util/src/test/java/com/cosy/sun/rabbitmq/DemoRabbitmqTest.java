package com.cosy.sun.rabbitmq;

import com.cosy.sun.rabbitmq.producer.DemoRabbitmqProducer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class DemoRabbitmqTest {

	@Autowired
	private DemoRabbitmqProducer producer;

	@Test
	public void test() {
		for(int i =0; i< 100; i ++) {
			producer.send();
		}
	}

}
