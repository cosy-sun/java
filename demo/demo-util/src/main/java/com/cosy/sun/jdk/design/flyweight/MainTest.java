package com.cosy.sun.jdk.design.flyweight;

public class MainTest {

	public static void main(String[] args) {
		
		FlyWeightFactory factory = new FlyWeightFactory("factory name ");
		
		FlyWeight fa = factory.getFlyweight("fa");
		FlyWeight fb = factory.getFlyweight("fa");
		FlyWeight fc = factory.getFlyweight("fa");
		FlyWeight fd = factory.getFlyweight("fb");
		FlyWeight fe = factory.getFlyweight("fb");
		fa.operator(new Unshared("unshared fa 1"));
		fb.operator(new Unshared("unshared fa 2"));
		fc.operator(new Unshared("Unshared fa 3"));
		fd.operator(new Unshared("unshared fb 1"));
		fe.operator(new Unshared("unshared fb 2"));
	}
	
}
