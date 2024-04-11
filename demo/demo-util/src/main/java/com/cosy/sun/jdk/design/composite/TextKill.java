package com.cosy.sun.jdk.design.composite;

public class TextKill implements KillVirus{

	String name ;
	
	public TextKill(String name) {
		this.name = name;
	}
	
	@Override
	public void killVirus(KillVirus killvirus) {
		System.out.println(this.name + "--text kill");
	}

}
