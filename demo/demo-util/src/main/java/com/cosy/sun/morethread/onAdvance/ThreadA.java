package com.cosy.sun.morethread.onAdvance;

public class ThreadA extends Thread{
	
	private MyService service;
	
	public ThreadA(MyService service) {
		this.service = service;
	}
	
	public void run() {
		service.testMethod();
	}

}
