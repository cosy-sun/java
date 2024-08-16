package com.cosy.sun.algorithm.leetcode;

public class LC3129 {

    private static final int MOD = 1000000007;

    public static int numberOfStableArrays(int zero, int one, int limit) {
        int[][][] dp = new int[zero][one][2];
        // 预处理i=0,k=0的部分状态
        for(int i = 0; i <= Math.min(limit, zero); i++){
            dp[i][0][0] = 1;
        }
        // 预处理j=0,k=1的部分状态
        for(int j = 0; j <= Math.min(limit, one); j++){
            dp[0][j][1] = 1;
        }

        for(int i = 1; i <= zero; i++){
            for(int j = 1; j <= one; j++){
                // 更新k=0的状态
                dp[i][j][0] = dp[i-1][j][1] + dp[i-1][j][0];
                if(i > limit){
                    dp[i][j][0] -= dp[i-limit-1][j][1];
                }
                dp[i][j][0] = (dp[i][j][0] % MOD + MOD) % MOD;  // 正确的取模更新状态值
                // 更新k=1的状态
                dp[i][j][1] = dp[i][j-1][0] + dp[i][j-1][1];
                if(j > limit){
                    dp[i][j][1] -= dp[i][j-limit-1][0];
                }
                dp[i][j][1] = (dp[i][j][1] % MOD + MOD) % MOD;  // 正确的取模更新状态值
            }
        }
        return (int) ((dp[zero][one][0] + dp[zero][one][1]) % MOD);

    }

}
