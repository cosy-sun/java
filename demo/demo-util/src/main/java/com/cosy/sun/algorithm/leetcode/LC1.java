package com.cosy.sun.algorithm.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标。
 * @author cosy-sun
 *
 */
public class LC1 {

	public static int[] sum1(int[] arr, int target) {
		int[] resInt = new int[2];
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < arr.length; i++) {
			if(map.containsKey(target - arr[i])) {
				resInt[0] = i;
				resInt[1] = map.get(target-arr[i]);
				break;
			}
			map.put(arr[i], i);
		}
		return resInt;
	}
	
}
