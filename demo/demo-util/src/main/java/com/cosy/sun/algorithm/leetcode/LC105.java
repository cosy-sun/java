package com.cosy.sun.algorithm.leetcode;

import com.cosy.sun.algorithm.bean.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class LC105 {

    public static void main(String[] args) {
        int[] pre = {3, 9, 20, 15, 7};
        int[] inorder = {9, 3, 15, 20, 7};
        LC105 lc105 = new LC105();
        TreeNode treeNode = lc105.buildTree(pre, inorder);
        System.out.println(treeNode);
    }

    private Map<Integer, Integer> indexMap = new HashMap<>();


    public TreeNode buildTree(int[] pre, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) {
            indexMap.put(inorder[i], i);
        }
        return building(pre, inorder, 0, pre.length - 1, 0, inorder.length);
    }

    private TreeNode building(int[] pre, int[] inorder, int preLeft, int preRight, int inLeft, int inRight) {
        if(preLeft > preRight) {
            return null;
        }
        int preRoot = pre[preLeft];
        int inRootIndex = indexMap.get(preRoot);

        int leftSize = inRootIndex - inLeft;
        TreeNode treeNode = new TreeNode(preRoot);

        treeNode.left = building(pre, inorder, preLeft + 1, preLeft + leftSize, inLeft, inRootIndex - 1);
        treeNode.right = building(pre, inorder, preLeft + leftSize + 1, preRight, inRootIndex + 1, inRight);
        return treeNode;

    }

}
