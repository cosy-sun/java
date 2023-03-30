package com.cosy.sun.design.bridge;

public abstract class Corp {

	public abstract void produce();
	public abstract void sell();
	public void makeMoney() {
		this.produce();
		this.makeMoney();
	}
		
}
