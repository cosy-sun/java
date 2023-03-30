package com.cosy.sun.morethread.threadpool;

import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Test5 {

	public static void main(String[] args) throws InterruptedException{
		ThreadPoolExecutor threadpool = new ThreadPoolExecutor(
				4, 5, 5, TimeUnit.SECONDS, new SynchronousQueue<Runnable>());
//		threadpool.allowCoreThreadTimeOut(true);
		System.out.println(threadpool.allowsCoreThreadTimeOut());
		for(int i=0;i<4;i++) {
			RunnableMy runnable = new RunnableMy();
			threadpool.execute(runnable);
		}
		
		Thread.sleep(8000);
		System.out.println(threadpool.getPoolSize());
	}
	
}
