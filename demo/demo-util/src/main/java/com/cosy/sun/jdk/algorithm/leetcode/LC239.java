package com.cosy.sun.jdk.algorithm.leetcode;

import java.util.Deque;
import java.util.LinkedList;

public class LC239 {

    public static int[] maxSlidingWindow2(int[] nums, int k) {
        if(nums.length == 0 || k == 0) return new int[0];
        Deque<Integer> deque = new LinkedList<>();
        int[] res = new int[nums.length - k + 1];
        // 未形成窗口
        for(int i = 0; i < k; i++) {
            while(!deque.isEmpty() && deque.peekLast() < nums[i]) {
                deque.removeLast();
            }
            deque.addLast(nums[i]);
        }
        res[0] = deque.peekFirst();
        // 形成窗口后
        for(int i = k; i < nums.length; i++) {
            if(deque.peekFirst() == nums[i - k]) {
                deque.removeFirst();

            }
            while(!deque.isEmpty() && deque.peekLast() < nums[i]) {
                deque.removeLast();
            }
            deque.addLast(nums[i]);
            res[i - k + 1] = deque.peekFirst();
        }
        return res;

    }

    public static int[] maxSlidingWindow(int[] nums, int k) {
        int[] ans = new int[nums.length - k + 1];
        int[] left = new int[nums.length];
        int[] right = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (i % k == 0) {
                left[i] = nums[i];
            } else {
                left[i] = Math.max(left[i - 1], nums[i]);
            }
        }
        for (int i = nums.length - 1; i >= 0; i--) {
            if (i == nums.length - 1 || i % k == 0) {
                right[i] = nums[i];
            } else {
                right[i] = Math.max(right[i + 1], nums[i]);
            }
        }
        for (int i = 0; i <= nums.length - k; i++) {
            ans[i] = Math.max(right[i], left[i + k - 1]);
        }
        return ans;
    }

}
