package com.cosy.sun.jdk.algorithm.leetcode;

import static java.lang.System.*;

/**
 * 给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。
 *
 * 如果反转后整数超过 32 位的有符号整数的范围 [−2^31,  2^31 − 1] ，就返回 0。
 *
 * 输入：x = 123
 * 输出：321
 */
public class LC7 {
	
	public static void main(String[] args) {
		LC7 LC7 = new LC7();
		int revert = LC7.revert(2147483647);
		out.println(revert);
	}
	
	public int revert(int i) {
		long min = Integer.MIN_VALUE;
		long max = Integer.MAX_VALUE;
		boolean bool = i >= 0;
		int tmp = i;
		StringBuilder builder = new StringBuilder(bool ? "": "-");
		while (tmp > min && tmp < max && tmp != 0) {
			int x = tmp / 10;
			int y = tmp % 10;
			builder.append(Math.abs(y));
			tmp = x;
		}

		String string = builder.toString();
		if(string.equals("") || string.equals("-")) {
			return 0;
		}
		Long valueOf = Long.valueOf(string);
		if(valueOf > max || valueOf < min) {
			return 0;
		}
		return Integer.valueOf(string);
	}
	
}
