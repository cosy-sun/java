package com.cosy.sun.algorithm;

import java.util.Arrays;

/**
 * 快排
 * @author cosy-sun
 *
 */
public class QuickSort {

	/**
	 * 快速排序, 
	 * @param arr
	 * @param start
	 * @param end
	 */
	public static void quickSort(int[] arr, int start, int end) {
		System.out.println("下一次快排" + Arrays.toString(arr) + " " + start + "---" + end);
		if(start < end) {
			int position = positionSelect(arr, start, end);
			quickSort(arr, start, position - 1);
			quickSort(arr, position + 1, end);
		}
	}
	
	/**
	 * 位置选择
	 * @param arr
	 * @param start
	 * @param end
	 * @return
	 */
	private static int positionSelect(int[] arr, int start, int end) {
		int index = start - 1;
		for(int i = start; i < end; i ++) {
			if(arr[i] < arr[end]) {
				swap(arr, ++ index, i);
			}
		}
		swap(arr, ++ index, end);
		System.out.println(Arrays.toString(arr));
		return index;
	}

	/**
	 * 交换两个位置
	 * @param arr
	 * @param x
	 * @param y
	 */
	private static void swap(int[] arr, int x, int y) {
		int tmp = arr[x];
		arr[x] = arr[y];
		arr[y] = tmp;
	}
	
}
