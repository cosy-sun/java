package com.cosy.sun.jdk.morethread.getPhaser;

import java.util.concurrent.Phaser;

public class ThreadA extends Thread{

	private Phaser phaser;
	
	public ThreadA(Phaser phaser) {
		this.phaser = phaser;
		
	}
	
	public void run() {
		System.out.println("a    begin");
		phaser.arriveAndAwaitAdvance();
		System.out.println("a    end phaser value="+phaser.getPhase());
		
		System.out.println("a    begin");
		phaser.arriveAndAwaitAdvance();
		System.out.println("a    end phaser value="+phaser.getPhase());
		
		System.out.println("a    begin");
		phaser.arriveAndAwaitAdvance();
		System.out.println("a    end phaser value="+phaser.getPhase());
		
		System.out.println("a    begin");
		phaser.arriveAndAwaitAdvance();
		System.out.println("a    end phaser value="+phaser.getPhase());
	}
	
}
