package com.cosy.sun.algorithm.leetcode;

import org.junit.jupiter.api.Test;

import static com.cosy.sun.algorithm.leetcode.LC128.longestConsecutive;

class LC128Test {

    @Test
    void longestConsecutiveTest() {

        longestConsecutive(new int[]{100, 2, 4, 6, 5, 3});
        longestConsecutive(new int[]{100,4,200,1,3,2});
        longestConsecutive(new int[]{100, 2, 4, 6, 2, 3, 3, 4, 5, 5});
        longestConsecutive(new int[]{9,1,4,7,3,-1,0,5,8,-1,6});
        longestConsecutive(new int[]{100, 89, 2, 6, 10, 70});
        longestConsecutive(new int[]{});
        longestConsecutive(null);

    }
}