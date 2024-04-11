package com.cosy.sun.jdk.algorithm.leetcode;

public class LC45 {

    public static void main(String[] args) {
//        System.out.println(jump(new int[]{2, 3, 1, 1, 4}));
//        System.out.println(jump(new int[]{2, 3, 0, 1, 4}));
        System.out.println(jump(new int[]{2, 1}));
    }

    public static int jump(int... nums) {
        int k = 0;
        int end = 0;
        int ans = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            k = Math.max(k, nums[i] + i);
            if(i == end) {
                end = k;
                ans ++;
            }
        }
        return ans;
    }

}
