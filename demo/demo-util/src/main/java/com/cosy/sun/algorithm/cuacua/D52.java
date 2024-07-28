package com.cosy.sun.algorithm.cuacua;

import java.util.Scanner;

/**
 * 机器人搬砖，一共有N堆砖存放在N个不同的仓库中，第i堆砖中有bricks[i]块砖头，要求在8小时内搬完。机器人每小时能搬砖的数量取决于有多少能量格，机器人一个小时中只能在一个仓库中搬砖，机器人的能量格每小时补充一次且能量格只在这一个小时有效，为使得机器人损耗最小化尽量减小每次补充的能量格数。
 * 为了保障在8小时内能完成搬砖任务，请计算每小时给机器人充能的最小能量格数。
 * 备注：
 * 1、无需考虑机器人补充能量格的耗时；
 * 2、无需考虑机器人搬砖的耗时；
 * 3、机器人每小时补充能量格只在这一个小时中有效；
 * 输入描述：
 * 程序输入为“30 12 25 8 19”一个整数数组，数组中的每个数字代表第i堆砖的个数，每堆砖的个数不超过100。
 * 输出描述：
 * 输出在8小时内完成搬砖任务，机器人每小时最少需要充多少个能量格；
 * 如果8个小时内无论如何都完成不了任务，则输出“-1”；
 * 补充说明：
 * 示例1
 * 输入：
 * 30 12 25 8 19
 * 输出：
 * 15
 * 说明：
 */
public class D52 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String[] split = s.split(" ");
        int[] ints = new int[split.length];
        int max = 0;
        for (int i = 0; i < ints.length; i++) {
            ints[i] = Integer.parseInt(split[i]);
            max = Math.max(max, ints[i]);
        }

        if (ints.length > 8) {
            System.out.println(-1);
        }

        int min = 1;
        int ans = 0;
        while (min <= max) {
            int tim = 0;
            for (int i = 0; i < ints.length; i++) {
                int anInt = ints[i];
                tim += anInt % max > 0 ? (anInt + max) / max : anInt /max;
            }
            if (tim <= 8) {
                ans = max;
                max --;
            } else {
               break;
            }
        }
        System.out.println(ans);


    }

}
