package com.cosy.sun.morethread.threadpool;

public class RunnableMy implements Runnable{
	
	public void run() {
		try {
			System.out.println(Thread.currentThread().getName() + "   " + System.currentTimeMillis());
			Thread.sleep(1000);
			System.out.println(Thread.currentThread().getName() + "   " + System.currentTimeMillis());
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
