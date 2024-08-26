package com.cosy.sun.algorithm.leetcode;

import org.junit.jupiter.api.Test;

public class LC79Test {

    @Test
    public void existTest() {
        char[][] arr = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        LC79.exist(arr, "BCCED");
    }
}