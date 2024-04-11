package com.cosy.sun.jdk.algorithm.leetcode;

public class LC41 {

    public static void main(String[] args) {
        LC41 lc41 = new LC41();
        int i = lc41.firstMissingPositive(new int[]{4, 3, 2, 1});
        System.out.println(i);
    }

    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; ++i) {
            while (nums[i] > 0 && nums[i] <= n && nums[nums[i] - 1] != nums[i]) {
                int temp = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = temp;
            }
        }
        for (int i = 0; i < n; ++i) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }
        return n + 1;
    }

}
