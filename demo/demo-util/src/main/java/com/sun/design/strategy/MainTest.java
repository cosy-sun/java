package com.sun.design.strategy;

public class MainTest {

	public static void main(String[] args) {
		System.out.println(getStrategy(2));
	}
	
	public static Strategy getStrategy(int i) {
		
		switch (i) {
		case 1:
			return new Strategy1("策略1").getAdvisor();
		case 2:
			return new Strategy2("策略2").getAdvisor();
		default:
			return null;
		}
		
	}
	
}
