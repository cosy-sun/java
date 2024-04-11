package com.cosy.sun.jdk.algorithm.leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class LC128 {

    public static int longestConsecutive(int[] nums) {
        if(Objects.isNull(nums) || nums.length == 0) {
            return 0;
        }
        Set<Integer> ints = new HashSet<>();
        for(int num : nums) {
            ints.add(num);
        }
        Integer[] array = ints.toArray(new Integer[ints.size()]);
        Arrays.sort(array);
        int max = 1;
        int tmpMax = 1;
        for (int i = 1; i < array.length; i++) {
            if(array[i] - 1 == array[i - 1]) {
                tmpMax ++;
            } else {
                tmpMax = 1;
            }
            max = Math.max(max, tmpMax);
        }
        System.out.println(max);
        return max;
    }

    public static void main(String[] args) {
        longestConsecutive(new int[]{100, 2, 4, 6, 5, 3});
        longestConsecutive(new int[]{100,4,200,1,3,2});
        longestConsecutive(new int[]{100, 2, 4, 6, 2, 3, 3, 4, 5, 5});
        longestConsecutive(new int[]{9,1,4,7,3,-1,0,5,8,-1,6});
        longestConsecutive(new int[]{100, 89, 2, 6, 10, 70});
        longestConsecutive(new int[]{});
        longestConsecutive(null);
    }

}
