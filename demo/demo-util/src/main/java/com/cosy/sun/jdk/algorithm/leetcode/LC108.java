package com.cosy.sun.jdk.algorithm.leetcode;

import com.cosy.sun.jdk.algorithm.leetcode.bean.TreeNode;

public class LC108 {

    public TreeNode sortedArrayToBST(int[] nums) {
        return helper(nums, 0, nums.length - 1);
    }

    private TreeNode helper(int[] nums, int left, int right) {
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
