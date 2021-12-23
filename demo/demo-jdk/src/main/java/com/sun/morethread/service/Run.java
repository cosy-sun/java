package com.sun.morethread.service;

public class Run {

	public static void main(String[] args) throws Exception{
		MyService service  =  new MyService();
		MyThread thread = new MyThread(service);
		thread.start();
		thread.sleep(2000);
		service.downMethod();
		
	}
	
}
