package com.cosy.sun.algorithm.cuacua;

import java.util.Scanner;

/**
 * 定义构造三叉搜索树规则如下：
 *     每个节点都存有一个数，当插入一个新的数时，从根节点向下寻找，直到找到一个合适的空节点插入。
 *     查找的规则是：
 *         1. 如果数小于节点的数减去500，则将数插入节点的左子树
 *         2. 如果数大于节点的数加上500，则将数插入节点的右子树
 *         3. 否则，将数插入节点的中子树
 * 给你一系列数，请按以上规则，按顺序将数插入树中，构建出一棵三叉搜索树，最后输出树的高度。
 * 输入描述：第一行为一个数N，表示有N个数，1<=N<=10000
 * 第二行为N个空格分隔的整数，每个数的范围为[1,10000]
 * 输出描述：输出树的高度(根节点的高度为1)
 * 补充说明：
 * 示例1
 * 输入：
 * 5
 * 5000 2000 5000 8000 1800
 * 输出：
 * 3
 * 说明：
 * 最终构造出的树如下，高度为3
 */
public class D55 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int count = sc.nextInt();
        int[] arr = new int[count];
        TreeNode root = null;
        int max = 0;
        for (int i = 0; i < count; i++) {
            arr[i] = sc.nextInt();
            if (i == 0) {
                root = new TreeNode(arr[0]);
            }
            if (i != 0) {
                int height = insert(root, arr[i], 1);
                max = Math.max(max, height);
            }
        }
        System.out.println(max);
    }

    private static int insert(TreeNode root, int val, int height) {
         if (val < root.val - 500) {
            if (root.left == null) {
                root.left = new TreeNode(val);
                return ++height;
            } else {
                height ++;
                return insert(root.left, val, height);
            }
        } if (val > root.val + 500) {
            if (root.right == null) {
                root.right = new TreeNode(val);
                return ++height;
            } else {
                height ++;
                return insert(root.right, val, height);
            }
        } else {
            if (root.mid == null) {
                root.mid = new TreeNode(val);
                return ++height;
            } else {
                height ++;
                return insert(root.mid, val, height);
            }
        }
    }


    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode mid;

        public TreeNode(int val) {
            this.val = val;
        }
    }

}
