package com.cosy.sun.jdk.algorithm.leetcode;

import com.cosy.sun.jdk.algorithm.leetcode.bean.TreeNode;

public class LC124 {

    private int maxSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        mainGain(root);
        return maxSum;
    }

    private int mainGain(TreeNode node) {
        if(node == null) {
            return 0;
        }

        int leftMax = Math.max(mainGain(node.left), 0);
        int rightMax = Math.max(mainGain(node.right), 0);

        int price = node.val + leftMax + rightMax;

        maxSum = Math.max(price, maxSum);

        return node.val + Math.max(leftMax, rightMax);

    }

}
