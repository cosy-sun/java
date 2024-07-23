package com.cosy.sun.algorithm.cuacua;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 寿司价格
 */
public class D57 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String[] split = s.split(" ");
        int[] ints = new int[split.length];
        for (int i = 0; i < ints.length; i++) {
            ints[i] = Integer.parseInt(split[i]);
        }

        int[] price = price(ints);
        System.out.println(Arrays.toString(price));
    }

    public static int[] price(int[] prices) {
        int[] res = new int[prices.length];
        for (int i = 0; i < prices.length; i++) {
            int j =i + 1;
            boolean flag = false;
            while (true) {
                if (j == prices.length) {
                    j = 0;
                }
                if(j == i) {
                    flag = true;
                    break;
                }
                if (prices[i] > prices[j]) {
                    res[i] = prices[j] + prices[i];
                    break;
                } else {
                    j ++;
                }
            }
            if (flag) {
                res[i] = prices[i];
            }
        }
        return res;
    }

}
