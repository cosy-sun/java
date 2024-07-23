package com.cosy.sun.algorithm.cuacua;


import java.util.Scanner;

/**
 * RSA加密算法在网络安全世界中无处不在，它利用了极大整数因数分解的困难度，数据越大，安全系数越高，给定一个32位正整数，请对其进行因数分解，找出是哪两个素数的乘积。
 *
 * 输入描述：
 *
 * 一个正整数num
 *
 * 0 < num <= 2147483647
 *
 * 输出描述：
 *
 * 如果成功找到，以单个空格分割，从小到大输出两个素数，分解失败，请输出-1 -1
 *
 * 示例1
 *
 * 输入：
 *
 * 15
 * 输出：
 *
 * 3 5
 * 说明：
 *
 * 因数分解后，找到两个素数3和5，使得3*5=15，按从小到大排列后，输出3 5
 */
public class D7 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        sc.close();

        if (num <= 1) {
            System.out.println("-1 -1");
        }

        boolean flag = false;
        for (int i = 2; i * i < num; i++) {
            if (ss(i) && num % i == 0) {
                int o = num /i ;
                boolean ss = ss(o);
                if (ss) {
                    System.out.println(i + " " + o);
                    flag = true;
                }
            }
        }
        if (!flag) {
            System.out.println("-1 -1");
        }

    }

    public static boolean ss(int num) {
        for (int i = 2; i * i < num; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

}
