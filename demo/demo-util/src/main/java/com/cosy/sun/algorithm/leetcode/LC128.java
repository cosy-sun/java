package com.cosy.sun.algorithm.leetcode;

import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;

public class LC128 {

    public static int longestConsecutive(int[] nums) {
        if(Objects.isNull(nums) || nums.length == 0) {
            return 0;
        }
        // 先用hashset排序一下，
        Set<Integer> ints = new TreeSet<>();
        for(int num : nums) {
            ints.add(num);
        }

        int max = 0;
        // 遍历hash，获取最长的
        for (int num : ints) {
            if (!ints.contains(num - 1)) {
                int currentNum = num;
                int currentLen = 1;
                while (ints.contains(++ currentNum)) {
                    currentLen ++;
                }
                max = Math.max(max, currentLen);
            }
        }

        return max;
    }


}
