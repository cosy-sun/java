package com.cosy.sun.algorithm.leetcode;

import java.util.Arrays;

public class LC3131 {

    public static int addedInteger(int[] num1, int[] num2) {
        int i1 = Arrays.stream(num2).max().getAsInt() - Arrays.stream(num1).max().getAsInt();
        return i1;
    }

}
