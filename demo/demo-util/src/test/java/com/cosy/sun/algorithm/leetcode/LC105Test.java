package com.cosy.sun.algorithm.leetcode;

import com.cosy.sun.algorithm.bean.TreeNode;
import org.junit.jupiter.api.Test;

public class LC105Test {

    @Test
    public void buildTreeTest() {
        int[] pre = {3, 9, 20, 15, 7};
        int[] inorder = {9, 3, 15, 20, 7};
        TreeNode treeNode = LC105.buildTree(pre, inorder);
        System.out.println(treeNode);
    }
}