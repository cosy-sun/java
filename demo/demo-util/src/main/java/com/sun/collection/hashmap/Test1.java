package com.sun.collection.hashmap;

public class Test1 {

	public static void main(String[] args) {
		
		Service2 service = new Service2();
		ThreadA threada = new ThreadA(service);
		ThreadB threadb = new ThreadB(service);
		threada.start();
		threadb.start();
		
	}
	
}
