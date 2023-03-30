package com.cosy.sun.structure;

/**
 * 栈
 * @author cosy-sun
 *
 * @param <T>
 */
@SuppressWarnings("all")
public class Stack<T> {

	//存储数组
	private Object[] arr = new Object[2];
	//栈顶
	private int top = -1;
	
	/**
	 * 入栈
	 * @param ele
	 */
	public synchronized void push(T ele) {
		
		if(top + 1 > arr.length - 1) {
			Object[] tmp = new Object[arr.length * 2];
			System.arraycopy(arr, 0, tmp, 0, arr.length);
			arr = tmp;
		}
		arr[++ top] = ele;
	}
	
	public T pop() {
		if(top - 1 >= -1) {
			T res = (T) arr[top];
			top --;
			if(arr.length / 2 - 1 >= top && arr.length > 2) {
				Object[] tmp = new Object[arr.length/2];
				System.arraycopy(arr, 0, tmp, 0, tmp.length);
				arr = tmp;
			}
			return res;
		} else {
			return null;
		}
	}
	
	public void clear() {
		top = -1;
		arr = new Object[2];
	}
	
	public T[] get() {
		return (T[]) arr;
	}
	
	public int getTop() {
		return top;
	}
}
