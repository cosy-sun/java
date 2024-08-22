package com.cosy.sun.algorithm.leetcode;

import org.junit.jupiter.api.Test;

import static com.cosy.sun.algorithm.leetcode.LC560.optimizeSubArraySum;
import static com.cosy.sun.algorithm.leetcode.LC560.subArraySum;

public class LC560Test {

    @Test
    public void subArraySumTest() {
        System.out.println(optimizeSubArraySum(new int[]{1, 1, 1, -1, 0, 2}, 2));
    }

    @Test
    public void optimizeSubArraySumTest() {
        System.out.println(subArraySum(new int[]{1, 1, 1, -1, 0, 2}, 2));
    }
}