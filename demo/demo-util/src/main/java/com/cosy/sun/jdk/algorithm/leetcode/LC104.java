package com.cosy.sun.jdk.algorithm.leetcode;

import com.cosy.sun.jdk.algorithm.leetcode.bean.TreeNode;

public class LC104 {

    public static void main(String[] args) {
        LC104 lc104 = new LC104();

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

        int i = lc104.maxDeepth(treeNode1);
        System.out.println(i);
    }

    public int maxDeepth(TreeNode node) {
        if(node == null) {
            return 0;
        }
        int left = maxDeepth(node.left);
        int right = maxDeepth(node.right);
        return Math.max(left, right) + 1;
    }


}
