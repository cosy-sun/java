package com.cosy.sun.algorithm.cuacua;

import java.util.Scanner;

/**
 * 特定大小的停车场，数组cars[]表示，其中1表示有车，0表示没车。车辆大小不一，小车占一个车位（长度1），货车占两个车位（长度2），卡车占三个车位（长度3），统计停车场最少可以停多少辆车，返回具体的数目。
 * 输入描述：
 * 整型字符串数组cars[]，其中1表示有车，0表示没车，数组长度小于1000。
 * 输出描述：
 * 整型数字字符串，表示最少停车数目。
 * 补充说明：
 * 示例1
 * 输入：
 * 1,0,1
 * 输出：
 * 2
 * 说明：
 * 1个小车占第1个车位
 * 第二个车位空
 * 1个小车占第3个车位
 * 最少有两辆车
 */
public class D25 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String[] split = s.split(",");
        int[] arr = new int[split.length];
        for (int i = 0; i < split.length; i++) {
            arr[i] = Integer.parseInt(split[i]);
        }

        int len = 0;
        int sum = 0;
        for (int i = 0; i <= split.length; i++) {
            if (i == split.length || arr[i] == 0) {
                int size = len;
                len = 0;
                sum += size /3;
                size = size % 3;
                sum += size /2;
                size = size % 2;
                sum += size;
            } else {
                len ++;
            }
        }

        System.out.println(sum);

    }

}
