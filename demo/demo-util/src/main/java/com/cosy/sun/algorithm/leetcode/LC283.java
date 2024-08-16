package com.cosy.sun.algorithm.leetcode;

import org.apache.commons.lang3.ArrayUtils;

import java.util.Arrays;
import java.util.Objects;

public class LC283 {

    public static void moveZeros2Left(int[] nums) {
        int left = nums.length - 1, right = nums.length - 1;
        while(left >= 0) {
            if(nums[left] != 0) {
                int tmp = nums[left];
                nums[left] = nums[right];
                nums[right] = tmp;
                right --;
            }
            left --;
        }
    }

    public static void moveZeros2Right(int[] nums) {
        if(Objects.isNull(nums)) {
            return ;
        }
        if(nums.length == 0) {
            return ;
        }
        int left = 0, right = -1;
        while (++right < nums.length) {
            if(nums[right] != 0) {
                ArrayUtils.swap(nums, right, left ++);
            }
        }
        System.out.println(Arrays.toString(nums));
    }

}
