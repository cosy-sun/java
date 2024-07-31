package com.cosy.sun.algorithm.cuacua;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * 给定一个正整数n，如果能够分解为m(m > 1)个连续正整数之和，请输出所有分解中，m最小的分解。
 * 如果给定整数无法分解为连续正整数，则输出字符串"N"。
 * 输入描述：
 * 输入数据为一整数，范围为（1, 2^30]
 * 输出描述：
 * 比如输入为：
 * 21
 * 输出：
 * 21=10+11
 * 补充说明：
 * 21可以分解的连续正整数组合的形式有多种
 * 21=1+2+3+4+5+6
 * 21=6+7+8
 * 21=10+11
 * 输出，21=10+11，是最短的分解序列。
 * 示例1
 * 输入：
 * 21
 * 输出：
 * 21=10+11
 * 说明：
 * 21可以分解的连续正整数组合的形式有多种
 * 21=1+2+3+4+5+6
 * 21=6+7+8
 * 21=10+11
 * 因21=10+11，是最短的分解序列。所以答案是21=10+11
 */
public class D21 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int count = 2;

        List<Integer> list = new ArrayList<Integer>();
        while (true) {
            int sum = 0;
            for (int i = 1; i < count; i++) {
                sum += i;
            }
            int i = (num - sum) % count;
            if (i !=0) {
                count ++;
                continue;
            }
            int i1 = (num - sum) / count;
            for (int j = 0; j < count; j++) {
                list.add(i1 + j);
            }
            break;
        }

        String collect = list.stream().map(String::valueOf).collect(Collectors.joining("+"));
        System.out.println(collect);
    }
}
