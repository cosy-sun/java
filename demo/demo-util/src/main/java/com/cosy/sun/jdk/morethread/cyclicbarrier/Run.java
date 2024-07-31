//package com.cosy.sun.jdk.morethread.cyclicbarrier;
//
//import java.util.concurrent.CyclicBarrier;
//
//public class Run {
//
//	public static void main(String[] args) {
//		CyclicBarrier cyc = new CyclicBarrier(5, new Runnable() {
//
//			@Override
//			public void run() {
//				System.out.println("五个人凑够了,开始了");
//
//			}
//		});
//
//		MyThread[] threads = new MyThread[10];
//		for(int i=0;i<threads.length;i++) {
//			threads[i] = new MyThread(cyc);
//			threads[i].setName("Thread"+(i+1));
//		}
//		for(int i=0;i<threads.length;i++) {
//			threads[i].start();
//		}
//
//
//	}
//
//}
