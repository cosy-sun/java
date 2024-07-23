package com.cosy.sun.algorithm.cuacua;

import java.util.Scanner;

/**
 * 数组连续和
 */
public class D69 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int sum = sc.nextInt();
        int[] ints = new int[size];
        for (int i = 0; i < size; i++) {
            ints[i] = sc.nextInt();
        }
        int sum1 = sum(ints, sum);
        System.out.println(sum1);
    }

    public static int sum(int[] arr, int x) {
        int left = 0;
        int right = 0;
        int sum = 0;
        int res = 0;
        int length = arr.length;
        while (right < length) {
            sum += arr[right];
            if (sum >= x) {
                res += length - right;
                boolean b = true;
                while (left <= right && b) {
                    sum -= arr[left];
                    if (sum >= x) {
                        left ++;
                        res += length - right;
                    } else if (sum == 0) {
                        left ++;
                        right ++;
                        sum = 0;
                        b = false;
                    } else {
                        right ++;
                        b = false;
                    }
                }
            } else {
                right ++;
            }
        }
        return res;
    }

}
