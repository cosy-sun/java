package com.cosy.sun.jdk.algorithm;

/**
 * Heap
 * @author cosy-sun
 *
 */
public class HeapSort {

	/**
	 * 堆排序
	 * @param arr
	 */
	public static void heapSort(int[] arr) {
		buildMaxHeapInit(arr);
//		System.out.println(Arrays.toString(arr));
		for(int i = arr.length - 1; i >= 0; i --) {
			swap(arr, 0, i);
//			System.out.println("arr" + Arrays.toString(arr));
			int[] tmp = new int[i];
			System.arraycopy(arr, 0, tmp, 0, tmp.length);
//			System.out.println("tmp" + Arrays.toString(tmp));
			maxHeapifyInit(tmp, 0);
			System.arraycopy(tmp, 0, arr, 0, tmp.length);
//			System.out.println("arr" + Arrays.toString(arr));
//			System.out.println("tmp" + Arrays.toString(tmp));
		}
	}
	
	/**
	 * 构建最大堆
	 * 此方法是因为索引0 无法左移, 因此将数组索引为0的位置置空,再加一位, 以此来构建最大堆
	 * @param arr
	 */
	public static void buildMaxHeapInit(int[] arr) {
		int[] tmp = new int[arr.length + 1];
		System.arraycopy(arr, 0, tmp, 1, arr.length);
		buildMaxHeap(tmp);
		System.arraycopy(tmp, 1, arr, 0, arr.length);
	}
	
	/**
	 * 构建最大堆
	 * @param arr
	 */
	public static void buildMaxHeap(int[] arr) {
		for(int i = arr.length/2; i > 0; i --) {
			maxHeapify(arr, i);
		}
	}
	
	/**
	 * 最大堆性质的保证
	 * 此方法雷同之前的init方法
	 * @param arr
	 * @param index
	 */
	public static void maxHeapifyInit(int[] arr, int index) {
		int[] tmp = new int[arr.length + 1];
		System.arraycopy(arr, 0, tmp, 1, arr.length);
		if(index == 0)
			index ++;
		maxHeapify(tmp, index);
		System.arraycopy(tmp, 1, arr, 0, arr.length);
	}
	
	/**
	 * 最大堆性质的保证
	 * @param arr
	 * @param index
	 */
	public static void maxHeapify(int[] arr, int index) {
		if(index == 0) index ++;
		int left = leftSub(index);
		int right = rightSub(index);
		int largest = index;
		if(left < arr.length && arr[left] > arr[index]) {
			largest = left;
		}
		if(right < arr.length && arr[right] > arr[largest]) {
			largest = right;
		}
		if(largest != index) {
			swap(arr, index, largest);
			maxHeapify(arr, largest);
		}
	}
	
	/**
	 * 左子节点
	 * @param index
	 * @return
	 */
	public static int leftSub(int index) {
		return index << 1;
	}
	
	/**
	 * 又子节点
	 * @param index
	 * @return
	 */
	public static int rightSub(int index) {
		return (index << 1) + 1;
	}
	
	/**
	 * 交换数组元素的位置
	 * @param arr
	 * @param x
	 * @param y
	 */
	public static void swap(int[] arr, int x, int y) {
		int tmp = arr[x];
		arr[x] = arr[y];
		arr[y] = tmp;
	}
	
	
}
