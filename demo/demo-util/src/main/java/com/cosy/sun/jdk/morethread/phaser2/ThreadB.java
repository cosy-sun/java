package com.cosy.sun.jdk.morethread.phaser2;

import java.util.concurrent.Phaser;

public class ThreadB extends Thread{

	@SuppressWarnings("unused")
	private Phaser phaser;
	
	public ThreadB(Phaser phaser) {
		this.phaser = phaser;
	}
	
	public void run() {
		PrintTools.methodA();
	}
	
}
