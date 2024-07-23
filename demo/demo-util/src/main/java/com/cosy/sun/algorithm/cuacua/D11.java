package com.cosy.sun.algorithm.cuacua;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.StringJoiner;

/**
 * 服务之间交换的接口成功率作为服务调用关键质量特性，某个时间段内的接口失败率使用一个数组表示，数组中每个元素都是单位时间内失败率数值，数组中的数值为0~100的整数，给定一个数值(minAverageLost)表示某个时间段内平均失败率容忍值，即平均失败率小于等于minAverageLost，找出数组中最长时间段，如果未找到则直接返回NULL。
 *
 * 输入描述：
 *
 * 输入有两行内容，第一行为{minAverageLost}，第二行为{数组}，数组元素通过空格(" ")分隔，minAverageLost及数组中元素取值范围为0~100的整数，数组元素的个数不会超过100个。
 *
 * 输出描述：
 *
 * 找出平均值小于等于minAverageLost的最长时间段，输出数组下标对，格式{beginIndex}-{endIndx}(下标从0开始)，如果同时存在多个最长时间段，则输出多个下标对且下标对之间使用空格(" ")拼接，多个下标对按下标从小到大排序。
 *
 * 补充说明：
 *
 * 示例1
 *
 * 输入：
 *
 * 1
 *
 * 0 1 2 3 4
 *
 * 输出：
 *
 * 0-2
 *
 * 说明：
 *
 * A、输入解释：minAverageLost=1，数组[0, 1, 2, 3, 4]
 *
 * B、前3个元素的平均值为1，因此数组第一个至第三个数组下标，即0-2
 */
public class D11 {

    /**
     * 通过前缀和来做
     * @param args
     */
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int avg = sc.nextInt();
        String s = sc.nextLine();
        String[] split = sc.nextLine().split(" ");
        int length = split.length;
        int[] req = new int[length + 1];
        int[] pre = new int[length + 1];
        int min = Integer.MAX_VALUE;
        for (int j = 1; j <= length; j++) {
            int fail = Integer.parseInt(split[j - 1]);
            req[j] = fail;
            pre[j] = fail + pre[j - 1];
            min = Math.min(pre[j], min);
        }
        if (min > avg) {
            System.out.println("NULL");
        }
        List<String> list = new LinkedList<>();
        for (int i = length; i >= 1; i--) {
            for (int l = 1, r = i; r <= length ; l ++, r ++) {
                int sum = pre[r] - pre[l - 1];
                if (sum <= avg * i) {
                    list.add((l - 1) + "-" + (r - 1));
                }
            }
            if (!list.isEmpty()) {
                StringJoiner joiner = new StringJoiner(" ");
                list.forEach(joiner::add);
                System.out.println(joiner);
                break;
            }
        }

    }

}
