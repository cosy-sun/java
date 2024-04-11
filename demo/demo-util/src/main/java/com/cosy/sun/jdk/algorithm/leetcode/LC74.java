package com.cosy.sun.jdk.algorithm.leetcode;

public class LC74 {

    public static void main(String[] args) {
        LC74 lc74 = new LC74();
        boolean b = lc74.searchMatrixOptime(new int[][]{{1}}, 1);
        System.out.println(b);
    }

    public boolean searchMatrixOptime(int[][] matrix, int target) {
        int deepth = matrix.length;
        int width = matrix[0].length;
        if(target < matrix[0][0] || target > matrix[deepth - 1][width - 1]) {
            return false;
        }
        for (int i = 0; i < deepth; i++) {
            int first = matrix[i][0];
            int last = matrix[i][width - 1];
            if(first <= target && target <= last) {
                for (int j = 0; j < width; j++) {
                    int matrix1 = matrix[i][j];
                    if(matrix1 == target) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean searchMatrix(int[][] mertrix, int target) {
        for (int i = 0; i < mertrix.length; i++) {
            for (int j = 0; j < mertrix[i].length; j++) {
                int num = mertrix[i][j];
                if(num == target) {
                    return true;
                }
            }

        }
        return false;
    }

}
