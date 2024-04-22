package com.cosy.sun.algorithm.leetcode;

public class LC169 {

    public static void main(String[] args) {
        LC169 lc169 = new LC169();
        int i = lc169.majorityElement(new int[]{2, 2, 2, 3, 4, 5, 1, 2, 1, 1, 1});
        System.out.println(i);
    }

    public int majorityElement(int[] nums) {
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
