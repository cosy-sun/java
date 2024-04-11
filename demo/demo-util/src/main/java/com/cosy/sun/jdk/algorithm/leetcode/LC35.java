package com.cosy.sun.jdk.algorithm.leetcode;

public class LC35 {

    public static void main(String[] args) {
        LC35 lc35 = new LC35();
        lc35.searchInsert(new int[]{1, 2, 3, 6, 7}, 6);
    }

    public int searchInsert(int[] nums, int target) {
        int n = nums.length;
        int left = 0;
        int right = n -1;
        int ans = n;
        while (left <= right) {
            int mid = ((right - left) >> 1) + left;
            if(target <= nums[mid]) {
                ans = mid;
                right = mid -1;
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }

}
