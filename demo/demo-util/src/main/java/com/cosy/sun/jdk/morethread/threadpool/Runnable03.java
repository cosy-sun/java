package com.cosy.sun.jdk.morethread.threadpool;

public class Runnable03 implements Runnable{

	private String userName;
	
	public Runnable03(String username) {
		this.userName = username;
	}
	
	public void setUserName(String name) {
		this.userName = name;
	}
	
	public String getUserName() {
		return this.userName;
	}
	
	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName() + getUserName() + System.currentTimeMillis());
		try {
			Thread.sleep(4000);
		}catch(Exception e) {
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName() + getUserName() + System.currentTimeMillis());     
	}

}
