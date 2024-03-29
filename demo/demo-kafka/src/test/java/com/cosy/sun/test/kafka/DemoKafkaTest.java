package com.cosy.sun.test.kafka;

import com.cosy.sun.kafka.DemoKafkaApplication;
import com.cosy.sun.kafka.producer.DemoKafkaProducer;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = DemoKafkaApplication.class)
public class DemoKafkaTest {

	@Autowired
	private DemoKafkaProducer producer;

	@Test
	public void test() {
		producer.send("topic1", "wo shi sun zhen hua !");
	}

}
