package com.cosy.sun.morethread.onAdvance;

import java.util.concurrent.Phaser;

public class MyService {

	private Phaser phaser;
	
	public MyService(Phaser phaser) {
		this.phaser = phaser;
	}
	
	public void testMethod() {
	try {
		
		System.out.println("A begin threadNmae="+Thread.currentThread().getName()
				+"      		"+System.currentTimeMillis());
		if(Thread.currentThread().getName().equals("B")) {
			Thread.sleep(5000);
		}
		phaser.arriveAndAwaitAdvance();
		System.out.println("A end thradName="+Thread.currentThread().getName()
				+" 				"+System.currentTimeMillis()
				);
		System.out.println("B    begin threadname="+Thread.currentThread().getName()
				+"				"+System.currentTimeMillis());
		if(Thread.currentThread().getName().equals("B")) {
			Thread.sleep(5000);
			
		}
		phaser.arriveAndAwaitAdvance();
		System.out.println("B   end threadname="+Thread.currentThread().getName()
				+"				"+System.currentTimeMillis());
		System.out.println("C begin threadNmae="+Thread.currentThread().getName()
				+"      		"+System.currentTimeMillis());
		if(Thread.currentThread().getName().equals("B")) {
			Thread.sleep(5000);
		}
		phaser.arriveAndAwaitAdvance();
		System.out.println("c end thradName="+Thread.currentThread().getName()
				+" 				"+System.currentTimeMillis()
				);
	}catch(Exception e) {
		e.printStackTrace();
	}
		
	}
	
}
