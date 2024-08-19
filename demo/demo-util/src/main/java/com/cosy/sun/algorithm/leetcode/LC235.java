package com.cosy.sun.algorithm.leetcode;

import com.cosy.sun.algorithm.bean.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class LC235 {

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> path = findPath(root, p);
        List<TreeNode> path1 = findPath(root, q);
        TreeNode ans = null;
        for (int i = 0; i < Math.min(path.size(), path1.size()); i++) {
            if (path.get(i).val == path1.get(i).val) {
                ans = path.get(i);
            } else {
                break;
            }
        }
        return ans;

    }

    public static List<TreeNode> findPath(TreeNode root, TreeNode search) {
        List<TreeNode> list = new ArrayList<>();
        TreeNode tmp = root;
        while (tmp != search) {
            list.add(tmp);

                if (tmp.val > search.val) {
                    tmp = tmp.left;
                } else {
                    tmp = tmp.right;
                }

        }
        list.add(tmp);
        return list;
    }

}
