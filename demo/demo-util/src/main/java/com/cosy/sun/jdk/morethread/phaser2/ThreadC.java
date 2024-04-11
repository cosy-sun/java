package com.cosy.sun.jdk.morethread.phaser2;

import java.util.concurrent.Phaser;

public class ThreadC extends Thread{

	@SuppressWarnings("unused")
	private Phaser phaser;
	
	public ThreadC(Phaser phaser) {
		this.phaser = phaser;
	}
	
	public void run() {
		try {
			PrintTools.methodB();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
