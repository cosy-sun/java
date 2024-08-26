package com.cosy.sun.algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

public class LC39 {

    static List<Integer> path = new ArrayList<Integer>();
    static List<List<Integer>> res = new ArrayList<List<Integer>>();
    public static List<List<Integer>> combinationSum1(int[] candidates, int target) {
        rollBack1(candidates, target, 0, 0);
        return res;
    }

    public static void rollBack1(int[] nums, int target, int index, int sum) {
        if (sum == target) {
            res.add(new ArrayList<>(path));
            return;
        }
        if (sum > target) return;
        for(int i = index; i < nums.length; i++) {
            path.add(nums[i]);
            sum += nums[i];
            rollBack1(nums, target, i, sum);
            path.remove(path.size() - 1);
            sum -= nums[i];
        }
    }


    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> combine = new ArrayList<>();
        dfs(candidates, target, ans, combine, 0);
        return ans;
    }

    public static void dfs(int[] candidates, int target, List<List<Integer>> ans, List<Integer> combine, int idx) {
        if (idx == candidates.length) {
            return;
        }
        if (target == 0) {
            ans.add(new ArrayList<>(combine));
            return;
        }
        // 直接跳过
        dfs(candidates, target, ans, combine, idx + 1);
        // 选择当前数
        if (target - candidates[idx] >= 0) {
            combine.add(candidates[idx]);
            dfs(candidates, target - candidates[idx], ans, combine, idx);
            combine.removeLast();
        }
    }
}