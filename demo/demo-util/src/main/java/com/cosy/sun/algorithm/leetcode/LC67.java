package com.cosy.sun.algorithm.leetcode;

import java.util.Arrays;

public class LC67 {

    public static String binarySum(String a, String b) {
        String tmpa = a;
        String tmpb = b;
        int aLen = a.length();
        int bLen = b.length();
        int maxLen = Math.max(aLen, bLen);
        String pre = new String(new char[maxLen - (Math.min(aLen, bLen))]).replace("\u0000", "0");
        if (aLen > bLen) {
            tmpb = pre + tmpb;
        } else {
            tmpa = pre + tmpa;
        }
        char[] chars = new char[maxLen + 1];
        int index = maxLen - 1;
        int preAdd = 0;
        while (index >= 0) {
            int inta = Integer.parseInt(tmpa.substring(index, index + 1));
            int intb = Integer.parseInt(tmpb.substring(index, index + 1));
            int intSum = inta + intb + preAdd;
            chars[index + 1] = intSum % 2 == 0 ? '0' : '1';
            preAdd = intSum / 2;
            index --;
        }
        if (preAdd == 1) {
            chars[0] = '1';
        } else {
            chars = Arrays.copyOfRange(chars, 1, chars.length);
        }
        return new String(chars);
    }

}
