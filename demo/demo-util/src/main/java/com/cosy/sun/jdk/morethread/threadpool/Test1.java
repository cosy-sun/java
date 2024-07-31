//package com.cosy.sun.jdk.morethread.threadpool;
//
//import java.util.concurrent.LinkedBlockingDeque;
//import java.util.concurrent.ThreadPoolExecutor;
//import java.util.concurrent.TimeUnit;
//
//public class Test1 {
//	public static void main(String[] args) throws InterruptedException {
//		RunnableMy runnable = new RunnableMy();
//		ThreadPoolExecutor pool = new ThreadPoolExecutor(1, 8, 999L, TimeUnit.SECONDS,
//				new LinkedBlockingDeque<Runnable>());
//		pool.execute(runnable);
//		pool.execute(runnable);
//		pool.execute(runnable);
//		pool.execute(runnable);
//		pool.shutdown();
////		System.out.println("A"+pool.awaitTermination(1, TimeUnit.SECONDS));
////		System.out.println("b"+pool.awaitTermination(1, TimeUnit.SECONDS));
////		System.out.println("c"+pool.awaitTermination(1, TimeUnit.SECONDS));
////		System.out.println("d"+pool.awaitTermination(1, TimeUnit.SECONDS));
////		System.out.println("e"+pool.awaitTermination(1, TimeUnit.SECONDS));
////		System.out.println("f"+pool.awaitTermination(1, TimeUnit.SECONDS));
//		System.out.println("g"+pool.awaitTermination(Integer.MAX_VALUE, TimeUnit.SECONDS));
//		System.out.println("全部执行完毕!");
//	}
//}
