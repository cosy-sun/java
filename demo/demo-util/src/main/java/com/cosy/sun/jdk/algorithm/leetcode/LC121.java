package com.cosy.sun.jdk.algorithm.leetcode;

public class LC121 {

    public static void main(String[] args) {
//        System.out.println(maxProfit(new int[] {7, 1, 5, 3, 6, 4}));
//        System.out.println(maxProfit(new int[] {7, 5, 3, 6, 4}));
        System.out.println(optimizeMaxProfit(new int[] {7, 1, 5, 3, 6, 4}));
        System.out.println(optimizeMaxProfit(new int[] {7, 5, 3, 6, 4}));

    }

    public static int optimizeMaxProfit(int[] prices) {
        if(prices.length < 2) {
            return 0;
        }
        int ans = 0, leftMin = prices[0], start = 1, end = 0;
        while (start < prices.length) {
            leftMin = Math.min(leftMin, prices[end]);
            ans = Math.max(ans, prices[start] - leftMin);
            start ++; end ++;
        }
        return ans;
    }

    public static int maxProfit(int[] prices) {
        if(prices.length < 2) {
            return 0;
        }
        int ans = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                int price = prices[i];
                int price1 = prices[j];
                if(ans < price1 - price) {
                    ans = price1 - price;
                }
            }
        }
        return ans;
    }

}
