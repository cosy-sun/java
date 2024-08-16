package com.cosy.sun.algorithm.leetcode;

import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

class LC1Test {

    @Test
    void sum() {
        int[] a = {1,3,5,6,3,213,432,13};
        int target = 4;
        List<Object> sum = Collections.singletonList(LC1.sum1(a, target));
    }

}