package com.cosy.sun.algorithm.design.invocationproxy;

public class Student implements Person{

	@SuppressWarnings("unused")
	private String name = null;
	
	public Student(String name ) {
		this.name = name ;
	}
	
	public void giveMoney(double money) {
		System.out.println("give " + money);
	}
	
}
