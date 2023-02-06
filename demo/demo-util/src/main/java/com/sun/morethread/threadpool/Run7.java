package com.sun.morethread.threadpool;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Run7 {

	public static void main(String[] args) {
		ThreadPoolExecutor executor = new ThreadPoolExecutor(7, 8, 5, TimeUnit.SECONDS, new LinkedBlockingDeque<Runnable>());
		executor.execute(new Runnable() {
			
			@Override
			public void run() {

				System.out.println("begin");
				try {
					Thread.sleep(1000);
				}catch(Exception e) {
					e.printStackTrace();
				}
				System.out.println("end");
				
			}
		});
		
		System.out.println(executor.isShutdown());
		executor.shutdown();
		System.out.println(executor.isShutdown());
	}
	
}
