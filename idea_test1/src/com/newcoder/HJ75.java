package com.newcoder;
/*
 *  @author changqi
 *  @date 2022/3/26 11:16
 *  @description
 *  @Version V1.0
 */

/*描述
给定两个只包含小写字母的字符串，计算两个字符串的最大公共子串的长度。

注：子串的定义指一个字符串删掉其部分前缀和后缀（也可以不删）后形成的字符串。
数据范围：字符串长度：1\le s\le 150\1≤s≤150
进阶：时间复杂度：O(n^3) ，空间复杂度：O(n)
输入描述：
输入两个只包含小写字母的字符串

输出描述：
输出一个整数，代表最大公共子串的长度*/

import java.util.Scanner;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;

public class HJ75  {
    public static void main(String[] args) {
        //System.gc()
        Scanner sc = new Scanner(System.in);

        String s1 = sc.nextLine();
        String s2 = sc.nextLine();

        int m = s1.length();
        int n = s2.length();

        //dp[i][j] s1.substring(0,i) 和s2.substring(0,j) 的最大公共子串
        int[][] dp = new int[m+1][n+1];
        int res = 0;
        for(int i=1;i<=m;i++) {
            for(int j=1;j<=n;j++) {
                if(s1.charAt(i-1)==s2.charAt(j-1)) {
                  dp[i][j] = dp[i-1][j-1]+1;
                }
                res = Math.max(res,dp[i][j]);
            }
        }
        System.out.println(res);
    }
}
