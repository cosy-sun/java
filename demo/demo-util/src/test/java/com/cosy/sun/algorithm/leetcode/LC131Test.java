package com.cosy.sun.algorithm.leetcode;

import com.cosy.sun.util.DemoUtilUtils;
import org.junit.jupiter.api.Test;

import java.util.List;

public class LC131Test {

    @Test
    public void partitionTest() {
        List<List<String>> aabbcc = LC131.partition("aabbcc");
        DemoUtilUtils.toString(aabbcc);
    }
}