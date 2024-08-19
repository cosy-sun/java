package com.cosy.sun.algorithm.leetcode;

import com.cosy.sun.algorithm.leetcode.bean.TreeNode;
import org.junit.jupiter.api.Test;

public class LC101Test {

    @Test
    public void isSymmetric() {

        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode21 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeNode5 = new TreeNode(5);

        treeNode1.left = treeNode2;
        treeNode1.right = treeNode21;

        treeNode2.left = treeNode3;
        treeNode2.right = treeNode4;

        treeNode21.left = treeNode4;
        treeNode21.right = treeNode3;

        boolean symmetric = LC101.isSymmetric(treeNode1);
        System.out.println(symmetric);

    }
}