package com.cosy.sun.algorithm.leetcode;

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
        int left = 0, right = 0;
        while (right < nums.length) {
            if(nums[right] != 0) {
                int tmp = nums[right];
                nums[right] = nums[left];
                nums[left] = tmp;
                left ++;
            }
            right ++;

        }
        System.out.println(Arrays.toString(nums));
    }

    public static void main(String[] args) {
//        moveZeros2Right(new int[] {1, 0, 3, 10, 0, -1});
        moveZeros2Left(new int[] {1, 0, 3, 10, 0, -1});
//        moveZeros2Right(new int[] {1, 0, 3, 10, 0, -1, 0});
//        moveZeros2Right(new int[] {1, 0, 3, 10, 0, 0, 0});
//        moveZeros2Right(null);
//        moveZeros2Right(new int[] {});
    }

}
