package com.cosy.sun.jdk.algorithm.leetcode;

import java.util.HashMap;

public class LC560 {

    public static void main(String[] args) {
//        System.out.println(subArraySum(new int[]{1, 1, 1, -1, 0, 2}, 2));
        System.out.println(optimizeSubArraySum(new int[]{1, 1, 1, -1, 0, 2}, 2));
    }

    public static int subArraySum(int[] nums, int k) {
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            int tmpSum = 0;
            for (int j = i; j < nums.length; j++) {
                tmpSum += nums[j];
                if(tmpSum == k) {
                    ans ++;
                }
            }
        }
        return ans;
    }

    public static int optimizeSubArraySum(int[] nums, int k) {
        int count = 0, pre = 0;
        HashMap< Integer, Integer > mp = new HashMap < > ();
        mp.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            pre += nums[i];
            if (mp.containsKey(pre - k)) {
                count += mp.get(pre - k);
            }
            mp.put(pre, mp.getOrDefault(pre, 0) + 1);
        }
        return count;
    }

}
