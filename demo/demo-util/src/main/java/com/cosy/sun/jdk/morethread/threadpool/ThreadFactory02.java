package com.cosy.sun.jdk.morethread.threadpool;

import java.lang.Thread.UncaughtExceptionHandler;
import java.util.concurrent.ThreadFactory;

public class ThreadFactory02 implements ThreadFactory{

	@Override
	public Thread newThread(Runnable r) {
		Thread thread = new Thread(r);
		thread.setName("孙振华");
		thread.setUncaughtExceptionHandler(new UncaughtExceptionHandler() {
			
			public void uncaughtException(Thread t, Throwable e) {
				System.out.println("自定义处理异常" + t.getName() + e.getMessage());
				e.printStackTrace();
			}
		});
		System.out.println("获取到的处理未捕获异常" + thread.getUncaughtExceptionHandler());
//		Thread.setDefaultUncaughtExceptionHandler(new UncaughtExceptionHandler() {
//			
//			@Override
//			public void uncaughtException(Thread t, Throwable e) {
//				System.out.println(t.getName()+e.getMessage());
//			}
//		});
		return thread;
	}

}
