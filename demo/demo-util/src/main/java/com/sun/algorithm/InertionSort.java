package com.sun.algorithm;

/**
 * 插入排序
 * @author cosy-sun
 *
 */
public class InertionSort {

	public static int[] sort(int[] arr) {
		for(int i = 1; i < arr.length; i ++) {
			int key = arr[i];
			int j = i - 1;
			while (j >= 0 && arr[j] < key) {
				arr[j + 1] = arr[j];
				j --;
			}
			arr[j + 1] = key;
		}
		return arr;
	}
	
	public static void sortDouble(double[] arr) {
		for(int i = 1; i < arr.length; i ++) {
			double key = arr[i];
			int j = i - 1;
			while (j >= 0 && arr[j] < key) {
				arr[j + 1] = arr[j];
				j --;
			}
			arr[j + 1] = key;
		}
	}
	
}
