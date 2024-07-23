package com.cosy.sun.algorithm.cuacua;

import java.util.Scanner;

/**
 * o为偶数的最大字符串长度
 */
public class D19 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String trim = s.trim();
        char[] charArray = trim.toCharArray();
        int i = maxO(charArray);
        System.out.println(i);
    }

    public static int maxO(char... chars) {
        int count = 0;
        for (char aChar : chars) {
            if (aChar == 'o') {
                count++;
            }
        }
        if (count % 2 == 0) {
            return chars.length;
        } else {
            return chars.length - 1;
        }
    }

}
