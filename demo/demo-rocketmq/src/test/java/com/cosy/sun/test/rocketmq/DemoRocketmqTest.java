package com.cosy.sun.test.rocketmq;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.cosy.sun.rocketmq.DemoRocketmqApplication;
import com.cosy.sun.rocketmq.producer.DemoRocketmqProducer;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = DemoRocketmqApplication.class)
public class DemoRocketmqTest {

	@Autowired
	private DemoRocketmqProducer producer;

	@Test
	public void test() {
		try {
			producer.send();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

}
