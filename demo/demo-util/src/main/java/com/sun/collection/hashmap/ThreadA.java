package com.sun.collection.hashmap;

public class ThreadA extends Thread {

	private Service2 service;
	
	public ThreadA(Service2 service) {
		this.service = service;
	}
	
	public void run() {
		for(int i = 0; i < 50000; i ++) {
			service.table.put("ThreadA " + (i + 1), "ThreadA " + (i + 1));
			System.out.println("ThreadA " + (i + 1));
		}
	}
	
}

class ThreadB extends Thread {

	private Service2 service;
	
	public ThreadB(Service2 service) {
		this.service = service;
	}
	
	public void run() {
		for(int i = 0; i < 50000; i ++) {
			this.service.table.put("ThreadB " + (i + 1), "ThreadB " + (i + 1));
			System.out.println("ThreadB " + (i + 1));
		}
	}
	
}
