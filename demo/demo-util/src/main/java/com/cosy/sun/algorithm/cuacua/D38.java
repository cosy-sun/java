package com.cosy.sun.algorithm.cuacua;

import java.util.Scanner;

/**
 *小华按照地图去寻宝，地图上被划分成 m 行和 n 列的方格，横纵坐标范围分别是 [0, n−1]和[0, m-1]。在横坐标和纵坐标的数位之和不大于k的方格中存在黄金（每个方格中仅存在一克黄金），但横坐标和纵坐标之和大于k的方格存在危险不可进入。小华从入口(0,0)进入，任何时候只能向左，右，上，下四个方向移动一格。请问小华最多能获得多少克黄金？
 * 输入描述：
 * 坐标取值范围如下：
 * 0<=m<=50
 * 0<=n<=50
 * k的取值范围如下：
 * 0<=k<=100
 * 输入中包含3个字数，分别是m，n，k
 * 输出描述：
 * 最多能获得多少克黄金
 * 补充说明：
 * 示例1
 * 输入：
 * 40 40 18
 * 输出：
 * 1484
 * 说明：
 * 当k为18时，小华能够进入方格（10,10），因为1+0+1+0 = 2。 但是，他不能进入方格（36,38），因为3+6+3+8 = 20
 */
public class D38 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int count = 0;
        if (n == 0 || m == 0) {
            count = 0;
        } else {
            for (int i = 0; i < m; i++) {
                int sum1 = 0;
                String[] splitA = String.valueOf(i).split("");
                for (int l = 0; l < splitA.length; l++) {
                    sum1 += Integer.parseInt(splitA[l]);
                }
                if (sum1 > k) {
                    break;
                }
                for (int j = 0; j < n; j++) {
                    String[] splitB = String.valueOf(j).split("");
                    int sum2 = 0;

                    for (int l = 0; l < splitB.length; l++) {
                        sum2 += Integer.parseInt(splitB[l]);
                    }
                    if (sum2 > k) {
                        break;
                    }
                    if (sum1 + sum2 <= k) {
                        count++;
                    }
                }

            }
        }
        System.out.println(count);
    }

}
