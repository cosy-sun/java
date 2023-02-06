package com.sun.algorithm.leetcode;

import java.util.Arrays;

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

public class _189轮转数组 {

    public static void main(String[] args) {
        int arrs[] = {1, 2,3,4,5,6,7};
        lunzhaun(arrs, 3);
        System.out.println(Arrays.toString(arrs));

    }

    public static void lunzhaun(int nums[], int k) {
        int length = nums.length;
        if(k%length == 0) {
            return;
        }
        int m = k % length;
        for(int i = 0; i < m; i ++) {
            int tem = nums[length -1];
            for(int j = length - 1; j >0; j --) {
                nums[j] = nums[j-1];
            }
            nums[0] = tem;
        }
    }

}
