package com.cosy.sun.jdk.morethread.threadpool;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Test0 {
	public static void main(String[] args) throws InterruptedException {
		RunnableMy runnableMy = new RunnableMy();
		ThreadPoolExecutor executor = new ThreadPoolExecutor(7, 8, 5, TimeUnit.SECONDS,
				new LinkedBlockingDeque<Runnable>());
		executor.execute(runnableMy);
		executor.shutdown();
		System.out.println("main begin" + System.currentTimeMillis());
		System.out.println(executor.awaitTermination(10, TimeUnit.SECONDS));
		System.out.println("main end " + System.currentTimeMillis());

	}
}
