package com.cosy.sun.algorithm.leetcode;

public class LC73 {

    public void setZeros(int[][] matrix) {
        boolean[] bool1 = new boolean[matrix.length];
        boolean[] bool2 = new boolean[matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if(matrix[i][j] == 0) {
                    bool1[i] = true;
                    bool2[j] = true;
                }
            }

        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if(bool1[i] || bool2[j]) {
                    matrix[i][j] = 0;
                }
            }
        }
    }

}
