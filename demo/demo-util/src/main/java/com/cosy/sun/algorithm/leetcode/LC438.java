package com.cosy.sun.algorithm.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC438 {

    public static void main(String[] args) {
//        findAnagrams("cbaebabacd", "abc");
//        findAnagrams("abab", "ab");
        int[] ins = new int[26];
        String str= "abab";
        for (int i = 0; i < 4; i++) {
            ++ins[str.charAt(i) - 'a'];
        }
        System.out.println(Arrays.toString(ins));
    }

    public static List<Integer> findAnagrams(String source, String target) {
        char[] charArray1 = target.toCharArray();
        Arrays.sort(charArray1);
        int targetHashCode = new String(charArray1).hashCode();

        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i <= source.length() - target.length(); i++) {
            String substring = source.substring(i, i + target.length());
            if(isAnagrams(substring, targetHashCode)) {
                ans.add(i);
            }
        }
        return ans;
    }

    public static boolean isAnagrams(String source, int target) {
        char[] charArray = source.toCharArray();
        Arrays.sort(charArray);
        String s = new String(charArray);
        return s.hashCode() == target;
    }

    public List<Integer> findAnagrams4(String s, String p) {
        int sLen = s.length(), pLen = p.length();

        if (sLen < pLen) {
            return new ArrayList<>();
        }

        List<Integer> ans = new ArrayList<>();
        int[] count = new int[26];
        for (int i = 0; i < pLen; ++i) {
            ++count[s.charAt(i) - 'a'];
            --count[p.charAt(i) - 'a'];
        }

        int differ = 0;
        for (int j = 0; j < 26; ++j) {
            if (count[j] != 0) {
                ++differ;
            }
        }

        if (differ == 0) {
            ans.add(0);
        }

        for (int i = 0; i < sLen - pLen; ++i) {
            if (count[s.charAt(i) - 'a'] == 1) {
                // 窗口中字母 s[i] 的数量与字符串 p 中的数量从不同变得相同
                --differ;
            } else if (count[s.charAt(i) - 'a'] == 0) {
                // 窗口中字母 s[i] 的数量与字符串 p 中的数量从相同变得不同
                ++differ;
            }
            --count[s.charAt(i) - 'a'];

            if (count[s.charAt(i + pLen) - 'a'] == -1) {
                // 窗口中字母 s[i+pLen] 的数量与字符串 p 中的数量从不同变得相同
                --differ;
            } else if (count[s.charAt(i + pLen) - 'a'] == 0) {
                // 窗口中字母 s[i+pLen] 的数量与字符串 p 中的数量从相同变得不同
                ++differ;
            }
            ++count[s.charAt(i + pLen) - 'a'];

            if (differ == 0) {
                ans.add(i + 1);
            }
        }

        return ans;
    }
}