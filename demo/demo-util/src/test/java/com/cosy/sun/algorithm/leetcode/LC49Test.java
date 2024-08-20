package com.cosy.sun.algorithm.leetcode;

import org.junit.jupiter.api.Test;

import java.util.List;

import static com.cosy.sun.algorithm.leetcode.LC49.groupArgs;

public class LC49Test {

    @Test
    public void groupArgsTest() {
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