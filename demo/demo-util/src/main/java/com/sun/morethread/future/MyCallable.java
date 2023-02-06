package com.sun.morethread.future;

import java.util.concurrent.Callable;

public class MyCallable implements Callable<String> {

	private String username;
	private long sleepValue;
	
	public MyCallable(String username, long sleepValue) {
		this.username = username;
		this.sleepValue = sleepValue;
	}
	
	public String call() throws Exception {
		
		Thread.sleep(sleepValue);
		System.out.println(username + "sleep stop");
		return "username  ------run ------" + username;
	}
	
}
