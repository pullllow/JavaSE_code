package com.newcoder;
/*
 *  @author changqi
 *  @date 2022/3/28 15:24
 *  @description
 *  @Version V1.0
 */

import java.util.Arrays;
import java.util.Scanner;

public class CD25 {
    public static void main(String[] arg) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] arr = new int [n];

        for(int i=0;i<n;i++) {
            arr[i] = sc.nextInt();
        }

        int[] dp = new int[n];
        int maxLen = 0;
        for(int a : arr) {
            int lo = 0;
            int hi = maxLen;

            while(lo<hi) {
                int mid = lo + (hi-lo)/2;
                if(dp[mid]<a) {
                    lo = mid+1;
                } else {
                    hi = mid;
                }
            }
            dp[lo] = a;
            if(lo==maxLen){
                dp[maxLen++] = a;

            }


        }

        System.out.println(Arrays.toString(dp));
        for(int i=0;i<maxLen;i++) {
            System.out.print(dp[i]);
            System.out.print(' ');
        }


    }
}
