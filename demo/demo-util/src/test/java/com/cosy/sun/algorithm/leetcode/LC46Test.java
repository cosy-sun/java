package com.cosy.sun.algorithm.leetcode;

import org.junit.jupiter.api.Test;

import java.util.List;

public class LC46Test {

    @Test
    public void permuteTest() {
        List<List<Integer>> permute = LC46.permute(new int[]{1, 2, 3});
        System.out.println(permute);
    }
}