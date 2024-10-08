package com.cosy.sun.algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

public class LC54 {

    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();

        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return ans;
        }
        int left = 0;
        int right = matrix[0].length - 1;
        int top = 0;
        int bottom = matrix.length - 1;
        while(left <= right && top <= bottom) {
            for (int i = left; i <= right; i++) {
                ans.add(matrix[top][i]);
            }
            top ++;
            for (int i = top; i <= bottom; i++) {
                ans.add(matrix[i][right]);
            }
            right --;
            for (int i = right; i >= left; i--) {
                ans.add(matrix[bottom][i]);
            }
            bottom --;
            for (int i = bottom; i >= top; i--) {
                ans.add(matrix[i][left]);
            }
            left ++;
        }
        return ans;
    }

}
