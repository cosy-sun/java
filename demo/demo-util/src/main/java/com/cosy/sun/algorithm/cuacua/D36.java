package com.cosy.sun.algorithm.cuacua;

import java.util.Scanner;

/**
 * 给定一个字符串s，最多只能进行一次变换，返回变换后能得到的最小字符串（按照字典序进行比较）。变换规则：交换字符串中任意两个不同位置的字符。
 * 输入描述：一串小写字母组成的字符串s
 * 输出描述：按照要求进行变换得到的最小字符串
 * 补充说明：s是都是小写字符组成
 *                   1<=s.length<=1000
 * 示例 
 * 示例1
 * 输入：abcdef
 * 输出：abcdef
 * 说明：abcdef已经是最小字符串，不需要交换
 * 示例2
 * 输入：bcdefa
 * 输出：acdefb
 * 说明：a和b进行位置交换，可以等到最小字符串
 */
public class D36 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();

        int resIndex = 0;
        int i = 0;
        for (; i < s.length() - 1; i++) {
            char c = s.charAt(i);
            char tmp = c;
            int index = 0;
            for (int j = i + 1; j < s.length(); j++) {
                char c1 = s.charAt(j);
                index = c1 < tmp ? j : index;
                tmp = c1 < tmp ? c1 : tmp;
            }
            if (tmp != c) {
                resIndex = index;
                break;
            }
        }

        char[] charArray = s.toCharArray();
        char tmp = charArray[resIndex];
        charArray[resIndex] = charArray[i];
        charArray[i] = tmp;
        System.out.println(new String(charArray));

    }

}
