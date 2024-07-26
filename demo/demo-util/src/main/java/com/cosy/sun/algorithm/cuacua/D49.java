package com.cosy.sun.algorithm.cuacua;

/**
 * 给一个正整数列 nums，一个跳数 jump，及幸存数量 left。运算过程为：从索引为0的位置开始向后跳，中间跳过 J 个数字，
 * 命中索引为J+1的数字，该数被敲出，并从该点起跳，以此类推，直到幸存left个数为止。然后返回幸存数之和。
 * 约束：
 * 1）0是第一个起跳点。
 * 2）起跳点和命中点之间间隔 jump 个数字，已被敲出的数字不计入在内。
 * 3）跳到末尾时无缝从头开始（循环查找），并可以多次循环。
 * 4）若起始时 left>len(nums) 则无需跳数处理过程。
 * <p>
 * * nums: 正整数数列，长度范围 [1,10000]
 * * jump: 跳数，范围 [1,10000]
 * * left: 幸存数量，范围 [0,10000]
 * * return: 幸存数之和
 * <p>
 * int sumOfLeft(int[] nums, int jump, int left)
 * 示例1
 * 输入：[1,2,3,4,5,6,7,8,9],4,3
 * 输出：13
 * 说明：从1（索引为0）开始起跳,中间跳过 4个数字,因此依次删除 6,2,8,5,4,7 。剩余 1,3,9,返回和为13
 */
public class D49 {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int jump = 4;
        int left = 3;
        System.out.println(sumOfLeft(nums, jump, left));
    }

    public static int sumOfLeft(int[] nums, int jump, int left) {
        int n = nums.length;
        boolean[] used = new boolean[n];
        int size = n;
        int i = 0;
        int count = 0;
        while (size > left) {
            while (true) {
                i = (i + 1) % n;
                if(!used[i]) {
                    count++;
                }
                if(count == jump + 1) {
                    used[i % n] = true;
                    count = 0;
                    size--;
                    break;
                }
            }
        }
        int sum = 0;
        for (int j = 0; j < used.length; j++) {
            if (!used[j]) {
                sum += nums[j];
            }
        }
        return sum;

    }

}
