package com.cosy.sun.jdk.structure.dymaicprograming;

/**
 *
 *	动态规划, 
 *	最长公共子序列
 * @author cosy-sun
 *
 */
public class LongestCommonSubsequene {

	/**
	 * 最长公共子序列
	 */
	public int[][] findLcs(String a, String b) {
		int aLength = a.length();
		int bLength = b.length();
		
		char[] achar = a.toCharArray();
		char[] bchar = b.toCharArray();
		
		int[][] lcs = new int[aLength][bLength];
		
		int flag = 0;
		//第一行
		for(int i = 0; i < bLength; i ++) {
			if(achar[0] == bchar[i]) {
				flag = 1;
			}
			lcs[0][i] = flag;
		}
		flag = 0;
		//第一列
		for(int i = 0; i < aLength; i ++) {
			if(bchar[0] == achar[i]) {
				flag = 1;
			}
			lcs[i][0] = flag;
		}
		
		//1,1 坐标开始遍历
		for(int i = 1; i < aLength; i ++) {
			for(int j = 1; j < bLength; j ++) {
				
				if(achar[i] == bchar[j]) {
					lcs[i][j] = lcs[i-1][j-1] + 1;
				} else {
					lcs[i][j] = Math.max(lcs[i - 1][j], lcs[i][j-1]);
				}
			}
		}
		displayArr(lcs, aLength, bLength);
		System.out.println(lcs[aLength - 1][bLength - 1]);
		return lcs;
	}
	
	/**
	 * 最长公共连续子序列
	 * @param a
	 * 		输入字符床,之后可以更改为其他类型的
	 * @param b
	 * @return 
	 */
	public int[][] findContinueLcs(String a, String b) {
		int len1 = a.length();
		int len2 = b.length();
		
		int dp[][] = new int[len1 + 1][len2 +1];
		for(int i =0; i < dp.length; i ++) {
			dp[i][0] = 0;
		}
		for(int i =0; i < dp[0].length; i ++) {
			dp[0][i] = 0;
		}
		int max = 0;
		int aind = 0;
		int bind = 0;
		for(int i = 1; i < dp.length; i ++) {
			for(int j =1; j < dp[0].length; j ++) {
				if(a.charAt(i - 1) == b.charAt(j - 1)) {
					if(i == 0 || j == 0) {
						dp[i][j] = 1;
					} else { 
						dp[i][j] = dp[i-1][j-1] + 1;
					} 
				} else {
					dp[i][j] = 0;
				}
				if(max < dp[i][j]) {
					max = dp[i][j];
					aind = i;
					bind = j;
				}
			}
		}
		displayArr(dp, len1 + 1, len2 + 1);
		
		System.out.println(max);
		System.out.println(a.substring(aind - max, aind));
		System.out.println(b.substring(bind - max, bind));
		
		return dp;
	}
	
	/**
	 * 回溯
	 */
	public void backtracking(String a, String b, int[][] c) {
		int alen = a.length();
		int blen = b.length();
		StringBuilder builder = new StringBuilder();
		while(alen > 0 && blen > 0) {
			if(a.charAt(alen - 1) == b.charAt(blen - 1)) {
				builder.append(a.charAt(alen - 1));
				alen --; blen --;
			} else if (c[alen - 1][blen- 2] > c[alen -2][blen - 1]) {
				blen --;
			} else if (c[alen - 1][blen-2] < c[alen -2][blen - 1]) {
				alen --;
			} else if (c[alen - 1][blen-2] == c[alen -2][blen - 1]) {
				alen --;
			}
		}
		System.out.println(builder.reverse().toString());
	}
	
	/**
	 * 显示中间的二位数组
	 * @param arr
	 * @param row
	 * @param col
	 */
	public void displayArr(int[][] arr, int row, int col) {
		for(int i = 0; i < row; i ++) {
			for(int j = 0; j < col; j ++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}
}
