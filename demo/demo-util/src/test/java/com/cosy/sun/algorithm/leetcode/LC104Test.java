package com.cosy.sun.algorithm.leetcode;

import com.cosy.sun.algorithm.bean.TreeNode;
import org.junit.jupiter.api.Test;

public class LC104Test {

    @Test
    public void maxDeepth() {

        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode7 = new TreeNode(7);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeNode5 = new TreeNode(5);
        TreeNode treeNode6 = new TreeNode(6);

        treeNode1.left = treeNode2;
        treeNode1.right = treeNode7;

        treeNode2.left = treeNode3;
        treeNode2.right = treeNode4;

        treeNode4.left = treeNode5;
        treeNode4.right = treeNode6;

        int i = LC104.maxDeepth(treeNode1);
        System.out.println(i);

    }
}