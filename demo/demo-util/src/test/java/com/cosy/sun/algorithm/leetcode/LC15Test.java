package com.cosy.sun.algorithm.leetcode;

import org.junit.jupiter.api.Test;

import java.util.List;

import static com.cosy.sun.algorithm.leetcode.LC15.threeSum;

public class LC15Test {

    @Test
    public void threeSumTest() {
        int[] nums = {1, 0, -1, -1, -2, 0, 2};
        List<List<Integer>> lists = threeSum(nums);
        System.out.println(lists);
    }
}