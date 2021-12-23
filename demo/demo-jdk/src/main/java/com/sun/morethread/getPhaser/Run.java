package com.sun.morethread.getPhaser;

import java.util.List;
import java.util.concurrent.AbstractExecutorService;
import java.util.concurrent.Phaser;
import java.util.concurrent.TimeUnit;

public class Run {

	public static void main(String[] args) {
		Phaser phaser = new Phaser(1);
		ThreadA a = new ThreadA(phaser);
		a.start();
		AbstractExecutorService abstractExecutorService = new AbstractExecutorService() {
			
			@Override
			public void execute(Runnable command) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public List<Runnable> shutdownNow() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public void shutdown() {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public boolean isTerminated() {
				// TODO Auto-generated method stub
				return false;
			}
			
			@Override
			public boolean isShutdown() {
				// TODO Auto-generated method stub
				return false;
			}
			
			@Override
			public boolean awaitTermination(long timeout, TimeUnit unit) throws InterruptedException {
				// TODO Auto-generated method stub
				return false;
			}
		};
	}
	
}
