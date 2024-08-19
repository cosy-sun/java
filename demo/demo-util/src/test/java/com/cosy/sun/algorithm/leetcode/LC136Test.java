package com.cosy.sun.algorithm.leetcode;

import org.junit.jupiter.api.Test;

class LC136Test {

    @Test
    void singleNumber1() {
        int[] ints = {4,1,2,1,2};
        int i = LC136.singleNumber1(ints);
        System.out.println(i);

    }
}