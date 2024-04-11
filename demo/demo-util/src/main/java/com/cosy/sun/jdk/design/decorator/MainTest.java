package com.cosy.sun.jdk.design.decorator;

public class MainTest {

	public static void main (String[] args) {
		Compent compent = new Decorator(new OneCompent());
		Compent compent2  = new Decorator(new TwoCompent());
		compent.biu();
		compent2.biu();
		
	}
	
}
