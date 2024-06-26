package com.cosy.sun.algorithm.leetcode;

import java.util.*;

/**
 * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标。
 * @author cosy-sun
 *
 */
public class LC1 {

	public static List<Object> sum(int[] arr, int target) {
		ArrayList<Object> arrayList = new ArrayList<>();
		for(int i = 0; i < arr.length; i ++) {
			for(int j = i+1; j < arr.length; j ++) {
				if(arr[i] + arr[j] == target) {
					arrayList.add(new Ele(arr[i], arr[j]));
				}
			}
		}
		return arrayList;
	}

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

	static class Ele {
		int i;
		int j;
		public Ele(int i, int j) {
			this.i = i;
			this.j = j;
		}
		public int geti() {
			return i;
		}
		public int getj() {
			return j;
		}
	}
	
	public static void main(String[] args) {
		int[] a = {1,3,5,6,3,213,432,13};
		int target = 4;
		List<Object> sum = sum(a, target);
		sum.forEach((Object o)-> {
			System.out.println(((Ele)o).geti() + " " + ((Ele)o).getj());
		});
	}
	
}
