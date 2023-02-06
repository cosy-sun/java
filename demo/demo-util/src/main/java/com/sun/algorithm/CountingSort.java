package com.sun.algorithm;

import java.util.Arrays;

/**
 * 计数排序
 * @author cosy-sun
 *
 */
public class CountingSort {

	public static int[] countSort(int[] arr) {
		//临时数组要比最大的值大一个
		int[] tmp = new int[max(arr) + 1];
		//排序数组也要比数据长度大一
		int[] res = new int[arr.length + 1];
		//临时数组key存储的是要排序数据的值, key对应的值是出现次数
		for(int i = 0; i < arr.length; i ++) {
			tmp[arr[i]] ++;
		}
		System.out.println(Arrays.toString(tmp));
		//计算比每个值小的数有多少个
		for(int i = 1; i < tmp.length; i ++) {
			tmp[i] = tmp[i] + tmp[i - 1];
		}
		System.out.println(Arrays.toString(tmp));
		//
		for(int i = arr.length - 1; i >= 0; i --) {
			res[tmp[arr[i]] --] = arr[i];
			
		}
		System.out.println(Arrays.toString(res));
		//最后将排序的数据1-n的值复制到原数组中
		System.arraycopy(res, 1, arr, 0, arr.length);
		return arr;
	}
	
	public static int max(int[] arr) {
		int max = 0;
		for(int x : arr) {
			if(x > max)
				max = x;
		}
		return max;
	}
	
}
