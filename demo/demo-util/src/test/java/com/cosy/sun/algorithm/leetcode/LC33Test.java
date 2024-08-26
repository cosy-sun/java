package com.cosy.sun.algorithm.leetcode;

import org.junit.jupiter.api.Test;

public class LC33Test {

    @Test
    public void searchTest() {
        int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15 };
        int target = 15;
        int search = LC33.search(arr, target);
        System.out.println(search);
    }
}