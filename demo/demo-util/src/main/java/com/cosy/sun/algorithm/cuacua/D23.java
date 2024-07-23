package com.cosy.sun.algorithm.cuacua;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 最长合法简单数学表达式
 */
public class D23 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int res = extractAndCal(s);
        System.out.println(res);
    }

    public static int extractAndCal(String s) {
        Pattern compile = Pattern.compile("\\d+([+\\-*]\\d+)+");
        Matcher matcher = compile.matcher(s);
        List<String> list = new ArrayList<>();
        while (matcher.find()) {
            list.add(matcher.group());
        }
        list.sort((o1, o2) -> o2.length() - o1.length());
        return cal(list.get(0));
    }

    private static int cal(String s) {
        List<String> list = new ArrayList<>();
        int index = 0;
        int end = 0;
        while (index <= s.length() && end >= index) {
            char c = s.charAt(index);
            if (end == s.length()) {
                String substring = s.substring(index, end);
                list.add(substring);
            }
            if (c == '+' || c == '-' || c == '*') {
                String substring = s.substring(index, end - 1);
                list.add(substring);
                list.add(Character.toString(c));
                end ++;
                index = end + 1;
            } else {
                end ++;
            }

        }
        return 0;
    }

}
