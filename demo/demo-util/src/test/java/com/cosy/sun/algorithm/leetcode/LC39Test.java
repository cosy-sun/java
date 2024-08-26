package com.cosy.sun.algorithm.leetcode;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class LC39Test {

    @Test
    public void combinationSumTest() {
        int[] arr = {1,2,3};
        List<List<Integer>> lists = LC39.combinationSum(arr, 7);
        lists.forEach(item -> System.out.println(Arrays.toString(item.toArray())));
    }

    @Test
    public void combinationSum1Test() {
        int[] arr = {1,2,3};
        List<List<Integer>> lists = LC39.combinationSum1(arr, 7);
        lists.forEach(item -> System.out.println(Arrays.toString(item.toArray())));
    }
}