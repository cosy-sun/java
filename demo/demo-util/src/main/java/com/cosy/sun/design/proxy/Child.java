package com.cosy.sun.design.proxy;

public class Child implements Ichild, Istudent{

	private String name ;
	
	public Child(String name ) {
		this.name = name;
	}
	
	@Override
	public void readBook() {

		System.out.println(name + " read book");
	}

	@Override
	public void eat() {
		System.out.println(name + " eat ");
	}

}
