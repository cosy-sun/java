package com.cosy.sun.algorithm.leetcode;

import org.junit.jupiter.api.Test;

import java.util.List;

public class LC438Test {

    String source = "abcabc";
    String taget = "abc";

    @Test
    public void findAnagramsTest() {
        List<Integer> anagrams = LC438.findAnagrams(source, taget);
        System.out.println(anagrams);
    }

    @Test
    public void findAnagrams2Test() {
        List<Integer> anagrams = LC438.findAnagrams2(source, taget);
        System.out.println(anagrams);
    }
}