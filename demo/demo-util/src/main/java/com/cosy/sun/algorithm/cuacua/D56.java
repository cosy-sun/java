package com.cosy.sun.algorithm.cuacua;

import java.util.Scanner;

/**
 * 小朋友出操，按学号从小到大排成一列；小明来迟了，请你给小明出个主意，让他尽快找到他应该排的位置。
 * 算法复杂度要求不高于nLog(n)；学号为整数类型，队列规模<=10000；
 * 输入描述：
 * 1、第一行：输入已排成队列的小朋友的学号（正整数），以”,”隔开；
 *        例如：93 95 97 100 102 123 155
 * 2、第二行：小明学号，如110；
 * 输出描述：
 * 输出一个数字，代表队列位置（从1开始）。
 * 例如：
 * 6
 * 补充说明：
 * 示例1
 * 输入：
 * 93 95 97 100 102 123 155
 * 110
 * 输出：
 * 6
 */
public class D56 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int xiaoming = sc.nextInt();
        String[] split = s.split(" ");
        int[] arr = new int[split.length];
        for (int i = 0; i < split.length; i++) {
            arr[i] = Integer.parseInt(split[i]);
        }

        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (arr[mid] > xiaoming) {
                right = mid - 1;
            } else if (arr[mid] < xiaoming) {
                left = mid + 1;
            }
        }

        System.out.println(left + 1);
    }

}
