package com.cosy.sun.design.composite;

import java.util.ArrayList;
import java.util.List;

public class FlodKill implements KillVirus{

	String name ;
	
	private List<KillVirus> child  = new ArrayList<>();
	
	public FlodKill(String name) {
		this.name = name ;
	}
	
	public void add(KillVirus killvirus) {
		
		child.add(killvirus);
		
	}
	
	public void killVirus(KillVirus killvirus) {
		for(KillVirus flod : child) {
			if(flod instanceof FlodKill) {
				System.out.println("start kill flod--" + ((FlodKill)flod).name);
				flod.killVirus(flod);
				System.out.println("end kill flod--" + ((FlodKill)flod).name);
			} else {
				System.out.println(this.name);
				flod.killVirus(flod);
				child.remove(flod);
			}
		}
	}
	
}
