package com.cosy.sun.morethread.onAdvance;

import java.util.concurrent.Phaser;

public class Run {

	public static void main(String[] args) {
		Phaser phaser = new Phaser(2) {
			@Override
			protected boolean onAdvance(int phase, int registeredParties) {
				System.out.println("protected boolean onadvance(int phaser, int registered parties)被调用");
				return true;
			}
		};
		MyService service = new MyService(phaser);
		ThreadA a  = new ThreadA(service);
		a.setName("A");
		a.start();
		ThreadB b = new ThreadB(service);
		b.setName("B");
		b.start();
	}
	
}
