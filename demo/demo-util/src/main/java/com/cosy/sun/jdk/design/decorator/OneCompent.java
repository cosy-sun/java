package com.cosy.sun.jdk.design.decorator;

public class OneCompent implements Compent{

	private String name = "OneCompent";
	
	@Override
	public void biu() {
		System.out.println("biubiubiu" + name);
	}

}
