package com.cosy.sun.algorithm.cuacua;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 现有两组服务器A和B，每组有多个算力不同的CPU，其中A[i]是A组第i个CPU的运算能力，B[i]是B组第i个CPU的运算能力。一组服务器的总算力是各CPU的算力之和。为了让两组服务器的算力相等，允许从每组各选出一个CPU进行一次交换，求两组服务器中，用于交换的CPU的算力，并且要求从A组服务器中选出的CPU，算力尽可能小。
 *
 * 输入描述：
 *
 * 第一行输入为L1和L2，以空格分隔，L1表示A组服务器中的CPU数量，L2表示B组服务器中的CPU数量。
 *
 * 第二行输入为A组服务器中各个CPU的算力值，以空格分隔。
 *
 * 第三行输入为B组服务器中各个CPU的算力值，以空格分隔。
 *
 * 1 <= L1 <= 10000
 *
 * 1 <= L2 <= 10000
 *
 * 1 <= A[i] <= 100000
 *
 * 1 <= B[i] <= 100000
 *
 * 输出描述：
 *
 * 对于每组测试数据，输出两个整数，以空格分隔，依次表示A组选出的CPU算力、B组选出的CPU算力。
 *
 * 要求从A组选出的CPU的算力尽可能小。
 *
 * 补充说明：
 *
 * 保证两组服务器的初始总算力不同。
 *
 * 答案肯定存在。
 *
 * 作者：大厂终结者
 * 链接：https://www.nowcoder.com/discuss/634508144105771008?fromPut=%3F%3F%3F%3F_pc_%3F%3F%3F%3F_%3F%3F%3F%3F_496107591719584205086
 * 来源：牛客网
 */
public class D8 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int oneCnt = sc.nextInt();
        int twoCnt = sc.nextInt();
        List<Integer> oneList = new ArrayList<Integer>();
        List<Integer> twoList = new ArrayList<>();
        for (int i = 0; i < oneCnt; i++) {
            oneList.add(sc.nextInt());
        }
        for (int i = 0; i < twoCnt; i++) {
            twoList.add(sc.nextInt());
        }
//        oneList.sort(Comparator.comparingInt(a -> a));
//        twoList.sort(Comparator.comparingInt(a -> a));
        Integer oneSum = oneList.stream().reduce(0, Integer::sum);
        Integer twoSum = twoList.stream().reduce(0, Integer::sum);
        for (int i = 0; i < oneCnt; i++) {
            Integer one = oneList.get(i);
            int tar = (twoSum - oneSum + 2 * one) / 2;
            if (twoList.contains(tar)) {
                System.out.println(one + " " + tar);
                break;
            }
        }

    }

}
