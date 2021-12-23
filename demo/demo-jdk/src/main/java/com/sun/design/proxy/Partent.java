package com.sun.design.proxy;

public class Partent implements Ichild{

	private Child child;
	
	public Partent(Child child) {
		this.child = child;
	}
	
	@Override
	public void eat() {
		
		System.out.println("fumuzuofan");
		this.child.eat();
		System.out.println("fumu shoushi");
		
	}
	
}
