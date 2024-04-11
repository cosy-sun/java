package com.cosy.sun.jdk.design.bridge;

public class House implements Product{

	@Override
	public void product() {
		// TODO Auto-generated method stub
		System.out.println("product house");
	}

	@Override
	public void sell() {
		System.out.println("sell house");
	}

}
