package com.cosy.sun.jdk.algorithm.leetcode;

public class LC238 {

    public static void main(String[] args) {
        LC238 lc238 = new LC238();
        lc238.productExceptSelf(new int[] {2, 3, 4, 1, 4, 1,7,8});
    }

    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int[] left = new int[len];
        int[] right = new int[len];

        int product = 1;
        for (int i = 0; i < len; i++) {
            left[i] = i != 0 ? product = product * nums[i - 1] :  product;
        }

        product = 1;
        for (int i = len - 1; i >= 0; i--) {
            right[i] = i != len - 1 ? product = product * nums[i + 1] : product;
        }

        int[] ans = new int[len];
        for (int i = 0; i < len; i++) {
            ans[i] = left[i] * right[i];
        }
        return ans;
        
    }

}
