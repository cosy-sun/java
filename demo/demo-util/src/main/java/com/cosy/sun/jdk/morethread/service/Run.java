package com.cosy.sun.jdk.morethread.service;

public class Run {

	public static void main(String[] args) throws Exception{
		MyService service  =  new MyService();
		MyThread thread = new MyThread(service);
		thread.start();
		Thread.sleep(2000);
		service.downMethod();
		
	}
	
}
