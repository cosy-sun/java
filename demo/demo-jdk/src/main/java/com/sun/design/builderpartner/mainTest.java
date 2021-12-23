package com.sun.design.builderpartner;

public class mainTest {

	public static void main(String [] args) {
		Bmw bmw = new Bmw();
		Builder builder = new Builder(bmw);
		builder.constract();
		bmw = bmw.getResult();
		System.out.println(bmw.toString());
	}
	
}
