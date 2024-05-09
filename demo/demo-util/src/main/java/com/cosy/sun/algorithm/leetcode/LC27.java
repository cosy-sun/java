package com.cosy.sun.algorithm.leetcode;

public class LC27 {

    public static void main(String[] args) {
        LC27 lc27 = new LC27();
        int[] ints = {2, 2, 3, 3, 4};
        int i = lc27.removeElement(ints, 2);
        System.out.println(i);

    }

    public int removeElement(int[] nums, int val) {
        int left = 0;
        int right = nums.length;
        while(left < right) {
            if(nums[left] == val) {
                nums[left] = nums[right - 1];
                right --;
            } else {
                left ++;
            }
        }
        return left;
    }

}
