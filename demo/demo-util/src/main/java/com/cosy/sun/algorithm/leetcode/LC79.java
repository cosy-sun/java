package com.cosy.sun.algorithm.leetcode;

public class LC79 {

    public static boolean exist(char[][] board, String word) {
        int h = board.length;
        int w = board[0].length;

        boolean[][] boardTmp = new boolean[h][w];

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if(check(board, boardTmp, i, j, word, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean check(char[][] board, boolean[][] boardTmp, int i, int j, String word, int i1) {
        if(board[i][j] != word.charAt(i1)) {
            return false;
        } else if (i1 == word.length() - 1) {
            return true;
        }

        boardTmp[i][j] = true;

        int[][] directions = {{0, 1}, {0, -1}, {1, 0},{-1, 0}};
        boolean result = false;

        for (int[] dir : directions) {
            int newi = i + dir[0], newj = j + dir[1];
            if (newi >= 0 && newi < board.length && newj >= 0 && newj < board[0].length) {
                if (!boardTmp[newi][newj]) {
                    boolean flag = check(board, boardTmp, newi, newj, word, i1 + 1);
                    if (flag) {
                        result = true;
                        break;
                    }
                }
            }

        }
        boardTmp[i][j] = false;
        return result;
    }

}
