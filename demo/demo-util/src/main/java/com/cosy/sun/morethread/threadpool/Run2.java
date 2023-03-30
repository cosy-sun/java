package com.cosy.sun.morethread.threadpool;

import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Run2 {

	public static void main(String[] args) {
		ThreadPoolExecutor executor = new ThreadPoolExecutor(7, 8, 5, TimeUnit.SECONDS,
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
		try {
			Thread.sleep(300);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("A:" + executor.getCorePoolSize());
		System.out.println("A:" + executor.getPoolSize());
		System.out.println("A:" + executor.getQueue().size());
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
}
