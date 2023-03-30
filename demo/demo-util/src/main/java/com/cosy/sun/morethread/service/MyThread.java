package com.cosy.sun.morethread.service;

public class MyThread extends Thread{
	
	private MyService service = new MyService();
	
	public MyThread(MyService service) {
		this.service = service;
	}
	
	public void run() {
		service.testMethod();
	}

}
