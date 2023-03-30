package com.cosy.sun.design.decorator;

public class OneCompent implements Compent{

	private String name = "OneCompent";
	
	@Override
	public void biu() {
		System.out.println("biubiubiu" + name);
	}

}
