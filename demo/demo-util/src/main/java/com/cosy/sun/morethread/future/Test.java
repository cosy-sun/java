package com.cosy.sun.morethread.future;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Test {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		UserInfo userinfo = new UserInfo();
		Runnable01 runnable = new Runnable01(userinfo);
		ThreadPoolExecutor executor = new ThreadPoolExecutor(2, 3, 5, TimeUnit.SECONDS,
				new LinkedBlockingDeque<Runnable>());
		Future<UserInfo> future = executor.submit(runnable, userinfo);
		UserInfo userInfo2 = future.get();
		System.out.println(userInfo2.toString());
		System.out.println();
		
	}
	
}
