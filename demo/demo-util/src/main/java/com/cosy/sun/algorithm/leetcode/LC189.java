package com.cosy.sun.algorithm.leetcode;

import org.apache.commons.lang3.ArrayUtils;

/**
 * 给定一个整数数组 nums，将数组中的元素向右轮转 k 个位置，其中 k 是非负数。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: nums = [1,2,3,4,5,6,7], k = 3
 * 输出: [5,6,7,1,2,3,4]
 * 解释:
 * 向右轮转 1 步: [7,1,2,3,4,5,6]
 * 向右轮转 2 步: [6,7,1,2,3,4,5]
 * 向右轮转 3 步: [5,6,7,1,2,3,4]
 * 示例 2:
 *
 * 输入：nums = [-1,-100,3,99], k = 2
 * 输出：[3,99,-1,-100]
 * 解释:
 * 向右轮转 1 步: [99,-1,-100,3]
 * 向右轮转 2 步: [3,99,-1,-100]
 *
 */

public class LC189 {

    public static void lunzhaun(int nums[], int k) {
        int n = nums.length;
        int[] newArr = new int[n];
        for (int i = 0; i < n; ++i) {
            newArr[(i + k) % n] = nums[i];
        }
        System.arraycopy(newArr, 0, nums, 0, n);
    }

    public static void reverse(int[] nums,  int k) {
        k = k % nums.length;
        rever(nums, 0, nums.length - 1);
        rever(nums, 0, k - 1);
        rever(nums, k, nums.length - 1);
    }

    private static void rever(int[] nums, int start, int end) {
        while (start < end) {
            ArrayUtils.swap(nums, start, end);
            start ++;
            end --;
        }
    }

}
