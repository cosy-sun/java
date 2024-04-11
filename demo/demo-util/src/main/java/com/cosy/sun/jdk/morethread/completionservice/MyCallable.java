package com.cosy.sun.jdk.morethread.completionservice;

import java.util.concurrent.Callable;

public class MyCallable implements Callable<String>{

	private String username;
	private long sleepValue;
	
	public MyCallable(String username, long sleepvalue) {
		this.username = username;
		this.sleepValue = sleepvalue;
	}
	
	public String call() throws InterruptedException{
		System.out.println(username);
		Thread.sleep(sleepValue);
		return "return " + username;
	}
	
}
