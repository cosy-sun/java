package com.cosy.sun.algorithm.leetcode;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class LC73Test {

    @Test
    public void setZerosTest() {
        int[][] arr = {{0,1,2,0},{3,4,5,2},{1,3,1,5}};
        LC73.setZeros(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(Arrays.toString(arr[i]));
        }
    }
}