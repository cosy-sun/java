package com.cosy.sun.algorithm.cuacua;

public class LuckyNum {

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8,9};
        int[] req = {1};
        long l = sumOfLeft(arr, 4, 3);
        System.out.println(l);
    }

    public static long sumOfLeft (int[] nums, int jump, int left) {
        if (left > nums.length) {
            return 0;
        }
        if (left == nums.length) {
            long sum = 0;
            for (int num : nums) {
                sum += num == -1 ? 0 : num;
            }

            return sum;
        }
        int removeCount = nums.length - left;
        int remove = 0;
        int i = 0;
        while (i < nums.length && remove < removeCount) {
            for (int j = 0; j < jump + 1; ) {
                i ++;
                if (i >= nums.length) {
                    i -=  nums.length;
                }
                int num = nums[i];
                if (num != -1) {
                    j ++;
                }
            }

            if (i >= nums.length) {
                i -=  nums.length;
            }
            remove ++;
            nums[i] = -1;
        }

        long sum = 0;
        for (int num : nums) {
            sum += num == -1 ? 0 : num;
        }

        return sum;
    }
    


}
