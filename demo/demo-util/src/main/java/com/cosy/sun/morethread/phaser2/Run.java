package com.cosy.sun.morethread.phaser2;

import java.util.concurrent.Phaser;

public class Run {

	public static void main(String[] args) {
		Phaser phaser = new Phaser(3);
		PrintTools.phaser = phaser;
		ThreadA t1 = new ThreadA(phaser);
		t1.setName("a");
		t1.start();
		ThreadB t2 = new ThreadB(phaser);
		t2.setName("b");
		t2.start();
		ThreadC t3 = new ThreadC(phaser);
		t3.setName("c");
		t3.start();
	}
	
}
