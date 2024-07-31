package com.cosy.sun.algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

// 2961. 双模幂运算
public class LC2961 {
    public static void main(String[] args) {
//        int[][] arr = {{2,3,3,10},{3,3,3,1},{6,1,1,4}};
        int[][] arr = {{31,12,21,24}};
        List<Integer> goodIndices = getGoodIndices(arr, 1);
        System.out.println(goodIndices);
    }

    public static List<Integer> getGoodIndices(int[][] variables, int target) {
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < variables.length; i++) {
            int[] v = variables[i];
            if (powMod(powMod(v[0], v[1], 10), v[2], v[3]) == target) {
                ans.add(i);
            }
        }
        return ans;
    }

    public static int powMod(int x, int y, int mod) {
        int res = 1;
        while (y != 0) {
            if ((y & 1) != 0) {
                res = res * x % mod;
            }
            x = x * x % mod;
            y >>= 1;
        }
        return res;
    }

}
