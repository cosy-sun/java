package com.cosy.sun.algorithm.leetcode;

import java.util.LinkedList;

public class LC20 {


    public static boolean isValid(String s) {
        LinkedList<Character> queue = new LinkedList<>();
        for(char c : s.toCharArray()) {
            if(!queue.isEmpty() && jdg(queue.peekLast(), c)) {
                queue.removeLast();
            } else {
                queue.addLast(c);
            }
        }
        return queue.isEmpty();
    }

    private static boolean jdg(Character s, char c) {
        return (s == '[' && c == ']') || (s == '(' && c == ')') || (s == '{' && c == '}');
    }

}
