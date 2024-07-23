package com.cosy.sun.algorithm.cuacua;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 整数对最小和
 */
public class D6 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] arr1 = extracted(sc);
        int[] arr2 = extracted(sc);
        int k = sc.nextInt();

        int[] res = new int[arr1.length * arr2.length];
        int tmp = 0;
        for (int j : arr1) {
            for (int value : arr2) {
                res[tmp++] = j + value;
            }
        }

        Arrays.sort(res);

        int sum = 0;
        for (int i = 0; i < k; i++) {
            sum += res[i];
        }
        System.out.println(sum);

    }

    private static int[] extracted(Scanner sc) {
        int i = sc.nextInt();
        int[] arr1 = new int[i];
        for (int j = 0; j < i; j++) {
            arr1[j] = sc.nextInt();
        }
        return arr1;
    }

}
