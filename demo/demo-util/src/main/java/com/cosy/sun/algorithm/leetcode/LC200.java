package com.cosy.sun.algorithm.leetcode;

public class LC200 {

    public static int numsIslands(char[][] grid) {
        if(grid == null || grid[0].length == 0) {
            return 0;
        }
        int ans = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == '1') {
                    dfs(grid, i, j);
                    ans ++;
                }
            }
        }
        return ans;
    }

    private static void dfs(char[][] grid, int r, int c) {
        if(!inares(grid, r, c)) {
            return ;
        }
        if(grid[r][c] == '0') {
            return;
        }
        grid[r][c] = '0';
        dfs(grid, r + 1, c);
        dfs(grid, r - 1, c);
        dfs(grid, r, c + 1);
        dfs(grid, r, c - 1);
    }


    private static boolean inares(char[][] grid, int r, int c) {
        return r >= 0
                && r < grid.length
                && c < grid[0].length
                && c >= 0;
    }

}
