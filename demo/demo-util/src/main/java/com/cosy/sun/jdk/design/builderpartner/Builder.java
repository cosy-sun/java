package com.cosy.sun.jdk.design.builderpartner;

public class Builder {

	private Car<?> car;
	
	public Builder(Car<?> car) {
		this.car = car;
	}
	
	public void constract() {
		car.builderDoor();
		car.builderCarBody();
		car.builderTyre();
	}
	
}
