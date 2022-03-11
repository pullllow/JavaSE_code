package com.leetcode.dp;
/*
 *  @author changqi
 *  @date 2022/2/15 15:10
 *  @description 剑指 Offer 13. 机器人的运动范围
 *  @Version V1.0
 */

public class MovingCountCase {
    public static void main(String[] args) {
        movingCount(14,14,5);
    }

    public static int movingCount(int m, int n, int k) {
        int res = 0;

        boolean[] dp = new boolean[n];

        dp[0] = true;
        res++;
        System.out.println(0+" "+0+" "+dp[0]);
        for(int i=1;i<n;i++){
            if(decide(0,i,k)){
                dp[i]=true;
                res++;
            }
            System.out.println(0+" "+i+" "+dp[i]);
        }

        for(int i=1;i<m;i++){
            dp[0] = (decide(0,i,k))&&dp[0];
            res = dp[0]?res+1:res;
            System.out.println(i+" "+0+" "+dp[0]);
            for(int j=1;j<n;j++){
                dp[j] = (dp[j-1]||dp[j])&&(decide(i,j,k));
                res = dp[j]?res+1:res;
                System.out.println(i+" "+j+" "+dp[j]);
            }
        }

        return res;

    }


    public static boolean decide(int i, int j, int k){
        int sum = 0;
        for(;i>0;i/=10){
            sum += i%10;
        }

        while(j!=0){
            sum+=(j%10);
            j=j/10;
        }

        return sum<=k;
    }
}
