package com.cosy.sun.algorithm.cuacua;

import java.util.Arrays;
import java.util.Random;

/**
 * 找朋友
 */
public class D48 {

    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int size = sc.nextInt();
//        if (size <= 0) {
//            return ;
//        }
//        int[] arr = new int[size];
//        for (int i = 0; i < size; i++) {
//            arr[i] = sc.nextInt();
//        }
        int[] arr = new int[40000];
        for (int i = 0; i < 40000; i++) {
            Random random = new Random();
            int i1 = random.nextInt(100);
            arr[i] = i1;
        }
        int size = 40000;
        int[] frend = frend(size, arr);
        System.out.println(Arrays.toString(frend));
    }

    public static int[] frend(int n, int[] height) {
        int[] res = new int[n];
        if (n == 0) {
            return res;
        }
        int temp = 0;
        int tmpH = height[0];
        for (int i = 0; i < n; i++) {
            int heightI = height[i];
            if (heightI > tmpH) {
                res[temp] = i;
                temp = i;
            }
        }
        return res;
    }

}
