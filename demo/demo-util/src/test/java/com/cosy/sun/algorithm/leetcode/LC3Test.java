package com.cosy.sun.algorithm.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class LC3Test {

    @Test
    void testMaxLengthSub() {
        int result = LC3.maxLengthSub("sabcdes");
        Assertions.assertEquals(6, result);
    }
}
