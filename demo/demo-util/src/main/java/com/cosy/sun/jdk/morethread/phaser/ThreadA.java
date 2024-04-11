package com.cosy.sun.jdk.morethread.phaser;

import java.util.concurrent.Phaser;

public class ThreadA extends Thread{

	@SuppressWarnings("unused")
	private Phaser phaser;
	
	public ThreadA(Phaser phaser) {
		this.phaser = phaser;
	}
	
	public void run() {
		PhaserTools.methodA();
	}
	
}
