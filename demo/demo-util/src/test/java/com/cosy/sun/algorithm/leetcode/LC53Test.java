package com.cosy.sun.algorithm.leetcode;

import org.junit.jupiter.api.Test;

public class LC53Test {

    int[] arr = new int[] {-2,-1,-3,-1,-1,-5};

    @Test
    public void maxSubArraySumTest() {
        System.out.println(LC53.maxSubArraySum(arr));
    }

    @Test
    public void maxSubArrayTest() {
        System.out.println(LC53.maxSubArray(arr));
    }
}