package com.cosy.sun.algorithm.leetcode;

import org.junit.jupiter.api.Test;

public class LC74Test {

    @Test
    public void searchMatrixOptimeTest() {
        LC74 lc74 = new LC74();
        boolean b = lc74.searchMatrixOptime(new int[][]{{1, 2}, {3, 4}}, 4);
        System.out.println(b);
    }
}