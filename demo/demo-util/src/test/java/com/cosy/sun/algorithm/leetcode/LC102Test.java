package com.cosy.sun.algorithm.leetcode;

import com.cosy.sun.algorithm.bean.TreeNode;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class LC102Test {

    @Test
    public void levelOrderTest() {
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode4 = new TreeNode(4);

        treeNode3.left = treeNode1;
        treeNode1.right = treeNode2;
        treeNode3.right = treeNode4;
        List<List<Integer>> lists = LC102.levelOrder(treeNode3);
        lists.forEach(item -> System.out.println(Arrays.toString(item.toArray())));
    }
}