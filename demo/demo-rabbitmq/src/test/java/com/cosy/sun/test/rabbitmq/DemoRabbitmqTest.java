package com.cosy.sun.test.rabbitmq;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.cosy.sun.rabbitmq.DemoRabbitmqApplication;
import com.cosy.sun.rabbitmq.producer.DemoRabbitmqProducer;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = DemoRabbitmqApplication.class)
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
