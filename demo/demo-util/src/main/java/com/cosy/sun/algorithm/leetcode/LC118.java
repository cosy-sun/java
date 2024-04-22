package com.cosy.sun.algorithm.leetcode;

import com.alibaba.fastjson.JSON;

import java.util.LinkedList;
import java.util.List;

public class LC118 {

    public static void main(String[] args) {
        LC118 lc118 = new LC118();
        List<List<Integer>> generate = lc118.generate(5);
        System.out.println(JSON.toJSONString(generate));
    }

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new LinkedList<>();


        for (int i = 0; i < numRows; i++) {
            List<Integer> item = new LinkedList<>();
            for (int j = 0; j <= i; j++) {
                if(j == 0 || j == i) {
                    item.add(1);
                } else {
                    List<Integer> integers = ans.get(i - 1);
                    Integer i1 = integers.get(j);
                    Integer i2 = integers.get(j - 1);
                    item.add(i1 + i2);
                }
            }
            ans. add(item);

        }

        return ans;
    }

}
