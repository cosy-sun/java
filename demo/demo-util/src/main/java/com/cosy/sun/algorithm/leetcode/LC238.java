package com.cosy.sun.algorithm.leetcode;

public class LC238 {

    public static int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int[] left = new int[len];
        int[] right = new int[len];

        for (int i = 0; i < len; i++) {
            left[i] = i != 0 ? nums[i] * left[i - 1] :  nums[i];
        }

        for (int i = len - 1; i >= 0; i--) {
            right[i] = i != len - 1 ? nums[i] * right[i + 1] : nums[i];
        }

        int[] ans = new int[len];
        for (int i = 1; i < len - 1; i++) {
            ans[i] = left[i - 1] * right[i + 1];
        }
        ans[0] = right[1];
        ans[len - 1] = left[len - 2];
        return ans;
        
    }

}
