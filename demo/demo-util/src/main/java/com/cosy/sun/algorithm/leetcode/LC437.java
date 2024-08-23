package com.cosy.sun.algorithm.leetcode;

import com.cosy.sun.algorithm.bean.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class LC437 {

    public static int pathSum1(TreeNode root, int targetSum) {
        int res = 0;
        res += rootSum1(root, targetSum);
        res += pathSum1(root.left, targetSum);
        res += pathSum1(root.right, targetSum);
        return res;
    }

    private static int rootSum1(TreeNode root, int targetSum) {
        if (root == null) {
            return 0;
        }
        int res = 0;
        if (root.val == targetSum) {
            res ++;
        }
        res += rootSum1(root.left, targetSum - root.val);
        res += rootSum1(root.right, targetSum - root.val);
        return res;
    }


    public static int pathSum(TreeNode root, int targetSum) {
        Map<Long, Integer> map = new HashMap<>();
        map.put(0L, 1);
        return dfs(root, map, 0, targetSum);
    }

    private static int dfs(TreeNode root, Map<Long, Integer> prefix, long curr, int targetSUm) {
        if(root == null) {
            return 0;
        }
        int ret;
        curr += root.val;
        ret = prefix.getOrDefault(curr - targetSUm, 0);
        prefix.put(curr, prefix.getOrDefault(curr, 0) + 1);
        ret += dfs(root.left, prefix, curr, targetSUm);
        ret += dfs(root.right, prefix, curr, targetSUm);
        // 恢复现场
        prefix.put(curr, prefix.getOrDefault(curr, 0) - 1);
        return ret;
    }

}
