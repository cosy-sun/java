package com.sun.structure.binaryTree;

public class Element<T extends Comparable<T>, K>{

	Element<T, K> left;
	Element<T, K> right;
	Element<T, K> parent;
	T key;
	K value;
	public Element(T key, K value) {
		this.key = key;
		this.value = value;
	}
	public K getValue() {
		return value;
	}
}
