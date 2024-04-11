package com.cosy.sun.jdk.algorithm.leetcode;

import java.util.Deque;
import java.util.LinkedList;

public class LC42 {

    public int trap1(int[] hight) {
        int ans = 0;
        Deque<Integer> stack = new LinkedList<>();
        int n = hight.length;
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && hight[i] > hight[stack.peek()]) {
                int top = stack.pop();
                if(stack.isEmpty()) {
                    break;
                }
                int left = stack.peek();
                int currentWidth = i - left - 1;
                int currentHeight = Math.min(hight[left], hight[i]) - hight[top];
                ans += currentWidth * currentHeight;
            }
            stack.push(i);
        }
        return ans;
    }

    public static int trap(int[] height) {
        int n = height.length;
        if (n == 0) {
            return 0;
        }

        int[] leftMax = new int[n];
        leftMax[0] = height[0];
        for (int i = 1; i < n; ++i) {
            leftMax[i] = Math.max(leftMax[i - 1], height[i]);
        }

        int[] rightMax = new int[n];
        rightMax[n - 1] = height[n - 1];
        for (int i = n - 2; i >= 0; --i) {
            rightMax[i] = Math.max(rightMax[i + 1], height[i]);
        }

        int ans = 0;
        for (int i = 0; i < n; ++i) {
            ans += Math.min(leftMax[i], rightMax[i]) - height[i];
        }
        return ans;
    }

    public static void main(String[] args) {
        int trap = trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1});
        System.out.println(trap);
    }

}
