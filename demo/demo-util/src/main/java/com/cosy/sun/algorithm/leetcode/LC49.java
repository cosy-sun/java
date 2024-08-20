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

}
