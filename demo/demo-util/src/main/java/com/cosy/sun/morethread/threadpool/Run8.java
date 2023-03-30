package com.cosy.sun.morethread.threadpool;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Run8 {

	public static void main(String[] args) throws InterruptedException{
		ThreadPoolExecutor executor = new ThreadPoolExecutor(2, 8, 5, TimeUnit.SECONDS, 
				new LinkedBlockingDeque<Runnable>());
		RunnableMy my = new RunnableMy();
		executor.execute(my);
		executor.execute(my);
		executor.execute(my);
		executor.execute(my);
		System.out.println("pool isTerminal"+executor.isTerminated());
		executor.shutdown();
		Thread.sleep(1000);
		System.out.println("        "+executor.isTerminated());
		Thread.sleep(1000);
		System.out.println("        "+executor.isTerminated());
		Thread.sleep(1000);
		System.out.println("        "+executor.isTerminated());
		Thread.sleep(1000);
		System.out.println("        "+executor.isTerminated());
		
		
	}
	
}
