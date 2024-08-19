package com.cosy.sun.algorithm.leetcode;

import com.cosy.sun.algorithm.leetcode.bean.TreeNode;
import org.junit.jupiter.api.Test;

public class LC543Test {

    @Test
    public void diameterOfBinaryTree() {
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

        LC543 lc543 = new LC543();
        int i = lc543.diameterOfBinaryTree(treeNode1);
        System.out.println(i - 1);

    }
}