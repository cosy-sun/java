package com.sun.collection.concurrenthashmap;

public class Thread_test extends Thread {

	private Service service;
	
	public Thread_test(Service service) {
		this.service = service;
	}
	
	public void run() {
		for(int i = 0; i < 50000; i ++) {
			service.concurrenthashmap.put("ThreadA " + (i + 1), "ThreadA " + (i + 1));
			System.out.println("ThreadA " + (i + 1));
		}
	}
	
}

class Thread_test1 extends Thread {

	private Service service;
	
	public Thread_test1(Service service) {
		this.service = service;
	}
	
	public void run() {
		for(int i = 0; i < 50000; i ++) {
			this.service.concurrenthashmap.put("ThreadB " + (i + 1), "ThreadB " + (i + 1));
			System.out.println("ThreadB " + (i + 1));
		}
	}
	
}
