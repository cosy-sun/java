package com.cosy.sun.jdk.algorithm.leetcode;

public class LC279 {

    public static void main(String[] args) {
        LC279 lc279 = new LC279();
        int i = lc279.numSquares(10);
        System.out.println(i);
    }

    public int numSquares(int n) {
        int[] f = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            int minn = Integer.MAX_VALUE;
            for (int j = 1; j*j <= i; j++) {
                minn = Math.min(minn, f[i - j * j]);
            }
            f[i] = minn + 1;
        }
        return f[n];
    }

}
