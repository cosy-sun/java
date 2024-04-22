package com.cosy.sun.algorithm.leetcode;

import java.util.HashMap;
import java.util.Map;

public class LC136 {

    public static void main(String[] args) {
        int[] ints = {4,1,2,1,2};
        int i = singleNumber(ints);
        System.out.println(i);
    }

    public static int singleNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if(map.containsKey(num)) {
                map.put(num, (map.get(num) + 1));
            } else {
                map.put(num, 1);
            }
        }
        int a = 0;
        for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if(entry.getValue() == 1) {
                a = entry.getKey();
            }
        }
        return a;
    }
}