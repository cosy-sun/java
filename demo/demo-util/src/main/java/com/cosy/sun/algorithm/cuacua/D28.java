package com.cosy.sun.algorithm.cuacua;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 输入字符串s，输出s中包含所有整数的最小和
 * 说明
 * 1. 字符串s，只包含 a-z A-Z +- ；
 * 2. 合法的整数包括
 *     1） 正整数 一个或者多个0-9组成，如 0 2 3 002 102
 *     2）负整数 负号 - 开头，数字部分由一个或者多个0-9组成，如 -0 -012 -23 -00023
 * 输入描述：
 * 包含数字的字符串
 * 输出描述：
 * 所有整数的最小和
 * 示例1
 * 输入：
 * bb1234aa
 * 输出：
 * 10
 * 说明：
 * 示例2
 * 输入：
 * bb12-34aa
 * 输出：
 * -31
 * 说明：
 * 1+2+（-34） = 31
 */
public class D28 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();

        Pattern compile = Pattern.compile("[+-]?\\d+");
        Matcher matcher = compile.matcher(str);
        List<Integer> list = new ArrayList<>();
        while (matcher.find()) {
            String group = matcher.group();
            if (group.startsWith("-")) {
                list.add(Integer.parseInt(group));
            } else {
                for (int i = 0; i < group.length(); i++) {
                    if (group.charAt(i) == '+') {
                        continue;
                    }
                    list.add(Integer.parseInt(group.substring(i, i + 1)));
                }
            }
        }
        Integer reduce1 = list.stream().reduce(0, Integer::sum);
        System.out.println(reduce1);
    }

}
