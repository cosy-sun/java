package com.cosy.sun.algorithm.leetcode;

import com.cosy.sun.algorithm.bean.TreeNode;

public class LC98 {

    public boolean isValidBST(TreeNode root) {
        return validBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean validBST(TreeNode root, long left, long right) {
        if(root == null) {
            return true;
        }
        if(root.val <= left || root.val >= right) {
            return false;
        }
        boolean b = validBST(root.left, left, root.val);
        boolean b1 = validBST(root.right, root.val, right);
        return b && b1;
    }

}
