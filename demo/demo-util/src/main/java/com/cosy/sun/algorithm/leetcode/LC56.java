package com.cosy.sun.algorithm.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class LC56 {

    public static int[][] merge(int[][] intervals) {
        if(intervals.length == 0) {
            return new int[0][2];
        }

        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));

        List<int[]> merged = new ArrayList<>();
        for (int i = 0; i < intervals.length; i++) {
            int left = intervals[i][0];
            int right = intervals[i][1];
            if(merged.size() == 0 || merged.get(merged.size() - 1)[1] < left) {
                merged.add(new int[] {left, right});
            } else {
                int[] ints = merged.get(merged.size() - 1);
                ints[1] = Math.max(ints[1], right);
            }
        }
        return merged.toArray(new int[0][0]);
    }

}
