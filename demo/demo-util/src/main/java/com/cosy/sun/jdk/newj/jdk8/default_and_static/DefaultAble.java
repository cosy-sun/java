package com.cosy.sun.jdk.newj.jdk8.default_and_static;

import java.util.function.Supplier;

public interface DefaultAble {

	default void test() {
		
		System.out.println("default method!");
		
	}
	
	
	static DefaultAble test2(Supplier<DefaultAble> test) {
		DefaultAble defaultAble = test.get();
		System.out.println("default method static!");
		return defaultAble;
	}
	
}
