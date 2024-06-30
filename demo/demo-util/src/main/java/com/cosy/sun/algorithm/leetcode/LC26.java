package com.cosy.sun.algorithm.leetcode;

public class LC26 {

    public int removeDuplicates(int[] nums) {
        if(nums == null || nums.length == 0) {
            return 0;
        }
        int p = 0;
        int q = 1;
        while (q < nums.length) {
            if(nums[p] != nums[q]) {
                nums[++p] = nums[q];
            }
            q ++;
        }
        return p + 1;
    }

}
