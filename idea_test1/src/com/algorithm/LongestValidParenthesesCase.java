package com.algorithm;
/*
 *  @author changqi
 *  @date 2021/11/15 21:30
 *  @description
 *  @Version V1.0
 */

public class LongestValidParenthesesCase {
    public static void main(String[] args) {
        String s =")()())()()(";
        System.out.println(longestValidParentheses(s));

    }

    public static int longestValidParentheses(String s) {
        int n = s.length();
        if(n<=1){
            return 0;
        }
        int[] dp = new int[n];
        int max =0;
        for(int i=1;i<n;i++){
            if(s.charAt(i)=='('){
                dp[i]=0;
            }
            if(s.charAt(i)==')'){
                if(s.charAt(i-1)=='('){
                   dp[i] = i>=2?dp[i-2]+2:2;

                } else if(s.charAt(i-1)==')'){
                    dp[i] = dp[i - 1] ;

                    if(i-dp[i-1]-1>=0&&s.charAt(i-dp[i-1]-1)=='('){
                        if(i-dp[i-1]-2>=0){
                            dp[i]+=dp[i-dp[i-1]-2];
                        }
                        dp[i]+=2;
                    }

                }
            }
            max = Math.max(max,dp[i]);
        }
        return max;

    }
}
