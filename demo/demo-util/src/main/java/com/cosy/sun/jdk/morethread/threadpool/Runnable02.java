package com.cosy.sun.jdk.morethread.threadpool;

public class Runnable02 implements Runnable{

	@SuppressWarnings("null")
	@Override
	public void run() {
		
			System.out.println("begin" + Thread.currentThread().getName()+System.currentTimeMillis());
			String abc = null;
			abc.indexOf(0);
//			throw new RuntimeException("sssssss");
		
	}

}
