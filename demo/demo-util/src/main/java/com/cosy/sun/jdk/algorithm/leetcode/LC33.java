package com.cosy.sun.jdk.algorithm.leetcode;

public class LC33 {

    public int search(int[] nums, int target) {
        int n = nums.length;
        if(n == 0) {
            return -1;
        }
        if(n == 1) {
            return target == nums[0] ? 0 : -1;
        }
        int left = 0;
        int right = nums.length - 1;
        while(left <= right) {
            int mid = (right + left) /2;
            if(nums[mid] == target) {
                return mid;
            }
            if(nums[0] <= nums[mid]) {
                if(nums[0] <= target && target <= nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                if(nums[mid] < target && target <= nums[n - 1]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }

}
