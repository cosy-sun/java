package com.cosy.sun.algorithm.leetcode;

import org.apache.commons.lang3.StringUtils;

public class LC28 {

    public int strstr(String haystack, String needle) {
        boolean contains = haystack.contains(needle);
        int i = StringUtils.indexOf(haystack, needle);
        return i;
    }

}
