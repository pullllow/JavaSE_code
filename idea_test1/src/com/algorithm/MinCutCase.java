package com.algorithm;
/*
 *  @author changqi
 *  @date 2021/11/18 10:40
 *  @description 132. 分割回文串 II
 *  @Version V1.0
 */

import java.util.Arrays;

public class MinCutCase {

    public static void main(String[] args) {
        String s = "aab";
        System.out.println(minCut(s));

    }

    public static int minCut(String s) {
        int n = s.length();
        if(n==1){
            return 0;
        }
        boolean[][] dp = new boolean[n+1][n+1];

        for(int i=1;i<=n;i++){
            dp[i][i] = true;
        }
        for(int l=2;l<=n;l++){
            for(int i=1;i<=n;i++){
                int j = i+l-1;
                if(j<=n){
                    dp[i][j] = (s.charAt(i-1)==s.charAt(j-1));
                    if(l>2){
                        dp[i][j] = dp[i][j] && dp[i+1][j-1];
                    }
                }

            }
        }

        int[] count = new int[n+1];
        Arrays.fill(count, Integer.MAX_VALUE);
        for(int i=1;i<=n;i++){
            if(!dp[1][i]){
                for(int j=1;j<i;j++){
                    if(dp[j+1][i]){
                        count[i] = Math.min(count[i],count[j]+1);
                    }
                }
            } else {
                count[i] = 0;
            }
        }
        return count[n];





    }
}
