package com.algorithm;
/*
 *  @author changqi
 *  @date 2021/11/16 11:07
 *  @description 62. 不同路径
 *  @Version V1.0
 */

public class UniquePathsCase {
    public static void main(String[] args) {
        uniquePaths(3,2);

    }
    public static int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        dp[0][0] = 1;

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(i!=0&&j!=0){
                    dp[i][j] = (i>=1?dp[i-1][j]:0)+(j>=1?dp[i][j-1]:0);
                }

            }
        }
        return dp[m-1][n-1];


    }

}
