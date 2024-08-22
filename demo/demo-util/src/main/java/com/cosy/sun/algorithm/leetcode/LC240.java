package com.cosy.sun.algorithm.leetcode;

public class LC240 {

    public static boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int x= 0;
        int y = n -1;
        while(x < m && y >=0) {
            if(matrix[x][y] == target) {
                return true;
            }
            if(matrix[x][y] > target) {
                y --;
            } else {
                x ++;
            }
        }
        return false;
    }

    /**
     * 最笨的方法
     * @param matrix
     * @param target
     * @return
     */
    public static boolean searchMatrix1(int[][] matrix, int target) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if(matrix[i][j] == target) {
                    return true;
                }
            }
        }
        return false;
    }

}
