package com.cosy.sun.jdk.algorithm.leetcode;

public class LC8 {

    public static void main(String[] args) {
        LC8 lc8 = new LC8();
        int i = lc8.myAtoi("   -42");
        System.out.println(i);
    }

    public int myAtoi(String s) {
        int sign = 0;
        int k = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c == ' ') {
                continue;
            }
            if(c == '-') {
                sign = -1;
                k = i;
                break;
            }
        }
        String substring = s.substring(k + 1);
        Integer i = Integer.valueOf(substring);
        int i1 = i * sign;
        return i1;
    }

}
