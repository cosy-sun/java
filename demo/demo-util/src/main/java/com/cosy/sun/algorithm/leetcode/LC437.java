package com.cosy.sun.algorithm.leetcode;

import com.cosy.sun.algorithm.bean.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class LC437 {

    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode4 = new TreeNode(4);

        treeNode3.left = treeNode1;
        treeNode1.right = treeNode2;
        treeNode3.right = treeNode4;

        LC437 lc437 = new LC437();
        int i = lc437.pathSum(treeNode3, 4);
        System.out.println(i);

    }

    public int pathSum(TreeNode root, int targetSum) {
        Map<Long, Integer> map = new HashMap<>();
        map.put(0L, 1);
        return dfs(root, map, 0, targetSum);
    }

    private int dfs(TreeNode root, Map<Long, Integer> prefix, long curr, int targetSUm) {
        if(root == null) {
            return 0;
        }
        int ret = 0;
        curr += root.val;
        ret = prefix.getOrDefault(curr - targetSUm, 0);
        prefix.put(curr, prefix.getOrDefault(curr, 0) + 1);
        ret += dfs(root.left, prefix, curr, targetSUm);
        ret += dfs(root.right, prefix, curr, targetSUm);
        prefix.put(curr, prefix.getOrDefault(curr, 0) - 1);
        return ret;
    }

}
