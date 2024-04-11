package com.cosy.sun.jdk.algorithm.leetcode;

public class LC240 {

    public static void main(String[] args) {
        LC240 lc240 = new LC240();
        int[][] req = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        boolean b = lc240.searchMatrix(req, 10);
        System.out.println(b);
    }

    public boolean searchMatrix(int[][] matrix, int target) {
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
    public boolean searchMatrix1(int[][] matrix, int target) {
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
