package com.cosy.sun.algorithm.leetcode;

public class LC169 {

    public static int majorityElement(int[] nums) {
        int condition = 0;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if(count == 0) {
                condition = num;
            }
            if(num == condition) {
                count ++;
            } else {
                count --;
            }
        }
        return condition;
    }

}
