package com.sun.design.decorator;

public class TwoCompent implements Compent{

	private String name = "TwoCompent";
	
	@Override
	public void biu() {
		System.out.println("biubiubiu "+ name);
	}

}
