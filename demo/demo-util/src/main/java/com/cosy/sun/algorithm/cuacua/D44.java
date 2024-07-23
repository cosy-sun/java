package com.cosy.sun.algorithm.cuacua;

import java.util.Deque;
import java.util.Scanner;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * 密码输入检测
 */
public class D44 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
//        String s = sc.nextLine();
        String s = "abc<defA123*";
        boolean upper = false, lower = false, digit = false, unDigit = false;
        Deque<Character> deque = new LinkedBlockingDeque<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c == '<') {
                deque.removeLast();
            } else {
                deque.addLast(c);
            }
            if (Character.isUpperCase(c)) {
                upper = true;
            } else
            if (Character.isLowerCase(c)) {
                lower = true;
            } else
            if(Character.isDigit(c)) {
                digit = true;
            } else {
                if(c != ' ' && c != '<') {
                    unDigit = true;
                }

            }
        }
        StringBuilder builder = new StringBuilder();
        int size = deque.size();
        for (int i = 0; i < size; i++) {
            builder.append(deque.pollFirst());
        }
        boolean res = upper && lower && digit && unDigit;
        System.out.println(builder + ", " + res);
    }

}
