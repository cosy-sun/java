//package com.cosy.sun.jdk.morethread.scheduledthreadpoolexecutor;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.concurrent.Callable;
//import java.util.concurrent.Executors;
//import java.util.concurrent.ScheduledExecutorService;
//import java.util.concurrent.ScheduledFuture;
//import java.util.concurrent.TimeUnit;
//
//public class Run {
//
//	public static void main(String[] args) throws Exception {
//		List<Callable<String>> list = new ArrayList<Callable<String>>();
//		list.add(new MycallableA());
//		list.add(new MycallableB());
//		ScheduledExecutorService scheduledExecutor = Executors.newSingleThreadScheduledExecutor();
//		ScheduledFuture<String> schedule = scheduledExecutor.schedule(list.get(0), 0L, TimeUnit.SECONDS);
//		ScheduledFuture<String> schedule2 = scheduledExecutor.schedule(list.get(1), 0L, TimeUnit.SECONDS);
//		System.out.println(schedule.get());
//		System.out.println(schedule2.get());
//
//
//	}
//
//}
