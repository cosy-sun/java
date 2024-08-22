package com.cosy.sun.algorithm.leetcode;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class LC48Test {

    @Test
    public void rotateTest() {
        int[][] ints = {{1, 2, 3,13}, {4, 5, 6,14}, {7, 8, 9,15}, {10, 11, 12,16}};
        LC48.rotate(ints);
        for (int[] arr : ints) {
            System.out.println(Arrays.toString(arr));
        }
    }
}