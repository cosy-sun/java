package com.cosy.sun.algorithm.leetcode;

public class LC191 {

    public static int hammingWeight(int n) {
        String binaryString = Integer.toBinaryString(n);
        int cnt = 0;
        for (int i = 0; i < binaryString.length(); i++) {
            cnt += binaryString.charAt(i) - '0';
        }
        return cnt;
    }

}
