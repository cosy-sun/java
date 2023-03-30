package com.cosy.sun.structure;

/**
 * 队列
 * @author cosy-sun
 *
 */
public class Queue<T> {

	//head
	private Element head;
	private Element tail;
	
	//队列大小
	private int size = 0;
	
	public Queue() {
	}
	
	public Queue(T[] ele) {
		for(T e : ele) {
			enqueue(e);
		}
	}
	
	/**
	 * 入队
	 * @param ele
	 */
	public synchronized void enqueue(T ele) {
		Queue<T>.Element element = new Element(ele);
		if(this.head == null) {
			this.head = element;
			this.head.prefix = null;
			this.head.sufix = null;
			this.tail = this.head;
			size ++;
			return ;
		}
		this.tail.sufix = element;
		element.prefix = this.tail;
		this.tail = element;
		this.tail.sufix = null;
		size ++;
		
	}
	
	/**
	 * 出队
	 * @return
	 */
	public Object dequeue() {
		if(size == 0) {
			return null;
		}
		if(size == 1) {
			Object ele = this.head.ele;
			this.head = null;
			size --;
			return ele;
		}
		Element ele = this.head;
		this.head.sufix.prefix = null;
		this.head = this.head.sufix;
		size --;
		return ele.ele;
	}
	
	@SuppressWarnings("unchecked")
	public T[] getQueue() {
		if(size == 0) return null;
		Object[] arr = new Object[size];
		Element tmp = this.head;
		arr[0] = this.head.ele;
		for(int i = 1; i < size; i ++) {
			arr[i] = tmp.sufix.ele;
			tmp = tmp.sufix;
		}
		return (T[]) arr;
		
	}
	
	public void clear() {
		this.head = this.tail = null;
		size = 0;
	}
	
	public int size() {
		return this.size;
	}

	class Element {
		Element prefix;
		Element sufix;
		Object ele;
		public Element(Object ele) {
			this.ele = ele;
		}
	}
	
}
