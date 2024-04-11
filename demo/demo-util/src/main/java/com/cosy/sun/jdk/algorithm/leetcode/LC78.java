package com.cosy.sun.jdk.algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

public class LC78 {

    public static void main(String[] args) {
        System.out.println(subsets(new int[] {1, 2, 3}));
    }

    public static List<List<Integer>> subsets(int... nums) {
        List<List<Integer>> ans = new ArrayList<>();
        for (int num : nums) {
            List<List<Integer>> tmpList = new ArrayList<>();
            for (List<Integer> anss : ans) {
                List<Integer> integers = new ArrayList<>(List.copyOf(anss));
                integers.add(num);
                tmpList.add(integers);
            }
            ans.addAll(tmpList);
            ans.add(List.of(num));
        }
        ans.add(List.of());
        return ans;
    }

}
