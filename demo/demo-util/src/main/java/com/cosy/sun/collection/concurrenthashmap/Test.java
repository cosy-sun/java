package com.cosy.sun.collection.concurrenthashmap;

public class Test {
	public static void main(String[] args) {
		Service service = new Service();
		
		Thread_test threa_test = new Thread_test(service);
		Thread_test1 thread_test1 = new Thread_test1(service);
		
		threa_test.start();
		thread_test1.start();
		
		System.out.println("szh");
	}
}
