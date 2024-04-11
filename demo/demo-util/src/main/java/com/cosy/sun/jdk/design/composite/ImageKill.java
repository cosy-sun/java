package com.cosy.sun.jdk.design.composite;

public class ImageKill implements KillVirus{

	String name = null;
	
	public ImageKill(String name) {
		this.name = name ;
	}
	
	@Override
	public void killVirus(KillVirus killvirus) {
		System.out.println(this.name + "--kill image!");
	}

}
