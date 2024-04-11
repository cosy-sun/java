package com.cosy.sun.jdk.algorithm;

import java.util.Arrays;

/**
 * 归并排序
 * @author cosy-sun
 *
 */
public class MergeSort {

	static int count = 0;
	public static void merge(int[] arr, int left, int mid, int right) {
		count ++;
		System.out.println("第"+ count+"次 :  " + left + " "  + mid + " " + right);
		int startLeft = left;
		int startRight = mid + 1;
		int tmpIndex = 0;
		int[] tmp = new int[right - left + 1];
		while (startLeft <= mid && startRight <= right) {
			if(arr[startLeft] <= arr[startRight]) {
				tmp[tmpIndex] = arr[startLeft];
				tmpIndex ++; startLeft ++;
			} else {
				tmp[tmpIndex] = arr[startRight];
				tmpIndex ++; startRight ++;
			}
			System.out.println("归并:" + Arrays.toString(tmp));
		}
		while (startLeft <= mid) {
			tmp[tmpIndex ++] = arr[startLeft ++];
			System.out.println("左边有多的" +  Arrays.toString(tmp));
		}
		while (startRight <= right) {
			tmp[tmpIndex ++] = arr[startRight ++];
			System.out.println("右边有多的" + Arrays.toString(tmp));
		}
		for(int i = 0 ; i < tmp.length; i ++) {
			arr[left ++] = tmp[i];
		}
	}
	
	public static void splitArray(int[] arr, int start, int end) {
		if(start < end){
			int mid = (end + start) / 2;
			splitArray(arr, start, mid);
			splitArray(arr, mid + 1, end);
			merge(arr, start, mid, end);
		}
	}
}
