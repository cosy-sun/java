package com.cosy.sun.algorithm.leetcode;

import com.cosy.sun.algorithm.bean.TreeNode;
import com.cosy.sun.util.DemoUtilUtils;
import org.junit.jupiter.api.Test;

public class LC101Test {

    @Test
    public void isSymmetric() {

        TreeNode treeNode1 = DemoUtilUtils.getTreeNode();

        boolean symmetric = LC101.isSymmetric(treeNode1);
        System.out.println(symmetric);

    }

}