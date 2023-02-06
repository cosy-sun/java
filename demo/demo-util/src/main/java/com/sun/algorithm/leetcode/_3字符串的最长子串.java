package com.sun.algorithm.leetcode;

import java.util.*;

/**
 * 给定一个字符串， 求该字符串中不重复的最长子串
 */
public class _3字符串的最长子串 {

    public static void main(String... args) {
        String str = "abcdabcaba";
        _3字符串的最长子串 instance = new _3字符串的最长子串();
        instance.maxLengthSub(str);
    }

    public void maxLengthSub(String str) {
        int length = str.length();
        int max = 0;
        String maxStr = null;
        Set<Character> set = new LinkedHashSet<>();
        int start = 0;
        int end = 0;
        while (start < length && end < length) {
            if (set.contains(str.charAt(end))) {
                Iterator<Character> iterator = set.iterator();
                while(iterator.hasNext()) {
                    Character next = iterator.next();
                    iterator.remove();
                    if(str.charAt(end) == next) {
                        break;
                    }
                }
                start ++;
            }
            set.add(str.charAt(end++));
            max = Math.max(set.size(), max);
            if(set.size() == max) {
                maxStr = Arrays.toString(set.toArray());
            }
        }
        System.out.println("最大长度" + max);
        System.out.println(maxStr);
    }

}
