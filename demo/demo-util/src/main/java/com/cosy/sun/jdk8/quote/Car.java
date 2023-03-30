package com.cosy.sun.jdk8.quote;

import java.util.function.Supplier;

public class Car {

	public static Car create(Supplier<Car> car) {
		return car.get();
	}
	
	public static void collide(final Car car)  {
		System.out.println(car.toString());
	}
	
	public void follow(Car another) {
		System.out.println(another.toString());
	}
	
	public void repair() {
		System.out.println();
	}
	
}
