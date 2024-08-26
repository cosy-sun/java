package com.cosy.sun.algorithm.leetcode;

import org.junit.jupiter.api.Test;

public class LC153Test {

    @Test
    public void findMinTest() {
        LC153 lc153 = new LC153();
        int min = lc153.findMin(new int[]{5, 6, 7, 8,9,10, 0, 1, 2});
        System.out.println(min);
    }
}