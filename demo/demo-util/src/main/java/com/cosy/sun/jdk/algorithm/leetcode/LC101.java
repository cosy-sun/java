package com.cosy.sun.jdk.algorithm.leetcode;

import com.cosy.sun.jdk.algorithm.leetcode.bean.TreeNode;

public class LC101 {

    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode21 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeNode5 = new TreeNode(5);

        treeNode1.left = treeNode2;
        treeNode1.right = treeNode21;

        treeNode2.left = treeNode3;
        treeNode2.right = treeNode4;

        treeNode21.left = treeNode4;
        treeNode21.right = treeNode3;

        boolean symmetric = isSymmetric(treeNode1);
        System.out.println(symmetric);
    }

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
