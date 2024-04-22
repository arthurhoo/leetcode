package com.arthur.codes.leetcode.solutiions.dynamicprogram;

import java.util.Arrays;

/**
 * @author: huhao
 * @create: 2024/4/20
 */
public class LestCoinSolution_322 {
    public int coinChange(int[] coins, int amount) {
        if(null == coins || coins.length <1 || coins.length>12 ||amount < 0 || amount>(int)Math.pow(10,4)){
            throw new IllegalArgumentException("参数错误，请检查");
        }
        int[] dp = new int[amount+1];
        Arrays.sort(coins);
        dp[0] =0;
        for(int i=1; i<dp.length;i++){
            int min = amount+1;
            for(int j = coins.length-1;j>=0;j--){
                if(i < coins[j]){
                    continue;
                }
                min = Math.min(min,dp[i-coins[j]]+1);

            }
            dp[i] = min;
        }
        return (dp[amount]>amount)? -1:dp[amount];
    }
    public static void main(String[] args) {
        int[] coins = {1,2,5};
        int amount = 11;
        LestCoinSolution_322 lestCoinSolution322 = new LestCoinSolution_322();
        int result = lestCoinSolution322.coinChange(coins,amount);
        System.out.println(result);
        coins = new int[]{2};
        result = lestCoinSolution322.coinChange(coins,3);
        System.out.println(result);
    }
}
