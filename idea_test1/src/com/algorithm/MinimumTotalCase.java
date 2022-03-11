package com.algorithm;
/*
 *  @author changqi
 *  @date 2021/11/16 16:56
 *  @description
 *  @Version V1.0
 */

import java.util.ArrayList;
import java.util.List;

public class MinimumTotalCase {

    public static void main(String[] args) {

        List<List<Integer>> triangle = new ArrayList<>();
        List<Integer> l1 =  new ArrayList<Integer>();
        l1.add(-10);
        /*
        List<Integer> l2 =  new ArrayList<Integer>();
        l2.add(3);
        l2.add(4);
        List<Integer> l3 =  new ArrayList<Integer>();
        l3.add(6);
        l3.add(5);
        l3.add(7);
        List<Integer> l4 =  new ArrayList<Integer>();
        l4.add(4);
        l4.add(1);
        l4.add(8);
        l4.add(3);
        triangle.add(l1);
        triangle.add(l2);
        triangle.add(l3);
        triangle.add(l4);*/
        triangle.add(l1);
        System.out.println(minimumTotal(triangle));

    }

    public static int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[] dp = new int[n+1];
        int[] lastDp = new int[n+1];
        dp[1] = triangle.get(0).get(0);
        lastDp[1] = dp[1];
        int min =Integer.MAX_VALUE;
        for(int i=2;i<=n;i++){
            List<Integer> curLevel = triangle.get(i-1);
            for(int j=1;j<=i;j++){
                if(j>1){
                    dp[j] = (j==i? lastDp[j-1]:Math.min(lastDp[j],lastDp[j-1]))+curLevel.get(j-1);
                } else {
                    dp[j] = lastDp[j]+curLevel.get(j-1);
                }
                if(i==n){
                    min = Math.min(min,dp[j]);
                }


            }
            for(int j=1;j<=i;j++){
                lastDp[j] = dp[j];
            }

        }
        if(n==1){
            min = dp[1];
        }
        return min;




    }
}
