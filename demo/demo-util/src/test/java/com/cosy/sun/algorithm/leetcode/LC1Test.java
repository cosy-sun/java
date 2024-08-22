package com.cosy.sun.algorithm.leetcode;

import com.cosy.sun.util.DemoUtilUtils;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

public class LC1Test {

    @Test
    public void sum() {
        int[] a = DemoUtilUtils.genRandomArray(10);
        int target = 4;
        List<Object> sum = Collections.singletonList(LC1.sum1(a, target));
    }

}