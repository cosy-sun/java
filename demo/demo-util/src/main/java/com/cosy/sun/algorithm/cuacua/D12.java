package com.cosy.sun.algorithm.cuacua;

import java.util.Scanner;

/**
 * 均衡串定义：字符串只包含两种字符，且两种字符的个数相同。
 *
 * 给定一个均衡字符串，请给出可分割成新的均衡子串的最大个数。
 *
 * 约定字符串中只包含大写的'X'和'Y'两种字符。
 *
 * 输入描述：
 *
 * 均衡串：XXYYXY
 *
 * 字符串的长度[2,10000]。给定的字符串均为均衡串。
 *
 * 输出描述：
 *
 * 可分割为两个子串：
 *
 * XXYY
 *
 * XY
 *
 * 补充说明：
 *
 * 分割后的子串，是原字符串的连续子串
 */
public class D12 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int xCount = 0, yCount = 0;
        int res = 0;
        for (int i = 0; i < str.length(); i++) {
            xCount += str.charAt(i) == 'X' ? 1 : 0;
            yCount += str.charAt(i) == 'Y' ? 1 : 0;
            if (xCount != 0 && xCount == yCount) {
                res ++;
                xCount = yCount = 0;
            }
        }
        System.out.println(res);
    }

}
