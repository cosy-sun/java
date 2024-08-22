package com.cosy.sun.algorithm.leetcode;

import org.junit.jupiter.api.Test;

public class LC11Test {

    @Test
    public void maxArea() {
        int[] ints = {1,8,6,2,5,4,8,3,7};
        int i1 = LC11.maxArea(ints);
        System.out.println(i1);
    }
}