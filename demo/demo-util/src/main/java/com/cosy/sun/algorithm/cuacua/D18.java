package com.cosy.sun.algorithm.cuacua;

import java.util.Arrays;
import java.util.Random;

/**
 * 最多可以排除多少团队
 */
public class D18 {

    public static void main(String[] args) {
        int size = 5;
        int[] arr = new int[size];
        for (int i = 0; i < 5; i++) {
            Random random = new Random();
            arr[i] = random.nextInt(10);
        }
        int score = 8;
        System.out.println(Arrays.toString(arr));
        int i = maxCount(arr, score);
        System.out.println(i);
    }

    private static int maxCount(int[] arr, int score) {
        int count = 0;
        Arrays.sort(arr);
        int left = 0;
        int right = arr.length - 1;
        while (left < right) {
            if (arr[right] >= score) {
                right --;
                count ++;
            } else if (arr[left] + arr[right] >= score) {
                count ++;
                right --; left ++;
            } else if (arr[left] + arr[right] < score) {
                left ++;
            }
        }
        return count;
    }

}
