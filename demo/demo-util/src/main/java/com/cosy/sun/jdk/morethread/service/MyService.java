package com.cosy.sun.jdk.morethread.service;

import java.util.concurrent.CountDownLatch;

public class MyService {

	private CountDownLatch down = new CountDownLatch(1);
	
	public void testMethod() {
		try {
			System.out.println("a");
			down.await();
			System.out.println("b");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void downMethod() {
		System.out.println("down");
		down.countDown();
	}
	
}
