package com.cosy.sun.algorithm.cuacua;

import java.util.Scanner;

/**
 * 在一棵树中，每个节点代表一个家庭成员，节点的数字表示其个人的财富值，一个节点及其直接相连的子节点被定义为一个小家庭。
 *
 * 现给你一棵树，请计算出最富裕的小家庭的财富和。
 *
 * 输入描述：第一行为一个数N，表示成员总数，成员编号1-N，1<=N<=1000
 *
 * 第二行为N个空格分隔的数，表示编号1-N的成员的财富值。0<=财富值<=1000000
 *
 * 接下来N-1行，每行两个空格分隔的整数(N1,N2)，表示N1是N2的父节点。
 *
 * 输出描述：
 *
 * 最富裕的小家庭的财富和
 *
 * 补充说明：
 *
 *  收起
 *
 * 示例1
 *
 * 输入：
 *
 * 4
 * 100 200 300 500
 * 1 2
 * 1 3
 * 2 4
 * 输出：
 *
 * 700
 * 说明：
 *
 * 成员1,2,3组成的小家庭财富值为600
 *
 * 成员2,4组成的小家庭财富值为700
 *
 * 示例2
 *
 * 输入：
 *
 * 4
 * 100 200 300 500
 * 1 2
 * 1 3
 * 1 4
 * 输出：
 *
 * 1100
 * 说明：
 *
 * 成员1,2,3,4组成的小家庭财富值为1100
 */
public class D10 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int totalSize = scanner.nextInt();
        int[] self = new int[totalSize];
        for (int i = 0; i < totalSize; i++) {
            int decimal = scanner.nextInt();
            self[i] = decimal;
        }

        int max = 0;
        for (int i = 1; i < totalSize; i++) {
            int i1 = scanner.nextInt();
            int i2 = scanner.nextInt();
            int i3 = self[i1 - 1];
            int i4 = self[i2 - 1];
            max = Math.max(max, i3 + i4);
        }
        System.out.println(max);


    }

}
