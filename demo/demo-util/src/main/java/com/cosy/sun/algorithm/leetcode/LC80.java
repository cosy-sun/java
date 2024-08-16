package com.cosy.sun.algorithm.leetcode;

public class LC80 {

    public static int removeDuplicates(int[] nums) {
        int tmp = nums[0];
        int count = 0;
        int deleteCount = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == Integer.MIN_VALUE) {
                break;
            }
            if (tmp == nums[i]) {
                count ++;
                if (count > 2) {
                    deleteCount ++;
                    for (int j = i + 1; j < nums.length; j++) {
                        nums[j - 1] = nums[j];
                    }
                    nums[nums.length - 1] = Integer.MIN_VALUE;
                    i --;
                }
            } else {
                count = 1;
                tmp = nums[i];
            }
            for (int jjk = 0; jjk < nums.length; jjk++) {
                System.out.print(nums[jjk]);
            }
            System.out.println();
        }
        return nums.length - deleteCount;
    }

}
