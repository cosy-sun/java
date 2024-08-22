package com.cosy.sun.algorithm.leetcode;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class LC189Test {

    @Test
    public void lunzhaunTest() {
        int arrs[] = {1, 2,3,4,5,6,7};
        LC189.lunzhaun(arrs, 3);
        System.out.println(Arrays.toString(arrs));
    }

    @Test
    public void reverseTest() {
        int arrs[] = {1,2,3,4,5,6,7};
        LC189.reverse(arrs, 3);
        System.out.println(Arrays.toString(arrs));
    }
}