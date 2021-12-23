package com.sun.morethread.threadpool;

import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Run3 {

	public static void main(String[] args) {
		ThreadPoolExecutor executor = new ThreadPoolExecutor(7, 10, 0L, TimeUnit.SECONDS,
				new SynchronousQueue<Runnable>());
		Runnable runnable = new Runnable() {
			public void run() {
				System.out.println(Thread.currentThread().getName() + "run!" + System.currentTimeMillis());
				try {

					Thread.sleep(1000);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		};
		
		executor.execute(runnable);
		executor.execute(runnable);
		executor.execute(runnable);
		executor.execute(runnable);
		executor.execute(runnable);
		executor.execute(runnable);
		executor.execute(runnable);
		executor.execute(runnable);
		executor.execute(runnable);
		executor.execute(new Runnable() {
			public void run(){
				System.out.println("指定的长时间");
				for(int i=0;i<Integer.MAX_VALUE;i++) {
					sss(i);
				}
			}
		});
		
		for (int i = 0; i < 10; i++) {
			System.out.println("-------------------"+i);
			try {
				Thread.sleep(1000);
			} catch (Exception e) {
				e.printStackTrace();
			}
			System.out.println("B:" + executor.getCorePoolSize());
			System.out.println("B:" + executor.getPoolSize());
			System.out.println("B:" + executor.getQueue().size());
		}

	}
	
	public static int sss(int i) {
		int a = 0;
		for(int n=1;n<=i;n++) {
			a=n*n;
			a+=a;
		}
		return a;
	}
}
