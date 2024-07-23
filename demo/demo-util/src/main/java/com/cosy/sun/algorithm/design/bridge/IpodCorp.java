package com.cosy.sun.algorithm.design.bridge;

public class IpodCorp extends Corp{

	@Override
	public void produce() {
		System.out.println("ipod produce");
	}

	@Override
	public void sell() {
		System.out.println("ipod sell");
	}

}
