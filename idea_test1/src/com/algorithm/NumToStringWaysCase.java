package com.algorithm;
/*
 *  @author changqi
 *  @date 2022/1/4 19:31
 *  @description
 *  @Version V1.0
 */

public class NumToStringWaysCase {
    public static void main(String[] args) {

        String str = "12210";

        int n =str.length();

        int[] post = new int[n+1];
        post[n] = 1;
        //post[n-1] = (str.charAt(n-1)-'a'>0 && str.charAt(n-1)-'a'< 10)?1:0;

        for(int i=n-1;i>=0;i--) {
            int num = str.charAt(i)-'0';
            if(num>0 && num<10){
                post[i] = post[i+1];
                if(i+1<n){
                    num *= 10;
                    num +=str.charAt(i+1)-'0';
                    if(num<26 ){
                        post[i]+=post[i+2];
                    }
                }
            }

            System.out.println(post[i]);





        }

        //System.out.println(post[0]);

    }

    public int process(int num){
        if (num < 1) {
            return 0;
        }
        char[] str = String.valueOf(num).toCharArray();

        int N = str.length;
        int[] dp = new int[N + 1];
        dp[N] = 1;
        dp[N - 1] = str[N - 1] == '0' ? 0 : 1;
        for (int i = N - 2; i >= 0; i--) {
            if (str[i] == '0') {
                dp[i] = 0;
            } else {
                dp[i] = dp[i + 1]
                        + (((str[i] - '0') * 10 + str[i + 1] - '0') < 27 ? dp[i + 2]: 0);
            }
        }
        return dp[0];
    }
}
