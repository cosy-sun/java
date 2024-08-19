package com.cosy.sun.algorithm.leetcode;

import com.cosy.sun.algorithm.AlgorithmUtil;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

public class LC1Test {

    @Test
    public void sum() {
        int[] a = AlgorithmUtil.genRandomArray(10);
        int target = 4;
        List<Object> sum = Collections.singletonList(LC1.sum1(a, target));
    }

}