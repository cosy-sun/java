package com.cosy.sun.jdk.algorithm;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 桶
 * @author cosy-sun
 *
 */
public class BucketSort {
	
	public static void bucketSort(double[] arr) {
		for(double d : arr) {
			if(d > 1)
				return;
		}
		double[][] tmp = new double[10][10];
		
		Map<Integer, Integer> map = new HashMap<>();
		for(int i = 0; i < arr.length; i ++) {
			int x = (int)(arr[i] * 10);
			System.out.println(x);
			Integer y = map.get(x);
			if(y == null) {
				map.put(x, -1);
			}
			y = map.get(x);
			tmp[x][++ y] = arr[i];
			map.put(x, y);
		}
		int a = 0;
		for(int i = tmp.length - 1; i > -1; i --) {
			Integer integer = map.get(i);
			if(integer == null)
				continue;
			++ integer;
			InertionSort.sortDouble(tmp[i]);
			System.arraycopy(tmp[i], 0, arr, a, integer);
			a += integer;
			System.out.println(" " + Arrays.toString(tmp[i]));
		}
		
	}
}
