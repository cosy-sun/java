package com.cosy.sun.algorithm.leetcode;

public class LC6 {

    public static void main(String[] args) {
        String abcdef = convert("abcdef", 3);
        System.out.println(abcdef);
    }

    public static String convert(String s, int numRows) {
        int n = s.length();
        if (numRows == 1 || numRows >= n) {
            return s;
        }
        int t = numRows * 2 - 2;
        int c = (n + t - 1) / t * (numRows - 1);
        char[][] mat = new char[numRows][c];
        for (int i = 0, x = 0, y = 0; i < n; ++i) {
            mat[x][y] = s.charAt(i);
            if (i % t < numRows - 1) {
                ++x; // 向下移动
            } else {
                --x;
                ++y; // 向右上移动
            }
        }
        StringBuilder ans = new StringBuilder();
        for (char[] row : mat) {
            for (char ch : row) {
                if (ch != 0) {
                    ans.append(ch);
                }
            }
        }
        return ans.toString();
    }
}
