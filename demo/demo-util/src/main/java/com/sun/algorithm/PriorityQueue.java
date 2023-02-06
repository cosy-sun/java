package com.sun.algorithm;

/**
 * 优先队列
 * @author cosy-sun
 *
 */
public class PriorityQueue {

	private static int[] arr = new int[8];
	private static int dateCount = 0;
	
	/**
	 * 插入元素X
	 * @param x
	 */
	public void insert(int x) {
		arr[dateCount ++] = x;
	}
	
	/**
	 * 返回最大元素
	 * @return
	 */
	public int maxMinum() {
		HeapSort.buildMaxHeapInit(arr);
		return  arr[0];
	}
	
	/**
	 * 返回最大元素,并除去此元素
	 * @return
	 */
	public int extractMax() {
		HeapSort.buildMaxHeapInit(arr);
		int result = arr[0];
		int[] tmp = new int[arr.length -1 ];
		System.arraycopy(arr, 1, tmp, 0, arr.length - 1);
		arr = tmp;
		return result;
	}
	
}
