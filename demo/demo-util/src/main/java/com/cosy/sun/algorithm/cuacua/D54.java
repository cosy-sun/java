package com.cosy.sun.algorithm.cuacua;

import java.util.Scanner;

/**
 * 找座位
 */
public class D54 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        char[] charArray = s.toCharArray();
        int num = 0;
        if (s.equals("0") || s.equals("00")) {
            num = 1;
            System.out.println(num);
            return ;
        }
        for (int i = 1; i < charArray.length - 1; i++) {
            char c = charArray[i];
            if (c == '0' && charArray[i-1] == '0' && charArray[i + 1] == '0') {
                num ++;
            }
        }
        System.out.println(num);

    }

}
