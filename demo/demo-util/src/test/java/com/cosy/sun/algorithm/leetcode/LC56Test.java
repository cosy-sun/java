package com.cosy.sun.algorithm.leetcode;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class LC56Test {

    @Test
    public void mergeTest() {

        int[][] arr = {{1,3}, {2,4}, {8, 10}, {6, 9}};
        int[][] merge = LC56.merge(arr);
        System.out.println(Arrays.toString(merge));

    }
}