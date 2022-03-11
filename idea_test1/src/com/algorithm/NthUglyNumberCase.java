package com.algorithm;
/*
 *  @author changqi
 *  @date 2021/11/26 17:21
 *  @description
 *  @Version V1.0
 */

import java.util.Comparator;
import java.util.PriorityQueue;

public class NthUglyNumberCase {
    public static void main(String[] args) {
        int n =2;

        System.out.println(nthUglyNumber(n));
    }

    public static int nthUglyNumber(int n) {
        int[] b = {Integer.MAX_VALUE/2,Integer.MAX_VALUE/3,Integer.MAX_VALUE/5};
        int[] dp = new int[n+1];
        dp[1] = 1;
        for(int i=2;i<=n;i++) {
            int min = Integer.MAX_VALUE;
            for(int j=i-1;j>=1;j--){
                if(dp[j]>dp[i-1]/5){
                    min =  dp[j]>b[2]?min:Math.min(min,dp[j]*5);
                    if(dp[j]>dp[i-1]/3) {
                        min =  dp[j]>b[1]?min:Math.min(min,dp[j]*3);
                        if(dp[j]>dp[i-1]/2) {
                            min =  dp[j]>b[0]?min:Math.min(min,dp[j]*2);
                        }
                    }
                } else{
                    break;
                }
            }
            dp[i] = min;
        }

        PriorityQueue<int[]> heap = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return 0;
            }
        });
        return dp[n];





    }

}
