package com.cosy.sun.jdk.morethread.runner;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MyThread extends Thread {

	private CountDownLatch down;
	
	private Lock lock = new ReentrantLock();

	public MyThread(CountDownLatch down) {
		this.down = down;
	}

	public void run() {
		try {
			Thread.sleep(2000);
			System.out.println(Thread.currentThread().getName() + "---回来了");
			lock.lock();
			System.out.println("计数器减少一个" + down.getCount());
			down.countDown();
			lock.unlock();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
