package com.cosy.sun.algorithm.leetcode;

import com.cosy.sun.util.DemoUtilUtils;
import org.junit.jupiter.api.Test;

public class LC169Test {

    @Test
    public void majorityElement() {

        int i = LC169.majorityElement(DemoUtilUtils.genRandomArray(10));
        System.out.println(i);

    }
}