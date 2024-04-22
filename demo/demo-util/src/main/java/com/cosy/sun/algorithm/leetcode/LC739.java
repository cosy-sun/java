package com.cosy.sun.algorithm.leetcode;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class LC739 {

    public static void main(String[] args) {
        LC739 lc739 = new LC739();
        int[] ints = lc739.dailyTemperatures(new int[]{1, 2, 3, 4, 5, 4, 3, 2, 1});
        System.out.println(Arrays.toString(ints));
    }

    public int[] dailyTemperatures(int[] temperatures) {
        int length = temperatures.length;
        int[] ans = new int[length];
        Deque<Integer> stack = new LinkedList<>();
        for (int i = 0; i < length; i++) {
            int termperature = temperatures[i];
            while(!stack.isEmpty() && termperature > temperatures[stack.peek()]) {
                int pervIndex = stack.pop();
                ans[pervIndex] = i - pervIndex;
            }
            stack.push(i);
        }
        return ans;
    }

}
