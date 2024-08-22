package com.cosy.sun.algorithm.leetcode;

import org.junit.jupiter.api.Test;

public class LC240Test {
    int[][] req = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
    @Test
    public void searchMatrixTest() {
        boolean b = LC240.searchMatrix(req, 10);
        System.out.println(b);
    }

    @Test
    public void searchMatrix1Test() {
        boolean b = LC240.searchMatrix1(req, 10);
        System.out.println(b);
    }
}