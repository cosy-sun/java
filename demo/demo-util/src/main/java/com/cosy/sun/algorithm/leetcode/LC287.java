package com.cosy.sun.algorithm.leetcode;

public class LC287 {

    public static void main(String[] args) {
        LC287 lc287 = new LC287();
        int duplicate = lc287.findDuplicate(new int[]{1, 3, 2, 4, 7, 6, 5, 7});
        System.out.println(duplicate);
    }

    public int findDuplicate(int[] nums) {
        int slow = 0;
        int fast = 0;
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        }while(slow != fast);

        slow= 0;
        while(slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }

}
