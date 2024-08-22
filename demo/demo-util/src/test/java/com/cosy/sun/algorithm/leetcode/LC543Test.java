package com.cosy.sun.algorithm.leetcode;

import com.cosy.sun.algorithm.bean.TreeNode;
import com.cosy.sun.util.DemoUtilUtils;
import org.junit.jupiter.api.Test;

public class LC543Test {

    @Test
    public void diameterOfBinaryTree() {
        TreeNode treeNode = DemoUtilUtils.getTreeNode();

        LC543 lc543 = new LC543();
        int i = lc543.diameterOfBinaryTree(treeNode);
        System.out.println(i - 1);

    }
}