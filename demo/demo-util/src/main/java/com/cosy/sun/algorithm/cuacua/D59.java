package com.cosy.sun.algorithm.cuacua;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * 悄悄话
 */
public class D59 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String[] split = s.split(" ");
        int length = split.length;
        int[] arr = new int[length];
        for (int i = 0; i < length; i++) {
            int i1 = Integer.parseInt(split[i]);
            arr[i] = i1;
        }
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        int res = 0;
        while (!queue.isEmpty()) {
            int i = queue.poll();
            int check = check(i * 2 + 1, queue, i, arr);
            int check1 = check(i * 2 + 2, queue, i, arr);
            int max = Math.max(check, check1);
            res = Math.max(max, res);
        }
        System.out.println(res);
    }

    private static int check(int i, Queue<Integer> queue, int i1, int[] arr) {
        int res = 0;
        if (i < arr.length && arr[i] != -1) {
            arr[i] += arr[i1];
            queue.add(i);
            if(arr[i] > res) {
                res = arr[i];
            }
        }
        return res;
    }

}
