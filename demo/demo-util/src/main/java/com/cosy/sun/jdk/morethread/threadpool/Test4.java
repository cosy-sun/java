//package com.cosy.sun.jdk.morethread.threadpool;
//
//import java.util.concurrent.SynchronousQueue;
//import java.util.concurrent.ThreadPoolExecutor;
//import java.util.concurrent.TimeUnit;
//
//public class Test4 {
//
//	public static void main(String[] args) {
//		Runnable03 runnable1 = new Runnable03("china one");
//		Runnable03 runnable2 = new Runnable03("china two");
//		Runnable03 runnable3 = new Runnable03("china three");
//		Runnable03 runnable4 = new Runnable03("china four");
//		ThreadPoolExecutor threadpool =
//				new ThreadPoolExecutor(2, 3, 5L, TimeUnit.SECONDS, new SynchronousQueue<Runnable>());
//		threadpool.setRejectedExecutionHandler(new MyrejectedExecutionHandler());
//		threadpool.execute(runnable1);
//		threadpool.execute(runnable2);
//		threadpool.execute(runnable3);
//		threadpool.execute(runnable4);
//
//
//	}
//}
