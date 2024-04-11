package com.cosy.sun.jdk.morethread.cyclicbarrier;

import java.util.concurrent.CyclicBarrier;

public class MyThread extends Thread{

	private CyclicBarrier cyclicb;
	
	public MyThread(CyclicBarrier cyclicb) {
		this.cyclicb = cyclicb;
	}
	
	public void run() {
		try {
			
			Thread.sleep((int)(Math.random()*10000));
			System.out.println(Thread.currentThread().getName()+"到了! 等待中");
			cyclicb.await();
			System.out.println("end");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
}
