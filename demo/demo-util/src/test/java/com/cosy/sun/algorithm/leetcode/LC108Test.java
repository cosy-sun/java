package com.cosy.sun.algorithm.leetcode;

import com.cosy.sun.algorithm.leetcode.bean.TreeNode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class LC108Test {
    @Test
    void testSortedArrayToBST() {
        TreeNode result = LC108.sortedArrayToBST(new int[]{0, 3, 4, 5});
        Assertions.assertEquals(new TreeNode(0), result);
    }
}