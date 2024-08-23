package com.cosy.sun.algorithm.leetcode;

import org.junit.jupiter.api.Test;

public class LC200Test {

    @Test
    public void numsIslandsTest() {
        char[][] grid = {
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}
        };

        int cnt = LC200.numsIslands(grid);

    }
}