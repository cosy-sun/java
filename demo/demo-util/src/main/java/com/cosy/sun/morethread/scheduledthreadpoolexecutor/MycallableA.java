package com.cosy.sun.morethread.scheduledthreadpoolexecutor;

import java.util.concurrent.Callable;

public class MycallableA implements Callable<String> {

	public String call() throws InterruptedException {
		System.out.println("begin"+Thread.currentThread().getName()+" 111  "+System.currentTimeMillis());
		Thread.sleep(3000);
		System.out.println("end"+Thread.currentThread().getName()+" 111  "+System.currentTimeMillis());
		return "MycallableA";
	}
	
}

class MycallableB implements Callable<String> {

	public String call() throws InterruptedException {
		System.out.println("begin"+Thread.currentThread().getName()+" 222  "+System.currentTimeMillis());
		System.out.println("end"+Thread.currentThread().getName()+" 222  "+System.currentTimeMillis());
		return "MycallableB";
	}
	
}