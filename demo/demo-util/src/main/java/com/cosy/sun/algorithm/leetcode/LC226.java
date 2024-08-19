package com.cosy.sun.algorithm.leetcode;

import com.cosy.sun.algorithm.bean.TreeNode;

public class LC226 {

    public static TreeNode invertBinaryTree(TreeNode root) {
        if(root == null) {
            return null;
        }
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
        invertBinaryTree(root.left);
        invertBinaryTree(root.right);
        return root;
    }

}
