package com.cosy.sun.algorithm.leetcode;

import com.cosy.sun.algorithm.bean.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class LC230 {

    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode4 = new TreeNode(4);

        treeNode3.left = treeNode1;
        treeNode1.right = treeNode2;
        treeNode3.right = treeNode4;

        LC230 lc230 = new LC230();
        int i = lc230.kthSmallest(treeNode3, 2);
        System.out.println(i);

    }

    // 二叉搜索树的第K小的节点
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> res = new ArrayList<>();
        Deque<TreeNode> stk = new LinkedList<>();
        while (root != null || !stk.isEmpty()) {
            while (root != null) {
                stk.push(root);
                root = root.left;
            }
            root = stk.pop();
            res.add(root.val);
            if(res.size() == k) {
                break;
            }
            root = root.right;
        }
        return res.get(k - 1);
    }

}
