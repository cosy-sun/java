package com.cosy.sun.morethread.future;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Test1 {

	public static void main(String[] args) throws Exception {
		MyCallable callable1 = new MyCallable("username1", 5000);
		MyCallable callable2 = new MyCallable("username2", 4000);
		MyCallable callable3 = new MyCallable("username3", 3000);
		MyCallable callable4 = new MyCallable("username4", 2000);
		MyCallable callable5 = new MyCallable("username5", 1000);
		
		List<Callable<String>> callableList = new ArrayList<>();
		callableList.add(callable1);
		callableList.add(callable2);
		callableList.add(callable3);
		callableList.add(callable4);
		callableList.add(callable5);
		
		List<Future<String>> futurelist = new ArrayList<>();
		ThreadPoolExecutor executor = new ThreadPoolExecutor(5, 10, 5, TimeUnit.SECONDS,
				new LinkedBlockingDeque<>());
		for(int i=0;i<5;i++) {
			futurelist.add(executor.submit(callableList.get(i)));
		}
		
		System.out.println("first time" + System.currentTimeMillis());
		
		for(int i=0;i<5;i++) {
			System.out.println(futurelist.get(i).get() + " " + System.currentTimeMillis());
		}
		
		
		
	}
	
}
