package com.cosy.sun.algorithm.cuacua;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 部门准备举办一场王者荣耀表演赛，有10名游戏爱好者参与，分为两队，每队5人。每位参与者都有一个评分，代表着他的游戏水平。
 * 为了表演赛尽可能精彩，我们需要把10名参赛者分为实力尽量相近的两队。一队的实力可以表示为这一队5名队员的评分总和。
 * 现在给你10名参与者的游戏水平评分，请你根据上述要求分队，最后输出这两组的实力差绝对值。
 * <p>
 * 例：10名参赛者的评分分别为5 1 8 3 4 6 7 10 9 2，分组为（1 3 5 8 10）（2 4  6 7 9），
 * 两组实力差最小，差值为1。有多种分法，但实力差的绝对值最小为1。
 * 输入描述：
 * 10个整数，表示10名参与者的游戏水平评分。范围在[1, 10000]之间
 * 输出描述：
 * 1个整数，表示分组后两组实力差绝对值的最小值。
 * 示例1
 * 输入：
 * 1 2 3 4 5 6 7 8 9 10
 * 输出：
 * 1
 * 说明：
 * 10名队员分成两组，两组实力差绝对值最小为1。
 */
public class D40 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        List<Integer> teamNumber = new ArrayList<>();
        int sum = 0;
        while (in.hasNextInt()) {
            int a = in.nextInt();
            teamNumber.add(a);
            sum += a;
        }


        int result = sum;

        for (int one = 0; one < 10; one++) {
            for (int two = one + 1; two < 10; two++) {
                int add12 = teamNumber.get(one) + teamNumber.get(two);
                for (int three = two + 1; three < 10; three++) {
                    int add23 = teamNumber.get(three) + add12;
                    for (int four = three + 1; four < 10; four++) {
                        int add34 = teamNumber.get(four) + add23;
                        for (int five = four + 1; five < 10; five++) {
                            int add45 = teamNumber.get(five) + add34;
                            result = Math.min(result, Math.abs(sum - add45 * 2));
                        }
                    }
                }
            }
        }
        System.out.println(result);
    }

}
