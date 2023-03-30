package com.cosy.sun.trigger;

public class Element<K, V> {

	private Element<K, V> left;
	private Element<K, V> right;
	private Element<K, V> parent;
	K key;
	V value;

	public Element(Element<K, V> left, Element<K, V> right, Element<K, V> parent, K key, V value) {
		super();
		this.left = left;
		this.right = right;
		this.parent = parent;
		this.key = key;
		this.value = value;
	}

	public V getValue() {
		return value;
	}

	public Element<K, V> getLeft() {
		return left;
	}

	public void setLeft(Element<K, V> left) {
		this.left = left;
	}

	public Element<K, V> getRight() {
		return right;
	}

	public void setRight(Element<K, V> right) {
		this.right = right;
	}

	public Element<K, V> getParent() {
		return parent;
	}

	public void setParent(Element<K, V> parent) {
		this.parent = parent;
	}

	public K getKey() {
		return key;
	}

	public void setKey(K key) {
		this.key = key;
	}

	public void setValue(V value) {
		this.value = value;
	}

}
