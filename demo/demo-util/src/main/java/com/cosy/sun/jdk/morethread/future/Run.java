package com.cosy.sun.jdk.morethread.future;

import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;

public class Run {

//	public static void main(String[] args) throws Exception {
//		MyCallable call = new MyCallable(100);
//		ThreadPoolExecutor executor = new ThreadPoolExecutor(2, 3, 5, TimeUnit.SECONDS,
//				new LinkedBlockingDeque<>());
//		Future<String> future = executor.submit(call);
//		System.out.println("main   "+System.currentTimeMillis());
//		System.out.println(future.get());
//		System.out.println("main end"+System.currentTimeMillis());
//	}
	
	public static void main(String[] args) throws Exception {
		Runnable runnable  = new Runnable() {
			
			@Override
			public void run() {
				System.out.println("end");
			}
		};
		ThreadPoolExecutor threadpool = (ThreadPoolExecutor) Executors.newCachedThreadPool();
		Future<?> future = threadpool.submit(runnable);
		System.out.println(future.get());
		System.out.println(future.isDone());
	}
	
}
