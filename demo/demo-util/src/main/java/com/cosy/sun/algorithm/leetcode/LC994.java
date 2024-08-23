package com.cosy.sun.algorithm.leetcode;

public class LC994 {

    public static int orangsRotting(int[][] grid) {
        int minutes = 0;

        // 如果没有好橘子
        if(!hasGood(grid)) {
            return minutes;
        }

        int num = 2;
        while (change(grid, num)) {
            num ++;
            minutes ++;
        }

        // 如果还有好句子
        if(hasGood(grid)) {
            return -1;
        }
        return minutes;
    }

    private static boolean change(int[][] grid, int num) {
        boolean flag = false;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == num) {
                    boolean flag1 = isFlag(grid, num, i-1, j);
                    boolean flag2 = isFlag(grid, num, i+1, j);
                    boolean flag3 = isFlag(grid, num, i, j-1);
                    boolean flag4 = isFlag(grid, num, i, j+1);
                    flag = flag ? flag : flag1 || flag2|| flag3 || flag4;
                }
            }
        }
        return flag;
    }

    private static boolean isFlag(int[][] grid, int num, int i, int j) {
        if(((i >= 0 && i<grid.length) && (j >= 0 && j < grid[0].length)) && grid[i][j] == 1) {
            grid[i][j] = num + 1;
            return true;
        }
        return false;
    }


    private static boolean hasGood(int[][] grid) {
        for (int[] ints : grid) {
            for (int j = 0; j < grid[0].length; j++) {
                if (ints[j] == 1) {
                    return true;
                }
            }
        }
        return false;
    }

}
