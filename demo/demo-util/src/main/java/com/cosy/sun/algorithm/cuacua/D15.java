package com.cosy.sun.algorithm.cuacua;


import java.util.Scanner;

/**
 * 为了充分发挥GPU算力，需要尽可能多的将任务交给GPU执行，现在有一个任务数组，数组元素表示在这1秒内新增的任务个数且每秒都有新增任务，假设GPU最多一次执行n个任务，一次执行耗时1秒，在保证GPU不空闲情况下，最少需要多长时间执行完成
 *
 * 输入描述：
 *
 * 第一个参数为GPU一次最多执行的任务个数，取值范围[1, 10000]
 *
 * 第二个参数为任务数组长度，取值范围[1, 10000]
 *
 * 第三个参数为任务数组，数字范围[1, 10000]
 *
 * 输出描述：
 *
 * 执行完所有任务最少需要多少秒
 *
 * 补充说明：
 *
 * 示例1
 *
 * 输入：
 *
 * 3
 *
 * 5
 *
 * 1 2 3 4 5
 *
 * 输出：
 *
 * 6
 *
 * 说明：
 *
 * 一次最多执行3个任务，最少耗时6s
 *
 */
public class D15 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int gpu = sc.nextInt();
        int size = sc.nextInt();
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = sc.nextInt();
        }

        int tmp = 0;
        for (int i = 0; i < arr.length; i++) {
            int task = arr[i];
            tmp += task - gpu;
            if(tmp < 0) {
                tmp = 0;
            }
        }
        int i = tmp / gpu + arr.length;
        System.out.println(i);

    }

}
