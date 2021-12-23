package com.sun.morethread.onAdvance;

public class ThreadB extends Thread{
	
	private  MyService service;
	
	public ThreadB(MyService service) {
		this.service = service;
	}
	
	public void run() {
		service.testMethod();
	}

}
