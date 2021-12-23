package com.sun.morethread.executorservice;

import java.util.concurrent.Callable;

public class Callablee implements Callable<String> {

	public String call() throws InterruptedException {
		System.out.println(Thread.currentThread().getName()+" begin");
		Thread.sleep(5000);
		System.out.println(Thread.currentThread().getName()+" end");
		return "callablee";
	}
	
}

class callablee1 implements Callable<String> {
	public String call() throws InterruptedException {
		System.out.println(Thread.currentThread().getName()+" begin");
		Thread.sleep(5000);
		System.out.println(Thread.currentThread().getName()+" end");
		return "callablee1";
	}
}