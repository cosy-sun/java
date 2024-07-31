//package com.cosy.sun.jdk.morethread.threadpool;
//
//import java.util.concurrent.LinkedBlockingQueue;
//import java.util.concurrent.SynchronousQueue;
//import java.util.concurrent.ThreadPoolExecutor;
//import java.util.concurrent.TimeUnit;
//
//public class Run1 {
//
//	public static void main(String[] args) {
//		ThreadPoolExecutor executor = new ThreadPoolExecutor(7, 8, 5, TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>());
//		System.out.println(executor.getCorePoolSize()+"\n"+executor.getMaximumPoolSize());
//
//		ThreadPoolExecutor executor1 = new ThreadPoolExecutor(7,8,5,TimeUnit.SECONDS, new SynchronousQueue<Runnable>());
//		System.out.println(executor1.getCorePoolSize()+"\n"+executor1.getMaximumPoolSize());
//
//	}
//
//}
