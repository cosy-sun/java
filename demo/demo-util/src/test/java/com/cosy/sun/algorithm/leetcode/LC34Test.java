package com.cosy.sun.algorithm.leetcode;

import org.junit.jupiter.api.Test;

public class LC34Test {

    @Test
    public void searchRangeTest() {
        int[] nums = {1, 2, 3,3, 4};
        LC34 lc34 = new LC34();
        int[] ints = lc34.searchRange(nums, 3);
        System.out.println(ints);
    }
}