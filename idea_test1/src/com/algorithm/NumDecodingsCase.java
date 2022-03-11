package com.algorithm;
/*
 *  @author changqi
 *  @date 2021/11/16 15:09
 *  @description
 *  @Version V1.0
 */

public class NumDecodingsCase {
    public static void main(String[] args) {
        System.out.println(numDecodings("0006"));
    }

    public static int numDecodings(String s) {
        int n = s.length();

        int[] dp = new int[n+1];



        dp[0] = 1;
        for(int i=1;i<=n;i++){
            if(s.charAt(i-1)!='0'){
                dp[i] += dp[i-1];

            }
            if(i>=2&&(s.charAt(i-2)-'0')*10+(s.charAt(i-1)-'0')<=26&&(s.charAt(i-2)-'0')!=0&&(s.charAt(i-1)-'0')!=0){
                dp[i] += dp[i-2];

            }
            if(i>=2&&s.charAt(i-1)=='0'&&s.charAt(i-2)-'0'<=2&&s.charAt(i-2)-'0'>0) {
                dp[i] =(i>2)?dp[i-2]:1;
            }


        }
        return dp[n];

    }

}
