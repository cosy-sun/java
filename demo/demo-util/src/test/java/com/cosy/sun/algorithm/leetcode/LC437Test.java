package com.cosy.sun.algorithm.leetcode;

import com.cosy.sun.algorithm.bean.TreeNode;
import org.junit.jupiter.api.Test;

public class LC437Test {

    @Test
    public void pathSumTest() {
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeNode5 = new TreeNode(5);
        TreeNode treeNode6 = new TreeNode(6);
        TreeNode treeNode7 = new TreeNode(7);
        TreeNode treeNode8 = new TreeNode(8);
        TreeNode treeNode9 = new TreeNode(9);

        treeNode3.left = treeNode1;
        treeNode1.right = treeNode2;
        treeNode3.right = treeNode4;
        treeNode4.left = treeNode5;
        treeNode4.right = treeNode6;
        treeNode5.left = treeNode7;
        treeNode5.right = treeNode8;
        treeNode6.left = treeNode9;

        int i = LC437.pathSum(treeNode3, 4);
        System.out.println(i);
    }

    @Test
    public void pathSum1Test() {
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode4 = new TreeNode(4);

        treeNode3.left = treeNode1;
        treeNode1.right = treeNode2;
        treeNode3.right = treeNode4;

        int i = LC437.pathSum1(treeNode3, 4);
        System.out.println(i);
    }
}