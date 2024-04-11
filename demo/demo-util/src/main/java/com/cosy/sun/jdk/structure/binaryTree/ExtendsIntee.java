package com.cosy.sun.jdk.structure.binaryTree;

public class ExtendsIntee implements Comparable<ExtendsIntee>{

	private int i = 0;
	
	public ExtendsIntee(int i ) {
		this.i = i;
	}

	@Override
	public int compareTo(ExtendsIntee o) {
		
		return this.i - o.i;
	}

}
