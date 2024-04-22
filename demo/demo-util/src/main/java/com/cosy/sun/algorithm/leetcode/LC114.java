package com.cosy.sun.algorithm.leetcode;

import com.cosy.sun.algorithm.leetcode.bean.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class LC114 {

    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        treeNode1.left = treeNode2;
        LC114 lc114 = new LC114();
        lc114.flattern(treeNode1);
        System.out.println(treeNode1);
    }

    public void flattern(TreeNode root) {
        List<TreeNode> treeNodes = new ArrayList<>();
        pre(root, treeNodes);
        for (int i = 0; i < treeNodes.size() - 1; i++) {
            TreeNode treeNode = treeNodes.get(i);
            TreeNode treeNode1 = treeNodes.get(i + 1);
            treeNode.left = null;
            treeNode.right = treeNode1;
        }
    }

    public void pre(TreeNode root, List<TreeNode> list) {
        if(root == null) {
            return ;
        }
        list.add(root);
        pre(root.left, list);
        pre(root.right, list);
    }

}
