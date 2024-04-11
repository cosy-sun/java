package com.cosy.sun.jdk.algorithm.leetcode;

import com.cosy.sun.jdk.algorithm.leetcode.bean.TreeNode;

import java.util.*;

public class LC199 {

    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode4 = new TreeNode(4);

        treeNode3.left = treeNode1;
        treeNode1.right = treeNode2;
        treeNode3.right = treeNode4;

        LC199 lc199 = new LC199();
        List<Integer> integers = lc199.rightSideView(treeNode3);
        System.out.println(Arrays.toString(integers.toArray()));
    }

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if(root == null) {
            return ans;
        }
        Deque<TreeNode> deque = new LinkedList<>();
        deque.offer(root);
        while (!deque.isEmpty()) {
            ans.add(deque.getLast().val);
            List<Integer> level = new ArrayList<>();
            int currSize = deque.size();
            for (int i = 0; i < currSize; i++) {
                TreeNode poll = deque.poll();
                level.add(poll.val);
                if (poll.left != null) {
                    deque.offer(poll.left);
                }
                if (poll.right != null) {
                    deque.offer(poll.right);
                }
            }
        }
        return ans;
    }

}
