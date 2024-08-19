package com.cosy.sun.algorithm.leetcode;

import com.cosy.sun.algorithm.leetcode.bean.TreeNode;

public class LC101 {

    public static boolean isSymmetric(TreeNode root) {
        if(root.left != null && root.right != null) {
            TreeNode treeNode1 = invertBinaryTree(root.right);

            return jdgEq(root.left, treeNode1);
        }
        return root.left == null && root.right == null;

    }

    public static boolean jdgEq(TreeNode root1, TreeNode root2) {
        if(root1 != null && root2 == null) {
            return false;
        }
        if(root1 == null && root2 != null) {
            return false;
        }
        if(root1 == null && root2 == null) {
            return true;
        }
        if(root1.val != root2.val) {
            return false;
        }
        return jdgEq(root1.left, root2.left) && jdgEq(root1.right, root2.right);

    }

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
