package com.cosy.sun.algorithm.leetcode;

import java.util.*;

public class LC49 {

    public static List<List<String>> groupArgs(String[] args) {
        Map<Integer, List<String>> map = new HashMap<>();
        for(String str : args) {
            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);
            String s = new String(charArray);
            int i = s.hashCode();
            List<String> strings = map.get(i);
            if(Objects.isNull(strings)) {
                strings = new ArrayList<>();
            }
            strings.add(str);
            map.put(i, strings);
        }
        return map.values().stream().toList();
    }

    public static void main(String[] args) {
        String[] strs = {"eat","tea","tan","ate","nat","bat"};
        List<List<String>> lists = groupArgs(strs);
        System.out.println(lists);
        String[] str2 = {"ddddddddddg","dgggggggggg"};
        List<List<String>> lists2 = groupArgs(str2);
        System.out.println(lists2);
        String[] str3 = {"e"};
        List<List<String>> lists3 = groupArgs(str3);
        System.out.println(lists3);
        String[] str4 = {"", ""};
        List<List<String>> lists4 = groupArgs(str4);
        System.out.println(lists4);
    }

}
