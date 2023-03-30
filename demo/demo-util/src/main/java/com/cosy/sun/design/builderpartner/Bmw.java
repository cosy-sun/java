package com.cosy.sun.design.builderpartner;

public class Bmw implements Car<Bmw>{
	
	String carBody, tyre, door;
	
	@Override
	public void builderCarBody() {
		this.carBody = "carbody";
		System.out.println(" this is car body");
	}

	@Override
	public void builderTyre() {
		// TODO Auto-generated method stub
		this.tyre = "tyre";
		System.out.println("this is tyre");
	}
	
	
	@Override
	public void builderDoor() {
		// TODO Auto-generated method stub
		this.door = "door";
		System.out.println("this is door");
	}

	@Override
	public Bmw getResult() {
		return this;
	}

	@Override
	public String toString() {
		return "Bmw [carBody=" + carBody + ", tyre=" + tyre + ", door=" + door + "]";
	}


}
