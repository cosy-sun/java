package com.cosy.sun.algorithm.design.decorator;

public class Decorator implements Compent{

	private String name = "Decorator";
	
	private Compent compent;
	
	public Decorator(Compent compent) {
		this.compent = compent;
	}
	
	@Override
	public void biu() {

		System.out.println(name +  "biubiubiu! hahaha");
		this.compent.biu();
		System.out.println();
	}
	
}
