package com.algorithm;
/*
 *  @author changqi
 *  @date 2021/12/15 21:53
 *  @description
 *  @Version V1.0
 */

import java.util.Arrays;

public class CoinChangeCase {
    public static void main(String[] args) {

        int[] coins = {1,2,5};
        int amount = 11;
        coinChange(coins,amount);

    }

    public static int coinChange(int[] coins, int amount) {
        if(amount==0){
            return 0;
        }

        int[] dp = new int[amount+1];
        Arrays.fill(dp,amount);

        for(int i=1;i<=amount;i++){
            for(int coin:coins) {
                if(i-coin>=0){
                    dp[i] = Math.min(dp[i-coin]+1,dp[i]);
                }
            }
        }


        return dp[amount];
    }
}
