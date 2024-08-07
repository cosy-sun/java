package com.cosy.sun.algorithm.cuacua;

import java.util.Scanner;

/**
 * 绘图机器的绘图笔初始位置在原点（0, 0），机器启动后其绘图笔按下面规则绘制直线：
 * 1）尝试沿着横向坐标轴正向绘制直线，直到给定的终点值E。
 * 2）期间可通过指令在纵坐标轴方向进行偏移，并同时绘制直线，偏移后按规则1 绘制直线；指令的格式为X offsetY，表示在横坐标X 沿纵坐标方向偏移，offsetY为正数表示正向偏移，为负数表示负向偏移。
 * 给定了横坐标终点值E、以及若干条绘制指令，请计算绘制的直线和横坐标轴、以及 X=E 的直线组成图形的面积。
 * 输入描述：
 * 首行为两个整数 N E，表示有N条指令，机器运行的横坐标终点值E。
 * 接下来N行，每行两个整数表示一条绘制指令X offsetY，用例保证横坐标X以递增排序方式出现，且不会出现相同横坐标X。
 * 取值范围：0 < N <= 10000, 0 <= X <= E <=20000, -10000 <= offsetY <= 10000。
 * 输出描述：
 * 一个整数，表示计算得到的面积，用例保证，结果范围在0~4294967295内
 * 补充说明：
 * 示例1
 * 输入：
 * 4 10
 * 1 1
 * 2 1
 * 3 1
 * 4 -2
 * 输出：
 * 12
 * 示例2
 * 输入：
 * 2 4
 * 0 1
 * 2 -2
 * 输出：
 * 4
 */
public class D34 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int e = sc.nextInt() + 1;
        int[][] a = new int[n][2];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 2; j++) {
                a[i][j] = sc.nextInt();
            }
        }

        int preX = 0;
        int preY = 0;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            int x = a[i][0];
            int y = a[i][1];
            if (y != preY && x != preX) {
                sum = (x - preX) * Math.abs(preY);
                preX = x;
            }
            preY = y + preY;
        }
        sum += (e - 1 - preX) * Math.abs(preY);
        System.out.println(sum);
    }
    
}
