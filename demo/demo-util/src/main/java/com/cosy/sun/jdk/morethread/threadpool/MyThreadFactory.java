package com.cosy.sun.jdk.morethread.threadpool;

import java.util.concurrent.ThreadFactory;

public class MyThreadFactory implements ThreadFactory{

	@Override
	public Thread newThread(Runnable r) {
		Thread thread = new Thread(r);
		thread.setName("sunzhenhua");
		return thread;
	}

}
