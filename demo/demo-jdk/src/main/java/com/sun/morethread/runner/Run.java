package com.sun.morethread.runner;

import java.util.concurrent.CountDownLatch;

public class Run {

	public static void main(String[] args) throws Exception {
		CountDownLatch down = new CountDownLatch(10);
		MyThread[] thread = new MyThread[Integer.parseInt(""+down.getCount())];
		for(int i=0;i<thread.length;i++) {
			thread[i] = new MyThread(down);
			thread[i].setName("线程"+(i+1));
			thread[i].start();
		}
		down.await();
		System.out.println("都回来了!");
	}
	
}
