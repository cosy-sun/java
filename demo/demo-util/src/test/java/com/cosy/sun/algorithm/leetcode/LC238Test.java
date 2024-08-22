package com.cosy.sun.algorithm.leetcode;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class LC238Test {

    @Test
    public void productExceptSelfTest() {
        int[] ints = LC238.productExceptSelf(new int[]{1,2,3,4});
        System.out.println(Arrays.toString(ints));
    }
}