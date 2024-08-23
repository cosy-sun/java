package com.cosy.sun.algorithm.leetcode;

import com.cosy.sun.algorithm.bean.TreeNode;
import org.junit.jupiter.api.Test;

public class LC114Test {

    @Test
    public void flatternTest() {
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        treeNode1.left = treeNode2;
        LC114.flattern(treeNode1);
        System.out.println(treeNode1);
    }
}