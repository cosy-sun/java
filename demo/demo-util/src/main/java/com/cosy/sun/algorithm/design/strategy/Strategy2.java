package com.cosy.sun.algorithm.design.strategy;

public class Strategy2 extends StrategyCommon implements Strategy{

	public Strategy2(String strategy) {
		super(strategy);
	}
	
	@Override
	public Strategy getAdvisor() {
		return this;
	}

}
