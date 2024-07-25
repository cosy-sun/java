package com.cosy.sun.algorithm.cuacua;

import java.util.Scanner;

/**
 * 橱窗里有一排宝石，不同的宝石对应不同的价格，宝石的价格标记为gems[i],0<=i<n, n = gems.length宝石可同时出售0个或多个，
 * 如果同时出售多个，则要求出售的宝石编号连续；例如客户最大购买宝石个数为m，购买的宝石编号必须为gems[i],
 * gems[i+1]...gems[i+m-1](0<=i<n,m<=n)假设你当前拥有总面值为value的钱，请问最多能购买到多少个宝石,如无法购买宝石，则返回0.
 *
 * 输入描述：第一行输入n，参数类型为int，取值范围：[0,10 ]，表示橱窗中宝石的总数量。
 * 之后n行分别表示从第0个到第n-1个宝石的价格，即gems[0]到gems[n-1]的价格，类型为int，取值范围：(0,1000]。
 * 之后一行输入v，类型为int，取值范围：[0,10 ]表示你拥有的钱。
 * 输出描述：输出int类型的返回值，表示最大可购买的宝石数量。
 * 示例 
 * 示例1
 * 输入：7
 *           8
 *           4
 *           6
 *           3
 *           1
 *           6
 *           7
 *          10
 * 输出：3
 * 说明：
 *         gems = [8,4,6,3,1,6,7], value = 10
 *        最多购买的宝石为gems[2]至gems[4]或者gems[3]至gems[5]
 */
public class D27 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int count = sc.nextInt();
        int[] arr = new int[count];
        for (int i = 0; i < count; i++) {
            arr[i] = sc.nextInt();
        }
        int amt = sc.nextInt();

        int left = 0, right = 0;
        int res = 0;
        int tmp = 0;
        for (; right < count; right++) {
            tmp += arr[right];
            while (tmp > amt) {
                tmp -= arr[left];
                left ++;
            }
            res = Math.max(right - left + 1, res);
        }

        System.out.println(res);


    }

}
