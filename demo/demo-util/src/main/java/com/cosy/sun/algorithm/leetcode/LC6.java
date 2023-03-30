package com.cosy.sun.algorithm.leetcode;

import static java.lang.System.*;

/**
 * 给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。
 *
 * 如果反转后整数超过 32 位的有符号整数的范围 [−2^31,  2^31 − 1] ，就返回 0。
 *
 * 输入：x = 123
 * 输出：321
 */
public class LC6 {
	
	public static void main(String[] args) {
		LC6 LC6 = new LC6();
		int revert = LC6.revert(-19999);
		out.println(revert);
	}
	
	public int revert(int i) {
		long min = -(2L << 30);
		long max = (2L << 30) - 1;
		boolean bool = false;
		if(i > 0) {
			bool = true;
		}
		int tmp = i;
		StringBuilder builder = new StringBuilder(bool ? "": "-");
		while (tmp > min && tmp < max && tmp != 0) {
			int x = tmp / 10;
			int y = tmp % 10; // 余数
			builder.append(Math.abs(y));
			tmp = x;
		}
		Long valueOf = Long.valueOf(builder.toString());
		if(valueOf > max || valueOf < min) {
			return 0;
		}
		return Integer.valueOf(builder.toString());
	}
	
}
