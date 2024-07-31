package com.cosy.sun.algorithm.cuacua;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int count = sc.nextInt();
        int[] arr = new int[count];
        for (int i = 0; i < count; i++) {
            arr[i] = sc.nextInt();
        }
        sc.close();
        int[] res = new int[count];
        for (int i = 0; i < count; i++) {
            int query = arr[i];
            for (int j = i + 1; j < count; j++) {
                if (arr[j] > query) {
                    res[i] = j;
                    break;
                }
            }
        }
        for (int i = 0; i < count; i++) {
            System.out.print(res[i]);
            if (i != count - 1) {
                System.out.print(" ");
            }
        }

    }

}
