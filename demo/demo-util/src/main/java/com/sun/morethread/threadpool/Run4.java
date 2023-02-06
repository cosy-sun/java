package com.sun.morethread.threadpool;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Run4 {

	public static void main(String[] args) throws Exception{
		RunnableMy runnable = new RunnableMy();
		ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(7, 8, 5, TimeUnit.SECONDS, new LinkedBlockingDeque<Runnable>());
		
		threadPoolExecutor.execute(runnable);
		threadPoolExecutor.execute(runnable);
		threadPoolExecutor.execute(runnable);
		threadPoolExecutor.execute(runnable);
		Thread.sleep(1000);
		threadPoolExecutor.shutdown();
		threadPoolExecutor.execute(runnable);
		System.out.println("end");
		
//		threadPoolExecutor.shutdown();
		
		System.out.println("main end");
		
	}
	
}
