package com.cosy.sun.algorithm.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC438 {


    public static List<Integer> findAnagrams(String source, String target) {
        int targetHashCode = getString(target).hashCode();

        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i <= source.length() - target.length(); i++) {
            String substring = source.substring(i, i + target.length());
            if(getString(substring).hashCode() == targetHashCode) {
                ans.add(i);
            }
        }
        return ans;
    }

    private static String getString(String source) {
        char[] charArray = source.toCharArray();
        Arrays.sort(charArray);
        return new String(charArray);
    }

    public static List<Integer> findAnagrams2(String s, String p) {
        int sLen = s.length(), pLen = p.length();

        if (sLen < pLen) {
            return new ArrayList<Integer>();
        }

        List<Integer> ans = new ArrayList<Integer>();
        int[] sCount = new int[26];
        int[] pCount = new int[26];
        for (int i = 0; i < pLen; ++i) {
            ++sCount[s.charAt(i) - 'a'];
            ++pCount[p.charAt(i) - 'a'];
        }

        if (Arrays.equals(sCount, pCount)) {
            ans.add(0);
        }

        for (int i = 0; i < sLen - pLen; ++i) {
            --sCount[s.charAt(i) - 'a'];
            ++sCount[s.charAt(i + pLen) - 'a'];

            if (Arrays.equals(sCount, pCount)) {
                ans.add(i + 1);
            }
        }

        return ans;
    }
}