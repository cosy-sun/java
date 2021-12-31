package com.sun.morethread.run;

import java.util.concurrent.CountDownLatch;

public class MyThread extends Thread{

	private CountDownLatch comingTag;
	private CountDownLatch beginTag;
	@SuppressWarnings("unused")
	private CountDownLatch endTag;
	private CountDownLatch waitTag;
	private CountDownLatch waitRunTag;
	
	public MyThread(CountDownLatch comingTag, CountDownLatch beginTag, CountDownLatch end,
			CountDownLatch waitTag, CountDownLatch waitRunTag) {
		this.comingTag = comingTag;
		this.beginTag = beginTag;
		this.endTag = end;
		this.waitTag = waitTag;
		this.waitRunTag = waitRunTag;
	}
	
	public void run() {
		System.out.println("运动员使用不同的工具以不同的速度正在向这边走");
		try {
			Thread.sleep((int)(Math.random()*10000));
			System.out.println(Thread.currentThread().getName()+"到起跑点了");
			comingTag.countDown();
			System.out.println("等待裁判说准备");
			waitTag.await();
			System.out.println("各就各位准备跑");
			Thread.sleep((int) (Math.random()*10000));
			waitRunTag.countDown();
			beginTag.await();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
}
