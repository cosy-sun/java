package com.cosy.sun.algorithm.leetcode;

import com.cosy.sun.algorithm.bean.TreeNode;

public class LC108 {

    public static TreeNode sortedArrayToBST(int[] nums) {
        return helper(nums, 0, nums.length - 1);
    }

    private static TreeNode helper(int[] nums, int left, int right) {
        if(left > right) {
            return null;
        }

        int mid = (left + right) / 2;

        TreeNode middle = new TreeNode(nums[mid]);

        middle.left = helper(nums, left, mid - 1);
        middle.right = helper(nums, mid + 1, right);
        return middle;
    }

}
