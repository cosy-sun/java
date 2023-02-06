package com.sun.design.proxy;

public class BigChild implements Ichild, Istudent{

	private Child child = null;
	
	public BigChild(Child child) {
		this.child = child;
	}
	
	@Override
	public void readBook() {
		this.child.readBook();
	}

	@Override
	public void eat() {
		System.out.println("child do!");
		this.child.eat();
		System.out.println("child kuaizi!");
	}

}
