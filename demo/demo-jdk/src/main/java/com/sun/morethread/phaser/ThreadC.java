package com.sun.morethread.phaser;

import java.util.concurrent.Phaser;

public class ThreadC extends Thread{

	@SuppressWarnings("unused")
	private Phaser phaser;
	
	public ThreadC(Phaser phaser) {
		this.phaser = phaser;
	}
	
	public void run() {
		try {
			PhaserTools.methodB();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
