package com.cosy.sun.algorithm.bean;

public class TreeNode implements Comparable<Integer> {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode() {
    }

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }


    @Override
    public String toString() {
        return String.valueOf(val);
    }

    @Override
    public int compareTo(Integer o) {
        return 0;
    }
}

