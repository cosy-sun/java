package com.jdk8.test;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import com.jdk8.quote.Car;

public class QuoteTest {

	@Test
	public void test() {
		Car create = Car.create(Car :: new ) ;
		System.out.println(create.toString());
		
		List<Car> list = Arrays.asList(create);
		list.forEach(Car :: collide);
		
		list.forEach(Car :: repair);
		
		Car test = Car.create(Car :: new ) ;
		
		list.forEach(test :: follow);
	}
	
}
