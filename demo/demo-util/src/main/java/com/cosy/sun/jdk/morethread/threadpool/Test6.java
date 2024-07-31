//package com.cosy.sun.jdk.morethread.threadpool;
//
//import java.util.concurrent.LinkedBlockingQueue;
//import java.util.concurrent.ThreadPoolExecutor;
//import java.util.concurrent.TimeUnit;
//
//public class Test6 {
//	public static void main(String[] args) throws InterruptedException{
//		Runnable runnable = new Runnable() {
//
//			@Override
//			public void run() {
//				try {
//					Thread.sleep(1000);
//					System.out.println(Thread.currentThread().getName() + "end!");
//				}catch(Exception e) {
//					e.printStackTrace();
//				}
//			}
//		};
//		ThreadPoolExecutor threadpool =
//				new ThreadPoolExecutor(2, 2, 5, TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>());
//		threadpool.execute(runnable);
//		threadpool.execute(runnable);
//		threadpool.execute(runnable);
//		threadpool.execute(runnable);
//		threadpool.execute(runnable);
//		threadpool.execute(runnable);
//		Thread.sleep(1000);
//		System.out.println(threadpool.getCompletedTaskCount());
//		Thread.sleep(1000);
//		System.out.println(threadpool.getCompletedTaskCount());
//		Thread.sleep(1000);
//		System.out.println(threadpool.getCompletedTaskCount());
//		Thread.sleep(1000);
//		System.out.println(threadpool.getCompletedTaskCount());
//		Thread.sleep(1000);
//		System.out.println(threadpool.getCompletedTaskCount());
//		Thread.sleep(1000);
//		System.out.println(threadpool.getCompletedTaskCount());
//		Thread.sleep(1000);
//		System.out.println(threadpool.getCompletedTaskCount());
//	}
//}
