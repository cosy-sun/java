package com.cosy.sun.algorithm.leetcode;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class LC54Test {

    @Test
    public void spiralOrderTest() {
        int[][] arr = {{1,2,3},{4,5,6},{7,8,9}};
        List<Integer> integers = LC54.spiralOrder(arr);
        System.out.println(Arrays.toString(integers.toArray(new Integer[0])));
    }
}