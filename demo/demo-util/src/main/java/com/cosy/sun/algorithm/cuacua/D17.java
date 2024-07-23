package com.cosy.sun.algorithm.cuacua;

import java.util.Scanner;

/**
 * 有位客人来自异国，在该国使用m进制计数。该客人有个幸运数字n(n<m)，每次购物时，其总是喜欢计算本次支付的花费(折算为异国的价格后)中存在多少幸运数字。问：当其购买一个在我国价值k的产品时，其中包含多少幸运数字？
 *
 * 输入描述：
 *
 * 第一行输入为 k, n, m。
 *
 * 其中：
 *
 * k 表示 该客人购买的物品价值（以十进制计算的价格）
 *
 * n 表示 该客人的幸运数字
 *
 * m 表示 该客人所在国度的采用的进制
 *
 * 输出描述：
 *
 * 输出幸运数字的个数，行末无空格。
 *
 * 补充说明：
 *
 * 当输入非法内容时，输出0
 *
 * 示例1
 *
 * 输入：
 *
 * 10 2 4
 *
 * 输出：
 *
 * 2
 *
 * 说明：
 *
 * 10用4进制表示时为22，同时，异国客人的幸运数字是2，故而此处输出为2，表示有2个幸运数字。
 */
public class D17 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int price = sc.nextInt();
        int luckyNum = sc.nextInt();
        int binary = sc.nextInt();

        int i1 = price % binary;
        price = price - i1;

        int count = 0;

        if (i1 == luckyNum) {
            count ++;
        }
        while (price > 0) {
            int i = price % binary;
            price = price / binary;
            if (i == luckyNum) {
                count ++;
            }
        }
        System.out.println(count);

    }

}
