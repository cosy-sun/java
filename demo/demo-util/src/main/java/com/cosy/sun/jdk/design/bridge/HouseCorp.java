package com.cosy.sun.jdk.design.bridge;

public class HouseCorp extends Corp{

	@Override
	public void produce() {
		System.out.println("house corp produce");
	}

	@Override
	public void sell() {
		System.out.println("house corp sell");
	}

}
