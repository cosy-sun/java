package com.cosy.sun.jdk.algorithm.leetcode;

public class LC153 {

    public static void main(String[] args) {
        LC153 lc153 = new LC153();
        int min = lc153.findMin(new int[]{5, 6, 7, 0, 1, 2});
        System.out.println(min);
    }

    public int findMin(int[] nums) {
        int low = 0;
        int high = nums.length - 1;
        while(low < high) {
            int mid = low + (high - low) / 2;
            if(nums[mid] < nums[high]) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return nums[low];
    }

}
