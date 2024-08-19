package com.cosy.sun.algorithm;

import com.cosy.sun.algorithm.bean.TreeNode;

import java.util.Random;

public class AlgorithmUtil {

    public static int[] genDescArray(int len) {
        int[] arr = new int[len];
        for (int i = len - 1, tmp = 0; i >= 0; i--, tmp ++) {
            arr[i] = tmp;
        }
        return arr;
    }

    public static int[] genAscArray(int length) {
        int[] array = new int[length];
        for (int i = 0; i < length; i++) {
            array[i] = i;
        }
        return array;
    }

    /**
     * 生成随机数组
     * @param length
     * @return
     */
    public static int[] genRandomArray(int length) {
        Random random = new Random();
        int[] array = new int[length];
        for (int i = 0; i < length; i++) {
            array[i] = random.nextInt(100);
        }
        return array;
    }

    public static TreeNode getTreeNode() {
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode21 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode4 = new TreeNode(4);

        treeNode1.left = treeNode2;
        treeNode1.right = treeNode21;

        treeNode2.left = treeNode3;
        treeNode2.right = treeNode4;

        treeNode21.left = treeNode4;
        treeNode21.right = treeNode3;
        return treeNode1;
    }
}
