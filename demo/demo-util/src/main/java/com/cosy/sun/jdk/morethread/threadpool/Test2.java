package com.cosy.sun.jdk.morethread.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Test2 {

	public static void main(String[] args) {
		Runnable02 command = new Runnable02();
		ExecutorService service = Executors.newCachedThreadPool(new ThreadFactory02());
		service.execute(command);
	}
	
}
