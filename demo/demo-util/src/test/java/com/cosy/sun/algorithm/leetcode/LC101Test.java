package com.cosy.sun.algorithm.leetcode;

import com.cosy.sun.algorithm.AlgorithmUtil;
import com.cosy.sun.algorithm.bean.TreeNode;
import org.junit.jupiter.api.Test;

public class LC101Test {

    @Test
    public void isSymmetric() {

        TreeNode treeNode1 = AlgorithmUtil.getTreeNode();

        boolean symmetric = LC101.isSymmetric(treeNode1);
        System.out.println(symmetric);

    }

}