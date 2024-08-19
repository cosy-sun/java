package com.cosy.sun.algorithm.leetcode;

import com.cosy.sun.algorithm.leetcode.bean.TreeNode;
import org.junit.jupiter.api.Test;

import java.util.List;

public class LC94Test {

    @Test
    public void inorderTraversal() {

        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode4 = new TreeNode(4);

        treeNode3.left = treeNode1;
        treeNode1.right = treeNode2;
        treeNode3.right = treeNode4;
        List<Integer> integers = LC94.inorderTraversal(treeNode3);
        System.out.println(integers);

    }
}