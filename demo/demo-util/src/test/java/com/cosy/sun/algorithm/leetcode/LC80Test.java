package com.cosy.sun.algorithm.leetcode;

import org.junit.jupiter.api.Test;

class LC80Test {

    @Test
    void removeDuplicates() {

        int[] arr = {0,0,1,1,2,2,2,3,3,3,4,4,4};
        int i1 = LC80.removeDuplicates(arr);
        System.out.println(i1);

    }
}