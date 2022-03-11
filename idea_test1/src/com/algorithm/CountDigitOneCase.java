package com.algorithm;
/*
 *  @author changqi
 *  @date 2021/11/18 16:49
 *  @description 233. 数字 1 的个数
 *  @Version V1.0
 */

public class CountDigitOneCase {
    public static void main(String[] args) {
        int N = 100;
        for(int i=100;i<=N;i++){
            System.out.println(i+" :"+countDigitOne(i));
        }



    }

    public static int countDigitOne(int n) {

        if(n<=1){
            return n;
        }
        int digit = 0;
        int res = n;

        while(res!=0){
            res = res/(int)Math.pow(10,++digit);
        }
        int[] dp = new int[digit];
        res = n;
        for(int i =0;i<dp.length;i++){
            res = res%(int)Math.pow(10,digit);
            dp[i] = res/(int)Math.pow(10,--digit);

        }
        //dp[dp.length-1] = res;
        int mul = 1;
        res = 0;


        for(int i=1;i<dp.length;i++){
            int ans = mul;
            if(dp[i]==1){
                for(int j=i+1;j< dp.length;j++){
                    ans *= dp[j]+1;
                }
                mul *= dp[i];

            } else if(dp[i]>1){
                for(int j=i+1;j< dp.length;j++){
                    ans *= 10;
                }
                mul *= dp[i];

            } else {

            }


            res += ans;


        }

        return res;

    }


}
