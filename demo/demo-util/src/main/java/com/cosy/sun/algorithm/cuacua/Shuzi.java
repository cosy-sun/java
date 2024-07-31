package com.cosy.sun.algorithm.cuacua;

import java.util.Random;

public class Shuzi {

    public static void main(String[] args) {
        Random random = new Random();
        int[] arr = new int[40000];
        for (int i = 0; i < 40000; i++) {
            arr[i] = random.nextInt(200);
        }

        for (int i = 0; i < 40000; i++) {
            System.out.print(arr[i]);
            if (i != 40000 - 1) {
                System.out.print(" ");
            }
        }


    }


}
