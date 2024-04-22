package com.cosy.sun.algorithm.leetcode;

import java.util.*;

public class LC17 {

    private static Map<String, List<Character>> map = new HashMap<>();

    static {
        map.put("2", Arrays.asList('a', 'b', 'c'));
        map.put("3", Arrays.asList('d', 'e', 'f'));
        map.put("4", Arrays.asList('i', 'g', 'h'));
        map.put("5", Arrays.asList('j', 'k', 'l'));
        map.put("6", Arrays.asList('m', 'n', 'o'));
        map.put("7", Arrays.asList('p', 'q', 'r', 's'));
        map.put("8", Arrays.asList('t', 'u', 'v'));
        map.put("9", Arrays.asList('w', 'x', 'y', 'z'));
    }

    public static void main(String[] args) {
        System.out.println(letterCombinations("234"));
    }

    public static List<String> letterCombinations(String digests) {
        if(digests.length() == 0) {
            return new ArrayList<>();
        }
        List<String> list = map.get(String.valueOf(digests.charAt(0))).stream().map(String::valueOf).toList();
        if(digests.length() == 1) {
            return list;
        }
        return merge(list, digests, 1);
    }

    private static List<String> merge(List<String> tmpList, String digests, int index) {
        if(digests.length() == index) {
            return tmpList;
        }
        List<String> list = map.get(String.valueOf(digests.charAt(index))).stream().map(String::valueOf).toList();
        List<String> ans = new ArrayList<>();
        for (String str : tmpList) {
            for (String ot : list) {
                ans.add(str + ot);
            }
        }
        return merge(ans, digests, ++ index);
    }

}
