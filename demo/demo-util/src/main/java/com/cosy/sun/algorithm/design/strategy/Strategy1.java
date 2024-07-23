package com.cosy.sun.algorithm.design.strategy;

public class Strategy1 extends StrategyCommon implements Strategy{

	public Strategy1(String strategy) {
		super(strategy);
	}
	
	@Override
	public Strategy getAdvisor() {
		return this;
	}

}
