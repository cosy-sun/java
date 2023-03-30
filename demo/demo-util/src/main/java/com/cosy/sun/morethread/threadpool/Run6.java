package com.cosy.sun.morethread.threadpool;

import java.util.List;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Run6 {

	public static void main(String[] args) throws Exception{
		@SuppressWarnings("unused")
		Runnable1 runnable1 = new Runnable1();
		ThreadPoolExecutor executor = new ThreadPoolExecutor(2, 999, 9999L, TimeUnit.SECONDS,
				new LinkedBlockingDeque<Runnable>());
		for(int i=0;i<4;i++) {
			executor.execute(new Runnable1());
		}
		
		Thread.sleep(1000);
		List<Runnable> shutdownNow = executor.shutdownNow();
		for(Runnable r: shutdownNow) {
			System.out.println(r.toString());
		}
	}
	
}
