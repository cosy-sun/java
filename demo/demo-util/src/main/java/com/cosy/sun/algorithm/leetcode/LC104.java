package com.cosy.sun.algorithm.leetcode;

import com.cosy.sun.algorithm.bean.TreeNode;

public class LC104 {

    public static int maxDeepth(TreeNode node) {
        if(node == null) {
            return 0;
        }
        int left = maxDeepth(node.left);
        int right = maxDeepth(node.right);
        return Math.max(left, right) + 1;
    }


}
